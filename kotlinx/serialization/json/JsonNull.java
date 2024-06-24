package kotlinx.serialization.json;

import com.amazonaws.services.s3.internal.Constants;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: JsonElement.kt */
@Serializable(with = JsonNullSerializer.class)
/* loaded from: classes4.dex */
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();
    public static final String content = Constants.NULL_VERSION_ID;
    public static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: kotlinx.serialization.json.JsonNull$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return JsonNullSerializer.INSTANCE;
        }
    });

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String getContent() {
        return content;
    }

    public final KSerializer<JsonNull> serializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }
}
