package utilsClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilsFunctions {
	
	public static int returnOnlyNumeric(String value) {
		String svalue="";
			Pattern pattern=Pattern.compile("\\d+");
			Matcher matcher =pattern.matcher(value);
			while(matcher.find()) {
				svalue=svalue+matcher.group();
			
		}
			System.out.println(svalue+" value is");
			return Integer.parseInt(svalue);
		
		
	}

}
