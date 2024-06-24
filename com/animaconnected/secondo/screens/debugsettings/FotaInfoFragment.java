package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.device.DeviceFotaListener;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.FirmwareUpdate;
import com.kronaby.watch.app.R;
import java.util.List;

@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public class FotaInfoFragment extends BaseFragment implements DeviceFotaListener {
    private TextView mPagesCompletedText;
    private TextView mPagesText;
    private SwitchCompat mSlowModeSwitch;
    private WatchProvider mWatchProvider;

    public static FotaInfoFragment create() {
        return new FotaInfoFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(CompoundButton compoundButton, boolean z) {
        DebugStorage.setUpdateFotaFromCloud(getContext(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSlowModeSwitch$1(CompoundButton compoundButton, boolean z) {
        this.mWatchProvider.setFotaSlowMode(z);
    }

    private void updatePages(List<Byte> list) {
        StringBuilder sb = new StringBuilder();
        int r2 = 0;
        for (int r1 = 0; r1 < list.size(); r1++) {
            sb.append("Page: ");
            sb.append(r1);
            byte byteValue = list.get(r1).byteValue();
            if (byteValue != 0) {
                if (byteValue != 1) {
                    if (byteValue == 2) {
                        sb.append(" In progress\n");
                    }
                } else {
                    sb.append(" Completed\n");
                    r2++;
                }
            } else {
                sb.append(" Not started\n");
            }
        }
        this.mPagesText.setText(sb.toString());
        this.mPagesCompletedText.setText(r2 + " of " + list.size() + " pages completed");
    }

    private void updateSlowModeSwitch() {
        this.mSlowModeSwitch.setChecked(this.mWatchProvider.isFotaSlowModeEnabled());
        this.mSlowModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.debugsettings.FotaInfoFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FotaInfoFragment.this.lambda$updateSlowModeSwitch$1(compoundButton, z);
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_settings);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Fotainfo";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z = false;
        View inflate = layoutInflater.inflate(R.layout.fragment_debug_fota_info, viewGroup, false);
        this.mWatchProvider = ProviderFactory.getWatch();
        TextView textView = (TextView) inflate.findViewById(R.id.fota_supported_text);
        StringBuilder sb = new StringBuilder("FOTA supported by device: ");
        if (this.mWatchProvider.getFirmwareUpdate() == FirmwareUpdate.FOTA) {
            z = true;
        }
        sb.append(z);
        textView.setText(sb.toString());
        ((TextView) inflate.findViewById(R.id.fota_running_text)).setText("FOTA running: " + this.mWatchProvider.isRunningFota());
        ((TextView) inflate.findViewById(R.id.fota_started_from_debug)).setText("FOTA started from debug: " + ProviderFactory.getWatchFotaProvider().getFotaStartedFromDebug());
        this.mPagesCompletedText = (TextView) inflate.findViewById(R.id.fota_pages_completed);
        this.mPagesText = (TextView) inflate.findViewById(R.id.fota_pages);
        this.mSlowModeSwitch = (SwitchCompat) inflate.findViewById(R.id.fota_slow_switch);
        SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R.id.fota_cloud_switch);
        switchCompat.setChecked(DebugStorage.getUpdateFotaFromCloud(getContext()));
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.animaconnected.secondo.screens.debugsettings.FotaInfoFragment$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                FotaInfoFragment.this.lambda$onCreateView$0(compoundButton, z2);
            }
        });
        return inflate;
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onFotaProgress(List<Byte> list) {
        updatePages(list);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mWatchProvider.unregisterFotaListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mWatchProvider.registerFotaListener(this);
        List<Byte> lastPagesInfo = this.mWatchProvider.getLastPagesInfo();
        if (lastPagesInfo != null) {
            updatePages(lastPagesInfo);
        }
        updateSlowModeSwitch();
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onPerformFotaCompleted() {
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onReadyToPerformFota() {
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onFotaError(String str) {
    }

    @Override // com.animaconnected.bluetooth.device.DeviceFotaListener
    public void onPerformFotaError(byte b) {
    }
}
