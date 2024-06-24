package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.ModifierNodeElement;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendingPointerInputFilter.kt */
/* loaded from: classes.dex */
public final class SuspendPointerInputElement extends ModifierNodeElement<SuspendingPointerInputModifierNodeImpl> {
    public final Object key1;
    public final Object key2;
    public final Object[] keys;
    public final Function2<PointerInputScope, Continuation<? super Unit>, Object> pointerInputHandler;

    public SuspendPointerInputElement() {
        throw null;
    }

    public SuspendPointerInputElement(Object obj, Object[] objArr, Function2 pointerInputHandler, int r6) {
        obj = (r6 & 1) != 0 ? null : obj;
        objArr = (r6 & 4) != 0 ? null : objArr;
        Intrinsics.checkNotNullParameter(pointerInputHandler, "pointerInputHandler");
        this.key1 = obj;
        this.key2 = null;
        this.keys = objArr;
        this.pointerInputHandler = pointerInputHandler;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final SuspendingPointerInputModifierNodeImpl create() {
        return new SuspendingPointerInputModifierNodeImpl(this.pointerInputHandler);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        if (!Intrinsics.areEqual(this.key1, suspendPointerInputElement.key1) || !Intrinsics.areEqual(this.key2, suspendPointerInputElement.key2)) {
            return false;
        }
        Object[] objArr = this.keys;
        if (objArr != null) {
            Object[] objArr2 = suspendPointerInputElement.keys;
            if (objArr2 == null || !Arrays.equals(objArr, objArr2)) {
                return false;
            }
        } else if (suspendPointerInputElement.keys != null) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r1;
        int r2;
        int r0 = 0;
        Object obj = this.key1;
        if (obj != null) {
            r1 = obj.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        Object obj2 = this.key2;
        if (obj2 != null) {
            r2 = obj2.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Object[] objArr = this.keys;
        if (objArr != null) {
            r0 = Arrays.hashCode(objArr);
        }
        return r13 + r0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl) {
        SuspendingPointerInputModifierNodeImpl node = suspendingPointerInputModifierNodeImpl;
        Intrinsics.checkNotNullParameter(node, "node");
        Function2<PointerInputScope, Continuation<? super Unit>, Object> value = this.pointerInputHandler;
        Intrinsics.checkNotNullParameter(value, "value");
        node.resetPointerInputHandler();
        node.pointerInputHandler = value;
    }
}
