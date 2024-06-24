package androidx.compose.ui.res;

import android.content.Context;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorResources.android.kt */
/* loaded from: classes.dex */
public final class ColorResourceHelper {
    public static final ColorResourceHelper INSTANCE = new ColorResourceHelper();

    /* renamed from: getColor-WaAFU9c, reason: not valid java name */
    public final long m504getColorWaAFU9c(Context context, int r3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ColorKt.Color(context.getResources().getColor(r3, context.getTheme()));
    }
}
