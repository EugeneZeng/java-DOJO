package JavaLearning.JavaDojo;

//import java.lang.*;
/**
 * Hello world!
 *
 */
public class App {
	public String output(String str) {

		if (str == null) {
			return "";
		}
		// 以空格分割字符串为几段子字符串数组
		String[] sArray = str.split(" ");
		// 创建一个字符串变量
		String result = "";
		// 以数组元素个数为限制进行循环
		for (int i = 0; i < sArray.length; i++) {
			// 将子数组倒序
			String inverted = new StringBuffer(sArray[i]).reverse().toString();
			// 将倒序后的数组放入s1中拼接
			if ("".equals(result)) {
				result = inverted;
			} else {
				result += " " + inverted;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println("Hello World!");
	}
}
