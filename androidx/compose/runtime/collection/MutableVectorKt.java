package androidx.compose.runtime.collection;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.util.List;

/* compiled from: MutableVector.kt */
/* loaded from: classes.dex */
public final class MutableVectorKt {
    public static final void access$checkIndex(int r4, List list) {
        int size = list.size();
        if (r4 >= 0 && r4 < size) {
        } else {
            throw new IndexOutOfBoundsException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Index ", r4, " is out of bounds. The list has ", size, " elements."));
        }
    }

    public static final void access$checkSubIndex(int r3, List list, int r5) {
        int size = list.size();
        if (r3 <= r5) {
            if (r3 >= 0) {
                if (r5 <= size) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + r5 + ") is more than than the list size (" + size + ')');
            }
            throw new IndexOutOfBoundsException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("fromIndex (", r3, ") is less than 0."));
        }
        throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Indices are out of order. fromIndex (", r3, ") is greater than toIndex (", r5, ")."));
    }
}
