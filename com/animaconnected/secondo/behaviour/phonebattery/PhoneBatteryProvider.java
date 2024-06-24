package com.animaconnected.secondo.behaviour.phonebattery;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.DeviceConnectionListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class PhoneBatteryProvider {
    private static final long MIN_DELAY_BETWEEN_PHONE_BATTERY_UPDATE = 1800000;
    private static final String TAG = "PhoneBatteryProvider";
    private static PhoneBatteryProvider sInstance;
    private long lastPhoneBatteryUpdateTimestamp;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mUpdateBatteryScheduleRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryProvider.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhoneBatteryProvider.this.updatePhoneBatteryStatus();
            PhoneBatteryProvider.this.mHandler.postDelayed(this, PhoneBatteryProvider.MIN_DELAY_BETWEEN_PHONE_BATTERY_UPDATE);
        }
    };
    private boolean mScheduleHasBeenStarted = false;

    /* renamed from: com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryProvider$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhoneBatteryProvider.this.updatePhoneBatteryStatus();
            PhoneBatteryProvider.this.mHandler.postDelayed(this, PhoneBatteryProvider.MIN_DELAY_BETWEEN_PHONE_BATTERY_UPDATE);
        }
    }

    /* renamed from: com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryProvider$2 */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements DeviceConnectionListener {
        public AnonymousClass2() {
        }

        @Override // com.animaconnected.watch.device.DeviceConnectionListener
        public void onConnected() {
            if (PhoneBatteryProvider.this.mScheduleHasBeenStarted) {
                PhoneBatteryProvider.this.updateComplicationIfMinDelayHasHasOverRun();
            }
        }
    }

    private PhoneBatteryProvider() {
        ProviderFactory.getWatch().registerDeviceConnectionListener(new DeviceConnectionListener() { // from class: com.animaconnected.secondo.behaviour.phonebattery.PhoneBatteryProvider.2
            public AnonymousClass2() {
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onConnected() {
                if (PhoneBatteryProvider.this.mScheduleHasBeenStarted) {
                    PhoneBatteryProvider.this.updateComplicationIfMinDelayHasHasOverRun();
                }
            }
        });
    }

    public static PhoneBatteryProvider getsInstance() {
        if (sInstance == null) {
            sInstance = new PhoneBatteryProvider();
        }
        return sInstance;
    }

    public void updateComplicationIfMinDelayHasHasOverRun() {
        if (SystemClock.uptimeMillis() - this.lastPhoneBatteryUpdateTimestamp >= MIN_DELAY_BETWEEN_PHONE_BATTERY_UPDATE) {
            updatePhoneBatteryStatus();
        }
    }

    public void updatePhoneBatteryStatus() {
        if (ProviderFactory.getWatch().isConnected()) {
            Log.d(TAG, "Phone battery complication has not been updated in 1800000 millis, update it");
            ProviderFactory.getWatch().updateRemoteComplication();
            setLastPhoneBatteryUpdateTimestamp();
        }
    }

    public void setLastPhoneBatteryUpdateTimestamp() {
        this.lastPhoneBatteryUpdateTimestamp = SystemClock.uptimeMillis();
    }

    public void startPhoneBatteryScheduler() {
        if (!this.mScheduleHasBeenStarted) {
            this.mScheduleHasBeenStarted = true;
            this.mHandler.postDelayed(this.mUpdateBatteryScheduleRunnable, MIN_DELAY_BETWEEN_PHONE_BATTERY_UPDATE);
        }
    }

    public void stopPhoneBatteryScheduler() {
        if (this.mScheduleHasBeenStarted) {
            this.mScheduleHasBeenStarted = false;
            this.mHandler.removeCallbacks(this.mUpdateBatteryScheduleRunnable);
        }
    }
}
