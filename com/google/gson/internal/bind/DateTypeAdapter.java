package com.google.gson.internal.bind;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final ArrayList dateFormats;

    /* renamed from: com.google.gson.internal.bind.DateTypeAdapter$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements TypeAdapterFactory {
        @Override // com.google.gson.TypeAdapterFactory
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    }

    public DateTypeAdapter() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.majorJavaVersion >= 9) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Date read(JsonReader jsonReader) throws IOException {
        Date parse;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            Iterator it = this.dateFormats.iterator();
            while (true) {
                if (it.hasNext()) {
                    try {
                        parse = ((DateFormat) it.next()).parse(nextString);
                        break;
                    } catch (ParseException unused) {
                    }
                } else {
                    try {
                        parse = ISO8601Utils.parse(nextString, new ParsePosition(0));
                        break;
                    } catch (ParseException e) {
                        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Failed parsing '", nextString, "' as Date; at path ");
                        m.append(jsonReader.getPreviousPath());
                        throw new JsonSyntaxException(m.toString(), e);
                    }
                }
            }
        }
        return parse;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        Date date2 = date;
        if (date2 == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            format = dateFormat.format(date2);
        }
        jsonWriter.value(format);
    }
}
