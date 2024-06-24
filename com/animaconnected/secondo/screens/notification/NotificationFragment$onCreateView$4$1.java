package com.animaconnected.secondo.screens.notification;

import android.view.View;
import com.animaconnected.secondo.screens.quiethours.QuietHoursFragment;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: NotificationFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.notification.NotificationFragment$onCreateView$4$1", f = "NotificationFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class NotificationFragment$onCreateView$4$1 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationFragment$onCreateView$4$1(NotificationFragment notificationFragment, Continuation<? super NotificationFragment$onCreateView$4$1> continuation) {
        super(2, continuation);
        this.this$0 = notificationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationFragment$onCreateView$4$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((NotificationFragment$onCreateView$4$1) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getMainController().gotoNextRevealedFragmentWithAnimations(QuietHoursFragment.Companion.newInstance(this.this$0.getFeaturePathName(), R.drawable.ic_close), R.anim.enter_from_bottom, R.anim.none, R.anim.none, R.anim.exit_to_bottom);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
