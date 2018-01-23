package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PassagemEditarController implements ControllerInterface {

    private long codigo;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo"));
        this.pagina = "editar_passagem.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            PassagemDaoInterface daoP = SessionUtils.getPassagemDao(session, conexao);
            Passagem passgm = daoP.buscar(codigo);
            request.setAttribute("passgm", passgm);
        } catch (Exception ex) {
            this.pagina = "erro.jsp";
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
