package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ListFieldSchema;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class Protobuf {
    public static final Protobuf INSTANCE = new Protobuf();
    public final ConcurrentHashMap schemaCache = new ConcurrentHashMap();
    public final ManifestSchemaFactory schemaFactory = new ManifestSchemaFactory();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.crypto.tink.shaded.protobuf.MessageSetSchema] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.google.crypto.tink.shaded.protobuf.MessageSetSchema] */
    public final <T> Schema<T> schemaFor(Class<T> cls) {
        MessageSchema newSchema;
        MessageSchema messageSchema;
        Class<?> cls2;
        Charset charset = Internal.UTF_8;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.schemaCache;
            Schema<T> schema = (Schema) concurrentHashMap.get(cls);
            if (schema == null) {
                ManifestSchemaFactory manifestSchemaFactory = this.schemaFactory;
                manifestSchemaFactory.getClass();
                Class<?> cls3 = SchemaUtil.GENERATED_MESSAGE_CLASS;
                if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = SchemaUtil.GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                }
                MessageInfo messageInfoFor = manifestSchemaFactory.messageInfoFactory.messageInfoFor(cls);
                if (messageInfoFor.isMessageSetWireFormat()) {
                    if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                        messageSchema = new MessageSetSchema(SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, ExtensionSchemas.LITE_SCHEMA, messageInfoFor.getDefaultInstance());
                    } else {
                        UnknownFieldSchema<?, ?> unknownFieldSchema = SchemaUtil.PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
                        ExtensionSchema<?> extensionSchema = ExtensionSchemas.FULL_SCHEMA;
                        if (extensionSchema != null) {
                            messageSchema = new MessageSetSchema(unknownFieldSchema, extensionSchema, messageInfoFor.getDefaultInstance());
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    }
                    newSchema = messageSchema;
                } else {
                    boolean z = true;
                    if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                        if (messageInfoFor.getSyntax() != ProtoSyntax.PROTO2) {
                            z = false;
                        }
                        if (z) {
                            newSchema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.LITE_SCHEMA, ListFieldSchema.LITE_INSTANCE, SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, ExtensionSchemas.LITE_SCHEMA, MapFieldSchemas.LITE_SCHEMA);
                        } else {
                            newSchema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.LITE_SCHEMA, ListFieldSchema.LITE_INSTANCE, SchemaUtil.UNKNOWN_FIELD_SET_LITE_SCHEMA, null, MapFieldSchemas.LITE_SCHEMA);
                        }
                    } else {
                        if (messageInfoFor.getSyntax() != ProtoSyntax.PROTO2) {
                            z = false;
                        }
                        if (z) {
                            NewInstanceSchema newInstanceSchema = NewInstanceSchemas.FULL_SCHEMA;
                            ListFieldSchema.ListFieldSchemaFull listFieldSchemaFull = ListFieldSchema.FULL_INSTANCE;
                            UnknownFieldSchema<?, ?> unknownFieldSchema2 = SchemaUtil.PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
                            ExtensionSchema<?> extensionSchema2 = ExtensionSchemas.FULL_SCHEMA;
                            if (extensionSchema2 != null) {
                                newSchema = MessageSchema.newSchema(messageInfoFor, newInstanceSchema, listFieldSchemaFull, unknownFieldSchema2, extensionSchema2, MapFieldSchemas.FULL_SCHEMA);
                            } else {
                                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                            }
                        } else {
                            newSchema = MessageSchema.newSchema(messageInfoFor, NewInstanceSchemas.FULL_SCHEMA, ListFieldSchema.FULL_INSTANCE, SchemaUtil.PROTO3_UNKNOWN_FIELD_SET_SCHEMA, null, MapFieldSchemas.FULL_SCHEMA);
                        }
                    }
                }
                Schema<T> schema2 = (Schema) concurrentHashMap.putIfAbsent(cls, newSchema);
                if (schema2 != null) {
                    return schema2;
                }
                return newSchema;
            }
            return schema;
        }
        throw new NullPointerException("messageType");
    }
}
