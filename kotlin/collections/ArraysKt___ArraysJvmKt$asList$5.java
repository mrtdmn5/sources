package kotlin.collections;

import java.util.RandomAccess;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes.dex */
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    public final /* synthetic */ float[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$5(float[] fArr) {
        this.$this_asList = fArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        boolean z;
        if (!(obj instanceof Float)) {
            return false;
        }
        float floatValue = ((Number) obj).floatValue();
        for (float f : this.$this_asList) {
            if (Float.floatToIntBits(f) == Float.floatToIntBits(floatValue)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        return Float.valueOf(this.$this_asList[r2]);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        boolean z;
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Number) obj).floatValue();
        float[] fArr = this.$this_asList;
        int length = fArr.length;
        for (int r4 = 0; r4 < length; r4++) {
            if (Float.floatToIntBits(fArr[r4]) == Float.floatToIntBits(floatValue)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return r4;
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
        boolean z;
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Number) obj).floatValue();
        float[] fArr = this.$this_asList;
        int length = fArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int r3 = length - 1;
            if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(floatValue)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return length;
            }
            if (r3 < 0) {
                return -1;
            }
            length = r3;
        }
    }
}
