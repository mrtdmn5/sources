package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class PendingResult<R extends Result> {

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface StatusListener {
        void onComplete(Status status);
    }
}
