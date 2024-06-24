package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.PointF;
import com.animaconnected.watch.display.RectF;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: TouchListener.kt */
/* loaded from: classes3.dex */
public final class TouchListener {
    private Event currentEvent;
    private int dataIndex;
    private final float dragDistanceThreshold;
    private final Function0<Unit> invalidate;
    private float lastX;
    private float lastY;
    private final Function0<RectF> mainDrawingZone;
    private final Function0<Unit> markerAppeared;
    private final Function0<Unit> playHapticFeedback;
    private Event previousEvent;
    private final Function0<Boolean> showNoDataText;
    private PointF touchPoint;
    private float xDistance;
    private float yDistance;

    /* compiled from: TouchListener.kt */
    /* loaded from: classes3.dex */
    public interface Event {

        /* compiled from: TouchListener.kt */
        /* loaded from: classes3.dex */
        public static final class Begin implements Event {
            private final PointF point;

            public Begin(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                this.point = point;
            }

            public static /* synthetic */ Begin copy$default(Begin begin, PointF pointF, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    pointF = begin.point;
                }
                return begin.copy(pointF);
            }

            public final PointF component1() {
                return this.point;
            }

            public final Begin copy(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                return new Begin(point);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Begin) && Intrinsics.areEqual(this.point, ((Begin) obj).point)) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.TouchListener.Event
            public PointF getPoint() {
                return this.point;
            }

            public int hashCode() {
                return this.point.hashCode();
            }

            public String toString() {
                return "Begin(point=" + this.point + ')';
            }
        }

        /* compiled from: TouchListener.kt */
        /* loaded from: classes3.dex */
        public static final class Changed implements Event {
            private final PointF point;

            public Changed(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                this.point = point;
            }

            public static /* synthetic */ Changed copy$default(Changed changed, PointF pointF, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    pointF = changed.point;
                }
                return changed.copy(pointF);
            }

            public final PointF component1() {
                return this.point;
            }

            public final Changed copy(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                return new Changed(point);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Changed) && Intrinsics.areEqual(this.point, ((Changed) obj).point)) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.TouchListener.Event
            public PointF getPoint() {
                return this.point;
            }

            public int hashCode() {
                return this.point.hashCode();
            }

            public String toString() {
                return "Changed(point=" + this.point + ')';
            }
        }

        /* compiled from: TouchListener.kt */
        /* loaded from: classes3.dex */
        public static final class End implements Event {
            private final PointF point;

            public End(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                this.point = point;
            }

            public static /* synthetic */ End copy$default(End end, PointF pointF, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    pointF = end.point;
                }
                return end.copy(pointF);
            }

            public final PointF component1() {
                return this.point;
            }

            public final End copy(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                return new End(point);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof End) && Intrinsics.areEqual(this.point, ((End) obj).point)) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.TouchListener.Event
            public PointF getPoint() {
                return this.point;
            }

            public int hashCode() {
                return this.point.hashCode();
            }

            public String toString() {
                return "End(point=" + this.point + ')';
            }
        }

        /* compiled from: TouchListener.kt */
        /* loaded from: classes3.dex */
        public static final class Idle implements Event {
            private final PointF point;

            public Idle() {
                this(null, 1, null);
            }

            public static /* synthetic */ Idle copy$default(Idle idle, PointF pointF, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    pointF = idle.point;
                }
                return idle.copy(pointF);
            }

            public final PointF component1() {
                return this.point;
            }

            public final Idle copy(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                return new Idle(point);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof Idle) && Intrinsics.areEqual(this.point, ((Idle) obj).point)) {
                    return true;
                }
                return false;
            }

            @Override // com.animaconnected.watch.graphs.TouchListener.Event
            public PointF getPoint() {
                return this.point;
            }

            public int hashCode() {
                return this.point.hashCode();
            }

            public String toString() {
                return "Idle(point=" + this.point + ')';
            }

            public Idle(PointF point) {
                Intrinsics.checkNotNullParameter(point, "point");
                this.point = point;
            }

            public /* synthetic */ Idle(PointF pointF, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? PointF.Companion.getZero() : pointF);
            }
        }

        PointF getPoint();
    }

    public TouchListener(Function0<RectF> mainDrawingZone, Function0<Unit> invalidate, Function0<Boolean> showNoDataText, Function0<Unit> playHapticFeedback, Function0<Unit> markerAppeared) {
        Intrinsics.checkNotNullParameter(mainDrawingZone, "mainDrawingZone");
        Intrinsics.checkNotNullParameter(invalidate, "invalidate");
        Intrinsics.checkNotNullParameter(showNoDataText, "showNoDataText");
        Intrinsics.checkNotNullParameter(playHapticFeedback, "playHapticFeedback");
        Intrinsics.checkNotNullParameter(markerAppeared, "markerAppeared");
        this.mainDrawingZone = mainDrawingZone;
        this.invalidate = invalidate;
        this.showNoDataText = showNoDataText;
        this.playHapticFeedback = playHapticFeedback;
        this.markerAppeared = markerAppeared;
        this.previousEvent = new Event.Idle(null, 1, null);
        this.currentEvent = new Event.Idle(null, 1, null);
        this.dataIndex = -1;
        this.touchPoint = PointF.Companion.getZero();
        this.dragDistanceThreshold = 4.0f;
    }

    public static /* synthetic */ void hideMarker$graphics_release$default(TouchListener touchListener, MarkerView markerView, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        touchListener.hideMarker$graphics_release(markerView, z);
    }

    private final PointF restrictToChartZone(PointF pointF) {
        return new PointF(RangesKt___RangesKt.coerceIn(pointF.getX(), 0.0f, this.mainDrawingZone.invoke().getRight()), RangesKt___RangesKt.coerceIn(pointF.getY(), 0.0f, this.mainDrawingZone.invoke().getBottom()));
    }

    public final Event getCurrentEvent() {
        return this.currentEvent;
    }

    public final PointF getTouchPoint$graphics_release() {
        return this.touchPoint;
    }

    public final float getXDistance$graphics_release() {
        return this.xDistance;
    }

    public final float getYDistance$graphics_release() {
        return this.yDistance;
    }

    public final void hideMarker$graphics_release(MarkerView markerView, boolean z) {
        Intrinsics.checkNotNullParameter(markerView, "markerView");
        this.touchPoint = null;
        this.dataIndex = -1;
        if (MarkerViewKt.resetPosition(markerView) && z) {
            this.invalidate.invoke();
        }
    }

    public final boolean onTouch$graphics_release(Event event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        this.previousEvent = this.currentEvent;
        this.currentEvent = event;
        boolean z2 = event instanceof Event.Changed;
        if (!z2) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
        }
        boolean z3 = true;
        if (event instanceof Event.Begin) {
            z = true;
        } else {
            z = event instanceof Event.Idle;
        }
        if (!z) {
            if (z2) {
                this.xDistance = Math.abs(event.getPoint().getX() - this.lastX) + this.xDistance;
                this.yDistance = Math.abs(event.getPoint().getY() - this.lastY) + this.yDistance;
                if (this.xDistance > this.dragDistanceThreshold) {
                    this.touchPoint = restrictToChartZone(event.getPoint());
                    this.invalidate.invoke();
                } else {
                    this.currentEvent = this.previousEvent;
                    z3 = false;
                }
            } else if (event instanceof Event.End) {
                this.touchPoint = restrictToChartZone(event.getPoint());
                this.invalidate.invoke();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.lastX = event.getPoint().getX();
        this.lastY = event.getPoint().getY();
        return z3;
    }

    public final void onTouchSelectedData$graphics_release(int r3) {
        if (this.dataIndex != r3) {
            this.playHapticFeedback.invoke();
            if (this.dataIndex == -1) {
                this.markerAppeared.invoke();
            }
            this.dataIndex = r3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:            if (r4 == false) goto L62;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean resetMarker$graphics_release(com.animaconnected.watch.graphs.MarkerView r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != 0) goto L4
            return r0
        L4:
            com.animaconnected.watch.graphs.TouchListener$Event r1 = r6.currentEvent
            boolean r2 = r1 instanceof com.animaconnected.watch.graphs.TouchListener.Event.Changed
            boolean r1 = r1 instanceof com.animaconnected.watch.graphs.TouchListener.Event.End
            r3 = 0
            if (r1 == 0) goto L15
            com.animaconnected.watch.graphs.TouchListener$Event r1 = r6.previousEvent
            boolean r1 = r1 instanceof com.animaconnected.watch.graphs.TouchListener.Event.Changed
            if (r1 == 0) goto L15
            r1 = r0
            goto L16
        L15:
            r1 = r3
        L16:
            com.animaconnected.watch.display.PointF r4 = r6.touchPoint
            if (r4 == 0) goto L23
            com.animaconnected.watch.display.RectF r5 = r7.getBounds()
            boolean r4 = r5.contains(r4)
            goto L24
        L23:
            r4 = r3
        L24:
            kotlin.jvm.functions.Function0<java.lang.Boolean> r5 = r6.showNoDataText
            java.lang.Object r5 = r5.invoke()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L33
            goto L4c
        L33:
            if (r2 != 0) goto L4b
            if (r1 == 0) goto L38
            goto L4b
        L38:
            com.animaconnected.watch.display.PointF r1 = r6.touchPoint
            if (r1 == 0) goto L41
            float r1 = r1.getX()
            goto L43
        L41:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L43:
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L4c
            if (r4 == 0) goto L4b
            goto L4c
        L4b:
            r0 = r3
        L4c:
            if (r0 == 0) goto L53
            r1 = 2
            r2 = 0
            hideMarker$graphics_release$default(r6, r7, r3, r1, r2)
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.TouchListener.resetMarker$graphics_release(com.animaconnected.watch.graphs.MarkerView):boolean");
    }
}
