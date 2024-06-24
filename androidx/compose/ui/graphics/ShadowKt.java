package androidx.compose.ui.graphics;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import okio.Okio__OkioKt;

/* compiled from: Shadow.kt */
/* loaded from: classes.dex */
public final class ShadowKt {
    public static /* synthetic */ boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzc(int r1, int r2, int r3) {
        String zzd;
        if (r1 >= 0 && r2 >= r1 && r2 <= r3) {
            return;
        }
        if (r1 >= 0 && r1 <= r3) {
            if (r2 >= 0 && r2 <= r3) {
                zzd = Okio__OkioKt.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(r2), Integer.valueOf(r1));
            } else {
                zzd = zzd(r2, r3, "end index");
            }
        } else {
            zzd = zzd(r1, r3, "start index");
        }
        throw new IndexOutOfBoundsException(zzd);
    }

    public static String zzd(int r0, int r1, String str) {
        if (r0 < 0) {
            return Okio__OkioKt.zza("%s (%s) must not be negative", str, Integer.valueOf(r0));
        }
        if (r1 >= 0) {
            return Okio__OkioKt.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(r0), Integer.valueOf(r1));
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r1));
    }

    public static void zza(int r2, int r3) {
        String zza;
        if (r2 < 0 || r2 >= r3) {
            if (r2 < 0) {
                zza = Okio__OkioKt.zza("%s (%s) must not be negative", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2));
            } else {
                if (r3 < 0) {
                    throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r3));
                }
                zza = Okio__OkioKt.zza("%s (%s) must be less than size (%s)", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2), Integer.valueOf(r3));
            }
            throw new IndexOutOfBoundsException(zza);
        }
    }
}
