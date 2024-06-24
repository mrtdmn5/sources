package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt$collectIsHoveredAsState$1$1;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt$collectIsPressedAsState$1$1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Indication.kt */
/* loaded from: classes.dex */
public final class DefaultDebugIndication implements Indication {
    public static final DefaultDebugIndication INSTANCE = new DefaultDebugIndication();

    /* compiled from: Indication.kt */
    /* loaded from: classes.dex */
    public static final class DefaultDebugIndicationInstance implements IndicationInstance {
        public final State<Boolean> isFocused;
        public final State<Boolean> isHovered;
        public final State<Boolean> isPressed;

        public DefaultDebugIndicationInstance(MutableState isPressed, MutableState isHovered, MutableState isFocused) {
            Intrinsics.checkNotNullParameter(isPressed, "isPressed");
            Intrinsics.checkNotNullParameter(isHovered, "isHovered");
            Intrinsics.checkNotNullParameter(isFocused, "isFocused");
            this.isPressed = isPressed;
            this.isHovered = isHovered;
            this.isFocused = isFocused;
        }

        @Override // androidx.compose.foundation.IndicationInstance
        public final void drawIndication(ContentDrawScope contentDrawScope) {
            long Color;
            long Color2;
            Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
            contentDrawScope.drawContent();
            if (this.isPressed.getValue().booleanValue()) {
                Color2 = ColorKt.Color(Color.m322getRedimpl(r0), Color.m321getGreenimpl(r0), Color.m319getBlueimpl(r0), 0.3f, Color.m320getColorSpaceimpl(Color.Black));
                DrawScope.m386drawRectnJ9OG0$default(contentDrawScope, Color2, 0L, contentDrawScope.mo391getSizeNHjbRc(), 0.0f, 122);
            } else if (this.isHovered.getValue().booleanValue() || this.isFocused.getValue().booleanValue()) {
                Color = ColorKt.Color(Color.m322getRedimpl(r0), Color.m321getGreenimpl(r0), Color.m319getBlueimpl(r0), 0.1f, Color.m320getColorSpaceimpl(Color.Black));
                DrawScope.m386drawRectnJ9OG0$default(contentDrawScope, Color, 0L, contentDrawScope.mo391getSizeNHjbRc(), 0.0f, 122);
            }
        }
    }

    @Override // androidx.compose.foundation.Indication
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1683566979);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-1692965168);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Object obj = Composer.Companion.Empty;
        if (rememberedValue == obj) {
            rememberedValue = Platform.mutableStateOf$default(Boolean.FALSE);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(interactionSource) | composer.changed(mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == obj) {
            rememberedValue2 = new PressInteractionKt$collectIsPressedAsState$1$1(interactionSource, mutableState, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2) rememberedValue2, composer);
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(1206586544);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == obj) {
            rememberedValue3 = Platform.mutableStateOf$default(Boolean.FALSE);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) rememberedValue3;
        composer.startReplaceableGroup(511388516);
        boolean changed2 = composer.changed(interactionSource) | composer.changed(mutableState2);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == obj) {
            rememberedValue4 = new HoverInteractionKt$collectIsHoveredAsState$1$1(interactionSource, mutableState2, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(interactionSource, (Function2) rememberedValue4, composer);
        composer.endReplaceableGroup();
        MutableState collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean changed3 = composer.changed(interactionSource);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed3 || rememberedValue5 == obj) {
            rememberedValue5 = new DefaultDebugIndicationInstance(mutableState, mutableState2, collectIsFocusedAsState);
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        DefaultDebugIndicationInstance defaultDebugIndicationInstance = (DefaultDebugIndicationInstance) rememberedValue5;
        composer.endReplaceableGroup();
        return defaultDebugIndicationInstance;
    }
}
