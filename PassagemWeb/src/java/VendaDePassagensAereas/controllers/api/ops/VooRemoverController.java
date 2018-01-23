package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooRemoverController implements ControllerInterface {

    private long codigo;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo_voo"));
        this.pagina = "FrontControllerServlet?controller=vooListar";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            Voo v = daoV.buscar(codigo);
            daoV.apagar(v);
        //} catch (Exception ex) {
        //    pagina = "erro.jsp";
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
