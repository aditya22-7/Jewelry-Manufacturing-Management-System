window.callIRDetailsServlet=callIRDetailsServlet;

export function setIRID(irid){
    document.querySelector("#irid-input").value = irid;
}


function callIRDetailsServlet(){
    $.ajax({
        url : '../IRDetailsServlet',
        data : {
                irid_input: $("#irid-input").val(),
                transtype : $(".input-ir").val(),
                irto_hidden_ID: $(".irto-irDetails-hidden-input").val(),
                dept_hidden_ID: $(".dept-irDetails-hidden-input").val(),
                purity_input: $(".purity-input").val(),
                weight_input: $(".weight-input").val(),
                desc_input: $(".desc-input").val(),
                labour_input: $(".labour-input").val()
               }
    });
}