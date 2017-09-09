package JavaLearning.JavaDojo;

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
	}

}
