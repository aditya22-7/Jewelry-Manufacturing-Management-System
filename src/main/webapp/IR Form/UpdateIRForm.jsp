<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                
        <style>
            .myForm-ir-update{
                margin: 15px 0 0 15px;
                width: 640px;
                height: 440px;
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
                margin-bottom: 50px;
                display: flex;
                flex-direction: row;
                margin-left: 160px;
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
        <form class="myForm-ir-update">
            <div id="datatoupdate" class="c-datatoupdate">
                <h4 style="margin-left:10px;margin-bottom: 3px;"><%="Hello World"%></h4>
            </div>
            
            <%@include file="../IR Form/IRForm.jsp" %>
            
            <span class="update-btn-span">
                <button class="update-btn" onclick="callUpdateIRServlet(<%=request.getParameter("current_irid")%>)">Update</button>
            </span>
        </form>
        
    </body>
</html>
