package JavaLearning.JavaDojo;

import java.text.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogHandler {

	public LogEntity getEntity(String logStr) {
		// 创建一个LogEntity对象
		LogEntity logEntity = new LogEntity();
		// 建立IP地址的正则表达式过滤规则
		String ipRegex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
		// 创建pattern对象和matcher对象，进行编译和匹配
		// Pattern pattern = Pattern.compile(ipRegex);
		Matcher ipMatcher = Pattern.compile(ipRegex).matcher(logStr);
		ipMatcher.find();
		// 把匹配结果放入LogEntity类中的变量ip中
		logEntity.setIp(ipMatcher.group(0));
		System.out.println(logEntity.getIp());
		// 建立时间的正则表达式规则
		String timeRegex = "\\d{2}\\/[A-Z]{1}[a-z]{2}\\/\\d{4}\\:\\d+\\:\\d+\\:\\d+\\s\\+\\d+";
		Matcher TimeMatcher = Pattern.compile(timeRegex).matcher(logStr);
		TimeMatcher.find();
		// 把匹配结果放入LogEntity类中的变量中
		// logEntity.setRequestTime(TimeMatcher.group(0));
		System.out.println(TimeMatcher.group(0));
		// 格式转换
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
		// 转换完成后赋值给LogEntity类中的变量RequestTime中
		try {
			logEntity.setRequestTime(dateFormat.parse(TimeMatcher.group(0)));
			System.out.println(logEntity.getRequestTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return logEntity;
	}

}
