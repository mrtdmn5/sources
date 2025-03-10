package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zam {
    public final int zaa;
    public final ConnectionResult zab;

    public zam(ConnectionResult connectionResult, int r2) {
        Preconditions.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = r2;
    }
}
