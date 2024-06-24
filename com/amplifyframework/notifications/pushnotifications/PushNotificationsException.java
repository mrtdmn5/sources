package com.amplifyframework.notifications.pushnotifications;

import com.amplifyframework.notifications.NotificationsException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushNotificationsException.kt */
/* loaded from: classes.dex */
public class PushNotificationsException extends NotificationsException {
    public /* synthetic */ PushNotificationsException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushNotificationsException(String message, String recoverySuggestion, Throwable th) {
        super(message, recoverySuggestion, th);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
