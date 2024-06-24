package com.animaconnected.secondo.notification.handler;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.NotificationTextExtractor;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventNotificationHandler.kt */
/* loaded from: classes3.dex */
public final class EventNotificationHandler implements NotificationHandler {
    private final HashMap<String, CharSequence> prevTickerTexts = new HashMap<>();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "EventNotificationHandler";

    /* compiled from: EventNotificationHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public boolean canHandle(String str, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        switch (packageName.hashCode()) {
            case -1955351778:
                if (!packageName.equals("com.samsung.android.calendar")) {
                    return false;
                }
                return Intrinsics.areEqual("event", str);
            case -456066902:
                if (!packageName.equals("com.android.calendar")) {
                    return false;
                }
                if (str != null && !Intrinsics.areEqual(str, "event")) {
                    return false;
                }
                return true;
            case -384534904:
                if (!packageName.equals("com.microsoft.office.outlook")) {
                    return false;
                }
                return Intrinsics.areEqual("event", str);
            case 160021734:
                if (!packageName.equals("com.google.calendar")) {
                    return false;
                }
                return Intrinsics.areEqual("event", str);
            case 578428293:
                if (!packageName.equals("com.google.android.calendar")) {
                    return false;
                }
                return Intrinsics.areEqual("event", str);
            case 1507157782:
                if (!packageName.equals("com.sonymobile.calendar")) {
                    return false;
                }
                return Intrinsics.areEqual("event", str);
            default:
                return false;
        }
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handle(StatusBarNotification sbn, final long j) {
        String str;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Notification notification = sbn.getNotification();
        String packageName = sbn.getPackageName();
        ArrayList<String> texts = NotificationTextExtractor.getTexts(sbn);
        if (this.prevTickerTexts.get(packageName) != null && notification.tickerText == null) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.notification.handler.EventNotificationHandler$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "handle() notificationGenerationId: " + j + " is repeat notification with null ticker. Dropped.";
                }
            }, 6, (Object) null);
            return;
        }
        HashMap<String, CharSequence> hashMap = this.prevTickerTexts;
        Intrinsics.checkNotNull(packageName);
        hashMap.put(packageName, notification.tickerText);
        CharSequence charSequence = notification.tickerText;
        if (charSequence == null || (str = charSequence.toString()) == null) {
            str = "";
        }
        send("event", packageName, str, packageName, j, texts);
    }
}
