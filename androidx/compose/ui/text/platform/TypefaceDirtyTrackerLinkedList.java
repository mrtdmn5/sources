package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public final class TypefaceDirtyTrackerLinkedList {
    public final Object initial;
    public final TypefaceDirtyTrackerLinkedList next;
    public final State<Object> resolveResult;

    public TypefaceDirtyTrackerLinkedList(State<? extends Object> resolveResult, TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList) {
        Intrinsics.checkNotNullParameter(resolveResult, "resolveResult");
        this.resolveResult = resolveResult;
        this.next = typefaceDirtyTrackerLinkedList;
        this.initial = resolveResult.getValue();
    }

    public final boolean isStaleResolvedFont() {
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList;
        if (this.resolveResult.getValue() == this.initial && ((typefaceDirtyTrackerLinkedList = this.next) == null || !typefaceDirtyTrackerLinkedList.isStaleResolvedFont())) {
            return false;
        }
        return true;
    }
}
