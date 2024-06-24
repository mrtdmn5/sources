package com.animaconnected.secondo.behaviour.music;

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
public class MusicFragment extends BaseAnimationDetailsFragment {
    public static BaseDetailsFragment newInstance(Slot slot, String str) {
        MusicFragment musicFragment = new MusicFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", str);
        musicFragment.setArguments(bundle);
        return musicFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_details_music, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.details.BaseAnimationDetailsFragment, com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!getHasQuickAction()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvMusicTop1, LottieFile.DvMusicBottom1), R.string.music_animation_title_pause_and_play));
            arrayList.add(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvMusicTop2, LottieFile.DvMusicBottom2), R.string.music_animation_title_skip_track));
            if (MusicProvider.shouldShowVolumeControlDescription()) {
                arrayList.add(DetailLottiePage.newInstance(selectAnimation(LottieFile.DvMusicTop3, LottieFile.DvMusicBottom3), R.string.music_animation_title_volume));
            } else {
                view.findViewById(R.id.trigger_layout_volume).setVisibility(8);
            }
            MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
            miniOnboardingPagerAdapter.setData(arrayList);
            this.lottieViewPager.setAdapter(miniOnboardingPagerAdapter);
        }
    }
}
