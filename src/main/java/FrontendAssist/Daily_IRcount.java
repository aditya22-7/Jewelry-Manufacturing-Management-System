package FrontendAssist;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Daily_IRcount{

    
    Connection con;
    Daily_IRcount dirCount;
    
    public Daily_IRcount(){}

    public Daily_IRcount getDirCount() {
        return dirCount;
    }

    public void setDirCount(Daily_IRcount dirCount) {
        this.dirCount = dirCount;
    }
    public Daily_IRcount(Connection con){
        this.con = con;
    }
    public Connection getCon() {
        return con;
    }
    
    
    public int getJobsCount(String woid)throws SQLException{
        int count = 0;
//        System.out.println("_____I m inside Daily_IRCount from daily_WOdata.jsp______");
//        System.out.println("woid in Daily_IRCount ===== "+woid);
        String queryString = String.format("select count(*) as totaljobsCount from public.\"IR\" where \"woID\" = '%s'",woid);
        Statement st = getCon().createStatement();
        ResultSet rs_IR = st.executeQuery(queryString);
        
        while(rs_IR.next()){
            count = Integer.parseInt(rs_IR.getString("totaljobsCount"));
        }
        
//        System.out.println("No. of jobs for "+woid+" ======= "+count);
        return count;
    }

    
   
}
