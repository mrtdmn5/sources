package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogLogoutAccountBinding;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.utils.Loading;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$7", f = "ProfileSettingsFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$onViewCreated$7 extends SuspendLambda implements Function2<View, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginViewModel $loginViewModel;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$onViewCreated$7(ProfileSettingsFragment profileSettingsFragment, LoginViewModel loginViewModel, Continuation<? super ProfileSettingsFragment$onViewCreated$7> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsFragment;
        this.$loginViewModel = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileSettingsFragment$onViewCreated$7(this.this$0, this.$loginViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(View view, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$onViewCreated$7) create(view, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            final ProfileSettingsFragment profileSettingsFragment = this.this$0;
            final LoginViewModel loginViewModel = this.$loginViewModel;
            BottomSheetKt.createBottomDialog(requireContext, new Function2<BottomDialog, LayoutInflater, ViewBinding>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$7.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    Intrinsics.checkNotNullParameter(inflater, "inflater");
                    DialogLogoutAccountBinding inflate = DialogLogoutAccountBinding.inflate(inflater);
                    ProfileSettingsFragment profileSettingsFragment2 = ProfileSettingsFragment.this;
                    LoginViewModel loginViewModel2 = loginViewModel;
                    Button btnLogout = inflate.btnLogout;
                    Intrinsics.checkNotNullExpressionValue(btnLogout, "btnLogout");
                    ProgressBar progressBar = inflate.progressBar;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                    Loading loading = new Loading(btnLogout, progressBar, false);
                    Button btnLogout2 = inflate.btnLogout;
                    Intrinsics.checkNotNullExpressionValue(btnLogout2, "btnLogout");
                    profileSettingsFragment2.onClick(btnLogout2, new ProfileSettingsFragment$onViewCreated$7$1$1$1(loading, loginViewModel2, dialog, null));
                    Button btnCancel = inflate.btnCancel;
                    Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
                    profileSettingsFragment2.onClick(btnCancel, new ProfileSettingsFragment$onViewCreated$7$1$1$2(dialog, null));
                    return inflate;
                }
            }).show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
