package com.google.firebase.crashlytics.internal.network;

/* loaded from: classes3.dex */
public final class HttpResponse {
    public final String body;
    public final int code;

    public HttpResponse(int r1, String str) {
        this.code = r1;
        this.body = str;
    }
}
