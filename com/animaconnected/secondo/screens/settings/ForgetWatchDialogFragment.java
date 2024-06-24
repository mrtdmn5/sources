package com.animaconnected.secondo.screens.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.DialogfragmentSettingsForgetWatchBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.analytics.WatchProviderAnalytics;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.WatchProvider;
import com.google.common.collect.Hashing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ForgetWatchDialogFragment.kt */
/* loaded from: classes3.dex */
public final class ForgetWatchDialogFragment extends BottomSheetBaseDialogFragment {
    private static final String ACTION_FORGET_WATCH = "forget_watch";
    private static final String BUNDLE_ADDRESS = "address";
    private static final long RESET_DEVICE_TIMEOUT = 15000;
    private String mAddress;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "ForgetWatchDialogFragment";

    /* compiled from: ForgetWatchDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ForgetWatchDialogFragment newInstance(String str) {
            ForgetWatchDialogFragment forgetWatchDialogFragment = new ForgetWatchDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("address", str);
            forgetWatchDialogFragment.setArguments(bundle);
            return forgetWatchDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$1(DialogfragmentSettingsForgetWatchBinding binding, ForgetWatchDialogFragment this$0, WatchProvider watch, View view) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        ProviderFactory.getAppAnalytics().sendAction(ACTION_FORGET_WATCH);
        binding.dialogForgetWatchAbort.setEnabled(false);
        FrameLayout forgetDeviceProgress = binding.forgetDeviceProgress;
        Intrinsics.checkNotNullExpressionValue(forgetDeviceProgress, "forgetDeviceProgress");
        ViewKt.visible(forgetDeviceProgress);
        Fragment parentFragment = this$0.getParentFragment();
        String str = this$0.mAddress;
        if (str != null && !Intrinsics.areEqual(str, watch.getAddress())) {
            String str2 = this$0.mAddress;
            Intrinsics.checkNotNull(str2);
            watch.removeInactiveDevice(str2);
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            WatchProviderAnalytics.sendDevicesAnalytics(watch, requireContext);
            this$0.dismiss();
            CompanionDeviceUtils companionDeviceUtils = CompanionDeviceUtils.INSTANCE;
            Context requireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            if (!companionDeviceUtils.isLastAssociatedDevice(requireContext2)) {
                Context requireContext3 = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                String str3 = this$0.mAddress;
                Intrinsics.checkNotNull(str3);
                companionDeviceUtils.disassociate(requireContext3, str3);
            }
            if (parentFragment != null && parentFragment.isResumed()) {
                ((BaseFragment) parentFragment).getMainController().goBack();
                return;
            }
            return;
        }
        BuildersKt.launch$default(Hashing.getLifecycleScope(this$0), null, null, new ForgetWatchDialogFragment$onCreateDialogView$2$1(watch, this$0, parentFragment, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialogView$lambda$2(ForgetWatchDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        final DialogfragmentSettingsForgetWatchBinding inflate = DialogfragmentSettingsForgetWatchBinding.inflate(LayoutInflater.from(requireContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mAddress = arguments.getString("address");
        }
        final WatchProvider watch = ProviderFactory.getWatch();
        inflate.dialogForgetWatchAccept.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetWatchDialogFragment.onCreateDialogView$lambda$1(DialogfragmentSettingsForgetWatchBinding.this, this, watch, view);
            }
        });
        inflate.dialogForgetWatchAbort.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.ForgetWatchDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgetWatchDialogFragment.onCreateDialogView$lambda$2(ForgetWatchDialogFragment.this, view);
            }
        });
        dialog.setDismissible(false);
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }
}
