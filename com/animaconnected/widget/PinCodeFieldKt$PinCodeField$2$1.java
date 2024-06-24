package com.animaconnected.widget;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: PinCodeField.kt */
@DebugMetadata(c = "com.animaconnected.widget.PinCodeFieldKt$PinCodeField$2$1", f = "PinCodeField.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PinCodeFieldKt$PinCodeField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinCodeFieldKt$PinCodeField$2$1(FocusRequester focusRequester, Continuation<? super PinCodeFieldKt$PinCodeField$2$1> continuation) {
        super(2, continuation);
        this.$focusRequester = focusRequester;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PinCodeFieldKt$PinCodeField$2$1(this.$focusRequester, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(150L, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.$focusRequester.focus$ui_release();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PinCodeFieldKt$PinCodeField$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
