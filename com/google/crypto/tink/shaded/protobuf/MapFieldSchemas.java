package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public final class MapFieldSchemas {
    public static final MapFieldSchema FULL_SCHEMA;
    public static final MapFieldSchemaLite LITE_SCHEMA;

    static {
        MapFieldSchema mapFieldSchema;
        try {
            mapFieldSchema = (MapFieldSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            mapFieldSchema = null;
        }
        FULL_SCHEMA = mapFieldSchema;
        LITE_SCHEMA = new MapFieldSchemaLite();
    }
}
