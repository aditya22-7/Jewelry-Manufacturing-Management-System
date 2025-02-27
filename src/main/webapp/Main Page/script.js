import { getDate,formatDate,iRStatus } from '../Main Page/script_assist.js'; 


window.loadWorkOrderForm = loadWorkOrderForm;
window.loadIRForm = loadIRForm;
window.loadIRDetailsForm = loadIRDetailsForm;
window.print_TransDateTime = print_TransDateTime;
window.purityButtonFunction = purityButtonFunction;
window.iRStatusDirect = iRStatusDirect;
window.iRDetailsIR = iRDetailsIR;



document.addEventListener('DOMContentLoaded',function(){
    loadIRDetailsForm();
});

function loadWorkOrderForm(activecon){
    
    document.querySelector("#title").innerHTML = "WorkOrderForm";
    
    let request = new XMLHttpRequest();
    
    request.open("GET","../Wo Form/NewWorkOrderForm.jsp");
    console.log("Active Pool Connections ==== "+activecon);
    request.onreadystatechange = function(){
    console.log("ready state of WorkOrderForm === "+this.readyState);

        if(this.readyState===4 && this.status===200){
            //console.log(this.responseText);
            document.querySelector(".newform").innerHTML = this.responseText;
            iRStatus();
        }
        
    };
    request.send();
}

function loadIRForm(activecon){
    console.log("HELLO WORLD !!!");
    document.querySelector("#title").innerHTML = "New Job Form";
    let request = new XMLHttpRequest();
    
    request.open("GET","../IR Form/NewIRForm.jsp");
    console.log("Active Pool Connections ==== "+activecon);
    request.onreadystatechange = function(){
        console.log("ready state of IRForm === "+this.readyState);
        
        if(this.readyState===4 && this.status===200){
            //console.log(this.responseText);
            document.querySelector(".newform").innerHTML = this.responseText;
            getDate();
            iRStatus();
        }
        
    };
    request.send();
    
    
}


function loadIRDetailsForm(activecon){
    
    document.querySelector("#title").innerHTML = "IRDetails Form";

    let request = new XMLHttpRequest();

    request.open("GET","../IRDetails Form/IRDetailsForm.jsp");
    console.log("Active Pool Connections ==== "+activecon);
    request.onreadystatechange = function(){
        
        console.log("ready state of IRDetailsForm === "+this.readyState);
        if(this.readyState===4 && this.status===200){
            //console.log(this.responseText);
            document.querySelector(".newform").innerHTML = this.responseText;
            iRDetailsIR();
            print_TransDateTime();
            purityButtonFunction();
        }

    };
    request.send();
}


function print_TransDateTime(){
    let dt = new Date();
    let format_dt = formatDate(dt);
    document.querySelector("#trans-datetime").innerText = format_dt;    
}


function purityButtonFunction(){
    let btn1 = document.querySelector(".purity-btn-one");
    let btn2 = document.querySelector(".purity-btn-two");
    let btn3 = document.querySelector(".purity-btn-three");
    let btn4 = document.querySelector(".purity-btn-four");
    let input = document.querySelector('.purity-input');

    btn1.addEventListener('click',()=>{
        input.value = btn1.textContent;
    });
    btn2.addEventListener('click',()=>{
        input.value = btn2.textContent;
    });
    btn3.addEventListener('click',()=>{
        input.value = btn3.textContent;
    });
    btn4.addEventListener('click',()=>{
        input.value = btn4.textContent;
    });

}
function iRStatusDirect(){
    console.log("IRStatus() is called !!!!");
    let open_btn = document.querySelector(".open-btn");
    let rp_btn = document.querySelector(".rp-btn");
    let closed_btn = document.querySelector(".closed-btn");
    let input_status = document.querySelector(".input-status");
    
    open_btn.addEventListener('click',()=>{
        input_status.value = open_btn.textContent;
        open_btn.style.backgroundColor = "var(--bs-warning)";
        rp_btn.style.backgroundColor = '#d5d1defe';
        closed_btn.style.backgroundColor = '#d5d1defe';
    });
    rp_btn.addEventListener('click',()=>{
        input_status.value = rp_btn.textContent;
        rp_btn.style.backgroundColor = "var(--bs-warning)";
        open_btn.style.backgroundColor = '#d5d1defe';
        closed_btn.style.backgroundColor = '#d5d1defe';
    });
    closed_btn.addEventListener('click',()=>{
        input_status.value = closed_btn.textContent;
        closed_btn.style.backgroundColor = "var(--bs-warning)";
        rp_btn.style.backgroundColor = '#d5d1defe';
        open_btn.style.backgroundColor = '#d5d1defe';
    });
    
}
function iRDetailsIR(){
    let ir_button_issue = document.querySelector(".trans-btn1");
    let ir_button_receipt = document.querySelector(".trans-btn2");
    let input_ir = document.querySelector(".input-ir");


    ir_button_issue.addEventListener('click',()=>{
        input_ir.value = ir_button_issue.textContent;
        ir_button_issue.style.backgroundColor = "var(--bs-warning)";
        ir_button_receipt.style.backgroundColor = '#d5d1defe';
        console.log("Issue Button Clicked !!");
    });
    ir_button_receipt.addEventListener('click',()=>{
        input_ir.value = ir_button_receipt.textContent;
        ir_button_receipt.style.backgroundColor = "var(--bs-warning)";
        ir_button_issue.style.backgroundColor = '#d5d1defe';
    });

}



                






