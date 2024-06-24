package com.airbnb.lottie.compose;

import android.graphics.Matrix;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.utils.Utils;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: LottieAnimation.kt */
/* loaded from: classes.dex */
public final class LottieAnimationKt {
    public static final void LottieAnimation(final LottieComposition lottieComposition, final Function0<Float> progress, Modifier modifier, boolean z, boolean z2, boolean z3, RenderMode renderMode, boolean z4, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z5, Composer composer, final int r46, final int r47, final int r48) {
        ComposerImpl composerImpl;
        Intrinsics.checkNotNullParameter(progress, "progress");
        ComposerImpl startRestartGroup = composer.startRestartGroup(185150517);
        Modifier modifier2 = (r48 & 4) != 0 ? Modifier.Companion.$$INSTANCE : modifier;
        boolean z6 = (r48 & 8) != 0 ? false : z;
        boolean z7 = (r48 & 16) != 0 ? false : z2;
        boolean z8 = (r48 & 32) != 0 ? false : z3;
        RenderMode renderMode2 = (r48 & 64) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z9 = (r48 & 128) != 0 ? false : z4;
        LottieDynamicProperties lottieDynamicProperties2 = (r48 & 256) != 0 ? null : lottieDynamicProperties;
        Alignment alignment2 = (r48 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? Alignment.Companion.Center : alignment;
        ContentScale contentScale2 = (r48 & 1024) != 0 ? ContentScale.Companion.Fit : contentScale;
        boolean z10 = (r48 & 2048) != 0 ? true : z5;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = new LottieDrawable();
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        final LottieDrawable lottieDrawable = (LottieDrawable) nextSlot;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = new Matrix();
            startRestartGroup.updateValue(nextSlot2);
        }
        startRestartGroup.end(false);
        final Matrix matrix = (Matrix) nextSlot2;
        startRestartGroup.startReplaceableGroup(-3687241);
        Object nextSlot3 = startRestartGroup.nextSlot();
        if (nextSlot3 == composer$Companion$Empty$1) {
            nextSlot3 = Platform.mutableStateOf$default(null);
            startRestartGroup.updateValue(nextSlot3);
        }
        startRestartGroup.end(false);
        final MutableState mutableState = (MutableState) nextSlot3;
        startRestartGroup.startReplaceableGroup(185151250);
        if (lottieComposition != null) {
            if (!(lottieComposition.getDuration() == 0.0f)) {
                startRestartGroup.end(false);
                float dpScale = Utils.dpScale();
                Modifier m92sizeVpY3zN4 = SizeKt.m92sizeVpY3zN4(modifier2, lottieComposition.bounds.width() / dpScale, lottieComposition.bounds.height() / dpScale);
                final ContentScale contentScale3 = contentScale2;
                final Alignment alignment3 = alignment2;
                final boolean z11 = z8;
                final RenderMode renderMode3 = renderMode2;
                final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
                final boolean z12 = z6;
                final boolean z13 = z7;
                final Modifier modifier3 = modifier2;
                final boolean z14 = z9;
                final boolean z15 = z10;
                CanvasKt.Canvas(m92sizeVpY3zN4, new Function1<DrawScope, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(DrawScope drawScope) {
                        DrawScope Canvas = drawScope;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        Alignment alignment4 = alignment3;
                        Canvas canvas = Canvas.getDrawContext().getCanvas();
                        LottieComposition lottieComposition2 = LottieComposition.this;
                        long Size = androidx.compose.ui.geometry.SizeKt.Size(lottieComposition2.bounds.width(), lottieComposition2.bounds.height());
                        long IntSize = IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(Canvas.mo391getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(Canvas.mo391getSizeNHjbRc())));
                        long mo420computeScaleFactorH7hwNQA = contentScale3.mo420computeScaleFactorH7hwNQA(Size, Canvas.mo391getSizeNHjbRc());
                        long mo229alignKFBX0sM = alignment4.mo229alignKFBX0sM(IntSizeKt.IntSize((int) (ScaleFactor.m437getScaleXimpl(mo420computeScaleFactorH7hwNQA) * Size.m276getWidthimpl(Size)), (int) (ScaleFactor.m438getScaleYimpl(mo420computeScaleFactorH7hwNQA) * Size.m274getHeightimpl(Size))), IntSize, Canvas.getLayoutDirection());
                        Matrix matrix2 = matrix;
                        matrix2.reset();
                        matrix2.preTranslate((int) (mo229alignKFBX0sM >> 32), IntOffset.m590getYimpl(mo229alignKFBX0sM));
                        matrix2.preScale(ScaleFactor.m437getScaleXimpl(mo420computeScaleFactorH7hwNQA), ScaleFactor.m438getScaleYimpl(mo420computeScaleFactorH7hwNQA));
                        LottieDrawable lottieDrawable2 = lottieDrawable;
                        boolean z16 = lottieDrawable2.enableMergePaths;
                        boolean z17 = z11;
                        if (z16 != z17) {
                            lottieDrawable2.enableMergePaths = z17;
                            if (lottieDrawable2.composition != null) {
                                lottieDrawable2.buildCompositionLayer();
                            }
                        }
                        lottieDrawable2.renderMode = renderMode3;
                        lottieDrawable2.computeRenderMode();
                        lottieDrawable2.setComposition(lottieComposition2);
                        MutableState<LottieDynamicProperties> mutableState2 = mutableState;
                        LottieDynamicProperties value = mutableState2.getValue();
                        LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties3;
                        if (lottieDynamicProperties4 != value) {
                            if (mutableState2.getValue() == null) {
                                if (lottieDynamicProperties4 == null) {
                                    mutableState2.setValue(lottieDynamicProperties4);
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        }
                        boolean z18 = lottieDrawable2.outlineMasksAndMattes;
                        boolean z19 = z12;
                        if (z18 != z19) {
                            lottieDrawable2.outlineMasksAndMattes = z19;
                            CompositionLayer compositionLayer = lottieDrawable2.compositionLayer;
                            if (compositionLayer != null) {
                                compositionLayer.setOutlineMasksAndMattes(z19);
                            }
                        }
                        lottieDrawable2.isApplyingOpacityToLayersEnabled = z13;
                        lottieDrawable2.maintainOriginalImageBounds = z14;
                        boolean z20 = lottieDrawable2.clipToCompositionBounds;
                        boolean z21 = z15;
                        if (z21 != z20) {
                            lottieDrawable2.clipToCompositionBounds = z21;
                            CompositionLayer compositionLayer2 = lottieDrawable2.compositionLayer;
                            if (compositionLayer2 != null) {
                                compositionLayer2.clipToCompositionBounds = z21;
                            }
                            lottieDrawable2.invalidateSelf();
                        }
                        lottieDrawable2.setProgress(progress.invoke().floatValue());
                        lottieDrawable2.setBounds(0, 0, lottieComposition2.bounds.width(), lottieComposition2.bounds.height());
                        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
                        Intrinsics.checkNotNullParameter(canvas, "<this>");
                        android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
                        CompositionLayer compositionLayer3 = lottieDrawable2.compositionLayer;
                        LottieComposition lottieComposition3 = lottieDrawable2.composition;
                        if (compositionLayer3 != null && lottieComposition3 != null) {
                            if (lottieDrawable2.useSoftwareRendering) {
                                canvas3.save();
                                canvas3.concat(matrix2);
                                lottieDrawable2.renderAndDrawAsBitmap(canvas3, compositionLayer3);
                                canvas3.restore();
                            } else {
                                compositionLayer3.draw(canvas3, matrix2, lottieDrawable2.alpha);
                            }
                            lottieDrawable2.isDirty = false;
                        }
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 0);
                RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final boolean z16 = z6;
                final boolean z17 = z7;
                final boolean z18 = z8;
                final RenderMode renderMode4 = renderMode2;
                final boolean z19 = z9;
                final LottieDynamicProperties lottieDynamicProperties4 = lottieDynamicProperties2;
                final Alignment alignment4 = alignment2;
                final ContentScale contentScale4 = contentScale2;
                final boolean z20 = z10;
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        LottieAnimationKt.LottieAnimation(LottieComposition.this, progress, modifier3, z16, z17, z18, renderMode4, z19, lottieDynamicProperties4, alignment4, contentScale4, z20, composer2, r46 | 1, r47, r48);
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
        }
        final Modifier modifier4 = modifier2;
        startRestartGroup.end(false);
        RecomposeScopeImpl endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            composerImpl = startRestartGroup;
        } else {
            final boolean z21 = z6;
            final boolean z22 = z7;
            final boolean z23 = z8;
            final RenderMode renderMode5 = renderMode2;
            final boolean z24 = z9;
            final LottieDynamicProperties lottieDynamicProperties5 = lottieDynamicProperties2;
            final Alignment alignment5 = alignment2;
            final ContentScale contentScale5 = contentScale2;
            final boolean z25 = z10;
            composerImpl = startRestartGroup;
            endRestartGroup2.block = new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    LottieAnimationKt.LottieAnimation(LottieComposition.this, progress, modifier4, z21, z22, z23, renderMode5, z24, lottieDynamicProperties5, alignment5, contentScale5, z25, composer2, r46 | 1, r47, r48);
                    return Unit.INSTANCE;
                }
            };
        }
        BoxKt.Box(modifier4, composerImpl, (r46 >> 6) & 14);
    }

    public static final void LottieAnimation(final LottieComposition lottieComposition, Modifier modifier, boolean z, boolean z2, LottieClipSpec lottieClipSpec, float f, int r29, boolean z3, boolean z4, boolean z5, RenderMode renderMode, boolean z6, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z7, Composer composer, final int r40, final int r41, final int r42) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(185154444);
        final Modifier modifier2 = (r42 & 2) != 0 ? Modifier.Companion.$$INSTANCE : modifier;
        boolean z8 = (r42 & 4) != 0 ? true : z;
        boolean z9 = (r42 & 8) != 0 ? true : z2;
        LottieClipSpec lottieClipSpec2 = (r42 & 16) != 0 ? null : lottieClipSpec;
        float f2 = (r42 & 32) != 0 ? 1.0f : f;
        int r9 = (r42 & 64) != 0 ? 1 : r29;
        boolean z10 = (r42 & 128) != 0 ? false : z3;
        boolean z11 = (r42 & 256) != 0 ? false : z4;
        boolean z12 = (r42 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? false : z5;
        RenderMode renderMode2 = (r42 & 1024) != 0 ? RenderMode.AUTOMATIC : renderMode;
        boolean z13 = (r42 & 2048) != 0 ? false : z6;
        LottieDynamicProperties lottieDynamicProperties2 = (r42 & 4096) != 0 ? null : lottieDynamicProperties;
        Alignment alignment2 = (r42 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? Alignment.Companion.Center : alignment;
        ContentScale contentScale2 = (r42 & DfuBaseService.ERROR_CONNECTION_MASK) != 0 ? ContentScale.Companion.Fit : contentScale;
        boolean z14 = (32768 & r42) != 0 ? true : z7;
        final LottieAnimatable animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(lottieComposition, z8, z9, lottieClipSpec2, f2, r9, startRestartGroup, 192);
        startRestartGroup.startReplaceableGroup(-3686930);
        boolean changed = startRestartGroup.changed(animateLottieCompositionAsState);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            nextSlot = new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$6$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(animateLottieCompositionAsState.getValue().floatValue());
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        Function0 function0 = (Function0) nextSlot;
        int r6 = r40 >> 12;
        int r3 = ((r40 << 3) & 896) | 134217736 | (r6 & 7168) | (57344 & r6) | (r6 & 458752);
        int r62 = r41 << 18;
        int r32 = r3 | (3670016 & r62) | (29360128 & r62) | (r62 & 1879048192);
        int r63 = r41 >> 12;
        LottieAnimation(lottieComposition, function0, modifier2, z10, z11, z12, renderMode2, z13, lottieDynamicProperties2, alignment2, contentScale2, z14, startRestartGroup, r32, (r63 & 112) | (r63 & 14), 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final boolean z15 = z8;
        final boolean z16 = z9;
        final LottieClipSpec lottieClipSpec3 = lottieClipSpec2;
        final float f3 = f2;
        final int r7 = r9;
        final boolean z17 = z10;
        final boolean z18 = z11;
        final boolean z19 = z12;
        final RenderMode renderMode3 = renderMode2;
        final boolean z20 = z13;
        final LottieDynamicProperties lottieDynamicProperties3 = lottieDynamicProperties2;
        final Alignment alignment3 = alignment2;
        final ContentScale contentScale3 = contentScale2;
        final boolean z21 = z14;
        endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationKt$LottieAnimation$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LottieAnimationKt.LottieAnimation(LottieComposition.this, modifier2, z15, z16, lottieClipSpec3, f3, r7, z17, z18, z19, renderMode3, z20, lottieDynamicProperties3, alignment3, contentScale3, z21, composer2, r40 | 1, r41, r42);
                return Unit.INSTANCE;
            }
        };
    }
}
