package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes3.dex */
public final class MapJsonAdapter<K, V> extends JsonAdapter<Map<K, V>> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final JsonAdapter<K> keyAdapter;
    public final JsonAdapter<V> valueAdapter;

    /* renamed from: com.squareup.moshi.MapJsonAdapter$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements JsonAdapter.Factory {
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Class<?> rawType;
            Type[] typeArr;
            if (!set.isEmpty() || (rawType = Types.getRawType(type)) != Map.class) {
                return null;
            }
            if (type == Properties.class) {
                typeArr = new Type[]{String.class, String.class};
            } else if (Map.class.isAssignableFrom(rawType)) {
                Type resolve = Util.resolve(type, rawType, Util.getGenericSupertype(type, rawType, Map.class));
                if (resolve instanceof ParameterizedType) {
                    typeArr = ((ParameterizedType) resolve).getActualTypeArguments();
                } else {
                    typeArr = new Type[]{Object.class, Object.class};
                }
            } else {
                throw new IllegalArgumentException();
            }
            return new JsonAdapter.AnonymousClass2();
        }
    }

    public MapJsonAdapter(Moshi moshi, Type type, Type type2) {
        moshi.getClass();
        Set<Annotation> set = Util.NO_ANNOTATIONS;
        this.keyAdapter = moshi.adapter(type, set, null);
        this.valueAdapter = moshi.adapter(type2, set, null);
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final Object fromJson(JsonReader jsonReader) throws IOException {
        LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            JsonUtf8Reader jsonUtf8Reader = (JsonUtf8Reader) jsonReader;
            if (jsonUtf8Reader.hasNext()) {
                jsonUtf8Reader.peekedString = jsonUtf8Reader.nextName();
                jsonUtf8Reader.peeked = 11;
            }
            K fromJson = this.keyAdapter.fromJson(jsonReader);
            V fromJson2 = this.valueAdapter.fromJson(jsonReader);
            Object put = linkedHashTreeMap.put(fromJson, fromJson2);
            if (put != null) {
                throw new JsonDataException("Map key '" + fromJson + "' has multiple values at path " + jsonReader.getPath() + ": " + put + " and " + fromJson2);
            }
        }
        jsonReader.endObject();
        return linkedHashTreeMap;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry<K, V> entry : ((Map) obj).entrySet()) {
            if (entry.getKey() != null) {
                int peekScope = jsonWriter.peekScope();
                if (peekScope != 5 && peekScope != 3) {
                    throw new IllegalStateException("Nesting problem.");
                }
                jsonWriter.promoteValueToName = true;
                this.keyAdapter.toJson(jsonWriter, entry.getKey());
                this.valueAdapter.toJson(jsonWriter, entry.getValue());
            } else {
                throw new JsonDataException("Map key is null at " + jsonWriter.getPath());
            }
        }
        jsonWriter.endObject();
    }

    public final String toString() {
        return "JsonAdapter(" + this.keyAdapter + "=" + this.valueAdapter + ")";
    }
}
