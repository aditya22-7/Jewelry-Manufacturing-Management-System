package Service.retreiveresultset;

import DataAccessObject.ResultsetMaker.IRresultset;
import DataTransferObject.ResultsetsDTO.Value_IRtable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetreiveResultsetIR {
    
    public Value_IRtable serviceforIRuitableResultset(String woid) throws SQLException{
        
        ResultSet rs_ir = IRresultset.createIRuitableResultset(woid);
        Value_IRtable v_uitable_ir = new Value_IRtable();
        v_uitable_ir.setRs_IR(rs_ir);
        
        return v_uitable_ir;
    }
    
}
