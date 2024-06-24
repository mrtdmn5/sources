package com.animaconnected.widget;

import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import com.animaconnected.widget.ImageLoadingState;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SessionCard.kt */
/* loaded from: classes3.dex */
public final class SessionCardKt {
    private static final SessionCardData fakeData = new SessionCardData(System.currentTimeMillis(), "Running", android.R.drawable.btn_default, "47 km", "09:30", "1h 57m", "1 day ago");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.animaconnected.widget.SessionCardKt$AllSessionCardsError$1, kotlin.jvm.internal.Lambda] */
    public static final void AllSessionCardsError(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(61563028);
        if ((r5 & 14) == 0) {
            if (startRestartGroup.changed(composeThemeProvider)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r5;
        } else {
            r0 = r5;
        }
        if ((r0 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, 64426372, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$AllSessionCardsError$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r28) {
                    SessionCardData sessionCardData;
                    if ((r28 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                    composer2.startReplaceableGroup(-483455358);
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                    if (composer2.getApplier() instanceof Applier) {
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            composer2.useNode();
                        }
                        Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                        composer2.startReplaceableGroup(2058660585);
                        androidx.compose.material.TextKt.m216Text4IGK_g(composeThemeProvider2.getClass().getSimpleName(), null, Color.White, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 384, 0, 131066);
                        Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(companion, com.animaconnected.secondo.R.styleable.AppTheme_tabTextColor);
                        sessionCardData = SessionCardKt.fakeData;
                        SessionCardKt.SessionCard(m83height3ABfNKs, sessionCardData, new SessionCardKt$AllSessionCardsError$1$1$1(null), new Function1<Rect, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$AllSessionCardsError$1$1$2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Rect it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                                invoke2(rect);
                                return Unit.INSTANCE;
                            }
                        }, android.R.drawable.ic_menu_mylocation, composer2, 28214, 0);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, (r0 & 14) | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$AllSessionCardsError$2
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
                    SessionCardKt.AllSessionCardsError(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095  */
    /* renamed from: DrawCircles-6-Kx3sI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1623DrawCircles6Kx3sI(androidx.compose.ui.Modifier r16, final long r17, final long r19, final int r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.SessionCardKt.m1623DrawCircles6Kx3sI(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004c  */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.animaconnected.widget.SessionCardKt$GoogleMapsImageLoader$1, kotlin.jvm.internal.Lambda] */
    /* renamed from: GoogleMapsImageLoader-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1624GoogleMapsImageLoadereaDK9VM(androidx.compose.ui.Modifier r18, final com.animaconnected.widget.ImageLoadingState r19, final long r20, final long r22, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.SessionCardKt.m1624GoogleMapsImageLoadereaDK9VM(androidx.compose.ui.Modifier, com.animaconnected.widget.ImageLoadingState, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.animaconnected.widget.SessionCardKt$SessionCard$3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, androidx.compose.ui.geometry.Rect] */
    public static final void SessionCard(Modifier modifier, final SessionCardData data, final Function3<? super DpSize, ? super Color, ? super Continuation<? super ImageLoadingState>, ? extends Object> loadImage, final Function1<? super Rect, Unit> onClick, final int r21, Composer composer, final int r23, final int r24) {
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(loadImage, "loadImage");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-593412819);
        if ((r24 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final long m172getSecondary0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        startRestartGroup.startReplaceableGroup(270370458);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Rect.Zero;
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        ref$ObjectRef.element = (Rect) nextSlot;
        startRestartGroup.startReplaceableGroup(270370510);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            nextSlot2 = Platform.mutableStateOf$default(ImageLoadingState.Loading.INSTANCE);
            startRestartGroup.updateValue(nextSlot2);
        }
        final MutableState mutableState = (MutableState) nextSlot2;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 270370700);
        if (m == composer$Companion$Empty$1) {
            Dp dp = new Dp(com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryHintRoundnessDetail);
            startRestartGroup.updateValue(dp);
            m = dp;
        }
        final float f = ((Dp) m).value;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 270370859);
        if (m2 == composer$Companion$Empty$1) {
            Dp dp2 = new Dp(170);
            startRestartGroup.updateValue(dp2);
            m2 = dp2;
        }
        final float f2 = ((Dp) m2).value;
        Object m3 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 270370902);
        if (m3 == composer$Companion$Empty$1) {
            m3 = Platform.derivedStateOf(new Function0<Dp>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$cardHeight$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* synthetic */ Dp invoke() {
                    return new Dp(m1628invokeD9Ej5fM());
                }

                /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                public final float m1628invokeD9Ej5fM() {
                    ImageLoadingState SessionCard$lambda$2;
                    SessionCard$lambda$2 = SessionCardKt.SessionCard$lambda$2(mutableState);
                    if (SessionCard$lambda$2 instanceof ImageLoadingState.Error) {
                        return f;
                    }
                    return f2;
                }
            });
            startRestartGroup.updateValue(m3);
        }
        startRestartGroup.end(false);
        BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(r21, OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, new Function1<LayoutCoordinates, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [T, androidx.compose.ui.geometry.Rect] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                ref$ObjectRef.element = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
            }
        }), null, new Dp(SessionCard$lambda$7((State) m3)), new Function0<Unit>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$2
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
                onClick.invoke(ref$ObjectRef.element);
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, -494408123, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$3
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

            /* JADX WARN: Type inference failed for: r12v4, types: [com.animaconnected.widget.SessionCardKt$SessionCard$3$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer2, int r12) {
                if ((r12 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16);
                final SessionCardData sessionCardData = SessionCardData.this;
                final Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> function3 = loadImage;
                final long j = m172getSecondary0d7_KjU;
                final MutableState<ImageLoadingState> mutableState2 = mutableState;
                BoxWithConstraintsKt.BoxWithConstraints(m71padding3ABfNKs, null, false, ComposableLambdaKt.composableLambda(composer2, 1540330267, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$3.1

                    /* compiled from: SessionCard.kt */
                    @DebugMetadata(c = "com.animaconnected.widget.SessionCardKt$SessionCard$3$1$1", f = "SessionCard.kt", l = {67}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.widget.SessionCardKt$SessionCard$3$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes3.dex */
                    public static final class C01301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<ImageLoadingState> $imageLoadingState$delegate;
                        final /* synthetic */ Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> $loadImage;
                        final /* synthetic */ long $pathColor;
                        final /* synthetic */ BoxWithConstraintsScope $this_BoxWithConstraints;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public C01301(Function3<? super DpSize, ? super Color, ? super Continuation<? super ImageLoadingState>, ? extends Object> function3, BoxWithConstraintsScope boxWithConstraintsScope, long j, MutableState<ImageLoadingState> mutableState, Continuation<? super C01301> continuation) {
                            super(2, continuation);
                            this.$loadImage = function3;
                            this.$this_BoxWithConstraints = boxWithConstraintsScope;
                            this.$pathColor = j;
                            this.$imageLoadingState$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C01301(this.$loadImage, this.$this_BoxWithConstraints, this.$pathColor, this.$imageLoadingState$delegate, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            MutableState<ImageLoadingState> mutableState;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            if (r1 != 0) {
                                if (r1 == 1) {
                                    mutableState = (MutableState) this.L$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                MutableState<ImageLoadingState> mutableState2 = this.$imageLoadingState$delegate;
                                Function3<DpSize, Color, Continuation<? super ImageLoadingState>, Object> function3 = this.$loadImage;
                                DpSize dpSize = new DpSize(DpKt.m582DpSizeYgX7TsA(this.$this_BoxWithConstraints.mo68getMaxWidthD9Ej5fM(), this.$this_BoxWithConstraints.mo67getMaxHeightD9Ej5fM()));
                                Color color = new Color(this.$pathColor);
                                this.L$0 = mutableState2;
                                this.label = 1;
                                Object invoke = function3.invoke(dpSize, color, this);
                                if (invoke == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                mutableState = mutableState2;
                                obj = invoke;
                            }
                            mutableState.setValue((ImageLoadingState) obj);
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C01301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer3, Integer num) {
                        invoke(boxWithConstraintsScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer3, int r13) {
                        int r0;
                        ImageLoadingState SessionCard$lambda$2;
                        ImageLoadingState SessionCard$lambda$22;
                        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                        if ((r13 & 14) == 0) {
                            r0 = (composer3.changed(BoxWithConstraints) ? 4 : 2) | r13;
                        } else {
                            r0 = r13;
                        }
                        if ((r0 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        EffectsKt.LaunchedEffect(Long.valueOf(SessionCardData.this.getTimestamp()), new C01301(function3, BoxWithConstraints, j, mutableState2, null), composer3);
                        SessionCard$lambda$2 = SessionCardKt.SessionCard$lambda$2(mutableState2);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                        SessionCardKt.m1624GoogleMapsImageLoadereaDK9VM(null, SessionCard$lambda$2, ((Colors) composer3.consume(staticProvidableCompositionLocal)).m174getSurface0d7_KjU(), ((Colors) composer3.consume(staticProvidableCompositionLocal)).m173getSecondaryVariant0d7_KjU(), composer3, 0, 1);
                        SessionCardData sessionCardData2 = SessionCardData.this;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        float f3 = 2;
                        SessionCard$lambda$22 = SessionCardKt.SessionCard$lambda$2(mutableState2);
                        SessionCardKt.SessionInfo(sessionCardData2, PaddingKt.m75paddingqDBjuR0$default(companion, f3, 0.0f, f3, SessionCard$lambda$22 instanceof ImageLoadingState.Success ? 16 : f3, 2), composer3, 0, 0);
                    }
                }), composer2, 3078, 6);
            }
        }), startRestartGroup, ((r23 >> 12) & 14) | 196608, 4);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.SessionCardKt$SessionCard$4
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
                    SessionCardKt.SessionCard(Modifier.this, data, loadImage, onClick, r21, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageLoadingState SessionCard$lambda$2(MutableState<ImageLoadingState> mutableState) {
        return mutableState.getValue();
    }

    private static final float SessionCard$lambda$7(State<Dp> state) {
        return state.getValue().value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SessionInfo(final com.animaconnected.widget.SessionCardData r70, androidx.compose.ui.Modifier r71, androidx.compose.runtime.Composer r72, final int r73, final int r74) {
        /*
            Method dump skipped, instructions count: 1058
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.widget.SessionCardKt.SessionInfo(com.animaconnected.widget.SessionCardData, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
