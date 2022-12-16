package com.xxxx.erp.query;

import com.xxxx.erp.base.BaseQuery;

public class UserQuery extends BaseQuery {
    private String userName;

    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
