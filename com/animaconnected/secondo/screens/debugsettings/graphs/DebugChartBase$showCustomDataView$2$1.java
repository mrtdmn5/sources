package com.animaconnected.secondo.screens.debugsettings.graphs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.animaconnected.secondo.utils.ViewKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugChartBase.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.graphs.DebugChartBase$showCustomDataView$2$1", f = "DebugChartBase.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugChartBase$showCustomDataView$2$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DebugChartBase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugChartBase$showCustomDataView$2$1(DebugChartBase debugChartBase, Continuation<? super DebugChartBase$showCustomDataView$2$1> continuation) {
        super(2, continuation);
        this.this$0 = debugChartBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugChartBase$showCustomDataView$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugChartBase$showCustomDataView$2$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LinearLayout containerEdit = this.this$0.getBinding().containerEdit;
            Intrinsics.checkNotNullExpressionValue(containerEdit, "containerEdit");
            ViewKt.visible(containerEdit);
            LinearLayout containerViewButtons = this.this$0.getBinding().containerViewButtons;
            Intrinsics.checkNotNullExpressionValue(containerViewButtons, "containerViewButtons");
            ViewKt.visible(containerViewButtons);
            RecyclerView recyclerView = this.this$0.getBinding().recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            ViewKt.gone(recyclerView);
            TextView tvGoBack = this.this$0.getBinding().tvGoBack;
            Intrinsics.checkNotNullExpressionValue(tvGoBack, "tvGoBack");
            ViewKt.gone(tvGoBack);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
