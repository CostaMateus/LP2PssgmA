package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AeroListarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.session = request.getSession();
        this.pagina = "listar_aeronaves.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            AeronaveDaoInterface dao = SessionUtils.getAeronaveDao(session, conexao);
            List<Aeronave> lista = dao.listarTudo();
            request.setAttribute("lista_aeronaves", lista);
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
