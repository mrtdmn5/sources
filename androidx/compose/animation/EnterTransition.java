package androidx.compose.animation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public abstract class EnterTransition {
    public static final EnterTransitionImpl None = new EnterTransitionImpl(new TransitionData(null, null, null, null, 15));

    public final boolean equals(Object obj) {
        if ((obj instanceof EnterTransition) && Intrinsics.areEqual(((EnterTransition) obj).getData$animation_release(), getData$animation_release())) {
            return true;
        }
        return false;
    }

    public abstract TransitionData getData$animation_release();

    public final int hashCode() {
        return getData$animation_release().hashCode();
    }

    public final EnterTransitionImpl plus(EnterTransitionImpl enterTransitionImpl) {
        TransitionData transitionData = ((EnterTransitionImpl) this).data;
        Fade fade = transitionData.fade;
        TransitionData transitionData2 = enterTransitionImpl.data;
        if (fade == null) {
            fade = transitionData2.fade;
        }
        Slide slide = transitionData.slide;
        if (slide == null) {
            slide = transitionData2.slide;
        }
        ChangeSize changeSize = transitionData.changeSize;
        if (changeSize == null) {
            changeSize = transitionData2.changeSize;
        }
        Scale scale = transitionData.scale;
        if (scale == null) {
            scale = transitionData2.scale;
        }
        return new EnterTransitionImpl(new TransitionData(fade, slide, changeSize, scale));
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        if (Intrinsics.areEqual(this, None)) {
            return "EnterTransition.None";
        }
        TransitionData data$animation_release = getData$animation_release();
        StringBuilder sb = new StringBuilder("EnterTransition: \nFade - ");
        Fade fade = data$animation_release.fade;
        String str4 = null;
        if (fade != null) {
            str = fade.toString();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(",\nSlide - ");
        Slide slide = data$animation_release.slide;
        if (slide != null) {
            str2 = slide.toString();
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(",\nShrink - ");
        ChangeSize changeSize = data$animation_release.changeSize;
        if (changeSize != null) {
            str3 = changeSize.toString();
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(",\nScale - ");
        Scale scale = data$animation_release.scale;
        if (scale != null) {
            str4 = scale.toString();
        }
        sb.append(str4);
        return sb.toString();
    }
}
