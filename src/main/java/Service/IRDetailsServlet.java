package Service;

import DataTransferObject.formvalueDTO.Value_IRDetailsForm;
import DataAccessObject.IRDetailsdb;
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

/**
 *
 * @author Megha Mathur
 */
public class IRDetailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            System.out.println("IRDetailsServlet IS CALLED !!!!");
            
            String iRDetailsServlet_irid = req.getParameter("irid_input");
            String iRDetailsServlet_irto = req.getParameter("irto_hidden_ID");
            String iRDetailsServlet_dept = req.getParameter("dept_hidden_ID");
            String iRDetailsServlet_transtype = req.getParameter("transtype");
            float iRDetailsServlet_purity = Float.parseFloat(req.getParameter("purity_input"));
            float iRDetailsServlet_weight = Float.parseFloat(req.getParameter("weight_input"));
            String iRDetailsServlet_desc = req.getParameter("desc_input");
            float iRDetailsServlet_labour = Float.parseFloat(req.getParameter("labour_input"));
            
            
            System.out.println(iRDetailsServlet_irid);
            System.out.println(iRDetailsServlet_irto);
            System.out.println(iRDetailsServlet_dept);
            System.out.println(iRDetailsServlet_transtype);
            System.out.println(iRDetailsServlet_purity);
            System.out.println(iRDetailsServlet_weight);
            System.out.println(iRDetailsServlet_desc);
            System.out.println(iRDetailsServlet_labour);
            
            
            Value_IRDetailsForm i = new SetIn_DTO().setIRDetailsParameters(iRDetailsServlet_irid,iRDetailsServlet_irto,iRDetailsServlet_dept,iRDetailsServlet_transtype, iRDetailsServlet_purity, iRDetailsServlet_weight, iRDetailsServlet_desc, iRDetailsServlet_labour);
            
            try {
                new IRDetailsdb(i).InsertData();
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
            Logger.getLogger(IRDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(IRDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
