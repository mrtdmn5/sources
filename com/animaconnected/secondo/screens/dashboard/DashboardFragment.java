package com.animaconnected.secondo.screens.dashboard;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.databinding.FragmentDashboardBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.activity.ActivityFragment;
import com.animaconnected.secondo.screens.activity.ActivitySetupFragment;
import com.animaconnected.secondo.screens.dashboard.DashboardPresenter;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.watch.display.DpUtilsKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardFragment.kt */
/* loaded from: classes3.dex */
public final class DashboardFragment extends BaseFragment implements DashboardPresenter.DashboardView, WatchViewLayouter {
    public static final String name = "Dashboard";
    private FragmentDashboardBinding binding;
    private DashboardPresenter presenter;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(0, 1, null);
    private final String name$1 = name;

    /* compiled from: DashboardFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DashboardFragment newInstance() {
            return new DashboardFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateDashboardRevealAnimation$lambda$2$lambda$1(DashboardFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        FragmentDashboardBinding fragmentDashboardBinding = this$0.binding;
        if (fragmentDashboardBinding != null) {
            LinearLayout root = fragmentDashboardBinding.getRoot();
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            root.setPadding(0, ((Integer) animatedValue).intValue(), 0, 0);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    private final BaseFragment getFirstActivityFragment() {
        if (ProviderFactory.getSettingProvider().getActivityOnboardingCompleted()) {
            return ActivityFragment.Companion.newInstance(false, name);
        }
        return ActivitySetupFragment.Companion.newInstance(false, name);
    }

    public static final DashboardFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    public final void animateDashboardRevealAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.dashboard_animation);
        int dpInt = DpUtilsKt.toDpInt(24.0f);
        FragmentDashboardBinding fragmentDashboardBinding = this.binding;
        if (fragmentDashboardBinding != null) {
            fragmentDashboardBinding.getRoot().setPadding(0, dpInt, 0, 0);
            int[] r1 = new int[2];
            FragmentDashboardBinding fragmentDashboardBinding2 = this.binding;
            if (fragmentDashboardBinding2 != null) {
                r1[0] = fragmentDashboardBinding2.getRoot().getPaddingTop();
                r1[1] = 0;
                ValueAnimator ofInt = ValueAnimator.ofInt(r1);
                ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.screens.dashboard.DashboardFragment$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DashboardFragment.animateDashboardRevealAnimation$lambda$2$lambda$1(DashboardFragment.this, valueAnimator);
                    }
                });
                ofInt.setStartDelay(3760L);
                ofInt.setDuration(470L);
                ofInt.start();
                FragmentDashboardBinding fragmentDashboardBinding3 = this.binding;
                if (fragmentDashboardBinding3 != null) {
                    fragmentDashboardBinding3.getRoot().startAnimation(loadAnimation);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.dashboard.DashboardPresenter.DashboardView
    public void enableApps(boolean z) {
        FragmentDashboardBinding fragmentDashboardBinding = this.binding;
        if (fragmentDashboardBinding != null) {
            if (z) {
                fragmentDashboardBinding.layoutApps.setVisibility(0);
                fragmentDashboardBinding.layoutWatchFace.setVisibility(8);
                fragmentDashboardBinding.layoutNotification.setVisibility(8);
                fragmentDashboardBinding.layoutPushers.setVisibility(8);
                fragmentDashboardBinding.btnActivity.setText(getString(R.string.health_top_title));
                return;
            }
            fragmentDashboardBinding.layoutApps.setVisibility(8);
            fragmentDashboardBinding.layoutWatchFace.setVisibility(0);
            fragmentDashboardBinding.layoutNotification.setVisibility(0);
            fragmentDashboardBinding.layoutPushers.setVisibility(0);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.dashboard.DashboardPresenter.DashboardView
    public void enableButtons(boolean z) {
        boolean z2;
        FragmentDashboardBinding fragmentDashboardBinding = this.binding;
        if (fragmentDashboardBinding != null) {
            fragmentDashboardBinding.btnPushers.setEnabled(z);
            fragmentDashboardBinding.btnApps.setEnabled(z);
            fragmentDashboardBinding.btnWatchFace.setEnabled(z);
            fragmentDashboardBinding.btnNotification.setEnabled(z);
            Button button = fragmentDashboardBinding.btnActivity;
            boolean z3 = true;
            if (!z) {
                DeviceType deviceType = ProviderFactory.getWatch().getDeviceType();
                if (deviceType != null && deviceType.getHasDisplay()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z3 = false;
                }
            }
            button.setEnabled(z3);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.dashboard.DashboardPresenter.DashboardView
    public void enableUpdateBadge(boolean z) {
        int r2;
        FragmentDashboardBinding fragmentDashboardBinding = this.binding;
        if (fragmentDashboardBinding != null) {
            ImageView imageView = fragmentDashboardBinding.updateAvailableBadge;
            if (z) {
                r2 = 0;
            } else {
                r2 = 4;
            }
            imageView.setVisibility(r2);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_watch);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name$1;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00db  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r5, android.view.ViewGroup r6, android.os.Bundle r7) {
        /*
            r4 = this;
            java.lang.String r7 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            r7 = 0
            com.animaconnected.secondo.databinding.FragmentDashboardBinding r5 = com.animaconnected.secondo.databinding.FragmentDashboardBinding.inflate(r5, r6, r7)
            java.lang.String r6 = "inflate(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r4.binding = r5
            android.content.Context r5 = r4.requireContext()
            com.animaconnected.secondo.provider.ThemeProviderBase$Companion r6 = com.animaconnected.secondo.provider.ThemeProviderBase.Companion
            android.content.Context r0 = r4.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2 = 2130968907(0x7f04014b, float:1.754648E38)
            int r6 = r6.getResourceId(r0, r2)
            java.lang.Object r0 = androidx.core.content.ContextCompat.sLock
            int r5 = androidx.core.content.ContextCompat.Api23Impl.getColor(r5, r6)
            android.content.Context r6 = r4.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            boolean r6 = com.animaconnected.secondo.screens.debugsettings.DebugStorage.getShowWorkoutSessions(r6)
            if (r6 != 0) goto L54
            com.animaconnected.watch.WatchProvider r6 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.info.DeviceType r6 = r6.getDeviceType()
            if (r6 == 0) goto L4c
            boolean r6 = r6.getHasDisplay()
            r0 = 1
            if (r6 != r0) goto L4c
            r7 = r0
        L4c:
            if (r7 == 0) goto L4f
            goto L54
        L4f:
            com.animaconnected.secondo.screens.BaseFragment r6 = r4.getFirstActivityFragment()
            goto L5a
        L54:
            com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment$Companion r6 = com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment.Companion
            com.animaconnected.secondo.screens.BaseFragment r6 = r6.newInstance()
        L5a:
            com.animaconnected.secondo.databinding.FragmentDashboardBinding r7 = r4.binding
            java.lang.String r0 = "binding"
            r1 = 0
            if (r7 == 0) goto Ldb
            android.widget.ImageView r2 = r7.quietHoursBadge
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.setColorFilter(r5, r3)
            android.widget.Button r5 = r7.btnWatchFace
            java.lang.String r2 = "btnWatchFace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$1 r2 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$1
            r2.<init>(r4, r1)
            r4.onClick(r5, r2)
            android.widget.Button r5 = r7.btnPushers
            java.lang.String r2 = "btnPushers"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$2 r2 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$2
            r2.<init>(r4, r1)
            r4.onClick(r5, r2)
            android.widget.Button r5 = r7.btnNotification
            java.lang.String r2 = "btnNotification"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$3 r2 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$3
            r2.<init>(r4, r1)
            r4.onClick(r5, r2)
            android.widget.Button r5 = r7.btnApps
            java.lang.String r2 = "btnApps"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$4 r2 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$4
            r2.<init>(r4, r1)
            r4.onClick(r5, r2)
            android.widget.Button r5 = r7.btnActivity
            java.lang.String r2 = "btnActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$5 r2 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$5
            r2.<init>(r4, r6, r1)
            r4.onClick(r5, r2)
            android.widget.Button r5 = r7.btnSettings
            java.lang.String r6 = "btnSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$6 r6 = new com.animaconnected.secondo.screens.dashboard.DashboardFragment$onCreateView$1$6
            r6.<init>(r4, r1)
            r4.onClick(r5, r6)
            com.animaconnected.secondo.screens.dashboard.DashboardPresenter r5 = new com.animaconnected.secondo.screens.dashboard.DashboardPresenter
            r5.<init>(r4)
            r4.presenter = r5
            com.animaconnected.secondo.databinding.FragmentDashboardBinding r5 = r4.binding
            if (r5 == 0) goto Ld7
            android.widget.LinearLayout r5 = r5.getRoot()
            java.lang.String r6 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        Ld7:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        Ldb:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.dashboard.DashboardFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        DashboardPresenter dashboardPresenter = this.presenter;
        if (dashboardPresenter != null) {
            dashboardPresenter.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DashboardPresenter dashboardPresenter = this.presenter;
        if (dashboardPresenter != null) {
            dashboardPresenter.onResume();
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DashboardPresenter dashboardPresenter = this.presenter;
        if (dashboardPresenter != null) {
            dashboardPresenter.onCreate();
        }
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.$$delegate_0.onWatchViewLayouted();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r2) {
        this.$$delegate_0.onWatchViewUpdated(r2);
    }

    @Override // com.animaconnected.secondo.screens.dashboard.DashboardPresenter.DashboardView
    public void updateQuietHoursBadge(boolean z) {
        int r2;
        FragmentDashboardBinding fragmentDashboardBinding = this.binding;
        if (fragmentDashboardBinding != null) {
            ImageView imageView = fragmentDashboardBinding.quietHoursBadge;
            if (z) {
                r2 = 0;
            } else {
                r2 = 4;
            }
            imageView.setVisibility(r2);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[]{0, getWatchYOffset(r4)};
    }
}
