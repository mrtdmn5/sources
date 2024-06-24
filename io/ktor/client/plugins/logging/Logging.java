package io.ktor.client.plugins.logging;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.observer.ResponseObserver;
import io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.ByteBufferChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.slf4j.LoggerFactory;

/* compiled from: Logging.kt */
/* loaded from: classes3.dex */
public final class Logging {
    public static final Companion Companion = new Companion();
    public static final AttributeKey<Logging> key = new AttributeKey<>("ClientLogging");
    public final List<? extends Function1<? super HttpRequestBuilder, Boolean>> filters;
    public final LogLevel level;
    public final Logger logger;
    public final List<SanitizedHeader> sanitizedHeaders;

    /* compiled from: Logging.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements HttpClientPlugin<Config, Logging> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<Logging> getKey() {
            return Logging.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            Logging plugin = (Logging) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.sendPipeline.intercept(HttpSendPipeline.Monitoring, new Logging$setupRequestLogging$1(plugin, null));
            Logging$setupResponseLogging$1 logging$setupResponseLogging$1 = new Logging$setupResponseLogging$1(plugin, null);
            HttpReceivePipeline httpReceivePipeline = scope.receivePipeline;
            httpReceivePipeline.intercept(HttpReceivePipeline.State, logging$setupResponseLogging$1);
            scope.responsePipeline.intercept(HttpResponsePipeline.Receive, new Logging$setupResponseLogging$2(plugin, null));
            if (plugin.level.getBody()) {
                httpReceivePipeline.intercept(HttpReceivePipeline.After, new ResponseObserver$Plugin$install$1(new ResponseObserver(new Logging$setupResponseLogging$observer$1(plugin, null), null), scope, null));
            }
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Logging prepare(Function1<? super Config, Unit> function1) {
            Config config = new Config();
            function1.invoke(config);
            Logger logger = config._logger;
            if (logger == null) {
                logger = new Logger() { // from class: io.ktor.client.plugins.logging.LoggerJvmKt$DEFAULT$1
                    public final org.slf4j.Logger delegate;

                    {
                        org.slf4j.Logger logger2 = LoggerFactory.getLogger((Class<?>) HttpClient.class);
                        Intrinsics.checkNotNull(logger2);
                        this.delegate = logger2;
                    }

                    @Override // io.ktor.client.plugins.logging.Logger
                    public final void log(String message) {
                        Intrinsics.checkNotNullParameter(message, "message");
                        this.delegate.info(message);
                    }
                };
            }
            return new Logging(logger, config.level, config.filters, config.sanitizedHeaders);
        }
    }

    /* compiled from: Logging.kt */
    /* loaded from: classes3.dex */
    public static final class Config {
        public Logger _logger;
        public final ArrayList filters = new ArrayList();
        public final ArrayList sanitizedHeaders = new ArrayList();
        public LogLevel level = LogLevel.HEADERS;
    }

    public Logging() {
        throw null;
    }

    public Logging(Logger logger, LogLevel logLevel, ArrayList arrayList, ArrayList arrayList2) {
        this.logger = logger;
        this.level = logLevel;
        this.filters = arrayList;
        this.sanitizedHeaders = arrayList2;
    }

    public static final Object access$logRequest(Logging logging, HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        boolean z;
        Charset charset;
        logging.getClass();
        Object obj = httpRequestBuilder.body;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
        OutgoingContent outgoingContent = (OutgoingContent) obj;
        final HttpClientCallLogger httpClientCallLogger = new HttpClientCallLogger(logging.logger);
        httpRequestBuilder.attributes.put(LoggingKt.ClientCallLogger, httpClientCallLogger);
        StringBuilder sb = new StringBuilder();
        LogLevel logLevel = logging.level;
        if (logLevel.getInfo()) {
            sb.append("REQUEST: " + URLUtilsKt.Url(httpRequestBuilder.url));
            sb.append('\n');
            sb.append("METHOD: " + httpRequestBuilder.method);
            sb.append('\n');
        }
        if (logLevel.getHeaders()) {
            sb.append("COMMON HEADERS\n");
            Set<Map.Entry<String, List<String>>> entries = httpRequestBuilder.headers.entries();
            List<SanitizedHeader> list = logging.sanitizedHeaders;
            LoggingUtilsKt.logHeaders(sb, entries, list);
            sb.append("CONTENT HEADERS");
            sb.append('\n');
            List<SanitizedHeader> list2 = list;
            Iterator<T> it = list2.iterator();
            if (!it.hasNext()) {
                Iterator<T> it2 = list2.iterator();
                if (!it2.hasNext()) {
                    Long contentLength = outgoingContent.getContentLength();
                    if (contentLength != null) {
                        long longValue = contentLength.longValue();
                        List<String> list3 = HttpHeaders.UnsafeHeadersList;
                        LoggingUtilsKt.logHeader(sb, "Content-Length", String.valueOf(longValue));
                    }
                    ContentType contentType = outgoingContent.getContentType();
                    if (contentType != null) {
                        List<String> list4 = HttpHeaders.UnsafeHeadersList;
                        LoggingUtilsKt.logHeader(sb, "Content-Type", contentType.toString());
                    }
                    LoggingUtilsKt.logHeaders(sb, outgoingContent.getHeaders().entries(), list);
                } else {
                    ((SanitizedHeader) it2.next()).getClass();
                    List<String> list5 = HttpHeaders.UnsafeHeadersList;
                    throw null;
                }
            } else {
                ((SanitizedHeader) it.next()).getClass();
                List<String> list6 = HttpHeaders.UnsafeHeadersList;
                throw null;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        boolean z2 = true;
        if (sb2.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String obj2 = StringsKt__StringsKt.trim(sb2).toString();
            StringBuilder sb3 = httpClientCallLogger.requestLog;
            sb3.append(obj2);
            sb3.append('\n');
        }
        if (sb2.length() != 0) {
            z2 = false;
        }
        if (!z2 && logLevel.getBody()) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("BODY Content-Type: " + outgoingContent.getContentType());
            sb4.append('\n');
            ContentType contentType2 = outgoingContent.getContentType();
            if (contentType2 == null || (charset = ContentTypesKt.charset(contentType2)) == null) {
                charset = Charsets.UTF_8;
            }
            ByteBufferChannel byteBufferChannel = new ByteBufferChannel(false);
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.Unconfined, null, new Logging$logRequestBody$2(byteBufferChannel, charset, sb4, null), 2).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.logging.Logging$logRequestBody$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    String sb5 = sb4.toString();
                    Intrinsics.checkNotNullExpressionValue(sb5, "requestLog.toString()");
                    HttpClientCallLogger httpClientCallLogger2 = HttpClientCallLogger.this;
                    httpClientCallLogger2.getClass();
                    String obj3 = StringsKt__StringsKt.trim(sb5).toString();
                    StringBuilder sb6 = httpClientCallLogger2.requestLog;
                    sb6.append(obj3);
                    sb6.append('\n');
                    httpClientCallLogger2.closeRequestLog();
                    return Unit.INSTANCE;
                }
            });
            return ObservingUtilsKt.observe(outgoingContent, byteBufferChannel, continuation);
        }
        httpClientCallLogger.closeRequestLog();
        return null;
    }

    public static final void access$logResponseException(Logging logging, StringBuilder sb, HttpRequest httpRequest, Throwable th) {
        if (logging.level.getInfo()) {
            sb.append("RESPONSE " + httpRequest.getUrl() + " failed with exception: " + th);
        }
    }
}
