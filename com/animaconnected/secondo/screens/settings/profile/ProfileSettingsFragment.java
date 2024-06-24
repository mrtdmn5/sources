package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.animaconnected.secondo.databinding.DialogGenericBinding;
import com.animaconnected.secondo.databinding.FragmentProfileSettingsBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.animaconnected.watch.account.AccountApi;
import com.animaconnected.watch.account.AccountHttpClient;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: ProfileSettingsFragment.kt */
/* loaded from: classes3.dex */
public final class ProfileSettingsFragment extends BaseFragment {
    private FragmentProfileSettingsBinding binding;
    private DownloadDataViewModel downloadDataViewModel;
    private final String featurePathName = "Settings";
    private final String name = "ProfileSettingsFragment";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ProfileSettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileSettingsFragment newInstance() {
            return new ProfileSettingsFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialogDataAvailable(final String str) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new Function2<BottomDialog, LayoutInflater, ViewBinding>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$showDialogDataAvailable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                DialogGenericBinding inflate = DialogGenericBinding.inflate(inflater);
                ProfileSettingsFragment profileSettingsFragment = ProfileSettingsFragment.this;
                String str2 = str;
                inflate.tvTitle.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_dialog_title));
                inflate.tvBody.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_dialog_download_message));
                inflate.btnPrimary.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_open_download_link));
                inflate.btnSecondary.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_request_new_file));
                Button btnPrimary = inflate.btnPrimary;
                Intrinsics.checkNotNullExpressionValue(btnPrimary, "btnPrimary");
                profileSettingsFragment.onClick(btnPrimary, new ProfileSettingsFragment$showDialogDataAvailable$1$1$1(profileSettingsFragment, dialog, str2, null));
                Button btnSecondary = inflate.btnSecondary;
                Intrinsics.checkNotNullExpressionValue(btnSecondary, "btnSecondary");
                profileSettingsFragment.onClick(btnSecondary, new ProfileSettingsFragment$showDialogDataAvailable$1$1$2(dialog, profileSettingsFragment, null));
                return inflate;
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialogStartDownload() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        BottomSheetKt.createBottomDialog(requireContext, new Function2<BottomDialog, LayoutInflater, ViewBinding>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$showDialogStartDownload$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final ViewBinding invoke(BottomDialog dialog, LayoutInflater inflater) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                DialogGenericBinding inflate = DialogGenericBinding.inflate(inflater);
                ProfileSettingsFragment profileSettingsFragment = ProfileSettingsFragment.this;
                inflate.tvTitle.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_dialog_title));
                inflate.tvBody.setText(profileSettingsFragment.getString(R.string.account_settings_download_data_dialog_start_message));
                inflate.btnPrimary.setText(profileSettingsFragment.getString(R.string.button_send_request));
                inflate.btnSecondary.setText(profileSettingsFragment.getString(R.string.button_cancel));
                Button btnPrimary = inflate.btnPrimary;
                Intrinsics.checkNotNullExpressionValue(btnPrimary, "btnPrimary");
                profileSettingsFragment.onClick(btnPrimary, new ProfileSettingsFragment$showDialogStartDownload$1$1$1(profileSettingsFragment, dialog, null));
                Button btnSecondary = inflate.btnSecondary;
                Intrinsics.checkNotNullExpressionValue(btnSecondary, "btnSecondary");
                profileSettingsFragment.onClick(btnSecondary, new ProfileSettingsFragment$showDialogStartDownload$1$1$2(dialog, null));
                return inflate;
            }
        }).show();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return this.featurePathName;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentProfileSettingsBinding inflate = FragmentProfileSettingsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        DownloadDataViewModel downloadDataViewModel = new DownloadDataViewModel(new AccountApi(new AccountHttpClient(ProviderFactory.getPoolIdProvider().isOnSandbox())));
        this.downloadDataViewModel = downloadDataViewModel;
        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new ProfileSettingsFragment$onViewCreated$1(this, createLoginViewModel, null), downloadDataViewModel.getState()), Hashing.getLifecycleScope(this));
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ProfileSettingsFragment$onViewCreated$2(this, null), 3);
        FragmentProfileSettingsBinding fragmentProfileSettingsBinding = this.binding;
        if (fragmentProfileSettingsBinding != null) {
            RelativeLayout btnDownloadData = fragmentProfileSettingsBinding.btnDownloadData;
            Intrinsics.checkNotNullExpressionValue(btnDownloadData, "btnDownloadData");
            onClick(btnDownloadData, new ProfileSettingsFragment$onViewCreated$5(this, null));
            FragmentProfileSettingsBinding fragmentProfileSettingsBinding2 = this.binding;
            if (fragmentProfileSettingsBinding2 != null) {
                Button btnDeleteAcc = fragmentProfileSettingsBinding2.btnDeleteAcc;
                Intrinsics.checkNotNullExpressionValue(btnDeleteAcc, "btnDeleteAcc");
                onClick(btnDeleteAcc, new ProfileSettingsFragment$onViewCreated$6(this, createLoginViewModel, null));
                FragmentProfileSettingsBinding fragmentProfileSettingsBinding3 = this.binding;
                if (fragmentProfileSettingsBinding3 != null) {
                    Button btnLogOut = fragmentProfileSettingsBinding3.btnLogOut;
                    Intrinsics.checkNotNullExpressionValue(btnLogOut, "btnLogOut");
                    onClick(btnLogOut, new ProfileSettingsFragment$onViewCreated$7(this, createLoginViewModel, null));
                    createLoginViewModel.getDialog().observe(getViewLifecycleOwner(), new ProfileSettingsFragment$sam$androidx_lifecycle_Observer$0(new Function1<DialogMessage, Unit>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileSettingsFragment$onViewCreated$8
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DialogMessage dialogMessage) {
                            invoke2(dialogMessage);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DialogMessage dialogMessage) {
                            Context requireContext = ProfileSettingsFragment.this.requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            Intrinsics.checkNotNull(dialogMessage);
                            AccountUtilsKt.showDialogInfo$default(requireContext, DialogMessageKt.getDialogInfo(dialogMessage), null, 4, null);
                        }
                    }));
                    BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ProfileSettingsFragment$onViewCreated$9(createLoginViewModel, this, null), 3);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
