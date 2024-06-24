package kotlinx.serialization.json;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonElementSerializer.class)
/* loaded from: classes4.dex */
public abstract class JsonElement {
    public static final Companion Companion = new Companion();

    /* compiled from: JsonElement.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<JsonElement> serializer() {
            return JsonElementSerializer.INSTANCE;
        }
    }
}
