package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidView.android.kt */
/* loaded from: classes.dex */
public final class AndroidView_androidKt$NoOpUpdate$1 extends Lambda implements Function1<View, Unit> {
    public static final AndroidView_androidKt$NoOpUpdate$1 INSTANCE = new AndroidView_androidKt$NoOpUpdate$1();

    public AndroidView_androidKt$NoOpUpdate$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$null");
        return Unit.INSTANCE;
    }
}
