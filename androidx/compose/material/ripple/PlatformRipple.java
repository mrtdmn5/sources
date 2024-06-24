package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ripple.android.kt */
/* loaded from: classes.dex */
public final class PlatformRipple extends Ripple {
    public PlatformRipple() {
        throw null;
    }

    @Override // androidx.compose.material.ripple.Ripple
    /* renamed from: rememberUpdatedRippleInstance-942rkJo, reason: not valid java name */
    public final RippleIndicationInstance mo220rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z, float f, MutableState mutableState, MutableState mutableState2, Composer composer) {
        View view;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(331259447);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-1737891121);
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.LocalView);
        while (!(consume instanceof ViewGroup)) {
            Object parent = ((View) consume).getParent();
            if (parent instanceof View) {
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                consume = parent;
            } else {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(1643267286);
        boolean isInEditMode = viewGroup.isInEditMode();
        Object obj = Composer.Companion.Empty;
        if (isInEditMode) {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(interactionSource) | composer.changed(this);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == obj) {
                rememberedValue = new CommonRippleIndicationInstance(z, f, mutableState, mutableState2);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) rememberedValue;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return commonRippleIndicationInstance;
        }
        composer.endReplaceableGroup();
        int childCount = viewGroup.getChildCount();
        int r10 = 0;
        while (true) {
            if (r10 < childCount) {
                view = viewGroup.getChildAt(r10);
                if (view instanceof RippleContainer) {
                    break;
                }
                r10++;
            } else {
                view = null;
                break;
            }
        }
        if (view == null) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view = new RippleContainer(context);
            viewGroup.addView(view);
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed2 = composer.changed(interactionSource) | composer.changed(this) | composer.changed(view);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == obj) {
            rememberedValue2 = new AndroidRippleIndicationInstance(z, f, mutableState, mutableState2, (RippleContainer) view);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) rememberedValue2;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        return androidRippleIndicationInstance;
    }
}
