package JavaLearning.JavaDojo;
import java.lang.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public String output(String str){

    	return new StringBuffer(str).reverse().toString();
    }
	public static void main( String[] args )
    {
		
        System.out.println( "Hello World!" );
    }
}
