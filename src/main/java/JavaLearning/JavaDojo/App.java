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
    		str="";
    		return str;
    	}
    	return new StringBuffer(str).reverse().toString();
    	
    	
    }
	public static void main( String[] args )
    {
		
        System.out.println( "Hello World!" );
    }
}
