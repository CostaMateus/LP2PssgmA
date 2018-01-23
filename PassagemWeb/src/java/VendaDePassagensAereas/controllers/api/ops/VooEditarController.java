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

public class VooEditarController implements ControllerInterface {

    private long codigo;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        this.codigo = Long.parseLong(request.getParameter("codigo"));
        this.pagina = "editar_voo.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        //try {
            HttpSession session = request.getSession();
            ConexaoInterface conexao = SessionUtils.getConexao(session);
            VooDaoInterface daoV = SessionUtils.getVooDao(session, conexao);
            Voo v = daoV.buscar(codigo);

            LocalidadeDaoInterface daoL = SessionUtils.getLocalidadeDao(session, conexao);
            AeronaveDaoInterface daoA = SessionUtils.getAeronaveDao(session, conexao);
            long codO = v.getOrigem().getCodigo();
            Localidade ori = daoL.buscar(codO);
            v.setOrigem(ori);
            long codD = v.getDestino().getCodigo();
            Localidade des = daoL.buscar(codD);
            v.setDestino(des);
            long codA = v.getAviao().getCodigo();
            Aeronave ae = daoA.buscar(codA);
            v.setAviao(ae);
            request.setAttribute("voo", v);
        //} catch (Exception ex) {
        //    pagina = "erro.jsp";
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
