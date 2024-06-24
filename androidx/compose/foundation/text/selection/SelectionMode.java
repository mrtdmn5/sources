package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SelectionMode.kt */
/* loaded from: classes.dex */
public abstract class SelectionMode {
    public static final SelectionMode Vertical = new SelectionMode() { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public final int mo147compare3MmeM6k$foundation_release(long j, Rect bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (bounds.m268containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m260getYimpl(j) < bounds.top) {
                return -1;
            }
            if (Offset.m259getXimpl(j) < bounds.left && Offset.m260getYimpl(j) < bounds.bottom) {
                return -1;
            }
            return 1;
        }
    };
    public static final SelectionMode Horizontal = new SelectionMode() { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public final int mo147compare3MmeM6k$foundation_release(long j, Rect bounds) {
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (bounds.m268containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m259getXimpl(j) < bounds.left) {
                return -1;
            }
            if (Offset.m260getYimpl(j) < bounds.top && Offset.m259getXimpl(j) < bounds.right) {
                return -1;
            }
            return 1;
        }
    };
    private static final /* synthetic */ SelectionMode[] $VALUES = $values();

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Vertical, Horizontal};
    }

    public /* synthetic */ SelectionMode(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r2);
    }

    public static SelectionMode valueOf(String str) {
        return (SelectionMode) Enum.valueOf(SelectionMode.class, str);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }

    /* renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo147compare3MmeM6k$foundation_release(long j, Rect rect);

    /* renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m148isSelected2x9bVx0$foundation_release(Rect bounds, long j, long j2) {
        boolean z;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        boolean z2 = true;
        if (bounds.m268containsk4lQ0M(j) || bounds.m268containsk4lQ0M(j2)) {
            return true;
        }
        int mo147compare3MmeM6k$foundation_release = mo147compare3MmeM6k$foundation_release(j, bounds);
        int mo147compare3MmeM6k$foundation_release2 = mo147compare3MmeM6k$foundation_release(j2, bounds);
        if (mo147compare3MmeM6k$foundation_release > 0) {
            z = true;
        } else {
            z = false;
        }
        if (mo147compare3MmeM6k$foundation_release2 <= 0) {
            z2 = false;
        }
        return z ^ z2;
    }

    private SelectionMode(String str, int r2) {
    }
}
