package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public final class SuspendingPointerInputFilterKt {
    public static final PointerEvent EmptyPointerEvent = new PointerEvent(EmptyList.INSTANCE);

    public static final Modifier pointerInput(Modifier modifier, Object obj, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return modifier.then(new SuspendPointerInputElement(obj, null, block, 6));
    }
}
