package com.sovon9.ActivityService;

public class Udp {
    private Long id;
    private String desc;
    private String value;
    private Long activityId;

    public Udp(Long id, String desc, String value) {
        this.id = id;
        this.desc = desc;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
