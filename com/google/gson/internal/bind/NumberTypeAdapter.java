package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    public static final AnonymousClass1 LAZILY_PARSED_NUMBER_FACTORY = new AnonymousClass1();
    public final ToNumberStrategy toNumberStrategy;

    /* renamed from: com.google.gson.internal.bind.NumberTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements TypeAdapterFactory {
        public AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Number.class) {
                return NumberTypeAdapter.this;
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            try {
                r0[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NumberTypeAdapter(ToNumberPolicy toNumberPolicy) {
        this.toNumberStrategy = toNumberPolicy;
    }

    @Override // com.google.gson.TypeAdapter
    public final Number read(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int r1 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[peek.ordinal()];
        if (r1 != 1) {
            if (r1 != 2 && r1 != 3) {
                throw new JsonSyntaxException("Expecting number, got: " + peek + "; at path " + jsonReader.getPath());
            }
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        jsonReader.nextNull();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
