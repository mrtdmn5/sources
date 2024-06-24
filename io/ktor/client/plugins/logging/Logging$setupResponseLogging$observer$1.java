package io.ktor.client.plugins.logging;

import io.ktor.client.statement.HttpResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$setupResponseLogging$observer$1", f = "Logging.kt", l = {222, 225, 226, 225, 226, 225, 226}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Logging$setupResponseLogging$observer$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public StringBuilder L$1;
    public int label;
    public final /* synthetic */ Logging this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$setupResponseLogging$observer$1(Logging logging, Continuation<? super Logging$setupResponseLogging$observer$1> continuation) {
        super(2, continuation);
        this.this$0 = logging;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Logging$setupResponseLogging$observer$1 logging$setupResponseLogging$observer$1 = new Logging$setupResponseLogging$observer$1(this.this$0, continuation);
        logging$setupResponseLogging$observer$1.L$0 = obj;
        return logging$setupResponseLogging$observer$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return ((Logging$setupResponseLogging$observer$1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.Logging$setupResponseLogging$observer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
