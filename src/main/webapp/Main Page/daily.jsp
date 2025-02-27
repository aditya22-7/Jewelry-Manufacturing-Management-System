<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="FrontendAssist.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<!--DOUBT : btn functionality of Account Name btn in js works only if <script src="WorkOrderForm_FetchData.js"></script> is added to daily.jsp
it doesnt work if this script is added to WorkOrderForm.jsp. Why does this happen ? Understand the semantics.
-->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Oranova</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script
        src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous">    
    </script>
    <script src="https://kit.fontawesome.com/3516857208.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../Main Page/style.css">

    

</head>

<body>
    <div class="pageparent">
                <nav class="nav">
                    <a class="navbar-brand" href="#">Oranova</a>
                </nav>
        
                <div class="table-form-page">
                    <div class="wo-jobs">
                        <div class="wo">
                            <div class="wo-label-div"><b>Work Order</b></div>
                            <div class="wo-table-parent">
                                <table class="wo-table table">
                                   <tr>
                                        <th>WorkOrder</th>
                                        <th>Status</th>
                                        <th>Jobs</th>
                                        <th></th>
                                   </tr>
                                   
                                   
                                   <%@include file="../Main Page Assistance/daily_WOdata.jsp"%>
                                   
                                   
                                </table>
                            </div>
                            <button onclick="loadWorkOrderForm(<%=DBUtil_dbcp.checkActiveCon()%>)" class="wo-btn"><i class="fa-solid fa-plus"></i> New</button>
                            
                        </div>
                        <!-- <br> -->
                        <h1 id="myh1"></h1>
                        <div class="jobs">
                            <div class="jobs-label-div"><b>Jobs</b></div>
                            <div class="jobs-table-parent">
                                <table id="jobs-table" class="jobs-table table">
                                    <tr>
                                        <th>Job</th>
                                        <th>Pending</th>
                                        <th>Status</th>
                                        <th>Issue Receipts</th>
                                        <th></th>
                                    </tr>
                                    
                                </table>
                                <div class="InstructioninIR">
                                   <h3>Select WorkOrder</h3>
                                </div>
                                
                            </div>
                            <button type="submit" class="jobs-btn" onclick="loadIRForm(<%=DBUtil_dbcp.checkActiveCon()%>)"><i class="fa-solid fa-plus"></i> New</button>
                        </div>
                    </div>
                    
                    <div class="divider-table-form-page"></div>
                    <div class="details-newField" id="details-newField">
                        <div class="details-newField-support">
<!--                            <div class="form-details">
                            </div>-->
                        
                            <div class="details-divider-newform"></div>
                            <hr class="h-line">
                            <div class="update-existing-form">
                                <span class="title-span">
                                    <h4 id="title" style="margin-bottom: 0px; background-color: var(--bs-warning-bg-subtle)">

                                    </h4>
                                </span>
                                <span class="LoadIR-btn-span">
                                    <button class="LoadIR-btn"><i class="fa-sharp fa-regular fa-pen-to-square"></i>IRDetails</button>
                                    <button class="LoadIR-btn" onclick="loadIRDetailsForm(<%=DBUtil_dbcp.checkActiveCon()%>)"><i class="fa-solid fa-plus"></i>IRDetails</button>
                                </span>  
                            </div>
                                
                            <hr class="h-line">
                            <div class="FormPositioningdiv">
                                <div class="newform"></div>
                                    <div class="FormDetailsdiv">
                                        <div class="FormDetailsdiv-label">
                                            <h4 style="margin-left: 10px;">Table Details</h4>
                                        </div>
                                        <div class="iridMessage" style="font-size: 30px;">
                                            
                                        </div>
                                    </div>
                            </div>
                        </div>
                            
                    </div>
                </div>
    </div>
            
                                   
    <script type="module" src='../Main Page/script_assist.js'></script>
    <script type="module" src="../Main Page Assistance/daily_WOdata.js"></script>
    <script type="module" src="../Main Page/script.js"></script>
    <script src="../IRDetails Form/IRDetailsForm_FetchData.js"></script>
    <script src="../Wo Form/WorkOrderForm_FetchData.js"></script>
    <script src="../IR Form/IRForm_FetchData.js"></script>
    <script type="module" src="../IR Form/CallForUpdateIR.js"></script>
    <script type="module" src="../IRDetails Form/scriptIRDetailsForm.js"></script>
    <script type="module" src="../Main Page Assistance/setIrid_inIRDetailsForm.js"></script>
</body>
</html>
