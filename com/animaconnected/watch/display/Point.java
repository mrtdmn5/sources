package com.animaconnected.watch.display;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public final class Point {
    public static final Companion Companion = new Companion(null);
    private static final Point Zero = new Point(0, 0);
    private final int x;
    private final int y;

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Point getZero() {
            return Point.Zero;
        }

        private Companion() {
        }
    }

    public Point(int r1, int r2) {
        this.x = r1;
        this.y = r2;
    }

    public static /* synthetic */ Point copy$default(Point point, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = point.x;
        }
        if ((r3 & 2) != 0) {
            r2 = point.y;
        }
        return point.copy(r1, r2);
    }

    public final int component1() {
        return this.x;
    }

    public final int component2() {
        return this.y;
    }

    public final Point copy(int r2, int r3) {
        return new Point(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        return false;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public int hashCode() {
        return Integer.hashCode(this.y) + (Integer.hashCode(this.x) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Point(x=");
        sb.append(this.x);
        sb.append(", y=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.y, ')');
    }
}
