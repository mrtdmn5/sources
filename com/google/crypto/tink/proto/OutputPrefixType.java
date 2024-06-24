package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes3.dex */
public enum OutputPrefixType implements Internal.EnumLite {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    public static final int CRUNCHY_VALUE = 4;
    public static final int LEGACY_VALUE = 2;
    public static final int RAW_VALUE = 3;
    public static final int TINK_VALUE = 1;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    private static final Internal.EnumLiteMap<OutputPrefixType> internalValueMap = new AnonymousClass1();
    private final int value;

    /* renamed from: com.google.crypto.tink.proto.OutputPrefixType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Internal.EnumLiteMap<OutputPrefixType> {
    }

    /* loaded from: classes3.dex */
    public static final class OutputPrefixTypeVerifier implements Internal.EnumVerifier {
        public static final OutputPrefixTypeVerifier INSTANCE = new OutputPrefixTypeVerifier();

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public final boolean isInRange(int number) {
            if (OutputPrefixType.forNumber(number) != null) {
                return true;
            }
            return false;
        }
    }

    OutputPrefixType(int value) {
        this.value = value;
    }

    public static OutputPrefixType forNumber(int value) {
        if (value != 0) {
            if (value != 1) {
                if (value != 2) {
                    if (value != 3) {
                        if (value != 4) {
                            return null;
                        }
                        return CRUNCHY;
                    }
                    return RAW;
                }
                return LEGACY;
            }
            return TINK;
        }
        return UNKNOWN_PREFIX;
    }

    public static Internal.EnumLiteMap<OutputPrefixType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return OutputPrefixTypeVerifier.INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static OutputPrefixType valueOf(int value) {
        return forNumber(value);
    }
}
