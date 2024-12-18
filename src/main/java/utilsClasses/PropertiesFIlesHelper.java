package utilsClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFIlesHelper {
	
	private Properties properties=null;
	public PropertiesFIlesHelper(String pathtoFile) {
		
		try {
			FileInputStream in=new FileInputStream(pathtoFile);
			properties=new Properties();
			properties.load(in);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Object getProperty(String key) {
		return properties.get(key);
	}

}
