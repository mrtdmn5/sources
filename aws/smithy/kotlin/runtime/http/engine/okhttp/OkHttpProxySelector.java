package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.engine.EnvironmentProxySelector;
import aws.smithy.kotlin.runtime.http.engine.ProxyConfig;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.net.QueryParametersBuilder;
import aws.smithy.kotlin.runtime.net.QueryParametersImpl;
import aws.smithy.kotlin.runtime.net.Scheme;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import aws.smithy.kotlin.runtime.net.UrlKt;
import aws.smithy.kotlin.runtime.net.UserInfo;
import aws.smithy.kotlin.runtime.util.text.TextKt;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mu.KLogger;
import mu.internal.LocationAwareKLogger;
import mu.internal.LocationIgnorantKLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/* compiled from: OkHttpUtils.kt */
/* loaded from: classes.dex */
public final class OkHttpProxySelector extends ProxySelector {
    public final aws.smithy.kotlin.runtime.http.engine.ProxySelector sdkSelector;

    public OkHttpProxySelector(EnvironmentProxySelector sdkSelector) {
        Intrinsics.checkNotNullParameter(sdkSelector, "sdkSelector");
        this.sdkSelector = sdkSelector;
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(final URI r3, final SocketAddress socketAddress, final IOException iOException) {
        KLogger locationIgnorantKLogger;
        String qualifiedName = Reflection.getOrCreateKotlinClass(OkHttpProxySelector.class).getQualifiedName();
        if (qualifiedName != null) {
            Logger logger = LoggerFactory.getLogger(qualifiedName);
            Intrinsics.checkNotNullExpressionValue(logger, "LoggerFactory.getLogger(name)");
            if (logger instanceof LocationAwareLogger) {
                locationIgnorantKLogger = new LocationAwareKLogger((LocationAwareLogger) logger);
            } else {
                locationIgnorantKLogger = new LocationIgnorantKLogger(logger);
            }
            locationIgnorantKLogger.error(new Function0<Object>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpProxySelector$connectFailed$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "failed to connect to proxy: uri=" + r3 + "; socketAddress: " + socketAddress + "; exception: " + iOException;
                }
            });
            return;
        }
        throw new IllegalArgumentException("getLogger<T> cannot be used on an anonymous object".toString());
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(final URI r5) {
        EmptyList emptyList = EmptyList.INSTANCE;
        if (r5 == null) {
            return emptyList;
        }
        Function1<UrlBuilder, Unit> function1 = new Function1<UrlBuilder, Unit>() { // from class: aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpUtilsKt$toUrl$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(UrlBuilder urlBuilder) {
                String host;
                UserInfo userInfo;
                String fragment;
                UrlBuilder invoke = urlBuilder;
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                Scheme scheme = Scheme.HTTPS;
                URI r0 = r5;
                String scheme2 = r0.getScheme();
                Intrinsics.checkNotNullExpressionValue(scheme2, "uri.scheme");
                invoke.scheme = Scheme.Companion.parse(scheme2);
                String host2 = r0.getHost();
                Intrinsics.checkNotNullExpressionValue(host2, "uri.host");
                boolean z = false;
                if (StringsKt__StringsJVMKt.startsWith(host2, "[", false)) {
                    String host3 = r0.getHost();
                    Intrinsics.checkNotNullExpressionValue(host3, "uri.host");
                    host = StringsKt__StringsKt.substring(host3, RangesKt___RangesKt.until(1, r0.getHost().length() - 1));
                } else {
                    host = r0.getHost();
                }
                Intrinsics.checkNotNullExpressionValue(host, "if (uri.host.startsWith(…length - 1) else uri.host");
                invoke.host = Host.Companion.parse(host);
                Integer valueOf = Integer.valueOf(r0.getPort());
                if (valueOf.intValue() > 0) {
                    z = true;
                }
                String str = null;
                if (!z) {
                    valueOf = null;
                }
                invoke.port = valueOf;
                String path = r0.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "uri.path");
                invoke.path = path;
                if (r0.getQuery() != null) {
                    Intrinsics.checkNotNullExpressionValue(r0.getQuery(), "uri.query");
                    if (!StringsKt__StringsJVMKt.isBlank(r1)) {
                        String query = r0.getQuery();
                        Intrinsics.checkNotNullExpressionValue(query, "uri.query");
                        QueryParametersBuilder queryParametersBuilder = new QueryParametersBuilder();
                        for (Map.Entry entry : TextKt.splitAsQueryString(query).entrySet()) {
                            queryParametersBuilder.appendAll((String) entry.getKey(), (Iterable) entry.getValue());
                        }
                        invoke.parameters.appendAll(new QueryParametersImpl(queryParametersBuilder.values));
                    }
                }
                String userInfo2 = r0.getUserInfo();
                if (userInfo2 != null) {
                    if (!(!StringsKt__StringsJVMKt.isBlank(userInfo2))) {
                        userInfo2 = null;
                    }
                    if (userInfo2 != null) {
                        userInfo = UrlKt.UserInfo(userInfo2);
                        invoke.userInfo = userInfo;
                        fragment = r0.getFragment();
                        if (fragment != null && (!StringsKt__StringsJVMKt.isBlank(fragment))) {
                            str = fragment;
                        }
                        invoke.fragment = str;
                        return Unit.INSTANCE;
                    }
                }
                userInfo = null;
                invoke.userInfo = userInfo;
                fragment = r0.getFragment();
                if (fragment != null) {
                    str = fragment;
                }
                invoke.fragment = str;
                return Unit.INSTANCE;
            }
        };
        UrlBuilder urlBuilder = new UrlBuilder();
        function1.invoke(urlBuilder);
        ProxyConfig select = this.sdkSelector.select(urlBuilder.build());
        if (select instanceof ProxyConfig.Http) {
            ProxyConfig.Http http = (ProxyConfig.Http) select;
            return CollectionsKt__CollectionsKt.listOf(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(http.url.host.toString(), http.url.port)));
        }
        return emptyList;
    }
}
