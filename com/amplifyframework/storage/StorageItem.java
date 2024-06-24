package com.amplifyframework.storage;

import androidx.core.util.ObjectsCompat$Api19Impl;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.Date;

/* loaded from: classes.dex */
public final class StorageItem {
    private final String eTag;
    private final String key;
    private final Date lastModified;
    private final Object pluginResults;
    private final long size;

    public StorageItem(String str, long j, Date date, String str2, Object obj) {
        this.key = str;
        this.size = j;
        this.lastModified = date;
        this.eTag = str2;
        this.pluginResults = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageItem)) {
            return false;
        }
        StorageItem storageItem = (StorageItem) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.key, storageItem.key) || this.size != storageItem.size || !ObjectsCompat$Api19Impl.equals(this.lastModified, storageItem.lastModified) || !ObjectsCompat$Api19Impl.equals(this.eTag, storageItem.eTag)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.pluginResults, storageItem.pluginResults);
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public Object getPluginResults() {
        return this.pluginResults;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        int r1;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.eTag, (this.lastModified.hashCode() + (((this.key.hashCode() * 31) + ((int) this.size)) * 31)) * 31, 31);
        Object obj = this.pluginResults;
        if (obj != null) {
            r1 = obj.hashCode();
        } else {
            r1 = 0;
        }
        return m + r1;
    }

    public String toString() {
        return "StorageItem{key='" + this.key + "', size=" + this.size + ", lastModified=" + this.lastModified.toString() + ", eTag='" + this.eTag + "', pluginResults=" + this.pluginResults + '}';
    }
}
