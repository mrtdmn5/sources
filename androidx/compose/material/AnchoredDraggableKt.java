package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {
    public static final Object access$closestAnchor(Map map, float f, boolean z) {
        float f2;
        float f3;
        if (!map.isEmpty()) {
            Iterator it = map.entrySet().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    float floatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    if (z) {
                        f2 = floatValue - f;
                    } else {
                        f2 = f - floatValue;
                    }
                    if (f2 < 0.0f) {
                        f2 = Float.POSITIVE_INFINITY;
                    }
                    do {
                        Object next2 = it.next();
                        float floatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                        if (z) {
                            f3 = floatValue2 - f;
                        } else {
                            f3 = f - floatValue2;
                        }
                        if (f3 < 0.0f) {
                            f3 = Float.POSITIVE_INFINITY;
                        }
                        if (Float.compare(f2, f3) > 0) {
                            next = next2;
                            f2 = f3;
                        }
                    } while (it.hasNext());
                }
                return ((Map.Entry) next).getKey();
            }
            throw new NoSuchElementException();
        }
        throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
    }

    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> state, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        boolean z3;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        AnchoredDraggableState$draggableState$1 anchoredDraggableState$draggableState$1 = state.draggableState;
        if (state.animationTarget$delegate.getValue() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        return DraggableKt.draggable$default(modifier, anchoredDraggableState$draggableState$1, orientation, z, mutableInteractionSource, z3, new AnchoredDraggableKt$anchoredDraggable$1(state, null), z2);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, boolean z2, int r11) {
        if ((r11 & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((r11 & 8) != 0) {
            z2 = false;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z3, z2, null);
    }

    public static final Object animateTo(float f, AnchoredDraggableState anchoredDraggableState, Object obj, Continuation continuation) {
        AnchoredDraggableKt$animateTo$2 anchoredDraggableKt$animateTo$2 = new AnchoredDraggableKt$animateTo$2(f, anchoredDraggableState, obj, null);
        MutatePriority mutatePriority = MutatePriority.Default;
        anchoredDraggableState.getClass();
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(obj, anchoredDraggableState, mutatePriority, anchoredDraggableKt$animateTo$2, null), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (coroutineScope != coroutineSingletons) {
            coroutineScope = Unit.INSTANCE;
        }
        if (coroutineScope != coroutineSingletons) {
            coroutineScope = Unit.INSTANCE;
        }
        if (coroutineScope == coroutineSingletons) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
