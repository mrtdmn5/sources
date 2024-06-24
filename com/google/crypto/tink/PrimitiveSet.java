package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class PrimitiveSet<P> {
    public Entry<P> primary;
    public final Class<P> primitiveClass;
    public final ConcurrentHashMap primitives = new ConcurrentHashMap();

    /* loaded from: classes3.dex */
    public static final class Entry<P> {
        public final byte[] identifier;
        public final OutputPrefixType outputPrefixType;
        public final P primitive;
        public final KeyStatusType status;

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(Object obj, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType) {
            this.primitive = obj;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }
    }

    /* loaded from: classes3.dex */
    public static class Prefix implements Comparable<Prefix> {
        public final byte[] prefix;

        public Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        @Override // java.lang.Comparable
        public final int compareTo(Prefix o) {
            Prefix prefix = o;
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = prefix.prefix;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int r2 = 0; r2 < bArr.length; r2++) {
                byte b = bArr[r2];
                byte b2 = prefix.prefix[r2];
                if (b != b2) {
                    return b - b2;
                }
            }
            return 0;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.prefix, ((Prefix) o).prefix);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public final String toString() {
            return Hex.encode(this.prefix);
        }
    }

    public PrimitiveSet(Class<P> primitiveClass) {
        this.primitiveClass = primitiveClass;
    }

    public final List<Entry<P>> getPrimitive(final byte[] identifier) {
        List<Entry<P>> list = (List) this.primitives.get(new Prefix(identifier));
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }
}
