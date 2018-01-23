package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AeroSalvarController implements ControllerInterface {

    private long codigo;
    private String modelo;
    private long capacidade;
    private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo_aero"));
        this.modelo = request.getParameter("modelo_aero");
        this.capacidade = Long.parseLong(request.getParameter("capacidade_aero"));
        this.pagina = "FrontControllerServlet?controller=aeroListar";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            AeronaveDaoInterface dao = SessionUtils.getAeronaveDao(session, conexao);
            Aeronave ae = new Aeronave(modelo, capacidade);
            ae.setCodigo(codigo);
            dao.atualizar(ae);
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
        return ReturnType.REDIRECT;
    }
    
}
