package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.UidVerifier;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbt extends zbo {
    public final Context zba;

    public zbt(Context context) {
        this.zba = context;
    }

    public final void zbd$1() {
        if (UidVerifier.isGooglePlayServicesUid(this.zba, Binder.getCallingUid())) {
        } else {
            throw new SecurityException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Calling UID ", Binder.getCallingUid(), " is not Google Play services."));
        }
    }
}
