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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$1", f = "AppsNotificationsFragment.kt", l = {87, 89}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragment$ComposeContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PermissionState $permissionState;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragment$ComposeContent$1(PermissionState permissionState, ModalBottomSheetState modalBottomSheetState, Continuation<? super AppsNotificationsFragment$ComposeContent$1> continuation) {
        super(2, continuation);
        this.$permissionState = permissionState;
        this.$sheetState = modalBottomSheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppsNotificationsFragment$ComposeContent$1(this.$permissionState, this.$sheetState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1 && r1 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$permissionState, PermissionState.Denied.INSTANCE)) {
                ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                this.label = 1;
                if (modalBottomSheetState.show(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                ModalBottomSheetState modalBottomSheetState2 = this.$sheetState;
                this.label = 2;
                if (modalBottomSheetState2.hide(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragment$ComposeContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
