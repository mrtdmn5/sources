package com.animaconnected.secondo.screens.details.lottieViewPager;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
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
public class DetailLottiePage extends Fragment {
    private static final String LOTTIE_FILE = "lottie-file";
    private static final String TITLE_RESOURCE_KEY = "title-resource-id";
    private ValueAnimator.AnimatorUpdateListener mAnimationListener;
    private LottieAnimationView mAnimationView;
    private LottieFile mLottieFile;
    private ProgressBar mSetupProgressBar;
    private boolean mShouldStartAnimation;
    private int mTitleResouceId;

    public void lambda$onCreateView$0(LottieComposition lottieComposition) {
        this.mAnimationView.setComposition(lottieComposition);
        this.mSetupProgressBar.setVisibility(4);
        this.mAnimationView.setVisibility(0);
        if (this.mShouldStartAnimation) {
            this.mShouldStartAnimation = false;
            this.mAnimationView.setRepeatCount(-1);
            this.mAnimationView.playAnimation();
            LottieAnimationView lottieAnimationView = this.mAnimationView;
            lottieAnimationView.lottieDrawable.animator.addUpdateListener(this.mAnimationListener);
        }
    }

    public static DetailLottiePage newInstance(LottieFile lottieFile, int r3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(LOTTIE_FILE, lottieFile);
        bundle.putInt(TITLE_RESOURCE_KEY, r3);
        DetailLottiePage detailLottiePage = new DetailLottiePage();
        detailLottiePage.setArguments(bundle);
        return detailLottiePage;
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
            this.mLottieFile = (LottieFile) arguments.getSerializable(LOTTIE_FILE);
            this.mTitleResouceId = arguments.getInt(TITLE_RESOURCE_KEY);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int r2, boolean z, int r4) {
        Fragment fragment;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            fragment = parentFragment.getParentFragment();
        } else {
            fragment = null;
        }
        if (!z && fragment != null && fragment.isRemoving()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation.setDuration(getContext().getResources().getInteger(R.integer.screen_transition_duration_horizontal));
            return alphaAnimation;
        }
        return super.onCreateAnimation(r2, z, r4);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.detail_lottie_page, viewGroup, false);
        this.mAnimationView = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
        this.mSetupProgressBar = (ProgressBar) inflate.findViewById(R.id.loading_progressbar);
        ((TextView) inflate.findViewById(R.id.animation_title)).setText(this.mTitleResouceId);
        Lottie.loadAnimation(requireContext(), this.mLottieFile).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottiePage$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DetailLottiePage.this.lambda$onCreateView$0((LottieComposition) obj);
            }
        });
        return inflate;
    }

    public void startAnimation(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mAnimationListener = animatorUpdateListener;
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
            this.mAnimationView.playAnimation();
            LottieAnimationView lottieAnimationView2 = this.mAnimationView;
            lottieAnimationView2.lottieDrawable.animator.addUpdateListener(this.mAnimationListener);
            return;
        }
        this.mShouldStartAnimation = true;
    }

    public void stopAnimation() {
        LottieAnimationView lottieAnimationView = this.mAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(0);
            this.mAnimationView.cancelAnimation();
            this.mAnimationView.setProgress(0.0f);
            LottieAnimationView lottieAnimationView2 = this.mAnimationView;
            lottieAnimationView2.lottieDrawable.animator.removeUpdateListener(this.mAnimationListener);
        }
    }
}
