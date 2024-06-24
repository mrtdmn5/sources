package androidx.compose.ui.text;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.ui.text.AnnotatedString;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public final class AnnotatedString$special$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t).start), Integer.valueOf(((AnnotatedString.Range) t2).start));
    }
}
