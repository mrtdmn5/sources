package com.animaconnected.secondo;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.animaconnected.watch.device.DeviceInfo;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KronabyFirebaseMessagingService.kt */
/* loaded from: classes.dex */
public final class LogRequestReceiver implements RemoteMessageReceiver {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "remote_log_request";

    /* compiled from: KronabyFirebaseMessagingService.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$0(Map map) {
        String str = (String) map.get(DeviceInfo.SerialNumber);
        if (str == null) {
            str = "XX:XX:XX:XX:XX:XX";
        }
        try {
            FirebaseCrashlytics.getInstance().recordException(new RemoteCrash(str));
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$1(Throwable th) {
        try {
            FirebaseCrashlytics.getInstance().recordException(new RemoteCrash("XX:XX:XX:XX:XX:XX"));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public String getServiceName() {
        return NAME;
    }

    @Override // com.animaconnected.watch.behaviour.RemoteMessageReceiver
    public void onMessageReceived(Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LogKt.debug$default((Object) this, "Logs requested remotely", (String) null, (Throwable) null, false, 14, (Object) null);
        ProviderFactory.getWatch().getDeviceInformation().success(new LogRequestReceiver$$ExternalSyntheticLambda0()).fail(new LogRequestReceiver$$ExternalSyntheticLambda1());
    }
}
