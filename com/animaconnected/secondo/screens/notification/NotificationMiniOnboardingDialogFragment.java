package com.animaconnected.secondo.screens.notification;

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
public class NotificationMiniOnboardingDialogFragment extends MiniOnboardingBaseDialogFragment {
    public static NotificationMiniOnboardingDialogFragment newInstance() {
        return new NotificationMiniOnboardingDialogFragment();
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment, com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment
    public List<Fragment> getPagerData() {
        ArrayList arrayList = new ArrayList();
        Context requireContext = requireContext();
        LottieFile lottieFile = LottieFile.OnboardingNotifications;
        LottieFile lottieFile2 = LottieFile.OnboardingDetailviewNote;
        Lottie.loadAnimation(requireContext, lottieFile, lottieFile2);
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.notification_onboarding_title_1, R.string.notification_onboarding_description_1, lottieFile));
        arrayList.add(MiniOnboardingAnimatedPageFragment.newInstance(R.string.notification_onboarding_title_2, R.string.notification_onboarding_description_2, lottieFile2));
        return arrayList;
    }
}
