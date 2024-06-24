package okhttp3.internal.http;

import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._ResponseCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.FastFallbackExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealRoutePlanner;
import okhttp3.internal.connection.SequentialExchangeFinder;
import okhttp3.internal.http2.ConnectionShutdownException;

/* compiled from: RetryAndFollowUpInterceptor.kt */
/* loaded from: classes4.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    public static int retryAfter(Response response, int r2) {
        String header$default = Response.header$default(response, "Retry-After");
        if (header$default == null) {
            return r2;
        }
        Pattern compile = Pattern.compile("\\d+");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        if (compile.matcher(header$default).matches()) {
            Integer valueOf = Integer.valueOf(header$default);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
            return valueOf.intValue();
        }
        return Integer.MAX_VALUE;
    }

    public final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        Route route;
        String header$default;
        HttpUrl.Builder builder;
        HttpUrl httpUrl;
        RequestBody requestBody = null;
        if (exchange != null) {
            route = exchange.getConnection$okhttp().route;
        } else {
            route = null;
        }
        int r2 = response.code;
        Request request = response.request;
        String str = request.method;
        boolean z = false;
        if (r2 != 307 && r2 != 308) {
            if (r2 != 401) {
                if (r2 != 421) {
                    if (r2 != 503) {
                        if (r2 != 407) {
                            if (r2 != 408) {
                                switch (r2) {
                                    case TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY /* 300 */:
                                    case Constants.BUCKET_REDIRECT_STATUS_CODE /* 301 */:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        return null;
                                }
                            } else {
                                if (!this.client.retryOnConnectionFailure) {
                                    return null;
                                }
                                RequestBody requestBody2 = request.body;
                                if (requestBody2 != null && requestBody2.isOneShot()) {
                                    return null;
                                }
                                Response response2 = response.priorResponse;
                                if ((response2 != null && response2.code == 408) || retryAfter(response, 0) > 0) {
                                    return null;
                                }
                                return response.request;
                            }
                        } else {
                            Intrinsics.checkNotNull(route);
                            if (route.proxy.type() == Proxy.Type.HTTP) {
                                return this.client.proxyAuthenticator.authenticate(route, response);
                            }
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                    } else {
                        Response response3 = response.priorResponse;
                        if ((response3 != null && response3.code == 503) || retryAfter(response, Integer.MAX_VALUE) != 0) {
                            return null;
                        }
                        return response.request;
                    }
                } else {
                    RequestBody requestBody3 = request.body;
                    if ((requestBody3 != null && requestBody3.isOneShot()) || exchange == null || !(!Intrinsics.areEqual(exchange.finder.getRoutePlanner().getAddress().url.host, exchange.codec.getCarrier().getRoute().address.url.host))) {
                        return null;
                    }
                    RealConnection connection$okhttp = exchange.getConnection$okhttp();
                    synchronized (connection$okhttp) {
                        connection$okhttp.noCoalescedConnections = true;
                    }
                    return response.request;
                }
            } else {
                return this.client.authenticator.authenticate(route, response);
            }
        }
        OkHttpClient okHttpClient = this.client;
        if (!okHttpClient.followRedirects || (header$default = Response.header$default(response, HttpHeader.LOCATION)) == null) {
            return null;
        }
        Request request2 = response.request;
        HttpUrl httpUrl2 = request2.url;
        httpUrl2.getClass();
        try {
            builder = new HttpUrl.Builder();
            builder.parse$okhttp(httpUrl2, header$default);
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        if (builder != null) {
            httpUrl = builder.build();
        } else {
            httpUrl = null;
        }
        if (httpUrl == null) {
            return null;
        }
        if (!Intrinsics.areEqual(httpUrl.scheme, request2.url.scheme) && !okHttpClient.followSslRedirects) {
            return null;
        }
        Request.Builder builder2 = new Request.Builder(request2);
        if (HttpMethod.permitsRequestBody(str)) {
            boolean areEqual = Intrinsics.areEqual(str, "PROPFIND");
            int r11 = response.code;
            if (areEqual || r11 == 308 || r11 == 307) {
                z = true;
            }
            if ((!Intrinsics.areEqual(str, "PROPFIND")) && r11 != 308 && r11 != 307) {
                builder2.method("GET", null);
            } else {
                if (z) {
                    requestBody = request2.body;
                }
                builder2.method(str, requestBody);
            }
            if (!z) {
                builder2.headers.removeAll("Transfer-Encoding");
                builder2.headers.removeAll("Content-Length");
                builder2.headers.removeAll("Content-Type");
            }
        }
        if (!_UtilJvmKt.canReuseConnectionFor(request2.url, httpUrl)) {
            builder2.headers.removeAll(HttpHeader.AUTHORIZATION);
        }
        builder2.url = httpUrl;
        return new Request(builder2);
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        boolean z;
        List list;
        int r25;
        boolean z2;
        Response response;
        Exchange exchange;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        ExchangeFinder sequentialExchangeFinder;
        Request request = realInterceptorChain.request;
        RealCall realCall = realInterceptorChain.call;
        boolean z3 = true;
        List list2 = EmptyList.INSTANCE;
        int r9 = 0;
        Response response2 = null;
        Request request2 = request;
        boolean z4 = true;
        while (true) {
            realCall.getClass();
            Intrinsics.checkNotNullParameter(request2, "request");
            if (realCall.interceptorScopedExchange == null) {
                z = z3;
            } else {
                z = false;
            }
            if (z) {
                synchronized (realCall) {
                    if (realCall.responseBodyOpen ^ z3) {
                        if (realCall.requestBodyOpen ^ z3) {
                            Unit unit = Unit.INSTANCE;
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                    }
                }
                if (z4) {
                    OkHttpClient okHttpClient = realCall.client;
                    HttpUrl httpUrl = request2.url;
                    if (httpUrl.isHttps) {
                        SSLSocketFactory sSLSocketFactory2 = okHttpClient.sslSocketFactoryOrNull;
                        if (sSLSocketFactory2 != null) {
                            sSLSocketFactory = sSLSocketFactory2;
                            hostnameVerifier = okHttpClient.hostnameVerifier;
                            certificatePinner = okHttpClient.certificatePinner;
                        } else {
                            throw new IllegalStateException("CLEARTEXT-only client");
                        }
                    } else {
                        sSLSocketFactory = null;
                        hostnameVerifier = null;
                        certificatePinner = null;
                    }
                    list = list2;
                    r25 = r9;
                    RealRoutePlanner realRoutePlanner = new RealRoutePlanner(okHttpClient, new Address(httpUrl.host, httpUrl.port, okHttpClient.dns, okHttpClient.socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator, okHttpClient.protocols, okHttpClient.connectionSpecs, okHttpClient.proxySelector), realCall, realInterceptorChain);
                    OkHttpClient okHttpClient2 = realCall.client;
                    if (okHttpClient2.fastFallback) {
                        sequentialExchangeFinder = new FastFallbackExchangeFinder(realRoutePlanner, okHttpClient2.taskRunner);
                    } else {
                        sequentialExchangeFinder = new SequentialExchangeFinder(realRoutePlanner);
                    }
                    realCall.exchangeFinder = sequentialExchangeFinder;
                } else {
                    list = list2;
                    r25 = r9;
                }
                try {
                    if (!realCall.canceled) {
                        try {
                            Response.Builder builder = new Response.Builder(realInterceptorChain.proceed(request2));
                            builder.request = request2;
                            if (response2 != null) {
                                response = _ResponseCommonKt.stripBody(response2);
                            } else {
                                response = null;
                            }
                            builder.priorResponse = response;
                            response2 = builder.build();
                            exchange = realCall.interceptorScopedExchange;
                        } catch (IOException e) {
                            if (!(e instanceof ConnectionShutdownException)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!recover(e, realCall, request2, z2)) {
                                List suppressed = list;
                                Intrinsics.checkNotNullParameter(suppressed, "suppressed");
                                Iterator it = suppressed.iterator();
                                while (it.hasNext()) {
                                    ExceptionsKt.addSuppressed(e, (Exception) it.next());
                                }
                                throw e;
                            }
                            list2 = CollectionsKt___CollectionsKt.plus(list, e);
                            realCall.exitNetworkInterceptorExchange$okhttp(true);
                            z4 = false;
                            z3 = true;
                            r9 = r25;
                        }
                        try {
                            request2 = followUpRequest(response2, exchange);
                            if (request2 == null) {
                                if (exchange != null && exchange.isDuplex) {
                                    if (!realCall.timeoutEarlyExit) {
                                        realCall.timeoutEarlyExit = true;
                                        realCall.timeout.exit();
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                }
                                realCall.exitNetworkInterceptorExchange$okhttp(false);
                                return response2;
                            }
                            RequestBody requestBody = request2.body;
                            if (requestBody != null && requestBody.isOneShot()) {
                                realCall.exitNetworkInterceptorExchange$okhttp(false);
                                return response2;
                            }
                            _UtilCommonKt.closeQuietly(response2.body);
                            r9 = r25 + 1;
                            if (r9 <= 20) {
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                list2 = list;
                                z4 = true;
                                z3 = true;
                            } else {
                                throw new ProtocolException("Too many follow-up requests: " + r9);
                            }
                        } catch (Throwable th) {
                            th = th;
                            realCall.exitNetworkInterceptorExchange$okhttp(true);
                            throw th;
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean recover(java.io.IOException r3, okhttp3.internal.connection.RealCall r4, okhttp3.Request r5, boolean r6) {
        /*
            r2 = this;
            okhttp3.OkHttpClient r0 = r2.client
            boolean r0 = r0.retryOnConnectionFailure
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 1
            if (r6 == 0) goto L1f
            okhttp3.RequestBody r5 = r5.body
            if (r5 == 0) goto L15
            boolean r5 = r5.isOneShot()
            if (r5 != 0) goto L19
        L15:
            boolean r5 = r3 instanceof java.io.FileNotFoundException
            if (r5 == 0) goto L1b
        L19:
            r5 = r0
            goto L1c
        L1b:
            r5 = r1
        L1c:
            if (r5 == 0) goto L1f
            return r1
        L1f:
            boolean r5 = r3 instanceof java.net.ProtocolException
            if (r5 == 0) goto L24
            goto L40
        L24:
            boolean r5 = r3 instanceof java.io.InterruptedIOException
            if (r5 == 0) goto L2f
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L40
            if (r6 != 0) goto L40
            goto L42
        L2f:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L3c
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L3c
            goto L40
        L3c:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L42
        L40:
            r3 = r1
            goto L43
        L42:
            r3 = r0
        L43:
            if (r3 != 0) goto L46
            return r1
        L46:
            okhttp3.internal.connection.Exchange r3 = r4.exchange
            if (r3 == 0) goto L50
            boolean r3 = r3.hasFailure
            if (r3 != r0) goto L50
            r3 = r0
            goto L51
        L50:
            r3 = r1
        L51:
            if (r3 == 0) goto L6e
            okhttp3.internal.connection.ExchangeFinder r3 = r4.exchangeFinder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            okhttp3.internal.connection.RoutePlanner r3 = r3.getRoutePlanner()
            okhttp3.internal.connection.Exchange r4 = r4.exchange
            if (r4 == 0) goto L65
            okhttp3.internal.connection.RealConnection r4 = r4.getConnection$okhttp()
            goto L66
        L65:
            r4 = 0
        L66:
            boolean r3 = r3.hasNext(r4)
            if (r3 == 0) goto L6e
            r3 = r0
            goto L6f
        L6e:
            r3 = r1
        L6f:
            if (r3 != 0) goto L72
            return r1
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.recover(java.io.IOException, okhttp3.internal.connection.RealCall, okhttp3.Request, boolean):boolean");
    }
}
