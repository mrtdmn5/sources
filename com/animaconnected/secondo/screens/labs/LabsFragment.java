package com.animaconnected.secondo.screens.labs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.animaconnected.secondo.behaviour.BehaviourFactory;
import com.animaconnected.secondo.behaviour.phonebattery.PhoneBattery;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.labs.LabsProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.dice.Dice;
import com.animaconnected.watch.behaviour.stoptime.StopTime;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: LabsFragment.kt */
/* loaded from: classes3.dex */
public final class LabsFragment extends BaseFragment {
    private boolean isBlockedScrollView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy labsDescriptionText$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$labsDescriptionText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            View view = LabsFragment.this.getView();
            TextView textView = view != null ? (TextView) view.findViewById(R.id.labs_description_text) : null;
            Intrinsics.checkNotNull(textView, "null cannot be cast to non-null type android.widget.TextView");
            return textView;
        }
    });
    private final Lazy labsJoinButton$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$labsJoinButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Button invoke() {
            View view = LabsFragment.this.getView();
            Button button = view != null ? (Button) view.findViewById(R.id.join_labs_button) : null;
            Intrinsics.checkNotNull(button, "null cannot be cast to non-null type android.widget.Button");
            return button;
        }
    });
    private final Lazy labsLeaveButton$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$labsLeaveButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Button invoke() {
            View view = LabsFragment.this.getView();
            Button button = view != null ? (Button) view.findViewById(R.id.leave_labs_button) : null;
            Intrinsics.checkNotNull(button, "null cannot be cast to non-null type android.widget.Button");
            return button;
        }
    });
    private final Lazy featuresAvailableLayout$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$featuresAvailableLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LinearLayout invoke() {
            View view = LabsFragment.this.getView();
            LinearLayout linearLayout = view != null ? (LinearLayout) view.findViewById(R.id.labs_currently_features_available) : null;
            Intrinsics.checkNotNull(linearLayout, "null cannot be cast to non-null type android.widget.LinearLayout");
            return linearLayout;
        }
    });
    private final Lazy labsScrollView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ScrollView>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$labsScrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ScrollView invoke() {
            View view = LabsFragment.this.getView();
            ScrollView scrollView = view != null ? (ScrollView) view.findViewById(R.id.labs_scrollView) : null;
            Intrinsics.checkNotNull(scrollView, "null cannot be cast to non-null type android.widget.ScrollView");
            return scrollView;
        }
    });
    private final Lazy lottieView$delegate = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$lottieView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LottieAnimationView invoke() {
            View view = LabsFragment.this.getView();
            LottieAnimationView lottieAnimationView = view != null ? (LottieAnimationView) view.findViewById(R.id.lottie_animation_view) : null;
            Intrinsics.checkNotNull(lottieAnimationView, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            return lottieAnimationView;
        }
    });

    /* compiled from: LabsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LabsFragment newInstance() {
            return new LabsFragment();
        }

        private Companion() {
        }
    }

    private final int getAsVisibility(boolean z) {
        if (z) {
            return 0;
        }
        return 8;
    }

    private final LinearLayout getFeaturesAvailableLayout() {
        return (LinearLayout) this.featuresAvailableLayout$delegate.getValue();
    }

    private final TextView getLabsDescriptionText() {
        return (TextView) this.labsDescriptionText$delegate.getValue();
    }

    private final Button getLabsJoinButton() {
        return (Button) this.labsJoinButton$delegate.getValue();
    }

    private final Button getLabsLeaveButton() {
        return (Button) this.labsLeaveButton$delegate.getValue();
    }

    private final ScrollView getLabsScrollView() {
        return (ScrollView) this.labsScrollView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.lottieView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(LabsFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.isBlockedScrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(LabsFragment this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        ProviderFactory.getLabsProvider().setJoinedLabs(false);
        this$0.updatedDescriptionAndButtons(view);
        this$0.getMainController().goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(LabsFragment this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        ProviderFactory.getLabsProvider().setJoinedLabs(true);
        this$0.updatedDescriptionAndButtons(view);
        LabsWelcomeDialogFragment.newInstance().show(this$0.getChildFragmentManager(), (String) null);
    }

    private final void showAvailableFeatures(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        BehaviourFactory behaviourFactory = ProviderFactory.getBehaviourFactory();
        Watch watch = ProviderFactory.getWatch().getWatch();
        Behaviour behaviour = behaviourFactory.getBehaviour(Dice.TYPE);
        boolean z4 = false;
        if (behaviour != null) {
            z = behaviour.isSelectable(watch);
        } else {
            z = false;
        }
        Behaviour behaviour2 = behaviourFactory.getBehaviour(StopTime.TYPE);
        if (behaviour2 != null) {
            z2 = behaviour2.isSelectable(watch);
        } else {
            z2 = false;
        }
        String TYPE = PhoneBattery.TYPE;
        Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
        Behaviour behaviour3 = behaviourFactory.getBehaviour(TYPE);
        if (behaviour3 != null) {
            z3 = behaviour3.isSelectable(watch);
        } else {
            z3 = false;
        }
        boolean hasDisconnectAlert = ProviderFactory.getWatch().getCapabilities().hasDisconnectAlert();
        if (z || z2 || z3) {
            z4 = true;
        }
        view.findViewById(R.id.labs_currently_watch_face).setVisibility(getAsVisibility(z4));
        view.findViewById(R.id.labs_currently_feature_dice).setVisibility(getAsVisibility(z));
        view.findViewById(R.id.labs_currently_feature_stop_time).setVisibility(getAsVisibility(z2));
        view.findViewById(R.id.labs_currently_feature_phone_battery).setVisibility(getAsVisibility(z3));
        view.findViewById(R.id.labs_currently_out_of_range).setVisibility(getAsVisibility(hasDisconnectAlert));
    }

    private final void updatedDescriptionAndButtons(View view) {
        boolean hasJoinedLabs = ProviderFactory.getLabsProvider().hasJoinedLabs();
        getLabsLeaveButton().setVisibility(getAsVisibility(hasJoinedLabs));
        getLabsJoinButton().setVisibility(getAsVisibility(!hasJoinedLabs));
        getFeaturesAvailableLayout().setVisibility(getAsVisibility(hasJoinedLabs));
        getLabsScrollView().setVerticalScrollBarEnabled(hasJoinedLabs);
        this.isBlockedScrollView = !hasJoinedLabs;
        if (hasJoinedLabs) {
            getLabsDescriptionText().setText(R.string.labs_description_text_leave);
            showAvailableFeatures(view);
        } else {
            getLabsDescriptionText().setText(R.string.labs_description_text_join);
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return LabsProvider.LABS_FEEDBACK_NAME;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_labs, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getLabsScrollView().setOnTouchListener(new View.OnTouchListener() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onViewCreated$lambda$0;
                onViewCreated$lambda$0 = LabsFragment.onViewCreated$lambda$0(LabsFragment.this, view2, motionEvent);
                return onViewCreated$lambda$0;
            }
        });
        getLabsLeaveButton().setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabsFragment.onViewCreated$lambda$1(LabsFragment.this, view, view2);
            }
        });
        getLabsJoinButton().setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.labs.LabsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LabsFragment.onViewCreated$lambda$2(LabsFragment.this, view, view2);
            }
        });
        updatedDescriptionAndButtons(view);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new LabsFragment$onViewCreated$4(this, null), 3);
    }
}
