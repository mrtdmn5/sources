package androidx.compose.ui.input.pointer;

import androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;

/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public interface AwaitPointerEventScope extends Density {
    Object awaitPointerEvent(PointerEventPass pointerEventPass, BaseContinuationImpl baseContinuationImpl);

    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    default long mo406getExtendedTouchPaddingNHjbRc() {
        int r0 = Size.$r8$clinit;
        return Size.Zero;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo407getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    default <T> Object withTimeout(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return function2.invoke(this, continuation);
    }

    default Object withTimeoutOrNull(long j, TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2, Continuation continuation) {
        return tapGestureDetectorKt$awaitSecondDown$2.invoke(this, continuation);
    }
}
