package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zznn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzdn implements zzdq {
    public static final /* synthetic */ zzdn zza = new zzdn();

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1645toStringimpl(int r3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "None";
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Characters";
        }
        if (r3 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Words";
        }
        if (r3 == 3) {
            z4 = true;
        }
        if (z4) {
            return "Sentences";
        }
        return "Invalid";
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return zznn.zza.zza().zzJ();
    }
}
