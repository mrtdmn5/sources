package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class TaskApiCall<A, ResultT> {
    public final Feature[] zaa;
    public final boolean zab;
    public final int zac;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class Builder<A, ResultT> {
        public RemoteCall zaa;
        public Feature[] zac;
        public boolean zab = true;
        public int zad = 0;
    }

    public TaskApiCall(Feature[] featureArr, boolean z, int r4) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = r4;
    }
}
