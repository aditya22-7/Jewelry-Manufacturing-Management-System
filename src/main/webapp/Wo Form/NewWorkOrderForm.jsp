<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            .myForm-wo-new{
                margin: 15px 0 0 15px;
                width: 620px;
                height: 390px;
                display: flex;
                flex-direction: column;
                background-color: var(--bs-light);
                border: 1px solid black;
                border-radius: 10px;
                align-items:center;
                justify-content:start;
            }
            .save-btn-span{
                width: 210px;
                margin-top: 5px;
                margin-bottom: 15px;
                display: flex;
                flex-direction: row;
                margin-left: 100px;
            }
            .save-btn{
                width: 200px;
                height: 40px;
                border-radius: 10px;
                background-color: var(--bs-warning);
                border:none;
            }
        </style>
    </head>
    <body>
        <form class="myForm-wo-new">
            <%@include file="../Wo Form/WorkOrderForm.jsp"%>
            <span class="save-btn-span">
                <button class="save-btn" onclick="callWorkOrderServlet()">Save</button>
            </span>
            <div style="height: 30px;width: 600px; background-color: var(--bs-warning-bg-subtle);margin-bottom: 2px;border-radius: 10px;">
                HELLO WORLD
            </div>
        </form>
    </body>
</html>
