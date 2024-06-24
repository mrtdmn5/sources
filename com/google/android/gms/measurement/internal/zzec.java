package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzec {
    public static final AtomicReference zza = new AtomicReference();
    public static final AtomicReference zzb = new AtomicReference();
    public static final AtomicReference zzc = new AtomicReference();
    public final zzgt zzd;

    public zzec(zzgt zzgtVar) {
        this.zzd = zzgtVar;
    }

    public static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        boolean z;
        String str2;
        Preconditions.checkNotNull(atomicReference);
        if (strArr.length == strArr2.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int r2 = 0; r2 < strArr.length; r2++) {
            Object obj = strArr[r2];
            if (str == obj || str.equals(obj)) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[r2];
                    if (str2 == null) {
                        str2 = strArr2[r2] + "(" + strArr[r2] + ")";
                        strArr3[r2] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(Object[] objArr) {
        String valueOf;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                valueOf = zzb((Bundle) obj);
            } else {
                valueOf = String.valueOf(obj);
            }
            if (valueOf != null) {
                if (m.length() != 1) {
                    m.append(", ");
                }
                m.append(valueOf);
            }
        }
        m.append("]");
        return m.toString();
    }

    public final String zzb(Bundle bundle) {
        String valueOf;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("Bundle[{");
        for (String str : bundle.keySet()) {
            if (m.length() != 8) {
                m.append(", ");
            }
            m.append(zze(str));
            m.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                valueOf = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                valueOf = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                valueOf = zza(((ArrayList) obj).toArray());
            } else {
                valueOf = String.valueOf(obj);
            }
            m.append(valueOf);
        }
        m.append("}]");
        return m.toString();
    }

    public final String zzc(zzaw zzawVar) {
        String zzb2;
        zzgt zzgtVar = this.zzd;
        if (!zzgtVar.zza()) {
            return zzawVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(zzawVar.zzc);
        sb.append(",name=");
        sb.append(zzd(zzawVar.zza));
        sb.append(",params=");
        zzau zzauVar = zzawVar.zzb;
        if (zzauVar == null) {
            zzb2 = null;
        } else if (!zzgtVar.zza()) {
            zzb2 = zzauVar.toString();
        } else {
            zzb2 = zzb(zzauVar.zzc());
        }
        sb.append(zzb2);
        return sb.toString();
    }

    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzgo.zzc, zzgo.zza, zza);
    }

    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzgp.zzb, zzgp.zza, zzb);
    }

    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return zzav$$ExternalSyntheticOutline0.m("experiment_id(", str, ")");
        }
        return zzg(str, zzgq.zzb, zzgq.zza, zzc);
    }
}
