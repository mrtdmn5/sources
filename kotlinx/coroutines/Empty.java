package kotlinx.coroutines;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class Empty implements Incomplete {
    public final boolean isActive;

    public Empty(boolean z) {
        this.isActive = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.isActive;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Empty{");
        if (this.isActive) {
            str = "Active";
        } else {
            str = "New";
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str, '}');
    }
}
