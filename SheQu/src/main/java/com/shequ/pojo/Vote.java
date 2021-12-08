package com.shequ.pojo;

public class Vote {
    private String uid;
    private String title;
    private String text;
    private String optionCount;
    private String opt0;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    public Vote() {
    }

    public Vote(String uid, String title, String text, String optionCount, String opt0, String opt1, String opt2, String opt3, String opt4) {
        this.uid = uid;
        this.title = title;
        this.text = text;
        this.optionCount = optionCount;
        this.opt0 = opt0;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOptionCount() {
        return optionCount;
    }

    public void setOptionCount(String optionCount) {
        this.optionCount = optionCount;
    }

    public String getOpt0() {
        return opt0;
    }

    public void setOpt0(String opt0) {
        this.opt0 = opt0;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", optionCount='" + optionCount + '\'' +
                ", opt0='" + opt0 + '\'' +
                ", opt1='" + opt1 + '\'' +
                ", opt2='" + opt2 + '\'' +
                ", opt3='" + opt3 + '\'' +
                ", opt4='" + opt4 + '\'' +
                '}';
    }
}
