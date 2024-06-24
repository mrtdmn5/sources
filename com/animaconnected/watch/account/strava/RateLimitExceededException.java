package com.animaconnected.watch.account.strava;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StravaRateLimiter.kt */
/* loaded from: classes3.dex */
public final class RateLimitExceededException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RateLimitExceededException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
