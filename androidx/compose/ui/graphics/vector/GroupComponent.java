package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public final class GroupComponent extends VNode {
    public final ArrayList children = new ArrayList();
    public AndroidPath clipPath;
    public List<? extends PathNode> clipPathData;
    public float[] groupMatrix;
    public Function0<Unit> invalidateListener;
    public boolean isClipPathDirty;
    public boolean isMatrixDirty;
    public String name;
    public float pivotX;
    public float pivotY;
    public float rotation;
    public float scaleX;
    public float scaleY;
    public float translationX;
    public float translationY;

    public GroupComponent() {
        int r0 = VectorKt.$r8$clinit;
        this.clipPathData = EmptyList.INSTANCE;
        this.isClipPathDirty = true;
        this.name = "";
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isMatrixDirty) {
            float[] fArr = this.groupMatrix;
            if (fArr == null) {
                fArr = Matrix.m337constructorimpl$default();
                this.groupMatrix = fArr;
            } else {
                Matrix.m340resetimpl(fArr);
            }
            Matrix.m341translateimpl$default(fArr, this.pivotX + this.translationX, this.pivotY + this.translationY);
            double d = (this.rotation * 3.141592653589793d) / 180.0d;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f = fArr[0];
            float f2 = fArr[4];
            float f3 = (sin * f2) + (cos * f);
            float f4 = -sin;
            float f5 = (f2 * cos) + (f * f4);
            float f6 = fArr[1];
            float f7 = fArr[5];
            float f8 = (sin * f7) + (cos * f6);
            float f9 = (f7 * cos) + (f6 * f4);
            float f10 = fArr[2];
            float f11 = fArr[6];
            float f12 = (sin * f11) + (cos * f10);
            float f13 = (f11 * cos) + (f10 * f4);
            float f14 = fArr[3];
            float f15 = fArr[7];
            float f16 = (sin * f15) + (cos * f14);
            float f17 = (cos * f15) + (f4 * f14);
            fArr[0] = f3;
            fArr[1] = f8;
            fArr[2] = f12;
            fArr[3] = f16;
            fArr[4] = f5;
            fArr[5] = f9;
            fArr[6] = f13;
            fArr[7] = f17;
            float f18 = this.scaleX;
            float f19 = this.scaleY;
            fArr[0] = f3 * f18;
            fArr[1] = f8 * f18;
            fArr[2] = f12 * f18;
            fArr[3] = f16 * f18;
            fArr[4] = f5 * f19;
            fArr[5] = f9 * f19;
            fArr[6] = f13 * f19;
            fArr[7] = f17 * f19;
            fArr[8] = fArr[8] * 1.0f;
            fArr[9] = fArr[9] * 1.0f;
            fArr[10] = fArr[10] * 1.0f;
            fArr[11] = fArr[11] * 1.0f;
            Matrix.m341translateimpl$default(fArr, -this.pivotX, -this.pivotY);
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            if (!this.clipPathData.isEmpty()) {
                AndroidPath androidPath = this.clipPath;
                if (androidPath == null) {
                    androidPath = OnTimeoutKt.Path();
                    this.clipPath = androidPath;
                }
                PathParserKt.toPath(this.clipPathData, androidPath);
            }
            this.isClipPathDirty = false;
        }
        CanvasDrawScope$drawContext$1 drawContext = drawScope.getDrawContext();
        long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
        drawContext.getCanvas().save();
        float[] fArr2 = this.groupMatrix;
        CanvasDrawScopeKt$asDrawTransform$1 canvasDrawScopeKt$asDrawTransform$1 = drawContext.transform;
        if (fArr2 != null) {
            canvasDrawScopeKt$asDrawTransform$1.m376transform58bKbWc(fArr2);
        }
        AndroidPath androidPath2 = this.clipPath;
        if ((!this.clipPathData.isEmpty()) && androidPath2 != null) {
            canvasDrawScopeKt$asDrawTransform$1.m372clipPathmtrdDE(androidPath2, 1);
        }
        ArrayList arrayList = this.children;
        int size = arrayList.size();
        for (int r4 = 0; r4 < size; r4++) {
            ((VNode) arrayList.get(r4)).draw(drawScope);
        }
        drawContext.getCanvas().restore();
        drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final Function0<Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final void remove(int r5, int r6) {
        for (int r0 = 0; r0 < r6; r0++) {
            ArrayList arrayList = this.children;
            if (r5 < arrayList.size()) {
                ((VNode) arrayList.get(r5)).setInvalidateListener$ui_release(null);
                arrayList.remove(r5);
            }
        }
        invalidate();
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setInvalidateListener$ui_release(Function0<Unit> function0) {
        this.invalidateListener = function0;
        ArrayList arrayList = this.children;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            ((VNode) arrayList.get(r2)).setInvalidateListener$ui_release(function0);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.name);
        ArrayList arrayList = this.children;
        int size = arrayList.size();
        for (int r3 = 0; r3 < size; r3++) {
            VNode vNode = (VNode) arrayList.get(r3);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
