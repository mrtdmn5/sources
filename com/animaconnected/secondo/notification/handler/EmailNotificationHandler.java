package com.animaconnected.secondo.notification.handler;

import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.animaconnected.secondo.app.NotificationTextExtractor;
import com.animaconnected.secondo.utils.SettingsProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmailNotificationHandler.kt */
/* loaded from: classes3.dex */
public final class EmailNotificationHandler implements NotificationHandler {
    private final Context context;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "EmailNotificationHandler";

    /* compiled from: EmailNotificationHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public EmailNotificationHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public boolean canHandle(String str, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return Intrinsics.areEqual(str, "email");
    }

    @Override // com.animaconnected.secondo.notification.handler.NotificationHandler
    public void handle(StatusBarNotification sbn, long j) {
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        String packageName = sbn.getPackageName();
        ArrayList<String> texts = NotificationTextExtractor.getTexts(sbn);
        String str = (String) CollectionsKt___CollectionsKt.firstOrNull((List) NotificationTextExtractor.INSTANCE.getEmailAddresses(sbn));
        SettingsProvider settingsProvider = new SettingsProvider(this.context);
        long latestGmailDate = settingsProvider.getLatestGmailDate();
        long postTime = sbn.getPostTime();
        if (latestGmailDate < postTime) {
            Log.d(TAG, "Message (match): " + postTime + ' ' + str);
            send("email", str, "", packageName, j, new ArrayList<>(texts));
        } else {
            Log.d(TAG, "Message (ignored): " + postTime + ' ' + str);
        }
        if (latestGmailDate < postTime) {
            latestGmailDate = postTime;
        }
        settingsProvider.setLatestGmailDate(latestGmailDate);
    }
}
