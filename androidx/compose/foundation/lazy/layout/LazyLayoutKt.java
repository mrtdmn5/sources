package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: LazyLayout.kt */
/* loaded from: classes.dex */
public final class LazyLayoutKt {
    /* JADX WARN: Type inference failed for: r0v20, types: [kotlin.jvm.internal.Lambda, androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3] */
    public static final void LazyLayout(final Function0<? extends LazyLayoutItemProvider> itemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, final Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer composer, final int r14, final int r15) {
        int r0;
        int r02;
        int r2;
        int r3;
        int r32;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        ComposerImpl startRestartGroup = composer.startRestartGroup(2002163445);
        if ((r15 & 1) != 0) {
            r0 = r14 | 6;
        } else if ((r14 & 14) == 0) {
            if (startRestartGroup.changedInstance(itemProvider)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r14;
        } else {
            r0 = r14;
        }
        int r1 = r15 & 2;
        if (r1 != 0) {
            r0 |= 48;
        } else if ((r14 & 112) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r2 = 32;
            } else {
                r2 = 16;
            }
            r0 |= r2;
        }
        int r22 = r15 & 4;
        if (r22 != 0) {
            r0 |= 384;
        } else if ((r14 & 896) == 0) {
            if (startRestartGroup.changed(lazyLayoutPrefetchState)) {
                r3 = 256;
            } else {
                r3 = 128;
            }
            r0 |= r3;
        }
        if ((r15 & 8) != 0) {
            r0 |= 3072;
        } else if ((r14 & 7168) == 0) {
            if (startRestartGroup.changedInstance(measurePolicy)) {
                r32 = 2048;
            } else {
                r32 = 1024;
            }
            r0 |= r32;
        }
        final int r7 = r0;
        if ((r7 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r1 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            if (r22 != 0) {
                lazyLayoutPrefetchState = null;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final MutableState rememberUpdatedState = Platform.rememberUpdatedState(itemProvider, startRestartGroup);
            final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
            final Modifier modifier2 = modifier;
            LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.composableLambda(startRestartGroup, -1488997347, new Function3<SaveableStateHolder, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(SaveableStateHolder saveableStateHolder, Composer composer2, Integer num) {
                    SaveableStateHolder saveableStateHolder2 = saveableStateHolder;
                    Composer composer3 = composer2;
                    num.intValue();
                    Intrinsics.checkNotNullParameter(saveableStateHolder2, "saveableStateHolder");
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    Object obj = Composer.Companion.Empty;
                    if (rememberedValue == obj) {
                        rememberedValue = new LazyLayoutItemContentFactory(saveableStateHolder2, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
                            public final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            public LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1(State<? extends Function0<? extends LazyLayoutItemProvider>> state) {
                                super(0);
                                r1 = state;
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final LazyLayoutItemProvider invoke() {
                                return r1.getValue().invoke();
                            }
                        });
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) rememberedValue;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    if (rememberedValue2 == obj) {
                        rememberedValue2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) rememberedValue2;
                    composer3.startReplaceableGroup(-1523808190);
                    int r8 = r7;
                    LazyLayoutPrefetchState lazyLayoutPrefetchState3 = LazyLayoutPrefetchState.this;
                    if (lazyLayoutPrefetchState3 != null) {
                        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(lazyLayoutPrefetchState3, lazyLayoutItemContentFactory, subcomposeLayoutState, composer3, ((r8 >> 6) & 14) | 64 | DfuBaseService.ERROR_REMOTE_TYPE_SECURE);
                        Unit unit = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    Modifier modifier3 = modifier2;
                    composer3.startReplaceableGroup(511388516);
                    boolean changed = composer3.changed(lazyLayoutItemContentFactory);
                    final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = measurePolicy;
                    boolean changed2 = changed | composer3.changed(function2);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == obj) {
                        rememberedValue3 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                long j = constraints.value;
                                Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$null");
                                return function2.invoke(new LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory.this, subcomposeMeasureScope2), new Constraints(j));
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(subcomposeLayoutState, modifier3, (Function2) rememberedValue3, composer3, (r8 & 112) | 8, 0);
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 6);
        }
        final Modifier modifier3 = modifier;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState3 = lazyLayoutPrefetchState;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    LazyLayoutKt.LazyLayout(itemProvider, modifier3, lazyLayoutPrefetchState3, measurePolicy, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
