package FrontendAssist;
import java.sql.*;
public class DbConnect_Frontend {

    Connection con;
    
            public void setCon(Connection con) {
                this.con = con;
            }
            public Connection getCon() {
                return con;
            }

            public String testing(){
                String st = "I m inside testing of DbConnect_Frontend !!!!";
                return st;
            }

            public void Connect(){
                try{
                    System.out.println("Connect() am called !!!!");
                    Class.forName("org.postgresql.Driver");
                    String url = "jdbc:postgresql://dbtest1.c7quy5rg5od7.ap-south-1.rds.amazonaws.com:5432/ogdb1";
                    String username = "postgres";
                    String password = "oranova1122";
                    con = DriverManager.getConnection(url,username,password);
                    setCon(con);
                    System.out.println("con object ===== "+getCon());
                    if(con.isClosed()){
                        System.out.println("Connection is closed");
                    }else
                        System.out.println("Database connected");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            public void CloseConnection(){
                Runtime.getRuntime().addShutdownHook(new Thread(()->{
                    try{
                        if(con!=null || !con.isClosed()) {
                            con.close();
                            System.out.println("Database Connection Closed");
                        }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }));
            }
}


//<c:forEach var="row" items="${rs.rows}">
//    <tr onclick="callJavaFunction(`${row.name}`);" class="row-wo">  
//        <td><c:out value="${row.orderName}"></c:out></td>
//        <td><c:out value="${row.status}"></c:out></td>
//
//        <c:set scope="request" var="getjob" value="${row.id}"></c:set>
//
//        <%
//            String id = (String) request.getAttribute("getjob");
//
//            count = dc.getJobsCount(id);
//            request.setAttribute("Count", count);
//        %>  
//        <td><c:out value="Jobs(${Count})"></c:out></td>
//
//    </tr>
//</c:forEach>