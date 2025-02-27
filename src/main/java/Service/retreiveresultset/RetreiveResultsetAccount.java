package Service.retreiveresultset;

import DataAccessObject.ResultsetMaker.AccountResultset;
import DataTransferObject.ResultsetsDTO.Value_AccountTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetreiveResultsetAccount {
    
    public static Value_AccountTable serviceforAccountdropendResultset() throws SQLException{
        
        ResultSet rs_account = AccountResultset.createAccountdropendResultset();
        Value_AccountTable v_inputdropend = new Value_AccountTable();
        v_inputdropend.setRs_account(rs_account);
        
        return v_inputdropend;
    }
    
}
