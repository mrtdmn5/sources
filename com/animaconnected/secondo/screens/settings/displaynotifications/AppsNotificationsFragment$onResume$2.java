package com.animaconnected.secondo.screens.settings.displaynotifications;

import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$onResume$2", f = "AppsNotificationsFragment.kt", l = {58, 59}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragment$onResume$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppsNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragment$onResume$2(AppsNotificationsFragment appsNotificationsFragment, Continuation<? super AppsNotificationsFragment$onResume$2> continuation) {
        super(2, continuation);
        this.this$0 = appsNotificationsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppsNotificationsFragment$onResume$2(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DisplayNotificationViewModel displayNotificationViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            long integer = this.this$0.getResources().getInteger(R.integer.screen_transition_duration_horizontal);
            this.label = 1;
            if (DelayKt.delay(integer, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        displayNotificationViewModel = this.this$0.viewModel;
        this.label = 2;
        if (displayNotificationViewModel.refreshAppsList(this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragment$onResume$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
