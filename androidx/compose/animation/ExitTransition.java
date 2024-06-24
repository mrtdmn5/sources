package androidx.compose.animation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public abstract class ExitTransition {
    public static final ExitTransitionImpl None = new ExitTransitionImpl(new TransitionData(null, null, null, null, 15));

    public final boolean equals(Object obj) {
        if ((obj instanceof ExitTransition) && Intrinsics.areEqual(((ExitTransition) obj).getData$animation_release(), getData$animation_release())) {
            return true;
        }
        return false;
    }

    public abstract TransitionData getData$animation_release();

    public final int hashCode() {
        return getData$animation_release().hashCode();
    }

    public final ExitTransitionImpl plus(ExitTransitionImpl exitTransitionImpl) {
        TransitionData transitionData = ((ExitTransitionImpl) this).data;
        Fade fade = transitionData.fade;
        TransitionData transitionData2 = exitTransitionImpl.data;
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
        return new ExitTransitionImpl(new TransitionData(fade, slide, changeSize, scale));
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        if (Intrinsics.areEqual(this, None)) {
            return "ExitTransition.None";
        }
        TransitionData data$animation_release = getData$animation_release();
        StringBuilder sb = new StringBuilder("ExitTransition: \nFade - ");
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
