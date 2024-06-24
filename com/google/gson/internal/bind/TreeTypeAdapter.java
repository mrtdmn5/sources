package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    public volatile TypeAdapter<T> delegate;
    public final JsonDeserializer<T> deserializer;
    public final Gson gson;
    public final boolean nullSafe;
    public final JsonSerializer<T> serializer;
    public final TypeToken<T> typeToken;
    public final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl();
    public final TypeAdapterFactory skipPast = null;

    /* loaded from: classes3.dex */
    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, boolean z) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.nullSafe = z;
    }

    public final TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter == null) {
            TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
            this.delegate = delegateAdapter;
            return delegateAdapter;
        }
        return typeAdapter;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer != null) {
            return this;
        }
        return delegate();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    @Override // com.google.gson.TypeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T read(com.google.gson.stream.JsonReader r4) throws java.io.IOException {
        /*
            r3 = this;
            com.google.gson.JsonDeserializer<T> r0 = r3.deserializer
            if (r0 != 0) goto Ld
            com.google.gson.TypeAdapter r0 = r3.delegate()
            java.lang.Object r4 = r0.read(r4)
            return r4
        Ld:
            r4.peek()     // Catch: java.lang.NumberFormatException -> L1c java.io.IOException -> L23 com.google.gson.stream.MalformedJsonException -> L2a java.io.EOFException -> L31
            com.google.gson.internal.bind.TypeAdapters$28 r1 = com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT     // Catch: java.io.EOFException -> L19 java.lang.NumberFormatException -> L1c java.io.IOException -> L23 com.google.gson.stream.MalformedJsonException -> L2a
            java.lang.Object r4 = r1.read(r4)     // Catch: java.io.EOFException -> L19 java.lang.NumberFormatException -> L1c java.io.IOException -> L23 com.google.gson.stream.MalformedJsonException -> L2a
            com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch: java.io.EOFException -> L19 java.lang.NumberFormatException -> L1c java.io.IOException -> L23 com.google.gson.stream.MalformedJsonException -> L2a
            goto L37
        L19:
            r4 = move-exception
            r1 = 0
            goto L33
        L1c:
            r4 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>(r4)
            throw r0
        L23:
            r4 = move-exception
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException
            r0.<init>(r4)
            throw r0
        L2a:
            r4 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>(r4)
            throw r0
        L31:
            r4 = move-exception
            r1 = 1
        L33:
            if (r1 == 0) goto L51
            com.google.gson.JsonNull r4 = com.google.gson.JsonNull.INSTANCE
        L37:
            boolean r1 = r3.nullSafe
            if (r1 == 0) goto L44
            r4.getClass()
            boolean r1 = r4 instanceof com.google.gson.JsonNull
            if (r1 == 0) goto L44
            r4 = 0
            return r4
        L44:
            com.google.gson.reflect.TypeToken<T> r1 = r3.typeToken
            java.lang.reflect.Type r1 = r1.getType()
            com.google.gson.internal.bind.TreeTypeAdapter<T>$GsonContextImpl r2 = r3.context
            java.lang.Object r4 = r0.deserialize(r4, r1, r2)
            return r4
        L51:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TreeTypeAdapter.read(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, t);
        } else if (this.nullSafe && t == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonSerializer.serialize(t, this.typeToken.getType(), this.context));
        }
    }
}
