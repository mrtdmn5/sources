package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionHandles.kt */
/* loaded from: classes.dex */
public final class SelectionHandleInfo {
    public final Handle handle;
    public final long position;

    public SelectionHandleInfo(Handle handle, long j) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.handle = handle;
        this.position = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        if (this.handle == selectionHandleInfo.handle && Offset.m257equalsimpl0(this.position, selectionHandleInfo.position)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.handle.hashCode() * 31;
        int r1 = Offset.$r8$clinit;
        return Long.hashCode(this.position) + hashCode;
    }

    public final String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.m264toStringimpl(this.position)) + ')';
    }
}
