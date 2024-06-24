package com.animaconnected.secondo.screens.minionboarding;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.provider.analytics.AnalyticsTrackingProvider;
import com.animaconnected.secondo.screens.BottomDialog;
import com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MiniOnboardingBaseDialogFragment extends BottomSheetBaseDialogFragment {
    private MiniOnboardingPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private int mViewPagerIndex;

    private MiniOnboardingBaseDialogFragmentCallback getMiniOnboardingDialogFragmentCallback() {
        return (MiniOnboardingBaseDialogFragmentCallback) getParentFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        int r2 = this.mViewPagerIndex;
        if (r2 >= 1) {
            int r22 = r2 - 1;
            this.mViewPagerIndex = r22;
            this.mViewPager.setCurrentItem(r22);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onCreateView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(int r1, View view) {
        int r2 = this.mViewPagerIndex;
        if (r2 < r1) {
            int r22 = r2 + 1;
            this.mViewPagerIndex = r22;
            this.mViewPager.setCurrentItem(r22);
            return;
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation(int r2) {
        Fragment item = this.mPagerAdapter.getItem(r2);
        if (item instanceof MiniOnboardingAnimatedPageFragment) {
            ((MiniOnboardingAnimatedPageFragment) item).startAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTrackingPage(int r4) {
        AnalyticsTrackingProvider.getInstance().startTrackingFragment(getParentFragment().getClass().getSimpleName() + "-MiniPage" + r4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnimation(int r2) {
        Fragment item = this.mPagerAdapter.getItem(r2);
        if (item instanceof MiniOnboardingAnimatedPageFragment) {
            ((MiniOnboardingAnimatedPageFragment) item).stopAnimation();
        }
    }

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public abstract List<Fragment> getPagerData();

    @Override // com.animaconnected.secondo.screens.BottomSheetBaseDialogFragment
    public View onCreateDialogView(BottomDialog bottomDialog) {
        return View.inflate(getContext(), R.layout.mini_onboarding_dialog_fragment, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mini_onboarding_dialog_fragment, (ViewGroup) null, false);
        this.mViewPager = (ViewPager) inflate.findViewById(R.id.mini_onboarding_pager);
        MiniOnboardingPagerAdapter miniOnboardingPagerAdapter = new MiniOnboardingPagerAdapter(getChildFragmentManager());
        this.mPagerAdapter = miniOnboardingPagerAdapter;
        miniOnboardingPagerAdapter.setData(getPagerData());
        this.mViewPager.setAdapter(this.mPagerAdapter);
        int currentItem = this.mViewPager.getCurrentItem();
        this.mViewPagerIndex = currentItem;
        startTrackingPage(currentItem);
        startAnimation(this.mViewPagerIndex);
        final Button button = (Button) inflate.findViewById(R.id.mini_onboarding_next_or_done_button);
        final Button button2 = (Button) inflate.findViewById(R.id.mini_onboarding_previous_button);
        final int count = this.mPagerAdapter.getCount() - 1;
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int r3) {
                MiniOnboardingBaseDialogFragment miniOnboardingBaseDialogFragment = MiniOnboardingBaseDialogFragment.this;
                miniOnboardingBaseDialogFragment.stopAnimation(miniOnboardingBaseDialogFragment.mViewPagerIndex);
                MiniOnboardingBaseDialogFragment.this.mViewPagerIndex = r3;
                MiniOnboardingBaseDialogFragment miniOnboardingBaseDialogFragment2 = MiniOnboardingBaseDialogFragment.this;
                miniOnboardingBaseDialogFragment2.startTrackingPage(miniOnboardingBaseDialogFragment2.mViewPagerIndex);
                MiniOnboardingBaseDialogFragment miniOnboardingBaseDialogFragment3 = MiniOnboardingBaseDialogFragment.this;
                miniOnboardingBaseDialogFragment3.startAnimation(miniOnboardingBaseDialogFragment3.mViewPagerIndex);
                if (MiniOnboardingBaseDialogFragment.this.mViewPagerIndex == 0) {
                    button2.setVisibility(8);
                } else {
                    button2.setVisibility(0);
                }
                if (MiniOnboardingBaseDialogFragment.this.mViewPagerIndex == count) {
                    button.setText(MiniOnboardingBaseDialogFragment.this.getString(R.string.mini_onboarding_button_done));
                } else {
                    button.setText(MiniOnboardingBaseDialogFragment.this.getString(R.string.mini_onboarding_button_next));
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int r1) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int r1, float f, int r3) {
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniOnboardingBaseDialogFragment.this.lambda$onCreateView$0(view);
            }
        });
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) inflate.findViewById(R.id.page_indicator);
        circlePageIndicator.setViewPager(this.mViewPager);
        FragmentActivity activity = getActivity();
        Object obj = ContextCompat.sLock;
        circlePageIndicator.setHighlightColor(ContextCompat.Api23Impl.getColor(activity, R.color.black));
        circlePageIndicator.setBackgroundStrokeColor(ContextCompat.Api23Impl.getColor(getActivity(), R.color.black));
        circlePageIndicator.setOnTouchListener(new MiniOnboardingBaseDialogFragment$$ExternalSyntheticLambda1());
        button.setText(getString(R.string.mini_onboarding_button_next));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.minionboarding.MiniOnboardingBaseDialogFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniOnboardingBaseDialogFragment.this.lambda$onCreateView$2(count, view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        getMiniOnboardingDialogFragmentCallback().onboardingDone();
        AnalyticsTrackingProvider.getInstance().stopTrackingFragment();
        super.onDismiss(dialogInterface);
    }
}
