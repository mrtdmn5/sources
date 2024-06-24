package io.ktor.client.plugins;

import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* compiled from: BodyProgress.kt */
/* loaded from: classes3.dex */
public final class BodyProgressKt {
    public static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey");
    public static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> DownloadProgressListenerAttributeKey = new AttributeKey<>("DownloadProgressListenerAttributeKey");
}
