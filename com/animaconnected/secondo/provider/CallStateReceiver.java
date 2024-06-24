package com.animaconnected.secondo.provider;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.notification.NotificationCenter;
import com.animaconnected.watch.CallHelper;
import com.animaconnected.watch.device.CallState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallStateReceiver.kt */
/* loaded from: classes3.dex */
public final class CallStateReceiver {
    public static final int $stable = 8;
    private Context context;
    private int lastState;
    private final CopyOnWriteArraySet<CallStateListener> listeners;
    private final NotificationCenter notificationCenterProvider;

    public CallStateReceiver(Context context, NotificationCenter notificationCenterProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationCenterProvider, "notificationCenterProvider");
        this.notificationCenterProvider = notificationCenterProvider;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        this.listeners = new CopyOnWriteArraySet<>();
    }

    private final void callEndedOrOngoing(String str) {
        if (this.lastState == 1) {
            NotificationCenter.handleNotification$default(this.notificationCenterProvider, "call", str, NotificationCenter.INCOMING_CALL_ENDED_OR_ONGOING, null, 0L, null, 56, null);
            if (CallHelper.shouldMuteCalls()) {
                CallHelper.INSTANCE.revertMuteIfNeeded();
            }
        }
    }

    private final boolean callPermissionGranted() {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        LogKt.debug$default((Object) this, "READ_PHONE_STATE is not granted, can't listen for calls!", (String) null, (Throwable) null, false, 14, (Object) null);
        return false;
    }

    public final void addListener(CallStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onCallStateChanged(int r20, String str) {
        String str2;
        if (!callPermissionGranted()) {
            LogKt.debug$default((Object) this, "Permission denied, can't guarantee that feature works correctly without it", (String) null, (Throwable) null, false, 14, (Object) null);
            return;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (r20 != 0) {
            if (r20 != 1) {
                if (r20 == 2) {
                    LogKt.debug$default((Object) this, "onCallStateChanged: Offhook", (String) null, (Throwable) null, false, 14, (Object) null);
                    Iterator<T> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((CallStateListener) it.next()).onCallStateChanged(CallState.OffHook, str2);
                    }
                    callEndedOrOngoing(str2);
                }
            } else {
                LogKt.debug$default((Object) this, "onCallStateChanged: Ringing", (String) null, (Throwable) null, false, 14, (Object) null);
                Iterator<T> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    ((CallStateListener) it2.next()).onCallStateChanged(CallState.Ringing, str2);
                }
                NotificationCenter.handleNotification$default(this.notificationCenterProvider, "call", str, NotificationCenter.INCOMING_CALL_RINGING, null, 0L, null, 56, null);
            }
        } else {
            LogKt.debug$default((Object) this, "onCallStateChanged: Idle", (String) null, (Throwable) null, false, 14, (Object) null);
            Iterator<T> it3 = this.listeners.iterator();
            while (it3.hasNext()) {
                ((CallStateListener) it3.next()).onCallStateChanged(CallState.Idle, str2);
            }
            callEndedOrOngoing(str2);
        }
        this.lastState = r20;
    }

    public final void removeListener(CallStateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
