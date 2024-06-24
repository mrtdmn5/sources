package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;

/* loaded from: classes3.dex */
public final class KeyTemplate {
    public final com.google.crypto.tink.proto.KeyTemplate kt;

    /* renamed from: com.google.crypto.tink.KeyTemplate$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType;
        public static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = r0;
            try {
                r0[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] r4 = new int[com.google.crypto.tink.proto.OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r4;
            try {
                r4[com.google.crypto.tink.proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    public KeyTemplate(com.google.crypto.tink.proto.KeyTemplate kt) {
        this.kt = kt;
    }

    public static KeyTemplate create(String typeUrl, byte[] value, OutputPrefixType outputPrefixType) {
        com.google.crypto.tink.proto.OutputPrefixType outputPrefixType2;
        KeyTemplate.Builder newBuilder = com.google.crypto.tink.proto.KeyTemplate.newBuilder();
        newBuilder.copyOnWrite();
        com.google.crypto.tink.proto.KeyTemplate.access$100((com.google.crypto.tink.proto.KeyTemplate) newBuilder.instance, typeUrl);
        ByteString.LiteralByteString copyFrom = ByteString.copyFrom(value, 0, value.length);
        newBuilder.copyOnWrite();
        com.google.crypto.tink.proto.KeyTemplate.access$400((com.google.crypto.tink.proto.KeyTemplate) newBuilder.instance, copyFrom);
        int r3 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (r3 != 1) {
            if (r3 != 2) {
                if (r3 != 3) {
                    if (r3 == 4) {
                        outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.CRUNCHY;
                    } else {
                        throw new IllegalArgumentException("Unknown output prefix type");
                    }
                } else {
                    outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.RAW;
                }
            } else {
                outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.LEGACY;
            }
        } else {
            outputPrefixType2 = com.google.crypto.tink.proto.OutputPrefixType.TINK;
        }
        newBuilder.copyOnWrite();
        com.google.crypto.tink.proto.KeyTemplate.access$700((com.google.crypto.tink.proto.KeyTemplate) newBuilder.instance, outputPrefixType2);
        return new KeyTemplate(newBuilder.build());
    }
}
