package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ListTagsForResourceResult implements Serializable {
    private Map<String, String> tags;

    public ListTagsForResourceResult addTagsEntry(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        if (!this.tags.containsKey(str)) {
            this.tags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException(CreateIdentityPoolRequest$$ExternalSyntheticOutline0.m(str, new StringBuilder("Duplicated keys ("), ") are provided."));
    }

    public ListTagsForResourceResult clearTagsEntries() {
        this.tags = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTagsForResourceResult)) {
            return false;
        }
        ListTagsForResourceResult listTagsForResourceResult = (ListTagsForResourceResult) obj;
        if (listTagsForResourceResult.getTags() == null) {
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
        if (listTagsForResourceResult.getTags() == null || listTagsForResourceResult.getTags().equals(getTags())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode;
        if (getTags() == null) {
            hashCode = 0;
        } else {
            hashCode = getTags().hashCode();
        }
        return 31 + hashCode;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTags() != null) {
            sb.append("Tags: " + getTags());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListTagsForResourceResult withTags(Map<String, String> map) {
        this.tags = map;
        return this;
    }
}
