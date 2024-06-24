package kotlinx.coroutines.channels;

import androidx.core.content.res.CamUtils;
import com.amazonaws.services.s3.internal.Constants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final class BufferedChannelKt {
    public static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment<>(-1, null, null, 0);
    public static final int SEGMENT_SIZE = CamUtils.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);
    public static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = CamUtils.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", Constants.MAXIMUM_UPLOAD_PARTS, 0, 0, 12);
    public static final Symbol BUFFERED = new Symbol("BUFFERED");
    public static final Symbol IN_BUFFER = new Symbol("SHOULD_BUFFER");
    public static final Symbol RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
    public static final Symbol RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
    public static final Symbol POISONED = new Symbol("POISONED");
    public static final Symbol DONE_RCV = new Symbol("DONE_RCV");
    public static final Symbol INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
    public static final Symbol INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
    public static final Symbol CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
    public static final Symbol SUSPEND = new Symbol("SUSPEND");
    public static final Symbol SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
    public static final Symbol FAILED = new Symbol("FAILED");
    public static final Symbol NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
    public static final Symbol CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
    public static final Symbol CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
    public static final Symbol NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");

    public static final <T> boolean tryResume0(CancellableContinuation<? super T> cancellableContinuation, T t, Function1<? super Throwable, Unit> function1) {
        Symbol tryResume = cancellableContinuation.tryResume(t, function1);
        if (tryResume != null) {
            cancellableContinuation.completeResume(tryResume);
            return true;
        }
        return false;
    }
}
