package com.animaconnected.widget;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VerificationCodeInput.kt */
/* loaded from: classes3.dex */
public final class VerificationCodeInputKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.internal.Lambda, com.animaconnected.widget.VerificationCodeInputKt$AllVerificationCodeInputs$1] */
    public static final void AllVerificationCodeInputs(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        int r0;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1779793356);
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
            ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, -1683434684, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$AllVerificationCodeInputs$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r27) {
                    Modifier m21backgroundbw27NRU;
                    if ((r27 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(PaddingKt.m71padding3ABfNKs(companion, 4), ((Colors) composer2.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
                    ComposeThemeProvider composeThemeProvider2 = ComposeThemeProvider.this;
                    composer2.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
                        androidx.compose.material.TextKt.m216Text4IGK_g(composeThemeProvider2.getClass().getSimpleName(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 32, 7), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 48, 0, 131068);
                        VerificationCodeInputKt.m1634VerificationCodeInput1YH7lEI(null, "123", false, "Send a new verification code", false, 0L, new Function1<String, Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$AllVerificationCodeInputs$1$1$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }
                        }, new VerificationCodeInputKt$AllVerificationCodeInputs$1$1$2(null), composer2, 18353584, 49);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$AllVerificationCodeInputs$2
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
                    VerificationCodeInputKt.AllVerificationCodeInputs(ComposeThemeProvider.this, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* renamed from: VerificationCodeInput-1YH7lEI, reason: not valid java name */
    public static final void m1634VerificationCodeInput1YH7lEI(Modifier modifier, final String code, final boolean z, final String buttonText, boolean z2, long j, final Function1<? super String, Unit> onCodeChanged, final Function1<? super Continuation<? super Unit>, ? extends Object> onRequestNewCode, Composer composer, final int r34, final int r35) {
        final Modifier modifier2;
        final boolean z3;
        long j2;
        int r7;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(onCodeChanged, "onCodeChanged");
        Intrinsics.checkNotNullParameter(onRequestNewCode, "onRequestNewCode");
        ComposerImpl startRestartGroup = composer.startRestartGroup(547458855);
        if ((r35 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        if ((r35 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z2;
        }
        if ((r35 & 32) != 0) {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            r7 = (-458753) & r34;
            j2 = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU();
        } else {
            j2 = j;
            r7 = r34;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (m == composer$Companion$Empty$1) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, 16, 7);
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
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
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 1712053725);
            if ((((r34 & 896) ^ 384) > 256 && startRestartGroup.changed(z)) || (r34 & 384) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z4 || nextSlot == composer$Companion$Empty$1) {
                nextSlot = new Function0<Boolean>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(!z);
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            Function0 function0 = (Function0) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(1712053765);
            if ((((3670016 & r34) ^ 1572864) > 1048576 && startRestartGroup.changedInstance(onCodeChanged)) || (r34 & 1572864) == 1048576) {
                z5 = true;
            } else {
                z5 = false;
            }
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z5 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function1<String, Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$1$2$1
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
                    public final void invoke2(String newCode) {
                        Intrinsics.checkNotNullParameter(newCode, "newCode");
                        onCodeChanged.invoke(newCode);
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            int r11 = r7 & 112;
            int r72 = r7 >> 6;
            PinCodeFieldKt.m1619PinCodeFieldfWhpE4E(null, code, 0, j2, function0, (Function1) nextSlot2, startRestartGroup, r11 | (r72 & 7168), 5);
            ButtonBorderlessKt.ButtonBorderless(null, buttonText, z3, false, new Function0<Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$1$3

                /* compiled from: VerificationCodeInput.kt */
                @DebugMetadata(c = "com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$1$3$1", f = "VerificationCodeInput.kt", l = {50}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$1$3$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onRequestNewCode;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$onRequestNewCode = function1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$onRequestNewCode, continuation);
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
                            Function1<Continuation<? super Unit>, Object> function1 = this.$onRequestNewCode;
                            this.label = 1;
                            if (function1.invoke(this) == coroutineSingletons) {
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
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(onRequestNewCode, null), 3);
                }
            }, startRestartGroup, (r72 & 112) | (r72 & 896), 9);
            RecomposeScopeImpl m2 = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m2 != null) {
                final long j3 = j2;
                m2.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.widget.VerificationCodeInputKt$VerificationCodeInput$2
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

                    public final void invoke(Composer composer2, int r14) {
                        VerificationCodeInputKt.m1634VerificationCodeInput1YH7lEI(Modifier.this, code, z, buttonText, z3, j3, onCodeChanged, onRequestNewCode, composer2, Strings.updateChangedFlags(r34 | 1), r35);
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
