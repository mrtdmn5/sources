package kotlinx.serialization.json;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: Json.kt */
/* loaded from: classes4.dex */
public final class JsonKt {
    public static JsonImpl Json$default(Function1 builderAction) {
        Json.Default from = Json.Default;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        JsonBuilder jsonBuilder = new JsonBuilder(from);
        builderAction.invoke(jsonBuilder);
        if (jsonBuilder.useArrayPolymorphism && !Intrinsics.areEqual(jsonBuilder.classDiscriminator, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
        }
        boolean z = jsonBuilder.prettyPrint;
        String str = jsonBuilder.prettyPrintIndent;
        if (!z) {
            if (!Intrinsics.areEqual(str, "    ")) {
                throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
            }
        } else if (!Intrinsics.areEqual(str, "    ")) {
            boolean z2 = false;
            int r0 = 0;
            while (true) {
                boolean z3 = true;
                if (r0 < str.length()) {
                    char charAt = str.charAt(r0);
                    if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                        z3 = false;
                    }
                    if (!z3) {
                        break;
                    }
                    r0++;
                } else {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                throw new IllegalArgumentException("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had ".concat(str).toString());
            }
        }
        return new JsonImpl(new JsonConfiguration(jsonBuilder.encodeDefaults, jsonBuilder.ignoreUnknownKeys, jsonBuilder.isLenient, jsonBuilder.allowStructuredMapKeys, jsonBuilder.prettyPrint, jsonBuilder.explicitNulls, jsonBuilder.prettyPrintIndent, jsonBuilder.coerceInputValues, jsonBuilder.useArrayPolymorphism, jsonBuilder.classDiscriminator, jsonBuilder.allowSpecialFloatingPointValues, jsonBuilder.useAlternativeNames), jsonBuilder.serializersModule);
    }
}
