package androidx.compose.foundation.layout;

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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Box.kt */
/* loaded from: classes.dex */
public final class BoxKt {
    public static final BoxKt$boxMeasurePolicy$1 DefaultBoxMeasurePolicy = new BoxKt$boxMeasurePolicy$1(Alignment.Companion.TopStart, false);
    public static final BoxKt$EmptyBoxMeasurePolicy$1 EmptyBoxMeasurePolicy = BoxKt$EmptyBoxMeasurePolicy$1.INSTANCE;

    public static final void Box(final Modifier modifier, Composer composer, final int r8) {
        int r0;
        int r02;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-211209833);
        if ((r8 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r8;
        } else {
            r0 = r8;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int r03 = (((((r0 << 3) & 112) | 384) << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, EmptyBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf.invoke(new SkippableUpdater(startRestartGroup), startRestartGroup, Integer.valueOf((r03 >> 3) & 112));
                startRestartGroup.startReplaceableGroup(2058660585);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$Box$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r8 | 1);
                    BoxKt.Box(Modifier.this, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$placeInBox(Placeable.PlacementScope placementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int r10, int r11, Alignment alignment) {
        BoxChildDataNode boxChildDataNode;
        Alignment alignment2;
        Alignment alignment3;
        Object parentData = measurable.getParentData();
        if (parentData instanceof BoxChildDataNode) {
            boxChildDataNode = (BoxChildDataNode) parentData;
        } else {
            boxChildDataNode = null;
        }
        if (boxChildDataNode != null && (alignment3 = boxChildDataNode.alignment) != null) {
            alignment2 = alignment3;
        } else {
            alignment2 = alignment;
        }
        long mo229alignKFBX0sM = alignment2.mo229alignKFBX0sM(IntSizeKt.IntSize(placeable.width, placeable.height), IntSizeKt.IntSize(r10, r11), layoutDirection);
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        placementScope.getClass();
        Placeable.PlacementScope.m432place70tqf50(placeable, mo229alignKFBX0sM, 0.0f);
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment alignment, boolean z, Composer composer) {
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        composer.startReplaceableGroup(56522820);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (Intrinsics.areEqual(alignment, Alignment.Companion.TopStart) && !z) {
            measurePolicy = DefaultBoxMeasurePolicy;
        } else {
            Boolean valueOf = Boolean.valueOf(z);
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(valueOf) | composer.changed(alignment);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.Empty) {
                rememberedValue = new BoxKt$boxMeasurePolicy$1(alignment, z);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) rememberedValue;
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }
}
