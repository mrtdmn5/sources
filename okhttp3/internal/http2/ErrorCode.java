package okhttp3.internal.http2;

/* compiled from: ErrorCode.kt */
/* loaded from: classes4.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    public static final Companion Companion = new Companion();
    private final int httpCode;

    /* compiled from: ErrorCode.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    ErrorCode(int r3) {
        this.httpCode = r3;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
