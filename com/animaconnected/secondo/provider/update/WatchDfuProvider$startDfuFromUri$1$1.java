package com.animaconnected.secondo.provider.update;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.device.DfuUiState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchDfuProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.update.WatchDfuProvider$startDfuFromUri$1$1", f = "WatchDfuProvider.kt", l = {R.styleable.AppTheme_stepsHistoryFontDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchDfuProvider$startDfuFromUri$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DisplayWatch $this_apply;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchDfuProvider$startDfuFromUri$1$1(DisplayWatch displayWatch, Continuation<? super WatchDfuProvider$startDfuFromUri$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = displayWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchDfuProvider$startDfuFromUri$1$1(this.$this_apply, continuation);
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
            DisplayWatch displayWatch = this.$this_apply;
            DfuUiState dfuUiState = DfuUiState.Loading;
            this.label = 1;
            if (displayWatch.setDfuUIState(dfuUiState, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchDfuProvider$startDfuFromUri$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
