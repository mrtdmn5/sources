package aws.smithy.kotlin.runtime.net;

import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import aws.smithy.kotlin.runtime.util.ValuesMapBuilder;
import aws.smithy.kotlin.runtime.util.ValuesMapKt;
import java.util.LinkedHashMap;

/* compiled from: QueryParameters.kt */
/* loaded from: classes.dex */
public final class QueryParametersBuilder extends ValuesMapBuilder<String> implements CanDeepCopy<QueryParametersBuilder> {
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public final QueryParametersBuilder deepCopy() {
        LinkedHashMap deepCopy = ValuesMapKt.deepCopy(this.values);
        QueryParametersBuilder queryParametersBuilder = new QueryParametersBuilder();
        queryParametersBuilder.values.putAll(deepCopy);
        return queryParametersBuilder;
    }

    public final String toString() {
        return "QueryParametersBuilder " + this.values.entrySet() + ' ';
    }
}
