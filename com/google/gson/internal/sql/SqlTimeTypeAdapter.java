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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes3.dex */
public final class SqlTimeTypeAdapter extends TypeAdapter<Time> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: com.google.gson.internal.sql.SqlTimeTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Time read(JsonReader jsonReader) throws IOException {
        Time time;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        try {
            synchronized (this) {
                time = new Time(this.format.parse(nextString).getTime());
            }
            return time;
        } catch (ParseException e) {
            StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as SQL Time; at path ");
            m.append(jsonReader.getPreviousPath());
            throw new JsonSyntaxException(m.toString(), e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Time time) throws IOException {
        String format;
        Time time2 = time;
        if (time2 == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this) {
            format = this.format.format((Date) time2);
        }
        jsonWriter.value(format);
    }
}
