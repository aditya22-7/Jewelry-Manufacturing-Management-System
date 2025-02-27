<%@page import="Service.retreiveresultset.RetreiveResultsetDepartment"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_DepartmentTable"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetWorkOrder"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_WorkOrderTable"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetAccount"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_AccountTable"%>
<%@page import="java.sql.Statement"%>
<%@page import="datasourceStore.DBUtil_dbcp"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IRForm</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        
    </head>
    <body>
        
        <div class="ir-included-parentdiv">
            
            <div class="field transdate">
                <label for="transdate">TransactionDate</label>
                <input class="i transdate-input" id="t" type="text" name="transdate">
            </div>
<%--__________________________________Department DropEnd___________________________________________________________--%>            
            
            <div class="field dropend">
                <label for="dept-ir">Department</label>
                <input class="dept-hidden-input" type="hidden" name="dept_hidden_ID" value="">

                <button style="background-color: #d5d1defe;" class="btn dropdown-toggle dept-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Department &nbsp;
                </button>
                
                <ul class="dropdown-menu dropdown-menu-assist">
            
                    <%
                        Value_DepartmentTable v_inputdropend = RetreiveResultsetDepartment.serviceforDeptdropendResultset();
                        ResultSet rs_deptdropend = v_inputdropend.getRs_dept();
                    %>

                    <%while(rs_deptdropend.next()){%>

                        <li>
                            <button onclick="irformDepartmentButton('<%=rs_deptdropend.getString("deptName")%>','<%=rs_deptdropend.getString("id")%>');" class="li-item-b dropdown-item" type="button">
                                <%=rs_deptdropend.getString("deptName")%>
                            </button>
                        </li>  

                    <%}%>
                </ul>
                
            </div>
            
<%--__________________________________IR To DropEnd___________________________________________________________--%>            
            
            <div class="field dropend">
                <label for="irto">IR To</label>
                <input class="irto-hidden-input" type="hidden" name="irto_hidden_ID" value="">
                <button style="background-color: #d5d1defe;" class="btn dropdown-toggle irto-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    IR To &nbsp;
                </button>
                
                
                <ul class="dropdown-menu dropdown-menu-assist">

                    <%
                        Value_AccountTable v_inputdropend_account = RetreiveResultsetAccount.serviceforAccountdropendResultset();
                        ResultSet rs_accountdropend = v_inputdropend_account.getRs_account();
                    %>

                    <%while(rs_accountdropend.next()){%>

                        <li>
                            <button onclick="irformIRToButton('<%=rs_accountdropend.getString("displayName")%>','<%=rs_accountdropend.getString("id")%>');" class="li-item-b dropdown-item" type="button">
                                <%=rs_accountdropend.getString("displayName")%>
                            </button>
                        </li>  

                    <%}%>
                </ul>
                
            </div>
            
<%--__________________________________WorkOrder DropEnd___________________________________________________________--%>            
           
            <div class="field dropend">
                <label for="wo">WorkOrder</label>
                <input class="wo-hidden-input" type="hidden" name="wo_hidden_ID" value="">
                <button style="background-color: #d5d1defe;" class="btn dropdown-toggle wo-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    WorkOrder &nbsp;
                </button>
                
                
                <ul class="dropdown-menu dropdown-menu-assist">
   
                    <%
                        Value_WorkOrderTable v_inputdropend_workorder = new RetreiveResultsetWorkOrder().serviceforWorkOrderdropendResultset();
                        ResultSet rs_workorderdropend = v_inputdropend_workorder.getRs_workorder();
                    %>

                    <%while(rs_workorderdropend.next()){%>

                    <li>
                        <button onclick="irformWOButton('<%=rs_workorderdropend.getString("orderName")%>','<%=rs_workorderdropend.getString("id")%>');" class="li-item-b dropdown-item" type="button">
                            <%=rs_workorderdropend.getString("orderName")%>
                        </button>
                    </li>  

                    <%}%>
                </ul>
                
                
            </div>
            
<%--_______________________________________Status___________________________________________________________--%>            

            <div class="status">
                <label for="status">Status</label>

                <input class="input-status" type="hidden" name="status">
                <button type="button" class="open-btn" onclick="iRStatus()">Open</button>
                &nbsp;&nbsp;
                <button type="button" class="rp-btn" onclick="iRStatus()">Rp</button>
                &nbsp;&nbsp;
                <button type="button" class="closed-btn" onclick="iRStatus()">Closed</button>
            </div>
            
        </div>

    <link rel="stylesheet" href="../IR Form/IRForm.css"/>             
    </body>
</html>

