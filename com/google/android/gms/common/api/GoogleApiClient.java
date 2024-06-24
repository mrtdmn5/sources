package com.google.android.gms.common.api;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public abstract class GoogleApiClient {
    public static final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    @Deprecated
    /* loaded from: classes3.dex */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    @Deprecated
    /* loaded from: classes3.dex */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }
}
