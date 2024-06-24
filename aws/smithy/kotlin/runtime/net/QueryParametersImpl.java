package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.util.ValuesMapImpl;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryParameters.kt */
/* loaded from: classes.dex */
public final class QueryParametersImpl extends ValuesMapImpl<String> implements QueryParameters {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParametersImpl(Map<String, ? extends List<String>> values) {
        super(values, true);
        Intrinsics.checkNotNullParameter(values, "values");
    }

    @Override // aws.smithy.kotlin.runtime.util.ValuesMapImpl
    public final boolean equals(Object obj) {
        if ((obj instanceof QueryParameters) && Intrinsics.areEqual(entries(), ((QueryParameters) obj).entries())) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "QueryParameters " + entries();
    }
}
