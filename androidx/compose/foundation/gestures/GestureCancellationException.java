package androidx.compose.foundation.gestures;

import java.util.concurrent.CancellationException;

/* compiled from: ForEachGesture.kt */
/* loaded from: classes.dex */
public final class GestureCancellationException extends CancellationException {
    public GestureCancellationException() {
        super(null);
    }

    public GestureCancellationException(int r1) {
        super("The press gesture was canceled.");
    }
}
