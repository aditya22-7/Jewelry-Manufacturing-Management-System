package DataAccessObject.ResultsetMaker;

import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentResultset {

    public static ResultSet createDepartmentdropendResultset() throws SQLException{
        
        Connection con = DBUtil_dbcp.getDataSource().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs_dept = stmt.executeQuery("select * from public.\"Department\";");
        
        return rs_dept;
    }
    
}
