package aws.smithy.kotlin.runtime.serde.json;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: JsonDeserializer.kt */
/* loaded from: classes.dex */
public final class JsonDeserializer$deserializeInt$1 extends Lambda implements Function1<String, Integer> {
    public static final JsonDeserializer$deserializeInt$1 INSTANCE = new JsonDeserializer$deserializeInt$1();

    public JsonDeserializer$deserializeInt$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(String str) {
        int parseDouble;
        String it = str;
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(it);
        if (intOrNull != null) {
            parseDouble = intOrNull.intValue();
        } else {
            parseDouble = (int) Double.parseDouble(it);
        }
        return Integer.valueOf(parseDouble);
    }
}
