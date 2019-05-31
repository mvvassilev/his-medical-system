package com.neuedu.hismedicalsystem.model.po;

public class Rule {
    private int ruleid;
    private String rulename;
    private String deptname;
    private String username;
    private String timecode;
    private String reglevel;
    private int ration;
    private int uRid;

    public int getRuleid() {
        return ruleid;
    }

    public void setRuleid(int ruleid) { this.ruleid = ruleid; }

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

    public String getTimecode() {
        return timecode;
    }

    public void setTimecode(String timecode) {
        this.timecode = timecode;
    }

    public String getReglevel() {
        return reglevel;
    }

    public void setReglevel(String reglevel) {
        this.reglevel = reglevel;
    }

    public int getRation() {
        return ration;
    }

    public void setRation(int ration) {
        this.ration = ration;
    }

    public int getuRid() {
        return uRid;
    }

    public void setuRid(int uRid) {
        this.uRid = uRid;
    }
}
