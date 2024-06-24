package androidx.compose.animation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class TransitionData {
    public final ChangeSize changeSize;
    public final Fade fade;
    public final Scale scale;
    public final Slide slide;

    public TransitionData() {
        this(null, null, null, null, 15);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) obj;
        if (Intrinsics.areEqual(this.fade, transitionData.fade) && Intrinsics.areEqual(this.slide, transitionData.slide) && Intrinsics.areEqual(this.changeSize, transitionData.changeSize) && Intrinsics.areEqual(this.scale, transitionData.scale)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int r0 = 0;
        Fade fade = this.fade;
        if (fade == null) {
            hashCode = 0;
        } else {
            hashCode = fade.hashCode();
        }
        int r1 = hashCode * 31;
        Slide slide = this.slide;
        if (slide == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = slide.hashCode();
        }
        int r12 = (r1 + hashCode2) * 31;
        ChangeSize changeSize = this.changeSize;
        if (changeSize == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = changeSize.hashCode();
        }
        int r13 = (r12 + hashCode3) * 31;
        Scale scale = this.scale;
        if (scale != null) {
            r0 = scale.hashCode();
        }
        return r13 + r0;
    }

    public final String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ')';
    }

    public TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale) {
        this.fade = fade;
        this.slide = slide;
        this.changeSize = changeSize;
        this.scale = scale;
    }

    public /* synthetic */ TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, int r7) {
        this((r7 & 1) != 0 ? null : fade, (r7 & 2) != 0 ? null : slide, (r7 & 4) != 0 ? null : changeSize, (r7 & 8) != 0 ? null : scale);
    }
}
