package com.wang.model;

import lombok.Data;

@Data
public class QueryCustomerListCase {
    private int caseId;
    private String custCategory;
    private String device;
    private String lendState;
    private String pageSize;
    private String pageNum;
    private String secondCategory;
    private String userName;
    private String ver;
    private String expected;


    public String getExpected() {
        return expected;
    }


    public void setExpected(String expected) {
        this.expected = expected;
    }


    public int getCaseId() {
        return caseId;
    }


    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }


    public String getCustCategory() {
        return custCategory;
    }


    public void setCustCategory(String custCategory) {
        this.custCategory = custCategory;
    }


    public String getDevice() {
        return device;
    }


    public void setDevice(String device) {
        this.device = device;
    }


    public String getLendState() {
        return lendState;
    }


    public void setLendState(String lendState) {
        this.lendState = lendState;
    }


    public String getPageSize() {
        return pageSize;
    }


    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }


    public String getPageNum() {
        return pageNum;
    }


    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }


    public String getSecondCategory() {
        return secondCategory;
    }


    public void setSecondCategory(String secondCategory) {
        this.secondCategory = secondCategory;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getVer() {
        return ver;
    }


    public void setVer(String ver) {
        this.ver = ver;
    }


    @Override
    public String toString() {
        return (
                "{caseId:" + caseId + "," +
                        "custCategory:" + custCategory + "," +
                        "device:" + device + "," +
                        "lendState:" + lendState + "," +
                        "pageSize:" + pageSize +
                        "pageNum:" + pageNum +
                        "secondCategory:" + secondCategory +
                        "userName:" + userName +
                        "ver:" + ver +
                        "}");
    }

}
