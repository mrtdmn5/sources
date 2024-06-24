package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes3.dex */
public final class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final TypeAdapter<Date> dateTypeAdapter;

    /* renamed from: com.google.gson.internal.sql.SqlTimestampTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Timestamp.class) {
                gson.getClass();
                return new SqlTimestampTypeAdapter(gson.getAdapter(TypeToken.get(Date.class)));
            }
            return null;
        }
    }

    public SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.dateTypeAdapter = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public final Timestamp read(JsonReader jsonReader) throws IOException {
        Date read = this.dateTypeAdapter.read(jsonReader);
        if (read != null) {
            return new Timestamp(read.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.dateTypeAdapter.write(jsonWriter, timestamp);
    }
}
