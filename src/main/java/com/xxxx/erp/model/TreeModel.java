package com.xxxx.erp.model;

public class TreeModel {

    private Integer menuId;
    private Integer pId;
    private String name;
    private boolean checked = false;

    public Integer getId() {
        return menuId;
    }

    public void setId(Integer id) {
        this.menuId = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
