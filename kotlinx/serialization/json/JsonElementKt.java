package kotlinx.serialization.json;

import com.google.android.gms.cloudmessaging.zzv;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
/* loaded from: classes4.dex */
public final class JsonElementKt {
    public static final InlineClassDescriptor jsonUnquotedLiteralDescriptor = zzv.InlinePrimitiveDescriptor("kotlinx.serialization.json.JsonUnquotedLiteral", StringSerializer.INSTANCE);

    public static final Boolean getBooleanOrNull(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        String content = jsonPrimitive.getContent();
        String[] strArr = StringOpsKt.ESCAPE_STRINGS;
        Intrinsics.checkNotNullParameter(content, "<this>");
        if (StringsKt__StringsJVMKt.equals(content, "true")) {
            return Boolean.TRUE;
        }
        if (StringsKt__StringsJVMKt.equals(content, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }
}
