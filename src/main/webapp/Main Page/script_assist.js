window.printirid=printirid;
window.getDate=getDate;
window.formatDate=formatDate;
window.iRStatus=iRStatus;

export function printirid(ir_id){
    let message = document.querySelector(".iridMessage");
    console.log(ir_id);
    message.innerText = ir_id;
}

export function getDate(){
    let dt = new Date();
    let format_dt = formatDate(dt);
    let el = document.querySelector("#t");
    el.style.fontSize = "27px";
    el.value = format_dt;
}
export function formatDate(dt){
    let year = dt.getFullYear();
    let month = dt.getMonth()+1;
    let day = dt.getDate();
    let hour = dt.getHours();
    let min = dt.getMinutes();
    let sec = dt.getSeconds();
    
    let req_date = year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;

    let req_date_string = req_date.toString();
    // console.log(req_date_string);
    
    return req_date;
}
export function iRStatus(){
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