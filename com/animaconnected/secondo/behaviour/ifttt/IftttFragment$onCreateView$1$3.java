package com.animaconnected.secondo.behaviour.ifttt;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.animaconnected.secondo.databinding.FragmentDetailsIftttBinding;
import com.animaconnected.secondo.utils.ViewKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IftttFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.ifttt.IftttFragment$onCreateView$1$3", f = "IftttFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class IftttFragment$onCreateView$1$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentDetailsIftttBinding $this_apply;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IftttFragment$onCreateView$1$3(FragmentDetailsIftttBinding fragmentDetailsIftttBinding, Continuation<? super IftttFragment$onCreateView$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = fragmentDetailsIftttBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IftttFragment$onCreateView$1$3 iftttFragment$onCreateView$1$3 = new IftttFragment$onCreateView$1$3(this.$this_apply, continuation);
        iftttFragment$onCreateView$1$3.Z$0 = ((Boolean) obj).booleanValue();
        return iftttFragment$onCreateView$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.Z$0) {
                ProgressBar setupProgressbar = this.$this_apply.setupProgressbar;
                Intrinsics.checkNotNullExpressionValue(setupProgressbar, "setupProgressbar");
                ViewKt.visible(setupProgressbar);
                TextView websiteDescriptionText = this.$this_apply.websiteDescriptionText;
                Intrinsics.checkNotNullExpressionValue(websiteDescriptionText, "websiteDescriptionText");
                ViewKt.invisible(websiteDescriptionText);
                Button setupBtn = this.$this_apply.setupBtn;
                Intrinsics.checkNotNullExpressionValue(setupBtn, "setupBtn");
                ViewKt.invisible(setupBtn);
            } else {
                ProgressBar setupProgressbar2 = this.$this_apply.setupProgressbar;
                Intrinsics.checkNotNullExpressionValue(setupProgressbar2, "setupProgressbar");
                ViewKt.invisible(setupProgressbar2);
                TextView websiteDescriptionText2 = this.$this_apply.websiteDescriptionText;
                Intrinsics.checkNotNullExpressionValue(websiteDescriptionText2, "websiteDescriptionText");
                ViewKt.visible(websiteDescriptionText2);
                Button setupBtn2 = this.$this_apply.setupBtn;
                Intrinsics.checkNotNullExpressionValue(setupBtn2, "setupBtn");
                ViewKt.visible(setupBtn2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((IftttFragment$onCreateView$1$3) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
