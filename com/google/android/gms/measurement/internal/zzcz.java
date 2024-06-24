package com.google.android.gms.measurement.internal;

import androidx.compose.ui.text.font.FontWeight;
import com.google.android.gms.internal.measurement.zzpd;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzcz implements zzdq {
    public static final /* synthetic */ zzcz zza = new zzcz();

    /* renamed from: getAndroidTypefaceStyle-FO1MlWM */
    public static final int m1641getAndroidTypefaceStyleFO1MlWM(FontWeight fontWeight, int r3) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        if (fontWeight.compareTo(FontWeight.W600) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        if (!z2) {
            return 0;
        }
        return 2;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzpd.zza.zza().zzc());
    }
}
