package com.neuedu.hismedicalsystem.model.po;

public class Rule {
    private int ruleid;
    private String rulename;
    private String deptname;
    private String username;
    private long timecode;

    public int getRuleid() {
        return ruleid;
    }

    public void setRuleid(int ruleid) {
        this.ruleid = ruleid;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTimecode() {
        return timecode;
    }

    public void setTimecode(long timecode) {
        this.timecode = timecode;
    }
}
