package io.ktor.utils.io.charsets;

/* compiled from: CharsetJVM.kt */
/* loaded from: classes3.dex */
public class MalformedInputException extends java.nio.charset.MalformedInputException {
    public final String _message;

    public MalformedInputException(String str) {
        super(0);
        this._message = str;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public final String getMessage() {
        return this._message;
    }
}
