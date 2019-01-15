package com.wang.model;


public class UserLoginCase {
    private String caseId;
    private String chanelStyle;
    private String username;
    private String pwd;
    private String ver;
    private String device;
    private String expected;

    public String getChanelStyle() {
        return chanelStyle;
    }

    public void setChanelStyle(String chanelStyle) {
        this.chanelStyle = chanelStyle;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
    public String toString() {
        return (
                "{caseId:" + caseId + "," +
                        "chanelStyle:" + chanelStyle + "," +
                        "username:" + username + "," +
                        "pwd:" + pwd + "," +
                        "expected:" + expected + "}");
    }
}
