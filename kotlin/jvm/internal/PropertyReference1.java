package kotlin.jvm.internal;

import androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* loaded from: classes.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1(Object obj) {
        super(obj, KeyEvent_androidKt.class, "isCtrlPressed", "isCtrlPressed-ZmokQxo(Landroid/view/KeyEvent;)Z", 1);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.factory.getClass();
        return this;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((KeyMappingKt$defaultKeyMapping$1) this).get(obj);
    }
}
