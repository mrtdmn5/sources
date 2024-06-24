package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import java.util.Map;

/* loaded from: classes3.dex */
public final class CacheEntry implements Map.Entry<String, DeviceComponent> {
    public final DeviceComponentWeakReference deviceComponentWeakReference;
    public final String string;

    public CacheEntry(String str, DeviceComponentWeakReference deviceComponentWeakReference) {
        this.string = str;
        this.deviceComponentWeakReference = deviceComponentWeakReference;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheEntry)) {
            return false;
        }
        CacheEntry cacheEntry = (CacheEntry) obj;
        if (this.string.equals(cacheEntry.string) && this.deviceComponentWeakReference.equals(cacheEntry.deviceComponentWeakReference)) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final String getKey() {
        return this.string;
    }

    @Override // java.util.Map.Entry
    public final DeviceComponent getValue() {
        return this.deviceComponentWeakReference.get();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.deviceComponentWeakReference.hashCode() + (this.string.hashCode() * 31);
    }

    @Override // java.util.Map.Entry
    public final DeviceComponent setValue(DeviceComponent deviceComponent) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
