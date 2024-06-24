package com.animaconnected.secondo.utils.debugging;

import kotlin.text.StringsKt___StringsKt;

/* compiled from: LoggerAndroid.kt */
/* loaded from: classes3.dex */
public final class LoggerAndroidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getTag(String str) {
        if (str.length() > 23) {
            return StringsKt___StringsKt.take(23, str);
        }
        return str;
    }
}
