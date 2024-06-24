package com.animaconnected.watch;

import android.os.Build;
import com.animaconnected.firebase.config.LePingReqParams;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LePingReq.kt */
/* loaded from: classes3.dex */
public final class LePingReqKt {
    public static final boolean getNeedsLePingRegWorkaround(WatchProvider watchProvider) {
        boolean z;
        Intrinsics.checkNotNullParameter(watchProvider, "<this>");
        for (LePingReqParams.Model model : watchProvider.getRemoteConfig().getLePingReqParams().getDevices()) {
            if (Intrinsics.areEqual(model.getModel(), Build.MODEL) && Intrinsics.areEqual(model.getVersion(), Build.VERSION.RELEASE)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
