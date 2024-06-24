package com.animaconnected.widget;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.google.common.base.Strings;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Modifiers.kt */
/* loaded from: classes3.dex */
public final class ModifiersKt {
    private static final float defaultFadingEdgeHeight = 32;

    /* renamed from: Spacer-8Feqmps, reason: not valid java name */
    public static final void m1611Spacer8Feqmps(final float f, Composer composer, final int r4) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1947336428);
        if ((r4 & 14) == 0) {
            if (startRestartGroup.changed(f)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r4;
        } else {
            r0 = r4;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(Modifier.Companion.$$INSTANCE, f), startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ModifiersKt$Spacer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    ModifiersKt.m1611Spacer8Feqmps(f, composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    private static final Modifier addAlphaMaskModifier(Modifier modifier, final Function1<? super ContentDrawScope, Unit> function1) {
        int r0 = Modifier.$r8$clinit;
        return modifier.then(DrawModifierKt.drawWithContent(GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion.$$INSTANCE, new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.widget.ModifiersKt$addAlphaMaskModifier$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayer) {
                Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                graphicsLayer.setAlpha(0.99f);
            }
        }), new Function1<ContentDrawScope, Unit>() { // from class: com.animaconnected.widget.ModifiersKt$addAlphaMaskModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                function1.invoke(drawWithContent);
            }
        }));
    }

    /* renamed from: fadingEdgeBottom-3ABfNKs, reason: not valid java name */
    public static final Modifier m1612fadingEdgeBottom3ABfNKs(Modifier fadingEdgeBottom, final float f) {
        Intrinsics.checkNotNullParameter(fadingEdgeBottom, "$this$fadingEdgeBottom");
        return addAlphaMaskModifier(fadingEdgeBottom, new Function1<ContentDrawScope, Unit>() { // from class: com.animaconnected.widget.ModifiersKt$fadingEdgeBottom$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope addAlphaMaskModifier) {
                Intrinsics.checkNotNullParameter(addAlphaMaskModifier, "$this$addAlphaMaskModifier");
                List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Color[]{new Color(Color.Black), new Color(Color.Transparent)});
                float mo49toPx0680j_4 = addAlphaMaskModifier.mo49toPx0680j_4(f);
                addAlphaMaskModifier.drawContent();
                DrawScope.m385drawRectAsUm42w$default(addAlphaMaskModifier, Brush.Companion.m311verticalGradient8A3gB4$default(listOf, Size.m274getHeightimpl(addAlphaMaskModifier.mo391getSizeNHjbRc()) - mo49toPx0680j_4, 0.0f, 12), OffsetKt.Offset(0.0f, Size.m274getHeightimpl(addAlphaMaskModifier.mo391getSizeNHjbRc()) - mo49toPx0680j_4), 0L, 0.0f, null, 6, 60);
            }
        });
    }

    /* renamed from: fadingEdgeBottom-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1613fadingEdgeBottom3ABfNKs$default(Modifier modifier, float f, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            f = defaultFadingEdgeHeight;
        }
        return m1612fadingEdgeBottom3ABfNKs(modifier, f);
    }

    /* renamed from: fadingEdgeTop-3ABfNKs, reason: not valid java name */
    public static final Modifier m1614fadingEdgeTop3ABfNKs(Modifier fadingEdgeTop, final float f) {
        Intrinsics.checkNotNullParameter(fadingEdgeTop, "$this$fadingEdgeTop");
        return addAlphaMaskModifier(fadingEdgeTop, new Function1<ContentDrawScope, Unit>() { // from class: com.animaconnected.widget.ModifiersKt$fadingEdgeTop$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope addAlphaMaskModifier) {
                Intrinsics.checkNotNullParameter(addAlphaMaskModifier, "$this$addAlphaMaskModifier");
                List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Color[]{new Color(Color.Transparent), new Color(Color.Black)});
                float mo49toPx0680j_4 = addAlphaMaskModifier.mo49toPx0680j_4(f);
                addAlphaMaskModifier.drawContent();
                DrawScope.m385drawRectAsUm42w$default(addAlphaMaskModifier, Brush.Companion.m311verticalGradient8A3gB4$default(listOf, 0.0f, mo49toPx0680j_4, 8), 0L, androidx.compose.ui.geometry.SizeKt.Size(Size.m276getWidthimpl(addAlphaMaskModifier.mo391getSizeNHjbRc()), mo49toPx0680j_4), 0.0f, null, 6, 58);
            }
        });
    }

    /* renamed from: fadingEdgeTop-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1615fadingEdgeTop3ABfNKs$default(Modifier modifier, float f, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            f = defaultFadingEdgeHeight;
        }
        return m1614fadingEdgeTop3ABfNKs(modifier, f);
    }

    public static final float getDefaultFadingEdgeHeight() {
        return defaultFadingEdgeHeight;
    }

    public static final Modifier noRippleClickable(Modifier modifier, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed$default(modifier, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.animaconnected.widget.ModifiersKt$noRippleClickable$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int r10) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-851232391);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                composer.startReplaceableGroup(865795847);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.Empty) {
                    rememberedValue = new MutableInteractionSourceImpl();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m25clickableO2vRcR0$default = ClickableKt.m25clickableO2vRcR0$default(composed, (MutableInteractionSource) rememberedValue, null, false, null, onClick, 28);
                composer.endReplaceableGroup();
                return m25clickableO2vRcR0$default;
            }
        });
    }
}
