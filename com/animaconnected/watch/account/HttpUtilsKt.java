package com.animaconnected.watch.account;

import kotlin.ranges.IntRange;

/* compiled from: HttpUtils.kt */
/* loaded from: classes3.dex */
public final class HttpUtilsKt {
    public static final int RESPONSE_EXCEPTION_CODE = 600;
    public static final int UNAUTHORIZED_RESPONSE_CODE = 401;
    public static final String liveUrl = "https://api.apps.festinagroup.com";
    public static final String sandboxUrl = "https://api.domain-for-sandbox.com";
    private static final IntRange SERVER_RESPONSE_SUCCESSFUL_RANGE = new IntRange(200, 299);
    private static final IntRange CLIENT_REQUEST_EXCEPTION_RANGE = new IntRange(400, 499);
    private static final IntRange SERVER_RESPONSE_EXCEPTION_RANGE = new IntRange(500, 599);

    public static final IntRange getCLIENT_REQUEST_EXCEPTION_RANGE() {
        return CLIENT_REQUEST_EXCEPTION_RANGE;
    }

    public static final IntRange getSERVER_RESPONSE_EXCEPTION_RANGE() {
        return SERVER_RESPONSE_EXCEPTION_RANGE;
    }

    public static final IntRange getSERVER_RESPONSE_SUCCESSFUL_RANGE() {
        return SERVER_RESPONSE_SUCCESSFUL_RANGE;
    }
}
