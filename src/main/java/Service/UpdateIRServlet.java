package Service;

import DataAccessObject.UpdateIRDb;
import DataTransferObject.formvalueDTO.Value_IRForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateIRServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            
            String current_irid = req.getParameter("current_irid");
            String iR_dept = req.getParameter("dept_hidden_ID");
            String iR_irto = req.getParameter("irto_hidden_ID");
            String iR_wo = req.getParameter("wo_hidden_ID");
            String iR_status = req.getParameter("status");
            
            System.out.println("IR UPDATE ====== "+current_irid);
            System.out.println("IR UPDATE ====== "+iR_dept);
            System.out.println("IR UPDATE ====== "+iR_irto);
            System.out.println("IR UPDATE ====== "+iR_wo);
            System.out.println("IR UPDATE ====== "+iR_status);
            
            
            Value_IRForm updateIR_valueobject = new SetIn_DTO().setUpdateIRParameters(current_irid, iR_dept,iR_irto,iR_wo,iR_status);
            
            try {
                new UpdateIRDb(updateIR_valueobject).updateIrRow();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

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
