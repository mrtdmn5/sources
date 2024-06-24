package kotlin.collections;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes.dex */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    public int _size;
    public int fromIndex;
    public final List<E> list;

    /* JADX WARN: Multi-variable type inference failed */
    public MovingSubList(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    @Override // java.util.List
    public final E get(int r5) {
        int r0 = this._size;
        if (r5 >= 0 && r5 < r0) {
            return this.list.get(this.fromIndex + r5);
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", r0));
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this._size;
    }
}
