package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Collection;
import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ImmutableList.kt */
/* loaded from: classes.dex */
public interface ImmutableList<E> extends List<E>, Collection, KMappedMarker {

    /* compiled from: ImmutableList.kt */
    /* loaded from: classes.dex */
    public static final class SubList<E> extends AbstractList<E> implements ImmutableList<E> {
        public final int _size;
        public final int fromIndex;
        public final ImmutableList<E> source;

        /* JADX WARN: Multi-variable type inference failed */
        public SubList(ImmutableList<? extends E> source, int r3, int r4) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.fromIndex = r3;
            ListImplementation.checkRangeIndexes$runtime_release(r3, r4, source.size());
            this._size = r4 - r3;
        }

        @Override // java.util.List
        public final E get(int r2) {
            ListImplementation.checkElementIndex$runtime_release(r2, this._size);
            return this.source.get(this.fromIndex + r2);
        }

        @Override // kotlin.collections.AbstractCollection
        public final int getSize() {
            return this._size;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public final List subList(int r3, int r4) {
            ListImplementation.checkRangeIndexes$runtime_release(r3, r4, this._size);
            int r1 = this.fromIndex;
            return new SubList(this.source, r3 + r1, r1 + r4);
        }
    }
}
