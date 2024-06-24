package aws.smithy.kotlin.runtime.http;

import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import aws.smithy.kotlin.runtime.util.ValuesMapBuilder;
import aws.smithy.kotlin.runtime.util.ValuesMapKt;
import java.util.LinkedHashMap;

/* compiled from: Headers.kt */
/* loaded from: classes.dex */
public final class HeadersBuilder extends ValuesMapBuilder<String> implements CanDeepCopy<HeadersBuilder> {
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public final HeadersBuilder deepCopy() {
        LinkedHashMap deepCopy = ValuesMapKt.deepCopy(this.values);
        HeadersBuilder headersBuilder = new HeadersBuilder();
        headersBuilder.values.putAll(deepCopy);
        return headersBuilder;
    }

    public final String toString() {
        return "HeadersBuilder " + this.values.entrySet() + ' ';
    }
}
