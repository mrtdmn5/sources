package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzeh extends zzgl {
    public char zza;
    public long zzb;
    public String zzc;
    public final zzef zzd;
    public final zzef zze;
    public final zzef zzf;
    public final zzef zzg;
    public final zzef zzh;
    public final zzef zzi;
    public final zzef zzj;
    public final zzef zzk;
    public final zzef zzl;

    public zzeh(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzef(this, 6, false, false);
        this.zze = new zzef(this, 6, true, false);
        this.zzf = new zzef(this, 6, false, true);
        this.zzg = new zzef(this, 5, false, false);
        this.zzh = new zzef(this, 5, true, false);
        this.zzi = new zzef(this, 5, false, true);
        this.zzj = new zzef(this, 4, false, false);
        this.zzk = new zzef(this, 3, false, false);
        this.zzl = new zzef(this, 2, false, false);
    }

    public static zzeg zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzeg(str);
    }

    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String zzp = zzp(obj, z);
        String zzp2 = zzp(obj2, z);
        String zzp3 = zzp(obj3, z);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    public static String zzp(Object obj, boolean z) {
        String th;
        String className;
        String str = "";
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            if (obj.toString().charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, valueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            if (z) {
                th = th2.getClass().getName();
            } else {
                th = th2.toString();
            }
            StringBuilder sb = new StringBuilder(th);
            String canonicalName = zzfr.class.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName)) {
                canonicalName = "";
            } else {
                int lastIndexOf = canonicalName.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    canonicalName = canonicalName.substring(0, lastIndexOf);
                }
            }
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            int r6 = 0;
            while (true) {
                if (r6 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[r6];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    if (TextUtils.isEmpty(className)) {
                        className = "";
                    } else {
                        int lastIndexOf2 = className.lastIndexOf(46);
                        if (lastIndexOf2 != -1) {
                            className = className.substring(0, lastIndexOf2);
                        }
                    }
                    if (className.equals(canonicalName)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                        break;
                    }
                }
                r6++;
            }
            return sb.toString();
        }
        if (obj instanceof zzeg) {
            return ((zzeg) obj).zza;
        }
        if (z) {
            return "-";
        }
        return obj.toString();
    }

    public final zzef zzc() {
        return this.zzk;
    }

    public final zzef zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zzf() {
        return false;
    }

    public final zzef zzj() {
        return this.zzl;
    }

    public final zzef zzk() {
        return this.zzg;
    }

    public final zzef zzl() {
        return this.zzi;
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    public final String zzq() {
        String str;
        synchronized (this) {
            try {
                if (this.zzc == null) {
                    zzfr zzfrVar = this.zzt;
                    String str2 = zzfrVar.zzh;
                    if (str2 != null) {
                        this.zzc = str2;
                    } else {
                        zzfrVar.zzk.zzt.getClass();
                        this.zzc = "FA";
                    }
                }
                Preconditions.checkNotNull(this.zzc);
                str = this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void zzt(int r8, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzq(), r8)) {
            Log.println(r8, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z2 && r8 >= 5) {
            Preconditions.checkNotNull(str);
            zzfo zzfoVar = this.zzt.zzn;
            if (zzfoVar == null) {
                Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
            } else {
                if (!zzfoVar.zza) {
                    Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
                    return;
                }
                if (r8 >= 9) {
                    r8 = 8;
                }
                zzfoVar.zzp(new zzee(this, r8, str, obj, obj2, obj3));
            }
        }
    }
}
