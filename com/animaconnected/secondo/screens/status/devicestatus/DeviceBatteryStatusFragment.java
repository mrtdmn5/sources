package com.animaconnected.secondo.screens.status.devicestatus;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.status.DeviceBatteryStatus;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.watch.device.BatteryState;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceBatteryStatusFragment.kt */
/* loaded from: classes3.dex */
public final class DeviceBatteryStatusFragment extends BaseStatusFragment {
    public static final int $stable = 0;
    private final boolean chargeable = ProviderFactory.getWatch().getWatchManager().getCurrentWatch().getCapabilities().getHasChargeableBattery();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$1$lambda$0(DeviceBatteryStatusFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this$0.getString(R.string.faq_uri))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3$lambda$2(View view) {
        ProviderFactory.getWatch().fireBatteryStateChanged(BatteryState.NORMAL);
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_status_device_battery_status, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        DeviceBatteryStatus deviceBatteryStatus;
        int r6;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.status_board_title);
        TextView textView2 = (TextView) view.findViewById(R.id.status_board_desc);
        Button button = (Button) view.findViewById(R.id.btn_battery_confirm);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.top_stripe);
        StatusModel status = getStatus();
        if (status instanceof DeviceBatteryStatus) {
            deviceBatteryStatus = (DeviceBatteryStatus) status;
        } else {
            deviceBatteryStatus = null;
        }
        if (deviceBatteryStatus != null) {
            if (deviceBatteryStatus.getBatteryState() == BatteryState.CRITICAL) {
                textView.setText(R.string.battery_critical_title);
                textView2.setText(R.string.battery_critical_description);
                button.setText(getString(R.string.battery_critical_site_btn));
                button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.devicestatus.DeviceBatteryStatusFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        DeviceBatteryStatusFragment.onViewCreated$lambda$4$lambda$1$lambda$0(DeviceBatteryStatusFragment.this, view2);
                    }
                });
                ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                frameLayout.setBackground(new ColorDrawable(companion.getColor(context, R.attr.statusTopStripeImportant)));
                return;
            }
            textView.setText(R.string.battery_low_title);
            if (this.chargeable) {
                r6 = R.string.battery_low_chargable_description;
            } else {
                r6 = R.string.battery_low_description;
            }
            textView2.setText(r6);
            button.setText(getString(R.string.battery_low_confirm_btn));
            button.setOnClickListener(new DeviceBatteryStatusFragment$$ExternalSyntheticLambda1());
        }
    }
}
