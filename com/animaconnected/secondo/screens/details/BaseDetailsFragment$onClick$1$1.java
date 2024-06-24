package com.animaconnected.secondo.screens.details;

import android.view.View;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.details.BaseDetailsFragment$onClick$1$1", f = "BaseDetailsFragment.kt", l = {192}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BaseDetailsFragment$onClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ Function2<View, Continuation<? super Unit>, Object> $onClick;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseDetailsFragment$onClick$1$1(Function2<? super View, ? super Continuation<? super Unit>, ? extends Object> function2, View view, Continuation<? super BaseDetailsFragment$onClick$1$1> continuation) {
        super(2, continuation);
        this.$onClick = function2;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseDetailsFragment$onClick$1$1(this.$onClick, this.$it, continuation);
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
            Function2<View, Continuation<? super Unit>, Object> function2 = this.$onClick;
            View it = this.$it;
            Intrinsics.checkNotNullExpressionValue(it, "$it");
            this.label = 1;
            if (function2.invoke(it, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseDetailsFragment$onClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
