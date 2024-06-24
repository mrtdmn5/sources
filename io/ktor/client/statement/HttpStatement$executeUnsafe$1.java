package io.ktor.client.statement;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpStatement.kt */
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {108}, m = "executeUnsafe")
/* loaded from: classes3.dex */
public final class HttpStatement$executeUnsafe$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HttpStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$executeUnsafe$1(HttpStatement httpStatement, Continuation<? super HttpStatement$executeUnsafe$1> continuation) {
        super(continuation);
        this.this$0 = httpStatement;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeUnsafe(this);
    }
}
