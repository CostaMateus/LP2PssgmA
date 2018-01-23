package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PassagemSalvarController implements ControllerInterface {

    private long codigo;
    private String nome;
    private long polt;
    private long codigoVoo;
    private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo_passgm"));
        this.nome = request.getParameter("nome");
        this.polt = Long.parseLong(request.getParameter("polt"));
        this.codigoVoo = Long.parseLong(request.getParameter("codigo_voo"));
        this.pagina = "FrontControllerServlet?controller=passgmListar";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            PassagemDaoInterface daoP = SessionUtils.getPassagemDao(session, conexao);
            Voo v = new Voo();
            v.setCodigo(codigoVoo);
            Passagem passgm = new Passagem(v, polt, nome, null);
            passgm.setCodigo(codigo);
            daoP.atualizar(passgm);
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
