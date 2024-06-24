package com.animaconnected.secondo.screens.settings.profile;

import android.widget.ImageView;
import android.widget.TextView;
import com.animaconnected.secondo.databinding.FragmentProfileSettingsBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.settings.profile.DownloadDataViewModel;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.device.DateFormatter;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileSettingsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$1", f = "ProfileSettingsFragment.kt", l = {96}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment$onViewCreated$1 extends SuspendLambda implements Function2<DownloadDataViewModel.AccountDownloadState, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginViewModel $loginViewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingsFragment$onViewCreated$1(ProfileSettingsFragment profileSettingsFragment, LoginViewModel loginViewModel, Continuation<? super ProfileSettingsFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = profileSettingsFragment;
        this.$loginViewModel = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileSettingsFragment$onViewCreated$1 profileSettingsFragment$onViewCreated$1 = new ProfileSettingsFragment$onViewCreated$1(this.this$0, this.$loginViewModel, continuation);
        profileSettingsFragment$onViewCreated$1.L$0 = obj;
        return profileSettingsFragment$onViewCreated$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DownloadDataViewModel.AccountDownloadState accountDownloadState, Continuation<? super Unit> continuation) {
        return ((ProfileSettingsFragment$onViewCreated$1) create(accountDownloadState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentProfileSettingsBinding fragmentProfileSettingsBinding;
        FragmentProfileSettingsBinding fragmentProfileSettingsBinding2;
        FragmentProfileSettingsBinding fragmentProfileSettingsBinding3;
        FragmentProfileSettingsBinding fragmentProfileSettingsBinding4;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            DownloadDataViewModel.AccountDownloadState accountDownloadState = (DownloadDataViewModel.AccountDownloadState) this.L$0;
            if (Intrinsics.areEqual(accountDownloadState, DownloadDataViewModel.AccountDownloadState.Idle.INSTANCE)) {
                fragmentProfileSettingsBinding4 = this.this$0.binding;
                if (fragmentProfileSettingsBinding4 != null) {
                    fragmentProfileSettingsBinding4.btnDownloadData.setEnabled(false);
                    fragmentProfileSettingsBinding4.btnDownloadData.setAlpha(0.3f);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else if (Intrinsics.areEqual(accountDownloadState, DownloadDataViewModel.AccountDownloadState.InitiateDownload.INSTANCE)) {
                fragmentProfileSettingsBinding3 = this.this$0.binding;
                if (fragmentProfileSettingsBinding3 != null) {
                    fragmentProfileSettingsBinding3.btnDownloadData.setEnabled(true);
                    fragmentProfileSettingsBinding3.btnDownloadData.setAlpha(1.0f);
                    TextView tvSubtitleDownloadData = fragmentProfileSettingsBinding3.tvSubtitleDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvSubtitleDownloadData, "tvSubtitleDownloadData");
                    ViewKt.gone(tvSubtitleDownloadData);
                    TextView tvExpirationDownloadData = fragmentProfileSettingsBinding3.tvExpirationDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvExpirationDownloadData, "tvExpirationDownloadData");
                    ViewKt.gone(tvExpirationDownloadData);
                    ImageView ivMarbleDownload = fragmentProfileSettingsBinding3.ivMarbleDownload;
                    Intrinsics.checkNotNullExpressionValue(ivMarbleDownload, "ivMarbleDownload");
                    ViewKt.gone(ivMarbleDownload);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else if (Intrinsics.areEqual(accountDownloadState, DownloadDataViewModel.AccountDownloadState.InProgress.INSTANCE)) {
                fragmentProfileSettingsBinding2 = this.this$0.binding;
                if (fragmentProfileSettingsBinding2 != null) {
                    ProfileSettingsFragment profileSettingsFragment = this.this$0;
                    fragmentProfileSettingsBinding2.btnDownloadData.setEnabled(false);
                    fragmentProfileSettingsBinding2.btnDownloadData.setAlpha(0.3f);
                    TextView tvSubtitleDownloadData2 = fragmentProfileSettingsBinding2.tvSubtitleDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvSubtitleDownloadData2, "tvSubtitleDownloadData");
                    ViewKt.visible(tvSubtitleDownloadData2);
                    TextView tvExpirationDownloadData2 = fragmentProfileSettingsBinding2.tvExpirationDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvExpirationDownloadData2, "tvExpirationDownloadData");
                    ViewKt.gone(tvExpirationDownloadData2);
                    ImageView ivMarbleDownload2 = fragmentProfileSettingsBinding2.ivMarbleDownload;
                    Intrinsics.checkNotNullExpressionValue(ivMarbleDownload2, "ivMarbleDownload");
                    ViewKt.gone(ivMarbleDownload2);
                    fragmentProfileSettingsBinding2.tvSubtitleDownloadData.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_in_progress));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else if (accountDownloadState instanceof DownloadDataViewModel.AccountDownloadState.DataAvailable) {
                fragmentProfileSettingsBinding = this.this$0.binding;
                if (fragmentProfileSettingsBinding != null) {
                    ProfileSettingsFragment profileSettingsFragment2 = this.this$0;
                    String format$default = DateFormatter.format$default(new AndroidDateFormatter("MMM d yyyy", ProviderFactory.createConfigProvider().getTranslationCompatibleLocale()), ((DownloadDataViewModel.AccountDownloadState.DataAvailable) accountDownloadState).getExpirationDate().toEpochMilliseconds(), null, false, 6, null);
                    fragmentProfileSettingsBinding.btnDownloadData.setEnabled(true);
                    fragmentProfileSettingsBinding.btnDownloadData.setAlpha(1.0f);
                    TextView tvSubtitleDownloadData3 = fragmentProfileSettingsBinding.tvSubtitleDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvSubtitleDownloadData3, "tvSubtitleDownloadData");
                    ViewKt.visible(tvSubtitleDownloadData3);
                    TextView tvExpirationDownloadData3 = fragmentProfileSettingsBinding.tvExpirationDownloadData;
                    Intrinsics.checkNotNullExpressionValue(tvExpirationDownloadData3, "tvExpirationDownloadData");
                    ViewKt.visible(tvExpirationDownloadData3);
                    ImageView ivMarbleDownload3 = fragmentProfileSettingsBinding.ivMarbleDownload;
                    Intrinsics.checkNotNullExpressionValue(ivMarbleDownload3, "ivMarbleDownload");
                    ViewKt.visible(ivMarbleDownload3);
                    fragmentProfileSettingsBinding.tvSubtitleDownloadData.setText(profileSettingsFragment2.getString(R.string.account_settings_download_data_ready));
                    fragmentProfileSettingsBinding.tvExpirationDownloadData.setText(profileSettingsFragment2.getString(R.string.account_settings_download_data_expires, format$default));
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            } else if (Intrinsics.areEqual(accountDownloadState, DownloadDataViewModel.AccountDownloadState.Unauthorized.INSTANCE)) {
                LoginViewModel loginViewModel = this.$loginViewModel;
                this.label = 1;
                if (loginViewModel.signOut(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
