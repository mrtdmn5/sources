package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Switch.kt */
/* loaded from: classes.dex */
public final class SwitchKt {
    public static final float SwitchHeight;
    public static final float SwitchWidth;
    public static final float ThumbDiameter;
    public static final float ThumbPathLength;
    public static final float TrackWidth;
    public static final float TrackStrokeWidth = 14;
    public static final float ThumbRippleRadius = 24;
    public static final float DefaultSwitchPadding = 2;
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(100, 0, null, 6);
    public static final float ThumbDefaultElevation = 1;
    public static final float ThumbPressedElevation = 6;
    public static final float SwitchVelocityThreshold = 125;

    static {
        float f = 34;
        TrackWidth = f;
        float f2 = 20;
        ThumbDiameter = f2;
        SwitchWidth = f;
        SwitchHeight = f2;
        ThumbPathLength = f - f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0282 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a4 A[LOOP:0: B:56:0x02a1->B:58:0x02a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02ff A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0361 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0344  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Switch(final boolean r34, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.material.SwitchColors r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0<Float> function0, final InteractionSource interactionSource, Composer composer, final int r24) {
        int r8;
        float f;
        Modifier.Companion companion;
        float f2;
        ?? r14;
        long j;
        int r9;
        int r92;
        int r93;
        int r94;
        int r95;
        int r82;
        ComposerImpl startRestartGroup = composer.startRestartGroup(70908914);
        if ((r24 & 14) == 0) {
            if (startRestartGroup.changed(boxScope)) {
                r82 = 4;
            } else {
                r82 = 2;
            }
            r8 = r82 | r24;
        } else {
            r8 = r24;
        }
        if ((r24 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r95 = 32;
            } else {
                r95 = 16;
            }
            r8 |= r95;
        }
        if ((r24 & 896) == 0) {
            if (startRestartGroup.changed(z2)) {
                r94 = 256;
            } else {
                r94 = 128;
            }
            r8 |= r94;
        }
        if ((r24 & 7168) == 0) {
            if (startRestartGroup.changed(switchColors)) {
                r93 = 2048;
            } else {
                r93 = 1024;
            }
            r8 |= r93;
        }
        if ((57344 & r24) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r92 = DfuBaseService.ERROR_CONNECTION_MASK;
            } else {
                r92 = DfuBaseService.ERROR_REMOTE_MASK;
            }
            r8 |= r92;
        }
        if ((458752 & r24) == 0) {
            if (startRestartGroup.changed(interactionSource)) {
                r9 = 131072;
            } else {
                r9 = 65536;
            }
            r8 |= r9;
        }
        if ((r8 & 374491) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            Object obj = Composer.Companion.Empty;
            if (nextSlot == obj) {
                nextSlot = new SnapshotStateList();
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            SnapshotStateList snapshotStateList = (SnapshotStateList) nextSlot;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(interactionSource) | startRestartGroup.changed(snapshotStateList);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (changed || nextSlot2 == obj) {
                nextSlot2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            EffectsKt.LaunchedEffect(interactionSource, (Function2) nextSlot2, startRestartGroup);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float f3 = f;
            final MutableState trackColor = switchColors.trackColor(z2, z, startRestartGroup);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion2, Alignment.Companion.Center));
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed(trackColor);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (changed2 || nextSlot3 == obj) {
                nextSlot3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(DrawScope drawScope) {
                        DrawScope Canvas = drawScope;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j2 = trackColor.getValue().value;
                        float mo49toPx0680j_4 = Canvas.mo49toPx0680j_4(SwitchKt.TrackWidth);
                        float mo49toPx0680j_42 = Canvas.mo49toPx0680j_4(SwitchKt.TrackStrokeWidth);
                        float f4 = mo49toPx0680j_42 / 2;
                        DrawScope.m382drawLineNGM6Ib0$default(Canvas, j2, OffsetKt.Offset(f4, Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0())), OffsetKt.Offset(mo49toPx0680j_4 - f4, Offset.m260getYimpl(Canvas.mo390getCenterF1C5BW0())), mo49toPx0680j_42, 1, 480);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) nextSlot3, startRestartGroup, 0);
            MutableState thumbColor = switchColors.thumbColor(z2, z, startRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) startRestartGroup.consume(ElevationOverlayKt.LocalElevationOverlay);
            float f4 = ((Dp) startRestartGroup.consume(ElevationOverlayKt.LocalAbsoluteElevation)).value + f3;
            startRestartGroup.startReplaceableGroup(-539243578);
            if (Color.m317equalsimpl0(((Color) thumbColor.getValue()).value, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU()) && elevationOverlay != null) {
                companion = companion2;
                f2 = f3;
                r14 = 0;
                j = elevationOverlay.mo179apply7g2Lkgo(((Color) thumbColor.getValue()).value, f4, startRestartGroup, 0);
            } else {
                companion = companion2;
                f2 = f3;
                r14 = 0;
                j = ((Color) thumbColor.getValue()).value;
            }
            startRestartGroup.end(r14);
            State m7animateColorAsStateeuL9pac = SingleValueAnimationKt.m7animateColorAsStateeuL9pac(j, null, startRestartGroup, 0, 14);
            Modifier align = boxScope.align(companion, Alignment.Companion.CenterStart);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed3 = startRestartGroup.changed(function0);
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (changed3 || nextSlot4 == obj) {
                nextSlot4 = new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final IntOffset invoke(Density density) {
                        Density offset = density;
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        return new IntOffset(IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(function0.invoke().floatValue()), 0));
                    }
                };
                startRestartGroup.updateValue(nextSlot4);
            }
            startRestartGroup.end(r14);
            Modifier m88requiredSize3ABfNKs = SizeKt.m88requiredSize3ABfNKs(IndicationKt.indication(androidx.compose.foundation.layout.OffsetKt.offset(align, (Function1) nextSlot4), interactionSource, RippleKt.m226rememberRipple9IZ8Weo(r14, ThumbRippleRadius, startRestartGroup, 54, 4)), ThumbDiameter);
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            SpacerKt.Spacer(BackgroundKt.m21backgroundbw27NRU(ShadowKt.m235shadows4CzXII$default(m88requiredSize3ABfNKs, f2, roundedCornerShape), ((Color) m7animateColorAsStateeuL9pac.getValue()).value, roundedCornerShape), startRestartGroup, r14);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    SwitchKt.SwitchImpl(BoxScope.this, z, z2, switchColors, function0, interactionSource, composer2, Strings.updateChangedFlags(r24 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
