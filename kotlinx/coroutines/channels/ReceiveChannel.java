package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface ReceiveChannel<E> {
    void cancel(CancellationException cancellationException);

    SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    ChannelIterator<E> iterator();

    Object receive(Continuation<? super E> continuation);

    /* renamed from: receiveCatching-JP2dKIU */
    Object mo1698receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2);

    /* renamed from: tryReceive-PtdJZtk */
    Object mo1700tryReceivePtdJZtk();
}
