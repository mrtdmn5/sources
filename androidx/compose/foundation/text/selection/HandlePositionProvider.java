package androidx.compose.foundation.text.selection;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSelectionHandles.android.kt */
/* loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    public final HandleReferencePoint handleReferencePoint;
    public final long offset;

    /* compiled from: AndroidSelectionHandles.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[HandleReferencePoint.values().length];
            try {
                r0[HandleReferencePoint.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[HandleReferencePoint.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j) {
        Intrinsics.checkNotNullParameter(handleReferencePoint, "handleReferencePoint");
        this.handleReferencePoint = handleReferencePoint;
        this.offset = j;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public final long mo133calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int r7 = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        long j3 = this.offset;
        int r2 = intRect.top;
        int r6 = intRect.left;
        if (r7 != 1) {
            if (r7 != 2) {
                if (r7 == 3) {
                    int r72 = IntOffset.$r8$clinit;
                    return IntOffsetKt.IntOffset((r6 + ((int) (j3 >> 32))) - (((int) (j2 >> 32)) / 2), IntOffset.m590getYimpl(j3) + r2);
                }
                throw new NoWhenBranchMatchedException();
            }
            return IntOffsetKt.IntOffset((r6 + ((int) (j3 >> 32))) - ((int) (j2 >> 32)), IntOffset.m590getYimpl(j3) + r2);
        }
        return IntOffsetKt.IntOffset(r6 + ((int) (j3 >> 32)), IntOffset.m590getYimpl(j3) + r2);
    }
}
