package com.google.crypto.tink.shaded.protobuf;

import androidx.work.InputMergerFactory;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.DEFAULT_INSTANCE;
    protected int memoizedSerializedSize = -1;

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        public final MessageType defaultInstance;
        public MessageType instance;
        public boolean isBuilt = false;

        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        public static void mergeFromInstance(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(generatedMessageLite.getClass()).mergeFrom(generatedMessageLite, generatedMessageLite2);
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw new UninitializedMessageException();
        }

        public final MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            MessageType messagetype = this.instance;
            messagetype.getClass();
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            protobuf.schemaFor(messagetype.getClass()).makeImmutable(messagetype);
            this.isBuilt = true;
            return this.instance;
        }

        public final Object clone() throws CloneNotSupportedException {
            MessageType messagetype = this.defaultInstance;
            messagetype.getClass();
            Builder builder = (Builder) messagetype.dynamicMethod(MethodToInvoke.NEW_BUILDER);
            MessageType buildPartial = buildPartial();
            builder.copyOnWrite();
            mergeFromInstance(builder.instance, buildPartial);
            return builder;
        }

        public final void copyOnWrite() {
            if (this.isBuilt) {
                MessageType messagetype = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                mergeFromInstance(messagetype, this.instance);
                this.instance = messagetype;
                this.isBuilt = false;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public final GeneratedMessageLite getDefaultInstanceForType$1() {
            return this.defaultInstance;
        }
    }

    /* loaded from: classes3.dex */
    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        public DefaultInstanceBasedParser(T t) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements MessageLiteOrBuilder {
        protected FieldSet<ExtensionDescriptor> extensions = FieldSet.DEFAULT_INSTANCE;
    }

    /* loaded from: classes3.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends InputMergerFactory {
    }

    /* loaded from: classes3.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite == null) {
            GeneratedMessageLite generatedMessageLite2 = (GeneratedMessageLite) UnsafeUtil.allocateInstance(cls);
            generatedMessageLite2.getClass();
            generatedMessageLite = (T) generatedMessageLite2.dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
            if (generatedMessageLite != null) {
                defaultInstanceMap.put(cls, generatedMessageLite);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) generatedMessageLite;
    }

    public static Object invokeOrDie(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream.ArrayDecoder newCodedInput = byteString.newCodedInput();
        T t2 = (T) parsePartialFrom(t, newCodedInput, extensionRegistryLite);
        newCodedInput.checkLastTagWas(0);
        if (t2.isInitialized()) {
            return t2;
        }
        throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            Schema schemaFor = protobuf.schemaFor(t2.getClass());
            CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
            if (codedInputStreamReader == null) {
                codedInputStreamReader = new CodedInputStreamReader(codedInputStream);
            }
            schemaFor.mergeFrom(t2, codedInputStreamReader, extensionRegistryLite);
            schemaFor.makeImmutable(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage());
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE)).getClass().isInstance(obj)) {
            return false;
        }
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        return protobuf.schemaFor(getClass()).equals(this, (GeneratedMessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final GeneratedMessageLite getDefaultInstanceForType$1() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    public final int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            this.memoizedSerializedSize = protobuf.schemaFor(getClass()).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public final int hashCode() {
        int r0 = this.memoizedHashCode;
        if (r0 != 0) {
            return r0;
        }
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        int hashCode = protobuf.schemaFor(getClass()).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte byteValue = ((Byte) dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        boolean isInitialized = protobuf.schemaFor(getClass()).isInitialized(this);
        dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED);
        return isInitialized;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Builder newBuilderForType$1() {
        return (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    public final void setMemoizedSerializedSize(int r1) {
        this.memoizedSerializedSize = r1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Builder toBuilder$1() {
        Builder builder = (Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        builder.copyOnWrite();
        Builder.mergeFromInstance(builder.instance, this);
        return builder;
    }

    public final String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        MessageLiteToString.reflectivePrintWithIndent(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Protobuf protobuf = Protobuf.INSTANCE;
        protobuf.getClass();
        Schema schemaFor = protobuf.schemaFor(getClass());
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        if (codedOutputStreamWriter == null) {
            codedOutputStreamWriter = new CodedOutputStreamWriter(codedOutputStream);
        }
        schemaFor.writeTo(this, codedOutputStreamWriter);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int length = bArr.length;
        T t2 = (T) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            Protobuf protobuf = Protobuf.INSTANCE;
            protobuf.getClass();
            Schema schemaFor = protobuf.schemaFor(t2.getClass());
            schemaFor.mergeFrom(t2, bArr, 0, length + 0, new ArrayDecoders.Registers(extensionRegistryLite));
            schemaFor.makeImmutable(t2);
            if (t2.memoizedHashCode == 0) {
                if (t2.isInitialized()) {
                    return t2;
                }
                throw new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ((ExtensionDescriptor) obj).getClass();
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat$JavaType getLiteJavaType() {
            throw null;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            Builder builder2 = (Builder) builder;
            builder2.copyOnWrite();
            Builder.mergeFromInstance(builder2.instance, (GeneratedMessageLite) messageLite);
            return builder2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final void getLiteType() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final void getNumber() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final void isPacked() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public final void isRepeated() {
        }
    }
}
