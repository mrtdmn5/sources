package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrieIterator.kt */
/* loaded from: classes.dex */
public final class TrieIterator<E> extends AbstractListIterator<E> {
    public int height;
    public boolean isInRightEdge;
    public Object[] path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public TrieIterator(Object[] root, int r4, int r5, int r6) {
        super(r4, r5);
        ?? r52;
        Intrinsics.checkNotNullParameter(root, "root");
        this.height = r6;
        Object[] objArr = new Object[r6];
        this.path = objArr;
        if (r4 == r5) {
            r52 = 1;
        } else {
            r52 = 0;
        }
        this.isInRightEdge = r52;
        objArr[0] = root;
        fillPath(r4 - r52, 1);
    }

    public final E elementAtCurrentIndex() {
        int r0 = this.index & 31;
        Object obj = this.path[this.height - 1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return (E) ((Object[]) obj)[r0];
    }

    public final void fillPath(int r5, int r6) {
        int r0 = (this.height - r6) * 5;
        while (r6 < this.height) {
            Object[] objArr = this.path;
            Object obj = objArr[r6 - 1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[r6] = ((Object[]) obj)[(r5 >> r0) & 31];
            r0 -= 5;
            r6++;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        int r3;
        if (hasNext()) {
            E elementAtCurrentIndex = elementAtCurrentIndex();
            int r1 = this.index + 1;
            this.index = r1;
            if (r1 == this.size) {
                this.isInRightEdge = true;
                return elementAtCurrentIndex;
            }
            int r12 = 0;
            while (true) {
                r3 = this.index;
                if (((r3 >> r12) & 31) != 0) {
                    break;
                }
                r12 += 5;
            }
            if (r12 > 0) {
                fillPath(r3, ((this.height - 1) - (r12 / 5)) + 1);
            }
            return elementAtCurrentIndex;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final E previous() {
        int r0;
        if (hasPrevious()) {
            this.index--;
            int r1 = 0;
            if (this.isInRightEdge) {
                this.isInRightEdge = false;
                return elementAtCurrentIndex();
            }
            while (true) {
                r0 = this.index;
                if (((r0 >> r1) & 31) != 31) {
                    break;
                }
                r1 += 5;
            }
            if (r1 > 0) {
                fillPath(r0, ((this.height - 1) - (r1 / 5)) + 1);
            }
            return elementAtCurrentIndex();
        }
        throw new NoSuchElementException();
    }
}
