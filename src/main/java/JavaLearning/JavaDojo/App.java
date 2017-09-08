package JavaLearning.JavaDojo;
//import java.lang.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public String output(String str){

    	if(str==null)
    	{
    		return "";
    	}
    	String str1=str.replaceAll(" ", "");
    	return new StringBuffer(str1).reverse().toString();
    	
    	
    }
	public static void main( String[] args )
    {
		
        System.out.println( "Hello World!" );
    }
}
