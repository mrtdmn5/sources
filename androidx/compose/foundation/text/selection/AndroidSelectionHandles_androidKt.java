package androidx.compose.foundation.text.selection;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
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
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AndroidSelectionHandles.android.kt */
/* loaded from: classes.dex */
public final class AndroidSelectionHandles_androidKt {
    public static final void DefaultSelectionHandle(final Modifier modifier, final boolean z, final ResolvedTextDirection direction, final boolean z2, Composer composer, final int r12) {
        int r0;
        Modifier composed;
        int r1;
        int r13;
        int r14;
        int r02;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(direction, "direction");
        ComposerImpl startRestartGroup = composer.startRestartGroup(47957398);
        if ((r12 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r12;
        } else {
            r0 = r12;
        }
        if ((r12 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r14 = 32;
            } else {
                r14 = 16;
            }
            r0 |= r14;
        }
        if ((r12 & 896) == 0) {
            if (startRestartGroup.changed(direction)) {
                r13 = 256;
            } else {
                r13 = 128;
            }
            r0 |= r13;
        }
        if ((r12 & 7168) == 0) {
            if (startRestartGroup.changed(z2)) {
                r1 = 2048;
            } else {
                r1 = 1024;
            }
            r0 |= r1;
        }
        if ((r0 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m92sizeVpY3zN4 = SizeKt.m92sizeVpY3zN4(modifier, SelectionHandlesKt.HandleWidth, SelectionHandlesKt.HandleHeight);
            Intrinsics.checkNotNullParameter(m92sizeVpY3zN4, "<this>");
            composed = ComposedModifierKt.composed(m92sizeVpY3zN4, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Modifier invoke(Modifier modifier2, Composer composer2, Integer num) {
                    Modifier modifier3 = modifier2;
                    Composer composer3 = composer2;
                    EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier3, "$this$composed", composer3, -1538687176);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    final long j = ((TextSelectionColors) composer3.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor;
                    Color color = new Color(j);
                    Boolean valueOf = Boolean.valueOf(z);
                    Boolean valueOf2 = Boolean.valueOf(z2);
                    final ResolvedTextDirection resolvedTextDirection = direction;
                    Object[] objArr = {color, valueOf, resolvedTextDirection, valueOf2};
                    final boolean z3 = z;
                    final boolean z4 = z2;
                    composer3.startReplaceableGroup(-568225417);
                    boolean z5 = false;
                    for (int r03 = 0; r03 < 4; r03++) {
                        z5 |= composer3.changed(objArr[r03]);
                    }
                    Object rememberedValue = composer3.rememberedValue();
                    if (z5 || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                ColorFilter porterDuffColorFilter;
                                CacheDrawScope drawWithCache = cacheDrawScope;
                                Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                                final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(drawWithCache, Size.m276getWidthimpl(drawWithCache.m231getSizeNHjbRc()) / 2.0f);
                                int r04 = Build.VERSION.SDK_INT;
                                long j2 = j;
                                if (r04 >= 29) {
                                    porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(j2, 5);
                                } else {
                                    porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(j2), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                                }
                                final androidx.compose.ui.graphics.ColorFilter colorFilter = new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter);
                                final boolean z6 = z3;
                                final ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
                                final boolean z7 = z4;
                                return drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:            if (r1 != false) goto L22;     */
                                    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:            if (r0 == false) goto L22;     */
                                    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:            if (r1 == false) goto L22;     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                                    */
                                    public final kotlin.Unit invoke(androidx.compose.ui.graphics.drawscope.ContentDrawScope r9) {
                                        /*
                                            r8 = this;
                                            androidx.compose.ui.graphics.drawscope.ContentDrawScope r9 = (androidx.compose.ui.graphics.drawscope.ContentDrawScope) r9
                                            java.lang.String r0 = "$this$onDrawWithContent"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                                            r9.drawContent()
                                            androidx.compose.ui.text.style.ResolvedTextDirection r0 = r2
                                            boolean r1 = r3
                                            boolean r2 = r1
                                            java.lang.String r3 = "direction"
                                            r4 = 1
                                            r5 = 0
                                            if (r2 == 0) goto L26
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
                                            androidx.compose.ui.text.style.ResolvedTextDirection r2 = androidx.compose.ui.text.style.ResolvedTextDirection.Ltr
                                            if (r0 != r2) goto L1f
                                            if (r1 == 0) goto L3c
                                        L1f:
                                            androidx.compose.ui.text.style.ResolvedTextDirection r2 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
                                            if (r0 != r2) goto L3b
                                            if (r1 == 0) goto L3b
                                            goto L3c
                                        L26:
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
                                            androidx.compose.ui.text.style.ResolvedTextDirection r2 = androidx.compose.ui.text.style.ResolvedTextDirection.Ltr
                                            if (r0 != r2) goto L2f
                                            if (r1 == 0) goto L35
                                        L2f:
                                            androidx.compose.ui.text.style.ResolvedTextDirection r2 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
                                            if (r0 != r2) goto L37
                                            if (r1 == 0) goto L37
                                        L35:
                                            r0 = r4
                                            goto L38
                                        L37:
                                            r0 = r5
                                        L38:
                                            if (r0 != 0) goto L3b
                                            goto L3c
                                        L3b:
                                            r4 = r5
                                        L3c:
                                            androidx.compose.ui.graphics.ColorFilter r0 = r5
                                            androidx.compose.ui.graphics.ImageBitmap r1 = r4
                                            if (r4 == 0) goto L68
                                            long r2 = r9.mo390getCenterF1C5BW0()
                                            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1 r4 = r9.getDrawContext()
                                            long r5 = r4.mo370getSizeNHjbRc()
                                            androidx.compose.ui.graphics.Canvas r7 = r4.getCanvas()
                                            r7.save()
                                            androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1 r7 = r4.transform
                                            r7.m375scale0AR0LA0(r2)
                                            androidx.compose.ui.graphics.drawscope.DrawScope.m380drawImagegbVJVH8$default(r9, r1, r0)
                                            androidx.compose.ui.graphics.Canvas r9 = r4.getCanvas()
                                            r9.restore()
                                            r4.mo371setSizeuvyYCjk(r5)
                                            goto L6b
                                        L68:
                                            androidx.compose.ui.graphics.drawscope.DrawScope.m380drawImagegbVJVH8$default(r9, r1, r0)
                                        L6b:
                                            kotlin.Unit r9 = kotlin.Unit.INSTANCE
                                            return r9
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.AnonymousClass1.invoke(java.lang.Object):java.lang.Object");
                                    }
                                });
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    Modifier then = modifier3.then(DrawModifierKt.drawWithCache((Function1) rememberedValue));
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                    composer3.endReplaceableGroup();
                    return then;
                }
            });
            SpacerKt.Spacer(composed, startRestartGroup, 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AndroidSelectionHandles_androidKt.DefaultSelectionHandle(Modifier.this, z, direction, z2, composer2, Strings.updateChangedFlags(r12 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* renamed from: HandlePopup-ULxng0E, reason: not valid java name */
    public static final void m131HandlePopupULxng0E(final long j, final HandleReferencePoint handleReferencePoint, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r13) {
        int r0;
        int r1;
        int r12;
        int r02;
        Intrinsics.checkNotNullParameter(handleReferencePoint, "handleReferencePoint");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1409050158);
        if ((r13 & 14) == 0) {
            if (startRestartGroup.changed(j)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r13;
        } else {
            r0 = r13;
        }
        if ((r13 & 112) == 0) {
            if (startRestartGroup.changed(handleReferencePoint)) {
                r12 = 32;
            } else {
                r12 = 16;
            }
            r0 |= r12;
        }
        if ((r13 & 896) == 0) {
            if (startRestartGroup.changedInstance(content)) {
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
            long IntOffset = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(j)), MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(j)));
            IntOffset intOffset = new IntOffset(IntOffset);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(intOffset) | startRestartGroup.changed(handleReferencePoint);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = new HandlePositionProvider(handleReferencePoint, IntOffset);
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            AndroidPopup_androidKt.Popup((HandlePositionProvider) nextSlot, null, new PopupProperties(false, true, 15), content, startRestartGroup, ((r0 << 3) & 7168) | 384, 2);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AndroidSelectionHandles_androidKt.m131HandlePopupULxng0E(j, handleReferencePoint, content, composer2, Strings.updateChangedFlags(r13 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a6, code lost:            if (r22 == false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:            if (r22 != false) goto L71;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00be, code lost:            if (r2 == false) goto L71;     */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandle$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: SelectionHandle-8fL75-g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m132SelectionHandle8fL75g(final long r18, final boolean r20, final androidx.compose.ui.text.style.ResolvedTextDirection r21, final boolean r22, final androidx.compose.ui.Modifier r23, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m132SelectionHandle8fL75g(long, boolean, androidx.compose.ui.text.style.ResolvedTextDirection, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:            if (r1 > r2.getHeight()) goto L9;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.graphics.ImageBitmap createHandleImage(androidx.compose.ui.draw.CacheDrawScope r25, float r26) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.createHandleImage(androidx.compose.ui.draw.CacheDrawScope, float):androidx.compose.ui.graphics.ImageBitmap");
    }
}
