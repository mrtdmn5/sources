package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Alpha.kt */
/* loaded from: classes.dex */
public final class AlphaKt {
    public static final Modifier alpha(Modifier modifier, float f) {
        boolean z;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (f == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return GraphicsLayerModifierKt.m331graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, f, null, true, 0, 126971);
        }
        return modifier;
    }

    public static final void cancelConsumed(ReceiveChannel receiveChannel, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        receiveChannel.cancel(cancellationException);
    }

    public static final void trySendBlocking(SendChannel sendChannel, Object obj) {
        Object runBlocking;
        Object mo1701trySendJP2dKIU = sendChannel.mo1701trySendJP2dKIU(obj);
        if (mo1701trySendJP2dKIU instanceof ChannelResult.Failed) {
            runBlocking = BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, obj, null));
            Object obj2 = ((ChannelResult) runBlocking).holder;
        } else {
            Unit unit = Unit.INSTANCE;
        }
    }
}
