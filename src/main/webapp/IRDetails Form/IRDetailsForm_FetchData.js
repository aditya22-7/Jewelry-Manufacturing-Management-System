
function irformdetailsIRToButton(display_name,accountID){
    let irto_btn = document.querySelector(".irto-irdetails-input");
    let irto_hidden_input = document.querySelector(".irto-irDetails-hidden-input");
    irto_btn.style.backgroundColor = '#d5d1defe';
    irto_btn.innerText = display_name+"  ";
    irto_hidden_input.value = accountID;
}
function irdetailsformDepartmentButton(dept_name,dept_id){
    let dept_btn_ir = document.querySelector(".dept-irdetails-input");
    let dept_hidden_input = document.querySelector(".dept-irDetails-hidden-input");
    dept_btn_ir.style.backgroundColor = '#d5d1defe';
    dept_btn_ir.innerText = dept_name+"  ";
    dept_hidden_input.value = dept_id;
}

