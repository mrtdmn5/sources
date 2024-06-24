package androidx.compose.ui.text.font;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public final class FontListFontFamily extends FileBasedFontFamily implements List<Font>, KMappedMarker {
    public final /* synthetic */ List<Font> $$delegate_0;
    public final ArrayList fonts;

    /* JADX WARN: Multi-variable type inference failed */
    public FontListFontFamily(List<? extends Font> list) {
        this.$$delegate_0 = list;
        List<? extends Font> list2 = list;
        if (!list2.isEmpty()) {
            this.fonts = new ArrayList(list2);
            return;
        }
        throw new IllegalStateException("At least one font should be passed to FontFamily".toString());
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r1, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Font)) {
            return false;
        }
        Font element = (Font) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.$$delegate_0.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.$$delegate_0.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FontListFontFamily) && Intrinsics.areEqual(this.fonts, ((FontListFontFamily) obj).fonts)) {
            return true;
        }
        return false;
    }

    @Override // java.util.List
    public final Font get(int r2) {
        return this.$$delegate_0.get(r2);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.fonts.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        Font element = (Font) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.$$delegate_0.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<Font> iterator() {
        return this.$$delegate_0.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Font)) {
            return -1;
        }
        Font element = (Font) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return this.$$delegate_0.lastIndexOf(element);
    }

    @Override // java.util.List
    public final ListIterator<Font> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Font remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<Font> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Font set(int r1, Font font) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.$$delegate_0.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super Font> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<Font> subList(int r2, int r3) {
        return this.$$delegate_0.subList(r2, r3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return "FontListFontFamily(fonts=" + this.fonts + ')';
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Font> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<Font> listIterator(int r2) {
        return this.$$delegate_0.listIterator(r2);
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
