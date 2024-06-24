package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final AnonymousClass1 DOUBLE_FACTORY = new AnonymousClass1(ToNumberPolicy.DOUBLE);
    public final Gson gson;
    public final ToNumberStrategy toNumberStrategy;

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements TypeAdapterFactory {
        public final /* synthetic */ ToNumberStrategy val$toNumberStrategy;

        public AnonymousClass1(ToNumberPolicy toNumberPolicy) {
            this.val$toNumberStrategy = toNumberPolicy;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson, this.val$toNumberStrategy);
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            try {
                r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ObjectTypeAdapter(Gson gson, ToNumberStrategy toNumberStrategy) {
        this.gson = gson;
        this.toNumberStrategy = toNumberStrategy;
    }

    public static Serializable tryBeginNesting(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int r2 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                return null;
            }
            jsonReader.beginObject();
            return new LinkedTreeMap();
        }
        jsonReader.beginArray();
        return new ArrayList();
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) throws IOException {
        String str;
        boolean z;
        Serializable serializable;
        JsonToken peek = jsonReader.peek();
        Object tryBeginNesting = tryBeginNesting(jsonReader, peek);
        if (tryBeginNesting == null) {
            return readTerminal(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (tryBeginNesting instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                JsonToken peek2 = jsonReader.peek();
                Serializable tryBeginNesting2 = tryBeginNesting(jsonReader, peek2);
                if (tryBeginNesting2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (tryBeginNesting2 == null) {
                    serializable = readTerminal(jsonReader, peek2);
                } else {
                    serializable = tryBeginNesting2;
                }
                if (tryBeginNesting instanceof List) {
                    ((List) tryBeginNesting).add(serializable);
                } else {
                    ((Map) tryBeginNesting).put(str, serializable);
                }
                if (z) {
                    arrayDeque.addLast(tryBeginNesting);
                    tryBeginNesting = serializable;
                }
            } else {
                if (tryBeginNesting instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return tryBeginNesting;
                }
                tryBeginNesting = arrayDeque.removeLast();
            }
        }
    }

    public final Serializable readTerminal(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int r0 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()];
        if (r0 != 3) {
            if (r0 != 4) {
                if (r0 != 5) {
                    if (r0 == 6) {
                        jsonReader.nextNull();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        return jsonReader.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Class<?> cls = obj.getClass();
        Gson gson = this.gson;
        gson.getClass();
        TypeAdapter adapter = gson.getAdapter(TypeToken.get((Class) cls));
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            adapter.write(jsonWriter, obj);
        }
    }
}
