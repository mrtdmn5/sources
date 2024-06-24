package androidx.compose.foundation.text;

import android.view.KeyEvent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: KeyMapping.kt */
/* loaded from: classes.dex */
public /* synthetic */ class KeyMappingKt$defaultKeyMapping$1 extends PropertyReference1Impl {
    public static final KeyMappingKt$defaultKeyMapping$1 INSTANCE = new KeyMappingKt$defaultKeyMapping$1();

    @Override // kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        KeyEvent isCtrlPressed = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
        Intrinsics.checkNotNullParameter(isCtrlPressed, "$this$isCtrlPressed");
        return Boolean.valueOf(isCtrlPressed.isCtrlPressed());
    }
}
