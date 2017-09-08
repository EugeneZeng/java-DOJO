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
    	//String str1=str.replaceAll(" ", "");
    	//return new StringBuffer(str).reverse().append(str).toString();
    	//以空格分割字符串为几段子字符串数组
    	String[] s = str.split(" ");
    	//创建一个字符串变量
    	  String s1 = "";
    	//以数组元素个数为限制进行循环
    	  for (int i = 0; i < s.length; i++) 
    	  {
    		//将子数组倒序  
    	   String s2 = new StringBuffer(s[i]).reverse().toString();
    	   //将倒序后的数组放入s1中拼接
    	   if ("".equals(s1))
    	    {
    		   s1 = s2;
    	    }
    	   else
    	    {
    		   s1=s1+" "+s2;
    	    }
    	  }
    	  return s1;

         
        
    	
    }
	public static void main( String[] args )
    {
		App a = new App();
		a.output("hello world");
        //System.out.println( "Hello World!" );
    }
}
