package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooNovoAdicionarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;
    @Override
    public void init(HttpServletRequest request) {
        this.session = request.getSession();
        this.pagina = "adicionar_voo.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            List<Localidade> lLocal = daoL.listarTudo();
            List<Aeronave> lAero = daoA.listarTudo();
            request.setAttribute("listaLocal", lLocal);
            request.setAttribute("listaAero", lAero);
        //} catch (Exception ex) {
        //    this.pagina = "erro.jsp";
        //}
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
