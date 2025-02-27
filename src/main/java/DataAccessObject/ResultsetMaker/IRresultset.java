package DataAccessObject.ResultsetMaker;

import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IRresultset {
    
    public static ResultSet createIRuitableResultset(String woid) throws SQLException{
        
        String queryString = String.format("select * from public.\"IR\" where \"woID\" = '%s'",woid);
        Connection con = DBUtil_dbcp.getDataSource().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs_workorder = stmt.executeQuery(queryString);
        
        return rs_workorder;
    }
    
}
