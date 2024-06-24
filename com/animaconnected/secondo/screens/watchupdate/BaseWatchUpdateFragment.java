package com.animaconnected.secondo.screens.watchupdate;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter;
import com.animaconnected.secondo.screens.watchupdate.UpdateFailedDialogFragment;
import com.kronaby.watch.app.R;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseWatchUpdateFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseWatchUpdateFragment extends BaseOnboardingFragment implements WatchViewLayouter, UpdateFailedDialogFragment.UpdateFailedDialogFragmentCallback, BaseWatchUpdatePresenter.WatchUpdateView {
    public static final String NAME = "watchUpdate";
    private boolean animationLoaded;
    private LottieAnimationView animationView;
    private DialogFragment currentDialog;
    protected View pausedProgressBar;
    protected Button startUpdateButton;
    private View startUpdateLayout;
    protected TextView startUpdateWarningText;
    protected BaseWatchUpdatePresenter watchUpdatePresenter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private AnimationState currentAnimationState = AnimationState.NOT_STARTED;
    private final String name = NAME;

    /* compiled from: BaseWatchUpdateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class AnimationState extends Enum<AnimationState> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationState[] $VALUES;
        public static final AnimationState NOT_STARTED = new AnimationState("NOT_STARTED", 0);
        public static final AnimationState UPDATING = new AnimationState("UPDATING", 1);
        public static final AnimationState COMPLETED = new AnimationState("COMPLETED", 2);

        private static final /* synthetic */ AnimationState[] $values() {
            return new AnimationState[]{NOT_STARTED, UPDATING, COMPLETED};
        }

        static {
            AnimationState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private AnimationState(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<AnimationState> getEntries() {
            return $ENTRIES;
        }

        public static AnimationState valueOf(String str) {
            return (AnimationState) Enum.valueOf(AnimationState.class, str);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) $VALUES.clone();
        }
    }

    /* compiled from: BaseWatchUpdateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: BaseWatchUpdateFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[AnimationState.values().length];
            try {
                r0[AnimationState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[AnimationState.UPDATING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[AnimationState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final void onCreateView$lambda$1$lambda$0(BaseWatchUpdateFragment this$0, LottieComposition result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        LottieAnimationView lottieAnimationView = this$0.animationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setComposition(result);
            this$0.animationLoaded = true;
            this$0.updateAnimation();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
        throw null;
    }

    private final void updateAnimation() {
        if (!this.animationLoaded) {
            return;
        }
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.currentAnimationState.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    LottieAnimationView lottieAnimationView = this.animationView;
                    if (lottieAnimationView != null) {
                        lottieAnimationView.lottieDrawable.setMinAndMaxFrame("loop_start", "update_complete", true);
                        lottieAnimationView.setRepeatCount(0);
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("animationView");
                        throw null;
                    }
                }
                return;
            }
            LottieAnimationView lottieAnimationView2 = this.animationView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.lottieDrawable.setMinAndMaxFrame("loop_start", "loop_end", true);
                lottieAnimationView2.playAnimation();
                lottieAnimationView2.setRepeatCount(-1);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("animationView");
            throw null;
        }
        LottieAnimationView lottieAnimationView3 = this.animationView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setMinAndMaxFrame("loop_start");
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("animationView");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    public final AnimationState getCurrentAnimationState$secondo_kronabyRelease() {
        return this.currentAnimationState;
    }

    public final DialogFragment getCurrentDialog() {
        return this.currentDialog;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public abstract int getLayoutResourceId();

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getParentFragmentName() {
        if (getWatchUpdatePresenter().hasUpdateStarted()) {
            return NAME;
        }
        return null;
    }

    public final View getPausedProgressBar() {
        View view = this.pausedProgressBar;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pausedProgressBar");
        throw null;
    }

    public final Button getStartUpdateButton() {
        Button button = this.startUpdateButton;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startUpdateButton");
        throw null;
    }

    public final TextView getStartUpdateWarningText() {
        TextView textView = this.startUpdateWarningText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startUpdateWarningText");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[0];
    }

    public final BaseWatchUpdatePresenter getWatchUpdatePresenter() {
        BaseWatchUpdatePresenter baseWatchUpdatePresenter = this.watchUpdatePresenter;
        if (baseWatchUpdatePresenter != null) {
            return baseWatchUpdatePresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchUpdatePresenter");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void goBackToSettings() {
        getMainController().goBack();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.UPDATE_REQUIRED) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void hideDialogs() {
        getPausedProgressBar().setVisibility(4);
        DialogFragment dialogFragment = this.currentDialog;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        this.currentDialog = null;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(getLayoutResourceId(), viewGroup, false);
        View findViewById = inflate.findViewById(R.id.paused_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setPausedProgressBar(findViewById);
        View findViewById2 = inflate.findViewById(R.id.start_update_varning_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        setStartUpdateWarningText((TextView) findViewById2);
        View findViewById3 = inflate.findViewById(R.id.start_update_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.startUpdateLayout = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.start_update_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        setStartUpdateButton((Button) findViewById4);
        View findViewById5 = inflate.findViewById(R.id.lottie_animation_view);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById5;
        this.animationView = lottieAnimationView;
        lottieAnimationView.lottieDrawable.animator.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment$onCreateView$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (BaseWatchUpdateFragment.this.getCurrentAnimationState$secondo_kronabyRelease() == BaseWatchUpdateFragment.AnimationState.COMPLETED) {
                    ProviderFactory.getWatchUpdateProvider().dismissWatchUpdateNotification();
                    if (BaseWatchUpdateFragment.this.isOnboarding()) {
                        BaseWatchUpdateFragment.this.getOnboarding().onUpdateCompleted();
                    } else {
                        BaseWatchUpdateFragment.this.getMainController().gotoNextFragment(WatchUpdateCompletedFragment.Companion.newInstance());
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        });
        Context context = inflate.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Lottie.loadAnimation(context, LottieFile.WatchUpdateAnimation).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                BaseWatchUpdateFragment.onCreateView$lambda$1$lambda$0(BaseWatchUpdateFragment.this, (LottieComposition) obj);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getWatchUpdatePresenter().onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getWatchUpdatePresenter().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getWatchUpdatePresenter().onResume();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.UpdateFailedDialogFragment.UpdateFailedDialogFragmentCallback
    public void onTryAgainClicked() {
        getMainController().goBack();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void onUpdateDone() {
        this.currentAnimationState = AnimationState.COMPLETED;
        updateAnimation();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void onUpdateStarted() {
        this.currentAnimationState = AnimationState.UPDATING;
        View view = this.startUpdateLayout;
        if (view != null) {
            view.setVisibility(4);
            updateAnimation();
            showToolbarUpIndicator(false);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startUpdateLayout");
        throw null;
    }

    public final void setCurrentAnimationState$secondo_kronabyRelease(AnimationState animationState) {
        Intrinsics.checkNotNullParameter(animationState, "<set-?>");
        this.currentAnimationState = animationState;
    }

    public final void setCurrentDialog(DialogFragment dialogFragment) {
        this.currentDialog = dialogFragment;
    }

    public final void setPausedDialog(DialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        DialogFragment dialogFragment = this.currentDialog;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        this.currentDialog = dialog;
        dialog.show(getChildFragmentManager(), (String) null);
    }

    public final void setPausedProgressBar(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.pausedProgressBar = view;
    }

    public final void setStartUpdateButton(Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.startUpdateButton = button;
    }

    public final void setStartUpdateWarningText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.startUpdateWarningText = textView;
    }

    public final void setWatchUpdatePresenter(BaseWatchUpdatePresenter baseWatchUpdatePresenter) {
        Intrinsics.checkNotNullParameter(baseWatchUpdatePresenter, "<set-?>");
        this.watchUpdatePresenter = baseWatchUpdatePresenter;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void showBluetoothDisabledDialog() {
        getPausedProgressBar().setVisibility(0);
        DialogFragment dialogFragment = this.currentDialog;
        if (dialogFragment == null || !(dialogFragment instanceof BluetoothDisabledDialogFragment)) {
            setPausedDialog(BluetoothDisabledDialogFragment.Companion.newInstance());
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void showBluetoothDisabledWarning() {
        boolean z;
        Button startUpdateButton = getStartUpdateButton();
        if (Build.VERSION.SDK_INT >= 33) {
            startUpdateButton.setText(R.string.watch_update_start_update_button);
            z = false;
        } else {
            startUpdateButton.setText(R.string.watch_update_paused_bluetooth_disabled_button);
            z = true;
        }
        startUpdateButton.setEnabled(z);
        getStartUpdateWarningText().setText(R.string.watch_update_error_bluetooth_off);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void showDisconnectedWarning() {
        Button startUpdateButton = getStartUpdateButton();
        startUpdateButton.setText(R.string.watch_update_start_update_button);
        startUpdateButton.setEnabled(false);
        getStartUpdateWarningText().setText(R.string.watch_update_error_disconnected);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void showStartWatchUpdate(boolean z) {
        int r2;
        Button startUpdateButton = getStartUpdateButton();
        if (z) {
            r2 = R.string.watch_update_resume;
        } else {
            r2 = R.string.watch_update_start_update_button;
        }
        startUpdateButton.setText(r2);
        startUpdateButton.setEnabled(true);
        getStartUpdateWarningText().setText("");
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r1) {
    }
}
