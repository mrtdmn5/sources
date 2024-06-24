package com.google.android.gms.internal.measurement;

import com.animaconnected.secondo.screens.settings.WatchSettingsFragment;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmy {
    public static final long zza;
    public static final boolean zzb;
    public static final Unsafe zzc;
    public static final Class zzd;
    public static final zzmx zzf;
    public static final boolean zzg;
    public static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    static {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzmy.<clinit>():void");
    }

    public static void zzA(Class cls) {
        if (zzh) {
            zzf.zzi(cls);
        }
    }

    public static Field zzB() {
        Field field;
        Field field2;
        int r1 = zziq.$r8$clinit;
        try {
            field = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            field = null;
        }
        if (field == null) {
            try {
                field2 = Buffer.class.getDeclaredField(WatchSettingsFragment.addressBundleKey);
            } catch (Throwable unused2) {
                field2 = null;
            }
            if (field2 == null || field2.getType() != Long.TYPE) {
                return null;
            }
            return field2;
        }
        return field;
    }

    public static void zzD(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzmx zzmxVar = zzf;
        int zzj = zzmxVar.zzj(j2, obj);
        int r6 = ((~((int) j)) & 3) << 3;
        zzmxVar.zzn(j2, ((255 & b) << r6) | (zzj & (~(255 << r6))), obj);
    }

    public static void zzE(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzmx zzmxVar = zzf;
        int r6 = (((int) j) & 3) << 3;
        zzmxVar.zzn(j2, ((255 & b) << r6) | (zzmxVar.zzj(j2, obj) & (~(255 << r6))), obj);
    }

    public static double zza(long j, Object obj) {
        return zzf.zza(j, obj);
    }

    public static float zzb(long j, Object obj) {
        return zzf.zzb(j, obj);
    }

    public static int zzc(long j, Object obj) {
        return zzf.zzj(j, obj);
    }

    public static long zzd(long j, Object obj) {
        return zzf.zzk(j, obj);
    }

    public static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(long j, Object obj) {
        return zzf.zzm(j, obj);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzmu());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzmy.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void zzm(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzo(Object obj, long j, double d) {
        zzf.zze(obj, j, d);
    }

    public static void zzp(Object obj, long j, float f) {
        zzf.zzf(obj, j, f);
    }

    public static void zzq(long j, int r3, Object obj) {
        zzf.zzn(j, r3, obj);
    }

    public static void zzs(long j, Object obj, Object obj2) {
        zzf.zzp(j, obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzv(Class cls) {
        int r1 = zziq.$r8$clinit;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzw(long j, Object obj) {
        return zzf.zzg(j, obj);
    }

    public static int zzz(Class cls) {
        if (zzh) {
            return zzf.zzh(cls);
        }
        return -1;
    }
}
