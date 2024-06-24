package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingAnimationsBinding;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.OnboardingWatchAnimationsLayout;
import com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.display.DpUtilsKt;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda2;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWatchFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingWatchFragment extends BaseOnboardingFragment implements OnboardingWatchAnimationsLayout.CancelAnimationsStartedCallback {
    private static final long CHARGE_HINT_DURATION_MS = 6000;
    private static final long CONNECTED_DURATION_FROM_CONNECTING_MS = 3342;
    private static final long CONNECTED_DURATION_MS = 5000;
    private static final long FADE_DURATION = 500;
    private static final long GET_STARTED_HINT_DURATION_MS = 11000;
    private static final long SCANNING_HINT_DURATION_MS = 6000;
    private static final long TEXT_CONTAINER_ANIMATION_IN_DELAY = 100;
    private static final int TEXT_CONTAINER_ANIMATION_OFFSET_DP = 10;
    private static final int WELCOME_TEXT_START_OFFSET_DP = 15;
    private ViewPropertyAnimator anim;
    private FragmentOnboardingAnimationsBinding binding;
    private Hint currentHint;
    private Float textInitialPosition;
    private int welcomeTextStartOffset;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable scanningRunnable = new Runnable() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            OnboardingWatchFragment.scanningRunnable$lambda$0(OnboardingWatchFragment.this);
        }
    };
    private final Runnable connectedFinishedRunnable = new FirebaseMessaging$$ExternalSyntheticLambda2(1, this);
    private final int textContainerOffset = DpUtilsKt.toPxInt(10);
    private final String name = "OnboardingWatchFragment";

    /* compiled from: OnboardingWatchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingWatchFragment newInstance() {
            return new OnboardingWatchFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: OnboardingWatchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Hint extends Enum<Hint> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Hint[] $VALUES;
        public static final Hint GET_STARTED = new Hint("GET_STARTED", 0);
        public static final Hint CHARGED = new Hint("CHARGED", 1);
        public static final Hint SCANNING = new Hint("SCANNING", 2);

        private static final /* synthetic */ Hint[] $values() {
            return new Hint[]{GET_STARTED, CHARGED, SCANNING};
        }

        static {
            Hint[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Hint(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<Hint> getEntries() {
            return $ENTRIES;
        }

        public static Hint valueOf(String str) {
            return (Hint) Enum.valueOf(Hint.class, str);
        }

        public static Hint[] values() {
            return (Hint[]) $VALUES.clone();
        }
    }

    /* compiled from: OnboardingWatchFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[Onboarding.State.values().length];
            try {
                r0[Onboarding.State.WELCOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Onboarding.State.SCANNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Onboarding.State.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Onboarding.State.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[Hint.values().length];
            try {
                r02[Hint.GET_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[Hint.CHARGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[Hint.SCANNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public static final void connectedFinishedRunnable$lambda$1(OnboardingWatchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboarding().setConnectedScreenDone();
    }

    public final Hint getNextHint(Hint hint) {
        int r2;
        if (hint == null) {
            r2 = -1;
        } else {
            r2 = WhenMappings.$EnumSwitchMapping$1[hint.ordinal()];
        }
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 == 3) {
                    return Hint.GET_STARTED;
                }
                throw new RuntimeException("Invalid state");
            }
            return Hint.SCANNING;
        }
        if (getResources().getBoolean(R.bool.app_onboarding_charge_watch_hint)) {
            return Hint.CHARGED;
        }
        return Hint.SCANNING;
    }

    private final void goToConnectedUI() {
        scrollTextContainer(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$goToConnectedUI$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                OnboardingWatchFragment.this.setConnectedTitleDescription();
            }
        });
        this.handler.postDelayed(this.connectedFinishedRunnable, CONNECTED_DURATION_FROM_CONNECTING_MS);
    }

    private final void initUI() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[getOnboarding().getState().ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 == 4) {
                        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
                        if (fragmentOnboardingAnimationsBinding != null) {
                            this.handler.removeCallbacks(this.scanningRunnable);
                            if (fragmentOnboardingAnimationsBinding.layoutWatchAnimation.isWatchHandAnimationsRunning()) {
                                fragmentOnboardingAnimationsBinding.layoutWatchAnimation.cancelWatchHandAnimations();
                            } else {
                                this.handler.postDelayed(this.connectedFinishedRunnable, 5000L);
                            }
                            setConnectedTitleDescription();
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                    return;
                }
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding2 = this.binding;
                if (fragmentOnboardingAnimationsBinding2 != null) {
                    this.handler.removeCallbacks(this.scanningRunnable);
                    fragmentOnboardingAnimationsBinding2.layoutWatchAnimation.startWatchHandAnimations();
                    setConnectingTitleDescription();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding3 = this.binding;
            if (fragmentOnboardingAnimationsBinding3 != null) {
                this.handler.postDelayed(this.scanningRunnable, GET_STARTED_HINT_DURATION_MS);
                if (getOnboarding().getHasOneDeviceBeenFound()) {
                    fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.cancelButtonAndArrowAnimations();
                    fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.startWatchHandAnimations();
                    this.handler.removeCallbacks(this.scanningRunnable);
                } else {
                    fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.startButtonAndArrowAnimations();
                }
                setScanningTitleDescription();
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding4 = this.binding;
        if (fragmentOnboardingAnimationsBinding4 != null) {
            TextView tvTitle = fragmentOnboardingAnimationsBinding4.tvTitle;
            Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
            ViewKt.visible(tvTitle);
            fragmentOnboardingAnimationsBinding4.tvTitle.setText(getString(R.string.welcome));
            fragmentOnboardingAnimationsBinding4.btnCancel.setEnabled(false);
            startWelcomeTextInTransition();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public static final void onCreateView$lambda$3$lambda$2(OnboardingWatchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboarding().cancelOnboarding();
    }

    public static final void scanningRunnable$lambda$0(OnboardingWatchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startScanningTextTransition();
    }

    private final void scrollTextContainer(final Function0<Unit> function0) {
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            final LinearLayout textContainer = fragmentOnboardingAnimationsBinding.textContainer;
            Intrinsics.checkNotNullExpressionValue(textContainer, "textContainer");
            final int r1 = this.textContainerOffset;
            if (this.textInitialPosition == null) {
                this.textInitialPosition = Float.valueOf(textContainer.getY());
            }
            ViewPropertyAnimator viewPropertyAnimator = this.anim;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
            }
            this.anim = textContainer.animate().alpha(0.0f).yBy(-r1).setDuration(FADE_DURATION).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    OnboardingWatchFragment.scrollTextContainer$lambda$16(OnboardingWatchFragment.this, function0, textContainer, r1);
                }
            });
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public static final void scrollTextContainer$lambda$16(OnboardingWatchFragment this$0, Function0 onGoneAction, LinearLayout view, int r4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onGoneAction, "$onGoneAction");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (!this$0.isAdded()) {
            return;
        }
        onGoneAction.invoke();
        view.setAlpha(0.0f);
        Float f = this$0.textInitialPosition;
        Intrinsics.checkNotNull(f);
        float f2 = r4;
        view.setY(f.floatValue() + f2);
        this$0.anim = view.animate().alpha(1.0f).yBy(-f2).setDuration(FADE_DURATION).setInterpolator(new DecelerateInterpolator()).setStartDelay(TEXT_CONTAINER_ANIMATION_IN_DELAY).withEndAction(new Runnable() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OnboardingWatchFragment.scrollTextContainer$lambda$16$lambda$15(OnboardingWatchFragment.this);
            }
        });
    }

    public static final void scrollTextContainer$lambda$16$lambda$15(OnboardingWatchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAdded()) {
            return;
        }
        this$0.anim = null;
    }

    public final void setConnectedTitleDescription() {
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            TextView tvTitle = fragmentOnboardingAnimationsBinding.tvTitle;
            Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
            ViewKt.visible(tvTitle);
            fragmentOnboardingAnimationsBinding.tvTitle.setText(getString(R.string.connection_successful));
            fragmentOnboardingAnimationsBinding.tvDescription.setText("");
            fragmentOnboardingAnimationsBinding.btnCancel.setEnabled(false);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final void setConnectingTitleDescription() {
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            TextView tvTitle = fragmentOnboardingAnimationsBinding.tvTitle;
            Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
            ViewKt.visible(tvTitle);
            fragmentOnboardingAnimationsBinding.tvTitle.setText(getString(R.string.onboarding_connecting));
            fragmentOnboardingAnimationsBinding.tvDescription.setText(getString(R.string.onboarding_connecting_desc));
            fragmentOnboardingAnimationsBinding.btnCancel.setEnabled(false);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    public final void setScanningTitleDescription() {
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            TextView tvTitle = fragmentOnboardingAnimationsBinding.tvTitle;
            Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
            ViewKt.gone(tvTitle);
            fragmentOnboardingAnimationsBinding.tvTitle.setText("");
            fragmentOnboardingAnimationsBinding.tvDescription.setText(getString(R.string.scanning_description));
            fragmentOnboardingAnimationsBinding.btnCancel.setEnabled(true);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final void startScanningTextTransition() {
        scrollTextContainer(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$startScanningTextTransition$1

            /* compiled from: OnboardingWatchFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[OnboardingWatchFragment.Hint.values().length];
                    try {
                        r0[OnboardingWatchFragment.Hint.GET_STARTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        r0[OnboardingWatchFragment.Hint.SCANNING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        r0[OnboardingWatchFragment.Hint.CHARGED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Handler handler;
                Runnable runnable;
                OnboardingWatchFragment.Hint hint;
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding;
                Handler handler2;
                Runnable runnable2;
                OnboardingWatchFragment.Hint hint2;
                OnboardingWatchFragment.Hint nextHint;
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding2;
                Handler handler3;
                Runnable runnable3;
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding3;
                Handler handler4;
                Runnable runnable4;
                handler = OnboardingWatchFragment.this.handler;
                runnable = OnboardingWatchFragment.this.scanningRunnable;
                handler.removeCallbacks(runnable);
                hint = OnboardingWatchFragment.this.currentHint;
                int r0 = hint == null ? -1 : WhenMappings.$EnumSwitchMapping$0[hint.ordinal()];
                if (r0 == 1) {
                    fragmentOnboardingAnimationsBinding = OnboardingWatchFragment.this.binding;
                    if (fragmentOnboardingAnimationsBinding != null) {
                        OnboardingWatchFragment onboardingWatchFragment = OnboardingWatchFragment.this;
                        fragmentOnboardingAnimationsBinding.layoutWatchAnimation.startButtonAndArrowAnimations();
                        fragmentOnboardingAnimationsBinding.tvDescription.setText(onboardingWatchFragment.getString(R.string.scanning_description));
                        handler2 = onboardingWatchFragment.handler;
                        runnable2 = onboardingWatchFragment.scanningRunnable;
                        handler2.postDelayed(runnable2, 11000L);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                } else if (r0 == 2) {
                    fragmentOnboardingAnimationsBinding2 = OnboardingWatchFragment.this.binding;
                    if (fragmentOnboardingAnimationsBinding2 != null) {
                        OnboardingWatchFragment onboardingWatchFragment2 = OnboardingWatchFragment.this;
                        fragmentOnboardingAnimationsBinding2.layoutWatchAnimation.cancelButtonAndArrowAnimations();
                        fragmentOnboardingAnimationsBinding2.tvDescription.setText(onboardingWatchFragment2.getString(R.string.scanning_help_description));
                        handler3 = onboardingWatchFragment2.handler;
                        runnable3 = onboardingWatchFragment2.scanningRunnable;
                        handler3.postDelayed(runnable3, 6000L);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                } else if (r0 == 3) {
                    fragmentOnboardingAnimationsBinding3 = OnboardingWatchFragment.this.binding;
                    if (fragmentOnboardingAnimationsBinding3 != null) {
                        OnboardingWatchFragment onboardingWatchFragment3 = OnboardingWatchFragment.this;
                        fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.cancelButtonAndArrowAnimations();
                        fragmentOnboardingAnimationsBinding3.tvDescription.setText(onboardingWatchFragment3.getString(R.string.onboarding_chargeable_watch_description));
                        handler4 = onboardingWatchFragment3.handler;
                        runnable4 = onboardingWatchFragment3.scanningRunnable;
                        handler4.postDelayed(runnable4, 6000L);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        throw null;
                    }
                }
                OnboardingWatchFragment onboardingWatchFragment4 = OnboardingWatchFragment.this;
                hint2 = onboardingWatchFragment4.currentHint;
                nextHint = onboardingWatchFragment4.getNextHint(hint2);
                onboardingWatchFragment4.currentHint = nextHint;
            }
        });
    }

    private final void startWelcomeTextInTransition() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillBefore(true);
        animationSet.setDuration(1000L);
        animationSet.setInterpolator(new DecelerateInterpolator());
        animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, this.welcomeTextStartOffset, 0.0f));
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            fragmentOnboardingAnimationsBinding.tvTitle.startAnimation(animationSet);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingWatchAnimationsLayout.CancelAnimationsStartedCallback
    public void cancelAnimationsStarted() {
        goToConnectedUI();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public void foundOneDeviceWhenScanning() {
        if (getOnboarding().getState() == Onboarding.State.SCANNING) {
            FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
            if (fragmentOnboardingAnimationsBinding != null) {
                fragmentOnboardingAnimationsBinding.layoutWatchAnimation.cancelButtonAndArrowAnimations();
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding2 = this.binding;
                if (fragmentOnboardingAnimationsBinding2 != null) {
                    fragmentOnboardingAnimationsBinding2.layoutWatchAnimation.startWatchHandAnimations();
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getEnterAnimRes(Onboarding.State fromState) {
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        if (fromState == Onboarding.State.PAUSED) {
            return R.anim.onboarding_enter;
        }
        return R.anim.onboarding_resume;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        return R.anim.onboarding_pause;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state != Onboarding.State.WELCOME && state != Onboarding.State.SCANNING && state != Onboarding.State.CONNECTING && state != Onboarding.State.CONNECTED) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingAnimationsBinding inflate = FragmentOnboardingAnimationsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (getOnboarding().getHasOnboardedDevice()) {
            Button btnCancel = inflate.btnCancel;
            Intrinsics.checkNotNullExpressionValue(btnCancel, "btnCancel");
            ViewKt.visible(btnCancel);
        } else {
            Button btnCancel2 = inflate.btnCancel;
            Intrinsics.checkNotNullExpressionValue(btnCancel2, "btnCancel");
            ViewKt.gone(btnCancel2);
        }
        inflate.btnCancel.setEnabled(false);
        inflate.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnboardingWatchFragment.onCreateView$lambda$3$lambda$2(OnboardingWatchFragment.this, view);
            }
        });
        this.currentHint = getNextHint(Hint.GET_STARTED);
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            RelativeLayout root = fragmentOnboardingAnimationsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.handler.removeCallbacks(this.scanningRunnable);
        this.handler.removeCallbacks(this.connectedFinishedRunnable);
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            OnboardingWatchAnimationsLayout onboardingWatchAnimationsLayout = fragmentOnboardingAnimationsBinding.layoutWatchAnimation;
            onboardingWatchAnimationsLayout.stopAnimations();
            onboardingWatchAnimationsLayout.setCancelAnimationsStartedCallback(null);
            super.onPause();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            OnboardingWatchAnimationsLayout onboardingWatchAnimationsLayout = fragmentOnboardingAnimationsBinding.layoutWatchAnimation;
            onboardingWatchAnimationsLayout.setCancelAnimationsStartedCallback(this);
            onboardingWatchAnimationsLayout.resetAnimations();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
        if (fragmentOnboardingAnimationsBinding != null) {
            fragmentOnboardingAnimationsBinding.layoutWatchAnimation.setCancelAnimationsStartedCallback(this);
            this.welcomeTextStartOffset = DpUtilsKt.toPxInt(15);
            FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding2 = this.binding;
            if (fragmentOnboardingAnimationsBinding2 != null) {
                fragmentOnboardingAnimationsBinding2.btnAddPascal.setVisibility(8);
                FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding3 = this.binding;
                if (fragmentOnboardingAnimationsBinding3 != null) {
                    fragmentOnboardingAnimationsBinding3.btnAddHybrid.setVisibility(8);
                    initUI();
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public void updateUI() {
        if (getOnboarding().getPreviousState() == Onboarding.State.PAUSED) {
            initUI();
            return;
        }
        int r0 = WhenMappings.$EnumSwitchMapping$0[getOnboarding().getState().ordinal()];
        if (r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4) {
                    FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding = this.binding;
                    if (fragmentOnboardingAnimationsBinding != null) {
                        fragmentOnboardingAnimationsBinding.btnCancel.setEnabled(false);
                        this.handler.removeCallbacks(this.scanningRunnable);
                        if (fragmentOnboardingAnimationsBinding.layoutWatchAnimation.isWatchHandAnimationsRunning()) {
                            fragmentOnboardingAnimationsBinding.layoutWatchAnimation.cancelWatchHandAnimations();
                            return;
                        } else {
                            goToConnectedUI();
                            return;
                        }
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                return;
            }
            FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding2 = this.binding;
            if (fragmentOnboardingAnimationsBinding2 != null) {
                fragmentOnboardingAnimationsBinding2.btnCancel.setEnabled(false);
                this.handler.removeCallbacks(this.scanningRunnable);
                fragmentOnboardingAnimationsBinding2.layoutWatchAnimation.startWatchHandAnimations();
                scrollTextContainer(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$updateUI$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        OnboardingWatchFragment.this.setConnectingTitleDescription();
                    }
                });
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        FragmentOnboardingAnimationsBinding fragmentOnboardingAnimationsBinding3 = this.binding;
        if (fragmentOnboardingAnimationsBinding3 != null) {
            fragmentOnboardingAnimationsBinding3.btnCancel.setEnabled(true);
            this.handler.postDelayed(this.scanningRunnable, GET_STARTED_HINT_DURATION_MS);
            if (getOnboarding().getHasOneDeviceBeenFound()) {
                fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.cancelButtonAndArrowAnimations();
                fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.startWatchHandAnimations();
                this.handler.removeCallbacks(this.scanningRunnable);
            } else {
                fragmentOnboardingAnimationsBinding3.layoutWatchAnimation.startButtonAndArrowAnimations();
            }
            scrollTextContainer(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchFragment$updateUI$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    OnboardingWatchFragment.this.setScanningTitleDescription();
                }
            });
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
