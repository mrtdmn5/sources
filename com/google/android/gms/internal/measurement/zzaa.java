package com.google.android.gms.internal.measurement;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzaa {
    public String zza;
    public final long zzb;
    public final HashMap zzc;

    public zzaa(HashMap hashMap, String str, long j) {
        this.zza = str;
        this.zzb = j;
        HashMap hashMap2 = new HashMap();
        this.zzc = hashMap2;
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaa)) {
            return false;
        }
        zzaa zzaaVar = (zzaa) obj;
        if (this.zzb != zzaaVar.zzb || !this.zza.equals(zzaaVar.zza)) {
            return false;
        }
        return this.zzc.equals(zzaaVar.zzc);
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        long j = this.zzb;
        return this.zzc.hashCode() + ((hashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.zza;
        String obj = this.zzc.toString();
        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Event{name='", str, "', timestamp=");
        m.append(this.zzb);
        m.append(", params=");
        m.append(obj);
        m.append("}");
        return m.toString();
    }

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzaa clone() {
        return new zzaa(new HashMap(this.zzc), this.zza, this.zzb);
    }
}
