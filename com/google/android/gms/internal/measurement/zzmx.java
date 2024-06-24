package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzmx {
    public final Unsafe zza;

    public zzmx(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(long j, Object obj);

    public abstract float zzb(long j, Object obj);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract void zzd(Object obj, long j, byte b);

    public abstract void zze(Object obj, long j, double d);

    public abstract void zzf(Object obj, long j, float f);

    public abstract boolean zzg(long j, Object obj);

    public final int zzh(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzi(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzj(long j, Object obj) {
        return this.zza.getInt(obj, j);
    }

    public final long zzk(long j, Object obj) {
        return this.zza.getLong(obj, j);
    }

    public final void zzl(Field field) {
        this.zza.objectFieldOffset(field);
    }

    public final Object zzm(long j, Object obj) {
        return this.zza.getObject(obj, j);
    }

    public final void zzn(long j, int r4, Object obj) {
        this.zza.putInt(obj, j, r4);
    }

    public final void zzo(Object obj, long j, long j2) {
        this.zza.putLong(obj, j, j2);
    }

    public final void zzp(long j, Object obj, Object obj2) {
        this.zza.putObject(obj, j, obj2);
    }
}
