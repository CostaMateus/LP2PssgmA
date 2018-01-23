package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooPassagensController implements ControllerInterface {

    private long codigo;
    private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo"));
        this.pagina = "passagens_voo.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            PassagemDaoInterface daoP = SessionUtils.getPassagemDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            
            Voo v = daoV.buscar(codigo);
            List<Passagem> lista = daoP.buscarPassagens(codigo);
            Localidade ori = daoL.buscar(v.getOrigem().getCodigo());
            Localidade des = daoL.buscar(v.getDestino().getCodigo());
            Aeronave ae = daoA.buscar(v.getAviao().getCodigo());
            
            v.setPassagens(lista);
            v.setOrigem(ori);
            v.setDestino(des);
            v.setAviao(ae);
            
            long poltOcup = lista.size();
            long poltLiv = (ae.getCapacidade() - poltOcup);
            
            DateTimeFormatter formDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            DateTimeFormatter formTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
            
            String data = v.getData().format(formDate);
            String hora = v.getHora().format(formTime);
            
            request.setAttribute("voo", v);
            request.setAttribute("hora", hora);
            request.setAttribute("data", data);
            request.setAttribute("lista_Pssgm", lista);
            request.setAttribute("poltO", poltOcup);
            request.setAttribute("poltL", poltLiv);
        } catch (Exception ex) {
            pagina = "erro.jsp";
        }
    }

    @Override
    public String getReturnPage() {
        return pagina;
    }

    @Override
    public ReturnType getReturnType() {
        return ReturnType.FORWARD;
    }
    
}
