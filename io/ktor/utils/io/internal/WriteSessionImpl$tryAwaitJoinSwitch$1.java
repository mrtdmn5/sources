package io.ktor.utils.io.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: WriteSessionImpl.kt */
@DebugMetadata(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", l = {86}, m = "tryAwaitJoinSwitch")
/* loaded from: classes3.dex */
public final class WriteSessionImpl$tryAwaitJoinSwitch$1 extends ContinuationImpl {
    public WriteSessionImpl L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ WriteSessionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteSessionImpl$tryAwaitJoinSwitch$1(WriteSessionImpl writeSessionImpl, Continuation<? super WriteSessionImpl$tryAwaitJoinSwitch$1> continuation) {
        super(continuation);
        this.this$0 = writeSessionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryAwaitJoinSwitch(0, this);
    }
}
