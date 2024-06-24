package androidx.compose.foundation.layout;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
/* loaded from: classes.dex */
public final class ValueInsets implements WindowInsets {
    public final String name;
    public final ParcelableSnapshotMutableState value$delegate;

    public ValueInsets(InsetsValues insetsValues, String str) {
        this.name = str;
        this.value$delegate = Platform.mutableStateOf$default(insetsValues);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueInsets)) {
            return false;
        }
        return Intrinsics.areEqual(getValue$foundation_layout_release(), ((ValueInsets) obj).getValue$foundation_layout_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InsetsValues getValue$foundation_layout_release() {
        return (InsetsValues) this.value$delegate.getValue();
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append("(left=");
        sb.append(getValue$foundation_layout_release().left);
        sb.append(", top=");
        sb.append(getValue$foundation_layout_release().top);
        sb.append(", right=");
        sb.append(getValue$foundation_layout_release().right);
        sb.append(", bottom=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, getValue$foundation_layout_release().bottom, ')');
    }
}
