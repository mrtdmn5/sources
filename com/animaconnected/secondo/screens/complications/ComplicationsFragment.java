package com.animaconnected.secondo.screens.complications;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment;
import com.animaconnected.secondo.screens.complications.ComplicationsPresenter;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProviderFactory;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.device.Capabilities;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: ComplicationsFragment.kt */
/* loaded from: classes3.dex */
public final class ComplicationsFragment extends BehaviourConfigurationBaseFragment implements ComplicationsPresenter.ComplicationsView {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
    private final Behaviours behaviours = ProviderFactory.getWatch().getWatchManager().getBehaviours();

    /* compiled from: ComplicationsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ComplicationsFragment newInstance() {
            return new ComplicationsFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateDoubleCrownLine() {
        View dropTargetsDoubleCrownLine = getDropTargetsDoubleCrownLine();
        if (dropTargetsDoubleCrownLine == null) {
            return;
        }
        dropTargetsDoubleCrownLine.setAlpha(0.0f);
        dropTargetsDoubleCrownLine.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(dropTargetsDoubleCrownLine, "alpha", 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(getResources().getInteger(R.integer.double_crown_fade));
        ofFloat.setStartDelay(getResources().getInteger(R.integer.double_crown_delay) + getResources().getInteger(R.integer.screen_transition_duration_horizontal));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateDoubleCrownTarget() {
        if (getDragAndDropTarget().getDropTargetsExtraViewLayout() != null) {
            getDragAndDropTarget().getDropTargetsExtraViewLayout().setAlpha(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getDragAndDropTarget().getDropTargetsExtraViewLayout(), "alpha", 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(getResources().getInteger(R.integer.double_crown_fade));
            ofFloat.setStartDelay(getResources().getInteger(R.integer.double_crown_delay) + getResources().getInteger(R.integer.screen_transition_duration_horizontal));
            ofFloat.start();
            getDragAndDropTarget().getDropTargetsExtraViewLayout().setVisibility(0);
        }
    }

    public static final ComplicationsFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public DialogFragment createOnboardingDialog() {
        ComplicationsMiniOnboardingDialogFragment newInstance = ComplicationsMiniOnboardingDialogFragment.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public float getAnimationTranslationAmount() {
        float f;
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.complications_no_sub_complication_holes_offset_x_factor, typedValue, true);
        float f2 = typedValue.getFloat();
        if (this.capabilities.hasOneSubComplication()) {
            getResources().getValue(R.dimen.complications_sub_complication_holes_offset_x_factor, typedValue, true);
            f = typedValue.getFloat();
        } else {
            f = 0.0f;
        }
        return f2 + f;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.complications.ComplicationsPresenter.ComplicationsView
    public int getDragAndDropProviderAdapterType() {
        return getTab();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_complications);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Complications";
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public boolean getOnboardingDone() {
        return MiniOnboardingStorage.getOnboardingDone(getContext(), MiniOnboardingConstants.COMPLICATIONS_ONBOARDING_STORAGE);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public int getTab() {
        return getDragAndDrop().getAdapterType();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        TypedValue typedValue = new TypedValue();
        if (!this.capabilities.hasSubComplications()) {
            getResources().getValue(R.dimen.complications_no_sub_complication_holes_offset_x_factor, typedValue, true);
        } else {
            getResources().getValue(R.dimen.complications_no_sub_complication_holes_offset_x_factor, typedValue, true);
        }
        return new int[]{(int) ((-getFillLayoutWidth()) * typedValue.getFloat()), getWatchYOffset(r5)};
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean hasTabs() {
        if (getDragAndDrop().getAdapterType() == 0 || getDragAndDrop().getAdapterType() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle, this.capabilities.hasSubComplications());
        setPresenter(new ComplicationsPresenter(getContext(), this, PermissionCompat.create(this), ProviderFactory.getWatch(), getUseTabbed()));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return super.onCreateView(inflater, viewGroup, WatchImageProviderFactory.createWatchImageProvider().getComplicationsDragAndDropTargetLayout());
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ComplicationsFragment$onViewCreated$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public void setOnboardingDone() {
        MiniOnboardingStorage.setOnboardingDone(getContext(), true, MiniOnboardingConstants.COMPLICATIONS_ONBOARDING_STORAGE);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r3, int r4, int r5, int r6, int r7) {
        float f;
        TypedValue typedValue = new TypedValue();
        int[] r42 = new int[2];
        if (r7 == 0) {
            getResources().getValue(R.dimen.complications_no_sub_complication_holes_offset_x_factor, typedValue, true);
            r42[0] = (int) ((-getFillLayoutWidth()) * typedValue.getFloat());
            r42[1] = getWatchYOffset(r6);
        } else if (r7 == 1) {
            if (this.capabilities.hasTwoSubComplications()) {
                f = 0.0f;
            } else {
                getResources().getValue(R.dimen.complications_sub_complication_holes_offset_x_factor, typedValue, true);
                f = -typedValue.getFloat();
            }
            r42[0] = (int) ((-getFillLayoutWidth()) * f);
            r42[1] = getWatchYOffset(r6);
        }
        return r42;
    }
}
