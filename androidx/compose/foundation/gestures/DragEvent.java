package androidx.compose.foundation.gestures;

/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public abstract class DragEvent {

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragCancelled extends DragEvent {
        public static final DragCancelled INSTANCE = new DragCancelled();
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragDelta extends DragEvent {
        public final long delta;

        public DragDelta(long j) {
            this.delta = j;
        }
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragStarted extends DragEvent {
        public final long startPoint;

        public DragStarted(long j) {
            this.startPoint = j;
        }
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragStopped extends DragEvent {
        public final long velocity;

        public DragStopped(long j) {
            this.velocity = j;
        }
    }
}
