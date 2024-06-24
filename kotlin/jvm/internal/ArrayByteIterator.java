package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ByteIterator;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes.dex */
public final class ArrayByteIterator extends ByteIterator {
    public final byte[] array;
    public int index;

    public ArrayByteIterator(byte[] bArr) {
        this.array = bArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.array.length) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.ByteIterator
    public final byte nextByte() {
        try {
            byte[] bArr = this.array;
            int r1 = this.index;
            this.index = r1 + 1;
            return bArr[r1];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
