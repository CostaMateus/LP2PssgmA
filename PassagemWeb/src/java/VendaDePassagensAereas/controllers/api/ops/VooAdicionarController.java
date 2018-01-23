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
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooAdicionarController implements ControllerInterface {

    private long idOri;
    private long idDes;
    private long idAero;
    private LocalDateTime dh;
    private String portao;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.idOri = Long.parseLong(request.getParameter("origem_voo"));
        this.idDes = Long.parseLong(request.getParameter("destino_voo"));
        this.idAero = Long.parseLong(request.getParameter("aero_voo"));
        this.dh = LocalDateTime.parse(request.getParameter("data_voo")+"T"+
                                      request.getParameter("hora_voo"));
        this.portao = request.getParameter("portao_voo");
        this.pagina = "FrontControllerServlet?controller=vooNovoAdicionar";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            Localidade ori = daoL.buscar(idOri);
            Localidade des = daoL.buscar(idDes);
            Aeronave ae = daoA.buscar(idAero);
            Voo v = new Voo(ori, des, ae, portao, dh);
            daoV.inserir(v);
        //} catch (Exception ex) {
        //    this.pagina = "erro.jsp";
        //}
    }

    @Override
    public String getReturnPage() {
        return pagina;
    }

    @Override
    public ReturnType getReturnType() {
        return ReturnType.REDIRECT;
    }

}
