package com.animaconnected.secondo.behaviour.timer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage;
import com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.timer.Timer;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TimerFragment extends BaseDetailsFragment {
    public static TimerFragment newInstance(Slot slot) {
        TimerFragment timerFragment = new TimerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("slot", slot);
        bundle.putString("type", Timer.TYPE);
        timerFragment.setArguments(bundle);
        return timerFragment;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_details_timer, viewGroup, false);
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getHasQuickAction()) {
            view.findViewById(R.id.lottie_animation_pager).setVisibility(8);
            view.findViewById(R.id.timer_overview_section).setVisibility(8);
            return;
        }
        boolean hasIncreaseDecreaseTimer = ProviderFactory.getWatch().getCapabilities().hasIncreaseDecreaseTimer();
        ArrayList arrayList = new ArrayList();
        arrayList.add(DetailLottiePage.newInstance(LottieFile.DvTimer1, R.string.timer_animation_title_setting_timer));
        if (hasIncreaseDecreaseTimer) {
            arrayList.add(DetailLottiePage.newInstance(LottieFile.DvTimer2, R.string.timer_animation_title_adjusting_timer));
        } else {
            view.findViewById(R.id.trigger_layout_adjusting).setVisibility(8);
        }
        MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
        miniOnboardingPagerAdapter.setData(arrayList);
        ((DetailLottieViewPager) view.findViewById(R.id.lottie_animation_pager)).setAdapter(miniOnboardingPagerAdapter);
    }
}
