<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datasourceStore.DBUtil_dbcp"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetWorkOrder"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_WorkOrderTable" %>
<%@page import= "FrontendAssist.*" %>
<%@page import = "java.sql.*" %>

<!--DOUBT : page directive needs to be defined for all pages, daily_WOdata.jsp,daily.jsp but 
            jstl tag directive is not included here then to no error but this page is included
            in daily.jsp may that is why it is working. Understand all the scopes and semantics -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            .updatebtn{
                background-color: var(--bs-light);
                border: none;
                width: 30px;
                height: 30px;
                border-radius: 5px;
            }
            .updatebtn:hover{
                background-color: #d5d1defe;    
            }
        </style>
    </head>
    <body>
        <%
            Value_WorkOrderTable v_workorder_uitable = new RetreiveResultsetWorkOrder().serviceforWorkOrderUItableResultset();
            ResultSet rs_workorder_uitable = v_workorder_uitable.getRs_workorder();
        %>

        <%
            int count;
            Connection con = DBUtil_dbcp.getDataSource().getConnection();
            Daily_IRcount dc = new Daily_IRcount(con);
        %>
        
        <%while(rs_workorder_uitable.next()){%>
        
            <%
                String woNo = rs_workorder_uitable.getString("woNo");
                String orderName = rs_workorder_uitable.getString("orderName");
                String status = rs_workorder_uitable.getString("status");
                String id_workorder = rs_workorder_uitable.getString("id");
            %>
            <tr onclick='loadIRtablerows(`<%=id_workorder%>`);' class="row-wo"> 
                
                <td><%=woNo+":"+orderName%></td>
                <td><%=status%></td>

                <%
                    count = dc.getJobsCount(id_workorder);
                %>  
                <td><%="Jobs("+count+")"%></td>
                <td><button class="updatebtn" onclick='updateButton(`<%=rs_workorder_uitable.getString("id")%>`,`<%=rs_workorder_uitable.getString("orderName")%>`);'><i class="fa-sharp fa-regular fa-pen-to-square"></i></button></td>
                <!--updateButton()is written in daily_WOdata.js-->
            </tr>
        <%}%>
         
        <%
            con.close();
        %>
        
        <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous">
        </script>
        <script src="https://kit.fontawesome.com/3516857208.js" crossorigin="anonymous"></script>
        <script type="module" src="../Main Page Assistance/daily_WOdata.js"></script>
    </body>
</html>
