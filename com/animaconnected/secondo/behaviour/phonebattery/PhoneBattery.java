package com.animaconnected.secondo.behaviour.phonebattery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.RemoteComplicationBehaviour;
import com.animaconnected.watch.device.Scale;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class PhoneBattery extends RemoteComplicationBehaviour {
    private static final String BEHAVIOUR_ANALYTICS_NAME = "phone_battery";
    private static final float MAX_ANGLE = 300.0f;
    private static final String TAG = "PhoneBattery";
    public static final String TYPE = "PhoneBattery";
    private static BroadcastReceiver sBatteryStatusReceiver = null;
    private static int sLatestPercentageInDegrees = -1;
    private final Context mContext;

    public PhoneBattery(Context context) {
        this.mContext = context;
    }

    private static float getBatteryPercentage(Context context) {
        float f;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (registerReceiver.getIntExtra(AnalyticsConstants.KEY_STATUS, -1) != 5) {
                f = intExtra / intExtra2;
            } else {
                Log.d(TAG, "Phone battery status is full, just set it to max value");
                f = 1.0f;
            }
            Log.d(TAG, "Phone battery percentage: " + f);
            return f;
        }
        Log.d(TAG, "Battery status is null, just return 0");
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getBatteryPercentageInDegrees() {
        return (int) Math.ceil(getBatteryPercentage(this.mContext) * MAX_ANGLE);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void activate(Slot slot) {
        super.activate(slot);
        if (sBatteryStatusReceiver == null) {
            sLatestPercentageInDegrees = -1;
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.behaviour.phonebattery.PhoneBattery.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Log.d(PhoneBattery.TAG, "Battery status changed " + SystemClock.uptimeMillis());
                    if (((int) PhoneBattery.this.getBatteryPercentageInDegrees()) != PhoneBattery.sLatestPercentageInDegrees) {
                        Log.d(PhoneBattery.TAG, "Battery percentage in degrees changed -> update remote complication");
                        ProviderFactory.getWatch().updateRemoteComplication();
                        PhoneBatteryProvider.getsInstance().setLastPhoneBatteryUpdateTimestamp();
                    }
                }
            };
            sBatteryStatusReceiver = broadcastReceiver;
            this.mContext.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            ProviderFactory.getWatch().updateRemoteComplication();
        }
        PhoneBatteryProvider.getsInstance().startPhoneBatteryScheduler();
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour, com.animaconnected.watch.behaviour.Complication
    public List<Scale> compatibleScales() {
        return Collections.singletonList(Scale.ZeroToHundred);
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public void deactivated(Slot slot) {
        super.deactivated(slot);
        BroadcastReceiver broadcastReceiver = sBatteryStatusReceiver;
        if (broadcastReceiver != null) {
            this.mContext.unregisterReceiver(broadcastReceiver);
            sBatteryStatusReceiver = null;
        }
        PhoneBatteryProvider.getsInstance().stopPhoneBatteryScheduler();
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return BEHAVIOUR_ANALYTICS_NAME;
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getHoursInDegrees() {
        return getBatteryPercentageInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.WatchFaceBehavior, com.animaconnected.watch.behaviour.WatchFaceVisible
    public float getMinutesInDegrees() {
        return getBatteryPercentageInDegrees();
    }

    @Override // com.animaconnected.watch.behaviour.RemoteComplicationBehaviour
    public int[] getRemoteData(List<? extends Scale> list) {
        int batteryPercentageInDegrees = (int) getBatteryPercentageInDegrees();
        sLatestPercentageInDegrees = batteryPercentageInDegrees;
        return new int[]{batteryPercentageInDegrees, batteryPercentageInDegrees};
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return TYPE;
    }
}
