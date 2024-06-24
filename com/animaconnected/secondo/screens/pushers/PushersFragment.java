package com.animaconnected.secondo.screens.pushers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageProviderFactory;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class PushersFragment extends BehaviourConfigurationBaseFragment {
    public static PushersFragment newInstance() {
        return new PushersFragment();
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public DialogFragment createOnboardingDialog() {
        return PushersMiniOnboardingDialogFragment.newInstance();
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public float getAnimationTranslationAmount() {
        return 0.0f;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_pushers);
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Pushers";
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public boolean getOnboardingDone() {
        return MiniOnboardingStorage.getOnboardingDone(getContext(), MiniOnboardingConstants.PUSHERS_ONBOARDING_STORAGE);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public int getTab() {
        return 2;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean hasTabs() {
        return false;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle, false);
        setPresenter(new PushersPresenter(getContext(), this, getMainController(), PermissionCompat.create(this), ProviderFactory.getWatch()));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, WatchImageProviderFactory.createWatchImageProvider().getPushersDragAndDropTargetLayout());
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBaseFragment
    public void setOnboardingDone() {
        MiniOnboardingStorage.setOnboardingDone(getContext(), true, MiniOnboardingConstants.PUSHERS_ONBOARDING_STORAGE);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r4, int r5, int r6, int r7) {
        int width = ScreenLocationHelper.getScreenSize(requireContext()).getWidth();
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R.dimen.pushers_holes_offset_x_factor, typedValue, true);
        return new int[]{(int) (-((width - (getFillLayoutWidth() + r4)) * typedValue.getFloat())), getWatchYOffset(r7)};
    }
}
