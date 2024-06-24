package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes3.dex */
public enum KeyStatusType implements Internal.EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    public static final int DESTROYED_VALUE = 3;
    public static final int DISABLED_VALUE = 2;
    public static final int ENABLED_VALUE = 1;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    private static final Internal.EnumLiteMap<KeyStatusType> internalValueMap = new AnonymousClass1();
    private final int value;

    /* renamed from: com.google.crypto.tink.proto.KeyStatusType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Internal.EnumLiteMap<KeyStatusType> {
    }

    /* loaded from: classes3.dex */
    public static final class KeyStatusTypeVerifier implements Internal.EnumVerifier {
        public static final KeyStatusTypeVerifier INSTANCE = new KeyStatusTypeVerifier();

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public final boolean isInRange(int number) {
            if (KeyStatusType.forNumber(number) != null) {
                return true;
            }
            return false;
        }
    }

    KeyStatusType(int value) {
        this.value = value;
    }

    public static KeyStatusType forNumber(int value) {
        if (value != 0) {
            if (value != 1) {
                if (value != 2) {
                    if (value != 3) {
                        return null;
                    }
                    return DESTROYED;
                }
                return DISABLED;
            }
            return ENABLED;
        }
        return UNKNOWN_STATUS;
    }

    public static Internal.EnumLiteMap<KeyStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return KeyStatusTypeVerifier.INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static KeyStatusType valueOf(int value) {
        return forNumber(value);
    }
}
