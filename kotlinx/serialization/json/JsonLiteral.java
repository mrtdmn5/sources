package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: JsonElement.kt */
/* loaded from: classes4.dex */
public final class JsonLiteral extends JsonPrimitive {
    public final SerialDescriptor coerceToInlineType;
    public final String content;
    public final boolean isString;

    public JsonLiteral(Object body, boolean z) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.isString = z;
        this.coerceToInlineType = null;
        this.content = body.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonLiteral.class != obj.getClass()) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        if (this.isString == jsonLiteral.isString && Intrinsics.areEqual(this.content, jsonLiteral.content)) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String getContent() {
        return this.content;
    }

    public final int hashCode() {
        return this.content.hashCode() + (Boolean.hashCode(this.isString) * 31);
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String toString() {
        String str = this.content;
        if (this.isString) {
            StringBuilder sb = new StringBuilder();
            StringOpsKt.printQuoted(str, sb);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        return str;
    }
}
