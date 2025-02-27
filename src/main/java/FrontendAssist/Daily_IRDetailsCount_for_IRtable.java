package FrontendAssist;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daily_IRDetailsCount_for_IRtable{
    ResultSet rs_IR;

    public ResultSet getRs_IR() {
        return rs_IR;
    }

    public void setRs_IR(ResultSet rs_IR) {
        this.rs_IR = rs_IR;
    }
    
    Connection con;
    
    public Daily_IRDetailsCount_for_IRtable(){}

    
    public Daily_IRDetailsCount_for_IRtable(Connection con){
        this.con = con;
    }
    public Connection getCon() {
        return con;
    }
    
    public void settingResultSet()throws SQLException{
        
    }
    public int getIssueReceiptsCount(String irid)throws SQLException{
        int count = 0;
        String queryString = String.format("Select count(*) as ird_rowcount from public.\"ID_Trans\" where \"irID\" = '%s'",irid);
        Statement st = getCon().createStatement();
        rs_IR = st.executeQuery(queryString);
        setRs_IR(rs_IR);
        System.out.println("irid in Daily_IRDetailsCount_for_IRtable ===== "+irid);
        while(getRs_IR().next()){
            count = Integer.parseInt(getRs_IR().getString("ird_rowcount"));
        }
        return count;
    }

    
   
}
