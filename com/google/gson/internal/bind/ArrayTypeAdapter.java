package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final Class<E> componentType;
    public final TypeAdapterRuntimeTypeWrapper componentTypeAdapter;

    /* renamed from: com.google.gson.internal.bind.ArrayTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type componentType;
            Type type = typeToken.getType();
            boolean z = type instanceof GenericArrayType;
            if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            if (z) {
                componentType = ((GenericArrayType) type).getGenericComponentType();
            } else {
                componentType = ((Class) type).getComponentType();
            }
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(componentType)), C$Gson$Types.getRawType(componentType));
        }
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Class<E> cls = this.componentType;
        if (cls.isPrimitive()) {
            Object newInstance = Array.newInstance((Class<?>) cls, size);
            for (int r2 = 0; r2 < size; r2++) {
                Array.set(newInstance, r2, arrayList.get(r2));
            }
            return newInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int r1 = 0; r1 < length; r1++) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(obj, r1));
        }
        jsonWriter.endArray();
    }
}
