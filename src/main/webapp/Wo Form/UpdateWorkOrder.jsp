<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Work Order</title>
        
        
        <style>
            .myForm-wo-update{
                margin: 15px 0 0 15px;
                width: 620px;
                height: 405px;
                display: flex;
                flex-direction: column;
                background-color: var(--bs-light);
                border: 1px solid black;
                border-radius: 10px;
                align-items:center;
                justify-content:start;
            }
            .c-datatoupdate{
                background-color: #d5d1defe;
                width: 600px;
                height: 40px;
                border-radius: 10px;
            }
            .update-btn-span{
                width: 210px;
                margin-top: 5px;
                margin-bottom: 15px;
                display: flex;
                flex-direction: row;
                margin-left: 100px;
            }
            .update-btn{
                width: 200px;
                height: 40px;
                border-radius: 10px;
                background-color: var(--bs-warning);
                border:none;
            }
        </style>
        
    </head>
    <body>
        <form class="myForm-wo-update">
            
            <div id="datatoupdate" class="c-datatoupdate">
                <h4 style="margin-left:10px;margin-bottom: 3px;"><%=request.getParameter("current_woname")%></h4>
            </div>
            
            <%@include file="../Wo Form/WorkOrderForm.jsp" %>
            
            <span class="update-btn-span">
                <button class="update-btn" onclick="callUpdateWorkOrderServlet(`<%=request.getParameter("current_woid")%>`)">Update</button>
            </span>
            
            <div style="height: 30px;width: 600px; background-color: var(--bs-warning-bg-subtle);margin-bottom: 5px;border-radius: 10px;">
                HELLO WORLD
            </div>
        </form>
            
            
        <script type="module" src="../Main Page Assistance/daily_WOdata.js"></script>
    </body>
</html>
