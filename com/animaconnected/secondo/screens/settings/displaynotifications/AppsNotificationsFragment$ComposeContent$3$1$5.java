package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.material.ModalBottomSheetState;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$5", f = "AppsNotificationsFragment.kt", l = {123, 125}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragment$ComposeContent$3$1$5 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ PermissionState $permissionState;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AppsNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragment$ComposeContent$3$1$5(PermissionState permissionState, ModalBottomSheetState modalBottomSheetState, AppsNotificationsFragment appsNotificationsFragment, Continuation<? super AppsNotificationsFragment$ComposeContent$3$1$5> continuation) {
        super(2, continuation);
        this.$permissionState = permissionState;
        this.$sheetState = modalBottomSheetState;
        this.this$0 = appsNotificationsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppsNotificationsFragment$ComposeContent$3$1$5 appsNotificationsFragment$ComposeContent$3$1$5 = new AppsNotificationsFragment$ComposeContent$3$1$5(this.$permissionState, this.$sheetState, this.this$0, continuation);
        appsNotificationsFragment$ComposeContent$3$1$5.Z$0 = ((Boolean) obj).booleanValue();
        return appsNotificationsFragment$ComposeContent$3$1$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DisplayNotificationViewModel displayNotificationViewModel;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1 && r1 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            if (!Intrinsics.areEqual(this.$permissionState, PermissionState.Denied.INSTANCE)) {
                displayNotificationViewModel = this.this$0.viewModel;
                this.label = 2;
                if (displayNotificationViewModel.setAllEnabled(z, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                this.label = 1;
                if (modalBottomSheetState.show(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragment$ComposeContent$3$1$5) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
