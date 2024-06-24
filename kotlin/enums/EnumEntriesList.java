package kotlin.enums;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnumEntries.kt */
/* loaded from: classes.dex */
public final class EnumEntriesList<T extends Enum<T>> extends AbstractList<T> implements EnumEntries<T>, Serializable {
    public final T[] entries;

    public EnumEntriesList(T[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        if (((Enum) ArraysKt___ArraysKt.getOrNull(element.ordinal(), this.entries)) != element) {
            return false;
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int r5) {
        T[] tArr = this.entries;
        int length = tArr.length;
        if (r5 >= 0 && r5 < length) {
            return tArr[r5];
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", length));
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.entries.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        int ordinal = element.ordinal();
        if (((Enum) ArraysKt___ArraysKt.getOrNull(ordinal, this.entries)) != element) {
            return -1;
        }
        return ordinal;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf(element);
    }
}
