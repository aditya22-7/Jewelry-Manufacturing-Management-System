package Service;
import DataTransferObject.formvalueDTO.Value_IRDetails_fromIRClick;
import DataTransferObject.formvalueDTO.Value_WorkOrderForm;
import DataTransferObject.formvalueDTO.Value_IRForm;
import DataTransferObject.formvalueDTO.Value_IRDetailsForm;

public class SetIn_DTO {
    
    Value_WorkOrderForm i_wo = new Value_WorkOrderForm();
    Value_IRForm i_ir = new Value_IRForm();
    Value_IRDetailsForm i_ird = new Value_IRDetailsForm();
    Value_IRDetails_fromIRClick i_ird_forIRIDsetting = new Value_IRDetails_fromIRClick();
    
    
    public SetIn_DTO(){}
    
    Value_WorkOrderForm setWoParameters(String orderName,String desc,String client,String status){
        i_wo.setOrderName(orderName);
        i_wo.setDesc(desc);
        i_wo.setClient(client);
        i_wo.setStatus(status);
        return i_wo;
    }   
    Value_WorkOrderForm setUpdateWoParameters(String woid,String orderName,String desc,String client,String status){
        i_wo.setUpdate_woid(woid);
        i_wo.setOrderName(orderName);
        i_wo.setDesc(desc);
        i_wo.setClient(client);
        i_wo.setStatus(status);
        return i_wo;
    }   
    
    Value_IRForm setIRParameters(String iR_transdate, String iR_dept, String iR_irto,String iR_wo, String iR_status){
        i_ir.setiR_transdate(iR_transdate);
        i_ir.setiR_dept(iR_dept);
        i_ir.setiR_irto(iR_irto);
        i_ir.setiR_wo(iR_wo);
        i_ir.setiR_status(iR_status);
        return i_ir;
    }
    Value_IRForm setUpdateIRParameters(String irid, String iR_dept, String iR_irto,String iR_wo, String iR_status){
        i_ir.setupdate_Irid(irid);
        i_ir.setiR_dept(iR_dept);
        i_ir.setiR_irto(iR_irto);
        i_ir.setiR_wo(iR_wo);
        i_ir.setiR_status(iR_status);
        return i_ir;
    }
    
    Value_IRDetailsForm setIRDetailsParameters(String iRDetailsServlet_irid, String iRDetailsServlet_irto, String iRDetailsServlet_dept ,String iRDetailsServlet_transtype, float iRDetailsServlet_purity, float iRDetailsServlet_weight, String iRDetailsServlet_desc,float iRDetailsServlet_labour){
       
        i_ird.setiRDetailsServlet_irid(iRDetailsServlet_irid);
        i_ird.setiRDetailsServlet_irto(iRDetailsServlet_irto);
        i_ird.setiRDetailsServlet_dept(iRDetailsServlet_dept);
        i_ird.setiRDetailsServlet_transtype(iRDetailsServlet_transtype);
        i_ird.setiRDetailsServlet_purity(iRDetailsServlet_purity);
        i_ird.setiRDetailsServlet_weight(iRDetailsServlet_weight);
        i_ird.setiRDetailsServlet_desc(iRDetailsServlet_desc);
        i_ird.setiRDetailsServlet_labour(iRDetailsServlet_labour);
        return i_ird;
    }
    public Value_IRDetails_fromIRClick setIRDetailsParameter_irid(String Irid_AssisstServlet_for_IRDetailsForm_irid){
        i_ird_forIRIDsetting.setIrid_AssisstServlet_for_IRDetailsForm_irid(Irid_AssisstServlet_for_IRDetailsForm_irid);
    
        return i_ird_forIRIDsetting;
    }
    
}
