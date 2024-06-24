package com.animaconnected.secondo.provider.habittracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import java.util.Calendar;

/* loaded from: classes3.dex */
class HabitTrackerStorage {
    private static final String COUNTER_STORAGE = "habitTrackerStorage";
    private static final String KEY_CURRENT_COUNT = "currentCount";
    private static final String KEY_GOAL_COUNT = "goalCount";
    private static final String KEY_GOAL_NAME = "goalName";
    private static final String KEY_LAST_DATE_USED = "lastDateUsed";
    private static final String KEY_ONBOARDING_DONE = "onboardingDone";
    private static final String KEY_RESET_INTERVAL = "resetInterval";
    private final Context mContext;

    public HabitTrackerStorage(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(COUNTER_STORAGE, 0);
    }

    public int getCurrentCount() {
        return getSharedPreferences(this.mContext).getInt(KEY_CURRENT_COUNT, 0);
    }

    public int getGoalCount() {
        return getSharedPreferences(this.mContext).getInt(KEY_GOAL_COUNT, 1);
    }

    public String getGoalName() {
        return getSharedPreferences(this.mContext).getString(KEY_GOAL_NAME, "");
    }

    public Calendar getLastDateUsed() {
        long j = getSharedPreferences(this.mContext).getLong(KEY_LAST_DATE_USED, 0L);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar;
    }

    public boolean getOnboardingDone() {
        return getSharedPreferences(this.mContext).getBoolean(KEY_ONBOARDING_DONE, false);
    }

    public ResetInverval getResetInterval() {
        return ResetInverval.getValueFromId(getSharedPreferences(this.mContext).getInt(KEY_RESET_INTERVAL, ResetInverval.DAY.getId()));
    }

    public void setCurrentCount(int r3) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_CURRENT_COUNT, r3).apply();
    }

    public void setGoalCount(int r3) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_GOAL_COUNT, r3).apply();
    }

    public void setGoalName(String str) {
        getSharedPreferences(this.mContext).edit().putString(KEY_GOAL_NAME, str).apply();
    }

    public void setLastDateUsed(Calendar calendar) {
        getSharedPreferences(this.mContext).edit().putLong(KEY_LAST_DATE_USED, calendar.getTimeInMillis()).apply();
    }

    public void setOnboardingDone(boolean z) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(this.mContext), KEY_ONBOARDING_DONE, z);
    }

    public void setResetInterval(ResetInverval resetInverval) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_RESET_INTERVAL, resetInverval.getId()).apply();
    }
}
