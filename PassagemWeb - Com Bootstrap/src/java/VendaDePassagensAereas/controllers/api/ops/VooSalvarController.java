package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
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

public class VooSalvarController implements ControllerInterface {

    private long codigo;
    private String nomeOri;
    private String nomeDes;
    private LocalDateTime dh;
    private String portao;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo_voo"));
        this.nomeOri = request.getParameter("origem_voo");
        this.nomeDes = request.getParameter("destino_voo");
        this.dh = LocalDateTime.parse(request.getParameter("data_voo") + "T"
                + request.getParameter("hora_voo"));
        this.portao = request.getParameter("portao_voo");
        this.pagina = "FrontControllerServlet?controller=vooListar";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            Localidade ori = daoL.buscarNome("nomeOri");
            Localidade des = daoL.buscarNome("nomeDes");
            Aeronave ae = null;
            Voo v = new Voo(ori, des, ae, portao, dh);
            daoV.atualizar(v);
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
