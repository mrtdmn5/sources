package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

/* compiled from: JsonNamesMap.kt */
/* loaded from: classes4.dex */
public final class JsonNamesMapKt {
    public static final DescriptorSchemaCache.Key<Map<String, Integer>> JsonDeserializationNamesKey = new DescriptorSchemaCache.Key<>();

    public static final int getJsonNameIndex(String name, SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        namingStrategy(serialDescriptor, json);
        int elementIndex = serialDescriptor.getElementIndex(name);
        if (elementIndex != -3) {
            return elementIndex;
        }
        if (!json.configuration.useAlternativeNames) {
            return elementIndex;
        }
        DescriptorSchemaCache.Key<Map<String, Integer>> key = JsonDeserializationNamesKey;
        JsonNamesMapKt$deserializationNamesMap$1 jsonNamesMapKt$deserializationNamesMap$1 = new JsonNamesMapKt$deserializationNamesMap$1(serialDescriptor, json);
        DescriptorSchemaCache descriptorSchemaCache = json._schemaCache;
        descriptorSchemaCache.getClass();
        Object obj = descriptorSchemaCache.get(serialDescriptor, key);
        if (obj == null) {
            obj = jsonNamesMapKt$deserializationNamesMap$1.invoke();
            ConcurrentHashMap concurrentHashMap = descriptorSchemaCache.map;
            Object obj2 = concurrentHashMap.get(serialDescriptor);
            if (obj2 == null) {
                obj2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(serialDescriptor, obj2);
            }
            ((Map) obj2).put(key, obj);
        }
        Integer num = (Integer) ((Map) obj).get(name);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int jsonNameIndex = getJsonNameIndex(name, serialDescriptor, json);
        if (jsonNameIndex != -3) {
            return jsonNameIndex;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static final void namingStrategy(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE)) {
            json.configuration.getClass();
        }
    }
}
