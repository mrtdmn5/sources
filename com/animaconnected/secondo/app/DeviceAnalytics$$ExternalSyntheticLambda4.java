package com.animaconnected.secondo.app;

import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DeviceAnalytics$$ExternalSyntheticLambda4 implements FlatMapCallback {
    @Override // com.animaconnected.future.FlatMapCallback
    public final Future onResult(Object obj) {
        Future userCategory$lambda$5;
        userCategory$lambda$5 = DeviceAnalytics.setUserCategory$lambda$5((Map) obj);
        return userCategory$lambda$5;
    }
}
