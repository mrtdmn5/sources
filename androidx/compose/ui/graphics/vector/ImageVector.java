package androidx.compose.ui.graphics.vector;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: ImageVector.kt */
/* loaded from: classes.dex */
public final class ImageVector {
    public final boolean autoMirror;
    public final float defaultHeight;
    public final float defaultWidth;
    public final String name;
    public final VectorGroup root;
    public final int tintBlendMode;
    public final long tintColor;
    public final float viewportHeight;
    public final float viewportWidth;

    /* compiled from: ImageVector.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public final boolean autoMirror;
        public final float defaultHeight;
        public final float defaultWidth;
        public boolean isConsumed;
        public final String name;
        public final ArrayList<GroupParams> nodes;
        public final GroupParams root;
        public final int tintBlendMode;
        public final long tintColor;
        public final float viewportHeight;
        public final float viewportWidth;

        /* compiled from: ImageVector.kt */
        /* loaded from: classes.dex */
        public static final class GroupParams {
            public final List<VectorNode> children;
            public final List<? extends PathNode> clipPathData;
            public final String name;
            public final float pivotX;
            public final float pivotY;
            public final float rotate;
            public final float scaleX;
            public final float scaleY;
            public final float translationX;
            public final float translationY;

            public GroupParams() {
                this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 1023);
            }

            public GroupParams(String name, float f, float f2, float f3, float f4, float f5, float f6, float f7, List clipPathData, int r13) {
                name = (r13 & 1) != 0 ? "" : name;
                f = (r13 & 2) != 0 ? 0.0f : f;
                f2 = (r13 & 4) != 0 ? 0.0f : f2;
                f3 = (r13 & 8) != 0 ? 0.0f : f3;
                f4 = (r13 & 16) != 0 ? 1.0f : f4;
                f5 = (r13 & 32) != 0 ? 1.0f : f5;
                f6 = (r13 & 64) != 0 ? 0.0f : f6;
                f7 = (r13 & 128) != 0 ? 0.0f : f7;
                if ((r13 & 256) != 0) {
                    int r12 = VectorKt.$r8$clinit;
                    clipPathData = EmptyList.INSTANCE;
                }
                ArrayList children = (r13 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? new ArrayList() : null;
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
                Intrinsics.checkNotNullParameter(children, "children");
                this.name = name;
                this.rotate = f;
                this.pivotX = f2;
                this.pivotY = f3;
                this.scaleX = f4;
                this.scaleY = f5;
                this.translationX = f6;
                this.translationY = f7;
                this.clipPathData = clipPathData;
                this.children = children;
            }
        }

        public Builder(String str, float f, float f2, float f3, float f4, long j, int r22, boolean z, int r24) {
            String name;
            long j2;
            int r5;
            boolean z2;
            if ((r24 & 1) != 0) {
                name = "";
            } else {
                name = str;
            }
            if ((r24 & 32) != 0) {
                j2 = Color.Unspecified;
            } else {
                j2 = j;
            }
            if ((r24 & 64) != 0) {
                r5 = 5;
            } else {
                r5 = r22;
            }
            if ((r24 & 128) != 0) {
                z2 = false;
            } else {
                z2 = z;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.defaultWidth = f;
            this.defaultHeight = f2;
            this.viewportWidth = f3;
            this.viewportHeight = f4;
            this.tintColor = j2;
            this.tintBlendMode = r5;
            this.autoMirror = z2;
            ArrayList<GroupParams> arrayList = new ArrayList<>();
            this.nodes = arrayList;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 1023);
            this.root = groupParams;
            arrayList.add(groupParams);
        }

        public final void addGroup(String name, float f, float f2, float f3, float f4, float f5, float f6, float f7, List clipPathData) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(clipPathData, "clipPathData");
            ensureNotConsumed();
            this.nodes.add(new GroupParams(name, f, f2, f3, f4, f5, f6, f7, clipPathData, DfuBaseService.ERROR_REMOTE_TYPE_SECURE));
        }

        /* renamed from: addPath-oIyEayM */
        public final void m394addPathoIyEayM(float f, float f2, float f3, float f4, float f5, float f6, float f7, int r25, int r26, int r27, Brush brush, Brush brush2, String name, List pathData) {
            Intrinsics.checkNotNullParameter(pathData, "pathData");
            Intrinsics.checkNotNullParameter(name, "name");
            ensureNotConsumed();
            this.nodes.get(r1.size() - 1).children.add(new VectorPath(name, pathData, r25, brush, f, brush2, f2, f3, r26, r27, f4, f5, f6, f7));
        }

        public final ImageVector build() {
            ensureNotConsumed();
            while (this.nodes.size() > 1) {
                clearGroup();
            }
            String str = this.name;
            float f = this.defaultWidth;
            float f2 = this.defaultHeight;
            float f3 = this.viewportWidth;
            float f4 = this.viewportHeight;
            GroupParams groupParams = this.root;
            ImageVector imageVector = new ImageVector(str, f, f2, f3, f4, new VectorGroup(groupParams.name, groupParams.rotate, groupParams.pivotX, groupParams.pivotY, groupParams.scaleX, groupParams.scaleY, groupParams.translationX, groupParams.translationY, groupParams.clipPathData, groupParams.children), this.tintColor, this.tintBlendMode, this.autoMirror);
            this.isConsumed = true;
            return imageVector;
        }

        public final void clearGroup() {
            ensureNotConsumed();
            ArrayList<GroupParams> arrayList = this.nodes;
            GroupParams remove = arrayList.remove(arrayList.size() - 1);
            arrayList.get(arrayList.size() - 1).children.add(new VectorGroup(remove.name, remove.rotate, remove.pivotX, remove.pivotY, remove.scaleX, remove.scaleY, remove.translationX, remove.translationY, remove.clipPathData, remove.children));
        }

        public final void ensureNotConsumed() {
            if (!this.isConsumed) {
            } else {
                throw new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
            }
        }
    }

    public ImageVector(String name, float f, float f2, float f3, float f4, VectorGroup vectorGroup, long j, int r10, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultWidth = f;
        this.defaultHeight = f2;
        this.viewportWidth = f3;
        this.viewportHeight = f4;
        this.root = vectorGroup;
        this.tintColor = j;
        this.tintBlendMode = r10;
        this.autoMirror = z;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) obj;
        if (!Intrinsics.areEqual(this.name, imageVector.name) || !Dp.m579equalsimpl0(this.defaultWidth, imageVector.defaultWidth) || !Dp.m579equalsimpl0(this.defaultHeight, imageVector.defaultHeight)) {
            return false;
        }
        if (this.viewportWidth == imageVector.viewportWidth) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.viewportHeight == imageVector.viewportHeight) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || !Intrinsics.areEqual(this.root, imageVector.root) || !Color.m317equalsimpl0(this.tintColor, imageVector.tintColor)) {
            return false;
        }
        if (this.tintBlendMode == imageVector.tintBlendMode) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && this.autoMirror == imageVector.autoMirror) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.root.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.viewportHeight, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.viewportWidth, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.defaultHeight, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.defaultWidth, this.name.hashCode() * 31, 31), 31), 31), 31)) * 31;
        int r0 = Color.$r8$clinit;
        return Boolean.hashCode(this.autoMirror) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.tintBlendMode, Scale$$ExternalSyntheticOutline0.m(this.tintColor, hashCode, 31), 31);
    }
}
