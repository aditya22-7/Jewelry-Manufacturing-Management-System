package DataAccessObject;
import DataTransferObject.formvalueDTO.Value_IRForm;
import java.sql.*;
import java.text.ParseException;
import org.postgresql.util.PSQLException;

public class IRdb extends ConnectionClass {
    Value_IRForm i_ir;
                                                
    public IRdb(Value_IRForm i_ir){
        this.i_ir=i_ir;
    }
    
   
    
    public void InsertData() throws SQLException, ParseException{
        Connect();
        
        try{
            GenerateAlphaNum r = new GenerateAlphaNum(getCon());

            PreparedStatement pstmt;  
            String q = "insert into public.\"IR\" (id,\"transDate\",\"deptID\",\"irTo\",status, \"woID\") values (?,?,?,?,?,?)";
            pstmt = getCon().prepareStatement(q);

            String iR_id = r.generateAlphaNum();

            System.out.println("woid in IRDB ======= "+i_ir.getiR_wo());

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            pstmt.setString(1,iR_id);
            pstmt.setTimestamp(2, timestamp);
            pstmt.setString(3, i_ir.getiR_dept());
            pstmt.setString(4, i_ir.getiR_irto());
            pstmt.setString(5, i_ir.getiR_status());
            pstmt.setString(6, i_ir.getiR_wo());
            pstmt.executeUpdate();
        }catch(PSQLException e){
            System.out.println("INTEGRITY VIOLATED !!!!");
            e.printStackTrace();
            //InsertData();
        }
        
        CloseConnection();
    }
    
    
    
}
