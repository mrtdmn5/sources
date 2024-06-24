package com.animaconnected.draganddrop.provider.model;

/* loaded from: classes.dex */
public class DragAndDropItem {
    private Object mData;
    protected Integer mId;
    private int mIndex;
    private int mType;

    public Object getData() {
        return this.mData;
    }

    public Integer getId() {
        return this.mId;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getType() {
        return this.mType;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setId(Integer num) {
        this.mId = num;
    }

    public void setIndex(int r1) {
        this.mIndex = r1;
    }

    public void setType(int r1) {
        this.mType = r1;
    }
}
