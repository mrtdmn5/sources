package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsReportJsonTransform$$ExternalSyntheticLambda0 implements CrashlyticsReportJsonTransform.ObjectParser {
    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public final Object parse(JsonReader jsonReader) {
        String str;
        jsonReader.beginObject();
        String str2 = null;
        byte[] bArr = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("filename")) {
                if (!nextName.equals("contents")) {
                    jsonReader.skipValue();
                } else {
                    bArr = Base64.decode(jsonReader.nextString(), 2);
                    if (bArr == null) {
                        throw new NullPointerException("Null contents");
                    }
                }
            } else {
                str2 = jsonReader.nextString();
                if (str2 == null) {
                    throw new NullPointerException("Null filename");
                }
            }
        }
        jsonReader.endObject();
        if (str2 == null) {
            str = " filename";
        } else {
            str = "";
        }
        if (bArr == null) {
            str = str.concat(" contents");
        }
        if (str.isEmpty()) {
            return new AutoValue_CrashlyticsReport_FilesPayload_File(str2, bArr);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }
}
