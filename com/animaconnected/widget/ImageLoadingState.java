package com.animaconnected.widget;

import android.graphics.Bitmap;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionCard.kt */
/* loaded from: classes3.dex */
public interface ImageLoadingState {

    /* compiled from: SessionCard.kt */
    /* loaded from: classes3.dex */
    public static final class Error implements ImageLoadingState {
        public static final int $stable = 8;
        private final Throwable exception;

        public Error(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Error copy$default(Error error, Throwable th, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                th = error.exception;
            }
            return error.copy(th);
        }

        public final Throwable component1() {
            return this.exception;
        }

        public final Error copy(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Error(exception);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Error) && Intrinsics.areEqual(this.exception, ((Error) obj).exception)) {
                return true;
            }
            return false;
        }

        public final Throwable getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Error(exception=" + this.exception + ')';
        }
    }

    /* compiled from: SessionCard.kt */
    /* loaded from: classes3.dex */
    public static final class Loading implements ImageLoadingState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Loading)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1178084388;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* compiled from: SessionCard.kt */
    /* loaded from: classes3.dex */
    public static final class Success implements ImageLoadingState {
        public static final int $stable = 8;
        private final int circleRadius;
        private final Bitmap image;
        private final long offset;
        private final int zoomLevel;

        public /* synthetic */ Success(Bitmap bitmap, long j, int r4, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, j, r4, r5);
        }

        /* renamed from: copy-ubNVwUQ$default, reason: not valid java name */
        public static /* synthetic */ Success m1607copyubNVwUQ$default(Success success, Bitmap bitmap, long j, int r7, int r8, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                bitmap = success.image;
            }
            if ((r9 & 2) != 0) {
                j = success.offset;
            }
            long j2 = j;
            if ((r9 & 4) != 0) {
                r7 = success.circleRadius;
            }
            int r10 = r7;
            if ((r9 & 8) != 0) {
                r8 = success.zoomLevel;
            }
            return success.m1609copyubNVwUQ(bitmap, j2, r10, r8);
        }

        public final Bitmap component1() {
            return this.image;
        }

        /* renamed from: component2-F1C5BW0, reason: not valid java name */
        public final long m1608component2F1C5BW0() {
            return this.offset;
        }

        public final int component3() {
            return this.circleRadius;
        }

        public final int component4() {
            return this.zoomLevel;
        }

        /* renamed from: copy-ubNVwUQ, reason: not valid java name */
        public final Success m1609copyubNVwUQ(Bitmap image, long j, int r12, int r13) {
            Intrinsics.checkNotNullParameter(image, "image");
            return new Success(image, j, r12, r13, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            if (Intrinsics.areEqual(this.image, success.image) && Offset.m257equalsimpl0(this.offset, success.offset) && this.circleRadius == success.circleRadius && this.zoomLevel == success.zoomLevel) {
                return true;
            }
            return false;
        }

        public final int getCircleRadius() {
            return this.circleRadius;
        }

        public final Bitmap getImage() {
            return this.image;
        }

        /* renamed from: getOffset-F1C5BW0, reason: not valid java name */
        public final long m1610getOffsetF1C5BW0() {
            return this.offset;
        }

        public final int getZoomLevel() {
            return this.zoomLevel;
        }

        public int hashCode() {
            int hashCode = this.image.hashCode() * 31;
            long j = this.offset;
            int r3 = Offset.$r8$clinit;
            return Integer.hashCode(this.zoomLevel) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.circleRadius, Scale$$ExternalSyntheticOutline0.m(j, hashCode, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Success(image=");
            sb.append(this.image);
            sb.append(", offset=");
            sb.append((Object) Offset.m264toStringimpl(this.offset));
            sb.append(", circleRadius=");
            sb.append(this.circleRadius);
            sb.append(", zoomLevel=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.zoomLevel, ')');
        }

        private Success(Bitmap image, long j, int r5, int r6) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
            this.offset = j;
            this.circleRadius = r5;
            this.zoomLevel = r6;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Success(android.graphics.Bitmap r8, long r9, int r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
            /*
                r7 = this;
                r14 = r13 & 2
                if (r14 == 0) goto L8
                int r9 = androidx.compose.ui.geometry.Offset.$r8$clinit
                long r9 = androidx.compose.ui.geometry.Offset.Unspecified
            L8:
                r2 = r9
                r9 = r13 & 4
                r10 = 0
                if (r9 == 0) goto L10
                r4 = r10
                goto L11
            L10:
                r4 = r11
            L11:
                r9 = r13 & 8
                if (r9 == 0) goto L17
                r5 = r10
                goto L18
            L17:
                r5 = r12
            L18:
                r6 = 0
                r0 = r7
                r1 = r8
                r0.<init>(r1, r2, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.ImageLoadingState.Success.<init>(android.graphics.Bitmap, long, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
