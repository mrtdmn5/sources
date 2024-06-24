package com.animaconnected.secondo.behaviour.time;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DefaultTextFieldColors;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
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
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.behaviour.worldtime.WorldTimeSearchViewModel;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.SearchKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: WorldTimeCitiesFragment.kt */
/* loaded from: classes3.dex */
public final class WorldTimeCitiesFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: List-Kz89ssw, reason: not valid java name */
    public static final void m792ListKz89ssw(final float f, final List<WorldTimeSearchViewModel.State> list, final Function2<? super String, ? super String, Boolean> function2, final Function0<Unit> function0, Composer composer, final int r22) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1493137797);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        LazyDslKt.LazyColumn(PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f, 0.0f, 2), null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1
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

            /* JADX WARN: Type inference failed for: r4v1, types: [com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<WorldTimeSearchViewModel.State> list2 = list;
                final Function2<String, String, Boolean> function22 = function2;
                final CoroutineScope coroutineScope2 = coroutineScope;
                final Function0<Unit> function02 = function0;
                final WorldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$1 worldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(WorldTimeSearchViewModel.State state) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((WorldTimeSearchViewModel.State) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(list2.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r8, Composer composer2, int r10) {
                        int r7;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r10 & 14) == 0) {
                            r7 = (composer2.changed(items) ? 4 : 2) | r10;
                        } else {
                            r7 = r10;
                        }
                        if ((r10 & 112) == 0) {
                            r7 |= composer2.changed(r8) ? 32 : 16;
                        }
                        if ((r7 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        WorldTimeSearchViewModel.State state = (WorldTimeSearchViewModel.State) list2.get(r8);
                        final Function2 function23 = function22;
                        final CoroutineScope coroutineScope3 = coroutineScope2;
                        final Function0 function03 = function02;
                        WorldTimeCitiesFragmentKt.TimeZoneRow(null, new Function2<String, String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$1$1

                            /* compiled from: WorldTimeCitiesFragment.kt */
                            @DebugMetadata(c = "com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$1$1$1", f = "WorldTimeCitiesFragment.kt", l = {125}, m = "invokeSuspend")
                            /* renamed from: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$1$1$1$1, reason: invalid class name */
                            /* loaded from: classes3.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                int label;

                                public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(continuation);
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
                                        WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
                                        this.label = 1;
                                        if (watchManager.sync(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
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
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                                invoke2(str, str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String zoneId, String cityKey) {
                                Intrinsics.checkNotNullParameter(zoneId, "zoneId");
                                Intrinsics.checkNotNullParameter(cityKey, "cityKey");
                                if (function23.invoke(zoneId, cityKey).booleanValue()) {
                                    BuildersKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(null), 3);
                                    function03.invoke();
                                }
                            }
                        }, state, composer2, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 1);
                    }
                }, true));
            }
        }, startRestartGroup, 0, 254);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$List$2
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

                public final void invoke(Composer composer2, int r8) {
                    WorldTimeCitiesFragmentKt.m792ListKz89ssw(f, list, function2, function0, composer2, Strings.updateChangedFlags(r22 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Search(Modifier modifier, final Function1<? super String, Unit> function1, Composer composer, final int r38, final int r39) {
        final Modifier modifier2;
        int r7;
        int r72;
        int r8;
        Modifier modifier3;
        long Color;
        boolean z;
        boolean z2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(191631457);
        int r4 = r39 & 1;
        if (r4 != 0) {
            r7 = r38 | 6;
            modifier2 = modifier;
        } else if ((r38 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r72 = 4;
            } else {
                r72 = 2;
            }
            r7 = r72 | r38;
        } else {
            modifier2 = modifier;
            r7 = r38;
        }
        if ((r39 & 2) != 0) {
            r7 |= 48;
        } else if ((r38 & 112) == 0) {
            if (startRestartGroup.changedInstance(function1)) {
                r8 = 32;
            } else {
                r8 = 16;
            }
            r7 |= r8;
        }
        int r20 = r7;
        if ((r20 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r4 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-1001453317);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = Platform.mutableStateOf$default("");
                startRestartGroup.updateValue(nextSlot);
            }
            final MutableState mutableState = (MutableState) nextSlot;
            startRestartGroup.end(false);
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.LocalFocusManager);
            String stringResource = URLProtocolKt.stringResource(R.string.general_search, startRestartGroup);
            String Search$lambda$4 = Search$lambda$4(mutableState);
            KeyboardOptions keyboardOptions = new KeyboardOptions(3, 1, 7, 2);
            KeyboardActions keyboardActions = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$Search$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                    invoke2(keyboardActionScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyboardActionScope $receiver) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    FocusManager.this.clearFocus(false);
                }
            }, null, 62);
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
            long m166getOnBackground0d7_KjU2 = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
            Color = ColorKt.Color(Color.m322getRedimpl(r11), Color.m321getGreenimpl(r11), Color.m319getBlueimpl(r11), 0.5f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU()));
            DefaultTextFieldColors m210textFieldColorsdx8h9Zs = TextFieldDefaults.m210textFieldColorsdx8h9Zs(m166getOnBackground0d7_KjU, Color, m166getOnBackground0d7_KjU2, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, 0L, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), startRestartGroup, 2064338);
            startRestartGroup.startReplaceableGroup(-1001452982);
            int r42 = r20 & 112;
            if (r42 == 32) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$Search$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        String Search$lambda$42;
                        mutableState.setValue("");
                        Function1<String, Unit> function12 = function1;
                        Search$lambda$42 = WorldTimeCitiesFragmentKt.Search$lambda$4(mutableState);
                        function12.invoke(Search$lambda$42);
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            Function0 function0 = (Function0) nextSlot2;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(-1001453079);
            if (r42 == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (z2 || nextSlot3 == composer$Companion$Empty$1) {
                nextSlot3 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$Search$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String input) {
                        String Search$lambda$42;
                        Intrinsics.checkNotNullParameter(input, "input");
                        mutableState.setValue(input);
                        Function1<String, Unit> function12 = function1;
                        Search$lambda$42 = WorldTimeCitiesFragmentKt.Search$lambda$4(mutableState);
                        function12.invoke(Search$lambda$42);
                    }
                };
                startRestartGroup.updateValue(nextSlot3);
            }
            startRestartGroup.end(false);
            SearchKt.OutlinedSearchField(modifier3, stringResource, Search$lambda$4, function0, keyboardActions, keyboardOptions, (Function1) nextSlot3, m210textFieldColorsdx8h9Zs, startRestartGroup, r20 & 14, 0);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$Search$4
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
                    WorldTimeCitiesFragmentKt.Search(Modifier.this, function1, composer2, Strings.updateChangedFlags(r38 | 1), r39);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Search$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeZoneRow(Modifier modifier, final Function2<? super String, ? super String, Unit> function2, final WorldTimeSearchViewModel.State state, Composer composer, final int r59, final int r60) {
        final Modifier modifier2;
        Modifier fillMaxWidth;
        long Color;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1814136408);
        if ((r60 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        fillMaxWidth = SizeKt.fillMaxWidth(modifier2, 1.0f);
        Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(GraphicsLayerModifierKt.graphicsLayer(SizeKt.m85heightInVpY3zN4$default(fillMaxWidth, 56, 0.0f, 2), new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$TimeZoneRow$1
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
                graphicsLayer.setAlpha(WorldTimeSearchViewModel.State.this.isActive() ? 0.5f : 1.0f);
            }
        }), new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$TimeZoneRow$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (WorldTimeSearchViewModel.State.this.isActive()) {
                    return;
                }
                function2.invoke(WorldTimeSearchViewModel.State.this.getZoneId(), WorldTimeSearchViewModel.State.this.getCityKey());
            }
        });
        Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
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
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            String city = state.getCity();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
            TextKt.m216Text4IGK_g(city, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).button, startRestartGroup, 0, 0, 65530);
            String offset = state.getOffset();
            Color = ColorKt.Color(Color.m322getRedimpl(r4), Color.m321getGreenimpl(r4), Color.m319getBlueimpl(r4), 0.7f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU()));
            TextKt.m216Text4IGK_g(offset, null, Color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).button, startRestartGroup, 0, 0, 65530);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$TimeZoneRow$4
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

                    public final void invoke(Composer composer2, int r8) {
                        WorldTimeCitiesFragmentKt.TimeZoneRow(Modifier.this, function2, state, composer2, Strings.updateChangedFlags(r59 | 1), r60);
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
    public static final void WorldTimeCitiesScreen(Modifier modifier, final Function0<Unit> function0, final WorldTimeSearchViewModel worldTimeSearchViewModel, Composer composer, final int r38, final int r39) {
        Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(555806387);
        int r0 = r39 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r0 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        float f = 24;
        List list = (List) Platform.collectAsState(worldTimeSearchViewModel.getTimeZones(), EmptyList.INSTANCE, null, startRestartGroup, 2).getValue();
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r3 = (((((r38 & 14) << 3) & 112) << 9) & 7168) | 6;
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r3 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            String stringResource = URLProtocolKt.stringResource(R.string.display_app_details_title, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-360132461);
            boolean z = true;
            if ((((r38 & 112) ^ 48) <= 32 || !startRestartGroup.changedInstance(function0)) && (r38 & 48) != 32) {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$WorldTimeCitiesScreen$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function0.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, stringResource, null, startRestartGroup, 48, 17);
            ScreenTitleKt.ScreenImageTitle(PaddingKt.m75paddingqDBjuR0$default(companion, f, f, f, 0.0f, 8), URLProtocolKt.stringResource(R.string.world_time_title, startRestartGroup), R.drawable.ic_second_time, startRestartGroup, 384, 0);
            TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.world_time_choose_city, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(companion, f, f, f, 0.0f, 8), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, 0, 0, 65528);
            float f2 = 16;
            Search(PaddingKt.m74paddingqDBjuR0(companion, f, f2, f, f2), new Function1<String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$WorldTimeCitiesScreen$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String searchText) {
                    Intrinsics.checkNotNullParameter(searchText, "searchText");
                    WorldTimeSearchViewModel.this.filterTimeZones(searchText);
                }
            }, startRestartGroup, 0, 0);
            m792ListKz89ssw(f, list, new Function2<String, String, Boolean>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$WorldTimeCitiesScreen$1$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(String zoneId, String cityKey) {
                    Intrinsics.checkNotNullParameter(zoneId, "zoneId");
                    Intrinsics.checkNotNullParameter(cityKey, "cityKey");
                    return Boolean.valueOf(WorldTimeSearchViewModel.this.addTimeZone(zoneId, cityKey));
                }
            }, function0, startRestartGroup, ((r38 << 6) & 7168) | 70);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                final Modifier modifier3 = modifier2;
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeCitiesFragmentKt$WorldTimeCitiesScreen$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r8) {
                        WorldTimeCitiesFragmentKt.WorldTimeCitiesScreen(Modifier.this, function0, worldTimeSearchViewModel, composer2, Strings.updateChangedFlags(r38 | 1), r39);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }
}
