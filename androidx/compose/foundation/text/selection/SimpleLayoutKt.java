package androidx.compose.foundation.text.selection;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleLayout.kt */
/* loaded from: classes.dex */
public final class SimpleLayoutKt {
    public static final void SimpleLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r10, final int r11) {
        int r1;
        int r12;
        int r2;
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-2105228848);
        int r0 = r11 & 1;
        if (r0 != 0) {
            r1 = r10 | 6;
        } else if ((r10 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r10;
        } else {
            r1 = r10;
        }
        if ((r11 & 2) != 0) {
            r1 |= 48;
        } else if ((r10 & 112) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r2 = 32;
            } else {
                r2 = 16;
            }
            r1 |= r2;
        }
        if ((r1 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r0 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SimpleLayoutKt$SimpleLayout$1 simpleLayoutKt$SimpleLayout$1 = SimpleLayoutKt$SimpleLayout$1.INSTANCE;
            int r13 = ((r1 << 3) & 112) | ((r1 >> 3) & 14);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int r14 = ((r13 << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, simpleLayoutKt$SimpleLayout$1, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r14 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                content.invoke(startRestartGroup, Integer.valueOf((r14 >> 9) & 14));
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r10 | 1);
                    SimpleLayoutKt.SimpleLayout(Modifier.this, content, composer2, updateChangedFlags, r11);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
