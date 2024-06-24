package com.animaconnected.secondo.screens.details.lottieViewPager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingPagerAdapter;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class DetailLottieViewPager extends LinearLayout {
    private static final int PROGRESS_BAR_MAX_VALUE = 10000;
    private int mCurrentPage;
    private final ValueAnimator.AnimatorUpdateListener mListener;
    private final View mView;
    private final ViewPager mViewPager;

    public DetailLottieViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.detail_lottie_view_pager, this);
        this.mView = inflate;
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.animation_view_pager);
        this.mViewPager = viewPager;
        this.mCurrentPage = viewPager.getCurrentItem();
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.animation_progress_bar);
        progressBar.setMax(10000);
        this.mListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DetailLottieViewPager.lambda$new$0(progressBar, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(ProgressBar progressBar, ValueAnimator valueAnimator) {
        progressBar.setProgress((int) (valueAnimator.getAnimatedFraction() * 10000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setupPageIndicator$1(View view, MotionEvent motionEvent) {
        return true;
    }

    private void setupPageIndicator(boolean z) {
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) this.mView.findViewById(R.id.page_indicator);
        circlePageIndicator.setViewPager(this.mViewPager);
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.detailPagerColor, typedValue, true);
        Context context = getContext();
        int r3 = typedValue.resourceId;
        Object obj = ContextCompat.sLock;
        circlePageIndicator.setHighlightColor(ContextCompat.Api23Impl.getColor(context, r3));
        circlePageIndicator.setBackgroundStrokeColor(ContextCompat.Api23Impl.getColor(getContext(), typedValue.resourceId));
        circlePageIndicator.setOnTouchListener(new DetailLottieViewPager$$ExternalSyntheticLambda1());
        if (!z) {
            circlePageIndicator.setVisibility(8);
        }
    }

    public void setAdapter(final MiniOnboardingPagerAdapter miniOnboardingPagerAdapter) {
        this.mViewPager.setAdapter(miniOnboardingPagerAdapter);
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.animaconnected.secondo.screens.details.lottieViewPager.DetailLottieViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r3) {
                Fragment item = miniOnboardingPagerAdapter.getItem(DetailLottieViewPager.this.mCurrentPage);
                if (item != null) {
                    ((DetailLottiePage) item).stopAnimation();
                }
                DetailLottieViewPager.this.mCurrentPage = r3;
                ((DetailLottiePage) miniOnboardingPagerAdapter.getItem(DetailLottieViewPager.this.mCurrentPage)).startAnimation(DetailLottieViewPager.this.mListener);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int r1) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r1, float f, int r3) {
            }
        });
        ((DetailLottiePage) miniOnboardingPagerAdapter.getItem(this.mCurrentPage)).startAnimation(this.mListener);
        boolean z = true;
        if (miniOnboardingPagerAdapter.getCount() <= 1) {
            z = false;
        }
        setupPageIndicator(z);
    }
}
