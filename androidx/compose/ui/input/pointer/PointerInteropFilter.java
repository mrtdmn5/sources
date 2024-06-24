package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;

/* compiled from: PointerInteropFilter.android.kt */
/* loaded from: classes.dex */
public final class PointerInteropFilter implements PointerInputModifier {
    public boolean disallowIntercept;
    public Function1<? super MotionEvent, Boolean> onTouchEvent;
    public final PointerInteropFilter$pointerInputFilter$1 pointerInputFilter = new PointerInteropFilter$pointerInputFilter$1(this);
    public RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent;

    /* compiled from: PointerInteropFilter.android.kt */
    /* loaded from: classes.dex */
    public enum DispatchToViewState {
        Unknown,
        Dispatching,
        NotDispatching
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public final PointerInteropFilter$pointerInputFilter$1 getPointerInputFilter() {
        return this.pointerInputFilter;
    }
}
