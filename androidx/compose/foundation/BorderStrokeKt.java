package androidx.compose.foundation;

import androidx.compose.foundation.BorderStrokeKt;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.CharMappings;

/* compiled from: BorderStroke.kt */
/* loaded from: classes.dex */
public class BorderStrokeKt {
    public static final byte charToTokenClass(char c) {
        if (c < '~') {
            return CharMappings.CHAR_TO_TOKEN[c];
        }
        return (byte) 0;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0] */
    public static final ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0 compareBy(final Function1... function1Arr) {
        boolean z;
        if (function1Arr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Function1[] selectors = function1Arr;
                    Intrinsics.checkNotNullParameter(selectors, "$selectors");
                    for (Function1 function1 : selectors) {
                        int compareValues = BorderStrokeKt.compareValues((Comparable) function1.invoke(obj), (Comparable) function1.invoke(obj2));
                        if (compareValues != 0) {
                            return compareValues;
                        }
                    }
                    return 0;
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int compareValues(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }
}
