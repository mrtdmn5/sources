package androidx.compose.foundation.layout;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.android.kt */
/* loaded from: classes.dex */
public final class AndroidWindowInsets implements WindowInsets {
    public final ParcelableSnapshotMutableState insets$delegate = Platform.mutableStateOf$default(Insets.NONE);
    public final ParcelableSnapshotMutableState isVisible$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
    public final String name;
    public final int type;

    public AndroidWindowInsets(int r1, String str) {
        this.type = r1;
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidWindowInsets)) {
            return false;
        }
        if (this.type == ((AndroidWindowInsets) obj).type) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('(');
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.insets$delegate;
        sb.append(((Insets) parcelableSnapshotMutableState.getValue()).left);
        sb.append(", ");
        sb.append(((Insets) parcelableSnapshotMutableState.getValue()).top);
        sb.append(", ");
        sb.append(((Insets) parcelableSnapshotMutableState.getValue()).right);
        sb.append(", ");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, ((Insets) parcelableSnapshotMutableState.getValue()).bottom, ')');
    }

    public final void update$foundation_layout_release(WindowInsetsCompat windowInsetsCompat, int r4) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsetsCompat");
        int r0 = this.type;
        if (r4 == 0 || (r4 & r0) != 0) {
            Insets insets = windowInsetsCompat.getInsets(r0);
            Intrinsics.checkNotNullParameter(insets, "<set-?>");
            this.insets$delegate.setValue(insets);
            this.isVisible$delegate.setValue(Boolean.valueOf(windowInsetsCompat.mImpl.isVisible(r0)));
        }
    }
}
