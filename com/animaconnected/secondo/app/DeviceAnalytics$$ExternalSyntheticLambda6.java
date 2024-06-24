package com.animaconnected.secondo.app;

import com.animaconnected.future.FailCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DeviceAnalytics$$ExternalSyntheticLambda6 implements FailCallback {
    @Override // com.animaconnected.future.FailCallback
    public final void onFail(Throwable th) {
        DeviceAnalytics.setUserCategory$lambda$8(th);
    }
}
