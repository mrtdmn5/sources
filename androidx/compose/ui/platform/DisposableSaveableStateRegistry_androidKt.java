package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ReferentialEqualityPolicy;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.io.Serializable;
import kotlin.Function;

/* compiled from: DisposableSaveableStateRegistry.android.kt */
/* loaded from: classes.dex */
public final class DisposableSaveableStateRegistry_androidKt {
    public static final Class<? extends Object>[] AcceptableClasses = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean canBeSavedToBundle(Object obj) {
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() != NeverEqualPolicy.INSTANCE && snapshotMutableState.getPolicy() != StructuralEqualityPolicy.INSTANCE && snapshotMutableState.getPolicy() != ReferentialEqualityPolicy.INSTANCE) {
                return false;
            }
            T value = snapshotMutableState.getValue();
            if (value == 0) {
                return true;
            }
            return canBeSavedToBundle(value);
        }
        if ((obj instanceof Function) && (obj instanceof Serializable)) {
            return false;
        }
        Class<? extends Object>[] clsArr = AcceptableClasses;
        for (int r3 = 0; r3 < 7; r3++) {
            if (clsArr[r3].isInstance(obj)) {
                return true;
            }
        }
        return false;
    }
}
