package androidx.compose.ui.graphics;

/* compiled from: PathMeasure.kt */
/* loaded from: classes.dex */
public interface PathMeasure {
    float getLength();

    boolean getSegment(float f, float f2, Path path);

    void setPath(Path path);
}
