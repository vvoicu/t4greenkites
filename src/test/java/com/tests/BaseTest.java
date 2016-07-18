package com.tests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.thucydides.core.annotations.Managed;
import tools.Constants;

public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    

    public String url;
    public String userName;
    public String password;
    
    @Before
    public void dataSetup(){
    	 Properties prop = new Properties();
    	  InputStream input = null;
    	  
    	  try {

    		   input = new FileInputStream(Constants.CONFIG_PATH);

    		   // load a properties file
    		   prop.load(input);
    		   
    		   url = prop.getProperty("url");
    		   userName = prop.getProperty("userName");
    		   password = prop.getProperty("password");
    		   
    		//   // get the property value and print it out
    		   System.out.println(prop.getProperty("url"));
    		   System.out.println(prop.getProperty("userName"));
    		   System.out.println(prop.getProperty("password"));

    		  } catch (IOException ex) {
    		   ex.printStackTrace();
    		  } finally {
    		   if (input != null) {
    		    try {
    		     input.close();
    		    } catch (IOException e) {
    		     e.printStackTrace();
    		    }
    		   }
    		  }
    	}
    
   }

