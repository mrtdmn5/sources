package com.animaconnected.secondo.screens.onboarding.permissions;

import androidx.compose.material.BottomSheetScaffoldState;
import androidx.compose.material.BottomSheetState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SmsPermissionFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1", f = "SmsPermissionFragment.kt", l = {81}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomSheetScaffoldState $sheetState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1> continuation) {
        super(2, continuation);
        this.$sheetState = bottomSheetScaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1(this.$sheetState, continuation);
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
            BottomSheetState bottomSheetState = this.$sheetState.bottomSheetState;
            this.label = 1;
            if (bottomSheetState.collapse(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
