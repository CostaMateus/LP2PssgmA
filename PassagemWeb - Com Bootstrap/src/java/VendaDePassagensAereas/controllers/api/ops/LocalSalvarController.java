package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Localidade.SiglaUF;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LocalSalvarController implements ControllerInterface {

    private long codigo;
    private String cdd;
    private SiglaUF uf;
    private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo_local"));
        this.cdd = request.getParameter("cidade");
        this.uf = SiglaUF.valueOf(request.getParameter("uf"));
        this.pagina = "FrontControllerServlet?controller=localListar";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            Localidade ldd = new Localidade(cdd, uf);
            ldd.setCodigo(codigo);
            daoL.atualizar(ldd);
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