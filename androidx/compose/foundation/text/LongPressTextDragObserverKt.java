package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1;
import androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LongPressTextDragObserver.kt */
/* loaded from: classes.dex */
public final class LongPressTextDragObserverKt {
    public static final Object detectDownAndDragGesturesWithObserver(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new LongPressTextDragObserverKt$detectDownAndDragGesturesWithObserver$2(pointerInputScope, textDragObserver, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public static final Object detectDragGesturesAfterLongPressWithObserver(PointerInputScope pointerInputScope, final TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Offset offset) {
                TextDragObserver.this.mo120onStartk4lQ0M(offset.packedValue);
                return Unit.INSTANCE;
            }
        };
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                TextDragObserver.this.onStop();
                return Unit.INSTANCE;
            }
        };
        Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                TextDragObserver.this.onCancel();
                return Unit.INSTANCE;
            }
        };
        Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                long j = offset.packedValue;
                Intrinsics.checkNotNullParameter(pointerInputChange, "<anonymous parameter 0>");
                TextDragObserver.this.mo119onDragk4lQ0M(j);
                return Unit.INSTANCE;
            }
        };
        DragGestureDetectorKt$HorizontalPointerDirectionConfig$1 dragGestureDetectorKt$HorizontalPointerDirectionConfig$1 = DragGestureDetectorKt.HorizontalPointerDirectionConfig;
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(null, function0, function02, function1, function2), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (awaitEachGesture != coroutineSingletons) {
            awaitEachGesture = Unit.INSTANCE;
        }
        if (awaitEachGesture == coroutineSingletons) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }
}
