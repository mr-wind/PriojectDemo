package com.example.mr_wind.priojectdemo.views.recycler;

/**
 * Created by mr_wind on 2016/8/1.
 */
public class SampleModel {
    private int mId;
    private String mName;
    private String mText;
    private boolean mIsChecked;

    public SampleModel(String text) {
        mText = text;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public boolean isChecked() {
        return mIsChecked;
    }

    public void setChecked(boolean checked) {
        mIsChecked = checked;
    }

}
