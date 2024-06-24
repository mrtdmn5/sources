package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.room.util.CursorUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: HitTestResult.kt */
/* loaded from: classes.dex */
public final class HitTestResult implements List<Modifier.Node>, KMappedMarker {
    public int size;
    public Object[] values = new Object[16];
    public long[] distanceFromEdgeAndInLayer = new long[16];
    public int hitDepth = -1;

    /* compiled from: HitTestResult.kt */
    /* loaded from: classes.dex */
    public final class SubList implements List<Modifier.Node>, KMappedMarker {
        public final int maxIndex;
        public final int minIndex;

        public SubList(int r2, int r3) {
            this.minIndex = r2;
            this.maxIndex = r3;
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ void add(int r1, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final boolean addAll(int r1, Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Modifier.Node)) {
                return false;
            }
            Modifier.Node element = (Modifier.Node) obj;
            Intrinsics.checkNotNullParameter(element, "element");
            if (indexOf(element) == -1) {
                return false;
            }
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains((Modifier.Node) it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public final Modifier.Node get(int r3) {
            Object obj = HitTestResult.this.values[r3 + this.minIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            if (!(obj instanceof Modifier.Node)) {
                return -1;
            }
            Modifier.Node element = (Modifier.Node) obj;
            Intrinsics.checkNotNullParameter(element, "element");
            int r0 = this.minIndex;
            int r2 = this.maxIndex;
            if (r0 > r2) {
                return -1;
            }
            int r3 = r0;
            while (!Intrinsics.areEqual(HitTestResult.this.values[r3], element)) {
                if (r3 == r2) {
                    return -1;
                }
                r3++;
            }
            return r3 - r0;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            if (this.maxIndex - this.minIndex == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<Modifier.Node> iterator() {
            int r1 = this.minIndex;
            return new HitTestResultIterator(r1, r1, this.maxIndex);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            if (!(obj instanceof Modifier.Node)) {
                return -1;
            }
            Modifier.Node element = (Modifier.Node) obj;
            Intrinsics.checkNotNullParameter(element, "element");
            int r0 = this.maxIndex;
            int r2 = this.minIndex;
            if (r2 > r0) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[r0], element)) {
                if (r0 == r2) {
                    return -1;
                }
                r0--;
            }
            return r0 - r2;
        }

        @Override // java.util.List
        public final ListIterator<Modifier.Node> listIterator() {
            int r1 = this.minIndex;
            return new HitTestResultIterator(r1, r1, this.maxIndex);
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Modifier.Node remove(int r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ Modifier.Node set(int r1, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.maxIndex - this.minIndex;
        }

        @Override // java.util.List
        public final void sort(Comparator<? super Modifier.Node> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final List<Modifier.Node> subList(int r3, int r4) {
            int r1 = this.minIndex;
            return new SubList(r3 + r1, r1 + r4);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final ListIterator<Modifier.Node> listIterator(int r5) {
            int r1 = this.minIndex;
            int r2 = this.maxIndex;
            return new HitTestResultIterator(r5 + r1, r1, r2);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return (T[]) CollectionToArray.toArray(this, array);
        }
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r1, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Modifier.Node)) {
            return false;
        }
        Modifier.Node element = (Modifier.Node) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        if (indexOf(element) == -1) {
            return false;
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains((Modifier.Node) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: findBestHitDistance-ptXAw2c */
    public final long m444findBestHitDistanceptXAw2c() {
        long access$DistanceAndInLayer = CursorUtil.access$DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int r2 = this.hitDepth + 1;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (r2 <= lastIndex) {
            while (true) {
                long j = this.distanceFromEdgeAndInLayer[r2];
                if (DistanceAndInLayer.m442compareToS_HNhKs(j, access$DistanceAndInLayer) < 0) {
                    access$DistanceAndInLayer = j;
                }
                if (Float.intBitsToFloat((int) (access$DistanceAndInLayer >> 32)) < 0.0f && DistanceAndInLayer.m443isInLayerimpl(access$DistanceAndInLayer)) {
                    return access$DistanceAndInLayer;
                }
                if (r2 == lastIndex) {
                    break;
                }
                r2++;
            }
        }
        return access$DistanceAndInLayer;
    }

    @Override // java.util.List
    public final Modifier.Node get(int r2) {
        Object obj = this.values[r2];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node) obj;
    }

    public final void hitInMinimumTouchTarget(Modifier.Node node, float f, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(node, "node");
        int r0 = this.hitDepth;
        int r1 = r0 + 1;
        this.hitDepth = r1;
        Object[] objArr = this.values;
        if (r1 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.values = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.distanceFromEdgeAndInLayer, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = copyOf2;
        }
        Object[] objArr2 = this.values;
        int r2 = this.hitDepth;
        objArr2[r2] = node;
        this.distanceFromEdgeAndInLayer[r2] = CursorUtil.access$DistanceAndInLayer(f, z);
        resizeToHitDepth();
        function0.invoke();
        this.hitDepth = r0;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Modifier.Node)) {
            return -1;
        }
        Modifier.Node element = (Modifier.Node) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (lastIndex < 0) {
            return -1;
        }
        int r2 = 0;
        while (!Intrinsics.areEqual(this.values[r2], element)) {
            if (r2 == lastIndex) {
                return -1;
            }
            r2++;
        }
        return r2;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<Modifier.Node> iterator() {
        return new HitTestResultIterator(this, 0, 7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Modifier.Node)) {
            return -1;
        }
        Modifier.Node element = (Modifier.Node) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(this.values[lastIndex], element)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator<Modifier.Node> listIterator() {
        return new HitTestResultIterator(this, 0, 7);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Modifier.Node remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void resizeToHitDepth() {
        int r0 = this.hitDepth + 1;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (r0 <= lastIndex) {
            while (true) {
                this.values[r0] = null;
                if (r0 == lastIndex) {
                    break;
                } else {
                    r0++;
                }
            }
        }
        this.size = this.hitDepth + 1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Modifier.Node set(int r1, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // java.util.List
    public final void sort(Comparator<? super Modifier.Node> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<Modifier.Node> subList(int r2, int r3) {
        return new SubList(r2, r3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    /* compiled from: HitTestResult.kt */
    /* loaded from: classes.dex */
    public final class HitTestResultIterator implements ListIterator<Modifier.Node>, KMappedMarker {
        public int index;
        public final int maxIndex;
        public final int minIndex;

        public HitTestResultIterator(HitTestResult hitTestResult, int r4, int r5) {
            this((r5 & 1) != 0 ? 0 : r4, 0, (r5 & 4) != 0 ? hitTestResult.size : 0);
        }

        @Override // java.util.ListIterator
        public final /* bridge */ /* synthetic */ void add(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.index < this.maxIndex) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.index > this.minIndex) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            Object[] objArr = HitTestResult.this.values;
            int r1 = this.index;
            this.index = r1 + 1;
            Object obj = objArr[r1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.index - this.minIndex;
        }

        @Override // java.util.ListIterator
        public final Modifier.Node previous() {
            Object[] objArr = HitTestResult.this.values;
            int r1 = this.index - 1;
            this.index = r1;
            Object obj = objArr[r1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final /* bridge */ /* synthetic */ void set(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public HitTestResultIterator(int r2, int r3, int r4) {
            this.index = r2;
            this.minIndex = r3;
            this.maxIndex = r4;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<Modifier.Node> listIterator(int r3) {
        return new HitTestResultIterator(this, r3, 6);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
