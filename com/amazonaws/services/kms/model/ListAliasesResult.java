package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class ListAliasesResult implements Serializable {
    private List<AliasListEntry> aliases = new ArrayList();
    private String nextMarker;
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
        if (obj == null || !(obj instanceof ListAliasesResult)) {
            return false;
        }
        ListAliasesResult listAliasesResult = (ListAliasesResult) obj;
        if (listAliasesResult.getAliases() == null) {
            z = true;
        } else {
            z = false;
        }
        if (getAliases() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (listAliasesResult.getAliases() != null && !listAliasesResult.getAliases().equals(getAliases())) {
            return false;
        }
        if (listAliasesResult.getNextMarker() == null) {
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
        if (listAliasesResult.getNextMarker() != null && !listAliasesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listAliasesResult.getTruncated() == null) {
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
        if (listAliasesResult.getTruncated() == null || listAliasesResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public List<AliasListEntry> getAliases() {
        return this.aliases;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int r1 = 0;
        if (getAliases() == null) {
            hashCode = 0;
        } else {
            hashCode = getAliases().hashCode();
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

    public void setAliases(Collection<AliasListEntry> collection) {
        if (collection == null) {
            this.aliases = null;
        } else {
            this.aliases = new ArrayList(collection);
        }
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAliases() != null) {
            sb.append("Aliases: " + getAliases() + ",");
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

    public ListAliasesResult withAliases(AliasListEntry... aliasListEntryArr) {
        if (getAliases() == null) {
            this.aliases = new ArrayList(aliasListEntryArr.length);
        }
        for (AliasListEntry aliasListEntry : aliasListEntryArr) {
            this.aliases.add(aliasListEntry);
        }
        return this;
    }

    public ListAliasesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListAliasesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListAliasesResult withAliases(Collection<AliasListEntry> collection) {
        setAliases(collection);
        return this;
    }
}
