package com.google.firebase.messaging;

import android.util.Log;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class TopicOperation {
    public static final Pattern TOPIC_NAME_REGEXP = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    public final String operation;
    public final String serializedString;
    public final String topic;

    public TopicOperation(String str, String str2) {
        String str3;
        if (str2 != null && str2.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            str3 = str2.substring(8);
        } else {
            str3 = str2;
        }
        if (str3 != null && TOPIC_NAME_REGEXP.matcher(str3).matches()) {
            this.topic = str3;
            this.operation = str;
            this.serializedString = AbstractResolvableFuture$$ExternalSyntheticOutline0.m(str, "!", str2);
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str3, "[a-zA-Z0-9-_.~%]{1,900}"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        if (!this.topic.equals(topicOperation.topic) || !this.operation.equals(topicOperation.operation)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.operation, this.topic});
    }
}
