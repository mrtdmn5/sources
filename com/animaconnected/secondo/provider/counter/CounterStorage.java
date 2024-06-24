package com.animaconnected.secondo.provider.counter;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class CounterStorage {
    private static final String COUNTER_STORAGE = "counterStorage";
    private static final String KEY_COUNT = "count";
    private final Context mContext;

    public CounterStorage(Context context) {
        this.mContext = context;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(COUNTER_STORAGE, 0);
    }

    public int getCount() {
        return getSharedPreferences(this.mContext).getInt(KEY_COUNT, 0);
    }

    public void setCount(int r3) {
        getSharedPreferences(this.mContext).edit().putInt(KEY_COUNT, r3).apply();
    }
}
