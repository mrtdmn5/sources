package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AppsNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$SearchTopAppBar$1$1", f = "AppsNotificationsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt$SearchTopAppBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ boolean $isSearchActive;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppsNotificationsFragmentKt$SearchTopAppBar$1$1(boolean z, FocusRequester focusRequester, Continuation<? super AppsNotificationsFragmentKt$SearchTopAppBar$1$1> continuation) {
        super(2, continuation);
        this.$isSearchActive = z;
        this.$focusRequester = focusRequester;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppsNotificationsFragmentKt$SearchTopAppBar$1$1(this.$isSearchActive, this.$focusRequester, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isSearchActive) {
                this.$focusRequester.focus$ui_release();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppsNotificationsFragmentKt$SearchTopAppBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
