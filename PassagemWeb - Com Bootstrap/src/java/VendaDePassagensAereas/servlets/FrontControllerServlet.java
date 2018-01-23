package VendaDePassagensAereas.servlets;

import VendaDePassagensAereas.controllers.api.ControllerInterface;
import VendaDePassagensAereas.controllers.api.ControllerInterface.ReturnType;
import VendaDePassagensAereas.controllers.api.ops.AeroAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.AeroConfirmarRemocaoController;
import VendaDePassagensAereas.controllers.api.ops.AeroEditarController;
import VendaDePassagensAereas.controllers.api.ops.AeroListarController;
import VendaDePassagensAereas.controllers.api.ops.AeroRemoverController;
import VendaDePassagensAereas.controllers.api.ops.AeroSalvarController;
import VendaDePassagensAereas.controllers.api.ops.LocalAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.LocalConfirmarRemocaoController;
import VendaDePassagensAereas.controllers.api.ops.LocalEditarController;
import VendaDePassagensAereas.controllers.api.ops.LocalListarController;
import VendaDePassagensAereas.controllers.api.ops.LocalRemoverController;
import VendaDePassagensAereas.controllers.api.ops.LocalSalvarController;
import VendaDePassagensAereas.controllers.api.ops.PassagemAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.PassagemConfirmarRemocaoController;
import VendaDePassagensAereas.controllers.api.ops.PassagemEditarController;
import VendaDePassagensAereas.controllers.api.ops.PassagemListarController;
import VendaDePassagensAereas.controllers.api.ops.PassagemNovaAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.PassagemRemoverController;
import VendaDePassagensAereas.controllers.api.ops.PassagemSalvarController;
import VendaDePassagensAereas.controllers.api.ops.VooAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.VooConfirmarRemocaoController;
import VendaDePassagensAereas.controllers.api.ops.VooEditarController;
import VendaDePassagensAereas.controllers.api.ops.VooListarController;
import VendaDePassagensAereas.controllers.api.ops.VooNovoAdicionarController;
import VendaDePassagensAereas.controllers.api.ops.VooPassagensController;
import VendaDePassagensAereas.controllers.api.ops.VooRemoverController;
import VendaDePassagensAereas.controllers.api.ops.VooSalvarController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ControllerInterface controller = null;

        // obter instância do controlador
        String nomeC = request.getParameter("controller");
        switch (nomeC) {
            // aeronaves
            case "aeroListar":
                controller = new AeroListarController();
                break;
            case "aeroAdicionar":
                controller = new AeroAdicionarController();
                break;
            case "aeroSalvar":
                controller = new AeroSalvarController();
                break;
            case "aeroRemover":
                controller = new AeroRemoverController();
                break;
            case "aeroConfirmar_remocao":
                controller = new AeroConfirmarRemocaoController();
                break;
            case "aeroEditar":
                controller = new AeroEditarController();
                break;

            // voos
            case "vooListar":
                controller = new VooListarController();
                break;
            case "vooAdicionar":
                controller = new VooAdicionarController();
                break;
            case "vooSalvar":
                controller = new VooSalvarController();
                break;
            case "vooRemover":
                controller = new VooRemoverController();
                break;
            case "vooConfirmar_remocao":
                controller = new VooConfirmarRemocaoController();
                break;
            case "vooEditar":
                controller = new VooEditarController();
                break;
            case "vooNovoAdicionar":
                controller = new VooNovoAdicionarController();
                break;
            case "vooPassagens":
                controller = new VooPassagensController();
                break;

            // locais
            case "localListar":
                controller = new LocalListarController();
                break;
            case "localAdicionar":
                controller = new LocalAdicionarController();
                break;
            case "localRemover":
                controller = new LocalRemoverController();
                break;
            case "localConfirmar_remocao":
                controller = new LocalConfirmarRemocaoController();
                break;
            case "localEditar":
                controller = new LocalEditarController();
                break;
            case "localSalvar":
                controller = new LocalSalvarController();
                break;
                
            // passagens
            case "passgmListar":
                controller = new PassagemListarController();
                break;
            case "passgmAdicionar":
                controller = new PassagemAdicionarController();
                break;
            case "passgmNovaAdicionar":
                controller = new PassagemNovaAdicionarController();
                break;
            case "passgmSalvar":
                controller = new PassagemSalvarController();
                break;
            case "passgmRemover":
                controller = new PassagemRemoverController();
                break;
            case "passgmConfirmar_remocao":
                controller = new PassagemConfirmarRemocaoController();
                break;
            case "passgmEditar":
                controller = new PassagemEditarController();
                break;
        }

        // inicialização
        controller.init(request);

        // execução da manipulação de dados
        controller.execute();

        // encaminhamento para próxima página
        if (controller.getReturnType() == ReturnType.FORWARD) {
            RequestDispatcher rd = request.getRequestDispatcher(controller.getReturnPage());
            rd.forward(request, response);
        } else if (controller.getReturnType() == ReturnType.REDIRECT) {
            response.sendRedirect(controller.getReturnPage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
