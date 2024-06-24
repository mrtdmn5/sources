package com.google.android.gms.internal.measurement;

import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzme implements Map.Entry, Comparable {
    public final /* synthetic */ zzmk zza;
    public final Comparable zzb;
    public Object zzc;

    public zzme(zzmk zzmkVar, Comparable comparable, Object obj) {
        this.zza = zzmkVar;
        this.zzb = comparable;
        this.zzc = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzme) obj).zzb);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Comparable comparable = this.zzb;
        if (comparable == null) {
            if (key != null) {
                equals = false;
            } else {
                equals = true;
            }
        } else {
            equals = comparable.equals(key);
        }
        if (equals) {
            Object obj2 = this.zzc;
            Object value = entry.getValue();
            if (obj2 == null) {
                if (value != null) {
                    equals2 = false;
                } else {
                    equals2 = true;
                }
            } else {
                equals2 = obj2.equals(value);
            }
            if (equals2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzb;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzc;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        Comparable comparable = this.zzb;
        if (comparable == null) {
            hashCode = 0;
        } else {
            hashCode = comparable.hashCode();
        }
        Object obj = this.zzc;
        if (obj != null) {
            r0 = obj.hashCode();
        }
        return r0 ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        int r0 = zzmk.$r8$clinit;
        this.zza.zzn();
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    public final String toString() {
        return AbstractResolvableFuture$$ExternalSyntheticOutline0.m(String.valueOf(this.zzb), "=", String.valueOf(this.zzc));
    }
}
