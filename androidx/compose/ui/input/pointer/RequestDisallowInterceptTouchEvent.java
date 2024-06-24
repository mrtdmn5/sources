package androidx.compose.ui.input.pointer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: PointerInteropFilter.android.kt */
/* loaded from: classes.dex */
public final class RequestDisallowInterceptTouchEvent implements Function1<Boolean, Unit> {
    public PointerInteropFilter pointerInteropFilter;

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        PointerInteropFilter pointerInteropFilter = this.pointerInteropFilter;
        if (pointerInteropFilter != null) {
            pointerInteropFilter.disallowIntercept = booleanValue;
        }
        return Unit.INSTANCE;
    }
}
