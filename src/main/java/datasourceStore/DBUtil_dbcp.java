package datasourceStore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil_dbcp {
    
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }
    public static int checkActiveCon(){
        BasicDataSource bds = (BasicDataSource)getDataSource();
        return bds.getNumActive();
    }
    static{
        
        try{
//            String filename = "mydatabaseConfig.properties";
//            String workingDirectory = System.getProperty("user.dir");
//            String filepath = workingDirectory + File.separator + filename;
//            String filePath = Paths.get(filename).toAbsolutePath().toString();
//            System.out.println("File path: " + filePath);
            
            
            Properties prop = new Properties();
            InputStream is = new FileInputStream("C:\\Users\\Megha Mathur\\Documents\\NetBeansProjects\\MavenWebTest\\src\\main\\java\\dbcpexploration\\mydatabaseConfig.properties");
            prop.load(is);

            BasicDataSource bds = new BasicDataSource();
   
            Class.forName(prop.getProperty("driverName"));
            bds.setUrl(prop.getProperty("dburl"));
            bds.setUsername(prop.getProperty("username"));
            bds.setPassword(prop.getProperty("password"));
            bds.setMinIdle(200);
            dataSource = (DataSource)bds;
            
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUtil_dbcp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBUtil_dbcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    
    

