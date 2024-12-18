package utilsClasses;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import org.testng.IClass;
import org.testng.IRetryAnalyzer;
import org.testng.ITest;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.internal.ConstructorOrMethod;
import org.testng.xml.XmlTest;




public class TestNGListenerClass implements org.testng.IRetryAnalyzer{
int counter=0;
int totalRetry=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(counter<totalRetry){
		return true;
		}
		return false;
	}


}
