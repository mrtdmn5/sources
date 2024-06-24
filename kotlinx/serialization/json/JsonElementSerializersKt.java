package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes4.dex */
public final class JsonElementSerializersKt {
    public static final void access$verify(Encoder encoder) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        if (encoder instanceof JsonEncoder) {
            jsonEncoder = (JsonEncoder) encoder;
        } else {
            jsonEncoder = null;
        }
        if (jsonEncoder != null) {
            return;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.getOrCreateKotlinClass(encoder.getClass()));
    }

    public static final JsonDecoder asJsonDecoder(Decoder decoder) {
        JsonDecoder jsonDecoder;
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        if (decoder instanceof JsonDecoder) {
            jsonDecoder = (JsonDecoder) decoder;
        } else {
            jsonDecoder = null;
        }
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(decoder.getClass()));
    }
}
