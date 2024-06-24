package androidx.compose.ui.layout;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
/* loaded from: classes.dex */
public final class LayoutKt {
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.layout.LayoutKt$materializerOf$1, kotlin.jvm.internal.Lambda] */
    public static final ComposableLambdaImpl modifierMaterializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOf$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                Composer composer2 = skippableUpdater.composer;
                Composer composer3 = composer;
                num.intValue();
                Intrinsics.checkNotNullParameter(composer2, "$this$null");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, Modifier.this);
                composer2.startReplaceableGroup(509942095);
                ComposeUiNode.Companion.getClass();
                Updater.m228setimpl(composer2, materializeModifier, ComposeUiNode.Companion.SetModifier);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                composer2.endReplaceableGroup();
                return Unit.INSTANCE;
            }
        }, true);
    }
}
