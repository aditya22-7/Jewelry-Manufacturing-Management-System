package FrontendAssist.AssistJobsTable;
import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BringIRto_and_Dept {
    
    public String getIRtoforJobsTable(String iRTableirToId) throws SQLException{
        
        String name = "";
        try (Connection con = DBUtil_dbcp.getDataSource().getConnection()) {
            String rs_accQuery = String.format("Select * from public.\"Account\" where id = '%s'",iRTableirToId);
            Statement st = con.createStatement();
            ResultSet rs_acc = st.executeQuery(rs_accQuery);
            while(rs_acc.next()){
                name = rs_acc.getString("displayName");
            }
        }
        
        return name;
    }
    public String getDeptforJobsTable(String iRTabledeptId) throws SQLException{

        String name = "";
        try (Connection con = DBUtil_dbcp.getDataSource().getConnection()) {
            String rs_woQuery = String.format("Select * from public.\"Department\" where id = '%s'",iRTabledeptId);
            Statement st = con.createStatement();
            ResultSet rs_dept = st.executeQuery(rs_woQuery);
            while(rs_dept.next()){
                name = rs_dept.getString("deptName");
            }
        }
        return name;
    }
    
}
