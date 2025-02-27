<%@page import="Service.retreiveresultset.RetreiveResultsetAccount"%>
<%@page import="DataTransferObject.ResultsetsDTO.Value_AccountTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WorkOrderForm</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
       
        
    </head>
    <body class="body-class">
        
        <div class="woIncluder-parentdiv">
            
            <div class="field ordername">
                <label for="wo">OrderName</label>
                <input class="i ordername-input" type="text" name="wo">
            </div>
            <div class="field desc">
                <label for="desc">Description</label>
                <input class="i desc-input" type="text" name="desc">
            </div>
            
            <div class="field dropend">
                <label for="client">Client</label>
                <input class="acc-hidden-input" type="hidden" name="account_hidden_ID" value="">
                <button style="background-color: #d5d1defe;" class="btn dropdown-toggle client-input" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Account Name 
                </button>
                
                <ul class="dropdown-menu dropdown-menu-assist">

                    <%
                        Value_AccountTable v_inputdropend_account = RetreiveResultsetAccount.serviceforAccountdropendResultset();
                        ResultSet rs_accountdropend = v_inputdropend_account.getRs_account();
                        int counter=1;
                    %>

                    <%while(rs_accountdropend.next()){%>
                        
                        <li>
                            <button onclick="woformAccountButton('<%=rs_accountdropend.getString("displayName")%>','<%=rs_accountdropend.getString("id")%>')" class="li-item-b dropdown-item" type="button">
                                <%=rs_accountdropend.getString("displayName")%>
                            </button>
                        </li>  
                        <%System.out.println("counter is = "+counter++);%>
                        <%System.out.println(rs_accountdropend.getString("displayName"));%>
                    <%}%>
                </ul>
                
            </div>
                
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
                          
        <link rel="stylesheet" href="../Wo Form/WorkOrderForm.css"/>        
    </body>
</html>







