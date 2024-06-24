package kotlinx.serialization.json.internal;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonNames;

/* compiled from: JsonNamesMap.kt */
/* loaded from: classes4.dex */
public final class JsonNamesMapKt$deserializationNamesMap$1 extends Lambda implements Function0<Map<String, ? extends Integer>> {
    public final /* synthetic */ SerialDescriptor $descriptor;
    public final /* synthetic */ Json $this_deserializationNamesMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonNamesMapKt$deserializationNamesMap$1(SerialDescriptor serialDescriptor, Json json) {
        super(0);
        this.$descriptor = serialDescriptor;
        this.$this_deserializationNamesMap = json;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Integer> invoke() {
        String[] names;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SerialDescriptor serialDescriptor = this.$descriptor;
        JsonNamesMapKt.namingStrategy(serialDescriptor, this.$this_deserializationNamesMap);
        int elementsCount = serialDescriptor.getElementsCount();
        for (int r4 = 0; r4 < elementsCount; r4++) {
            List<Annotation> elementAnnotations = serialDescriptor.getElementAnnotations(r4);
            ArrayList arrayList = new ArrayList();
            for (Object obj : elementAnnotations) {
                if (obj instanceof JsonNames) {
                    arrayList.add(obj);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt___CollectionsKt.singleOrNull(arrayList);
            if (jsonNames != null && (names = jsonNames.names()) != null) {
                for (String str : names) {
                    if (!linkedHashMap.containsKey(str)) {
                        linkedHashMap.put(str, Integer.valueOf(r4));
                    } else {
                        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("The suggested name '", str, "' for property ");
                        m.append(serialDescriptor.getElementName(r4));
                        m.append(" is already one of the names for property ");
                        m.append(serialDescriptor.getElementName(((Number) MapsKt__MapsKt.getValue(str, linkedHashMap)).intValue()));
                        m.append(" in ");
                        m.append(serialDescriptor);
                        throw new JsonException(m.toString());
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return EmptyMap.INSTANCE;
        }
        return linkedHashMap;
    }
}
