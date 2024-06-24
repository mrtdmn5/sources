package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.unit.Density;

/* compiled from: PlatformMagnifier.kt */
/* loaded from: classes.dex */
public interface PlatformMagnifierFactory {
    PlatformMagnifier create(MagnifierStyle magnifierStyle, View view, Density density, float f);

    boolean getCanUpdateZoom();
}
