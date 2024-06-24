package com.animaconnected.secondo.screens.workout.vo2max;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ColorResourceHelper;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.widget.compose.ChartsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.workout.FitnessIndexData;
import com.animaconnected.watch.workout.FitnessIndexKt;
import com.animaconnected.widget.BackgroundCardKt;
import com.animaconnected.widget.theme.TypographyKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutVO2MaxDetailFragment.kt */
/* loaded from: classes3.dex */
public final class WorkoutVO2MaxDetailFragment extends ComposeFragment implements Dismissible {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "WorkoutVO2MaxDetailFragment";

    /* compiled from: WorkoutVO2MaxDetailFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutVO2MaxDetailFragment newInstance() {
            return new WorkoutVO2MaxDetailFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ChartSection(final FitnessProvider.Profile profile, final FitnessIndexData fitnessIndexData, final float f, Modifier modifier, Composer composer, final int r35, final int r36) {
        Modifier modifier2;
        Integer num;
        ComposerImpl startRestartGroup = composer.startRestartGroup(199862631);
        int r1 = r36 & 8;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        int r8 = r35 >> 9;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r2 = ((((((r8 & 14) | 384) << 3) & 112) << 9) & 7168) | 6;
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r2 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            boolean z = false;
            if (fitnessIndexData == null) {
                startRestartGroup.startReplaceableGroup(-1619922779);
                EmptyState(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 16, 7), startRestartGroup, (r8 & 112) | 6, 0);
                startRestartGroup.end(false);
            } else {
                startRestartGroup.startReplaceableGroup(-1619922686);
                String valueOf = String.valueOf(fitnessIndexData.getValue());
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                TypographyKt.m1636BigTextZHfKjFs(null, valueOf, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), null, 0, 0, false, startRestartGroup, 0, 121);
                TextKt.m216Text4IGK_g(FitnessIndexKt.getName(fitnessIndexData.getCategory()), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 4, 0.0f, 0.0f, 13), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(androidx.compose.material.TypographyKt.LocalTypography)).h4, startRestartGroup, 48, 0, 65528);
                z = false;
                startRestartGroup.end(false);
            }
            float f2 = 16;
            Modifier alpha = AlphaKt.alpha(SizeKt.m83height3ABfNKs(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f2, 0.0f, f2, 5), 32), f);
            if (fitnessIndexData != null) {
                num = Integer.valueOf(fitnessIndexData.getValue());
            } else {
                num = null;
            }
            ChartsKt.FitnessIndexChart(alpha, profile, num, startRestartGroup, 64, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, z, true, z, z);
            if (m != null) {
                final Modifier modifier3 = modifier2;
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxDetailFragment$ChartSection$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                        invoke(composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r10) {
                        WorkoutVO2MaxDetailFragment.this.ChartSection(profile, fitnessIndexData, f, modifier3, composer2, Strings.updateChangedFlags(r35 | 1), r36);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void EmptyState(Modifier modifier, Composer composer, final int r19, final int r20) {
        Modifier modifier2;
        int r6;
        int r62;
        final Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1325376029);
        int r3 = r20 & 1;
        if (r3 != 0) {
            r6 = r19 | 6;
            modifier2 = modifier;
        } else if ((r19 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r19;
        } else {
            modifier2 = modifier;
            r6 = r19;
        }
        if ((r6 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r3 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            BackgroundCardKt.m1586BackgroundCardUalQlp0(modifier3, null, RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(24), null, ColorResourceHelper.INSTANCE.m504getColorWaAFU9c((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext), R.color.paletteGreyDark), 0.0f, false, ComposableSingletons$WorkoutVO2MaxDetailFragmentKt.INSTANCE.m1036getLambda1$secondo_kronabyRelease(), startRestartGroup, (r6 & 14) | 12582912, 106);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxDetailFragment$EmptyState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    WorkoutVO2MaxDetailFragment.this.EmptyState(modifier3, composer2, Strings.updateChangedFlags(r19 | 1), r20);
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r7.nextSlot(), java.lang.Integer.valueOf(r3)) == false) goto L35;     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ComposeContent(androidx.compose.runtime.Composer r45, final int r46) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.vo2max.WorkoutVO2MaxDetailFragment.ComposeContent(androidx.compose.runtime.Composer, int):void");
    }

    @Override // com.animaconnected.secondo.screens.details.Dismissible
    public void dismiss(OnDismissedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        View viewAnimContainer = getBinding().viewAnimContainer;
        Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
        AnimationFactoryKotlinKt.exitCardRevealAnim(this, root, viewAnimContainer, getCardBounds(), listener);
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
