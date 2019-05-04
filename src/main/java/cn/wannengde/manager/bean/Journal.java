package cn.wannengde.manager.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Journal implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer journalId;

    private Integer userId;

    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")
    private Date journalTime;

    private String journalWeek;

    private Integer journalWeather;

    private String journalText;

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getJournalTime() {
        return journalTime;
    }

    public void setJournalTime(Date journalTime) {
        this.journalTime = journalTime;
    }

    public String getJournalWeek() {
        return journalWeek;
    }

    public void setJournalWeek(String journalWeek) {
        this.journalWeek = journalWeek == null ? null : journalWeek.trim();
    }

    public Integer getJournalWeather() {
        return journalWeather;
    }

    public void setJournalWeather(Integer journalWeather) {
        this.journalWeather = journalWeather;
    }

    public String getJournalText() {
        return journalText;
    }

    public void setJournalText(String journalText) {
        this.journalText = journalText == null ? null : journalText.trim();
    }
}