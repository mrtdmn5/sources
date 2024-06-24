package com.animaconnected.secondo.provider.notification.configuration.item;

import android.os.Build;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class NotificationItemConstants {
    public static final int GROUP_DEFAULT = -1;
    public static final int SUB_TYPE_CONTACTS = 0;
    public static final int SUB_TYPE_IMPORTANT_APP = 2;
    public static final int SUB_TYPE_MISC = 1;
    public static final int TYPE_ALL_CALLS = 0;
    public static final int TYPE_ALL_MESSAGES = 9;
    public static final int TYPE_CALENDAR = 3;
    public static final int TYPE_CONTACT = 2;
    public static final int TYPE_CONTACT_ADDER = 1;
    public static final int TYPE_GET_MOVING = 6;
    public static final int TYPE_IFTTT = 10;
    public static final int TYPE_IMPORTANT_APP = 4;
    public static final int TYPE_IMPORTANT_APP_ADDER = 8;
    public static final int TYPE_MAGIC_WORD = 11;
    public static final int TYPE_OUT_OF_RANGE = 12;
    public static final int TYPE_SILENT_ALARM = 5;
    public static final int TYPE_STEP_GOAL = 7;

    private NotificationItemConstants() {
    }

    public static int getConfigurationDescription(int r1) {
        if (r1 != 5) {
            if (r1 != 10) {
                if (r1 != 11) {
                    return -1;
                }
                return R.layout.dialog_magic_word;
            }
            return R.layout.dialog_ifttt;
        }
        return R.layout.dialog_silent_alarm;
    }

    public static String getNotificationName(int r0) {
        switch (r0) {
            case 0:
                return "all_calls";
            case 1:
                return "contact_added";
            case 2:
                return "contact";
            case 3:
                return "calendar";
            case 4:
                return "important_app";
            case 5:
                return "silent_alarm";
            case 6:
                return "get_moving";
            case 7:
                return "step_goal";
            case 8:
            default:
                return "undefined";
            case 9:
                return "all_texts";
            case 10:
                return "ifttt";
            case 11:
                return "magicword";
            case 12:
                return "out_of_range";
        }
    }

    public static boolean needNotificationAccess(int r1) {
        if (r1 != 2 && r1 != 3 && r1 != 4 && r1 != 11) {
            return false;
        }
        return true;
    }

    public static boolean needsConfiguration(int r1) {
        if (r1 != 5 && r1 != 10 && r1 != 11) {
            return false;
        }
        return true;
    }

    public static String[] requiredPermissions(int r11) {
        if (r11 != 0) {
            if (r11 != 1) {
                if (r11 != 2) {
                    if (r11 != 9) {
                        return new String[0];
                    }
                    return new String[]{"android.permission.RECEIVE_SMS"};
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    return new String[]{"android.permission.READ_CONTACTS", "android.permission.RECEIVE_SMS", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE", "android.permission.READ_CALL_LOG", "android.permission.GET_ACCOUNTS"};
                }
                return new String[]{"android.permission.READ_CONTACTS", "android.permission.RECEIVE_SMS", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE", "android.permission.GET_ACCOUNTS"};
            }
            return new String[]{"android.permission.READ_CONTACTS"};
        }
        return new String[]{"android.permission.READ_CALL_LOG", "android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};
    }
}
