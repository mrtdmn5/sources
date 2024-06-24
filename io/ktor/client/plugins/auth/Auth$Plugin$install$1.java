package io.ktor.client.plugins.auth;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.collections.ConcurrentMap$$ExternalSyntheticLambda0;
import io.ktor.util.collections.ConcurrentMap$computeIfAbsent$1;
import io.ktor.util.pipeline.PipelineContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Auth.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.Auth$Plugin$install$1", f = "Auth.kt", l = {62}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Auth$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Auth $plugin;
    public /* synthetic */ PipelineContext L$0;
    public Iterator L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Auth$Plugin$install$1(Auth auth, Continuation<? super Auth$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = auth;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        Auth$Plugin$install$1 auth$Plugin$install$1 = new Auth$Plugin$install$1(this.$plugin, continuation);
        auth$Plugin$install$1.L$0 = pipelineContext;
        return auth$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        Iterator it;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                it = this.L$1;
                pipelineContext = this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            pipelineContext = this.L$0;
            List<AuthProvider> list = this.$plugin.providers;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((AuthProvider) obj2).sendWithoutRequest((HttpRequestBuilder) pipelineContext.context)) {
                    arrayList.add(obj2);
                }
            }
            it = arrayList.iterator();
        }
        while (it.hasNext()) {
            AuthProvider authProvider = (AuthProvider) it.next();
            AuthKt.LOGGER.trace("Adding auth headers for " + ((HttpRequestBuilder) pipelineContext.context).url + " from provider " + authProvider);
            ConcurrentMap<AuthProvider, AtomicCounter> concurrentMap = Auth.tokenVersions;
            Auth$Plugin$install$1$2$tokenVersion$1 block = new Function0<AtomicCounter>() { // from class: io.ktor.client.plugins.auth.Auth$Plugin$install$1$2$tokenVersion$1
                @Override // kotlin.jvm.functions.Function0
                public final AtomicCounter invoke() {
                    return new AtomicCounter();
                }
            };
            concurrentMap.getClass();
            Intrinsics.checkNotNullParameter(block, "block");
            ((Map) ((HttpRequestBuilder) pipelineContext.context).attributes.computeIfAbsent(Auth.tokenVersionsAttributeKey, new Function0<Map<AuthProvider, Integer>>() { // from class: io.ktor.client.plugins.auth.Auth$Plugin$install$1$2$requestTokenVersions$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<AuthProvider, Integer> invoke() {
                    return new LinkedHashMap();
                }
            })).put(authProvider, new Integer(concurrentMap.delegate.computeIfAbsent(authProvider, new ConcurrentMap$$ExternalSyntheticLambda0(new ConcurrentMap$computeIfAbsent$1(block))).atomic));
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) pipelineContext.context;
            this.L$0 = pipelineContext;
            this.L$1 = it;
            this.label = 1;
            if (authProvider.addRequestHeaders(httpRequestBuilder, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
