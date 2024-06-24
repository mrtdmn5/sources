package com.animaconnected.widget;

import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Switch2.kt */
/* loaded from: classes3.dex */
public final class SwitchDefaults2 {
    public static final int $stable = 0;
    public static final SwitchDefaults2 INSTANCE = new SwitchDefaults2();

    private SwitchDefaults2() {
    }

    /* renamed from: colors-SQMK_m0, reason: not valid java name */
    public final SwitchColors2 m1632colorsSQMK_m0(long j, long j2, float f, long j3, long j4, float f2, long j5, long j6, long j7, long j8, Composer composer, int r36, int r37, int r38) {
        long j9;
        long j10;
        float f3;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long Color;
        long Color2;
        long Color3;
        long Color4;
        long Color5;
        long Color6;
        long Color7;
        long Color8;
        composer.startReplaceableGroup(-380887170);
        if ((r38 & 1) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            j9 = ((Colors) composer.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
        } else {
            j9 = j;
        }
        if ((r38 & 2) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            j10 = ((Colors) composer.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU();
        } else {
            j10 = j2;
        }
        float f4 = 1.0f;
        if ((r38 & 4) != 0) {
            f3 = 1.0f;
        } else {
            f3 = f;
        }
        if ((r38 & 8) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
            j11 = ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
        } else {
            j11 = j3;
        }
        if ((r38 & 16) != 0) {
            j12 = j10;
        } else {
            j12 = j4;
        }
        if ((r38 & 32) == 0) {
            f4 = f2;
        }
        if ((r38 & 64) != 0) {
            Color8 = ColorKt.Color(Color.m322getRedimpl(j9), Color.m321getGreenimpl(j9), Color.m319getBlueimpl(j9), ContentAlpha.getDisabled(composer, 0), Color.m320getColorSpaceimpl(j9));
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
            j13 = j9;
            j14 = ColorKt.m324compositeOverOWjLjI(Color8, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU());
        } else {
            j13 = j9;
            j14 = j5;
        }
        if ((r38 & 128) != 0) {
            Color7 = ColorKt.Color(Color.m322getRedimpl(j10), Color.m321getGreenimpl(j10), Color.m319getBlueimpl(j10), ContentAlpha.getDisabled(composer, 0), Color.m320getColorSpaceimpl(j10));
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$15 = ComposerKt.removeCurrentGroupInstance;
            j15 = j14;
            j16 = ColorKt.m324compositeOverOWjLjI(Color7, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU());
        } else {
            j15 = j14;
            j16 = j6;
        }
        if ((r38 & 256) != 0) {
            Color6 = ColorKt.Color(Color.m322getRedimpl(j11), Color.m321getGreenimpl(j11), Color.m319getBlueimpl(j11), ContentAlpha.getDisabled(composer, 0), Color.m320getColorSpaceimpl(j11));
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$16 = ComposerKt.removeCurrentGroupInstance;
            j17 = j11;
            j18 = ColorKt.m324compositeOverOWjLjI(Color6, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU());
        } else {
            j17 = j11;
            j18 = j7;
        }
        if ((r38 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            Color5 = ColorKt.Color(Color.m322getRedimpl(j12), Color.m321getGreenimpl(j12), Color.m319getBlueimpl(j12), ContentAlpha.getDisabled(composer, 0), Color.m320getColorSpaceimpl(j12));
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$17 = ComposerKt.removeCurrentGroupInstance;
            j19 = ColorKt.m324compositeOverOWjLjI(Color5, ((Colors) composer.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU());
        } else {
            j19 = j8;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$18 = ComposerKt.removeCurrentGroupInstance;
        Color = ColorKt.Color(Color.m322getRedimpl(j10), Color.m321getGreenimpl(j10), Color.m319getBlueimpl(j10), f3, Color.m320getColorSpaceimpl(j10));
        Color2 = ColorKt.Color(Color.m322getRedimpl(j12), Color.m321getGreenimpl(j12), Color.m319getBlueimpl(j12), f4, Color.m320getColorSpaceimpl(j12));
        Color3 = ColorKt.Color(Color.m322getRedimpl(j16), Color.m321getGreenimpl(j16), Color.m319getBlueimpl(j16), f3, Color.m320getColorSpaceimpl(j16));
        Color4 = ColorKt.Color(Color.m322getRedimpl(j19), Color.m321getGreenimpl(j19), Color.m319getBlueimpl(j19), f4, Color.m320getColorSpaceimpl(j19));
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j13, Color, j17, Color2, j15, Color3, j18, Color4, null);
        composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
