package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
public class LazyFieldLite {
    public volatile ByteString memoizedBytes;
    public volatile MessageLite value;

    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.value;
        MessageLite messageLite2 = lazyFieldLite.value;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType$1()));
        }
        return getValue(messageLite2.getDefaultInstanceForType$1()).equals(messageLite2);
    }

    public final MessageLite getValue(MessageLite messageLite) {
        if (this.value == null) {
            synchronized (this) {
                if (this.value == null) {
                    try {
                        this.value = messageLite;
                        this.memoizedBytes = ByteString.EMPTY;
                    } catch (InvalidProtocolBufferException unused) {
                        this.value = messageLite;
                        this.memoizedBytes = ByteString.EMPTY;
                    }
                }
            }
        }
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    public final ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                return this.memoizedBytes;
            }
            if (this.value == null) {
                this.memoizedBytes = ByteString.EMPTY;
            } else {
                this.memoizedBytes = this.value.toByteString();
            }
            return this.memoizedBytes;
        }
    }
}
