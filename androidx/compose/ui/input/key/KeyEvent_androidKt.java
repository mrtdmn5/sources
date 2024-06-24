package androidx.compose.ui.input.key;

import com.google.android.material.shape.ShapePath;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyEvent.android.kt */
/* loaded from: classes.dex */
public class KeyEvent_androidKt {
    /* renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m399getKeyZmokQxo(android.view.KeyEvent key) {
        Intrinsics.checkNotNullParameter(key, "$this$key");
        return Key_androidKt.Key(key.getKeyCode());
    }

    /* renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m400getTypeZmokQxo(android.view.KeyEvent type) {
        Intrinsics.checkNotNullParameter(type, "$this$type");
        int action = type.getAction();
        if (action != 0) {
            if (action == 1) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        throw null;
    }
}
