package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzox;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzdc implements zzdq {
    public static final /* synthetic */ zzdc zza = new zzdc();

    /* renamed from: toString-impl */
    public static String m1642toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Blocking";
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Optional";
        }
        if (r3 == 2) {
            z3 = true;
        }
        if (z3) {
            return "Async";
        }
        return "Invalid(value=" + r3 + ')';
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzox.zza.zza().zzb());
    }
}
