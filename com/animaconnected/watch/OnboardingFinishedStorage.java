package com.animaconnected.watch;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.bluetooth.device.ScanToConnectInterface;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class OnboardingFinishedStorage implements ScanToConnectInterface {
    private static final String KEY_ONBOARDING_DONE = "onboarding";
    private static final String ONBOARDING_FINISHED_STORAGE = "onboardingFinishedStorage";
    private final SharedPreferences mSharedPreferences;

    public OnboardingFinishedStorage(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(ONBOARDING_FINISHED_STORAGE, 0);
    }

    public void setIsOnboardingFinished(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(this.mSharedPreferences, KEY_ONBOARDING_DONE, z);
    }

    @Override // com.animaconnected.bluetooth.device.ScanToConnectInterface
    public boolean shouldUseScanToConnect() {
        return this.mSharedPreferences.getBoolean(KEY_ONBOARDING_DONE, false);
    }
}
