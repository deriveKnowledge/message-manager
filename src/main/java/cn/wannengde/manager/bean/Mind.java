package cn.wannengde.manager.bean;

import java.io.Serializable;

public class Mind implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer mindId;

    private Integer userId;

    private String mindTime;

    private String mindText;

    public Integer getMindId() {
        return mindId;
    }

    public void setMindId(Integer mindId) {
        this.mindId = mindId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMindTime() {
        return mindTime;
    }

    public void setMindTime(String mindTime) {
        this.mindTime = mindTime == null ? null : mindTime.trim();
    }

    public String getMindText() {
        return mindText;
    }

    public void setMindText(String mindText) {
        this.mindText = mindText == null ? null : mindText.trim();
    }
}