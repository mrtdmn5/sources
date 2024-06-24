package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Blocking.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", l = {319, 38}, m = "loop")
/* loaded from: classes3.dex */
public final class InputAdapter$loop$1$loop$1 extends ContinuationImpl {
    public InputAdapter$loop$1 L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ InputAdapter$loop$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1$loop$1(InputAdapter$loop$1 inputAdapter$loop$1, Continuation<? super InputAdapter$loop$1$loop$1> continuation) {
        super(continuation);
        this.this$0 = inputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loop(this);
    }
}
