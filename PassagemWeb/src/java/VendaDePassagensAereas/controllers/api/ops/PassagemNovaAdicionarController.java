package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PassagemNovaAdicionarController implements ControllerInterface {

    private String pagina;
    private HttpSession session;
    private HttpServletRequest request;
    @Override
    public void init(HttpServletRequest request) {
        this.session = request.getSession();
        this.pagina = "adicionar_passagem.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            List<Voo> lista = daoV.listarTudo();
            for (Voo v : lista) {
                Localidade ori = daoL.buscar(v.getOrigem().getCodigo());
                Localidade des = daoL.buscar(v.getDestino().getCodigo());
                v.setOrigem(ori);
                v.setDestino(des);
            }
            request.setAttribute("listaVoos", lista);
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