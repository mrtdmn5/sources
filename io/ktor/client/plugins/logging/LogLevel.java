package io.ktor.client.plugins.logging;

/* compiled from: LogLevel.kt */
/* loaded from: classes3.dex */
public enum LogLevel {
    ALL(true, true, true),
    HEADERS(true, true, false),
    BODY(true, false, true),
    INFO(true, false, false),
    NONE(false, false, false);

    private final boolean body;
    private final boolean headers;
    private final boolean info;

    LogLevel(boolean z, boolean z2, boolean z3) {
        this.info = z;
        this.headers = z2;
        this.body = z3;
    }

    public final boolean getBody() {
        return this.body;
    }

    public final boolean getHeaders() {
        return this.headers;
    }

    public final boolean getInfo() {
        return this.info;
    }
}
