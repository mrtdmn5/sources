package com.animaconnected.secondo.screens.calibration;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.ViewPager;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.CalibrationProgress;
import com.animaconnected.secondo.screens.calibration.CalibrationAbortedDialogFragment;
import com.animaconnected.secondo.screens.calibration.CalibrationPresenter;
import com.animaconnected.secondo.widget.CirclePageIndicator;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalibrationFragment.kt */
/* loaded from: classes3.dex */
public final class CalibrationFragment extends BaseFragment implements CalibrationPresenter.CalibrationView, CalibrationAbortedDialogFragment.CalibrationAbortedDialogParent {
    private static final String HAS_ONBOARDING_STYLE_ID = "hasOnboardingStyleId";
    private CalibrationAbortedDialogFragment abortDialog;
    private CalibrationProgress calibrationProgressActivity;
    private CalibrationWheelView calibrationWheelView;
    private boolean hasOnboardingStyle;
    private final String name = "Calibration";
    private CalibrationPagerAdapter pagerAdapter;
    private CalibrationPresenter presenter;
    private FrameLayout progressFrame;
    private ViewPager viewPager;
    private int viewPagerIndex;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CalibrationFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CalibrationFragment newInstance(boolean z) {
            CalibrationFragment calibrationFragment = new CalibrationFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(CalibrationFragment.HAS_ONBOARDING_STYLE_ID, z);
            calibrationFragment.setArguments(bundle);
            return calibrationFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$8$lambda$2$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$4(Button button, CalibrationFragment this$0, Button button2, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        button.setText(this$0.getString(R.string.calibration_button_next));
        int r0 = this$0.viewPagerIndex;
        if (r0 >= 1) {
            int r02 = r0 - 1;
            this$0.viewPagerIndex = r02;
            ViewPager viewPager = this$0.viewPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(r02);
                if (this$0.viewPagerIndex == 0) {
                    button2.setVisibility(8);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$8$lambda$6$lambda$5(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8$lambda$7(CalibrationFragment this$0, int r2, Button button, Button button2, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.viewPagerIndex < r2) {
            button.setVisibility(0);
            int r3 = this$0.viewPagerIndex + 1;
            this$0.viewPagerIndex = r3;
            ViewPager viewPager = this$0.viewPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(r3);
                if (this$0.viewPagerIndex == r2) {
                    button2.setText(this$0.getString(R.string.calibration_button_done));
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            throw null;
        }
        CalibrationProgress calibrationProgress = this$0.calibrationProgressActivity;
        if (calibrationProgress != null) {
            calibrationProgress.calibrationFinished();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("calibrationProgressActivity");
            throw null;
        }
    }

    private final void popCalibrationAbortedDialog() {
        CalibrationAbortedDialogFragment newInstance = CalibrationAbortedDialogFragment.newInstance();
        this.abortDialog = newInstance;
        if (newInstance != null) {
            newInstance.show(getChildFragmentManager(), (String) null);
        }
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationPresenter.CalibrationView
    public void deviceTimeout() {
        popCalibrationAbortedDialog();
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationPresenter.CalibrationView
    public void displayProgress(boolean z) {
        if (z) {
            FrameLayout frameLayout = this.progressFrame;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                CalibrationWheelView calibrationWheelView = this.calibrationWheelView;
                if (calibrationWheelView != null) {
                    calibrationWheelView.startHintAnimation();
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("calibrationWheelView");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("progressFrame");
            throw null;
        }
        FrameLayout frameLayout2 = this.progressFrame;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("progressFrame");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationAbortedDialogFragment.CalibrationAbortedDialogParent
    public void onCalibrationAbortedDialogCanceled() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hasOnboardingStyle = arguments.getBoolean(HAS_ONBOARDING_STYLE_ID);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.presenter = new CalibrationPresenter(requireContext, this, this.hasOnboardingStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        int r11;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.hasOnboardingStyle) {
            r11 = R.layout.fragment_calibration_onboarding;
        } else {
            r11 = R.layout.fragment_calibration_settings;
        }
        View inflate = inflater.inflate(r11, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.calibration_pager);
        ((ViewPager) findViewById).setOnTouchListener(new CalibrationFragment$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.viewPager = (ViewPager) findViewById;
        this.pagerAdapter = new CalibrationPagerAdapter(getChildFragmentManager());
        CalibrationPresenter calibrationPresenter = this.presenter;
        if (calibrationPresenter != null) {
            calibrationPresenter.onUIReady();
            ViewPager viewPager = this.viewPager;
            if (viewPager != null) {
                int currentItem = viewPager.getCurrentItem();
                this.viewPagerIndex = currentItem;
                CalibrationPagerAdapter calibrationPagerAdapter = this.pagerAdapter;
                if (calibrationPagerAdapter != null) {
                    CalibrationPageFragment item = calibrationPagerAdapter.getItem(currentItem);
                    Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
                    CalibrationPresenter calibrationPresenter2 = this.presenter;
                    if (calibrationPresenter2 != null) {
                        calibrationPresenter2.setWatchFaceAndHand(item.getWatchFace(), item.getHand(), item.getSpeedMultiplier());
                        if (getActivity() instanceof CalibrationProgress) {
                            KeyEventDispatcher.Component activity = getActivity();
                            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.animaconnected.secondo.screens.CalibrationProgress");
                            CalibrationProgress calibrationProgress = (CalibrationProgress) activity;
                            this.calibrationProgressActivity = calibrationProgress;
                            calibrationProgress.calibrationPageSelected(this.viewPagerIndex);
                            View findViewById2 = inflate.findViewById(R.id.calibration_wheel);
                            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                            CalibrationWheelView calibrationWheelView = (CalibrationWheelView) findViewById2;
                            this.calibrationWheelView = calibrationWheelView;
                            CalibrationPresenter calibrationPresenter3 = this.presenter;
                            if (calibrationPresenter3 != null) {
                                calibrationWheelView.setWheelListener(calibrationPresenter3);
                                final Button button = (Button) inflate.findViewById(R.id.calibration_next_or_done_button);
                                final Button button2 = (Button) inflate.findViewById(R.id.calibration_previous_button);
                                button2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.calibration.CalibrationFragment$$ExternalSyntheticLambda1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        CalibrationFragment.onCreateView$lambda$8$lambda$4(button, this, button2, view);
                                    }
                                });
                                CirclePageIndicator circlePageIndicator = (CirclePageIndicator) inflate.findViewById(R.id.page_indicator);
                                ViewPager viewPager2 = this.viewPager;
                                if (viewPager2 != null) {
                                    circlePageIndicator.setViewPager(viewPager2);
                                    ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
                                    Context context = circlePageIndicator.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                                    circlePageIndicator.setHighlightColor(companion.getColor(context, R.attr.onboardingCalibrationPageIndicatorHighlightColor));
                                    Context context2 = circlePageIndicator.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                    circlePageIndicator.setBackgroundFillColor(companion.getColor(context2, R.attr.onboardingCalibrationPageIndicatorBackgroundFillColor));
                                    Context context3 = circlePageIndicator.getContext();
                                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                                    circlePageIndicator.setBackgroundStrokeColor(companion.getColor(context3, R.attr.onboardingCalibrationPageIndicatorBackgroundStrokeColor));
                                    circlePageIndicator.setOnTouchListener(new CalibrationFragment$$ExternalSyntheticLambda2());
                                    CalibrationPagerAdapter calibrationPagerAdapter2 = this.pagerAdapter;
                                    if (calibrationPagerAdapter2 != null) {
                                        final int count = calibrationPagerAdapter2.getCount() - 1;
                                        button.setText(getString(R.string.calibration_button_next));
                                        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.calibration.CalibrationFragment$$ExternalSyntheticLambda3
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                CalibrationFragment.onCreateView$lambda$8$lambda$7(CalibrationFragment.this, count, button2, button, view);
                                            }
                                        });
                                        View findViewById3 = inflate.findViewById(R.id.calibration_progress);
                                        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                                        this.progressFrame = (FrameLayout) findViewById3;
                                        return inflate;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                            throw null;
                        }
                        throw new IllegalArgumentException(("Containing Activity " + getActivity() + " needs to implement CalibrationFinished").toString());
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        CalibrationAbortedDialogFragment calibrationAbortedDialogFragment = this.abortDialog;
        if (calibrationAbortedDialogFragment != null) {
            calibrationAbortedDialogFragment.dismiss();
        }
        this.abortDialog = null;
        super.onPause();
        CalibrationWheelView calibrationWheelView = this.calibrationWheelView;
        if (calibrationWheelView != null) {
            calibrationWheelView.cancelHintAnimation();
            CalibrationPresenter calibrationPresenter = this.presenter;
            if (calibrationPresenter != null) {
                calibrationPresenter.onPause();
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("calibrationWheelView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CalibrationPresenter calibrationPresenter = this.presenter;
        if (calibrationPresenter != null) {
            calibrationPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.calibration.CalibrationPresenter.CalibrationView
    public void setPagerData(List<CalibrationPageFragment> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        CalibrationPagerAdapter calibrationPagerAdapter = this.pagerAdapter;
        if (calibrationPagerAdapter != null) {
            calibrationPagerAdapter.setData(pages);
            ViewPager viewPager = this.viewPager;
            if (viewPager != null) {
                CalibrationPagerAdapter calibrationPagerAdapter2 = this.pagerAdapter;
                if (calibrationPagerAdapter2 != null) {
                    viewPager.setAdapter(calibrationPagerAdapter2);
                    ViewPager viewPager2 = this.viewPager;
                    if (viewPager2 != null) {
                        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.animaconnected.secondo.screens.calibration.CalibrationFragment$setPagerData$1
                            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                            public void onPageSelected(int r5) {
                                CalibrationPagerAdapter calibrationPagerAdapter3;
                                int r1;
                                CalibrationPresenter calibrationPresenter;
                                CalibrationProgress calibrationProgress;
                                int r0;
                                calibrationPagerAdapter3 = CalibrationFragment.this.pagerAdapter;
                                if (calibrationPagerAdapter3 != null) {
                                    r1 = CalibrationFragment.this.viewPagerIndex;
                                    CalibrationPageFragment item = calibrationPagerAdapter3.getItem(r1);
                                    Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
                                    calibrationPresenter = CalibrationFragment.this.presenter;
                                    if (calibrationPresenter != null) {
                                        calibrationPresenter.setWatchFaceAndHand(item.getWatchFace(), item.getHand(), item.getSpeedMultiplier());
                                        calibrationProgress = CalibrationFragment.this.calibrationProgressActivity;
                                        if (calibrationProgress != null) {
                                            r0 = CalibrationFragment.this.viewPagerIndex;
                                            calibrationProgress.calibrationPageSelected(r0);
                                            return;
                                        } else {
                                            Intrinsics.throwUninitializedPropertyAccessException("calibrationProgressActivity");
                                            throw null;
                                        }
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                                throw null;
                            }

                            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                            public void onPageScrollStateChanged(int r1) {
                            }

                            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                            public void onPageScrolled(int r1, float f, int r3) {
                            }
                        });
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        throw null;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        throw null;
    }
}
