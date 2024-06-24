package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes4.dex */
public final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {
    public int currentIndex;
    public final int size;
    public final JsonArray value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(Json json, JsonArray value) {
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.size = value.size();
        this.currentIndex = -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return this.value.content.get(Integer.parseInt(tag));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int r2 = this.currentIndex;
        if (r2 < this.size - 1) {
            int r22 = r2 + 1;
            this.currentIndex = r22;
            return r22;
        }
        return -1;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public final String elementName(SerialDescriptor descriptor, int r3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return String.valueOf(r3);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement getValue() {
        return this.value;
    }
}
