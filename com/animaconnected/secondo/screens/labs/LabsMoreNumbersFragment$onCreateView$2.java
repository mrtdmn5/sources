package com.animaconnected.secondo.screens.labs;

import android.content.Context;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LabsMoreNumbersFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.labs.LabsMoreNumbersFragment$onCreateView$2", f = "LabsMoreNumbersFragment.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LabsMoreNumbersFragment$onCreateView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimationView $lottieView;
    final /* synthetic */ View $progressBar;
    int label;
    final /* synthetic */ LabsMoreNumbersFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsMoreNumbersFragment$onCreateView$2(LabsMoreNumbersFragment labsMoreNumbersFragment, LottieAnimationView lottieAnimationView, View view, Continuation<? super LabsMoreNumbersFragment$onCreateView$2> continuation) {
        super(2, continuation);
        this.this$0 = labsMoreNumbersFragment;
        this.$lottieView = lottieAnimationView;
        this.$progressBar = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabsMoreNumbersFragment$onCreateView$2(this.this$0, this.$lottieView, this.$progressBar, continuation);
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
            Context context = this.this$0.getContext();
            if (context != null) {
                LottieFile lottieFile = LottieFile.MoreNumbers;
                this.label = 1;
                obj = LottieKt.loadLottieAnimation(context, lottieFile, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        LottieComposition lottieComposition = (LottieComposition) obj;
        if (lottieComposition != null) {
            this.$lottieView.setComposition(lottieComposition);
            this.$progressBar.setVisibility(4);
            this.$lottieView.setVisibility(0);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LabsMoreNumbersFragment$onCreateView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
