package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AeroAdicionarController implements ControllerInterface {
    
    private String modelo;
    private long capacidade;
    private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.modelo = request.getParameter("modelo_aero");
        this.capacidade = Long.parseLong(request.getParameter("capacidade_aero"));
        this.pagina = "adicionar_aeronave.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        Aeronave ae = new Aeronave(modelo, capacidade);
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            daoA.inserir(ae);
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
