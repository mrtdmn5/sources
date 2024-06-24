package io.ktor.http;

/* compiled from: ContentTypes.kt */
/* loaded from: classes3.dex */
public final class BadContentTypeFormatException extends Exception {
    public BadContentTypeFormatException(String str) {
        super("Bad Content-Type format: ".concat(str));
    }
}
