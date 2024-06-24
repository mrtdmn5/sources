package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public abstract void extensionNumber(Map.Entry entry);

    public abstract GeneratedMessageLite.GeneratedExtension findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int r3);

    public abstract FieldSet<T> getExtensions(Object obj);

    public abstract FieldSet<T> getMutableExtensions(Object obj);

    public abstract boolean hasExtensions(MessageLite messageLite);

    public abstract void makeImmutable(Object obj);

    public abstract Object parseExtension(Object obj) throws IOException;

    public abstract void parseLengthPrefixedMessageSetItem(Object obj) throws IOException;

    public abstract void parseMessageSetItem(Object obj) throws IOException;

    public abstract void serializeExtension(Map.Entry entry) throws IOException;
}
