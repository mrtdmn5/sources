package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgq;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzc {
    public static final HashSet zza = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
    public static final List zzb = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    public static final List zzc = Arrays.asList("auto", "app", "am");
    public static final List zzd = Arrays.asList("_r", "_dbg");
    public static final List zze;
    public static final List zzf;

    static {
        String[][] strArr = {zzgq.zza, zzgq.zzb};
        int r5 = 0;
        for (int r2 = 0; r2 < 2; r2++) {
            r5 += strArr[r2].length;
        }
        Object[] copyOf = Arrays.copyOf(strArr[0], r5);
        int length = strArr[0].length;
        String[] strArr2 = strArr[1];
        System.arraycopy(strArr2, 0, copyOf, length, strArr2.length);
        zze = Arrays.asList((String[]) copyOf);
        zzf = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean zzh(String str, String str2, Bundle bundle) {
        char c;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzl(str) || bundle == null) {
            return false;
        }
        Iterator it = zzd.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey((String) it.next())) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals("fiam")) {
                    c = 2;
                }
                c = 65535;
            } else {
                if (str.equals("fdl")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (str.equals("fcm")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    return false;
                }
                bundle.putString("_cis", "fiam_integration");
                return true;
            }
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        bundle.putString("_cis", "fcm_integration");
        return true;
    }

    public static boolean zzj(Bundle bundle, String str) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle != null) {
            Iterator it = zzd.iterator();
            while (it.hasNext()) {
                if (bundle.containsKey((String) it.next())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean zzl(String str) {
        if (!zzc.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzm(String str, String str2) {
        if (!"_ce1".equals(str2) && !"_ce2".equals(str2)) {
            if ("_ln".equals(str2)) {
                if (str.equals("fcm") || str.equals("fiam")) {
                    return true;
                }
                return false;
            }
            if (zze.contains(str2)) {
                return false;
            }
            Iterator it = zzf.iterator();
            while (it.hasNext()) {
                if (str2.matches((String) it.next())) {
                    return false;
                }
            }
            return true;
        }
        if (str.equals("fcm") || str.equals("frc")) {
            return true;
        }
        return false;
    }
}
