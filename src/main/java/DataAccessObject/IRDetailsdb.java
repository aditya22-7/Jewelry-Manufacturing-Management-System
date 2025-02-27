package DataAccessObject;
import DataTransferObject.formvalueDTO.Value_IRDetailsForm;
import java.sql.*;
import java.text.ParseException;
import java.util.*;

public class IRDetailsdb extends ConnectionClass{
    
//    ArrayList list = new ArrayList();
    Value_IRDetailsForm i_ird;
    
    public IRDetailsdb(Value_IRDetailsForm i_ird){
        this.i_ird=i_ird;
    }
    
   
    public void InsertData() throws SQLException, ParseException{
        Connect();
        GenerateAlphaNum r = new GenerateAlphaNum(getCon());
        
        
        Statement st_dept = getCon().createStatement();
        ResultSet rs_deptId = st_dept.executeQuery("Select id from public.\"Department\"");
        
        Statement st_account = getCon().createStatement();
        ResultSet rs_accountID = st_account.executeQuery("Select id from public.\"Account\"");
        
//        Statement st_IR = getCon().createStatement();
//        ResultSet rs_IR = st_IR.executeQuery("Select id,\"irTo\" from public.\"IR\"");
        
        PreparedStatement pstmt;
        String q = "insert into public.\"ID_Trans\" (id,\"irID\",\"transType\",purity,weight,\"desc\", \"transDateTime\",\"labourPercentage\",\"deptID\",\"irTo\") values (?,?,?,?,?,?,?,?,?,?)";
        pstmt = getCon().prepareStatement(q);
        
        
        
        String iRDetailsServlet_id = r.generateAlphaNum();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        String iRDetailsServlet_deptId="";
        while(rs_deptId.next()){  
            if(i_ird.getiRDetailsServlet_dept().equals(rs_deptId.getString(1))){
                iRDetailsServlet_deptId = rs_deptId.getString(1);
            }
        }
        
        String iRDetailsServlet_irToId="";
        while(rs_accountID.next()){
            if(i_ird.getiRDetailsServlet_irto().equals(rs_accountID.getString(1))){
                iRDetailsServlet_irToId = rs_accountID.getString(1);
            }
        }
       
        System.out.println(iRDetailsServlet_id);
        System.out.println(i_ird.getiRDetailsServlet_irid());
        System.out.println(i_ird.getiRDetailsServlet_transtype());
        System.out.println(i_ird.getiRDetailsServlet_purity());
        System.out.println(i_ird.getiRDetailsServlet_weight());
        System.out.println(i_ird.getiRDetailsServlet_desc());
        System.out.println(timestamp);
        System.out.println(i_ird.getiRDetailsServlet_labour());
        System.out.println(iRDetailsServlet_deptId);
        System.out.println(iRDetailsServlet_irToId);
        
        
        pstmt.setString(1,iRDetailsServlet_id);
        pstmt.setString(2, i_ird.getiRDetailsServlet_irid());    
        pstmt.setString(3, i_ird.getiRDetailsServlet_transtype());
        pstmt.setFloat(4, i_ird.getiRDetailsServlet_purity());
        pstmt.setFloat(5, i_ird.getiRDetailsServlet_weight());
        pstmt.setString(6, i_ird.getiRDetailsServlet_desc());
        pstmt.setTimestamp(7, timestamp);
        pstmt.setFloat(8, i_ird.getiRDetailsServlet_labour());
        pstmt.setString(9, iRDetailsServlet_deptId);
        pstmt.setString(10, iRDetailsServlet_irToId);    
        
        pstmt.executeUpdate();
        
        CloseConnection();
    }
    
    
    
}
