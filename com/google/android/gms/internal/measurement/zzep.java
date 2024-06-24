package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzep implements zzkj {
    public static final zzep zza = new zzep();

    @Override // com.google.android.gms.internal.measurement.zzkj
    public final boolean zza(int r5) {
        char c;
        if (r5 != 0) {
            c = 2;
            if (r5 != 1) {
                if (r5 != 2) {
                    c = 4;
                    if (r5 != 3) {
                        if (r5 != 4) {
                            c = 0;
                        } else {
                            c = 5;
                        }
                    }
                } else {
                    c = 3;
                }
            }
        } else {
            c = 1;
        }
        if (c == 0) {
            return false;
        }
        return true;
    }
}
