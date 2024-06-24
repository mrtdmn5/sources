package com.animaconnected.widget;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Text.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$TextKt {
    public static final ComposableSingletons$TextKt INSTANCE = new ComposableSingletons$TextKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f122lambda1 = ComposableLambdaKt.composableLambdaInstance(1833626135, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TextKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r276) {
            if ((r276 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 8);
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
            PersistentCompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
            if (composer.getApplier() instanceof Applier) {
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    composer.useNode();
                }
                Updater.m228setimpl(composer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer), composer, 2058660585);
                TextKt.m1633CapsTextfLXpl1I("CapsText", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H1 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h1, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H2 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h2, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H3 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h3, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H4 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h4, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H5 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h5, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("H5 style", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).h6, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("Body1: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ercitation ullamco laboris nisi ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).body1, composer, 0, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("Body2: Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ercitation ullamco laboris nisi ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).body2, composer, 0, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("Button ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).button, composer, 6, 0, 65534);
                androidx.compose.material.TextKt.m216Text4IGK_g("Caption ", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.getTypography(composer).caption, composer, 6, 0, 65534);
                DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer);
                return;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f123lambda2 = ComposableLambdaKt.composableLambdaInstance(870123334, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TextKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.access$AllTexts(composer, 0);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f124lambda3 = ComposableLambdaKt.composableLambdaInstance(-657591748, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.ComposableSingletons$TextKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.access$AllTexts(composer, 0);
            }
        }
    }, false);

    /* renamed from: getLambda-1$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1599getLambda1$widget_release() {
        return f122lambda1;
    }

    /* renamed from: getLambda-2$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1600getLambda2$widget_release() {
        return f123lambda2;
    }

    /* renamed from: getLambda-3$widget_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1601getLambda3$widget_release() {
        return f124lambda3;
    }
}
