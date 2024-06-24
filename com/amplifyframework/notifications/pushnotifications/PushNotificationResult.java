package com.amplifyframework.notifications.pushnotifications;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PushNotificationResult.kt */
/* loaded from: classes.dex */
public abstract class PushNotificationResult {

    /* compiled from: PushNotificationResult.kt */
    /* loaded from: classes.dex */
    public static final class AppInForeground extends PushNotificationResult {
        public static final AppInForeground INSTANCE = new AppInForeground();

        private AppInForeground() {
            super(null);
        }
    }

    /* compiled from: PushNotificationResult.kt */
    /* loaded from: classes.dex */
    public static final class NotificationPosted extends PushNotificationResult {
        public static final NotificationPosted INSTANCE = new NotificationPosted();

        private NotificationPosted() {
            super(null);
        }
    }

    /* compiled from: PushNotificationResult.kt */
    /* loaded from: classes.dex */
    public static final class OptedOut extends PushNotificationResult {
        public static final OptedOut INSTANCE = new OptedOut();

        private OptedOut() {
            super(null);
        }
    }

    /* compiled from: PushNotificationResult.kt */
    /* loaded from: classes.dex */
    public static final class Silent extends PushNotificationResult {
        public static final Silent INSTANCE = new Silent();

        private Silent() {
            super(null);
        }
    }

    public /* synthetic */ PushNotificationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PushNotificationResult() {
    }
}
