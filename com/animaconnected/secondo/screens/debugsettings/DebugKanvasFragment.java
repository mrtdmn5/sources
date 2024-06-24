package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugKanvasFragment.kt */
/* loaded from: classes3.dex */
public final class DebugKanvasFragment extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "DebugKanvasFragment";

    /* compiled from: DebugKanvasFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugKanvasFragment newInstance() {
            return new DebugKanvasFragment();
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(838404225);
        if ((r9 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion.$$INSTANCE);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                ChartsKt.Scrapbook(BoxScopeInstance.INSTANCE.matchParentSize(), startRestartGroup, 0, 0);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugKanvasFragment$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    DebugKanvasFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r9 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
