package androidx.compose.ui.platform;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$sortByGeometryGroupings$$inlined$compareBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(Float.valueOf(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$getGetTraversalIndex((SemanticsNode) t)), Float.valueOf(AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$getGetTraversalIndex((SemanticsNode) t2)));
    }
}
