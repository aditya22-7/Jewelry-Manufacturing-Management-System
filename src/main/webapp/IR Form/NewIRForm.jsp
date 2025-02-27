<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style>
        
        .myForm-ir-new{
                margin: 15px 0 0 15px;
                width: 640px;
                height: 410px;
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
                /*margin-bottom: 50px;*/
                display: flex;
                flex-direction: row;
                margin-left: 160px;
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
        
        <form class="myForm-ir-new">
            <%@include file="../IR Form/IRForm.jsp" %>
            <span class="save-btn-span">
                <button class="save-btn" onclick="callIRServlet()">Save</button>
            </span>
                    
        </form>
        
    </body>
</html>
