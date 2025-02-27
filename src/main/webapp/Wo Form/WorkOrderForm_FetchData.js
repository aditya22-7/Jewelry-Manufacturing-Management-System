function woformAccountButton(display_name,accountID){
    console.log("Account Name button is clicked !!!!!");
    let acc_btn = document.querySelector(".client-input");
    let acc_hidden_input = document.querySelector(".acc-hidden-input");
    //document.querySelector(".dropdown-toggle").style.display = "none";
    //acc_btn.removeAttribute("data-bs-toggle");
    acc_btn.style.backgroundColor = '#d5d1defe';
//    acc_btn.style.color = 'black';
    acc_btn.innerText = display_name+"   ";
    acc_hidden_input.value = accountID;
    console.log(accountID);
}

function callWorkOrderServlet(){
    $.ajax({
        url : '../WorkOrderServlet',
        data : {
                wo : $(".ordername-input").val(),
                desc: $(".desc-input").val(),
                account_hidden_ID: $(".acc-hidden-input").val(),
                status: $(".input-status").val()
               }
    });
}
function callUpdateWorkOrderServlet(current_woid){
    
    $.ajax({
        url : '../UpdateWorkOrderServlet',
        data : {
                current_woid : current_woid,
                wo : $(".ordername-input").val(),
                desc: $(".desc-input").val(),
                account_hidden_ID: $(".acc-hidden-input").val(),
                status: $(".input-status").val()
               }
    });
}







