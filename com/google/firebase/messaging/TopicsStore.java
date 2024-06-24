package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class TopicsStore {
    public static WeakReference<TopicsStore> topicsStoreWeakReference;
    public SharedPreferencesQueue topicOperationsQueue;

    public TopicsStore(SharedPreferences sharedPreferences, ScheduledExecutorService scheduledExecutorService) {
    }

    public final synchronized TopicOperation getNextTopicOperation() {
        String peek;
        TopicOperation topicOperation;
        SharedPreferencesQueue sharedPreferencesQueue = this.topicOperationsQueue;
        synchronized (sharedPreferencesQueue.internalQueue) {
            peek = sharedPreferencesQueue.internalQueue.peek();
        }
        Pattern pattern = TopicOperation.TOPIC_NAME_REGEXP;
        if (!TextUtils.isEmpty(peek)) {
            String[] split = peek.split("!", -1);
            if (split.length == 2) {
                topicOperation = new TopicOperation(split[0], split[1]);
            }
        }
        topicOperation = null;
        return topicOperation;
    }
}
