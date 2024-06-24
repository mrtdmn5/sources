package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: TextFieldImpl.kt */
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final Modifier IconDefaultSizeModifier;
    public static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    public static final float TextFieldPadding = 16;
    public static final float HorizontalIconPadding = 12;

    static {
        int r0 = Modifier.$r8$clinit;
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m81defaultMinSizeVpY3zN4(Modifier.Companion.$$INSTANCE, f, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3, kotlin.jvm.internal.Lambda] */
    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> innerTextField, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int r53, final int r54, final int r55) {
        int r0;
        int r26;
        InputPhase inputPhase;
        ComposerImpl composerImpl;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-712568069);
        if ((r55 & 1) != 0) {
            r0 = r53 | 6;
        } else if ((r53 & 14) == 0) {
            r0 = (startRestartGroup.changed(type) ? 4 : 2) | r53;
        } else {
            r0 = r53;
        }
        if ((r55 & 2) != 0) {
            r0 |= 48;
        } else if ((r53 & 112) == 0) {
            r0 |= startRestartGroup.changed(value) ? 32 : 16;
        }
        if ((r55 & 4) != 0) {
            r0 |= 384;
        } else if ((r53 & 896) == 0) {
            r0 |= startRestartGroup.changedInstance(innerTextField) ? 256 : 128;
        }
        if ((r55 & 8) != 0) {
            r0 |= 3072;
        } else if ((r53 & 7168) == 0) {
            r0 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        int r3 = r55 & 16;
        int r22 = DfuBaseService.ERROR_REMOTE_MASK;
        if (r3 != 0) {
            r0 |= 24576;
        } else if ((r53 & 57344) == 0) {
            r0 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int r32 = r55 & 32;
        if (r32 != 0) {
            r0 |= 196608;
        } else if ((r53 & 458752) == 0) {
            r0 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
        }
        int r25 = r55 & 64;
        if (r25 != 0) {
            r0 |= 1572864;
        } else if ((r53 & 3670016) == 0) {
            r0 |= startRestartGroup.changedInstance(function23) ? Constants.MB : 524288;
        }
        int r1 = r55 & 128;
        if (r1 != 0) {
            r0 |= 12582912;
        } else if ((r53 & 29360128) == 0) {
            r0 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        int r2 = r55 & 256;
        if (r2 != 0) {
            r0 |= 100663296;
        } else if ((r53 & 234881024) == 0) {
            r0 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int r13 = r55 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
        if (r13 != 0) {
            r0 |= 805306368;
        } else if ((r53 & 1879048192) == 0) {
            r0 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
        }
        final int r27 = r0;
        int r02 = r55 & 1024;
        if (r02 != 0) {
            r26 = r54 | 6;
        } else if ((r54 & 14) == 0) {
            r26 = r54 | (startRestartGroup.changed(z3) ? 4 : 2);
        } else {
            r26 = r54;
        }
        if ((r55 & 2048) != 0) {
            r26 |= 48;
        } else if ((r54 & 112) == 0) {
            r26 |= startRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int r7 = r26;
        if ((r55 & 4096) != 0) {
            r7 |= 384;
        } else if ((r54 & 896) == 0) {
            r7 |= startRestartGroup.changed(contentPadding) ? 256 : 128;
        }
        if ((r55 & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
            r7 |= 3072;
        } else if ((r54 & 7168) == 0) {
            r7 |= startRestartGroup.changed(colors) ? 2048 : 1024;
        }
        int r15 = r55 & DfuBaseService.ERROR_CONNECTION_MASK;
        if (r15 != 0) {
            r7 |= 24576;
        } else if ((r54 & 57344) == 0) {
            if (startRestartGroup.changedInstance(function25)) {
                r22 = 16384;
            }
            r7 |= r22;
        }
        if ((r27 & 1533916891) == 306783378 && (46811 & r7) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            function26 = function22;
            function27 = function23;
            function28 = function24;
            z4 = z;
            z5 = z2;
            z6 = z3;
            function29 = function25;
            composerImpl = startRestartGroup;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function210 = r32 != 0 ? null : function22;
            Function2<? super Composer, ? super Integer, Unit> function211 = r25 != 0 ? null : function23;
            Function2<? super Composer, ? super Integer, Unit> function212 = r1 != 0 ? null : function24;
            boolean z7 = r2 != 0 ? false : z;
            boolean z8 = r13 != 0 ? true : z2;
            boolean z9 = r02 != 0 ? false : z3;
            Function2<? super Composer, ? super Integer, Unit> function213 = r15 != 0 ? null : function25;
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(value) | startRestartGroup.changed(visualTransformation);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = visualTransformation.filter(new AnnotatedString(value, null, 6));
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            final String str = ((TransformedText) nextSlot).text.text;
            if (((Boolean) FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (r7 >> 3) & 14).getValue()).booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = str.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            final int r23 = r7;
            final boolean z10 = z8;
            final boolean z11 = z9;
            Function3<InputPhase, Composer, Integer, Color> function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function3
                public final Color invoke(InputPhase inputPhase3, Composer composer2, Integer num) {
                    boolean z12;
                    InputPhase it = inputPhase3;
                    Composer composer3 = composer2;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(it, "it");
                    composer3.startReplaceableGroup(697243846);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    TextFieldColors textFieldColors = colors;
                    boolean z13 = z10;
                    if (it == InputPhase.UnfocusedEmpty) {
                        z12 = false;
                    } else {
                        z12 = z11;
                    }
                    boolean z14 = z12;
                    InteractionSource interactionSource2 = interactionSource;
                    int r72 = (r27 >> 27) & 14;
                    int r9 = r23;
                    long j = ((Color) textFieldColors.labelColor(z13, z14, interactionSource2, composer3, r72 | ((r9 << 3) & 896) | (r9 & 7168)).getValue()).value;
                    composer3.endReplaceableGroup();
                    return new Color(j);
                }
            };
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
            Typography typography = (Typography) startRestartGroup.consume(staticProvidableCompositionLocal);
            TextStyle textStyle = typography.subtitle1;
            long m531getColor0d7_KjU = textStyle.m531getColor0d7_KjU();
            long j = Color.Unspecified;
            boolean m317equalsimpl0 = Color.m317equalsimpl0(m531getColor0d7_KjU, j);
            TextStyle textStyle2 = typography.caption;
            boolean z12 = (m317equalsimpl0 && !Color.m317equalsimpl0(textStyle2.m531getColor0d7_KjU(), j)) || (!Color.m317equalsimpl0(textStyle.m531getColor0d7_KjU(), j) && Color.m317equalsimpl0(textStyle2.m531getColor0d7_KjU(), j));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(2129141006);
            long m531getColor0d7_KjU2 = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).caption.m531getColor0d7_KjU();
            if (z12) {
                if (!(m531getColor0d7_KjU2 != j)) {
                    m531getColor0d7_KjU2 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).value;
                }
            }
            long j2 = m531getColor0d7_KjU2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(2129141197);
            long m531getColor0d7_KjU3 = ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).subtitle1.m531getColor0d7_KjU();
            if (z12) {
                if (!(m531getColor0d7_KjU3 != j)) {
                    m531getColor0d7_KjU3 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).value;
                }
            }
            long j3 = m531getColor0d7_KjU3;
            startRestartGroup.end(false);
            final Function2<? super Composer, ? super Integer, Unit> function214 = function210;
            final boolean z13 = z9;
            final int r5 = r7;
            final boolean z14 = z8;
            final Function2<? super Composer, ? super Integer, Unit> function215 = function211;
            final Function2<? super Composer, ? super Integer, Unit> function216 = function212;
            final boolean z15 = z7;
            final boolean z16 = z12;
            final Function2<? super Composer, ? super Integer, Unit> function217 = function213;
            composerImpl = startRestartGroup;
            textFieldTransitionScope.m215TransitionDTcfvLk(inputPhase2, j2, j3, function3, function2 != null, ComposableLambdaKt.composableLambda(composerImpl, 341865432, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] r0 = new int[TextFieldType.values().length];
                        try {
                            r0[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            r0[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = r0;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x018d  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x01dd  */
                /* JADX WARN: Removed duplicated region for block: B:64:0x01fc  */
                /* JADX WARN: Removed duplicated region for block: B:75:0x0299  */
                /* JADX WARN: Removed duplicated region for block: B:76:0x01c4  */
                /* JADX WARN: Removed duplicated region for block: B:77:0x0189  */
                /* JADX WARN: Removed duplicated region for block: B:78:0x015d  */
                /* JADX WARN: Type inference failed for: r10v10, types: [androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r11v8, types: [androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r3v27, types: [kotlin.jvm.internal.Lambda, androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1] */
                /* JADX WARN: Type inference failed for: r8v10, types: [androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1, kotlin.jvm.internal.Lambda] */
                @Override // kotlin.jvm.functions.Function6
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final kotlin.Unit invoke(java.lang.Float r25, androidx.compose.ui.graphics.Color r26, androidx.compose.ui.graphics.Color r27, java.lang.Float r28, androidx.compose.runtime.Composer r29, java.lang.Integer r30) {
                    /*
                        Method dump skipped, instructions count: 720
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.invoke(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                }
            }), composerImpl, 1769472);
            function26 = function210;
            function27 = function211;
            function28 = function212;
            z4 = z7;
            z5 = z8;
            z6 = z9;
            function29 = function213;
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TextFieldImplKt.CommonDecorationBox(TextFieldType.this, value, innerTextField, visualTransformation, function2, function26, function27, function28, z4, z5, z6, interactionSource, contentPadding, colors, function29, composer2, Strings.updateChangedFlags(r53 | 1), Strings.updateChangedFlags(r54), r55);
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004e  */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m213DecorationeuL9pac(final long r15, androidx.compose.ui.text.TextStyle r17, java.lang.Float r18, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m213DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        LayoutIdParentData layoutIdParentData;
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof LayoutIdParentData) {
            layoutIdParentData = (LayoutIdParentData) parentData;
        } else {
            layoutIdParentData = null;
        }
        if (layoutIdParentData == null) {
            return null;
        }
        return layoutIdParentData.getLayoutId();
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.height;
        }
        return 0;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.width;
        }
        return 0;
    }
}
