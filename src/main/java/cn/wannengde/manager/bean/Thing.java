package cn.wannengde.manager.bean;

import java.io.Serializable;

public class Thing implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer thingId;

    private String thingTitle;

    private String thingText;

    private Integer timeType;

    private String thingTime;

    private Integer alertNum;

    private Integer userId;
    
    

    public Thing() {
		super();
	}

	public Thing(String thingTitle, String thingText, Integer timeType, String thingTime, Integer alertNum,
			Integer userId) {
		super();
		this.thingTitle = thingTitle;
		this.thingText = thingText;
		this.timeType = timeType;
		this.thingTime = thingTime;
		this.alertNum = alertNum;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Thing [thingId=" + thingId + ", thingTitle=" + thingTitle + ", thingText=" + thingText + ", timeType="
				+ timeType + ", thingTime=" + thingTime + ", alertNum=" + alertNum + ", userId=" + userId + "]";
	}

	public Integer getThingId() {
        return thingId;
    }

    public void setThingId(Integer thingId) {
        this.thingId = thingId;
    }

    public String getThingTitle() {
        return thingTitle;
    }

    public void setThingTitle(String thingTitle) {
        this.thingTitle = thingTitle == null ? null : thingTitle.trim();
    }

    public String getThingText() {
        return thingText;
    }

    public void setThingText(String thingText) {
        this.thingText = thingText == null ? null : thingText.trim();
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public String getThingTime() {
        return thingTime;
    }

    public void setThingTime(String thingTime) {
        this.thingTime = thingTime == null ? null : thingTime.trim();
    }

    public Integer getAlertNum() {
        return alertNum;
    }

    public void setAlertNum(Integer alertNum) {
        this.alertNum = alertNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}