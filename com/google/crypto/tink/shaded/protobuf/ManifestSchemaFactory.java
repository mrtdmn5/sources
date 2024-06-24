package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class ManifestSchemaFactory {
    public static final AnonymousClass1 EMPTY_FACTORY = new AnonymousClass1();
    public final MessageInfoFactory messageInfoFactory;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ManifestSchemaFactory$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements MessageInfoFactory {
        @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
        public final boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
        public final MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    /* loaded from: classes3.dex */
    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        public final MessageInfoFactory[] factories;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
        public final boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
        public final MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }
    }

    public ManifestSchemaFactory() {
        MessageInfoFactory messageInfoFactory;
        MessageInfoFactory[] messageInfoFactoryArr = new MessageInfoFactory[2];
        messageInfoFactoryArr[0] = GeneratedMessageInfoFactory.instance;
        try {
            messageInfoFactory = (MessageInfoFactory) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            messageInfoFactory = EMPTY_FACTORY;
        }
        messageInfoFactoryArr[1] = messageInfoFactory;
        CompositeMessageInfoFactory compositeMessageInfoFactory = new CompositeMessageInfoFactory(messageInfoFactoryArr);
        Charset charset = Internal.UTF_8;
        this.messageInfoFactory = compositeMessageInfoFactory;
    }
}
