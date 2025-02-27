import { getDate,iRStatus } from '../Main Page/script_assist.js'; 

window.updateButtonIR=updateButtonIR;

function updateButtonIR(irid){
    document.querySelector("#title").innerHTML = "Update IR";

    $.ajax({
        url : '../IR Form/UpdateIRForm.jsp',
        data : { 
                current_irid : irid
                },
        success : function(responseText) 
        {
            $('.newform').html(responseText);
            getDate();
            iRStatus();
        }
    });
}