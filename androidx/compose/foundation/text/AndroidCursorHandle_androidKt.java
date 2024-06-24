package androidx.compose.foundation.text;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.HandleReferencePoint;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.platform.InspectableValueKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidCursorHandle.android.kt */
/* loaded from: classes.dex */
public final class AndroidCursorHandle_androidKt {
    public static final float CursorHandleHeight;
    public static final float CursorHandleWidth;

    static {
        float f = 25;
        CursorHandleHeight = f;
        CursorHandleWidth = (f * 2.0f) / 2.4142137f;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: CursorHandle-ULxng0E, reason: not valid java name */
    public static final void m113CursorHandleULxng0E(final long j, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int r12) {
        final int r0;
        int r1;
        int r13;
        int r02;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-5185995);
        if ((r12 & 14) == 0) {
            if (startRestartGroup.changed(j)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r12;
        } else {
            r0 = r12;
        }
        if ((r12 & 112) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r13 = 32;
            } else {
                r13 = 16;
            }
            r0 |= r13;
        }
        if ((r12 & 896) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r1 = 256;
            } else {
                r1 = 128;
            }
            r0 |= r1;
        }
        if ((r0 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            AndroidSelectionHandles_androidKt.m131HandlePopupULxng0E(j, HandleReferencePoint.TopMiddle, ComposableLambdaKt.composableLambda(startRestartGroup, -1458480226, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    if ((num.intValue() & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        int r4 = r0;
                        Function2<Composer, Integer, Unit> function22 = function2;
                        if (function22 == null) {
                            composer3.startReplaceableGroup(1275643833);
                            AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, composer3, (r4 >> 3) & 14);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(1275643903);
                            function22.invoke(composer3, Integer.valueOf((r4 >> 6) & 14));
                            composer3.endReplaceableGroup();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, (r0 & 14) | 432);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$CursorHandle$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AndroidCursorHandle_androidKt.m113CursorHandleULxng0E(j, modifier, function2, composer2, Strings.updateChangedFlags(r12 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void DefaultCursorHandle(final Modifier modifier, Composer composer, final int r4) {
        int r0;
        Modifier composed;
        int r02;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerImpl startRestartGroup = composer.startRestartGroup(694251107);
        if ((r4 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
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
            Modifier m92sizeVpY3zN4 = SizeKt.m92sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight);
            Intrinsics.checkNotNullParameter(m92sizeVpY3zN4, "<this>");
            composed = ComposedModifierKt.composed(m92sizeVpY3zN4, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1
                @Override // kotlin.jvm.functions.Function3
                public final Modifier invoke(Modifier modifier2, Composer composer2, Integer num) {
                    Modifier modifier3 = modifier2;
                    Composer composer3 = composer2;
                    EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier3, "$this$composed", composer3, -2126899193);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    final long j = ((TextSelectionColors) composer3.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor;
                    Color color = new Color(j);
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed = composer3.changed(color);
                    Object rememberedValue = composer3.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                ColorFilter porterDuffColorFilter;
                                CacheDrawScope drawWithCache = cacheDrawScope;
                                Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                                final float m276getWidthimpl = Size.m276getWidthimpl(drawWithCache.m231getSizeNHjbRc()) / 2.0f;
                                final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, m276getWidthimpl);
                                int r2 = Build.VERSION.SDK_INT;
                                long j2 = j;
                                if (r2 >= 29) {
                                    porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(j2, 5);
                                } else {
                                    porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(j2), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                                }
                                final androidx.compose.ui.graphics.ColorFilter colorFilter = new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter);
                                return drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ContentDrawScope contentDrawScope) {
                                        ContentDrawScope onDrawWithContent = contentDrawScope;
                                        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                                        onDrawWithContent.drawContent();
                                        CanvasDrawScope$drawContext$1 drawContext = onDrawWithContent.getDrawContext();
                                        long mo370getSizeNHjbRc = drawContext.mo370getSizeNHjbRc();
                                        drawContext.getCanvas().save();
                                        float f = m276getWidthimpl;
                                        CanvasDrawScopeKt$asDrawTransform$1 canvasDrawScopeKt$asDrawTransform$1 = drawContext.transform;
                                        canvasDrawScopeKt$asDrawTransform$1.translate(f, 0.0f);
                                        canvasDrawScopeKt$asDrawTransform$1.m374rotateUv8p0NA(Offset.Zero);
                                        onDrawWithContent.mo360drawImagegbVJVH8(createHandleImage, Offset.Zero, 1.0f, Fill.INSTANCE, colorFilter, 3);
                                        drawContext.getCanvas().restore();
                                        drawContext.mo371setSizeuvyYCjk(mo370getSizeNHjbRc);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    Modifier then = modifier3.then(DrawModifierKt.drawWithCache((Function1) rememberedValue));
                    composer3.endReplaceableGroup();
                    return then;
                }
            });
            SpacerKt.Spacer(composed, startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$DefaultCursorHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r4 | 1);
                    AndroidCursorHandle_androidKt.DefaultCursorHandle(Modifier.this, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
