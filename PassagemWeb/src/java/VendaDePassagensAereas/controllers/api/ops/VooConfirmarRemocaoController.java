package VendaDePassagensAereas.controllers.api.ops;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.dao.api.AeronaveDaoInterface;
import VendaDePassagensAereas.dao.api.LocalidadeDaoInterface;
import VendaDePassagensAereas.dao.api.VooDaoInterface;
import VendaDePassagensAereas.dao.impl.relacional.ConexaoInterface;
import VendaDePassagensAereas.dominio.Aeronave;
import VendaDePassagensAereas.dominio.Localidade;
import VendaDePassagensAereas.dominio.Voo;
import VendaDePassagensAereas.servlets.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VooConfirmarRemocaoController implements ControllerInterface {

    private long codigo;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo"));
        this.pagina = "remover_voo.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            Voo v = daoV.buscar(codigo);
            Localidade ori = daoL.buscar(v.getOrigem().getCodigo());
            Localidade des = daoL.buscar(v.getDestino().getCodigo());
            Aeronave ae = daoA.buscar(v.getAviao().getCodigo());
            v.setOrigem(ori);
            v.setDestino(des);
            v.setAviao(ae);
            request.setAttribute("voo", v);
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
