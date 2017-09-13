package JavaLearning.JavaDojo;

import java.util.*;
public class LogEntity {

	private String ip;
	private Date requestTime;
	private String requestMethod;
	private String requestPath;
	private String requestVersion;
	private String requestStatus;
	private String requestFromUrl;
	private String terminalInfor;
	private Date updateTime;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getRequestPath() {
		return requestPath;
	}
	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
	public String getRequestVersion() {
		return requestVersion;
	}
	public void setRequestVersion(String requestVersion) {
		this.requestVersion = requestVersion;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestFromUrl() {
		return requestFromUrl;
	}
	public void setRequestFromUrl(String requestFromUrl) {
		this.requestFromUrl = requestFromUrl;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getTerminalInfor() {
		return terminalInfor;
	}
	public void setTerminalInfor(String terminalInfor) {
		this.terminalInfor = terminalInfor;
	}
	

}
