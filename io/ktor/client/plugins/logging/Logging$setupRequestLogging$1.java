package io.ktor.client.plugins.logging;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupRequestLogging$1", f = "Logging.kt", l = {84, 90}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Logging$setupRequestLogging$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public int label;
    public final /* synthetic */ Logging this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupRequestLogging$1(Logging logging, Continuation<? super Logging$setupRequestLogging$1> continuation) {
        super(3, continuation);
        this.this$0 = logging;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        Logging$setupRequestLogging$1 logging$setupRequestLogging$1 = new Logging$setupRequestLogging$1(this.this$0, continuation);
        logging$setupRequestLogging$1.L$0 = pipelineContext;
        return logging$setupRequestLogging$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0067, code lost:            if (r9 != false) goto L31;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Type inference failed for: r1v10, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v7, types: [io.ktor.util.pipeline.PipelineContext] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            io.ktor.client.plugins.logging.Logging r3 = r8.this$0
            r4 = 1
            if (r1 == 0) goto L26
            if (r1 == r4) goto L20
            if (r1 != r2) goto L18
            io.ktor.util.pipeline.PipelineContext r0 = r8.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L15
            goto L9f
        L15:
            r9 = move-exception
            goto La3
        L18:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L20:
            io.ktor.util.pipeline.PipelineContext r1 = r8.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L8a
            goto L87
        L26:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.util.pipeline.PipelineContext r1 = r8.L$0
            TContext r9 = r1.context
            io.ktor.client.request.HttpRequestBuilder r9 = (io.ktor.client.request.HttpRequestBuilder) r9
            java.util.List<? extends kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, java.lang.Boolean>> r5 = r3.filters
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L69
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r6 = r5 instanceof java.util.Collection
            r7 = 0
            if (r6 == 0) goto L48
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L48
            goto L66
        L48:
            java.util.Iterator r5 = r5.iterator()
        L4c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L66
            java.lang.Object r6 = r5.next()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r6 = r6.invoke(r9)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L4c
            r9 = r4
            goto L67
        L66:
            r9 = r7
        L67:
            if (r9 == 0) goto L6a
        L69:
            r7 = r4
        L6a:
            TContext r9 = r1.context
            if (r7 != 0) goto L7a
            io.ktor.client.request.HttpRequestBuilder r9 = (io.ktor.client.request.HttpRequestBuilder) r9
            io.ktor.util.AttributesJvmBase r9 = r9.attributes
            io.ktor.util.AttributeKey<kotlin.Unit> r0 = io.ktor.client.plugins.logging.LoggingKt.DisableLogging
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r9.put(r0, r1)
            return r1
        L7a:
            io.ktor.client.request.HttpRequestBuilder r9 = (io.ktor.client.request.HttpRequestBuilder) r9     // Catch: java.lang.Throwable -> L8a
            r8.L$0 = r1     // Catch: java.lang.Throwable -> L8a
            r8.label = r4     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r9 = io.ktor.client.plugins.logging.Logging.access$logRequest(r3, r9, r8)     // Catch: java.lang.Throwable -> L8a
            if (r9 != r0) goto L87
            return r0
        L87:
            io.ktor.http.content.OutgoingContent r9 = (io.ktor.http.content.OutgoingContent) r9     // Catch: java.lang.Throwable -> L8a
            goto L8b
        L8a:
            r9 = 0
        L8b:
            if (r9 != 0) goto L94
            java.lang.Object r9 = r1.getSubject()     // Catch: java.lang.Throwable -> L92
            goto L94
        L92:
            r9 = move-exception
            goto La2
        L94:
            r8.L$0 = r1     // Catch: java.lang.Throwable -> L92
            r8.label = r2     // Catch: java.lang.Throwable -> L92
            java.lang.Object r9 = r1.proceedWith(r9, r8)     // Catch: java.lang.Throwable -> L92
            if (r9 != r0) goto L9f
            return r0
        L9f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        La2:
            r0 = r1
        La3:
            TContext r0 = r0.context
            io.ktor.client.request.HttpRequestBuilder r0 = (io.ktor.client.request.HttpRequestBuilder) r0
            io.ktor.client.plugins.logging.LogLevel r1 = r3.level
            boolean r1 = r1.getInfo()
            if (r1 == 0) goto Ld0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "REQUEST "
            r1.<init>(r2)
            io.ktor.http.URLBuilder r0 = r0.url
            io.ktor.http.Url r0 = io.ktor.http.URLUtilsKt.Url(r0)
            r1.append(r0)
            java.lang.String r0 = " failed with exception: "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = r1.toString()
            io.ktor.client.plugins.logging.Logger r1 = r3.logger
            r1.log(r0)
        Ld0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.Logging$setupRequestLogging$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
