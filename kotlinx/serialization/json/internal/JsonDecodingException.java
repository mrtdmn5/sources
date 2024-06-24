package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonExceptions.kt */
/* loaded from: classes4.dex */
public final class JsonDecodingException extends JsonException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonDecodingException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
