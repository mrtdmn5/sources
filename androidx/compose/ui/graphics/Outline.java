package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Outline.kt */
/* loaded from: classes.dex */
public abstract class Outline {

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Generic extends Outline {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Generic)) {
                return false;
            }
            ((Generic) obj).getClass();
            if (Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }
    }

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Rectangle extends Outline {
        public final Rect rect;

        public Rectangle(Rect rect) {
            this.rect = rect;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rectangle)) {
                return false;
            }
            if (Intrinsics.areEqual(this.rect, ((Rectangle) obj).rect)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.rect.hashCode();
        }
    }

    /* compiled from: Outline.kt */
    /* loaded from: classes.dex */
    public static final class Rounded extends Outline {
        public final RoundRect roundRect;
        public final AndroidPath roundRectPath;

        /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0053  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Rounded(androidx.compose.ui.geometry.RoundRect r13) {
            /*
                r12 = this;
                r12.<init>()
                r12.roundRect = r13
                long r0 = r13.bottomLeftCornerRadius
                float r2 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r0)
                long r3 = r13.bottomRightCornerRadius
                float r5 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r3)
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                r5 = 1
                r6 = 0
                if (r2 != 0) goto L19
                r2 = r5
                goto L1a
            L19:
                r2 = r6
            L1a:
                long r7 = r13.topLeftCornerRadius
                long r9 = r13.topRightCornerRadius
                if (r2 == 0) goto L44
                float r2 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r3)
                float r11 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r9)
                int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r2 != 0) goto L2e
                r2 = r5
                goto L2f
            L2e:
                r2 = r6
            L2f:
                if (r2 == 0) goto L44
                float r2 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r9)
                float r11 = androidx.compose.ui.geometry.CornerRadius.m253getXimpl(r7)
                int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r2 != 0) goto L3f
                r2 = r5
                goto L40
            L3f:
                r2 = r6
            L40:
                if (r2 == 0) goto L44
                r2 = r5
                goto L45
            L44:
                r2 = r6
            L45:
                float r0 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r0)
                float r1 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r3)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L53
                r0 = r5
                goto L54
            L53:
                r0 = r6
            L54:
                if (r0 == 0) goto L7a
                float r0 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r3)
                float r1 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r9)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L64
                r0 = r5
                goto L65
            L64:
                r0 = r6
            L65:
                if (r0 == 0) goto L7a
                float r0 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r9)
                float r1 = androidx.compose.ui.geometry.CornerRadius.m254getYimpl(r7)
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L75
                r0 = r5
                goto L76
            L75:
                r0 = r6
            L76:
                if (r0 == 0) goto L7a
                r0 = r5
                goto L7b
            L7a:
                r0 = r6
            L7b:
                if (r2 == 0) goto L80
                if (r0 == 0) goto L80
                goto L81
            L80:
                r5 = r6
            L81:
                if (r5 != 0) goto L8b
                androidx.compose.ui.graphics.AndroidPath r0 = kotlinx.coroutines.selects.OnTimeoutKt.Path()
                r0.addRoundRect(r13)
                goto L8c
            L8b:
                r0 = 0
            L8c:
                r12.roundRectPath = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.Outline.Rounded.<init>(androidx.compose.ui.geometry.RoundRect):void");
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rounded)) {
                return false;
            }
            if (Intrinsics.areEqual(this.roundRect, ((Rounded) obj).roundRect)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.roundRect.hashCode();
        }
    }
}
