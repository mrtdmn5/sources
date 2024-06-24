package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public final class NewInstanceSchemas {
    public static final NewInstanceSchema FULL_SCHEMA;
    public static final NewInstanceSchemaLite LITE_SCHEMA;

    static {
        NewInstanceSchema newInstanceSchema;
        try {
            newInstanceSchema = (NewInstanceSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            newInstanceSchema = null;
        }
        FULL_SCHEMA = newInstanceSchema;
        LITE_SCHEMA = new NewInstanceSchemaLite();
    }
}
