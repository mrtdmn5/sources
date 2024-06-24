package aws.smithy.kotlin.runtime.client.endpoints;

import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.util.Attributes;
import aws.smithy.kotlin.runtime.util.AttributesImpl;
import aws.smithy.kotlin.runtime.util.ValuesMap;

/* compiled from: Endpoint.kt */
/* loaded from: classes.dex */
public final class Endpoint {
    public final Attributes attributes;
    public final ValuesMap<String> headers;
    public final Url uri;

    public Endpoint() {
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Endpoint(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1 r0 = new aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1
            r0.<init>(r2)
            aws.smithy.kotlin.runtime.net.UrlBuilder r2 = new aws.smithy.kotlin.runtime.net.UrlBuilder
            r2.<init>()
            r0.invoke(r2)
            aws.smithy.kotlin.runtime.net.Url r2 = r2.build()
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.client.endpoints.Endpoint.<init>(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:22:0x004a->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof aws.smithy.kotlin.runtime.client.endpoints.Endpoint
            r1 = 0
            if (r0 == 0) goto L81
            aws.smithy.kotlin.runtime.client.endpoints.Endpoint r8 = (aws.smithy.kotlin.runtime.client.endpoints.Endpoint) r8
            aws.smithy.kotlin.runtime.net.Url r0 = r8.uri
            aws.smithy.kotlin.runtime.net.Url r2 = r7.uri
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 == 0) goto L81
            aws.smithy.kotlin.runtime.util.ValuesMap<java.lang.String> r0 = r7.headers
            aws.smithy.kotlin.runtime.util.ValuesMap<java.lang.String> r2 = r8.headers
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L81
            aws.smithy.kotlin.runtime.util.Attributes r0 = r7.attributes
            java.util.Set r2 = r0.getKeys()
            int r2 = r2.size()
            aws.smithy.kotlin.runtime.util.Attributes r3 = r8.attributes
            java.util.Set r3 = r3.getKeys()
            int r3 = r3.size()
            r4 = 1
            if (r2 != r3) goto L7d
            java.util.Set r2 = r0.getKeys()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L46
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L46
            goto L78
        L46:
            java.util.Iterator r2 = r2.iterator()
        L4a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L78
            java.lang.Object r3 = r2.next()
            aws.smithy.kotlin.runtime.util.AttributeKey r3 = (aws.smithy.kotlin.runtime.util.AttributeKey) r3
            boolean r5 = r0.contains(r3)
            if (r5 == 0) goto L73
            java.lang.String r5 = "null cannot be cast to non-null type aws.smithy.kotlin.runtime.util.AttributeKey<kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
            java.lang.Object r5 = r0.getOrNull(r3)
            aws.smithy.kotlin.runtime.util.Attributes r6 = r8.attributes
            java.lang.Object r3 = r6.getOrNull(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r3)
            if (r3 == 0) goto L73
            r3 = r4
            goto L74
        L73:
            r3 = r1
        L74:
            if (r3 != 0) goto L4a
            r8 = r1
            goto L79
        L78:
            r8 = r4
        L79:
            if (r8 == 0) goto L7d
            r8 = r4
            goto L7e
        L7d:
            r8 = r1
        L7e:
            if (r8 == 0) goto L81
            r1 = r4
        L81:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.client.endpoints.Endpoint.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.uri.hashCode() * 31;
        ValuesMap<String> valuesMap = this.headers;
        if (valuesMap == null) {
            hashCode = 0;
        } else {
            hashCode = valuesMap.hashCode();
        }
        return this.attributes.hashCode() + ((hashCode2 + hashCode) * 31);
    }

    public final String toString() {
        return "Endpoint(uri=" + this.uri + ", headers=" + this.headers + ", attributes=" + this.attributes + ')';
    }

    public Endpoint(Url url) {
        AttributesImpl attributesImpl = new AttributesImpl();
        this.uri = url;
        this.headers = null;
        this.attributes = attributesImpl;
    }
}
