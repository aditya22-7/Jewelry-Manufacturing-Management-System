package DataAccessObject;
import DataTransferObject.formvalueDTO.Value_WorkOrderForm;
import java.sql.*;
import org.postgresql.util.PSQLException;

public class WorkOrderdb extends ConnectionClass {
    
    Value_WorkOrderForm i;
    
    public WorkOrderdb(Value_WorkOrderForm i){
        this.i=i;
    }

    
    public void InsertData() throws SQLException{
        
        Connect();
        
        try{
            GenerateAlphaNum r = new GenerateAlphaNum(getCon());            
            
            PreparedStatement pstmt;
            String q = "insert into public.\"WorkOrder\" (id,\"desc\",\"clientID\",\"orderName\",status) values (?,?,?,?,?)";
            pstmt = getCon().prepareStatement(q);

            //____Generate id__________________
            String id = r.generateAlphaNum();
            //_________________________________

            
            pstmt.setString(1, id);
            pstmt.setString(2, i.getDesc());
            pstmt.setString(3, i.getClient());
            pstmt.setString(4, i.getOrderName());
            pstmt.setString(5, i.getStatus());
            pstmt.executeUpdate();
        }catch(PSQLException e){
            System.out.println("INTEGRITY VIOLATED !!!!");
            InsertData();
        }
        
        CloseConnection();
        
        
    }
    
    
    
    
    
}
