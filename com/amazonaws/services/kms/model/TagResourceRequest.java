package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class TagResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private List<Tag> tags = new ArrayList();

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TagResourceRequest)) {
            return false;
        }
        TagResourceRequest tagResourceRequest = (TagResourceRequest) obj;
        if (tagResourceRequest.getKeyId() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getKeyId() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (tagResourceRequest.getKeyId() != null && !tagResourceRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (tagResourceRequest.getTags() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (getTags() == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (tagResourceRequest.getTags() == null || tagResourceRequest.getTags().equals(getTags())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode;
        int r1 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int r0 = (hashCode + 31) * 31;
        if (getTags() != null) {
            r1 = getTags().hashCode();
        }
        return r0 + r1;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getTags() != null) {
            sb.append("Tags: " + getTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public TagResourceRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public TagResourceRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public TagResourceRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
