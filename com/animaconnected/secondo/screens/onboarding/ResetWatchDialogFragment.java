package com.animaconnected.secondo.screens.onboarding;

import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ResetWatchDialogFragment.kt */
/* loaded from: classes3.dex */
public final class ResetWatchDialogFragment extends BottomSheetBaseDialogFragment {
    public static final int $stable = 0;

    private final ResetWatchDialogFragmentCallback getResetWatchDialogFragmentCallback() {
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof ResetWatchDialogFragmentCallback) {
            return (ResetWatchDialogFragmentCallback) activity;
        }
        return null;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        View inflate = View.inflate(getContext(), R.layout.dialogfragment_onboarding_reset_watch, null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.animation_view_in);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ResetWatchDialogFragment$onCreateDialogView$1$1(inflate, (ProgressBar) inflate.findViewById(R.id.setup_progressbar), lottieAnimationView, null), 3);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ResetWatchDialogFragmentCallback resetWatchDialogFragmentCallback = getResetWatchDialogFragmentCallback();
        if (resetWatchDialogFragmentCallback != null) {
            resetWatchDialogFragmentCallback.resetWatchDialogDismissed();
        }
    }
}
