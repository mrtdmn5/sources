package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.auto.value.AutoValue;
import java.io.BufferedReader;
import java.io.IOException;

@AutoValue
/* loaded from: classes3.dex */
public abstract class LogResponse {
    public static AutoValue_LogResponse fromJson(BufferedReader bufferedReader) throws IOException {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        return new AutoValue_LogResponse(Long.parseLong(jsonReader.nextString()));
                    }
                    return new AutoValue_LogResponse(jsonReader.nextLong());
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long getNextRequestWaitMillis();
}
