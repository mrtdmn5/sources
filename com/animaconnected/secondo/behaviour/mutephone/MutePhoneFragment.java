package com.animaconnected.secondo.behaviour.mutephone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.Slot;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MutePhoneFragment extends BaseAnimationDetailsFragment {
    public static BaseDetailsFragment newInstance(Slot slot) {
        MutePhoneFragment mutePhoneFragment = new MutePhoneFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", MutePhone.TYPE);
        mutePhoneFragment.setArguments(bundle);
        return mutePhoneFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_details_mute_phone, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!getHasQuickAction()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvMutephoneTop, LottieFile.DvMutephoneBottom), R.string.mute_phone_animation_description));
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(arrayList);
            this.lottieViewPager.setAdapter(miniOnboardingPagerAdapter);
        }
    }
}
