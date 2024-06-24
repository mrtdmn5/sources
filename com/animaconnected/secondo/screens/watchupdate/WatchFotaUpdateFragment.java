package com.animaconnected.secondo.screens.watchupdate;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchFotaUpdatePresenter;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchFotaUpdateFragment.kt */
/* loaded from: classes3.dex */
public final class WatchFotaUpdateFragment extends BaseWatchUpdateFragment implements WatchFotaUpdatePresenter.FotaWatchUpdateView {
    private final int layoutResourceId = R.layout.fragment_watch_fota_update;
    private TextView progressText;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchFotaUpdateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchFotaUpdateFragment newInstance() {
            return new WatchFotaUpdateFragment();
        }

        private Companion() {
        }
    }

    public static final WatchFotaUpdateFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment
    public int getLayoutResourceId() {
        return this.layoutResourceId;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchFotaUpdatePresenter.FotaWatchUpdateView
    public void goBackToDashboard() {
        getMainController().popUntilFragment(DashboardFragment.name);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Context context = onCreateView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setWatchUpdatePresenter(new WatchFotaUpdatePresenter(this, context));
        View findViewById = onCreateView.findViewById(R.id.fota_progress_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressText = (TextView) findViewById;
        onClick(getStartUpdateButton(), new WatchFotaUpdateFragment$onCreateView$1$1(this, null));
        return onCreateView;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchFotaUpdatePresenter.FotaWatchUpdateView
    public void onStarted() {
        if (isOnboarding()) {
            getOnboarding().onUpdateStarted();
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void onUpdateStarted() {
        TextView textView = this.progressText;
        if (textView != null) {
            textView.setVisibility(0);
            super.onUpdateStarted();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("progressText");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchFotaUpdatePresenter.FotaWatchUpdateView
    public void showUpdateFailedDialog(String str) {
        if (getCurrentDialog() == null || !(getCurrentDialog() instanceof UpdateFailedDialogFragment)) {
            UpdateFailedDialogFragment newInstance = UpdateFailedDialogFragment.newInstance(str);
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            setPausedDialog(newInstance);
        }
    }
}
