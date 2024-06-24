package com.animaconnected.secondo.screens.settings.health;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.pickerdialog.TimePickerShower;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.fitness.Bedtime;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HealthSettings.kt */
/* loaded from: classes3.dex */
public final class HealthSettings extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "HealthSettings";

    /* compiled from: HealthSettings.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance() {
            return new HealthSettings();
        }

        private Companion() {
        }
    }

    private static final BottomSheetType ComposeContent$lambda$2(MutableState<BottomSheetType> mutableState) {
        return mutableState.getValue();
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r19) {
        int r3;
        boolean z;
        int r32;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1979076854);
        if ((r19 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r19;
        } else {
            r3 = r19;
        }
        if ((r3 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(1061316584);
            Object nextSlot = startRestartGroup.nextSlot();
            Object obj = Composer.Companion.Empty;
            if (nextSlot == obj) {
                nextSlot = new HealthSettingsViewModel(ProviderFactory.getWatch().fitness());
                startRestartGroup.updateValue(nextSlot);
            }
            final HealthSettingsViewModel healthSettingsViewModel = (HealthSettingsViewModel) nextSlot;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (nextSlot2 == obj) {
                nextSlot2 = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
            }
            startRestartGroup.end(false);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot2).coroutineScope;
            startRestartGroup.end(false);
            final ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, false, startRestartGroup, 14);
            startRestartGroup.startReplaceableGroup(1061316825);
            Object nextSlot3 = startRestartGroup.nextSlot();
            if (nextSlot3 == obj) {
                nextSlot3 = Platform.mutableStateOf$default(BottomSheetType.Walk);
                startRestartGroup.updateValue(nextSlot3);
            }
            final MutableState mutableState = (MutableState) nextSlot3;
            startRestartGroup.end(false);
            final Function1<BottomSheetType, Unit> function1 = new Function1<BottomSheetType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$showSheet$1

                /* compiled from: HealthSettings.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$showSheet$1$1", f = "HealthSettings.kt", l = {59}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$showSheet$1$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ ModalBottomSheetState $sheetState;
                    final /* synthetic */ MutableState<BottomSheetType> $sheetType$delegate;
                    final /* synthetic */ BottomSheetType $type;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(BottomSheetType bottomSheetType, ModalBottomSheetState modalBottomSheetState, MutableState<BottomSheetType> mutableState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$type = bottomSheetType;
                        this.$sheetState = modalBottomSheetState;
                        this.$sheetType$delegate = mutableState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$type, this.$sheetState, this.$sheetType$delegate, continuation);
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
                            this.$sheetType$delegate.setValue(this.$type);
                            ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                            this.label = 1;
                            if (modalBottomSheetState.show(this) == coroutineSingletons) {
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
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BottomSheetType bottomSheetType) {
                    invoke2(bottomSheetType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BottomSheetType type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(type, rememberModalBottomSheetState, mutableState, null), 3);
                }
            };
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new HealthSettings$ComposeContent$1(null), startRestartGroup);
            CustomActivityResult<Intent, ActivityResult> activityLauncher = getActivityLauncher();
            startRestartGroup.startReplaceableGroup(1061317262);
            boolean changedInstance = startRestartGroup.changedInstance(function1);
            Object nextSlot4 = startRestartGroup.nextSlot();
            if (changedInstance || nextSlot4 == obj) {
                nextSlot4 = new Function1<BottomSheetType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$googleFitUIState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomSheetType bottomSheetType) {
                        invoke2(bottomSheetType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomSheetType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                };
                startRestartGroup.updateValue(nextSlot4);
            }
            startRestartGroup.end(false);
            GoogleFitUIState rememberGoogleFitUIState = GoogleFitUIStateKt.rememberGoogleFitUIState(activityLauncher, (Function1) nextSlot4, startRestartGroup, 8);
            startRestartGroup.startReplaceableGroup(1061317353);
            boolean changedInstance2 = startRestartGroup.changedInstance(function1);
            Object nextSlot5 = startRestartGroup.nextSlot();
            if (changedInstance2 || nextSlot5 == obj) {
                nextSlot5 = new Function1<BottomSheetType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$stravaUIState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomSheetType bottomSheetType) {
                        invoke2(bottomSheetType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomSheetType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                };
                startRestartGroup.updateValue(nextSlot5);
            }
            startRestartGroup.end(false);
            StravaUIState rememberStravaUIState = StravaUIStateKt.rememberStravaUIState((Function1) nextSlot5, null, startRestartGroup, 0, 2);
            startRestartGroup.startReplaceableGroup(1061317591);
            boolean changedInstance3 = startRestartGroup.changedInstance(function1);
            Object nextSlot6 = startRestartGroup.nextSlot();
            if (changedInstance3 || nextSlot6 == obj) {
                nextSlot6 = new Function1<BottomSheetType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BottomSheetType bottomSheetType) {
                        invoke2(bottomSheetType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BottomSheetType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        function1.invoke(it);
                    }
                };
                startRestartGroup.updateValue(nextSlot6);
            }
            Function1 function12 = (Function1) nextSlot6;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(1061317636);
            if ((r3 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot7 = startRestartGroup.nextSlot();
            if (z || nextSlot7 == obj) {
                nextSlot7 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$3$1
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
                        HealthSettings.this.getMainController().goBack();
                    }
                };
                startRestartGroup.updateValue(nextSlot7);
            }
            startRestartGroup.end(false);
            HealthSettingsKt.access$HealthSettingsScreen(healthSettingsViewModel, rememberModalBottomSheetState, rememberGoogleFitUIState, rememberStravaUIState, function12, (Function0) nextSlot7, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$4

                /* compiled from: HealthSettings.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$4$1", f = "HealthSettings.kt", l = {81}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$4$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $scope;
                    final /* synthetic */ HealthSettingsViewModel $viewModel;
                    int label;
                    final /* synthetic */ HealthSettings this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(HealthSettingsViewModel healthSettingsViewModel, HealthSettings healthSettings, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$viewModel = healthSettingsViewModel;
                        this.this$0 = healthSettings;
                        this.$scope = coroutineScope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$viewModel, this.this$0, this.$scope, continuation);
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
                            HealthSettingsViewModel healthSettingsViewModel = this.$viewModel;
                            this.label = 1;
                            obj = healthSettingsViewModel.getBedTime(this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        Bedtime bedtime = (Bedtime) obj;
                        HealthSettings healthSettings = this.this$0;
                        int hour = bedtime.getHour();
                        int minute = bedtime.getMinute();
                        final CoroutineScope coroutineScope = this.$scope;
                        final HealthSettingsViewModel healthSettingsViewModel2 = this.$viewModel;
                        TimePickerShower.showTimeEditDialog(healthSettings, hour, minute, new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings.ComposeContent.4.1.1

                            /* compiled from: HealthSettings.kt */
                            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$4$1$1$1", f = "HealthSettings.kt", l = {84}, m = "invokeSuspend")
                            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$4$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes3.dex */
                            public static final class C00661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ int $hourOfDay;
                                final /* synthetic */ int $minute;
                                final /* synthetic */ HealthSettingsViewModel $viewModel;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C00661(HealthSettingsViewModel healthSettingsViewModel, int r2, int r3, Continuation<? super C00661> continuation) {
                                    super(2, continuation);
                                    this.$viewModel = healthSettingsViewModel;
                                    this.$hourOfDay = r2;
                                    this.$minute = r3;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00661(this.$viewModel, this.$hourOfDay, this.$minute, continuation);
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
                                        HealthSettingsViewModel healthSettingsViewModel = this.$viewModel;
                                        Bedtime bedtime = new Bedtime(this.$hourOfDay, this.$minute);
                                        this.label = 1;
                                        if (healthSettingsViewModel.setBedTime(bedtime, this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                                invoke(num.intValue(), num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int r5, int r6) {
                                BuildersKt.launch$default(CoroutineScope.this, null, null, new C00661(healthSettingsViewModel2, r5, r6, null), 3);
                            }
                        });
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

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
                    CoroutineScope coroutineScope2 = CoroutineScope.this;
                    BuildersKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(healthSettingsViewModel, this, coroutineScope2, null), 3);
                }
            }, ComposeContent$lambda$2(mutableState), startRestartGroup, 4680);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettings$ComposeContent$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r33) {
                    HealthSettings.this.ComposeContent(composer2, Strings.updateChangedFlags(r19 | 1));
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
