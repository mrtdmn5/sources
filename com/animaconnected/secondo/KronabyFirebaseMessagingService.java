package com.animaconnected.secondo;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.RunOnUIThread;
import com.animaconnected.watch.behaviour.RemoteMessageReceiver;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KronabyFirebaseMessagingService.kt */
/* loaded from: classes.dex */
public final class KronabyFirebaseMessagingService extends FirebaseMessagingService {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageReceived$lambda$0(String service, KronabyFirebaseMessagingService this$0, Map data) {
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        RemoteMessageReceiver messageReceiver = ProviderFactory.INSTANCE.getMessageReceiver(service);
        LogKt.debug$default((Object) this$0, "messageReceiver: " + messageReceiver, (String) null, (Throwable) null, false, 14, (Object) null);
        if (messageReceiver != null) {
            messageReceiver.onMessageReceived(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNewToken$lambda$1(String token) {
        Intrinsics.checkNotNullParameter(token, "$token");
        ProviderFactory.getKronabyFirebaseInstanceIdService().onTokenRefresh(token);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ArrayMap arrayMap = message.data;
        Bundle bundle = message.bundle;
        if (arrayMap == null) {
            ArrayMap arrayMap2 = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap2.put(str, str2);
                    }
                }
            }
            message.data = arrayMap2;
        }
        final ArrayMap arrayMap3 = message.data;
        Intrinsics.checkNotNullExpressionValue(arrayMap3, "getData(...)");
        LogKt.info$default((Object) this, "onMessageReceived from = " + bundle.getString("from") + " data: " + arrayMap3, (String) null, (Throwable) null, false, 14, (Object) null);
        final String str3 = (String) arrayMap3.getOrDefault(AnalyticsConstants.KEY_SERVICE, null);
        if (str3 == null) {
            str3 = "distress";
        }
        RunOnUIThread.post(new Runnable() { // from class: com.animaconnected.secondo.KronabyFirebaseMessagingService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KronabyFirebaseMessagingService.onMessageReceived$lambda$0(str3, this, arrayMap3);
            }
        });
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(final String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        RunOnUIThread.post(new Runnable() { // from class: com.animaconnected.secondo.KronabyFirebaseMessagingService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                KronabyFirebaseMessagingService.onNewToken$lambda$1(token);
            }
        });
    }
}
