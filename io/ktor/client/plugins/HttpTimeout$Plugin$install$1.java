package io.ktor.client.plugins;

import com.animaconnected.secondo.R;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.util.AttributeKey;
import io.ktor.util.AttributesJvmBase;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* compiled from: HttpTimeout.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeout$Plugin$install$1", f = "HttpTimeout.kt", l = {R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail, R.styleable.AppTheme_themeShadowOpacity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpTimeout$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    public final /* synthetic */ HttpTimeout $plugin;
    public final /* synthetic */ HttpClient $scope;
    public /* synthetic */ Sender L$0;
    public /* synthetic */ HttpRequestBuilder L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeout$Plugin$install$1(HttpTimeout httpTimeout, HttpClient httpClient, Continuation<? super HttpTimeout$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpTimeout;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpTimeout$Plugin$install$1 httpTimeout$Plugin$install$1 = new HttpTimeout$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpTimeout$Plugin$install$1.L$0 = sender;
        httpTimeout$Plugin$install$1.L$1 = httpRequestBuilder;
        return httpTimeout$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object obj2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        boolean z2 = true;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Sender sender = this.L$0;
        HttpRequestBuilder httpRequestBuilder = this.L$1;
        URLProtocol uRLProtocol = httpRequestBuilder.url.protocol;
        Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
        String str = uRLProtocol.name;
        if (!Intrinsics.areEqual(str, "ws") && !Intrinsics.areEqual(str, "wss")) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            HttpTimeout.Plugin plugin = HttpTimeout.Plugin;
            AttributeKey<Map<HttpClientEngineCapability<?>, Object>> attributeKey = HttpClientEngineCapabilityKt.ENGINE_CAPABILITIES_KEY;
            AttributesJvmBase attributesJvmBase = httpRequestBuilder.attributes;
            Map map = (Map) attributesJvmBase.getOrNull(attributeKey);
            if (map != null) {
                obj2 = map.get(plugin);
            } else {
                obj2 = null;
            }
            HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) obj2;
            HttpTimeout httpTimeout = this.$plugin;
            if (httpTimeoutCapabilityConfiguration == null) {
                if (httpTimeout.requestTimeoutMillis == null && httpTimeout.connectTimeoutMillis == null && httpTimeout.socketTimeoutMillis == null) {
                    z2 = false;
                }
                if (z2) {
                    httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration();
                    ((Map) attributesJvmBase.computeIfAbsent(attributeKey, new Function0<Map<HttpClientEngineCapability<?>, Object>>() { // from class: io.ktor.client.request.HttpRequestBuilder$setCapability$capabilities$1
                        @Override // kotlin.jvm.functions.Function0
                        public final Map<HttpClientEngineCapability<?>, Object> invoke() {
                            return new LinkedHashMap();
                        }
                    })).put(plugin, httpTimeoutCapabilityConfiguration);
                }
            }
            if (httpTimeoutCapabilityConfiguration != null) {
                Long l = httpTimeoutCapabilityConfiguration._connectTimeoutMillis;
                if (l == null) {
                    l = httpTimeout.connectTimeoutMillis;
                }
                HttpTimeout.HttpTimeoutCapabilityConfiguration.checkTimeoutValue(l);
                httpTimeoutCapabilityConfiguration._connectTimeoutMillis = l;
                Long l2 = httpTimeoutCapabilityConfiguration._socketTimeoutMillis;
                if (l2 == null) {
                    l2 = httpTimeout.socketTimeoutMillis;
                }
                HttpTimeout.HttpTimeoutCapabilityConfiguration.checkTimeoutValue(l2);
                httpTimeoutCapabilityConfiguration._socketTimeoutMillis = l2;
                Long l3 = httpTimeoutCapabilityConfiguration._requestTimeoutMillis;
                if (l3 == null) {
                    l3 = httpTimeout.requestTimeoutMillis;
                }
                httpTimeoutCapabilityConfiguration.setRequestTimeoutMillis(l3);
                Long l4 = httpTimeoutCapabilityConfiguration._requestTimeoutMillis;
                if (l4 == null) {
                    l4 = httpTimeout.requestTimeoutMillis;
                }
                if (l4 != null && l4.longValue() != Long.MAX_VALUE) {
                    final StandaloneCoroutine launch$default = BuildersKt.launch$default(this.$scope, null, null, new HttpTimeout$Plugin$install$1$1$killer$1(l4, httpRequestBuilder, httpRequestBuilder.executionContext, null), 3);
                    httpRequestBuilder.executionContext.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.HttpTimeout$Plugin$install$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Throwable th) {
                            launch$default.cancel(null);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
            this.L$0 = null;
            this.label = 2;
            obj = sender.execute(httpRequestBuilder, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            return obj;
        }
        this.L$0 = null;
        this.label = 1;
        obj = sender.execute(httpRequestBuilder, this);
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        return obj;
    }
}
