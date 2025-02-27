package DataAccessObject.ResultsetMaker;

import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountResultset {
    
    public static ResultSet createAccountdropendResultset() throws SQLException{
        
        Connection con = DBUtil_dbcp.getDataSource().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs_account = stmt.executeQuery("select * from public.\"Account\";");
        
        return rs_account;
    }
    
}
