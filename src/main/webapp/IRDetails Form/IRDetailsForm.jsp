<%@page import="DataTransferObject.ResultsetsDTO.Value_DepartmentTable"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_AccountTable"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetDepartment"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Service.retreiveresultset.RetreiveResultsetAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IRDetailsForm</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        
    </head>
    <body>
        
        <div class="irdform-instruction-div"></div>
        <form class="myForm">

            
            <div id="trans-datetime">
            </div>
            
            <input id="irid-input" type="hidden" value="">
            
            <fieldset id="fieldset-IRDetails">
                    <div class="transtype">
                    <label>Transaction Type</label>

                    <input class="input-ir" type="hidden" name="ir">
                    <button type="button" class="trans-btn1">Issue</button>
                    &nbsp;&nbsp;
                    <button type="button" class="trans-btn2">Receipt</button>
                </div>


                <div class="field dropend">
                    <label for="irto">IR To</label>
                    <input class="irto-irDetails-hidden-input" type="hidden" name="irto-hidden_ID" value="">
                    <button style="background-color: #d5d1defe;" class="btn dropdown-toggle irto-irdetails-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        IR To &nbsp;
                    </button>
                    
                    <%--
                    <ul class="dropdown-menu dropdown-menu-assist">
                        
                        <%
                            Value_AccountTable v_inputdropend_account = RetreiveResultsetAccount.serviceforAccountdropendResultset();
                            ResultSet rs_accountdropend = v_inputdropend_account.getRs_account();
                        %>

                        <%while(rs_accountdropend.next()){%>

                            <li>
                                <button onclick="irformdetailsIRToButton(`<%=rs_accountdropend.getString("displayName")%>`,`<%=rs_accountdropend.getString("id")%>`);" class="li-item-b dropdown-item" type="button">
                                    <%=rs_accountdropend.getString("displayName")%>
                                </button>
                            </li>  

                        <%}%>
                    </ul>
                    --%>
                </div>


                <div class="field dropend">
                    <label for="dept-ir">Department</label>
                    <input class="dept-irDetails-hidden-input" type="hidden" name="dept-hidden_ID" value="">
                    <button style="background-color: #d5d1defe;" class="btn dropdown-toggle dept-irdetails-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Department &nbsp;
                    </button>
                    
                    <%--
                    <ul class="dropdown-menu dropdown-menu-assist">
                        <%
                            Value_DepartmentTable v_inputdropend = RetreiveResultsetDepartment.serviceforDeptdropendResultset();
                            ResultSet rs_deptdropend = v_inputdropend.getRs_dept();
                        %>

                        <%while(rs_deptdropend.next()){%>
                            <li>
                                <button onclick="irdetailsformDepartmentButton(`<%=rs_deptdropend.getString("deptName")%>`,`<%=rs_deptdropend.getString("id")%>`);" class="li-item-b dropdown-item" type="button">
                                    <%=rs_deptdropend.getString("deptName")%>
                                </button>
                            </li>  
                        <%}%>
                        
                    </ul>
                    --%>
                </div>


                <div class="field purity">
                    <label for="purity">Purity</label>
                    <input class="i purity-input" type="text" name="purity">
                    <br>
                </div>
                <div class="purity-btn-div" style="height: 37px;">
                    <button type="button" class="purity-btn purity-btn-one" onclick="purityButtonFunction()">91.8</button>
                    <button type="button" class="purity-btn purity-btn-two" onclick="purityButtonFunction()">75.1</button>
                    <button type="button" class="purity-btn purity-btn-three" onclick="purityButtonFunction()">99.9</button>
                    <button type="button" class="purity-btn purity-btn-four" onclick="purityButtonFunction()">99.5</button>
                </div>

                <div class="weight">
                    <label for="weight">Weight</label>
                    <input class="i weight-input" type="text" name="weight">
                </div>
                <div class="field desc">
                    <label for="desc">Description</label>
                    <input class="i desc-input" type="text" name="desc">
                </div>
                <div class="field labour">
                    <label for="labour">Labour %</label>
                    <input class="i labour-input" type="text" name="labour">
                </div>
                <div class="save-btn-div">
                    <button class="save-btn" onclick='callIRDetailsServlet()'>Save</button>
                </div>
            </fieldset>
                                    
        </form>
        
        
        <link rel="stylesheet" href="../IRDetails Form/IRDetailsForm.css"/> 
        <script type="module" src="../IRDetails Form/scriptIRDetailsForm.js"></script>
    </body>
</html>
