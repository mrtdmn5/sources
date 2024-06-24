package com.animaconnected.secondo.screens.labs;

import android.content.Context;
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

/* compiled from: LabsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.labs.LabsFragment$onViewCreated$4", f = "LabsFragment.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class LabsFragment$onViewCreated$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LabsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsFragment$onViewCreated$4(LabsFragment labsFragment, Continuation<? super LabsFragment$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = labsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabsFragment$onViewCreated$4(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LottieAnimationView lottieView;
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
                LottieFile lottieFile = LottieFile.LabsLottie;
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
            lottieView = this.this$0.getLottieView();
            lottieView.setComposition(lottieComposition);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LabsFragment$onViewCreated$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
