package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocalListarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.pagina = "listar_locais.jsp";
        this.session = request.getSession();
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            List<Localidade> lista = daoL.listarTudo();
            request.setAttribute("lista_local", lista);
        } catch (Exception ex) {
            pagina = "erro,jsp";
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
