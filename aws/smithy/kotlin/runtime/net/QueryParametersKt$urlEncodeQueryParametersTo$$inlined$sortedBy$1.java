package aws.smithy.kotlin.runtime.net;

import androidx.compose.foundation.BorderStrokeKt;
import java.util.Comparator;
import java.util.Map;

/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public final class QueryParametersKt$urlEncodeQueryParametersTo$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return BorderStrokeKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
    }
}
