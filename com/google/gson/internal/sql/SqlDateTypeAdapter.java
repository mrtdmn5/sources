package com.google.gson.internal.sql;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final SimpleDateFormat format = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: com.google.gson.internal.sql.SqlDateTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Date read(JsonReader jsonReader) throws IOException {
        java.util.Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                parse = this.format.parse(nextString);
            }
            return new Date(parse.getTime());
        } catch (ParseException e) {
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as SQL Date; at path ");
            m.append(jsonReader.getPreviousPath());
            throw new JsonSyntaxException(m.toString(), e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        Date date2 = date;
        if (date2 == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.format.format((java.util.Date) date2);
        }
        jsonWriter.value(format);
    }
}
