package com.google.gson.internal.bind;

import aws.smithy.kotlin.runtime.net.IpAddr;
import com.amazonaws.services.s3.internal.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    public final boolean complexMapKeySerialization = false;
    public final ConstructorConstructor constructorConstructor;

    /* loaded from: classes3.dex */
    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        public final ObjectConstructor<? extends Map<K, V>> constructor;
        public final TypeAdapterRuntimeTypeWrapper keyTypeAdapter;
        public final TypeAdapterRuntimeTypeWrapper valueTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map<K, V> construct = this.constructor.construct();
            JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = this.valueTypeAdapter;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = this.keyTypeAdapter;
            if (peek == jsonToken) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    Object read = typeAdapterRuntimeTypeWrapper2.read(jsonReader);
                    if (construct.put(read, typeAdapterRuntimeTypeWrapper.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    IpAddr.INSTANCE.getClass();
                    if (jsonReader instanceof JsonTreeReader) {
                        JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                        jsonTreeReader.expect(JsonToken.NAME);
                        Map.Entry entry = (Map.Entry) ((Iterator) jsonTreeReader.peekStack()).next();
                        jsonTreeReader.push(entry.getValue());
                        jsonTreeReader.push(new JsonPrimitive((String) entry.getKey()));
                    } else {
                        int r0 = jsonReader.peeked;
                        if (r0 == 0) {
                            r0 = jsonReader.doPeek();
                        }
                        if (r0 == 13) {
                            jsonReader.peeked = 9;
                        } else if (r0 == 12) {
                            jsonReader.peeked = 8;
                        } else if (r0 == 14) {
                            jsonReader.peeked = 10;
                        } else {
                            throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                        }
                    }
                    Object read2 = typeAdapterRuntimeTypeWrapper2.read(jsonReader);
                    if (construct.put(read2, typeAdapterRuntimeTypeWrapper.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                jsonReader.endObject();
            }
            return construct;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String str;
            boolean z;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.nullValue();
                return;
            }
            boolean z2 = MapTypeAdapterFactory.this.complexMapKeySerialization;
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = this.valueTypeAdapter;
            if (!z2) {
                jsonWriter.beginObject();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    typeAdapterRuntimeTypeWrapper.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int r3 = 0;
            boolean z3 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                K key = entry2.getKey();
                TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper2 = this.keyTypeAdapter;
                typeAdapterRuntimeTypeWrapper2.getClass();
                try {
                    JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
                    typeAdapterRuntimeTypeWrapper2.write(jsonTreeWriter, key);
                    ArrayList arrayList3 = jsonTreeWriter.stack;
                    if (arrayList3.isEmpty()) {
                        JsonElement jsonElement = jsonTreeWriter.product;
                        arrayList.add(jsonElement);
                        arrayList2.add(entry2.getValue());
                        jsonElement.getClass();
                        if (!(jsonElement instanceof JsonArray) && !(jsonElement instanceof JsonObject)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        z3 |= z;
                    } else {
                        throw new IllegalStateException("Expected one JSON element but was " + arrayList3);
                    }
                } catch (IOException e) {
                    throw new JsonIOException(e);
                }
            }
            if (z3) {
                jsonWriter.beginArray();
                int size = arrayList.size();
                while (r3 < size) {
                    jsonWriter.beginArray();
                    TypeAdapters.JSON_ELEMENT.write(jsonWriter, (JsonElement) arrayList.get(r3));
                    typeAdapterRuntimeTypeWrapper.write(jsonWriter, arrayList2.get(r3));
                    jsonWriter.endArray();
                    r3++;
                }
                jsonWriter.endArray();
                return;
            }
            jsonWriter.beginObject();
            int size2 = arrayList.size();
            while (r3 < size2) {
                JsonElement jsonElement2 = (JsonElement) arrayList.get(r3);
                jsonElement2.getClass();
                boolean z4 = jsonElement2 instanceof JsonPrimitive;
                if (z4) {
                    if (z4) {
                        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement2;
                        Serializable serializable = jsonPrimitive.value;
                        if (serializable instanceof Number) {
                            str = String.valueOf(jsonPrimitive.getAsNumber());
                        } else if (serializable instanceof Boolean) {
                            str = Boolean.toString(jsonPrimitive.getAsBoolean());
                        } else if (serializable instanceof String) {
                            str = jsonPrimitive.getAsString();
                        } else {
                            throw new AssertionError();
                        }
                    } else {
                        throw new IllegalStateException("Not a JSON Primitive: " + jsonElement2);
                    }
                } else if (jsonElement2 instanceof JsonNull) {
                    str = Constants.NULL_VERSION_ID;
                } else {
                    throw new AssertionError();
                }
                jsonWriter.name(str);
                typeAdapterRuntimeTypeWrapper.write(jsonWriter, arrayList2.get(r3));
                r3++;
            }
            jsonWriter.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] typeArr;
        TypeAdapter<T> typeAdapter;
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        if (type == Properties.class) {
            typeArr = new Type[]{String.class, String.class};
        } else {
            Type supertype = C$Gson$Types.getSupertype(type, rawType, Map.class);
            if (supertype instanceof ParameterizedType) {
                typeArr = ((ParameterizedType) supertype).getActualTypeArguments();
            } else {
                typeArr = new Type[]{Object.class, Object.class};
            }
        }
        Type type2 = typeArr[0];
        if (type2 != Boolean.TYPE && type2 != Boolean.class) {
            typeAdapter = gson.getAdapter(TypeToken.get(type2));
        } else {
            typeAdapter = TypeAdapters.BOOLEAN_AS_STRING;
        }
        return new Adapter(gson, typeArr[0], typeAdapter, typeArr[1], gson.getAdapter(TypeToken.get(typeArr[1])), this.constructorConstructor.get(typeToken));
    }
}
