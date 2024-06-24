package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.ServiceLocator;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt$createClientPlugin$2;
import io.ktor.client.plugins.api.HookHandler;
import io.ktor.client.plugins.api.OnRequestContext;
import io.ktor.client.plugins.api.OnResponseContext;
import io.ktor.client.plugins.api.RequestHook;
import io.ktor.client.plugins.api.ResponseHook;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: StravaRateLimiter.kt */
/* loaded from: classes3.dex */
public final class StravaRateLimiterKt {
    private static final ClientPlugin<Unit> StravaRateLimitPlugin;

    static {
        final StravaRateLimiterKt$StravaRateLimitPlugin$1 body = new Function1<ClientPluginBuilder<Unit>, Unit>() { // from class: com.animaconnected.watch.account.strava.StravaRateLimiterKt$StravaRateLimitPlugin$1

            /* compiled from: StravaRateLimiter.kt */
            @DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaRateLimiterKt$StravaRateLimitPlugin$1$1", f = "StravaRateLimiter.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.account.strava.StravaRateLimiterKt$StravaRateLimitPlugin$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> {
                final /* synthetic */ StravaRateLimiter $rateLimit;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(StravaRateLimiter stravaRateLimiter, Continuation<? super AnonymousClass1> continuation) {
                    super(4, continuation);
                    this.$rateLimit = stravaRateLimiter;
                }

                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(OnRequestContext onRequestContext, HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<? super Unit> continuation) {
                    return new AnonymousClass1(this.$rateLimit, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        StravaRateLimiter.onRequest$default(this.$rateLimit, null, 1, null);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* compiled from: StravaRateLimiter.kt */
            @DebugMetadata(c = "com.animaconnected.watch.account.strava.StravaRateLimiterKt$StravaRateLimitPlugin$1$2", f = "StravaRateLimiter.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.account.strava.StravaRateLimiterKt$StravaRateLimitPlugin$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function3<OnResponseContext, HttpResponse, Continuation<? super Unit>, Object> {
                final /* synthetic */ StravaRateLimiter $rateLimit;
                /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(StravaRateLimiter stravaRateLimiter, Continuation<? super AnonymousClass2> continuation) {
                    super(3, continuation);
                    this.$rateLimit = stravaRateLimiter;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(OnResponseContext onResponseContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$rateLimit, continuation);
                    anonymousClass2.L$0 = httpResponse;
                    return anonymousClass2.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    boolean z;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        HttpResponse httpResponse = (HttpResponse) this.L$0;
                        String str = httpResponse.getHeaders().get("X-RateLimit-Limit");
                        if (str == null) {
                            return Unit.INSTANCE;
                        }
                        String str2 = httpResponse.getHeaders().get("X-RateLimit-Usage");
                        if (str2 == null) {
                            return Unit.INSTANCE;
                        }
                        boolean z2 = true;
                        if (str.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            if (str2.length() <= 0) {
                                z2 = false;
                            }
                            if (z2) {
                                Instant.Companion companion = Instant.Companion;
                                long j = httpResponse.getResponseTime().timestamp;
                                companion.getClass();
                                this.$rateLimit.handleHeaders(str, str2, Instant.Companion.fromEpochMilliseconds(j));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClientPluginBuilder<Unit> clientPluginBuilder) {
                invoke2(clientPluginBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClientPluginBuilder<Unit> createClientPlugin) {
                Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
                StravaRateLimiter stravaRateLimiter = new StravaRateLimiter(ServiceLocator.INSTANCE.getStorageFactory().createStorage("stravaRateLimit"));
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(stravaRateLimiter, null);
                RequestHook requestHook = RequestHook.INSTANCE;
                ArrayList arrayList = createClientPlugin.hooks;
                arrayList.add(new HookHandler(requestHook, anonymousClass1));
                arrayList.add(new HookHandler(ResponseHook.INSTANCE, new AnonymousClass2(stravaRateLimiter, null)));
            }
        };
        Intrinsics.checkNotNullParameter(body, "body");
        final CreatePluginUtilsKt$createClientPlugin$2 createConfiguration = new Function0<Unit>() { // from class: io.ktor.client.plugins.api.CreatePluginUtilsKt$createClientPlugin$2
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(createConfiguration, "createConfiguration");
        StravaRateLimitPlugin = new ClientPlugin<Object>() { // from class: io.ktor.client.plugins.api.CreatePluginUtilsKt$createClientPlugin$1
            public final /* synthetic */ String $name = "StravaRateLimitPlugin";
            public final AttributeKey<ClientPluginInstance<Object>> key = new AttributeKey<>("StravaRateLimitPlugin");

            @Override // io.ktor.client.plugins.HttpClientPlugin
            public final AttributeKey<ClientPluginInstance<Object>> getKey() {
                return this.key;
            }

            @Override // io.ktor.client.plugins.HttpClientPlugin
            public final void install(HttpClient scope, Object obj) {
                ClientPluginInstance plugin = (ClientPluginInstance) obj;
                Intrinsics.checkNotNullParameter(plugin, "plugin");
                Intrinsics.checkNotNullParameter(scope, "scope");
                ClientPluginBuilder clientPluginBuilder = new ClientPluginBuilder(new AttributeKey(plugin.name), scope, plugin.config);
                plugin.body.invoke(clientPluginBuilder);
                plugin.onClose = clientPluginBuilder.onClose;
                Iterator it = clientPluginBuilder.hooks.iterator();
                while (it.hasNext()) {
                    HookHandler hookHandler = (HookHandler) it.next();
                    hookHandler.getClass();
                    hookHandler.hook.install(scope, hookHandler.handler);
                }
            }

            @Override // io.ktor.client.plugins.HttpClientPlugin
            public final Object prepare(Function1 function1) {
                Object invoke = createConfiguration.invoke();
                function1.invoke(invoke);
                return new ClientPluginInstance(invoke, this.$name, body);
            }
        };
    }

    public static final ClientPlugin<Unit> getStravaRateLimitPlugin() {
        return StravaRateLimitPlugin;
    }
}
