package com.animaconnected.secondo.provider.habittracker;

import android.content.Context;
import com.kronaby.watch.app.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public enum ResetInverval {
    DAY(0, R.string.behaviour_habit_tracker_day, R.string.behaviour_habit_tracker_day_goal),
    WEEK(1, R.string.behaviour_habit_tracker_week, R.string.behaviour_habit_tracker_week_goal),
    MONTH(2, R.string.behaviour_habit_tracker_month, R.string.behaviour_habit_tracker_month_goal),
    NEVER(3, R.string.behaviour_habit_tracker_never, -1);

    public static final int NO_RESOURCE = -1;
    private final int mId;
    private final int mStringGoalResId;
    private final int mStringResId;

    ResetInverval(int r3, int r4, int r5) {
        this.mId = r3;
        this.mStringResId = r4;
        this.mStringGoalResId = r5;
    }

    public static int getIndexOf(int r4) {
        ResetInverval[] values = values();
        for (int r2 = 0; r2 < values.length; r2++) {
            if (values[r2].equals(r4)) {
                return r2;
            }
        }
        return 0;
    }

    public static ArrayList<String> getResetIntervalStrings(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (ResetInverval resetInverval : values()) {
            arrayList.add(context.getString(resetInverval.getStringResId()));
        }
        return arrayList;
    }

    public static ResetInverval getValueFromId(int r0) {
        return getValueFromIndex(getIndexOf(r0));
    }

    public static ResetInverval getValueFromIndex(int r1) {
        return values()[r1];
    }

    public boolean equals(int r2) {
        if (this.mId == r2) {
            return true;
        }
        return false;
    }

    public int getId() {
        return this.mId;
    }

    public int getStringGoalResId() {
        return this.mStringGoalResId;
    }

    public int getStringResId() {
        return this.mStringResId;
    }
}
