package kotlinx.serialization.json.internal;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import io.ktor.http.ContentTypesKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: TreeJsonDecoder.kt */
/* loaded from: classes4.dex */
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    public boolean forceNull;
    public final SerialDescriptor polyDescriptor;
    public final String polyDiscriminator;
    public int position;
    public final JsonObject value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String str, SerialDescriptor serialDescriptor) {
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.polyDiscriminator = str;
        this.polyDescriptor = serialDescriptor;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor == this.polyDescriptor) {
            return this;
        }
        return super.beginStructure(descriptor);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt__MapsKt.getValue(tag, getValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:            if (kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r7, r4, r5) != (-3)) goto L45;     */
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor r9) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
        L5:
            int r0 = r8.position
            int r1 = r9.getElementsCount()
            if (r0 >= r1) goto Lb1
            int r0 = r8.position
            int r1 = r0 + 1
            r8.position = r1
            java.lang.String r0 = r8.elementName(r9, r0)
            java.lang.String r1 = "nestedName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.ArrayList<Tag> r1 = r8.tagStack
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r8.position
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r8.forceNull = r3
            kotlinx.serialization.json.JsonObject r4 = r8.getValue()
            boolean r4 = r4.containsKey(r0)
            kotlinx.serialization.json.Json r5 = r8.json
            if (r4 != 0) goto L54
            kotlinx.serialization.json.JsonConfiguration r4 = r5.configuration
            boolean r4 = r4.explicitNulls
            if (r4 != 0) goto L4f
            boolean r4 = r9.isElementOptional(r1)
            if (r4 != 0) goto L4f
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r9.getElementDescriptor(r1)
            boolean r4 = r4.isNullable()
            if (r4 == 0) goto L4f
            r4 = r2
            goto L50
        L4f:
            r4 = r3
        L50:
            r8.forceNull = r4
            if (r4 == 0) goto L5
        L54:
            kotlinx.serialization.json.JsonConfiguration r4 = r8.configuration
            boolean r4 = r4.coerceInputValues
            if (r4 == 0) goto Lb0
            kotlinx.serialization.descriptors.SerialDescriptor r4 = r9.getElementDescriptor(r1)
            boolean r6 = r4.isNullable()
            if (r6 != 0) goto L6d
            kotlinx.serialization.json.JsonElement r6 = r8.currentElement(r0)
            boolean r6 = r6 instanceof kotlinx.serialization.json.JsonNull
            if (r6 == 0) goto L6d
            goto Lae
        L6d:
            kotlinx.serialization.descriptors.SerialKind r6 = r4.getKind()
            kotlinx.serialization.descriptors.SerialKind$ENUM r7 = kotlinx.serialization.descriptors.SerialKind.ENUM.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto Lad
            boolean r6 = r4.isNullable()
            if (r6 == 0) goto L88
            kotlinx.serialization.json.JsonElement r6 = r8.currentElement(r0)
            boolean r6 = r6 instanceof kotlinx.serialization.json.JsonNull
            if (r6 == 0) goto L88
            goto Lad
        L88:
            kotlinx.serialization.json.JsonElement r0 = r8.currentElement(r0)
            boolean r6 = r0 instanceof kotlinx.serialization.json.JsonPrimitive
            r7 = 0
            if (r6 == 0) goto L94
            kotlinx.serialization.json.JsonPrimitive r0 = (kotlinx.serialization.json.JsonPrimitive) r0
            goto L95
        L94:
            r0 = r7
        L95:
            if (r0 == 0) goto La2
            kotlinx.serialization.internal.InlineClassDescriptor r6 = kotlinx.serialization.json.JsonElementKt.jsonUnquotedLiteralDescriptor
            boolean r6 = r0 instanceof kotlinx.serialization.json.JsonNull
            if (r6 == 0) goto L9e
            goto La2
        L9e:
            java.lang.String r7 = r0.getContent()
        La2:
            if (r7 != 0) goto La5
            goto Lad
        La5:
            int r0 = kotlinx.serialization.json.internal.JsonNamesMapKt.getJsonNameIndex(r7, r4, r5)
            r4 = -3
            if (r0 != r4) goto Lad
            goto Lae
        Lad:
            r2 = r3
        Lae:
            if (r2 != 0) goto L5
        Lb0:
            return r1
        Lb1:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.JsonTreeDecoder.decodeElementIndex(kotlinx.serialization.descriptors.SerialDescriptor):int");
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        if (!this.forceNull && super.decodeNotNullMark()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public String elementName(SerialDescriptor descriptor, int r8) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Json json = this.json;
        JsonNamesMapKt.namingStrategy(descriptor, json);
        String elementName = descriptor.getElementName(r8);
        if (!this.configuration.useAlternativeNames) {
            return elementName;
        }
        if (getValue().keySet().contains(elementName)) {
            return elementName;
        }
        DescriptorSchemaCache.Key<Map<String, Integer>> key = JsonNamesMapKt.JsonDeserializationNamesKey;
        JsonNamesMapKt$deserializationNamesMap$1 jsonNamesMapKt$deserializationNamesMap$1 = new JsonNamesMapKt$deserializationNamesMap$1(descriptor, json);
        DescriptorSchemaCache descriptorSchemaCache = json._schemaCache;
        descriptorSchemaCache.getClass();
        Object obj2 = descriptorSchemaCache.get(descriptor, key);
        if (obj2 == null) {
            obj2 = jsonNamesMapKt$deserializationNamesMap$1.invoke();
            ConcurrentHashMap concurrentHashMap = descriptorSchemaCache.map;
            Object obj3 = concurrentHashMap.get(descriptor);
            if (obj3 == null) {
                obj3 = new ConcurrentHashMap(2);
                concurrentHashMap.put(descriptor, obj3);
            }
            ((Map) obj3).put(key, obj2);
        }
        Map map = (Map) obj2;
        Iterator<T> it = getValue().keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Integer num = (Integer) map.get((String) obj);
                if (num != null && num.intValue() == r8) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            return str;
        }
        return elementName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Set set;
        Set plus;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonConfiguration jsonConfiguration = this.configuration;
        if (!jsonConfiguration.ignoreUnknownKeys && !(descriptor.getKind() instanceof PolymorphicKind)) {
            Json json = this.json;
            JsonNamesMapKt.namingStrategy(descriptor, json);
            if (!jsonConfiguration.useAlternativeNames) {
                plus = Platform_commonKt.cachedSerialNames(descriptor);
            } else {
                Set<String> cachedSerialNames = Platform_commonKt.cachedSerialNames(descriptor);
                Map map = (Map) json._schemaCache.get(descriptor, JsonNamesMapKt.JsonDeserializationNamesKey);
                if (map != null) {
                    set = map.keySet();
                } else {
                    set = null;
                }
                if (set == null) {
                    set = EmptySet.INSTANCE;
                }
                plus = SetsKt.plus(cachedSerialNames, set);
            }
            for (String key : getValue().keySet()) {
                if (!plus.contains(key) && !Intrinsics.areEqual(key, this.polyDiscriminator)) {
                    String jsonObject = getValue().toString();
                    Intrinsics.checkNotNullParameter(key, "key");
                    StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Encountered an unknown key '", key, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                    m.append((Object) ContentTypesKt.minify(-1, jsonObject));
                    throw ContentTypesKt.JsonDecodingException(-1, m.toString());
                }
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonObject getValue() {
        return this.value;
    }
}
