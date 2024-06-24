package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.gestures.DraggableNode$pointerInputNode$1;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;

/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02e7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ef  */
    /* JADX WARN: Type inference failed for: r8v19, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0216 -> B:24:0x0186). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0277 -> B:13:0x0285). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x02e9 -> B:23:0x02f0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable access$awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, androidx.compose.foundation.gestures.DraggableNode$_canDrag$1 r19, androidx.compose.foundation.gestures.DraggableNode$_startDragImmediately$1 r20, androidx.compose.ui.input.pointer.util.VelocityTracker r21, androidx.compose.foundation.gestures.Orientation r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.access$awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.DraggableNode$_canDrag$1, androidx.compose.foundation.gestures.DraggableNode$_startDragImmediately$1, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, kotlin.coroutines.Continuation):java.io.Serializable");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2] */
    /* renamed from: access$awaitDrag-Su4bsnU */
    public static final Object m42access$awaitDragSu4bsnU(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, long j, final VelocityTracker velocityTracker, final BufferedChannel bufferedChannel, final boolean z, Orientation orientation, DraggableNode$pointerInputNode$1.AnonymousClass1.AnonymousClass2 anonymousClass2) {
        float signum = Math.signum(Offset.m259getXimpl(pointerInputChange.position));
        long j2 = pointerInputChange.position;
        bufferedChannel.mo1701trySendJP2dKIU(new DragEvent.DragStarted(Offset.m261minusMKHz9U(j2, OffsetKt.Offset(Offset.m259getXimpl(j) * signum, Offset.m260getYimpl(j) * Math.signum(Offset.m260getYimpl(j2))))));
        if (z) {
            j = Offset.m263timestuRUvjQ(-1.0f, j);
        }
        bufferedChannel.mo1701trySendJP2dKIU(new DragEvent.DragDelta(j));
        return m43onDragOrUpAxegvzg(awaitPointerEventScope, orientation, pointerInputChange.id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PointerInputChange pointerInputChange2) {
                PointerInputChange event = pointerInputChange2;
                Intrinsics.checkNotNullParameter(event, "event");
                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, event);
                if (!PointerEventKt.changedToUpIgnoreConsumed(event)) {
                    long positionChangeInternal = PointerEventKt.positionChangeInternal(event, false);
                    event.consume();
                    if (z) {
                        positionChangeInternal = Offset.m263timestuRUvjQ(-1.0f, positionChangeInternal);
                    }
                    bufferedChannel.mo1701trySendJP2dKIU(new DragEvent.DragDelta(positionChangeInternal));
                }
                return Unit.INSTANCE;
            }
        }, anonymousClass2);
    }

    public static Modifier draggable$default(Modifier modifier, DraggableState state, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, final boolean z2, Function3 onDragStopped, boolean z3) {
        DraggableKt$draggable$1 draggableKt$draggable$1 = new DraggableKt$draggable$1(null);
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return modifier.then(new DraggableElement(state, new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange pointerInputChange) {
                PointerInputChange it = pointerInputChange;
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        }, orientation, z, mutableInteractionSource, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(z2);
            }
        }, draggableKt$draggable$1, new DraggableKt$draggable$5(onDragStopped, orientation, null), z3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fd, code lost:            if ((!r15) != false) goto L135;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:55:0x00e7, B:42:0x00c2], limit reached: 74 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0088 -> B:10:0x008d). Please report as a decompilation issue!!! */
    /* renamed from: onDragOrUp-Axegvzg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m43onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, androidx.compose.foundation.gestures.Orientation r18, long r19, androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2 r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m43onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.Orientation, long, androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
