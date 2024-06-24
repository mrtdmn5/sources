package com.animaconnected.secondo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public class SettingsProvider {
    private static final String ACTIVITY_ONBOARDING_COMPLETED = "activity_onboarding_completed";
    private static final String AVAILABILITY = "availability";
    private static final String PREFERENCES_NAME = "com.animaconnected.secondo";
    private static final String PREF_GOOGLE_EMAIL = "google_email";
    private static final String PREF_LATEST_GMAIL_DATE = "latest_gmail_date";
    private static final String TERMS_AND_POLICY = "terms_and_policy_accepted";
    private final Context mContext;
    private SharedPreferences mSharedPreferences;

    public SettingsProvider(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences(PREFERENCES_NAME, 0);
        }
        return this.mSharedPreferences;
    }

    public boolean getActivityOnboardingCompleted() {
        return getSharedPreferences().getBoolean(ACTIVITY_ONBOARDING_COMPLETED, false);
    }

    public boolean getAvailability() {
        return getSharedPreferences().getBoolean(AVAILABILITY, false);
    }

    public String getGoogleEmailAddress() {
        return getSharedPreferences().getString(PREF_GOOGLE_EMAIL, "");
    }

    public long getLatestGmailDate() {
        return getSharedPreferences().getLong(PREF_LATEST_GMAIL_DATE, 0L);
    }

    public boolean getTermsAndPolicyAccepted() {
        return getSharedPreferences().getBoolean(TERMS_AND_POLICY, false);
    }

    public boolean isEnabled(String str) {
        return isEnabled(str, false);
    }

    public void setActivityOnboardingCompleted(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), ACTIVITY_ONBOARDING_COMPLETED, z);
    }

    public void setAvailability(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), AVAILABILITY, z);
    }

    public void setGoogleEmailAddress(String str) {
        getSharedPreferences().edit().putString(PREF_GOOGLE_EMAIL, str).apply();
    }

    public void setLatestGmailDate(long j) {
        getSharedPreferences().edit().putLong(PREF_LATEST_GMAIL_DATE, j).apply();
    }

    public void setTermsAndPolicyAccepted(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(), TERMS_AND_POLICY, z);
    }

    public boolean isEnabled(String str, boolean z) {
        return getSharedPreferences().getBoolean(str, z);
    }
}
