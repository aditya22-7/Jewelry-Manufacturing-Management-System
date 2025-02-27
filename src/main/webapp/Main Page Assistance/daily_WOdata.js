import { getDate,iRStatus } from '../Main Page/script_assist.js'; 

window.loadIRtablerows=loadIRtablerows;
window.updateButton=updateButton;

function loadIRtablerows(woid){
        
    $.ajax({
        url : '../Main Page Assistance/daily_IRdata.jsp',
        data : { woid_from_daily_WOdata_jsp : woid},
        success : function(responseText) 
        {
            $('.jobs-table-parent').html(responseText);
        }
        
    });
//daily_IRdata.jsp
}
function updateButton(woid,ordername){
    
    document.querySelector("#title").innerHTML = "Update WorkOrder";

    $.ajax({
        url : '../Wo Form/UpdateWorkOrder.jsp',
        data : { 
                current_woid : woid,
                current_woname : ordername
                },
        success : function(responseText) 
        {
            $('.newform').html(responseText);
            iRStatus();
        }
    });
}
