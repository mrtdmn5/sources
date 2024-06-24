package com.animaconnected.watch.strings;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringsExtensions.kt */
/* loaded from: classes3.dex */
public final class Translated extends KeyString {
    private final Key key;
    private final List<String> values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Translated(Key key, List<String> values) {
        super(null);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        this.key = key;
        this.values = values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Translated copy$default(Translated translated, Key key, List list, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            key = translated.key;
        }
        if ((r3 & 2) != 0) {
            list = translated.values;
        }
        return translated.copy(key, list);
    }

    public final Key component1() {
        return this.key;
    }

    public final List<String> component2() {
        return this.values;
    }

    public final Translated copy(Key key, List<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        return new Translated(key, values);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Translated)) {
            return false;
        }
        Translated translated = (Translated) obj;
        if (this.key == translated.key && Intrinsics.areEqual(this.values, translated.values)) {
            return true;
        }
        return false;
    }

    public final Key getKey() {
        return this.key;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public int hashCode() {
        return this.values.hashCode() + (this.key.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Translated(key=");
        sb.append(this.key);
        sb.append(", values=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.values, ')');
    }

    public /* synthetic */ Translated(Key key, List list, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(key, (r3 & 2) != 0 ? EmptyList.INSTANCE : list);
    }
}
