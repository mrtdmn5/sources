package kotlinx.serialization;

/* compiled from: SerializationExceptions.kt */
/* loaded from: classes4.dex */
public class SerializationException extends IllegalArgumentException {
    public SerializationException() {
    }

    public SerializationException(String str, MissingFieldException missingFieldException) {
        super(str, missingFieldException);
    }
}
