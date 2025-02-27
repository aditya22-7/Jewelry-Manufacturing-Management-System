<%@page import="datasourceStore.DBUtil_dbcp"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetIR"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_IRtable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "FrontendAssist.*" %>
<%@page import= "FrontendAssist.AssistJobsTable.*" %>
<%@page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous">    
        </script>
        <script src="https://kit.fontawesome.com/3516857208.js" crossorigin="anonymous"></script>
        
        <style>
            .jobs-table-new{
                background-color: var(--bs-light-border-subtle);
                /* LOGIC FOR VERTICAL SCROLLBAR OF TABLE */
                width: 100%; /* Ensure the table takes up 100% width of its container */
                border-radius: 50px;
            }
            .jobs-table-new tr th{
                position: sticky;
                top: 0;
                left: 0;
                background-color: #d5d1defe;
                border-bottom: 2px black solid;
            }
            .jobs-table-new tr:hover td{
                background-color: var(--bs-warning-bg-subtle);
                cursor:pointer;
            }
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
            System.out.println("dailyIRdata.jsp is called on row click !!");
        %>
        <%
            String woid_ir = request.getParameter("woid_from_daily_WOdata_jsp");
        %>
        
        <%
            Value_IRtable v_ir_uitable = new RetreiveResultsetIR().serviceforIRuitableResultset(woid_ir);
            ResultSet rs_ir_uitable = v_ir_uitable.getRs_IR();
        %>
        
        
        <table id="jobs-table-new" class="jobs-table-new table">
            <tr>
                <th>Job</th>
                <th>Pending</th>
                <th>Status</th>
                <th>IRs</th>
                <th></th>
            </tr>
            <%
                int count_ir;
                Connection con = DBUtil_dbcp.getDataSource().getConnection();
                Daily_IRDetailsCount_for_IRtable obj_Daily_IRDetailsCount = new Daily_IRDetailsCount_for_IRtable(con);
                
            %>


                
            <%while(rs_ir_uitable.next()){%>
                
                <%
                    String ir_id = rs_ir_uitable.getString("id");
                    String ir_bagNo = rs_ir_uitable.getString("bagNo");
                    String ir_status = rs_ir_uitable.getString("status");
                    String ir_irto = rs_ir_uitable.getString("irTo");
                    String ir_dept = rs_ir_uitable.getString("deptID");
                    
                    count_ir = obj_Daily_IRDetailsCount.getIssueReceiptsCount(ir_id);
                %>  
                <tr class="row-irtable" onclick="setIrid_inIRDetailsForm(`${IRTable_Id}`)">  
                    <%
                        BringIRto_and_Dept bring = new BringIRto_and_Dept();
                        String irToName = bring.getIRtoforJobsTable(ir_irto);
                        String deptName = bring.getDeptforJobsTable(ir_dept);
                    %>
                    <td><%=ir_bagNo+":"+irToName+":"+deptName%></td>

                    <td><%="99"%></td>

                    <td><%=ir_status%></td>

                    <td><%="IRS("+count_ir+")"%></td>
                    <td><button class="updatebtn" onclick="updateButtonIR(<%=ir_id%>);"><i class="fa-sharp fa-regular fa-pen-to-square"></i></button></td>

                </tr>
                    
            <%}%>
        </table>
            
            <script type="module" src="../IR Form/CallForUpdateIR.js"></script>
    </body>
</html>






















