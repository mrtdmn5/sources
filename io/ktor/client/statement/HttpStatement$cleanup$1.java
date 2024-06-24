package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableJob;

/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {126}, m = "cleanup")
/* loaded from: classes3.dex */
public final class HttpStatement$cleanup$1 extends ContinuationImpl {
    public CompletableJob L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$cleanup$1(HttpStatement httpStatement, Continuation<? super HttpStatement$cleanup$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cleanup(null, this);
    }
}
