package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Tag implements Serializable {
    private String key;
    private String value;

    public Tag(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tag tag = (Tag) obj;
        String str = this.key;
        if (str == null ? tag.key != null : !str.equals(tag.key)) {
            return false;
        }
        String str2 = this.value;
        String str3 = tag.value;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int r0;
        String str = this.key;
        int r1 = 0;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        String str2 = this.value;
        if (str2 != null) {
            r1 = str2.hashCode();
        }
        return r02 + r1;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Tag withKey(String str) {
        setKey(str);
        return this;
    }

    public Tag withValue(String str) {
        setValue(str);
        return this;
    }
}
