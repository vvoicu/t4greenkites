package tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import com.selenium.steps.LoginSteps;

import net.thucydides.core.annotations.Steps;

public class FileOutputStreamTopMenuItem {

	@Steps
	public LoginSteps userSteps;
	
	public void writeMenuItem() throws IOException{
		List<String> listMenuName=userSteps.getMenuItem();
		
		Properties itemProp=new Properties();
		OutputStream output=null;
		String finalString = "";
		
		output=new FileOutputStream("menuItem.properties");
		for(int i=0;i<listMenuName.size();i++){
			finalString +=listMenuName.get(i) + ",";
		}
		

		itemProp.setProperty("topMenuItemName", finalString);

		itemProp.store(output, null);
	}
}
