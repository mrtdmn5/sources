package androidx.compose.ui;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;

/* compiled from: Alignment.kt */
/* loaded from: classes.dex */
public interface Alignment {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: Alignment.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final BiasAlignment TopStart = new BiasAlignment(-1.0f, -1.0f);
        public static final BiasAlignment TopCenter = new BiasAlignment(0.0f, -1.0f);
        public static final BiasAlignment CenterStart = new BiasAlignment(-1.0f, 0.0f);
        public static final BiasAlignment Center = new BiasAlignment(0.0f, 0.0f);
        public static final BiasAlignment CenterEnd = new BiasAlignment(1.0f, 0.0f);
        public static final BiasAlignment BottomCenter = new BiasAlignment(0.0f, 1.0f);
        public static final BiasAlignment BottomEnd = new BiasAlignment(1.0f, 1.0f);
        public static final BiasAlignment.Vertical Top = new BiasAlignment.Vertical(-1.0f);
        public static final BiasAlignment.Vertical CenterVertically = new BiasAlignment.Vertical(0.0f);
        public static final BiasAlignment.Vertical Bottom = new BiasAlignment.Vertical(1.0f);
        public static final BiasAlignment.Horizontal Start = new BiasAlignment.Horizontal(-1.0f);
        public static final BiasAlignment.Horizontal CenterHorizontally = new BiasAlignment.Horizontal(0.0f);
        public static final BiasAlignment.Horizontal End = new BiasAlignment.Horizontal(1.0f);
    }

    /* compiled from: Alignment.kt */
    /* loaded from: classes.dex */
    public interface Horizontal {
        int align(int r1, int r2, LayoutDirection layoutDirection);
    }

    /* compiled from: Alignment.kt */
    /* loaded from: classes.dex */
    public interface Vertical {
        int align(int r1, int r2);
    }

    /* renamed from: align-KFBX0sM, reason: not valid java name */
    long mo229alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection);
}
