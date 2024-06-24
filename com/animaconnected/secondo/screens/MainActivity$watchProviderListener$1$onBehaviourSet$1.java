package com.animaconnected.secondo.screens;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.Slot;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MainActivity.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.MainActivity$watchProviderListener$1$onBehaviourSet$1", f = "MainActivity.kt", l = {R.styleable.AppTheme_subComplicationDropZoneSelected}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MainActivity$watchProviderListener$1$onBehaviourSet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Slot $slot;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$watchProviderListener$1$onBehaviourSet$1(MainActivity mainActivity, Slot slot, Continuation<? super MainActivity$watchProviderListener$1$onBehaviourSet$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$slot = slot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$watchProviderListener$1$onBehaviourSet$1(this.this$0, this.$slot, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateSubComplicationBehaviourIfNeeded;
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
            MainActivity mainActivity = this.this$0;
            Slot slot = this.$slot;
            this.label = 1;
            updateSubComplicationBehaviourIfNeeded = mainActivity.updateSubComplicationBehaviourIfNeeded(slot, this);
            if (updateSubComplicationBehaviourIfNeeded == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$watchProviderListener$1$onBehaviourSet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
