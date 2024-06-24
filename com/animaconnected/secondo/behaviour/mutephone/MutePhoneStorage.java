package com.animaconnected.secondo.behaviour.mutephone;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutePhoneStorage.kt */
/* loaded from: classes3.dex */
public final class MutePhoneStorage {
    public static final int $stable = 0;
    private static final String INITIAL_MUTEPHONE_STORAGE = "initialMutephoneStorage";
    public static final MutePhoneStorage INSTANCE = new MutePhoneStorage();
    private static final String KEY_MUTE_MUSIC_VOLUME = "muteMusicVolume";

    private MutePhoneStorage() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(INITIAL_MUTEPHONE_STORAGE, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final int getMuteMusicVolume(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getInt(KEY_MUTE_MUSIC_VOLUME, -1);
    }

    public final void setMuteMusicVolume(Context context, int r3) {
        Intrinsics.checkNotNullParameter(context, "context");
        getSharedPreferences(context).edit().putInt(KEY_MUTE_MUSIC_VOLUME, r3).apply();
    }
}
