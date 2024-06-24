package com.google.firebase.encoders.json;

import com.amazonaws.util.DateUtils;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    public final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 fallbackEncoder;
    public boolean ignoreNullValues;
    public final HashMap objectEncoders;
    public final HashMap valueEncoders;
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_FALLBACK_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0();
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda1 STRING_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda1();
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda2 BOOLEAN_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda2();
    public static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();

    /* renamed from: com.google.firebase.encoders.json.JsonDataEncoderBuilder$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 {
        public AnonymousClass1() {
        }

        public final void encode(Object obj, Writer writer) throws IOException {
            JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
            jsonValueObjectEncoderContext.add(obj);
            jsonValueObjectEncoderContext.maybeUnNest();
            jsonValueObjectEncoderContext.jsonWriter.flush();
        }
    }

    /* loaded from: classes3.dex */
    public static final class TimestampEncoder implements ValueEncoder<Date> {
        public static final SimpleDateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN, Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ValueEncoderContext valueEncoderContext) throws IOException {
            valueEncoderContext.add(rfc339.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        HashMap hashMap = new HashMap();
        this.objectEncoders = hashMap;
        HashMap hashMap2 = new HashMap();
        this.valueEncoders = hashMap2;
        this.fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
        this.ignoreNullValues = false;
        hashMap2.put(String.class, STRING_ENCODER);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, BOOLEAN_ENCODER);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, TIMESTAMP_ENCODER);
        hashMap.remove(Date.class);
    }

    public final EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }
}
