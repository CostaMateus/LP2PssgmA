package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.PassagemDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Passagem;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PassagemAdicionarController implements ControllerInterface {

    private String nome;
    private long polt;
    private String cpf;
    private long codVoo;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.nome = request.getParameter("nome");
        this.polt = Long.parseLong(request.getParameter("polt"));
        this.cpf = request.getParameter("cpf");
        this.codVoo = Long.parseLong(request.getParameter("codigo_voo"));
        this.pagina = "FrontControllerServlet?controller=passgmNovaAdicionar";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            PassagemDaoInterface daoP = SessionUtils.getPassagemDao(session, conexao);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            Voo v = daoV.buscar(codVoo);
            Passagem passgm = new Passagem(v, polt, nome, cpf);
            daoP.inserir(passgm);
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

