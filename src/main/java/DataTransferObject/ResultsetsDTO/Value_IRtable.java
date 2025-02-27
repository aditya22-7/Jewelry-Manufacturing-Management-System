package DataTransferObject.ResultsetsDTO;

import java.sql.ResultSet;

public class Value_IRtable {

    ResultSet rs_workorder;

    public ResultSet getRs_IR() {
        return rs_workorder;
    }

    public void setRs_IR(ResultSet rs_workorder) {
        this.rs_workorder = rs_workorder;
    }
    
}
