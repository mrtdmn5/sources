package androidx.compose.ui;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Modifier.kt */
/* loaded from: classes.dex */
public final class CombinedModifier implements Modifier {
    public final Modifier inner;
    public final Modifier outer;

    public CombinedModifier(Modifier outer, Modifier inner) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.outer = outer;
        this.inner = inner;
    }

    @Override // androidx.compose.ui.Modifier
    public final boolean all(Function1<? super Modifier.Element, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (this.outer.all(predicate) && this.inner.all(predicate)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (Intrinsics.areEqual(this.outer, combinedModifier.outer) && Intrinsics.areEqual(this.inner, combinedModifier.inner)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public final <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.inner.foldIn(this.outer.foldIn(r, operation), operation);
    }

    public final int hashCode() {
        return (this.inner.hashCode() * 31) + this.outer.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("["), (String) foldIn("", new Function2<String, Modifier.Element, String>() { // from class: androidx.compose.ui.CombinedModifier$toString$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, Modifier.Element element) {
                boolean z;
                String acc = str;
                Modifier.Element element2 = element;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element2, "element");
                if (acc.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return element2.toString();
                }
                return acc + ", " + element2;
            }
        }), ']');
    }
}
