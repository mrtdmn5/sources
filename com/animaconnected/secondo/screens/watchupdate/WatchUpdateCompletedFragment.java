package com.animaconnected.secondo.screens.watchupdate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda8;
import com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.watchupdate.updateinfo.Update;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchUpdateCompletedFragment.kt */
/* loaded from: classes3.dex */
public final class WatchUpdateCompletedFragment extends BaseOnboardingFragment implements WatchViewLayouter {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String NAME = "watchUpdateCompleted";
    private final String name = NAME;
    private final String parentFragmentName = NAME;

    /* compiled from: WatchUpdateCompletedFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchUpdateCompletedFragment newInstance() {
            return new WatchUpdateCompletedFragment();
        }

        private Companion() {
        }
    }

    private final void addView(int r3, ViewGroup viewGroup) {
        viewGroup.addView(LayoutInflater.from(getContext()).inflate(r3, viewGroup, false));
    }

    public static final WatchUpdateCompletedFragment newInstance() {
        return Companion.newInstance();
    }

    public static final void onCreateView$lambda$1$lambda$0(WatchUpdateCompletedFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProviderFactory.getWatchUpdateProvider().clearUpdateInfo();
        if (this$0.isOnboarding()) {
            this$0.getOnboarding().setConnectedScreenDone();
        } else {
            this$0.getMainController().popUntilFragment(DashboardFragment.name);
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
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

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getParentFragmentName() {
        return this.parentFragmentName;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.UPDATE_COMPLETED) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_watch_update_completed, viewGroup, false);
        inflate.findViewById(R.id.update_done_button).setOnClickListener(new DeviceInfoFragment$$ExternalSyntheticLambda8(this, 1));
        return inflate;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showToolbarUpIndicator(false);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.change_log_view);
        List<Update> completedUpdates = ProviderFactory.getWatchUpdateProvider().getCompletedUpdates(ProviderFactory.getWatch().getFirmwareUpdate());
        if (completedUpdates.size() >= 2) {
            int updatesAsLayoutRes = completedUpdates.get(1).getUpdatesAsLayoutRes();
            Intrinsics.checkNotNull(viewGroup);
            addView(updatesAsLayoutRes, viewGroup);
            addView(completedUpdates.get(0).getUpdatesAsLayoutRes(), viewGroup);
            return;
        }
        if (completedUpdates.size() == 1) {
            int updatesAsLayoutRes2 = completedUpdates.get(0).getUpdatesAsLayoutRes();
            Intrinsics.checkNotNull(viewGroup);
            addView(updatesAsLayoutRes2, viewGroup);
        } else {
            int updatesAsLayoutRes3 = Update.Companion.getGENERAL_UPDATE().getUpdatesAsLayoutRes();
            Intrinsics.checkNotNull(viewGroup);
            addView(updatesAsLayoutRes3, viewGroup);
        }
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r1) {
    }
}
