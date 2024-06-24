package com.animaconnected.secondo.screens.watchupdate;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.update.DfuState;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.watch.device.DfuStatus;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchDfuUpdateFragment.kt */
/* loaded from: classes3.dex */
public final class WatchDfuUpdateFragment extends BaseWatchUpdateFragment implements WatchDfuUpdatePresenter.DfuWatchUpdateView {
    private final int layoutResourceId = R.layout.fragment_watch_dfu_update;
    private BroadcastReceiver locationChangedBroadcastReceiver;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private ProgressBar progressBar;
    private TextView progressStepText;
    private TextView progressText;
    private View runningUpdateLayout;
    private ProgressBar startUpdateButtonProgress;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WatchDfuUpdateFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WatchDfuUpdateFragment newInstance() {
            return new WatchDfuUpdateFragment();
        }

        private Companion() {
        }
    }

    public WatchDfuUpdateFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdateFragment$special$$inlined$registerMultiplePermissions$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                if ((entrySet instanceof Collection) && entrySet.isEmpty()) {
                    return;
                }
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext() && ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
    }

    public static final WatchDfuUpdateFragment newInstance() {
        return Companion.newInstance();
    }

    @SuppressLint({"SetTextI18n"})
    private final void setProgressStep(int r3, int r4) {
        TextView textView = this.progressStepText;
        if (textView != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(r3);
            sb.append('/');
            sb.append(r4);
            textView.setText(sb.toString());
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressStepText");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public CustomActivityResult<Intent, ActivityResult> activityLauncher() {
        return getActivityLauncher();
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment
    public int getLayoutResourceId() {
        return this.layoutResourceId;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Context context = onCreateView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setWatchUpdatePresenter(new WatchDfuUpdatePresenter(this, context, PermissionCompat.create(this)));
        View findViewById = onCreateView.findViewById(R.id.dfu_progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = onCreateView.findViewById(R.id.dfu_progress_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.progressText = (TextView) findViewById2;
        View findViewById3 = onCreateView.findViewById(R.id.dfu_progress_step);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.progressStepText = (TextView) findViewById3;
        View findViewById4 = onCreateView.findViewById(R.id.update_progress_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.runningUpdateLayout = findViewById4;
        View findViewById5 = onCreateView.findViewById(R.id.start_update_button_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.startUpdateButtonProgress = (ProgressBar) findViewById5;
        onClick(getStartUpdateButton(), new WatchDfuUpdateFragment$onCreateView$1$1(this, null));
        this.locationChangedBroadcastReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdateFragment$onCreateView$1$2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                WatchDfuUpdateFragment.this.getWatchUpdatePresenter().updateView();
            }
        };
        return onCreateView;
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Context context = getContext();
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.locationChangedBroadcastReceiver;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("locationChangedBroadcastReceiver");
                throw null;
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.locationChangedBroadcastReceiver;
            if (broadcastReceiver != null) {
                context.registerReceiver(broadcastReceiver, new IntentFilter("android.location.MODE_CHANGED"));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("locationChangedBroadcastReceiver");
                throw null;
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment, com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdatePresenter.WatchUpdateView
    public void onUpdateStarted() {
        if (isOnboarding()) {
            getOnboarding().onUpdateStarted();
        }
        View view = this.runningUpdateLayout;
        if (view != null) {
            view.setVisibility(0);
            super.onUpdateStarted();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("runningUpdateLayout");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void requestLocationPermission(String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissionLauncher.launch(permissions);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showDisconnectedDialog() {
        getPausedProgressBar().setVisibility(0);
        if (getCurrentDialog() == null || !(getCurrentDialog() instanceof DisconnectedDialogFragment)) {
            DisconnectedDialogFragment newInstance = DisconnectedDialogFragment.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            setPausedDialog(newInstance);
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showLoading() {
        Button startUpdateButton = getStartUpdateButton();
        startUpdateButton.setText("");
        startUpdateButton.setEnabled(false);
        ProgressBar progressBar = this.startUpdateButtonProgress;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("startUpdateButtonProgress");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showLocationDisabledWarning() {
        getStartUpdateButton().setText(R.string.button_label_turn_on_location);
        getStartUpdateButton().setEnabled(true);
        getStartUpdateWarningText().setText(R.string.location_services_not_available);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showLocationPermissionWarning() {
        getStartUpdateButton().setText(R.string.button_label_give_access);
        getStartUpdateButton().setEnabled(true);
        getStartUpdateWarningText().setText(R.string.location_permissions_is_missing);
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showRemoveBondBluetoothDialog() {
        if (getCurrentDialog() == null || !(getCurrentDialog() instanceof RemoveBondBluetoothDialogFragment)) {
            RemoveBondBluetoothDialogFragment newInstance = RemoveBondBluetoothDialogFragment.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            setPausedDialog(newInstance);
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showRemoveBondRestartPhoneFragment() {
        if (getCurrentDialog() == null || !(getCurrentDialog() instanceof RemoveBondBluetoothDialogFragment)) {
            MainController mainController = getMainController();
            RemoveBondRestartFragment newInstance = RemoveBondRestartFragment.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            mainController.gotoNextFragment(newInstance);
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void showStartDfuError(DfuStatus dfuStatus, boolean z) {
        int r3;
        Button startUpdateButton = getStartUpdateButton();
        startUpdateButton.setText(getString(R.string.button_label_retry));
        startUpdateButton.setEnabled(true);
        if (dfuStatus == DfuStatus.BatteryLow) {
            r3 = R.string.watch_update_error_battery_too_low;
        } else if (dfuStatus == DfuStatus.TooCold) {
            r3 = R.string.watch_update_error_too_cold;
        } else if (z) {
            r3 = R.string.watch_update_error_phone_battery_to_low;
        } else {
            r3 = R.string.watch_update_error_general;
        }
        getStartUpdateWarningText().setText(r3);
        ProgressBar progressBar = this.startUpdateButtonProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("startUpdateButtonProgress");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.watchupdate.WatchDfuUpdatePresenter.DfuWatchUpdateView
    public void updateDfuState(DfuState state) {
        boolean areEqual;
        boolean z;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DfuState.NotStarted) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(state, DfuState.Initiating.INSTANCE);
        }
        if (areEqual) {
            z = true;
        } else {
            z = state instanceof DfuState.Failed;
        }
        if (z) {
            TextView textView = this.progressText;
            if (textView != null) {
                textView.setText(R.string.watch_update_progress_preparing);
                ProgressBar progressBar = this.progressBar;
                if (progressBar != null) {
                    progressBar.setIndeterminate(true);
                    progressBar.setRotation(180.0f);
                    setProgressStep(1, 3);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("progressText");
            throw null;
        }
        if (state instanceof DfuState.Ongoing) {
            TextView textView2 = this.progressText;
            if (textView2 != null) {
                textView2.setText(R.string.watch_update_progress_running);
                ProgressBar progressBar2 = this.progressBar;
                if (progressBar2 != null) {
                    progressBar2.setIndeterminate(false);
                    progressBar2.setRotation(0.0f);
                    progressBar2.setProgress(((DfuState.Ongoing) state).getProgress());
                    setProgressStep(2, 3);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("progressText");
            throw null;
        }
        if (Intrinsics.areEqual(state, DfuState.Successful.INSTANCE)) {
            TextView textView3 = this.progressText;
            if (textView3 != null) {
                textView3.setText(R.string.watch_update_progress_finalising);
                ProgressBar progressBar3 = this.progressBar;
                if (progressBar3 != null) {
                    progressBar3.setIndeterminate(true);
                    progressBar3.setRotation(0.0f);
                    progressBar3.setProgress(100);
                    setProgressStep(3, 3);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("progressText");
            throw null;
        }
    }
}
