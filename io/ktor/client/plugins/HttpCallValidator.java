package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.PhaseContent;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
/* loaded from: classes3.dex */
public final class HttpCallValidator {
    public static final Companion Companion = new Companion();
    public static final AttributeKey<HttpCallValidator> key = new AttributeKey<>("HttpResponseValidator");
    public final List<HandlerWrapper> callExceptionHandlers;
    public final boolean expectSuccess;
    public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators;

    /* compiled from: HttpCallValidator.kt */
    /* loaded from: classes3.dex */
    public static final class Companion implements HttpClientPlugin<Config, HttpCallValidator> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpCallValidator> getKey() {
            return HttpCallValidator.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpCallValidator plugin = (HttpCallValidator) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.Before, new HttpCallValidator$Companion$install$1(plugin, null));
            PipelinePhase pipelinePhase = new PipelinePhase("BeforeReceive");
            HttpResponsePipeline httpResponsePipeline = scope.responsePipeline;
            httpResponsePipeline.getClass();
            PipelinePhase reference = HttpResponsePipeline.Receive;
            Intrinsics.checkNotNullParameter(reference, "reference");
            if (!httpResponsePipeline.hasPhase(pipelinePhase)) {
                int findPhaseIndex = httpResponsePipeline.findPhaseIndex(reference);
                if (findPhaseIndex != -1) {
                    httpResponsePipeline.phasesRaw.add(findPhaseIndex, new PhaseContent(pipelinePhase, new PipelinePhaseRelation.Before(reference)));
                } else {
                    throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
                }
            }
            httpResponsePipeline.intercept(pipelinePhase, new HttpCallValidator$Companion$install$2(plugin, null));
            HttpSend.Plugin plugin2 = HttpSend.Plugin;
            ((HttpSend) HttpClientPluginKt.plugin(scope)).interceptors.add(new HttpCallValidator$Companion$install$3(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpCallValidator prepare(Function1<? super Config, Unit> function1) {
            Config config = new Config();
            function1.invoke(config);
            return new HttpCallValidator(config.expectSuccess, CollectionsKt___CollectionsKt.reversed(config.responseValidators), CollectionsKt___CollectionsKt.reversed(config.responseExceptionHandlers));
        }
    }

    /* compiled from: HttpCallValidator.kt */
    /* loaded from: classes3.dex */
    public static final class Config {
        public final ArrayList responseValidators = new ArrayList();
        public final ArrayList responseExceptionHandlers = new ArrayList();
        public boolean expectSuccess = true;
    }

    public HttpCallValidator(boolean z, List list, List list2) {
        this.responseValidators = list;
        this.callExceptionHandlers = list2;
        this.expectSuccess = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$processException(io.ktor.client.plugins.HttpCallValidator r6, java.lang.Throwable r7, io.ktor.client.request.HttpRequest r8, kotlin.coroutines.Continuation r9) {
        /*
            r6.getClass()
            boolean r0 = r9 instanceof io.ktor.client.plugins.HttpCallValidator$processException$1
            if (r0 == 0) goto L16
            r0 = r9
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = (io.ktor.client.plugins.HttpCallValidator$processException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = new io.ktor.client.plugins.HttpCallValidator$processException$1
            r0.<init>(r6, r9)
        L1b:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3c
            if (r2 == r3) goto L32
            if (r2 != r4) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            java.util.Iterator r6 = r0.L$2
            io.ktor.client.request.HttpRequest r8 = r0.L$1
            java.lang.Throwable r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L66
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            org.slf4j.Logger r9 = io.ktor.client.plugins.HttpCallValidatorKt.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Processing exception "
            r2.<init>(r5)
            r2.append(r7)
            java.lang.String r5 = " for request "
            r2.append(r5)
            io.ktor.http.Url r5 = r8.getUrl()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r9.trace(r2)
            java.util.List<io.ktor.client.plugins.HandlerWrapper> r6 = r6.callExceptionHandlers
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L66:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L9c
            java.lang.Object r9 = r6.next()
            io.ktor.client.plugins.HandlerWrapper r9 = (io.ktor.client.plugins.HandlerWrapper) r9
            boolean r2 = r9 instanceof io.ktor.client.plugins.ExceptionHandlerWrapper
            if (r2 != 0) goto L8d
            boolean r2 = r9 instanceof io.ktor.client.plugins.RequestExceptionHandlerWrapper
            if (r2 == 0) goto L66
            io.ktor.client.plugins.RequestExceptionHandlerWrapper r9 = (io.ktor.client.plugins.RequestExceptionHandlerWrapper) r9
            kotlin.jvm.functions.Function3<java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r9.handler
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r9 = r9.invoke(r7, r8, r0)
            if (r9 != r1) goto L66
            goto L9e
        L8d:
            io.ktor.client.plugins.ExceptionHandlerWrapper r9 = (io.ktor.client.plugins.ExceptionHandlerWrapper) r9
            r9.getClass()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r6
            r0.label = r3
            r6 = 0
            throw r6
        L9c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.access$processException(io.ktor.client.plugins.HttpCallValidator, java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$validateResponse(io.ktor.client.plugins.HttpCallValidator r5, io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            if (r0 == 0) goto L16
            r0 = r7
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = (io.ktor.client.plugins.HttpCallValidator$validateResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = new io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            r0.<init>(r5, r7)
        L1b:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.util.Iterator r5 = r0.L$1
            io.ktor.client.statement.HttpResponse r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            org.slf4j.Logger r7 = io.ktor.client.plugins.HttpCallValidatorKt.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Validating response for request "
            r2.<init>(r4)
            io.ktor.client.call.HttpClientCall r4 = r6.getCall()
            io.ktor.client.request.HttpRequest r4 = r4.getRequest()
            io.ktor.http.Url r4 = r4.getUrl()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.trace(r2)
            java.util.List<kotlin.jvm.functions.Function2<io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r5 = r5.responseValidators
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L60:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L79
            java.lang.Object r7 = r5.next()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L60
            goto L7b
        L79:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.access$validateResponse(io.ktor.client.plugins.HttpCallValidator, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
