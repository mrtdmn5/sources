package com.animaconnected.secondo.screens.debugsettings;

import android.widget.Toast;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugDisplayFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugDisplayFragment$showApp$2", f = "DebugDisplayFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugDisplayFragment$showApp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $e;
    int label;
    final /* synthetic */ DebugDisplayFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugDisplayFragment$showApp$2(DebugDisplayFragment debugDisplayFragment, Exception exc, Continuation<? super DebugDisplayFragment$showApp$2> continuation) {
        super(2, continuation);
        this.this$0 = debugDisplayFragment;
        this.$e = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugDisplayFragment$showApp$2(this.this$0, this.$e, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.this$0.getContext(), this.$e.getMessage(), 0).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugDisplayFragment$showApp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
