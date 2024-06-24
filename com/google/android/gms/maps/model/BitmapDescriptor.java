package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes3.dex */
public final class BitmapDescriptor {
    public final IObjectWrapper zza;

    public BitmapDescriptor(IObjectWrapper iObjectWrapper) {
        Preconditions.checkNotNull(iObjectWrapper);
        this.zza = iObjectWrapper;
    }
}
