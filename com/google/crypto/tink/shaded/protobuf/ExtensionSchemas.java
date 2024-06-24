package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public final class ExtensionSchemas {
    public static final ExtensionSchema<?> FULL_SCHEMA;
    public static final ExtensionSchemaLite LITE_SCHEMA = new ExtensionSchemaLite();

    static {
        ExtensionSchema<?> extensionSchema;
        try {
            extensionSchema = (ExtensionSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            extensionSchema = null;
        }
        FULL_SCHEMA = extensionSchema;
    }
}
