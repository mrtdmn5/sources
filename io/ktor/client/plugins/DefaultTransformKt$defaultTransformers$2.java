package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DefaultTransform.kt */
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", l = {68, 72, 72, 77, 77, 81, 89, 115, 120}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    public /* synthetic */ PipelineContext L$0;
    public /* synthetic */ Object L$1;
    public CoroutineScope L$2;
    public TypeInfo L$3;
    public int label;

    public DefaultTransformKt$defaultTransformers$2(Continuation<? super DefaultTransformKt$defaultTransformers$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(continuation);
        defaultTransformKt$defaultTransformers$2.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$2.L$1 = httpResponseContainer;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0612 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0388 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0661 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x05ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x054a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x054b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 1846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
