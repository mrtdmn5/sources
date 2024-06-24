package com.animaconnected.secondo.screens.workout.heartrate;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HelpPagesBottomDialog.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.heartrate.HelpPagesBottomDialogKt$DialogContent$1$changePage$1", f = "HelpPagesBottomDialog.kt", l = {89}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HelpPagesBottomDialogKt$DialogContent$1$changePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismissDialog;
    final /* synthetic */ List<HelpPageModel> $pageModels;
    final /* synthetic */ int $pageOffset;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HelpPagesBottomDialogKt$DialogContent$1$changePage$1(PagerState pagerState, int r2, List<HelpPageModel> list, Function0<Unit> function0, Continuation<? super HelpPagesBottomDialogKt$DialogContent$1$changePage$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$pageOffset = r2;
        this.$pageModels = list;
        this.$dismissDialog = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpPagesBottomDialogKt$DialogContent$1$changePage$1(this.$pagerState, this.$pageOffset, this.$pageModels, this.$dismissDialog, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object animateScrollToPage;
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
            int intValue = ((Number) this.$pagerState.targetPage$delegate.getValue()).intValue() + this.$pageOffset;
            if (intValue < this.$pageModels.size()) {
                PagerState pagerState = this.$pagerState;
                this.label = 1;
                animateScrollToPage = pagerState.animateScrollToPage(intValue, 0.0f, AnimationSpecKt.spring$default(400.0f, null, 5), this);
                if (animateScrollToPage == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                this.$dismissDialog.invoke();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpPagesBottomDialogKt$DialogContent$1$changePage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
