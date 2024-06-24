package com.animaconnected.secondo.screens.complications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingAnimatedPageFragment;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment;
import com.animaconnected.watch.device.Capabilities;
import com.animaconnected.watch.device.Scale;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ComplicationsMiniOnboardingDialogFragment extends MiniOnboardingBaseDialogFragment {
    public static ComplicationsMiniOnboardingDialogFragment newInstance() {
        return new ComplicationsMiniOnboardingDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment, com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment
    public List<Fragment> getPagerData() {
        ArrayList arrayList = new ArrayList();
        Context requireContext = requireContext();
        LottieFile lottieFile = LottieFile.OnboardingCrown;
        Lottie.loadAnimation(requireContext, lottieFile);
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.complications_onboarding_title_1, R.string.complications_onboarding_description_1, lottieFile));
        Capabilities capabilities = ProviderFactory.getWatch().getCapabilities();
        if (capabilities.hasScaleOnSubdials(Scale.ZeroToTwelve)) {
            Context requireContext2 = requireContext();
            LottieFile lottieFile2 = LottieFile.OnboardingSubdial;
            Lottie.loadAnimation(requireContext2, lottieFile2);
            arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.complications_onboarding_title_2, R.string.complications_onboarding_description_2, lottieFile2));
        } else if (capabilities.hasScaleOnSubdials(Scale.ZeroToTwentyFour)) {
            Context requireContext3 = requireContext();
            LottieFile lottieFile3 = LottieFile.OnboardingSubdial2;
            Lottie.loadAnimation(requireContext3, lottieFile3);
            arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.complications_onboarding_title_2, R.string.complications_onboarding_description_2, lottieFile3));
        }
        Context requireContext4 = requireContext();
        LottieFile lottieFile4 = LottieFile.OnboardingDetailviewComp;
        Lottie.loadAnimation(requireContext4, lottieFile4);
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.complications_onboarding_title_3, R.string.complications_onboarding_description_3, lottieFile4));
        return arrayList;
    }
}
