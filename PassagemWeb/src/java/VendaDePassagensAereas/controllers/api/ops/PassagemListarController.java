package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PassagemListarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.session = request.getSession();
        this.pagina = "listar_passagens.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            PassagemDaoInterface daoP = SessionUtils.getPassagemDao(session, conexao);
            List<Passagem> lista = daoP.listarTudo();
            request.setAttribute("lista_passagens", lista);
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
