package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SharedPreferencesQueue {
    public final SharedPreferences sharedPreferences;
    public final Executor syncExecutor;
    public final ArrayDeque<String> internalQueue = new ArrayDeque<>();
    public final String queueName = "topic_operation_queue";
    public final String itemSeparator = ",";

    public SharedPreferencesQueue(SharedPreferences sharedPreferences, Executor executor) {
        this.sharedPreferences = sharedPreferences;
        this.syncExecutor = executor;
    }

    public static SharedPreferencesQueue createInstance(SharedPreferences sharedPreferences, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, executor);
        synchronized (sharedPreferencesQueue.internalQueue) {
            sharedPreferencesQueue.internalQueue.clear();
            String string = sharedPreferencesQueue.sharedPreferences.getString(sharedPreferencesQueue.queueName, "");
            if (!TextUtils.isEmpty(string) && string.contains(sharedPreferencesQueue.itemSeparator)) {
                String[] split = string.split(sharedPreferencesQueue.itemSeparator, -1);
                if (split.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        sharedPreferencesQueue.internalQueue.add(str);
                    }
                }
            }
        }
        return sharedPreferencesQueue;
    }
}
