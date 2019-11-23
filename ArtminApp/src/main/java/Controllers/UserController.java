/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author work
 */

@Controller
@RequestMapping("/ArtminApp/usercontroller.htm")
public class UserController {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String userLogin() {
        
        //Connection to database
        String hostName = "jpcloudeu011.nshostserver.net";
        String dbName = "artminbe_ArtminDB";
        String user = "artminbe_ArtAdm"; //Vervangen door value textfield
        String password = "@rtMinAdmin"; //Vervangen door value textfield
        
        String url = String.format("jdbc:mysql://%s:3306;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection(url);
            
            String userSql = "SELECT TOP 20 name FROM [Users]";
            
            try(Statement statement = connection.createStatement(); java.sql.ResultSet resultset = statement.executeQuery(userSql)) {
                while (resultset.next()){
                    System.out.println(resultset.getString(0));
                }
                connection.close();
            }
            
        }
        catch(Exception e){
            System.out.println("Fout:");
            e.printStackTrace();
        }
        
        return "";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String demo() {
        int test = 1;
        return "";
    }
}
