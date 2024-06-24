package com.amplifyframework.notifications;

import com.amplifyframework.AmplifyException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsException.kt */
/* loaded from: classes.dex */
public class NotificationsException extends AmplifyException {
    public /* synthetic */ NotificationsException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationsException(String message, String recoverySuggestion, Throwable th) {
        super(message, th, recoverySuggestion);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
