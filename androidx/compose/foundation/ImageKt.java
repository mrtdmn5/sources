package androidx.compose.foundation;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
/* loaded from: classes.dex */
public final class ImageKt {
    public static final void Image(final Painter painter, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, final int r25, final int r26) {
        Modifier modifier2;
        Alignment alignment2;
        ContentScale contentScale2;
        float f2;
        ColorFilter colorFilter2;
        Intrinsics.checkNotNullParameter(painter, "painter");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1142754848);
        int r3 = r26 & 4;
        Modifier modifier3 = Modifier.Companion.$$INSTANCE;
        if (r3 != 0) {
            modifier2 = modifier3;
        } else {
            modifier2 = modifier;
        }
        if ((r26 & 8) != 0) {
            alignment2 = Alignment.Companion.Center;
        } else {
            alignment2 = alignment;
        }
        if ((r26 & 16) != 0) {
            contentScale2 = ContentScale.Companion.Fit;
        } else {
            contentScale2 = contentScale;
        }
        if ((r26 & 32) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((r26 & 64) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-816794123);
        if (str != null) {
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(str);
            Object nextSlot = startRestartGroup.nextSlot();
            if (changed || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$semantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setContentDescription(semantics, str);
                        SemanticsPropertiesKt.m506setRolekuIjeqM(semantics, 5);
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            modifier3 = SemanticsModifierKt.semantics(modifier3, false, (Function1) nextSlot);
        }
        startRestartGroup.end(false);
        Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, alignment2, contentScale2, f2, colorFilter2, 2);
        ImageKt$Image$2 imageKt$Image$2 = ImageKt$Image$2.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(paint$default);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, imageKt$Image$2, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.end(false);
            startRestartGroup.end(true);
            startRestartGroup.end(false);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier4 = modifier2;
                final Alignment alignment3 = alignment2;
                final ContentScale contentScale3 = contentScale2;
                final float f3 = f2;
                final ColorFilter colorFilter3 = colorFilter2;
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num) {
                        num.intValue();
                        ImageKt.Image(Painter.this, str, modifier4, alignment3, contentScale3, f3, colorFilter3, composer2, Strings.updateChangedFlags(r25 | 1), r26);
                        return Unit.INSTANCE;
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:            if (r9 == androidx.compose.runtime.Composer.Companion.Empty) goto L26;     */
    /* renamed from: Image-5h-nEew, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m28Image5hnEew(androidx.compose.ui.graphics.AndroidImageBitmap r17, java.lang.String r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.layout.ContentScale r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r10 = r21
            r0 = r22
            r1 = r23
            r2 = -1396260732(0xffffffffacc6c084, float:-5.648872E-12)
            r10.startReplaceableGroup(r2)
            r2 = r1 & 4
            if (r2 == 0) goto L13
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            goto L15
        L13:
            r2 = r19
        L15:
            r3 = r1 & 8
            if (r3 == 0) goto L1c
            androidx.compose.ui.BiasAlignment r3 = androidx.compose.ui.Alignment.Companion.Center
            goto L1d
        L1c:
            r3 = 0
        L1d:
            r4 = r1 & 16
            if (r4 == 0) goto L24
            androidx.compose.ui.layout.ContentScale$Companion$Fit$1 r4 = androidx.compose.ui.layout.ContentScale.Companion.Fit
            goto L26
        L24:
            r4 = r20
        L26:
            r5 = r1 & 32
            if (r5 == 0) goto L2d
            r5 = 1065353216(0x3f800000, float:1.0)
            goto L2e
        L2d:
            r5 = 0
        L2e:
            r6 = 0
            r1 = r1 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L35
            r1 = 1
            goto L36
        L35:
            r1 = 0
        L36:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r7 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            r7 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r7)
            r7 = r17
            boolean r8 = r10.changed(r7)
            java.lang.Object r9 = r21.rememberedValue()
            if (r8 != 0) goto L4e
            androidx.compose.runtime.Composer$Companion$Empty$1 r8 = androidx.compose.runtime.Composer.Companion.Empty
            if (r9 != r8) goto L69
        L4e:
            long r13 = androidx.compose.ui.unit.IntOffset.Zero
            int r8 = r17.getWidth()
            int r9 = r17.getHeight()
            long r15 = androidx.compose.ui.unit.IntSizeKt.IntSize(r8, r9)
            androidx.compose.ui.graphics.painter.BitmapPainter r9 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r11 = r9
            r12 = r17
            r11.<init>(r12, r13, r15)
            r9.filterQuality = r1
            r10.updateRememberedValue(r9)
        L69:
            r21.endReplaceableGroup()
            r1 = r9
            androidx.compose.ui.graphics.painter.BitmapPainter r1 = (androidx.compose.ui.graphics.painter.BitmapPainter) r1
            r7 = r0 & 112(0x70, float:1.57E-43)
            r7 = r7 | 8
            r8 = r0 & 896(0x380, float:1.256E-42)
            r7 = r7 | r8
            r8 = r0 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r8
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r0
            r7 = r7 | r8
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r0
            r7 = r7 | r8
            r8 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r8
            r8 = r7 | r0
            r9 = 0
            r0 = r1
            r1 = r18
            r7 = r21
            Image(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r21.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.m28Image5hnEew(androidx.compose.ui.graphics.AndroidImageBitmap, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.layout.ContentScale, androidx.compose.runtime.Composer, int, int):void");
    }
}
