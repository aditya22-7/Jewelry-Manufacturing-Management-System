package Service.retreiveresultset;

import DataAccessObject.ResultsetMaker.WorkOrderResultset;
import DataTransferObject.ResultsetsDTO.Value_WorkOrderTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetreiveResultsetWorkOrder {
    
    public Value_WorkOrderTable serviceforWorkOrderdropendResultset() throws SQLException{
        
        ResultSet rs_workorder = WorkOrderResultset.createWorkOrderdropendResultset();
        Value_WorkOrderTable v_inputdropend_workorder = new Value_WorkOrderTable();
        v_inputdropend_workorder.setRs_workorder(rs_workorder);
        
        return v_inputdropend_workorder;
    }
    
    public Value_WorkOrderTable serviceforWorkOrderUItableResultset() throws SQLException{
        
        ResultSet rs_workorder = WorkOrderResultset.createWorkOrderdropendResultset();
        Value_WorkOrderTable v_inputdropend_workorder = new Value_WorkOrderTable();
        v_inputdropend_workorder.setRs_workorder(rs_workorder);
        
        return v_inputdropend_workorder;
    }
    
}
