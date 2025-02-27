import { printirid } from '../Main Page/script_assist.js'; 
import { setIRID } from '../IRDetails Form/scriptIRDetailsForm.js'; 

window.setIrid_inIRDetailsForm=setIrid_inIRDetailsForm;

function setIrid_inIRDetailsForm(ir_id){
//    console.log("Testing for irid ==== ",ir_id);
//    sendiridtoIRDetailsFormView(ir_id);
//    $.ajax({
//        url : '../Irid_AssisstServlet_for_IRDetailsForm',
//        data : { ir_id_from_dailyIRdata_TO_Irid_AssisstServlet_for_IRDetailsForm : ir_id}
//    });
//    sendiridtoIRDetailsFormView(ir_id);
    setIRID(ir_id);
    printirid(ir_id);
}

//function sendiridtoIRDetailsFormView(ir_id){
//    enableIRDForm();
//    loadIRDetailsForm();
//    iridReceivedMessage(ir_id);
//}

