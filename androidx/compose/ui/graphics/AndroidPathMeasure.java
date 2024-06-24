package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPathMeasure.android.kt */
/* loaded from: classes.dex */
public final class AndroidPathMeasure implements PathMeasure {
    public final android.graphics.PathMeasure internalPathMeasure;

    public AndroidPathMeasure(android.graphics.PathMeasure pathMeasure) {
        this.internalPathMeasure = pathMeasure;
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final float getLength() {
        return this.internalPathMeasure.getLength();
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final boolean getSegment(float f, float f2, Path destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof AndroidPath) {
            return this.internalPathMeasure.getSegment(f, f2, ((AndroidPath) destination).internalPath, true);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.PathMeasure
    public final void setPath(Path path) {
        android.graphics.Path path2;
        if (path != null) {
            if (path instanceof AndroidPath) {
                path2 = ((AndroidPath) path).internalPath;
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            path2 = null;
        }
        this.internalPathMeasure.setPath(path2, false);
    }
}
