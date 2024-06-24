package com.animaconnected.secondo.screens.debugsettings;

import android.view.View;
import android.widget.Toast;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: DebugImagePreview.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$onCreateView$1$4", f = "DebugImagePreview.kt", l = {105}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugImagePreview$onCreateView$1$4 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DebugImagePreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugImagePreview$onCreateView$1$4(DebugImagePreview debugImagePreview, Continuation<? super DebugImagePreview$onCreateView$1$4> continuation) {
        super(2, continuation);
        this.this$0 = debugImagePreview;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DebugImagePreview$onCreateView$1$4 debugImagePreview$onCreateView$1$4 = new DebugImagePreview$onCreateView$1$4(this.this$0, continuation);
        debugImagePreview$onCreateView$1$4.L$0 = obj;
        return debugImagePreview$onCreateView$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((DebugImagePreview$onCreateView$1$4) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendImage;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                View view = (View) this.L$0;
                DebugImagePreview debugImagePreview = this.this$0;
                this.label = 1;
                sendImage = debugImagePreview.sendImage(view, this);
                if (sendImage == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } catch (Exception e) {
            Toast.makeText(this.this$0.getContext(), "Failed error: " + e.getMessage(), 0).show();
        }
        return Unit.INSTANCE;
    }
}
