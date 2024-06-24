package kotlin.collections;

import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes.dex */
public final class ArraysKt___ArraysJvmKt$asList$1 extends AbstractList<Byte> implements RandomAccess {
    public final /* synthetic */ byte[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$1(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Byte)) {
            return false;
        }
        byte byteValue = ((Number) obj).byteValue();
        byte[] bArr = this.$this_asList;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        int r3 = 0;
        while (true) {
            if (r3 < length) {
                if (byteValue == bArr[r3]) {
                    break;
                }
                r3++;
            } else {
                r3 = -1;
                break;
            }
        }
        if (r3 < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        return Byte.valueOf(this.$this_asList[r2]);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Byte)) {
            return -1;
        }
        byte byteValue = ((Number) obj).byteValue();
        byte[] bArr = this.$this_asList;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int r3 = 0; r3 < length; r3++) {
            if (byteValue == bArr[r3]) {
                return r3;
            }
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        if (this.$this_asList.length == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Byte)) {
            return -1;
        }
        byte byteValue = ((Number) obj).byteValue();
        byte[] bArr = this.$this_asList;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int r3 = length - 1;
            if (byteValue == bArr[length]) {
                return length;
            }
            if (r3 < 0) {
                return -1;
            }
            length = r3;
        }
    }
}
