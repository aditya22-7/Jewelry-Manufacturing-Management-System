package DataAccessObject;

import DataTransferObject.formvalueDTO.Value_IRForm;
import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class UpdateIRDb extends ConnectionClass {
    
    HashMap<Integer,String> map = new HashMap<>();
    Value_IRForm updateIR_valueobject;
    
    public UpdateIRDb(Value_IRForm updateIR_valueobject){
        this.updateIR_valueobject = updateIR_valueobject;
    }
    
    
    
    public void updateIrRow() throws SQLException{

        try (Connection con = DBUtil_dbcp.getDataSource().getConnection()) {
        
            String rs_irQuery = String.format("Select \"deptID\",\"irTo\",status,\"woID\" from public.\"IR\" where id = '%s'",updateIR_valueobject.getupdate_Irid());
            Statement st_updateIR = con.createStatement();
            ResultSet rs_ir = st_updateIR.executeQuery(rs_irQuery);
            
            ResultSetMetaData rsMetaData = rs_ir.getMetaData();
            
//            System.out.println(rsMetaData.getColumnCount());
            map.put(1,updateIR_valueobject.getiR_dept());
            map.put(2,updateIR_valueobject.getiR_irto());
            map.put(3,updateIR_valueobject.getiR_status());
            map.put(4,updateIR_valueobject.getiR_wo());

            for (HashMap.Entry<Integer,String> entry : map.entrySet()){  
                if(entry.getValue()!=null){
                    System.out.println(entry.getKey()+" : "+entry.getValue());
                    
                    PreparedStatement pstmt;
                    String q = String.format("update public.\"WorkOrder\" set \"%s\"=(?) where id = '%s'",rsMetaData.getColumnName(entry.getKey()),updateIR_valueobject.getupdate_Irid());
//                    
                    pstmt = getCon().prepareStatement(q);
                    
                    pstmt.setString(1, entry.getValue());
                    pstmt.executeUpdate();
                } 
            } 
        }
    }
}
