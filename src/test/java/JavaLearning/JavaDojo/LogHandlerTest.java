package JavaLearning.JavaDojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class LogHandlerTest extends TestCase {
	private LogHandler logHandler;
	protected void setUp() throws Exception {
		logHandler = new LogHandler();
		super.setUp();
	}

	public void testGetEntity() {
		String logStr = "183.193.187.122 - - [24/Dec/2016:00:13:14 +0800] \"POST /socket.io/?EIO=3&transport=polling&j=12&t=LaiTH9P&b64=1&sid=rWxYshIVfGqzC15yAAEV HTTP/1.1\" 200 2 \"http://pmchat.24k.hk/studio?utm_source=pn14&utm_medium=ag&utm_campaign=yy&utm_content=AD_pcuiZS_top\" \"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)\"";
		LogEntity logEntity = logHandler.getEntity(logStr);
	    assertEquals(logEntity.getIp(), "183.193.187.122");
	    
	    Date reqTime = logEntity.getRequestTime();
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(reqTime);
	    assertEquals(cal.get(Calendar.DATE), 24);
	    assertEquals(cal.get(Calendar.MONTH), 11);
	    assertEquals(cal.get(Calendar.YEAR), 2016);
	    assertEquals(cal.get(Calendar.HOUR_OF_DAY), 0);
	    assertEquals(cal.get(Calendar.MINUTE), 13);
	    assertEquals(cal.get(Calendar.SECOND), 14);
	    assertEquals(cal.get(Calendar.ZONE_OFFSET), 8 * 3600 * 1000);
	    
	    String method = logEntity.getRequestMethod();
	    assertEquals(method, "POST");
	    
	    String requestPath = logEntity.getRequestPath();
	    assertEquals(requestPath, "/socket.io/?EIO=3&transport=polling&j=12&t=LaiTH9P&b64=1&sid=rWxYshIVfGqzC15yAAEV");
		
	    String requestVersion = logEntity.getRequestVersion();
	    assertEquals(requestVersion, "HTTP/1.1");
		
            String requestStatus = logEntity.getRequestStatus();
	    assertEquals(requestStatus, "200");
		
	    String requestFromUrl = logEntity.getRequestFromUrl();
	    assertEquals(requestFromUrl, "http://pmchat.24k.hk/studio?utm_source=pn14&utm_medium=ag&utm_campaign=yy&utm_content=AD_pcuiZS_top");
		
	    String terminalName = logEntity.getTerminalName();
	    assertEquals(terminalName, "Mozilla");
		
	    String terminalVersion = logEntity.getTerminalVersion();
	    assertEquals(terminalVersion, "5.0");
		
	    String terminalDescription = logEntity.getTerminalDescription();
	    assertEquals(terminalDescription, "(compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
	}

}
