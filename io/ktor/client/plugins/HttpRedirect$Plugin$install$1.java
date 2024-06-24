package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpRedirect.kt */
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin$install$1", f = "HttpRedirect.kt", l = {64, 69}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HttpRedirect$Plugin$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    public final /* synthetic */ HttpRedirect $plugin;
    public final /* synthetic */ HttpClient $scope;
    public /* synthetic */ Sender L$0;
    public /* synthetic */ HttpRequestBuilder L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$install$1(HttpRedirect httpRedirect, HttpClient httpClient, Continuation<? super HttpRedirect$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpRedirect;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRedirect$Plugin$install$1 httpRedirect$Plugin$install$1 = new HttpRedirect$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpRedirect$Plugin$install$1.L$0 = sender;
        httpRedirect$Plugin$install$1.L$1 = httpRequestBuilder;
        return httpRedirect$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Sender sender;
        HttpRequestBuilder httpRequestBuilder;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HttpRequestBuilder httpRequestBuilder2 = this.L$1;
            Sender sender2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            httpRequestBuilder = httpRequestBuilder2;
            sender = sender2;
        } else {
            ResultKt.throwOnFailure(obj);
            Sender sender3 = this.L$0;
            HttpRequestBuilder httpRequestBuilder3 = this.L$1;
            this.L$0 = sender3;
            this.L$1 = httpRequestBuilder3;
            this.label = 1;
            Object execute = sender3.execute(httpRequestBuilder3, this);
            if (execute == coroutineSingletons) {
                return coroutineSingletons;
            }
            sender = sender3;
            httpRequestBuilder = httpRequestBuilder3;
            obj = execute;
        }
        HttpClientCall httpClientCall = (HttpClientCall) obj;
        HttpRedirect httpRedirect = this.$plugin;
        if (httpRedirect.checkHttpMethod && !HttpRedirectKt.ALLOWED_FOR_REDIRECT.contains(httpClientCall.getRequest().getMethod())) {
            return httpClientCall;
        }
        HttpRedirect.Plugin plugin = HttpRedirect.Plugin;
        boolean z = httpRedirect.allowHttpsDowngrade;
        HttpClient httpClient = this.$scope;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        obj = HttpRedirect.Plugin.access$handleCall(plugin, sender, httpRequestBuilder, httpClientCall, z, httpClient, this);
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        return obj;
    }
}
