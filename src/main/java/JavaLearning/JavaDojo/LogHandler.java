package JavaLearning.JavaDojo;

import java.text.*;
import java.io.*;
import java.util.*;


public class LogHandler {

	public LogEntity getEntity(String logStr) {
		LogEntity logEntity = new LogEntity();

		logEntity.setIp(getIpFromString(logStr));

		logEntity.setRequestTime(getTimeFromString(logStr));
		
		logEntity.setRequestMethod(getMethod(logStr));

		logEntity.setRequestPath(getRequestPath(logStr));

		logEntity.setRequestVersion(getRequestVersion(logStr));

		logEntity.setRequestStatus(getStatus(logStr));

		logEntity.setRequestFromUrl(getUrl(logStr));
		
		logEntity.setTerminalInfor(getTerminalInforFromString(logStr));
		
		logEntity.setUpdateTime(new Date());

		return logEntity;
	}
	
	

	private String getTerminalInforFromString(String logStr) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[5]).toString();
		return str;
	}

	private String getUrl(String logStr) {
		String[] stringArray = logStr.split("\"");
		String url = new StringBuffer(stringArray[3]).toString();
		return url;
	}

	private String getStatus(String logStr) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[2]).toString();
		String[] strArray = str.split(" ");
		String requestStatus = new StringBuffer(strArray[1]).toString();
		return requestStatus;
	}

	private String getRequestVersion(String logStr) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String requestVersion = new StringBuffer(strArray[2]).toString();
		return requestVersion;
	}

	private String getRequestPath(String logStr) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String requestPath = new StringBuffer(strArray[1]).toString();
		return requestPath;
	}

	private String getMethod(String logStr) {
		String[] stringArray = logStr.split("\"");
		String str = new StringBuffer(stringArray[1]).toString();
		String[] strArray = str.split(" ");
		String method = new StringBuffer(strArray[0]).toString();
		return method;
	}

	private Date getTimeFromString(String logStr) {
		Date date = null;
		String time=logStr.split("\\[")[1].split("\\]")[0];		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
		try {
			date = dateFormat.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return date;
	}

	private String getIpFromString(String logStr) {
		String ip = logStr.split(" ")[0];
		return ip;
	}

	public BufferedReader getStringListFromPath(String path) throws IOException {
	
		if (path == null) {
			return null;
		}		 		
		FileReader	fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		return br;
		
	}

}
