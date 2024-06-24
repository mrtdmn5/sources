package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusManager;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$6", f = "AppsNotificationsFragment.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail, R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragment$ComposeContent$3$1$6 extends SuspendLambda implements Function4<String, String, Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ State<Boolean> $isKeyBoardVisible$delegate;
    final /* synthetic */ PermissionState $permissionState;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AppsNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragment$ComposeContent$3$1$6(PermissionState permissionState, FocusManager focusManager, ModalBottomSheetState modalBottomSheetState, AppsNotificationsFragment appsNotificationsFragment, State<Boolean> state, Continuation<? super AppsNotificationsFragment$ComposeContent$3$1$6> continuation) {
        super(4, continuation);
        this.$permissionState = permissionState;
        this.$focusManager = focusManager;
        this.$sheetState = modalBottomSheetState;
        this.this$0 = appsNotificationsFragment;
        this.$isKeyBoardVisible$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String str, String str2, Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(str, str2, bool.booleanValue(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r8)
            goto L63
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L18:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4f
        L1c:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r1 = r7.L$1
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = r7.Z$0
            com.animaconnected.secondo.screens.onboarding.PermissionState r5 = r7.$permissionState
            com.animaconnected.secondo.screens.onboarding.PermissionState$Denied r6 = com.animaconnected.secondo.screens.onboarding.PermissionState.Denied.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L5a
            androidx.compose.runtime.State<java.lang.Boolean> r8 = r7.$isKeyBoardVisible$delegate
            boolean r8 = com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment.access$ComposeContent$lambda$4(r8)
            if (r8 == 0) goto L4f
            androidx.compose.ui.focus.FocusManager r8 = r7.$focusManager
            r1 = 0
            r8.clearFocus(r1)
            r8 = 0
            r7.L$0 = r8
            r7.label = r3
            r3 = 50
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r3, r7)
            if (r8 != r0) goto L4f
            return r0
        L4f:
            androidx.compose.material.ModalBottomSheetState r8 = r7.$sheetState
            r7.label = r2
            java.lang.Object r8 = r8.show(r7)
            if (r8 != r0) goto L63
            return r0
        L5a:
            com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment r0 = r7.this$0
            com.animaconnected.secondo.screens.settings.displaynotifications.DisplayNotificationViewModel r0 = com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment.access$getViewModel$p(r0)
            r0.setEnabled(r8, r1, r4)
        L63:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment$ComposeContent$3$1$6.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(String str, String str2, boolean z, Continuation<? super Unit> continuation) {
        AppsNotificationsFragment$ComposeContent$3$1$6 appsNotificationsFragment$ComposeContent$3$1$6 = new AppsNotificationsFragment$ComposeContent$3$1$6(this.$permissionState, this.$focusManager, this.$sheetState, this.this$0, this.$isKeyBoardVisible$delegate, continuation);
        appsNotificationsFragment$ComposeContent$3$1$6.L$0 = str;
        appsNotificationsFragment$ComposeContent$3$1$6.L$1 = str2;
        appsNotificationsFragment$ComposeContent$3$1$6.Z$0 = z;
        return appsNotificationsFragment$ComposeContent$3$1$6.invokeSuspend(Unit.INSTANCE);
    }
}
