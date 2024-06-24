package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.style.TextAlign;
import androidx.core.graphics.drawable.DrawableKt;
import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.watch.account.HttpUtilsKt;
import com.animaconnected.widget.LoadingIndicatorKt;
import com.animaconnected.widget.Switch2Kt;
import com.animaconnected.widget.theme.TypographyKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: AppsNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class AppsNotificationsFragmentKt {
    public static final void AllAppsRow(final boolean z, final Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, final int r15) {
        long Color;
        ComposerImpl startRestartGroup = composer.startRestartGroup(79108761);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
        Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            String stringResource = URLProtocolKt.stringResource(R.string.nft_title_all_important_app, startRestartGroup);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            TypographyKt.m1637ButtonBigTextOxOnQKw(null, stringResource, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), null, startRestartGroup, 0, 9);
            AppSwitch(z, new AppsNotificationsFragmentKt$AllAppsRow$1$1(function2, null), startRestartGroup, (r15 & 14) | 64);
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            Color = ColorKt.Color(Color.m322getRedimpl(r1), Color.m321getGreenimpl(r1), Color.m319getBlueimpl(r1), 0.5f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU()));
            float f = 16;
            DividerKt.m180DivideroMI9zvI(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, f, 5), Color, 0.0f, 0.0f, startRestartGroup, 6, 12);
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AllAppsRow$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r4) {
                        AppsNotificationsFragmentKt.AllAppsRow(z, function2, composer2, Strings.updateChangedFlags(r15 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void AppRow(final AppState appState, final boolean z, final Function4<? super String, ? super String, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4, Composer composer, final int r33) {
        boolean z2;
        boolean z3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-370685309);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, 0.0f, 0.0f, 16, 7);
        Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
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
            Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            if (2.0f > 0.0d) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(2.0f, true);
                companion.then(layoutWeightElement);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutWeightElement);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    ImageKt.m28Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(appState.getIcon(), 0, 0, 7)), "", SizeKt.m91size3ABfNKs(companion, 36), null, startRestartGroup, 440, 248);
                    TextKt.m216Text4IGK_g(appState.getName(), PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 8, 0.0f, 2), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, new TextAlign(5), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(androidx.compose.material.TypographyKt.LocalTypography)).h3, startRestartGroup, 48, 0, 65016);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    if (!appState.isSelected() && !z) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    AppSwitch(z3, new AppsNotificationsFragmentKt$AppRow$1$2(function4, appState, null), startRestartGroup, 64);
                    RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                    if (m != null) {
                        m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppRow$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int r5) {
                                AppsNotificationsFragmentKt.AppRow(AppState.this, z, function4, composer2, Strings.updateChangedFlags(r33 | 1));
                            }
                        };
                        return;
                    }
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 2.0f, "; must be greater than zero").toString());
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void AppSwitch(final boolean z, final Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, final int r13) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(551664231);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-770793690);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(Boolean.TRUE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        startRestartGroup.startReplaceableGroup(773894976);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot2).coroutineScope;
        startRestartGroup.end(false);
        Switch2Kt.Switch2(z, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppSwitch$1

            /* compiled from: AppsNotificationsFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppSwitch$1$1", f = "AppsNotificationsFragment.kt", l = {HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE, Constants.NO_SUCH_BUCKET_STATUS_CODE}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppSwitch$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<Boolean> $enabled$delegate;
                final /* synthetic */ boolean $isChecked;
                final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> $onCheckedChange;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, boolean z, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onCheckedChange = function2;
                    this.$isChecked = z;
                    this.$enabled$delegate = mutableState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onCheckedChange, this.$isChecked, this.$enabled$delegate, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 != 1) {
                            if (r1 == 2) {
                                ResultKt.throwOnFailure(obj);
                                AppsNotificationsFragmentKt.AppSwitch$lambda$9(this.$enabled$delegate, true);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        AppsNotificationsFragmentKt.AppSwitch$lambda$9(this.$enabled$delegate, false);
                        Function2<Boolean, Continuation<? super Unit>, Object> function2 = this.$onCheckedChange;
                        Boolean valueOf = Boolean.valueOf(this.$isChecked);
                        this.label = 1;
                        if (function2.invoke(valueOf, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    this.label = 2;
                    if (DelayKt.delay(50L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    AppsNotificationsFragmentKt.AppSwitch$lambda$9(this.$enabled$delegate, true);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z2) {
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(function2, z2, mutableState, null), 3);
            }
        }, null, AppSwitch$lambda$8(mutableState), null, null, startRestartGroup, r13 & 14, 52);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppSwitch$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r4) {
                    AppsNotificationsFragmentKt.AppSwitch(z, function2, composer2, Strings.updateChangedFlags(r13 | 1));
                }
            };
        }
    }

    private static final boolean AppSwitch$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void AppSwitch$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void ApplyParallaxEffectOnScroll(GraphicsLayerScope graphicsLayerScope, LazyListState lazyListState, float f, float f2) {
        int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
        List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
        float f3 = firstVisibleItemScrollOffset;
        float f4 = 1.0f;
        graphicsLayerScope.setTranslationY(RangesKt___RangesKt.coerceIn(f2, 0.1f, 1.0f) * f3);
        if ((!visibleItemsInfo.isEmpty()) && lazyListState.getFirstVisibleItemIndex() == 0) {
            f4 = 1.0f - ((f * f3) / visibleItemsInfo.get(0).getSize());
        }
        graphicsLayerScope.setAlpha(f4);
    }

    public static final void AppsList(Modifier modifier, final AppsUIState appsUIState, final Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, final Function4<? super String, ? super String, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function4, final boolean z, Composer composer, final int r25, final int r26) {
        Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1089262525);
        if ((r26 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(startRestartGroup);
        Boolean valueOf = Boolean.valueOf(!z);
        startRestartGroup.startReplaceableGroup(-1503738583);
        boolean changed = startRestartGroup.changed(rememberLazyListState);
        Object nextSlot = startRestartGroup.nextSlot();
        if (changed || nextSlot == Composer.Companion.Empty) {
            nextSlot = new AppsNotificationsFragmentKt$AppsList$1$1(rememberLazyListState, null);
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        EffectsKt.LaunchedEffect(valueOf, (Function2) nextSlot, startRestartGroup);
        LazyDslKt.LazyColumn(modifier2, rememberLazyListState, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                invoke2(lazyListScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$1, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$2, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r5v2, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final LazyListState lazyListState = rememberLazyListState;
                final boolean z2 = z;
                LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(670292439, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                        invoke(lazyItemScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer2, int r9) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((r9 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, 40, 0.0f, 48, 5);
                        composer2.startReplaceableGroup(-2055053744);
                        boolean changed2 = composer2.changed(LazyListState.this);
                        final LazyListState lazyListState2 = LazyListState.this;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed2 || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$1$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                    invoke2(graphicsLayerScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GraphicsLayerScope graphicsLayer) {
                                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                                    AppsNotificationsFragmentKt.ApplyParallaxEffectOnScroll(graphicsLayer, LazyListState.this, 3.0f, 0.6f);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        AppsNotificationsFragmentKt.Description(GraphicsLayerModifierKt.graphicsLayer(m75paddingqDBjuR0$default, (Function1) rememberedValue), z2, composer2, 0, 0);
                    }
                }, true));
                final boolean z3 = z;
                final AppsUIState appsUIState2 = AppsUIState.this;
                final Function2<Boolean, Continuation<? super Unit>, Object> function22 = function2;
                LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1532326222, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2.2

                    /* compiled from: AppsNotificationsFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$2$1", f = "AppsNotificationsFragment.kt", l = {276}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> $onAllToggle;
                        /* synthetic */ boolean Z$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public AnonymousClass1(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$onAllToggle = function2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onAllToggle, continuation);
                            anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                            return invoke(bool.booleanValue(), continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                boolean z = this.Z$0;
                                Function2<Boolean, Continuation<? super Unit>, Object> function2 = this.$onAllToggle;
                                Boolean valueOf = Boolean.valueOf(z);
                                this.label = 1;
                                if (function2.invoke(valueOf, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            return Unit.INSTANCE;
                        }

                        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                        invoke(lazyItemScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer2, int r29) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((r29 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        if (z3 && appsUIState2.getFilteredApps().isEmpty()) {
                            composer2.startReplaceableGroup(-2055053307);
                            TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.filtered_notifications_search_no_results_found, composer2), PaddingKt.m75paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, 4, 0.0f, 0.0f, 13), ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(androidx.compose.material.TypographyKt.LocalTypography)).h3, composer2, 48, 0, 65528);
                            composer2.endReplaceableGroup();
                            return;
                        }
                        if (!z3 && (!appsUIState2.getFilteredApps().isEmpty())) {
                            composer2.startReplaceableGroup(-2055052927);
                            AppsNotificationsFragmentKt.AllAppsRow(appsUIState2.getAllEnabled(), new AnonymousClass1(function22, null), composer2, 64);
                            composer2.endReplaceableGroup();
                        } else if (!appsUIState2.getFilteredApps().isEmpty()) {
                            composer2.startReplaceableGroup(-2055052683);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-2055052723);
                            LoadingIndicatorKt.CircularLoadingIndicator(null, composer2, 0, 1);
                            composer2.endReplaceableGroup();
                        }
                    }
                }, true));
                final List<AppState> filteredApps = AppsUIState.this.getFilteredApps();
                final AppsUIState appsUIState3 = AppsUIState.this;
                final Function4<String, String, Boolean, Continuation<? super Unit>, Object> function42 = function4;
                final AppsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$1 appsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(AppState appState) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((AppState) obj);
                    }
                };
                LazyColumn.items(filteredApps.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(filteredApps.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$2$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r4, Composer composer2, int r6) {
                        int r3;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r6 & 14) == 0) {
                            r3 = (composer2.changed(items) ? 4 : 2) | r6;
                        } else {
                            r3 = r6;
                        }
                        if ((r6 & 112) == 0) {
                            r3 |= composer2.changed(r4) ? 32 : 16;
                        }
                        if ((r3 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            AppsNotificationsFragmentKt.AppRow((AppState) filteredApps.get(r4), appsUIState3.getAllEnabled(), new AppsNotificationsFragmentKt$AppsList$2$3$1(function42, null), composer2, DfuConstants.UNKNOWN_DFU_15_ERROR);
                        }
                    }
                }, true));
            }
        }, startRestartGroup, r25 & 14, 252);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$AppsList$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r10) {
                    AppsNotificationsFragmentKt.AppsList(Modifier.this, appsUIState, function2, function4, z, composer2, Strings.updateChangedFlags(r25 | 1), r26);
                }
            };
        }
    }

    public static final void Description(final Modifier modifier, final boolean z, Composer composer, final int r13, final int r14) {
        int r1;
        int r12;
        int r2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-498690670);
        int r0 = r14 & 1;
        if (r0 != 0) {
            r1 = r13 | 6;
        } else if ((r13 & 14) == 0) {
            if (startRestartGroup.changed(modifier)) {
                r12 = 4;
            } else {
                r12 = 2;
            }
            r1 = r12 | r13;
        } else {
            r1 = r13;
        }
        if ((r14 & 2) != 0) {
            r1 |= 48;
        } else if ((r13 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
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
            AnimatedVisibilityKt.AnimatedVisibility(!z, modifier, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$AppsNotificationsFragmentKt.INSTANCE.m992getLambda3$secondo_kronabyRelease(), startRestartGroup, ((r1 << 3) & 112) | 196608, 28);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$Description$1
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
                    AppsNotificationsFragmentKt.Description(Modifier.this, z, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004e  */
    /* JADX WARN: Type inference failed for: r12v6, types: [com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt$SearchTopAppBar$2, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SearchTopAppBar(androidx.compose.ui.Modifier r20, final kotlin.jvm.functions.Function0<kotlin.Unit> r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r23, final kotlin.jvm.functions.Function0<kotlin.Unit> r24, final boolean r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragmentKt.SearchTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final boolean SearchTopAppBar$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final /* synthetic */ void access$AppsList(Modifier modifier, AppsUIState appsUIState, Function2 function2, Function4 function4, boolean z, Composer composer, int r6, int r7) {
        AppsList(modifier, appsUIState, function2, function4, z, composer, r6, r7);
    }

    public static final /* synthetic */ void access$SearchTopAppBar(Modifier modifier, Function0 function0, Function0 function02, Function1 function1, Function0 function03, boolean z, Composer composer, int r7, int r8) {
        SearchTopAppBar(modifier, function0, function02, function1, function03, z, composer, r7, r8);
    }
}
