package com.google.common.base;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ActualAndroid_androidKt;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.animaconnected.firebase.AnalyticsConstants;
import okhttp3.internal._HostnamesJvmKt;

/* loaded from: classes3.dex */
public final class Objects {
    public static final ParcelableSnapshotMutableFloatState mutableFloatStateOf(float f) {
        int r0 = ActualAndroid_androidKt.$r8$clinit;
        return new ParcelableSnapshotMutableFloatState(f);
    }

    public static void zza(int r2, int r3) {
        String zza;
        if (r2 >= 0 && r2 < r3) {
            return;
        }
        if (r2 >= 0) {
            if (r3 < 0) {
                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r3));
            }
            zza = _HostnamesJvmKt.zza("%s (%s) must be less than size (%s)", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2), Integer.valueOf(r3));
        } else {
            zza = _HostnamesJvmKt.zza("%s (%s) must not be negative", AnalyticsConstants.KEY_INDEX, Integer.valueOf(r2));
        }
        throw new IndexOutOfBoundsException(zza);
    }

    public static void zzc(int r1, int r2, int r3) {
        String zzd;
        if (r1 >= 0 && r2 >= r1 && r2 <= r3) {
            return;
        }
        if (r1 >= 0 && r1 <= r3) {
            if (r2 >= 0 && r2 <= r3) {
                zzd = _HostnamesJvmKt.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(r2), Integer.valueOf(r1));
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
            return _HostnamesJvmKt.zza("%s (%s) must not be negative", str, Integer.valueOf(r0));
        }
        if (r1 >= 0) {
            return _HostnamesJvmKt.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(r0), Integer.valueOf(r1));
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("negative size: ", r1));
    }
}
