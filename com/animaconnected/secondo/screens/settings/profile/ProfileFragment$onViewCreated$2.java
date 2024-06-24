package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import android.view.View;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt;
import com.animaconnected.secondo.screens.settings.AccountDialogsKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.secondo.utils.Internet;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileFragment$onViewCreated$2", f = "ProfileFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileFragment$onViewCreated$2 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileFragment$onViewCreated$2(ProfileFragment profileFragment, Continuation<? super ProfileFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileFragment$onViewCreated$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$onViewCreated$2) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DemoModeProvider demoModeProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            demoModeProvider = this.this$0.demoModeProvider;
            if (demoModeProvider.isCurrentlyEnabled()) {
                Context requireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                DisabledFunctionalityDescriptionBottomDialogKt.showSignInDisabledInfoBottomDialog(requireContext);
            } else if (!Internet.INSTANCE.isAvailable()) {
                Context requireContext2 = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                AccountUtilsKt.showDialogInfo$default(requireContext2, DialogMessageKt.getDialogInfo(DialogMessage.NoInternetConnection.INSTANCE), null, 4, null);
            } else {
                AccountDialogsKt.showLoginDialog(this.this$0);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
