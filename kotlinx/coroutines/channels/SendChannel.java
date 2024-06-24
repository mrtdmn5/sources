package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface SendChannel<E> {
    boolean close(Throwable th);

    void invokeOnClose(ProduceKt$awaitClose$4$1 produceKt$awaitClose$4$1);

    boolean isClosedForSend();

    Object send(E e, Continuation<? super Unit> continuation);

    /* renamed from: trySend-JP2dKIU */
    Object mo1701trySendJP2dKIU(E e);
}
