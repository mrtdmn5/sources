package com.animaconnected.secondo.screens.notification;

import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public enum NotificationInfo {
    ALL_CALLS(0, 1, R.drawable.ic_all_calls, R.string.nft_all_calls_title),
    CALENDAR(3, 1, R.drawable.ic_calendar, R.string.nft_calendar_title),
    SILENT_ALARM(5, 1, R.drawable.ic_alarm, R.string.nft_silent_alarm_title),
    GET_MOVING(6, 1, R.drawable.ic_get_moving, R.string.nft_get_moving_title),
    STEP_GOAL(7, 1, R.drawable.ic_step_goal, R.string.nft_step_goal_title),
    IFTTT(10, 1, R.drawable.ic_ifttt, R.string.behaviour_name_ifttt),
    ALL_MESSAGES(9, 1, R.drawable.ic_all_texts, R.string.nft_all_messages_title),
    MAGIC_WORD(11, 1, R.drawable.ic_magic_word, R.string.nft_magic_word_title),
    OUT_OF_RANGE(12, 1, R.drawable.ic_out_of_range, R.string.out_of_range_name);

    private final int mCategory;
    private final int mIconResourceId;
    private final int mName;
    private final int mType;

    NotificationInfo(int r3, int r4, int r5, int r6) {
        this.mType = r3;
        this.mCategory = r4;
        this.mIconResourceId = r5;
        this.mName = r6;
    }

    public static NotificationInfo getFromType(int r1) {
        if (r1 != 0) {
            if (r1 != 3) {
                if (r1 != 5) {
                    if (r1 != 6) {
                        if (r1 != 7) {
                            switch (r1) {
                                case 9:
                                    return ALL_MESSAGES;
                                case 10:
                                    return IFTTT;
                                case 11:
                                    return MAGIC_WORD;
                                case 12:
                                    return OUT_OF_RANGE;
                                default:
                                    return null;
                            }
                        }
                        return STEP_GOAL;
                    }
                    return GET_MOVING;
                }
                return SILENT_ALARM;
            }
            return CALENDAR;
        }
        return ALL_CALLS;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public int getIconResourceId() {
        return this.mIconResourceId;
    }

    public int getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }
}
