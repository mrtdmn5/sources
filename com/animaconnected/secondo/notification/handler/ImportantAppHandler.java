package com.animaconnected.secondo.notification.handler;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.app.NotificationTextExtractor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImportantAppHandler.kt */
/* loaded from: classes3.dex */
public final class ImportantAppHandler implements NotificationHandler {
    public static final int $stable = 0;

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public boolean canHandle(String str, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return true;
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handle(StatusBarNotification sbn, long j) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Notification notification = sbn.getNotification();
        String packageName = sbn.getPackageName();
        String str = notification.category;
        String groupKey = sbn.getGroupKey();
        if (Intrinsics.areEqual(packageName, "com.viber.voip") && str == null) {
            return;
        }
        if (Intrinsics.areEqual(packageName, "com.whatsapp")) {
            if (str != null && notification.tickerText != "WhatsApp Web") {
                if (Intrinsics.areEqual(str, "call") && (notification.tickerText == null || groupKey == null)) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Intrinsics.areEqual(packageName, "com.facebook.orca") && Intrinsics.areEqual(str, AnalyticsConstants.KEY_SERVICE)) {
            return;
        }
        send("msg", packageName, notification.tickerText, packageName, j, NotificationTextExtractor.getTexts(sbn));
    }
}
