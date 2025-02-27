function irformDepartmentButton(dept_name,dept_id){
    let dept_btn_ir = document.querySelector(".dept-input");
    let dept_hidden_input = document.querySelector(".dept-hidden-input");
    dept_btn_ir.style.backgroundColor = '#d5d1defe';
    dept_btn_ir.innerText = dept_name+"  ";
    dept_hidden_input.value = dept_id;
}


function irformIRToButton(display_name,accountID){
    console.log(display_name);
    console.log(accountID);
    let irto_btn = document.querySelector(".irto-input");
    let irto_hidden_input = document.querySelector(".irto-hidden-input");
    irto_btn.style.backgroundColor = '#d5d1defe';
    irto_btn.innerText = display_name+"  ";
    irto_hidden_input.value = accountID;
}


function irformWOButton(wo_name,wo_id){
    let wo_btn_ir = document.querySelector(".wo-input");
    let wo_hidden_input = document.querySelector(".wo-hidden-input");
    wo_btn_ir.style.backgroundColor = '#d5d1defe';
    wo_btn_ir.innerText = wo_name+"  ";
    wo_hidden_input.value = wo_id;
} 

function callIRServlet(){
    $.ajax({
        url : '../IRServlet',
        data : {
                transdate : $(".transdate-input").val(),
                dept_hidden_ID: $(".dept-hidden-input").val(),
                irto_hidden_ID: $(".irto-hidden-input").val(),
                wo_hidden_ID: $(".wo-hidden-input").val(),
                status: $(".input-status").val()
               }
    });
}

function callIRServlet(current_irid){
    $.ajax({
        url : '../IRServlet',
        data : {
                current_irid : current_irid,
                dept_hidden_ID: $(".dept-hidden-input").val(),
                irto_hidden_ID: $(".irto-hidden-input").val(),
                wo_hidden_ID: $(".wo-hidden-input").val(),
                status: $(".input-status").val()
               }
    });
}
// "1"	"2024-06-02 11:48:13.810373+00"	"2024-05-02 11:37:36"	"677de4be"	"5546cc61"	"Open"	173	"3"