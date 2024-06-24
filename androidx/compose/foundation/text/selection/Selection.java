package androidx.compose.foundation.text.selection;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Selection.kt */
/* loaded from: classes.dex */
public final class Selection {
    public final AnchorInfo end;
    public final boolean handlesCrossed;
    public final AnchorInfo start;

    /* compiled from: Selection.kt */
    /* loaded from: classes.dex */
    public static final class AnchorInfo {
        public final ResolvedTextDirection direction;
        public final int offset;
        public final long selectableId;

        public AnchorInfo(ResolvedTextDirection direction, int r3, long j) {
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.direction = direction;
            this.offset = r3;
            this.selectableId = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) obj;
            if (this.direction == anchorInfo.direction && this.offset == anchorInfo.offset && this.selectableId == anchorInfo.selectableId) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Long.hashCode(this.selectableId) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.offset, this.direction.hashCode() * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AnchorInfo(direction=");
            sb.append(this.direction);
            sb.append(", offset=");
            sb.append(this.offset);
            sb.append(", selectableId=");
            return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.selectableId, ')');
        }
    }

    public Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z) {
        this.start = anchorInfo;
        this.end = anchorInfo2;
        this.handlesCrossed = z;
    }

    public static Selection copy$default(Selection selection, AnchorInfo start, AnchorInfo end, int r4) {
        boolean z;
        if ((r4 & 1) != 0) {
            start = selection.start;
        }
        if ((r4 & 2) != 0) {
            end = selection.end;
        }
        if ((r4 & 4) != 0) {
            z = selection.handlesCrossed;
        } else {
            z = false;
        }
        selection.getClass();
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new Selection(start, end, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        if (Intrinsics.areEqual(this.start, selection.start) && Intrinsics.areEqual(this.end, selection.end) && this.handlesCrossed == selection.handlesCrossed) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.end.hashCode() + (this.start.hashCode() * 31)) * 31;
        boolean z = this.handlesCrossed;
        int r0 = z;
        if (z != 0) {
            r0 = 1;
        }
        return hashCode + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Selection(start=");
        sb.append(this.start);
        sb.append(", end=");
        sb.append(this.end);
        sb.append(", handlesCrossed=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.handlesCrossed, ')');
    }
}
