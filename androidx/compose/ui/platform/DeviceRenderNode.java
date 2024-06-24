package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DeviceRenderNode.android.kt */
/* loaded from: classes.dex */
public interface DeviceRenderNode {
    void discardDisplayList();

    void drawInto(Canvas canvas);

    float getAlpha();

    int getBottom();

    boolean getClipToBounds();

    boolean getClipToOutline();

    float getElevation();

    boolean getHasDisplayList();

    int getHeight();

    int getLeft();

    void getMatrix(Matrix matrix);

    int getRight();

    int getTop();

    int getWidth();

    void offsetLeftAndRight(int r1);

    void offsetTopAndBottom(int r1);

    void record(CanvasHolder canvasHolder, Path path, Function1<? super androidx.compose.ui.graphics.Canvas, Unit> function1);

    void setAlpha(float f);

    void setAmbientShadowColor(int r1);

    void setCameraDistance(float f);

    void setClipToBounds(boolean z);

    void setClipToOutline(boolean z);

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo497setCompositingStrategyaDBOjCE(int r1);

    void setElevation(float f);

    boolean setHasOverlappingRendering();

    void setOutline(Outline outline);

    void setPivotX(float f);

    void setPivotY(float f);

    boolean setPosition(int r1, int r2, int r3, int r4);

    void setRenderEffect();

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setSpotShadowColor(int r1);

    void setTranslationX(float f);

    void setTranslationY(float f);
}
