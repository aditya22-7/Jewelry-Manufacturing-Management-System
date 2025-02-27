package Service.retreiveresultset;

import DataAccessObject.ResultsetMaker.DepartmentResultset;
import DataTransferObject.ResultsetsDTO.Value_DepartmentTable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetreiveResultsetDepartment {
    
    public static Value_DepartmentTable serviceforDeptdropendResultset() throws SQLException{
        
        ResultSet rs_dept = DepartmentResultset.createDepartmentdropendResultset();
        Value_DepartmentTable v_inputdropend = new Value_DepartmentTable();
        v_inputdropend.setRs_dept(rs_dept);
        
        return v_inputdropend;
    }
    
}
