package FrontendAssist;

import DataAccessObject.IRDetailsdb;
import DataAccessObject.IRdb;
import DataTransferObject.formvalueDTO.Value_IRDetails_fromIRClick;
import Service.SetIn_DTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Irid_AssisstServlet_for_IRDetailsForm extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String irdetails_irid = request.getParameter("ir_id_from_dailyIRdata_TO_Irid_AssisstServlet_for_IRDetailsForm");
            System.out.println("irid obtained on ir row click inside Irid_AssisstServlet_for_IRDetailsForm ===== "+irdetails_irid);

            Value_IRDetails_fromIRClick i_ird_forIRIDsetting = new SetIn_DTO().setIRDetailsParameter_irid(irdetails_irid);
        
//            new IRDetailsdb(i_ird_forIRIDsetting).test();
            
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
