package com.animaconnected.secondo.provider.lostwatch;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import com.animaconnected.watch.location.Spot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class LostWatchStorage {
    private static final String KEY_LOST_WATCH_HAS_SPOT = "lostWatchHasSpot";
    private static final String KEY_LOST_WATCH_SPOT = "lostWatchSpot";
    private static final String PREFIX_LOST_WATCH_STORAGE = "lostWatch_";
    private static final Type sSpotType = new TypeToken<Spot>() { // from class: com.animaconnected.secondo.provider.lostwatch.LostWatchStorage.1
    }.getType();
    private final Context mContext;

    /* renamed from: com.animaconnected.secondo.provider.lostwatch.LostWatchStorage$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends TypeToken<Spot> {
    }

    public LostWatchStorage(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences(String str, Context context) {
        return context.getSharedPreferences(PREFIX_LOST_WATCH_STORAGE + str, 0);
    }

    public Spot getLostWatchSpot(String str) {
        String string;
        if (!hasLostWatchSpot(str) || (string = getSharedPreferences(str, this.mContext).getString(KEY_LOST_WATCH_SPOT, null)) == null) {
            return null;
        }
        return (Spot) new Gson().fromJson(string, sSpotType);
    }

    public boolean hasLostWatchSpot(String str) {
        return getSharedPreferences(str, this.mContext).getBoolean(KEY_LOST_WATCH_HAS_SPOT, false);
    }

    public void removeLostWatchSpot(String str) {
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(str, this.mContext), KEY_LOST_WATCH_HAS_SPOT, false);
    }

    public void storeLostWatchSpot(String str, Spot spot) {
        getSharedPreferences(str, this.mContext).edit().putString(KEY_LOST_WATCH_SPOT, new Gson().toJson(spot)).apply();
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(str, this.mContext), KEY_LOST_WATCH_HAS_SPOT, true);
    }
}
