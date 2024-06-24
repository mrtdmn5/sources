package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import com.amazonaws.services.s3.internal.Constants;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final float MinHeight = 56;
    public static final float MinWidth = 280;
    public static final float UnfocusedBorderThickness = 1;
    public static final float FocusedBorderThickness = 2;

    /* renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public static DefaultTextFieldColors m209outlinedTextFieldColorsdx8h9Zs(Composer composer) {
        long Color;
        long Color2;
        long Color3;
        long Color4;
        long Color5;
        long Color6;
        long Color7;
        long Color8;
        long Color9;
        long Color10;
        long Color11;
        long Color12;
        long Color13;
        long Color14;
        composer.startReplaceableGroup(1762667317);
        Color = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), ((Number) composer.consume(ContentAlphaKt.LocalContentAlpha)).floatValue(), Color.m320getColorSpaceimpl(((Color) composer.consume(ContentColorKt.LocalContentColor)).value));
        Color2 = ColorKt.Color(Color.m322getRedimpl(Color), Color.m321getGreenimpl(Color), Color.m319getBlueimpl(Color), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color));
        long j = Color.Transparent;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
        long m170getPrimary0d7_KjU = ((Colors) composer.consume(staticProvidableCompositionLocal)).m170getPrimary0d7_KjU();
        long m165getError0d7_KjU = ((Colors) composer.consume(staticProvidableCompositionLocal)).m165getError0d7_KjU();
        Color3 = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), ContentAlpha.getHigh(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m170getPrimary0d7_KjU()));
        Color4 = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
        Color5 = ColorKt.Color(Color.m322getRedimpl(Color4), Color.m321getGreenimpl(Color4), Color.m319getBlueimpl(Color4), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color4));
        long m165getError0d7_KjU2 = ((Colors) composer.consume(staticProvidableCompositionLocal)).m165getError0d7_KjU();
        Color6 = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), 0.54f, Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
        Color7 = ColorKt.Color(Color.m322getRedimpl(Color6), Color.m321getGreenimpl(Color6), Color.m319getBlueimpl(Color6), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color6));
        Color8 = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), 0.54f, Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
        Color9 = ColorKt.Color(Color.m322getRedimpl(Color8), Color.m321getGreenimpl(Color8), Color.m319getBlueimpl(Color8), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color8));
        long m165getError0d7_KjU3 = ((Colors) composer.consume(staticProvidableCompositionLocal)).m165getError0d7_KjU();
        Color10 = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), ContentAlpha.getHigh(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m170getPrimary0d7_KjU()));
        Color11 = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), ContentAlpha.getMedium(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
        Color12 = ColorKt.Color(Color.m322getRedimpl(Color11), Color.m321getGreenimpl(Color11), Color.m319getBlueimpl(Color11), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color11));
        long m165getError0d7_KjU4 = ((Colors) composer.consume(staticProvidableCompositionLocal)).m165getError0d7_KjU();
        Color13 = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), ContentAlpha.getMedium(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(staticProvidableCompositionLocal)).m169getOnSurface0d7_KjU()));
        Color14 = ColorKt.Color(Color.m322getRedimpl(Color13), Color.m321getGreenimpl(Color13), Color.m319getBlueimpl(Color13), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(Color13));
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(Color, Color2, m170getPrimary0d7_KjU, m165getError0d7_KjU, Color3, Color4, m165getError0d7_KjU2, Color5, Color6, Color7, Color6, Color8, Color9, m165getError0d7_KjU3, j, Color10, Color11, Color12, m165getError0d7_KjU4, Color13, Color14);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public static DefaultTextFieldColors m210textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, Composer composer, int r62) {
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        long j32;
        long j33;
        long Color;
        long Color2;
        long Color3;
        long Color4;
        long Color5;
        composer.startReplaceableGroup(231892599);
        if ((r62 & 1) != 0) {
            Color5 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), ((Number) composer.consume(ContentAlphaKt.LocalContentAlpha)).floatValue(), Color.m320getColorSpaceimpl(((Color) composer.consume(ContentColorKt.LocalContentColor)).value));
            j8 = Color5;
        } else {
            j8 = j;
        }
        if ((r62 & 2) != 0) {
            j9 = ColorKt.Color(Color.m322getRedimpl(j8), Color.m321getGreenimpl(j8), Color.m319getBlueimpl(j8), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j8));
        } else {
            j9 = 0;
        }
        if ((r62 & 4) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Color4 = ColorKt.Color(Color.m322getRedimpl(r10), Color.m321getGreenimpl(r10), Color.m319getBlueimpl(r10), 0.12f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
            j10 = Color4;
        } else {
            j10 = j2;
        }
        if ((r62 & 8) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            j11 = ((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU();
        } else {
            j11 = j3;
        }
        if ((r62 & 16) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            j12 = ((Colors) composer.consume(ColorsKt.LocalColors)).m165getError0d7_KjU();
        } else {
            j12 = 0;
        }
        if ((r62 & 32) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
            j13 = ColorKt.Color(Color.m322getRedimpl(r14), Color.m321getGreenimpl(r14), Color.m319getBlueimpl(r14), ContentAlpha.getHigh(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU()));
        } else {
            j13 = j4;
        }
        if ((r62 & 64) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$15 = ComposerKt.removeCurrentGroupInstance;
            j14 = ColorKt.Color(Color.m322getRedimpl(r3), Color.m321getGreenimpl(r3), Color.m319getBlueimpl(r3), 0.42f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j14 = 0;
        }
        if ((r62 & 128) != 0) {
            Color3 = ColorKt.Color(Color.m322getRedimpl(j14), Color.m321getGreenimpl(j14), Color.m319getBlueimpl(j14), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j14));
            j15 = Color3;
        } else {
            j15 = 0;
        }
        if ((r62 & 256) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$16 = ComposerKt.removeCurrentGroupInstance;
            j16 = ((Colors) composer.consume(ColorsKt.LocalColors)).m165getError0d7_KjU();
        } else {
            j16 = 0;
        }
        if ((r62 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$17 = ComposerKt.removeCurrentGroupInstance;
            j17 = j14;
            j18 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), 0.54f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j17 = j14;
            j18 = j5;
        }
        if ((r62 & 1024) != 0) {
            j19 = ColorKt.Color(Color.m322getRedimpl(j18), Color.m321getGreenimpl(j18), Color.m319getBlueimpl(j18), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j18));
        } else {
            j19 = 0;
        }
        if ((r62 & 2048) != 0) {
            j20 = j18;
        } else {
            j20 = 0;
        }
        if ((r62 & 4096) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$18 = ComposerKt.removeCurrentGroupInstance;
            j21 = j18;
            j22 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), 0.54f, Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j21 = j18;
            j22 = j6;
        }
        if ((r62 & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
            j23 = ColorKt.Color(Color.m322getRedimpl(j22), Color.m321getGreenimpl(j22), Color.m319getBlueimpl(j22), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j22));
        } else {
            j23 = 0;
        }
        if ((r62 & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$19 = ComposerKt.removeCurrentGroupInstance;
            j24 = ((Colors) composer.consume(ColorsKt.LocalColors)).m165getError0d7_KjU();
        } else {
            j24 = 0;
        }
        if ((32768 & r62) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$110 = ComposerKt.removeCurrentGroupInstance;
            j25 = j22;
            j26 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), ContentAlpha.getHigh(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU()));
        } else {
            j25 = j22;
            j26 = j7;
        }
        if ((65536 & r62) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$111 = ComposerKt.removeCurrentGroupInstance;
            j27 = j26;
            j28 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), ContentAlpha.getMedium(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j27 = j26;
            j28 = 0;
        }
        if ((131072 & r62) != 0) {
            Color2 = ColorKt.Color(Color.m322getRedimpl(j28), Color.m321getGreenimpl(j28), Color.m319getBlueimpl(j28), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j28));
            j29 = Color2;
        } else {
            j29 = 0;
        }
        if ((262144 & r62) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$112 = ComposerKt.removeCurrentGroupInstance;
            j30 = ((Colors) composer.consume(ColorsKt.LocalColors)).m165getError0d7_KjU();
        } else {
            j30 = 0;
        }
        if ((524288 & r62) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$113 = ComposerKt.removeCurrentGroupInstance;
            j31 = j28;
            j32 = ColorKt.Color(Color.m322getRedimpl(r2), Color.m321getGreenimpl(r2), Color.m319getBlueimpl(r2), ContentAlpha.getMedium(composer), Color.m320getColorSpaceimpl(((Colors) composer.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU()));
        } else {
            j31 = j28;
            j32 = 0;
        }
        if ((r62 & Constants.MB) != 0) {
            Color = ColorKt.Color(Color.m322getRedimpl(j32), Color.m321getGreenimpl(j32), Color.m319getBlueimpl(j32), ContentAlpha.getDisabled(composer, 6), Color.m320getColorSpaceimpl(j32));
            j33 = Color;
        } else {
            j33 = 0;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$114 = ComposerKt.removeCurrentGroupInstance;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j8, j9, j11, j12, j13, j17, j16, j15, j21, j19, j20, j25, j23, j24, j10, j27, j31, j29, j30, j32, j33);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    public final void m211BorderBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors colors, Shape shape, float f, float f2, Composer composer, final int r28, final int r29) {
        int r0;
        int r02;
        int r1;
        int r12;
        int r13;
        Shape shape2;
        float f3;
        float f4;
        int r6;
        final Shape shape3;
        final float f5;
        final float f6;
        int r62;
        int r5;
        int r3;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        ComposerImpl startRestartGroup = composer.startRestartGroup(943754022);
        if ((r29 & 1) != 0) {
            r0 = r28 | 6;
        } else if ((r28 & 14) == 0) {
            if (startRestartGroup.changed(z)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r28;
        } else {
            r0 = r28;
        }
        if ((r29 & 2) != 0) {
            r0 |= 48;
        } else if ((r28 & 112) == 0) {
            if (startRestartGroup.changed(z2)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r29 & 4) != 0) {
            r0 |= 384;
        } else if ((r28 & 896) == 0) {
            if (startRestartGroup.changed(interactionSource)) {
                r12 = 256;
            } else {
                r12 = 128;
            }
            r0 |= r12;
        }
        if ((r29 & 8) != 0) {
            r0 |= 3072;
        } else if ((r28 & 7168) == 0) {
            if (startRestartGroup.changed(colors)) {
                r13 = 2048;
            } else {
                r13 = 1024;
            }
            r0 |= r13;
        }
        if ((r28 & 57344) == 0) {
            if ((r29 & 16) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    r3 = DfuBaseService.ERROR_CONNECTION_MASK;
                    r0 |= r3;
                }
            } else {
                shape2 = shape;
            }
            r3 = DfuBaseService.ERROR_REMOTE_MASK;
            r0 |= r3;
        } else {
            shape2 = shape;
        }
        if ((r28 & 458752) == 0) {
            if ((r29 & 32) == 0) {
                f3 = f;
                if (startRestartGroup.changed(f3)) {
                    r5 = 131072;
                    r0 |= r5;
                }
            } else {
                f3 = f;
            }
            r5 = 65536;
            r0 |= r5;
        } else {
            f3 = f;
        }
        if ((3670016 & r28) == 0) {
            if ((r29 & 64) == 0) {
                f4 = f2;
                if (startRestartGroup.changed(f4)) {
                    r62 = Constants.MB;
                    r0 |= r62;
                }
            } else {
                f4 = f2;
            }
            r62 = 524288;
            r0 |= r62;
        } else {
            f4 = f2;
        }
        if ((r29 & 128) != 0) {
            r0 |= 12582912;
        } else if ((29360128 & r28) == 0) {
            if (startRestartGroup.changed(this)) {
                r6 = 8388608;
            } else {
                r6 = 4194304;
            }
            r0 |= r6;
        }
        if ((23967451 & r0) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
        } else {
            startRestartGroup.startDefaults();
            if ((r28 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if ((r29 & 16) != 0) {
                    r0 &= -57345;
                }
                if ((r29 & 32) != 0) {
                    r0 &= -458753;
                }
                if ((r29 & 64) != 0) {
                    r0 &= -3670017;
                }
            } else {
                if ((r29 & 16) != 0) {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                    shape2 = ((Shapes) startRestartGroup.consume(ShapesKt.LocalShapes)).small;
                    r0 &= -57345;
                }
                if ((r29 & 32) != 0) {
                    r0 &= -458753;
                    f3 = FocusedBorderThickness;
                }
                if ((r29 & 64) != 0) {
                    r0 &= -3670017;
                    f4 = UnfocusedBorderThickness;
                }
            }
            Shape shape4 = shape2;
            float f7 = f3;
            float f8 = f4;
            startRestartGroup.endDefaults();
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            int r2 = (r0 & 14) | (r0 & 112) | (r0 & 896) | (r0 & 7168);
            int r03 = r0 >> 3;
            BoxKt.Box(BorderKt.border((BorderStroke) TextFieldDefaultsKt.m212access$animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, colors, f7, f8, startRestartGroup, (57344 & r03) | r2 | (r03 & 458752)).getValue(), shape4), startRestartGroup, 0);
            shape3 = shape4;
            f5 = f7;
            f6 = f8;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$BorderBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    TextFieldDefaults.this.m211BorderBoxnbWgWpA(z, z2, interactionSource, colors, shape3, f5, f6, composer2, Strings.updateChangedFlags(r28 | 1), r29);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0262  */
    /* JADX WARN: Type inference failed for: r1v9, types: [androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void OutlinedTextFieldDecorationBox(final java.lang.String r34, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final boolean r36, final boolean r37, final androidx.compose.ui.text.input.VisualTransformation r38, final androidx.compose.foundation.interaction.InteractionSource r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.material.TextFieldColors r45, androidx.compose.foundation.layout.PaddingValues r46, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void TextFieldDecorationBox(final java.lang.String r42, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, final boolean r44, final boolean r45, final androidx.compose.ui.text.input.VisualTransformation r46, final androidx.compose.foundation.interaction.InteractionSource r47, boolean r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.material.TextFieldColors r53, androidx.compose.foundation.layout.PaddingValues r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 825
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
