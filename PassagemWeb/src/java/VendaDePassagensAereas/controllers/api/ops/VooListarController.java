package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooListarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.session = request.getSession();
        this.pagina = "listar_voos.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            List<Voo> lista = daoV.listarTudo();
            for (Voo v : lista) {
                Localidade ori = daoL.buscar(v.getOrigem().getCodigo());
                Localidade des = daoL.buscar(v.getDestino().getCodigo());
                Aeronave ae = daoA.buscar(v.getAviao().getCodigo());
                v.setOrigem(ori);
                v.setDestino(des);
                v.setAviao(ae);
            }
            
            DateTimeFormatter formDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
            DateTimeFormatter formTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
            
            request.setAttribute("lista_voos", lista);
            request.setAttribute("hora", formTime);
            request.setAttribute("data", formDate);
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
