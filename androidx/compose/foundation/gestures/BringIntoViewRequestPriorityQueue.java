package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: BringIntoViewRequestPriorityQueue.kt */
/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    public final MutableVector<ContentInViewModifier.Request> requests = new MutableVector<>(new ContentInViewModifier.Request[16]);

    public final void cancelAndRemoveAll(CancellationException cancellationException) {
        MutableVector<ContentInViewModifier.Request> mutableVector = this.requests;
        int r1 = mutableVector.size;
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[r1];
        for (int r4 = 0; r4 < r1; r4++) {
            cancellableContinuationArr[r4] = mutableVector.content[r4].continuation;
        }
        for (int r3 = 0; r3 < r1; r3++) {
            cancellableContinuationArr[r3].cancel(cancellationException);
        }
        if (!mutableVector.isEmpty()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final void resumeAndRemoveAll() {
        MutableVector<ContentInViewModifier.Request> mutableVector = this.requests;
        int r3 = 0;
        int r0 = new IntRange(0, mutableVector.size - 1).last;
        if (r0 >= 0) {
            while (true) {
                mutableVector.content[r3].continuation.resumeWith(Unit.INSTANCE);
                if (r3 == r0) {
                    break;
                } else {
                    r3++;
                }
            }
        }
        mutableVector.clear();
    }
}
