package kotlinx.coroutines.channels;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ConflatedBufferedChannel.kt */
/* loaded from: classes4.dex */
public final class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    public final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int r3, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(r3, function1);
        boolean z;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r3 >= 1) {
            } else {
                throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Buffered channel capacity must be at least 1, but ", r3, " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean isConflatedDropOldest() {
        if (this.onBufferOverflow == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException;
        Object m1702trySendImplMj0NB7M = m1702trySendImplMj0NB7M(e, true);
        boolean z = m1702trySendImplMj0NB7M instanceof ChannelResult.Closed;
        if (z) {
            if (z) {
            }
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            if (function1 != null && (callUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, e, null)) != null) {
                ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException, getSendException());
                throw callUndeliveredElementCatchingException;
            }
            throw getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo1701trySendJP2dKIU(E e) {
        return m1702trySendImplMj0NB7M(e, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ee, code lost:            return kotlin.Unit.INSTANCE;     */
    /* renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1702trySendImplMj0NB7M(E r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ConflatedBufferedChannel.m1702trySendImplMj0NB7M(java.lang.Object, boolean):java.lang.Object");
    }
}
