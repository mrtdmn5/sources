package com.animaconnected.secondo.screens.pushers;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingAnimatedPageFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PushersMiniOnboardingDialogFragment extends MiniOnboardingBaseDialogFragment {
    public static PushersMiniOnboardingDialogFragment newInstance() {
        return new PushersMiniOnboardingDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment, com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment
    public List<Fragment> getPagerData() {
        ArrayList arrayList = new ArrayList();
        Context requireContext = requireContext();
        LottieFile lottieFile = LottieFile.OnboardingPlacePusher;
        LottieFile lottieFile2 = LottieFile.OnboardingTriggerPusher;
        LottieFile lottieFile3 = LottieFile.OnboardingDetailviewPush;
        Lottie.loadAnimation(requireContext, lottieFile, lottieFile2, lottieFile3);
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.pushers_onboarding_title_1, R.string.pushers_onboarding_description_1, lottieFile));
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.pushers_onboarding_title_2, R.string.pushers_onboarding_description_2, lottieFile2));
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.pushers_onboarding_title_3, R.string.pushers_onboarding_description_3, lottieFile3));
        return arrayList;
    }
}
