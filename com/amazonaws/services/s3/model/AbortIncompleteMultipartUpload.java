package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class AbortIncompleteMultipartUpload implements Serializable {
    private int daysAfterInitiation;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.daysAfterInitiation == ((AbortIncompleteMultipartUpload) obj).daysAfterInitiation) {
            return true;
        }
        return false;
    }

    public int getDaysAfterInitiation() {
        return this.daysAfterInitiation;
    }

    public int hashCode() {
        return this.daysAfterInitiation;
    }

    public void setDaysAfterInitiation(int r1) {
        this.daysAfterInitiation = r1;
    }

    public AbortIncompleteMultipartUpload withDaysAfterInitiation(int r1) {
        setDaysAfterInitiation(r1);
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AbortIncompleteMultipartUpload m623clone() throws CloneNotSupportedException {
        try {
            return (AbortIncompleteMultipartUpload) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}
