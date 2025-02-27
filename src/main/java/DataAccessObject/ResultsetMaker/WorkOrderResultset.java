package DataAccessObject.ResultsetMaker;

import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkOrderResultset {
    
    public static ResultSet createWorkOrderdropendResultset() throws SQLException{
        
        Connection con = DBUtil_dbcp.getDataSource().getConnection(); 
        Statement stmt = con.createStatement();
        ResultSet rs_workorder = stmt.executeQuery("select * from public.\"WorkOrder\" order by \"woNo\" desc limit 3;");
        
        return rs_workorder;
    }
    
}
