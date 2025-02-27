package Service;

import DataTransferObject.formvalueDTO.Value_IRForm;
import DataAccessObject.IRdb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IRServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            String iR_transdate = req.getParameter("transdate");
            String iR_dept = req.getParameter("dept_hidden_ID");
            String iR_irto = req.getParameter("irto_hidden_ID");
            String iR_wo = req.getParameter("wo_hidden_ID");
            String iR_status = req.getParameter("status");
            
            System.out.println(iR_transdate);
            System.out.println(iR_dept);
            System.out.println(iR_irto);
            System.out.println(iR_wo);
            System.out.println(iR_status);
            
            
            Value_IRForm i = new SetIn_DTO().setIRParameters(iR_transdate, iR_dept,iR_irto,iR_wo,iR_status);
            
            try {
                new IRdb(i).InsertData();
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(IRServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(IRServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
