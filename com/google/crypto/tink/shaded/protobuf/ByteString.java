package com.google.crypto.tink.shaded.protobuf;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final LiteralByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    public static final ByteArrayCopier byteArrayCopier;
    public int hash = 0;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ByteString$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends AbstractByteIterator {
        public final int limit;
        public int position = 0;

        public AnonymousClass1() {
            this.limit = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.position < this.limit) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class AbstractByteIterator implements Iterator {
        @Override // java.util.Iterator
        public final Object next() {
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) this;
            int r1 = anonymousClass1.position;
            if (r1 < anonymousClass1.limit) {
                anonymousClass1.position = r1 + 1;
                return Byte.valueOf(ByteString.this.internalByteAt(r1));
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public final byte[] copyFrom(byte[] bArr, int r2, int r3) {
            return Arrays.copyOfRange(bArr, r2, r3 + r2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class BoundedByteString extends LiteralByteString {
        public final int bytesLength;
        public final int bytesOffset;

        public BoundedByteString(byte[] bArr, int r3, int r4) {
            super(bArr);
            ByteString.checkRange(r3, r3 + r4, bArr.length);
            this.bytesOffset = r3;
            this.bytesLength = r4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public final byte byteAt(int r5) {
            int r1 = this.bytesLength;
            if (((r1 - (r5 + 1)) | r5) < 0) {
                if (r5 < 0) {
                    throw new ArrayIndexOutOfBoundsException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Index < 0: ", r5));
                }
                throw new ArrayIndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index > length: ", r5, ", ", r1));
            }
            return this.bytes[this.bytesOffset + r5];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public final void copyToInternal(int r4, byte[] bArr) {
            System.arraycopy(this.bytes, this.bytesOffset + 0, bArr, 0, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        public final int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public final byte internalByteAt(int r2) {
            return this.bytes[this.bytesOffset + r2];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public final int size() {
            return this.bytesLength;
        }
    }

    /* loaded from: classes3.dex */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int r2, int r3);
    }

    /* loaded from: classes3.dex */
    public static abstract class LeafByteString extends ByteString {
    }

    /* loaded from: classes3.dex */
    public static class LiteralByteString extends LeafByteString {
        public final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int r2) {
            return this.bytes[r2];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public void copyToInternal(int r3, byte[] bArr) {
            System.arraycopy(this.bytes, 0, bArr, 0, r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                LiteralByteString literalByteString = (LiteralByteString) obj;
                int r1 = this.hash;
                int r3 = literalByteString.hash;
                if (r1 != 0 && r3 != 0 && r1 != r3) {
                    return false;
                }
                int size = size();
                if (size <= literalByteString.size()) {
                    if (0 + size <= literalByteString.size()) {
                        int offsetIntoBytes = getOffsetIntoBytes() + size;
                        int offsetIntoBytes2 = getOffsetIntoBytes();
                        int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + 0;
                        while (offsetIntoBytes2 < offsetIntoBytes) {
                            if (this.bytes[offsetIntoBytes2] != literalByteString.bytes[offsetIntoBytes3]) {
                                return false;
                            }
                            offsetIntoBytes2++;
                            offsetIntoBytes3++;
                        }
                        return true;
                    }
                    StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Ran off end of other: 0, ", size, ", ");
                    m.append(literalByteString.size());
                    throw new IllegalArgumentException(m.toString());
                }
                throw new IllegalArgumentException("Length too large: " + size + size());
            }
            return obj.equals(this);
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte internalByteAt(int r2) {
            return this.bytes[r2];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final CodedInputStream.ArrayDecoder newCodedInput() {
            int offsetIntoBytes = getOffsetIntoBytes();
            int size = size();
            CodedInputStream.ArrayDecoder arrayDecoder = new CodedInputStream.ArrayDecoder(this.bytes, offsetIntoBytes, size, true);
            try {
                arrayDecoder.pushLimit(size);
                return arrayDecoder;
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int partialHash(int r4, int r5) {
            int offsetIntoBytes = getOffsetIntoBytes() + 0;
            Charset charset = Internal.UTF_8;
            for (int r1 = offsetIntoBytes; r1 < offsetIntoBytes + r5; r1++) {
                r4 = (r4 * 31) + this.bytes[r1];
            }
            return r4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final LiteralByteString substring(int r4) {
            int checkRange = ByteString.checkRange(0, r4, size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + 0, checkRange);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    /* loaded from: classes3.dex */
    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public final byte[] copyFrom(byte[] bArr, int r4, int r5) {
            byte[] bArr2 = new byte[r5];
            System.arraycopy(bArr, r4, bArr2, 0, r5);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier arraysByteArrayCopier;
        if (Android.isOnAndroidDevice()) {
            arraysByteArrayCopier = new SystemByteArrayCopier();
        } else {
            arraysByteArrayCopier = new ArraysByteArrayCopier();
        }
        byteArrayCopier = arraysByteArrayCopier;
    }

    public static int checkRange(int r3, int r4, int r5) {
        int r0 = r4 - r3;
        if ((r3 | r4 | r0 | (r5 - r4)) < 0) {
            if (r3 >= 0) {
                if (r4 < r3) {
                    throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Beginning index larger than ending index: ", r3, ", ", r4));
                }
                throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("End index: ", r4, " >= ", r5));
            }
            throw new IndexOutOfBoundsException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Beginning index: ", r3, " < 0"));
        }
        return r0;
    }

    public static LiteralByteString copyFrom(byte[] bArr, int r3, int r4) {
        checkRange(r3, r3 + r4, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, r3, r4));
    }

    public abstract byte byteAt(int r1);

    public abstract void copyToInternal(int r1, byte[] bArr);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int r0 = this.hash;
        if (r0 == 0) {
            int size = size();
            r0 = partialHash(size, size);
            if (r0 == 0) {
                r0 = 1;
            }
            this.hash = r0;
        }
        return r0;
    }

    public abstract byte internalByteAt(int r1);

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    public final Iterator<Byte> iterator() {
        return new AnonymousClass1();
    }

    public abstract CodedInputStream.ArrayDecoder newCodedInput();

    public abstract int partialHash(int r1, int r2);

    public abstract int size();

    public abstract LiteralByteString substring(int r1);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(size, bArr);
        return bArr;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = TextFormatEscaper.escapeBytes(this);
        } else {
            str = TextFormatEscaper.escapeBytes(substring(47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract String toStringInternal(Charset charset);

    public abstract void writeTo(ByteOutput byteOutput) throws IOException;
}
