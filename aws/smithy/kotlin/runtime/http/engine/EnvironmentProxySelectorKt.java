package aws.smithy.kotlin.runtime.http.engine;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.Url;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.net.UrlParserKt$urlParseImpl$1;
import aws.smithy.kotlin.runtime.util.PlatformEnvironProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: EnvironmentProxySelector.kt */
/* loaded from: classes.dex */
public final class EnvironmentProxySelectorKt {
    public static final ProxyConfig access$resolveProxyByEnvironment(PlatformEnvironProvider platformEnvironProvider, Scheme scheme) {
        String str = scheme.protocolName;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String concat = lowerCase.concat("_proxy");
        String upperCase = scheme.protocolName.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{concat, upperCase.concat("_PROXY")});
        ArrayList arrayList = new ArrayList();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            String str2 = platformEnvironProvider.getenv((String) it.next());
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String url = (String) it2.next();
            Intrinsics.checkNotNullParameter(url, "url");
            UrlParserKt$urlParseImpl$1 urlParserKt$urlParseImpl$1 = new UrlParserKt$urlParseImpl$1(url);
            UrlBuilder urlBuilder = new UrlBuilder();
            urlParserKt$urlParseImpl$1.invoke(urlBuilder);
            arrayList2.add(new ProxyConfig.Http(urlBuilder.build()));
        }
        return (ProxyConfig) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList2);
    }

    public static final ProxyConfig.Http access$resolveProxyByProperty(PlatformEnvironProvider platformEnvironProvider, Scheme scheme) {
        int r12;
        String m = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), scheme.protocolName, ".proxyHost");
        String m2 = ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), scheme.protocolName, ".proxyPort");
        String property = platformEnvironProvider.getProperty(m);
        String property2 = platformEnvironProvider.getProperty(m2);
        if (property != null) {
            Scheme scheme2 = Scheme.HTTP;
            Host parse = Host.Companion.parse(property);
            if (property2 != null) {
                r12 = Integer.parseInt(property2);
            } else {
                r12 = scheme.defaultPort;
            }
            return new ProxyConfig.Http(new Url(scheme2, parse, r12, null, null, null, null, false, 504));
        }
        return null;
    }

    public static final NoProxyHost parseNoProxyHost(String str) {
        List split$default = StringsKt__StringsKt.split$default(2, 2, str, new char[]{':'});
        int size = split$default.size();
        if (size != 1) {
            if (size == 2) {
                return new NoProxyHost((String) split$default.get(0), Integer.valueOf(Integer.parseInt((String) split$default.get(1))));
            }
            throw new IllegalStateException("invalid no proxy host: ".concat(str).toString());
        }
        return new NoProxyHost((String) split$default.get(0), null);
    }
}
