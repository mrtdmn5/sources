package com.animaconnected.secondo.notification.handler;

import android.service.notification.StatusBarNotification;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationHandler.kt */
/* loaded from: classes3.dex */
public interface NotificationHandler {
    boolean canHandle(String str, String str2);

    void handle(StatusBarNotification statusBarNotification, long j);

    default void handleRemoval(StatusBarNotification sbn) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
    }

    default void send(String str, String str2, CharSequence charSequence, String str3, long j, ArrayList<String> arrayList) {
        ProviderFactory.INSTANCE.getNotificationCenter().handleNotification(str, str2, charSequence, str3, j, arrayList);
    }
}
