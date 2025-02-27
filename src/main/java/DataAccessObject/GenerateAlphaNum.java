package DataAccessObject;
import java.util.Random;
import java.sql.*;


public class GenerateAlphaNum {
    Connection con;

    public GenerateAlphaNum(Connection con){
        this.con=con;
    }
    
    public Connection getCon() {
        return con;
    }

    private final String letters = "abcdefghijklmnopqrstuvwxyz";
    private final char[] alphanumeric = (letters+"0123456789").toCharArray();
    
    
    StringBuilder result = new StringBuilder();
    public String generateAlphaNum(){
        result.setLength(0);  

        for(int i=0;i<8;i++){
            result.append(alphanumeric[new Random().nextInt(alphanumeric.length)]);
        }
        
        return convertToString(result);
    }
    
    public String convertToString(StringBuilder result){
        char[] a = new char[result.length()];
        for(int i=0;i<result.length();i++){
            a[i]=result.charAt(i);
        }
        String alphanum_string = String.valueOf(a);
        return alphanum_string;
    }
}
