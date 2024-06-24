package com.animaconnected.secondo.behaviour.rememberthisspot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.rememberthisspot.spots.SavedSpotsFragment;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.RememberThisSpot;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.provider.SpotsProvider;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class RememberThisSpotFragment extends BaseAnimationDetailsFragment implements SpotsProvider.SpotsProviderListener {
    private TextView mLastLocationText;
    private SpotsProvider spotsProvider;

    public /* synthetic */ void lambda$onCreateView$0(View view) {
        boolean z;
        MainController mainController = getMainController();
        if (this.slot != Slot.Unknown) {
            z = true;
        } else {
            z = false;
        }
        BaseFragment parentBaseFragment = getParentBaseFragment();
        Objects.requireNonNull(parentBaseFragment);
        mainController.gotoNextFragment(SavedSpotsFragment.newInstance(z, parentBaseFragment.getFeaturePathName()));
    }

    public static BaseDetailsFragment newInstance(Slot slot) {
        RememberThisSpotFragment rememberThisSpotFragment = new RememberThisSpotFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", RememberThisSpot.TYPE);
        rememberThisSpotFragment.setArguments(bundle);
        return rememberThisSpotFragment;
    }

    private void setupLastSpotText() {
        List<Spot> allSpots = this.spotsProvider.getAllSpots();
        if (allSpots.size() >= 1) {
            this.mLastLocationText.setText(allSpots.get(0).addressLine);
        } else {
            this.mLastLocationText.setText(R.string.remember_this_spot_details_no_last_spot);
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_remember_this_spot, viewGroup, false);
        this.mLastLocationText = (TextView) inflate.findViewById(R.id.last_spot);
        inflate.findViewById(R.id.last_spot_container).setOnClickListener(new RememberThisSpotFragment$$ExternalSyntheticLambda0(this, 0));
        this.spotsProvider = SpotsProvider.getInstance();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.spotsProvider.unregisterSpotsProviderListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.spotsProvider.registerSpotsProviderListener(this);
        setupLastSpotText();
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotAdded(int r1) {
        setupLastSpotText();
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!getHasQuickAction()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvRemspotTop, LottieFile.DvRemspotBottom), R.string.remember_this_spot_animation_description));
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(arrayList);
            this.lottieViewPager.setAdapter(miniOnboardingPagerAdapter);
        }
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotRemoved(int r1) {
    }

    @Override // com.animaconnected.watch.provider.SpotsProvider.SpotsProviderListener
    public void onSpotRenamed(int r1) {
    }
}
