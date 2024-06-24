package com.animaconnected.secondo.screens.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.googlefit.GoogleFitProvider;
import com.animaconnected.secondo.provider.googlefit.GoogleFitUiState;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.activity.activityHistory.StepsHistoryGraph;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ActivityFragment.kt */
/* loaded from: classes3.dex */
public final class ActivityFragment extends ComposeFragment implements WatchViewLayouter {
    private static final String HAS_DETAIL_STYLE_KEY_ID = "hasDetailStyleKeyId";
    private static final String PARENT_NAME_KEY_ID = "parentNameKeyId";
    private boolean hasDetailStyle;
    private String parentFragmentName;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(1);
    private final String name = "ActivityStepsFragment";
    private final GoogleFitProvider googleFitProvider = ProviderFactory.INSTANCE.getGoogleFitProvider();
    private final MutableStateFlow<Boolean> showLoading = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    private final ActivityStepsViewModel viewModel = new ActivityStepsViewModel();

    /* compiled from: ActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActivityFragment newInstance(boolean z, String str) {
            ActivityFragment activityFragment = new ActivityFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ActivityFragment.HAS_DETAIL_STYLE_KEY_ID, z);
            bundle.putString(ActivityFragment.PARENT_NAME_KEY_ID, str);
            activityFragment.setArguments(bundle);
            return activityFragment;
        }

        private Companion() {
        }
    }

    private static final StepProgress ComposeContent$lambda$0(State<StepProgress> state) {
        return state.getValue();
    }

    private static final List<StepsHistoryGraph.GraphData> ComposeContent$lambda$1(State<? extends List<StepsHistoryGraph.GraphData>> state) {
        return state.getValue();
    }

    private static final boolean ComposeContent$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public static final ActivityFragment newInstance(boolean z, String str) {
        return Companion.newInstance(z, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGoalPicker() {
        if (this.hasDetailStyle) {
            getMainController().gotoNextRevealedFragmentWithAnimations(ActivityGoalFragment.Companion.newInstance(this.hasDetailStyle, getParentFragmentName(), false), R.anim.enter_from_bottom, R.anim.none, R.anim.none, R.anim.exit_to_bottom);
        } else {
            getMainController().gotoNextFragmentWithAnimations(ActivityGoalFragment.Companion.newInstance(this.hasDetailStyle, getParentFragmentName(), false), R.anim.enter_from_bottom, R.anim.none, R.anim.none, R.anim.exit_to_bottom);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r15) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1032643476);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        MutableState collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(this.viewModel.getStepProgress(), new StepProgress(0, 0, null, null, 15, null), startRestartGroup, 8);
        MutableState collectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(this.viewModel.getStepsHistory(), EmptyList.INSTANCE, startRestartGroup, 56);
        boolean isConnected = ((GoogleFitUiState) FlowExtKt.collectAsStateWithLifecycle(this.googleFitProvider.getUiState(), startRestartGroup).getValue()).isConnected();
        MutableState collectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(this.showLoading, startRestartGroup);
        startRestartGroup.startReplaceableGroup(773894976);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
        startRestartGroup.end(false);
        final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        ActivityFragmentKt.access$ActivityStepsScreen(ComposeContent$lambda$0(collectAsStateWithLifecycle), ComposeContent$lambda$1(collectAsStateWithLifecycle2), isConnected, ComposeContent$lambda$2(collectAsStateWithLifecycle3), this.hasDetailStyle, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$1
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
                ActivityFragment.this.getMainController().goBack();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$2
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
                ActivityFragment.this.showGoalPicker();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$3

            /* compiled from: ActivityFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$3$1", f = "ActivityFragment.kt", l = {101}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$3$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                int label;
                final /* synthetic */ ActivityFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ActivityFragment activityFragment, Context context, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = activityFragment;
                    this.$context = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$context, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    GoogleFitProvider googleFitProvider;
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
                        googleFitProvider = this.this$0.googleFitProvider;
                        this.label = 1;
                        obj = googleFitProvider.disableGoogleFit(this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        Context context = this.$context;
                        String string = context.getString(R.string.activity_activate_google_fit_disconnect_fail_toast);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        ViewKt.toast(context, string, true);
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
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GoogleFitProvider googleFitProvider;
                MutableStateFlow mutableStateFlow;
                Object value;
                GoogleFitProvider googleFitProvider2;
                googleFitProvider = ActivityFragment.this.googleFitProvider;
                if (!googleFitProvider.isEnabled()) {
                    mutableStateFlow = ActivityFragment.this.showLoading;
                    do {
                        value = mutableStateFlow.getValue();
                        ((Boolean) value).booleanValue();
                    } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
                    ActivityFragment activityFragment = ActivityFragment.this;
                    googleFitProvider2 = activityFragment.googleFitProvider;
                    final ActivityFragment activityFragment2 = ActivityFragment.this;
                    ActivityUtilKt.enableGoogleFitAndPresentErrors(activityFragment, googleFitProvider2, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$3.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            MutableStateFlow mutableStateFlow2;
                            Object value2;
                            mutableStateFlow2 = ActivityFragment.this.showLoading;
                            do {
                                value2 = mutableStateFlow2.getValue();
                                ((Boolean) value2).booleanValue();
                            } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
                        }
                    });
                    return;
                }
                BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(ActivityFragment.this, context, null), 3);
            }
        }, startRestartGroup, 64);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityFragment$ComposeContent$4
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
                    ActivityFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r15 | 1));
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

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getParentFragmentName() {
        return this.parentFragmentName;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        return this.$$delegate_0.getWatchOffset(r2, r3, r4, r5);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return this.$$delegate_0.hideWatch();
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z;
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(HAS_DETAIL_STYLE_KEY_ID);
        } else {
            z = false;
        }
        this.hasDetailStyle = z;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(PARENT_NAME_KEY_ID);
        } else {
            str = null;
        }
        setParentFragmentName(str);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        BaseFragmentUtilsKt.launchOnStarted(this, new ActivityFragment$onViewCreated$1(this, null));
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.$$delegate_0.onWatchViewLayouted();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r2) {
        this.$$delegate_0.onWatchViewUpdated(r2);
    }

    public void setParentFragmentName(String str) {
        this.parentFragmentName = str;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r7, int r8, int r9, int r10, int r11) {
        return this.$$delegate_0.getWatchOffset(r7, r8, r9, r10, r11);
    }
}
