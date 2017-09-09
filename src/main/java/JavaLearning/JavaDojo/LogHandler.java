package JavaLearning.JavaDojo;

import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogHandler {

	public LogEntity getEntity(String logStr) {
		LogEntity logEntity = new LogEntity();
		getIpFromString(logStr, logEntity);
		logEntity.setIp(getIpFromString(logStr, logEntity));
		getTimeFromString(logStr, logEntity);
		logEntity.setRequestTime(getTimeFromString(logStr, logEntity));
		getMethod(logStr, logEntity);
		logEntity.setRequestMethod(getMethod(logStr, logEntity));
		getRequestPath(logStr, logEntity);
		logEntity.setRequestPath(getRequestPath(logStr, logEntity));
		getRequestVersion(logStr, logEntity);
		
		return logEntity;
	}

	private String getRequestVersion(String logStr, LogEntity logEntity) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String requestVersion = new StringBuffer(strArray[2]).toString();
		logEntity.setRequestVersion(requestVersion);
		return requestVersion;
	}

	private String getRequestPath(String logStr, LogEntity logEntity) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String requestPath = new StringBuffer(strArray[1]).toString();
		logEntity.setRequestPath(requestPath);
		return requestPath;
	}

	private String getMethod(String logStr, LogEntity logEntity) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String method = new StringBuffer(strArray[0]).toString();
		logEntity.setRequestMethod(method);
		return method;
	}

	private Date getTimeFromString(String logStr, LogEntity logEntity) {
		Date date = null;
		String timeRegex = "\\d+\\/\\w+\\/\\d+\\:\\d+\\:\\d+\\:\\d+\\s\\+\\d+";
		Matcher TimeMatcher = Pattern.compile(timeRegex).matcher(logStr);
		TimeMatcher.find();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
		try {
			date = dateFormat.parse(TimeMatcher.group(0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	private String getIpFromString(String logStr, LogEntity logEntity) {
		String ipRegex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
		Matcher ipMatcher = Pattern.compile(ipRegex).matcher(logStr);
		ipMatcher.find();
		return ipMatcher.group(0);
	}

}
