package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonPrimitiveSerializer.class)
/* loaded from: classes4.dex */
public abstract class JsonPrimitive extends JsonElement {
    public static final Companion Companion = new Companion();

    /* compiled from: JsonElement.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<JsonPrimitive> serializer() {
            return JsonPrimitiveSerializer.INSTANCE;
        }
    }

    public abstract String getContent();

    public String toString() {
        return getContent();
    }
}
