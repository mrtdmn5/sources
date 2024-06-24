package com.google.android.gms.common.internal;

import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zal {
    public final SparseIntArray zaa;
    public final GoogleApiAvailabilityLight zab;

    public zal() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zaa = new SparseIntArray();
        this.zab = googleApiAvailability;
    }
}
