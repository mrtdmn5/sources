package kotlin.collections;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceBuilderIterator;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes.dex */
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int r3, int r4) {
        boolean z;
        String m;
        if (r3 > 0 && r4 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (r3 != r4) {
                m = ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Both size ", r3, " and step ", r4, " must be greater than zero.");
            } else {
                m = ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("size ", r3, " must be greater than zero.");
            }
            throw new IllegalArgumentException(m.toString());
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int r9, int r10, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        if (!iterator.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(r9, r10, iterator, z2, z, null);
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.nextStep = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(slidingWindowKt$windowedIterator$1, sequenceBuilderIterator, sequenceBuilderIterator);
        return sequenceBuilderIterator;
    }
}
