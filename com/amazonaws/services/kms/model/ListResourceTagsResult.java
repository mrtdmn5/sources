package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListResourceTagsResult implements Serializable {
    private String nextMarker;
    private List<Tag> tags = new ArrayList();
    private Boolean truncated;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceTagsResult)) {
            return false;
        }
        ListResourceTagsResult listResourceTagsResult = (ListResourceTagsResult) obj;
        if (listResourceTagsResult.getTags() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getTags() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listResourceTagsResult.getTags() != null && !listResourceTagsResult.getTags().equals(getTags())) {
            return false;
        }
        if (listResourceTagsResult.getNextMarker() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getNextMarker() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (listResourceTagsResult.getNextMarker() != null && !listResourceTagsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listResourceTagsResult.getTruncated() == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (getTruncated() == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (listResourceTagsResult.getTruncated() == null || listResourceTagsResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getTags() == null) {
            hashCode = 0;
        } else {
            hashCode = getTags().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getNextMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNextMarker().hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        if (getTruncated() != null) {
            r1 = getTruncated().hashCode();
        }
        return r02 + r1;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListResourceTagsResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListResourceTagsResult withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public ListResourceTagsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListResourceTagsResult withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
