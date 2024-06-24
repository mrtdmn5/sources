package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public abstract class CrossAxisAlignment {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: RowColumnImpl.kt */
    /* loaded from: classes.dex */
    public static final class CenterCrossAxisAlignment extends CrossAxisAlignment {
        public static final /* synthetic */ int $r8$clinit = 0;

        static {
            new CenterCrossAxisAlignment();
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final int align$foundation_layout_release(int r1, LayoutDirection layoutDirection, Placeable placeable) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return r1 / 2;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    /* loaded from: classes.dex */
    public static final class EndCrossAxisAlignment extends CrossAxisAlignment {
        public static final /* synthetic */ int $r8$clinit = 0;

        static {
            new EndCrossAxisAlignment();
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final int align$foundation_layout_release(int r1, LayoutDirection layoutDirection, Placeable placeable) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            if (layoutDirection != LayoutDirection.Ltr) {
                return 0;
            }
            return r1;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    /* loaded from: classes.dex */
    public static final class HorizontalCrossAxisAlignment extends CrossAxisAlignment {
        public final Alignment.Horizontal horizontal;

        public HorizontalCrossAxisAlignment(Alignment.Horizontal horizontal) {
            Intrinsics.checkNotNullParameter(horizontal, "horizontal");
            this.horizontal = horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final int align$foundation_layout_release(int r2, LayoutDirection layoutDirection, Placeable placeable) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.horizontal.align(0, r2, layoutDirection);
        }
    }

    /* compiled from: RowColumnImpl.kt */
    /* loaded from: classes.dex */
    public static final class StartCrossAxisAlignment extends CrossAxisAlignment {
        public static final /* synthetic */ int $r8$clinit = 0;

        static {
            new StartCrossAxisAlignment();
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final int align$foundation_layout_release(int r1, LayoutDirection layoutDirection, Placeable placeable) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            if (layoutDirection == LayoutDirection.Ltr) {
                return 0;
            }
            return r1;
        }
    }

    /* compiled from: RowColumnImpl.kt */
    /* loaded from: classes.dex */
    public static final class VerticalCrossAxisAlignment extends CrossAxisAlignment {
        public final Alignment.Vertical vertical;

        public VerticalCrossAxisAlignment(Alignment.Vertical vertical) {
            Intrinsics.checkNotNullParameter(vertical, "vertical");
            this.vertical = vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final int align$foundation_layout_release(int r1, LayoutDirection layoutDirection, Placeable placeable) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.vertical.align(0, r1);
        }
    }

    static {
        int r0 = CenterCrossAxisAlignment.$r8$clinit;
        int r02 = StartCrossAxisAlignment.$r8$clinit;
        int r03 = EndCrossAxisAlignment.$r8$clinit;
    }

    public abstract int align$foundation_layout_release(int r1, LayoutDirection layoutDirection, Placeable placeable);
}
