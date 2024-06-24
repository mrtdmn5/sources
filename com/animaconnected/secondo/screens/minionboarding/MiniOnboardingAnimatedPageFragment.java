package com.animaconnected.secondo.screens.minionboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.lottie.Lottie;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class MiniOnboardingAnimatedPageFragment extends Fragment {
    protected static final String DESCRIPTION_RESOURCE_ID = "descriptionResourceId";
    protected static final String LOTTIE_FILE = "lottie-file";
    protected static final String TITLE_RESOURCE_ID = "titleResourceId";
    private LottieAnimationView mAnimationView;
    private int mDescriptionResourceID;
    private LottieFile mLottieFile;
    private ProgressBar mSetupProgressBar;
    private boolean mShouldStartAnimation;
    private int mTitleResourceID;

    public /* synthetic */ void lambda$onCreateView$0(LottieComposition lottieComposition) {
        this.mAnimationView.setComposition(lottieComposition);
        this.mSetupProgressBar.setVisibility(4);
        this.mAnimationView.setVisibility(0);
        if (this.mShouldStartAnimation) {
            this.mAnimationView.setRepeatCount(-1);
            this.mAnimationView.playAnimation();
        }
    }

    public static MiniOnboardingAnimatedPageFragment newInstance(int r3, int r4, LottieFile lottieFile) {
        MiniOnboardingAnimatedPageFragment miniOnboardingAnimatedPageFragment = new MiniOnboardingAnimatedPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TITLE_RESOURCE_ID, r3);
        bundle.putInt(DESCRIPTION_RESOURCE_ID, r4);
        bundle.putSerializable(LOTTIE_FILE, lottieFile);
        miniOnboardingAnimatedPageFragment.setArguments(bundle);
        return miniOnboardingAnimatedPageFragment;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mTitleResourceID = arguments.getInt(TITLE_RESOURCE_ID);
            this.mDescriptionResourceID = arguments.getInt(DESCRIPTION_RESOURCE_ID);
            this.mLottieFile = (LottieFile) arguments.getSerializable(LOTTIE_FILE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mini_onboarding_animated, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.mTitleResourceID);
        ((TextView) inflate.findViewById(R.id.description)).setText(this.mDescriptionResourceID);
        this.mAnimationView = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
        this.mSetupProgressBar = (ProgressBar) inflate.findViewById(R.id.loading_progressbar);
        Lottie.loadAnimation(requireContext(), this.mLottieFile).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.minionboarding.MiniOnboardingAnimatedPageFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                MiniOnboardingAnimatedPageFragment.this.lambda$onCreateView$0((LottieComposition) obj);
            }
        });
        return inflate;
    }

    public void startAnimation() {
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
            this.mAnimationView.playAnimation();
        } else {
            this.mShouldStartAnimation = true;
        }
    }

    public void stopAnimation() {
        this.mAnimationView.setRepeatCount(0);
        this.mAnimationView.cancelAnimation();
        this.mAnimationView.setProgress(0.0f);
    }
}
