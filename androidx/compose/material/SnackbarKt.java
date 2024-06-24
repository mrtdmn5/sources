package androidx.compose.material;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Dp;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snackbar.kt */
/* loaded from: classes.dex */
public final class SnackbarKt {
    public static final float HorizontalSpacingButtonSide;
    public static final float TextEndExtraSpacing;
    public static final float HeightToFirstLine = 30;
    public static final float HorizontalSpacing = 16;
    public static final float SeparateButtonExtraY = 2;
    public static final float SnackbarVerticalPadding = 6;
    public static final float LongButtonVerticalOffset = 12;
    public static final float SnackbarMinHeightOneLine = 48;
    public static final float SnackbarMinHeightTwoLines = 68;

    static {
        float f = 8;
        HorizontalSpacingButtonSide = f;
        TextEndExtraSpacing = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c6  */
    /* JADX WARN: Type inference failed for: r13v8, types: [androidx.compose.material.SnackbarKt$Snackbar$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m202Snackbar7zSek6w(androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m202Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c9  */
    /* JADX WARN: Type inference failed for: r12v6, types: [androidx.compose.material.SnackbarKt$Snackbar$actionComposable$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r2v30, types: [androidx.compose.material.SnackbarKt$Snackbar$3, kotlin.jvm.internal.Lambda] */
    /* renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m203SnackbarsPrSdHI(final androidx.compose.material.SnackbarData r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.ui.graphics.Shape r32, long r33, long r35, long r37, float r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m203SnackbarsPrSdHI(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void access$NewLineButtonSnackbar(final Function2 function2, final Function2 function22, Composer composer, final int r21) {
        int r4;
        Modifier modifier;
        int r5;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1229075900);
        if ((r21 & 14) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r21;
        } else {
            r4 = r21;
        }
        if ((r21 & 112) == 0) {
            if (startRestartGroup.changedInstance(function22)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        if ((r4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier modifier2 = Modifier.Companion.$$INSTANCE;
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(modifier2, 1.0f);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(fillMaxWidth, f, 0.0f, f2, SeparateButtonExtraY, 2);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                float f3 = HeightToFirstLine;
                if (!Dp.m579equalsimpl0(f3, Float.NaN)) {
                    modifier = AlignmentLineKt.m59paddingFrom4j6BHR0$default(androidx.compose.ui.layout.AlignmentLineKt.FirstBaseline, f3, 0.0f, 4);
                } else {
                    modifier = modifier2;
                }
                float f4 = LongButtonVerticalOffset;
                if (!Dp.m579equalsimpl0(f4, Float.NaN)) {
                    modifier2 = AlignmentLineKt.m59paddingFrom4j6BHR0$default(androidx.compose.ui.layout.AlignmentLineKt.LastBaseline, 0.0f, f4, 2);
                }
                Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(modifier.then(modifier2), 0.0f, 0.0f, f2, 0.0f, 11);
                startRestartGroup.startReplaceableGroup(733328855);
                BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default2);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    function2.invoke(startRestartGroup, Integer.valueOf(r4 & 14));
                    startRestartGroup.end(false);
                    startRestartGroup.end(true);
                    startRestartGroup.end(false);
                    startRestartGroup.end(false);
                    HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(Alignment.Companion.End);
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(horizontalAlignElement);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                        function22.invoke(startRestartGroup, Integer.valueOf((r4 >> 3) & 14));
                        startRestartGroup.end(false);
                        startRestartGroup.end(true);
                        startRestartGroup.end(false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                        startRestartGroup.end(false);
                    } else {
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r21 | 1);
                    SnackbarKt.access$NewLineButtonSnackbar(function2, function22, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$OneRowSnackbar(final Function2 function2, final Function2 function22, Composer composer, final int r19) {
        int r4;
        int r5;
        int r42;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-534813202);
        if ((r19 & 14) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r42 | r19;
        } else {
            r4 = r19;
        }
        if ((r19 & 112) == 0) {
            if (startRestartGroup.changedInstance(function22)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        if ((r4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10);
            SnackbarKt$OneRowSnackbar$2 snackbarKt$OneRowSnackbar$2 = new SnackbarKt$OneRowSnackbar$2();
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, snackbarKt$OneRowSnackbar$2, composeUiNode$Companion$SetMeasurePolicy$1);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(LayoutIdKt.layoutId("text"), 0.0f, SnackbarVerticalPadding, 1);
                startRestartGroup.startReplaceableGroup(733328855);
                BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m73paddingVpY3zN4$default);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    function2.invoke(startRestartGroup, Integer.valueOf(r4 & 14));
                    startRestartGroup.end(false);
                    startRestartGroup.end(true);
                    startRestartGroup.end(false);
                    startRestartGroup.end(false);
                    Modifier layoutId = LayoutIdKt.layoutId(AnalyticsConstants.KEY_ACTION);
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                        function22.invoke(startRestartGroup, Integer.valueOf((r4 >> 3) & 14));
                        startRestartGroup.end(false);
                        startRestartGroup.end(true);
                        startRestartGroup.end(false);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                    } else {
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r19 | 1);
                    SnackbarKt.access$OneRowSnackbar(function2, function22, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$TextOnlySnackbar(final Function2 function2, Composer composer, final int r15) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(917397959);
        if ((r15 & 14) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r15;
        } else {
            r0 = r15;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SnackbarKt$TextOnlySnackbar$2 snackbarKt$TextOnlySnackbar$2 = SnackbarKt$TextOnlySnackbar$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            Applier<?> applier = startRestartGroup.applier;
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Updater.m228setimpl(startRestartGroup, snackbarKt$TextOnlySnackbar$2, composeUiNode$Companion$SetMeasurePolicy$1);
                ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                Modifier m72paddingVpY3zN4 = PaddingKt.m72paddingVpY3zN4(companion, HorizontalSpacing, SnackbarVerticalPadding);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m72paddingVpY3zN4);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    function2.invoke(startRestartGroup, Integer.valueOf(r0 & 14));
                    startRestartGroup.end(false);
                    startRestartGroup.end(true);
                    startRestartGroup.end(false);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r15 | 1);
                    SnackbarKt.access$TextOnlySnackbar(function2, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
