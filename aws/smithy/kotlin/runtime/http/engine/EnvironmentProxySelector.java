package aws.smithy.kotlin.runtime.http.engine;

import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import aws.smithy.kotlin.runtime.util.SystemDefaultProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: EnvironmentProxySelector.kt */
/* loaded from: classes.dex */
public final class EnvironmentProxySelector implements ProxySelector {
    public final ProxyConfig httpProxy;
    public final ProxyConfig httpsProxy;
    public final LinkedHashSet noProxyHosts;

    public EnvironmentProxySelector() {
        Set set;
        PlatformProvider.Companion.getClass();
        SystemDefaultProvider provider = PlatformProvider.Companion.System;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Scheme scheme = Scheme.HTTP;
        ProxyConfig access$resolveProxyByProperty = EnvironmentProxySelectorKt.access$resolveProxyByProperty(provider, scheme);
        this.httpProxy = access$resolveProxyByProperty == null ? EnvironmentProxySelectorKt.access$resolveProxyByEnvironment(provider, scheme) : access$resolveProxyByProperty;
        Scheme scheme2 = Scheme.HTTPS;
        ProxyConfig access$resolveProxyByProperty2 = EnvironmentProxySelectorKt.access$resolveProxyByProperty(provider, scheme2);
        this.httpsProxy = access$resolveProxyByProperty2 == null ? EnvironmentProxySelectorKt.access$resolveProxyByEnvironment(provider, scheme2) : access$resolveProxyByProperty2;
        String property = System.getProperty("http.noProxyHosts");
        if (property != null) {
            List split$default = StringsKt__StringsKt.split$default(0, 6, property, new char[]{'|'});
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt__StringsKt.trim((String) it.next()).toString());
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt__StringsKt.trimStart((String) it2.next(), '.'));
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(EnvironmentProxySelectorKt.parseNoProxyHost((String) it3.next()));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList3);
        } else {
            set = EmptySet.INSTANCE;
        }
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"no_proxy", "NO_PROXY"});
        ArrayList arrayList4 = new ArrayList();
        Iterator it4 = listOf.iterator();
        while (it4.hasNext()) {
            String str = provider.getenv((String) it4.next());
            if (str != null) {
                arrayList4.add(str);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            CollectionsKt__ReversedViewsKt.addAll(StringsKt__StringsKt.split$default(0, 6, (String) it5.next(), new char[]{',', ' '}), arrayList5);
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it6 = arrayList5.iterator();
        while (it6.hasNext()) {
            arrayList6.add(StringsKt__StringsKt.trim((String) it6.next()).toString());
        }
        ArrayList arrayList7 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it7 = arrayList6.iterator();
        while (it7.hasNext()) {
            arrayList7.add(StringsKt__StringsKt.trimStart((String) it7.next(), '.'));
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList7, 10));
        Iterator it8 = arrayList7.iterator();
        while (it8.hasNext()) {
            arrayList8.add(EnvironmentProxySelectorKt.parseNoProxyHost((String) it8.next()));
        }
        this.noProxyHosts = SetsKt.plus(set, CollectionsKt___CollectionsKt.toSet(arrayList8));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x003f, code lost:            if (r10.port != r3.intValue()) goto L82;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006b, code lost:            if (r3.charAt(r8) == '.') goto L81;     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:0: B:23:0x001a->B:36:?, LOOP_END, SYNTHETIC] */
    @Override // aws.smithy.kotlin.runtime.http.engine.ProxySelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final aws.smithy.kotlin.runtime.http.engine.ProxyConfig select(aws.smithy.kotlin.runtime.net.Url r10) {
        /*
            r9 = this;
            aws.smithy.kotlin.runtime.http.engine.ProxyConfig r0 = r9.httpsProxy
            aws.smithy.kotlin.runtime.http.engine.ProxyConfig r1 = r9.httpProxy
            if (r1 != 0) goto L8
            if (r0 == 0) goto L75
        L8:
            java.util.LinkedHashSet r2 = r9.noProxyHosts
            boolean r3 = r2 instanceof java.util.Collection
            r4 = 0
            if (r3 == 0) goto L16
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L16
            goto L73
        L16:
            java.util.Iterator r2 = r2.iterator()
        L1a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L73
            java.lang.Object r3 = r2.next()
            aws.smithy.kotlin.runtime.http.engine.NoProxyHost r3 = (aws.smithy.kotlin.runtime.http.engine.NoProxyHost) r3
            r3.getClass()
            java.lang.String r5 = r3.hostMatch
            java.lang.String r6 = "*"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            r7 = 1
            if (r6 == 0) goto L35
            goto L6d
        L35:
            java.lang.Integer r3 = r3.port
            if (r3 == 0) goto L42
            int r3 = r3.intValue()
            int r6 = r10.port
            if (r6 == r3) goto L42
            goto L6f
        L42:
            aws.smithy.kotlin.runtime.net.Host r3 = r10.host
            java.lang.String r3 = r3.toString()
            int r6 = r5.length()
            int r8 = r3.length()
            if (r6 <= r8) goto L53
            goto L6f
        L53:
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.endsWith(r3, r5, r4)
            int r8 = r3.length()
            int r5 = r5.length()
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r6 == 0) goto L6f
            if (r8 < 0) goto L6d
            char r3 = r3.charAt(r8)
            r5 = 46
            if (r3 != r5) goto L6f
        L6d:
            r3 = r7
            goto L70
        L6f:
            r3 = r4
        L70:
            if (r3 == 0) goto L1a
            r4 = r7
        L73:
            if (r4 == 0) goto L78
        L75:
            aws.smithy.kotlin.runtime.http.engine.ProxyConfig$Direct r10 = aws.smithy.kotlin.runtime.http.engine.ProxyConfig.Direct.INSTANCE
            return r10
        L78:
            aws.smithy.kotlin.runtime.net.Scheme r2 = aws.smithy.kotlin.runtime.net.Scheme.HTTP
            aws.smithy.kotlin.runtime.net.Scheme r10 = r10.scheme
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r2)
            if (r2 == 0) goto L84
            r0 = r1
            goto L8e
        L84:
            aws.smithy.kotlin.runtime.net.Scheme r1 = aws.smithy.kotlin.runtime.net.Scheme.HTTPS
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
            if (r10 == 0) goto L8d
            goto L8e
        L8d:
            r0 = 0
        L8e:
            if (r0 != 0) goto L92
            aws.smithy.kotlin.runtime.http.engine.ProxyConfig$Direct r0 = aws.smithy.kotlin.runtime.http.engine.ProxyConfig.Direct.INSTANCE
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector.select(aws.smithy.kotlin.runtime.net.Url):aws.smithy.kotlin.runtime.http.engine.ProxyConfig");
    }
}
