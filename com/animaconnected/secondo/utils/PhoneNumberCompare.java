package com.animaconnected.secondo.utils;

import android.telephony.PhoneNumberUtils;

/* loaded from: classes3.dex */
public class PhoneNumberCompare {
    public static boolean compare(String str, String str2) {
        return PhoneNumberUtils.compare(str, str2);
    }
}
