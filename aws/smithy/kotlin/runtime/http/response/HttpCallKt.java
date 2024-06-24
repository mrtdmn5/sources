package aws.smithy.kotlin.runtime.http.response;

import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.io.SdkByteReadChannel;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpCall.kt */
/* loaded from: classes.dex */
public final class HttpCallKt {
    public static final Object complete(HttpCall httpCall, ContinuationImpl continuationImpl) {
        CompletableJob completableJob;
        SdkByteReadChannel readFrom;
        CoroutineContext.Element element = httpCall.callContext.get(Job.Key.$$INSTANCE);
        HttpBody.ChannelContent channelContent = null;
        if (element instanceof CompletableJob) {
            completableJob = (CompletableJob) element;
        } else {
            completableJob = null;
        }
        if (completableJob == null) {
            return Unit.INSTANCE;
        }
        try {
            HttpBody httpBody = httpCall.response.body;
            if (httpBody instanceof HttpBody.ChannelContent) {
                channelContent = (HttpBody.ChannelContent) httpBody;
            }
            if (channelContent != null && (readFrom = channelContent.readFrom()) != null) {
                readFrom.cancel();
            }
        } catch (Throwable unused) {
        }
        completableJob.complete();
        Object join = completableJob.join(continuationImpl);
        if (join == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return join;
        }
        return Unit.INSTANCE;
    }
}
