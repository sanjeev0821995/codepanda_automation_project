package org.orange.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;

    public ReadConfig()
    {
        String directory=System.getProperty("user.dir");
        File src = new File(directory+File.separator+"src"+File.separator+"main"+
                File.separator+"java"+File.separator+"org"+File.separator+"orange"+File.separator
                +"resources"+File.separator+"config.properties");
        try
        {
            FileInputStream file= new FileInputStream(src) ;
            properties= new Properties();
            properties.load(file);
        }
        catch (Exception e)
        {
            System.out.println("Exception is" + e.getMessage());
        }
    }

    public String getApplicationUrl(){
        return properties.getProperty("url");
    }

    public String getUserName(){
        return properties.getProperty("username");
    }

    public String getApplicationPassword(){
        return properties.getProperty("applicationPassword");
    }
    public String getEmployeeName(){
        return properties.getProperty("employeeName");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public String getConfirmPassword(){
        return properties.getProperty("confirmPassword");
    }


}
