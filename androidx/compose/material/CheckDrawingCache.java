package androidx.compose.material;

import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: Checkbox.kt */
/* loaded from: classes.dex */
public final class CheckDrawingCache {
    public final Path checkPath;
    public final PathMeasure pathMeasure;
    public final Path pathToDraw;

    public CheckDrawingCache() {
        this(0);
    }

    public CheckDrawingCache(int r3) {
        AndroidPath Path = OnTimeoutKt.Path();
        AndroidPathMeasure androidPathMeasure = new AndroidPathMeasure(new android.graphics.PathMeasure());
        AndroidPath Path2 = OnTimeoutKt.Path();
        this.checkPath = Path;
        this.pathMeasure = androidPathMeasure;
        this.pathToDraw = Path2;
    }
}
