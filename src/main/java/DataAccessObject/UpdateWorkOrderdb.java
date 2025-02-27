package DataAccessObject;

import DataTransferObject.formvalueDTO.Value_WorkOrderForm;
import datasourceStore.DBUtil_dbcp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class UpdateWorkOrderdb extends ConnectionClass {
    
    HashMap<Integer,String> map = new HashMap<>();  
    Value_WorkOrderForm i;
    
    public UpdateWorkOrderdb(Value_WorkOrderForm i){
        this.i=i;
    }

    
    public void updatewoRow() throws SQLException{
        
        try (Connection con = DBUtil_dbcp.getDataSource().getConnection()) {
            String rs_woQuery = String.format("Select * from public.\"WorkOrder\" where id = '%s'",i.getUpdate_woid());
            Statement st = con.createStatement();
            ResultSet rs_wo = st.executeQuery(rs_woQuery);
            
            ResultSetMetaData rsMetaData = rs_wo.getMetaData();
            
//            System.out.println(rsMetaData.getColumnCount());
            map.put(2,i.getDesc());
            map.put(3,i.getClient());
            map.put(4,i.getOrderName());
            map.put(6,i.getStatus());
            System.out.println("currentwoid in DBDBDB ===== "+i.getUpdate_woid());
            for (HashMap.Entry<Integer,String> entry : map.entrySet()){
                if(entry.getValue()!=null){
                    System.out.println(entry.getKey()+" : "+entry.getValue());

                    PreparedStatement pstmt;
                    String q = String.format("update public.\"WorkOrder\" set \"%s\"=(?) where id = '%s'",rsMetaData.getColumnName(entry.getKey()),i.getUpdate_woid());

                    pstmt = getCon().prepareStatement(q);

                    pstmt.setString(1, entry.getValue());
                    pstmt.executeUpdate();
                }
            }
        }

    }
    
    
}
