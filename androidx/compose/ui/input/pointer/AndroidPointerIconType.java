package androidx.compose.ui.input.pointer;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerIcon.android.kt */
/* loaded from: classes.dex */
public final class AndroidPointerIconType implements PointerIcon {
    public final int type;

    public AndroidPointerIconType(int r1) {
        this.type = r1;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(AndroidPointerIconType.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        if (this.type == ((AndroidPointerIconType) obj).type) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.type;
    }

    public final String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("AndroidPointerIcon(type="), this.type, ')');
    }
}
