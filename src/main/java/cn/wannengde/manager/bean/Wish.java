package cn.wannengde.manager.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Wish {
    private Integer wishId;

    private Integer userId;

    private String wishTitle;

    private String wishText;

    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")
    private Date wishOverTime;

    private Integer wishStatus;

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWishTitle() {
        return wishTitle;
    }

    public void setWishTitle(String wishTitle) {
        this.wishTitle = wishTitle == null ? null : wishTitle.trim();
    }

    public String getWishText() {
        return wishText;
    }

    public void setWishText(String wishText) {
        this.wishText = wishText == null ? null : wishText.trim();
    }

    public Date getWishOverTime() {
        return wishOverTime;
    }

    public void setWishOverTime(Date wishOverTime) {
        this.wishOverTime = wishOverTime;
    }

    public Integer getWishStatus() {
        return wishStatus;
    }

    public void setWishStatus(Integer wishStatus) {
        this.wishStatus = wishStatus;
    }
}