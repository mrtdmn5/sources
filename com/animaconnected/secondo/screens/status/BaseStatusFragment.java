package com.animaconnected.secondo.screens.status;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.screens.MainController;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class BaseStatusFragment extends Fragment {
    private StatusModel mStatus;

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public MainController getMainController() {
        Object activity = getActivity();
        if (activity instanceof MainController) {
            return (MainController) activity;
        }
        throw new RuntimeException("Containing Activity " + activity + " needs to implement MainController");
    }

    public StatusModel getStatus() {
        return this.mStatus;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStatus = ProviderFactory.getStatusProvider().getCurrent();
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r2, boolean z, int r4) {
        Fragment parentFragment = getParentFragment();
        if (!z && parentFragment != null && parentFragment.isRemoving()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(getContext().getResources().getInteger(R.integer.screen_transition_duration_horizontal));
            return alphaAnimation;
        }
        return super.onCreateAnimation(r2, z, r4);
    }
}
