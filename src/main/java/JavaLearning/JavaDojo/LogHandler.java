package JavaLearning.JavaDojo;

import java.text.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogHandler {

	public LogEntity getEntity(String logStr) {
		LogEntity logEntity = new LogEntity();
		String ipRegex = "\\d+\\.\\d+\\.\\d+\\.\\d+";
		Matcher ipMatcher = Pattern.compile(ipRegex).matcher(logStr);
		ipMatcher.find();
		logEntity.setIp(ipMatcher.group(0));
		String timeRegex = "\\d+\\/\\w+\\/\\d+\\:\\d+\\:\\d+\\:\\d+\\s\\+\\d+";
		Matcher TimeMatcher = Pattern.compile(timeRegex).matcher(logStr);
		TimeMatcher.find();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
		try {
			logEntity.setRequestTime(dateFormat.parse(TimeMatcher.group(0)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return logEntity;
	}

}
