package com.squareup.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public final class ArrayJsonAdapter extends JsonAdapter<Object> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final JsonAdapter<Object> elementAdapter;
    public final Class<?> elementClass;

    /* renamed from: com.squareup.moshi.ArrayJsonAdapter$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements JsonAdapter.Factory {
        @Override // com.squareup.moshi.JsonAdapter.Factory
        public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Type type2;
            if (type instanceof GenericArrayType) {
                type2 = ((GenericArrayType) type).getGenericComponentType();
            } else if (type instanceof Class) {
                type2 = ((Class) type).getComponentType();
            } else {
                type2 = null;
            }
            if (type2 == null || !set.isEmpty()) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type2);
            moshi.getClass();
            return new JsonAdapter.AnonymousClass2();
        }
    }

    public ArrayJsonAdapter(Class<?> cls, JsonAdapter<Object> jsonAdapter) {
        this.elementClass = cls;
        this.elementAdapter = jsonAdapter;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final Object fromJson(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.elementAdapter.fromJson(jsonReader));
        }
        jsonReader.endArray();
        Object newInstance = Array.newInstance(this.elementClass, arrayList.size());
        for (int r1 = 0; r1 < arrayList.size(); r1++) {
            Array.set(newInstance, r1, arrayList.get(r1));
        }
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public final void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int r1 = 0; r1 < length; r1++) {
            this.elementAdapter.toJson(jsonWriter, Array.get(obj, r1));
        }
        jsonWriter.endArray();
    }

    public final String toString() {
        return this.elementAdapter + ".array()";
    }
}
