package com.animaconnected.secondo.screens.workout.detail;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.databinding.FragmentWorkoutDetailsBinding;
import com.animaconnected.secondo.databinding.LayoutWorkoutDetailsLinechartBinding;
import com.animaconnected.secondo.databinding.LayoutWorkoutDetailsSplitsBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.animaconnected.secondo.screens.debugsettings.DebugStorage;
import com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsViewModel;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt;
import com.animaconnected.secondo.widget.TopFadeScrollView;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.display.DpUtils;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.workout.SessionListItem;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.zac;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.zzah;
import com.google.common.collect.Hashing;
import java.util.WeakHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: WorkoutDetailsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1", f = "WorkoutDetailsFragment.kt", l = {R.styleable.AppTheme_stepsHistoryNoDataBackgroundDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorkoutDetailsFragment$onCreateView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LayoutInflater $inflater;
    final /* synthetic */ Bundle $savedInstanceState;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WorkoutDetailsFragment this$0;

    /* compiled from: WorkoutDetailsFragment.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$6", f = "WorkoutDetailsFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$6, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<WorkoutDetailsViewModel.AnimationState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WorkoutDetailsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(WorkoutDetailsFragment workoutDetailsFragment, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.this$0 = workoutDetailsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.this$0, continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WorkoutDetailsViewModel.AnimationState animationState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(animationState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WorkoutDetailsViewModel.AnimationState animationState = (WorkoutDetailsViewModel.AnimationState) this.L$0;
                if (this.this$0.map != null) {
                    this.this$0.renderAnimationState(animationState);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkoutDetailsFragment$onCreateView$1(WorkoutDetailsFragment workoutDetailsFragment, Bundle bundle, LayoutInflater layoutInflater, Continuation<? super WorkoutDetailsFragment$onCreateView$1> continuation) {
        super(2, continuation);
        this.this$0 = workoutDetailsFragment;
        this.$savedInstanceState = bundle;
        this.$inflater = layoutInflater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkoutDetailsFragment$onCreateView$1(this.this$0, this.$savedInstanceState, this.$inflater, continuation);
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FitnessProvider fitness;
        long j;
        WorkoutDetailsFragment workoutDetailsFragment;
        Session session;
        SessionListItem sessionListItem;
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding;
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding2;
        SessionListItem sessionListItem2;
        WorkoutDetailsViewModel workoutDetailsViewModel;
        WorkoutDetailsViewModel workoutDetailsViewModel2;
        WorkoutDetailsViewModel workoutDetailsViewModel3;
        WorkoutDetailsViewModel workoutDetailsViewModel4;
        WorkoutDetailsViewModel workoutDetailsViewModel5;
        boolean z;
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding3;
        FragmentWorkoutDetailsBinding fragmentWorkoutDetailsBinding4;
        Rect rect;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                workoutDetailsFragment = (WorkoutDetailsFragment) this.L$1;
                fitness = (FitnessProvider) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            fitness = ProviderFactory.getWatch().fitness();
            WorkoutDetailsFragment workoutDetailsFragment2 = this.this$0;
            j = workoutDetailsFragment2.sessionID;
            this.L$0 = fitness;
            this.L$1 = workoutDetailsFragment2;
            this.label = 1;
            Object sessionsDetailed = fitness.getSessionsDetailed(j, this);
            if (sessionsDetailed == coroutineSingletons) {
                return coroutineSingletons;
            }
            workoutDetailsFragment = workoutDetailsFragment2;
            obj = sessionsDetailed;
        }
        workoutDetailsFragment.detailedSession = (Session) obj;
        WorkoutDetailsFragment workoutDetailsFragment3 = this.this$0;
        SessionListItem.Companion companion = SessionListItem.Companion;
        session = workoutDetailsFragment3.detailedSession;
        Intrinsics.checkNotNull(session);
        workoutDetailsFragment3.session = companion.fromSession(session, fitness.getProfile().getMeasurement());
        WorkoutDetailsFragment workoutDetailsFragment4 = this.this$0;
        sessionListItem = workoutDetailsFragment4.session;
        if (sessionListItem != null) {
            AnonymousClass1 anonymousClass1 = new Function1<Long, String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Long l) {
                    return invoke(l.longValue());
                }

                public final String invoke(long j2) {
                    return DateFormatter.format$default(new AndroidDateFormatter("EEEE dd MMM", null, 2, null), j2, null, false, 6, null);
                }
            };
            AnonymousClass2 anonymousClass2 = new Function1<Long, String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Long l) {
                    return invoke(l.longValue());
                }

                public final String invoke(long j2) {
                    return DateFormatter.format$default(new AndroidDateFormatter("HH:mm", null, 2, null), j2, null, false, 6, null);
                }
            };
            AnonymousClass3 anonymousClass3 = new Function1<LocationEntry, String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1.3
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(LocationEntry locationEntry) {
                    String cityName = locationEntry != null ? AndroidLocationBackend.INSTANCE.getCityName(locationEntry) : null;
                    return cityName == null ? "" : cityName;
                }
            };
            final WorkoutDetailsFragment workoutDetailsFragment5 = this.this$0;
            workoutDetailsFragment4.viewModel = new WorkoutDetailsViewModel(sessionListItem, anonymousClass1, anonymousClass2, anonymousClass3, new Function1<Integer, String>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final String invoke(int r2) {
                    String string = WorkoutDetailsFragment.this.getString(r2);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            });
            fragmentWorkoutDetailsBinding = this.this$0.binding;
            if (fragmentWorkoutDetailsBinding != null) {
                final WorkoutDetailsFragment workoutDetailsFragment6 = this.this$0;
                Bundle bundle = this.$savedInstanceState;
                final LayoutInflater layoutInflater = this.$inflater;
                fragmentWorkoutDetailsBinding2 = workoutDetailsFragment6.binding;
                if (fragmentWorkoutDetailsBinding2 != null) {
                    MapView mapView = fragmentWorkoutDetailsBinding2.mapView;
                    zzah zzahVar = mapView.zza;
                    StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
                    try {
                        zzahVar.getClass();
                        zzahVar.zaf(bundle, new zac(zzahVar, bundle));
                        if (zzahVar.zaa == null) {
                            DeferredLifecycleHelper.showGooglePlayUnavailableMessage(mapView);
                        }
                        StrictMode.setThreadPolicy(threadPolicy);
                        ImageView ivToolbarBack = fragmentWorkoutDetailsBinding.ivToolbarBack;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarBack, "ivToolbarBack");
                        workoutDetailsFragment6.onClick(ivToolbarBack, new WorkoutDetailsFragment$onCreateView$1$5$1(workoutDetailsFragment6, null));
                        ImageView ivToolbarExpand = fragmentWorkoutDetailsBinding.ivToolbarExpand;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarExpand, "ivToolbarExpand");
                        workoutDetailsFragment6.onClick(ivToolbarExpand, new WorkoutDetailsFragment$onCreateView$1$5$2(workoutDetailsFragment6, null));
                        ImageView ivToolbarCollapse = fragmentWorkoutDetailsBinding.ivToolbarCollapse;
                        Intrinsics.checkNotNullExpressionValue(ivToolbarCollapse, "ivToolbarCollapse");
                        workoutDetailsFragment6.onClick(ivToolbarCollapse, new WorkoutDetailsFragment$onCreateView$1$5$3(workoutDetailsFragment6, null));
                        TopFadeScrollView topFadeScrollView = fragmentWorkoutDetailsBinding.scrollView;
                        topFadeScrollView.setVerticalFadingEdgeEnabled(false);
                        topFadeScrollView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$4$1
                            @Override // android.view.ViewOutlineProvider
                            public void getOutline(View view, Outline outline) {
                                Intrinsics.checkNotNullParameter(view, "view");
                                Intrinsics.checkNotNullParameter(outline, "outline");
                                int width = view.getWidth();
                                int height = view.getHeight();
                                DpUtils dpUtils = DpUtils.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(layoutInflater.getContext(), "getContext(...)");
                                outline.setRoundRect(0, 0, width, height, dpUtils.dpToPx(r0, 24.0f));
                            }
                        });
                        topFadeScrollView.setClipToOutline(true);
                        workoutDetailsFragment6.updateTopBarAlpha(fragmentWorkoutDetailsBinding);
                        sessionListItem2 = workoutDetailsFragment6.session;
                        if (sessionListItem2 != null) {
                            if (!sessionListItem2.getRoute().isEmpty()) {
                                workoutDetailsFragment6.initGoogleMap();
                            } else {
                                FrameLayout containerMap = fragmentWorkoutDetailsBinding.containerMap;
                                Intrinsics.checkNotNullExpressionValue(containerMap, "containerMap");
                                ViewKt.gone(containerMap);
                                RelativeLayout containerAnimatedToolbar = fragmentWorkoutDetailsBinding.containerAnimatedToolbar;
                                Intrinsics.checkNotNullExpressionValue(containerAnimatedToolbar, "containerAnimatedToolbar");
                                ViewKt.gone(containerAnimatedToolbar);
                                CustomToolbar toolbarNoAnimation = fragmentWorkoutDetailsBinding.toolbarNoAnimation;
                                Intrinsics.checkNotNullExpressionValue(toolbarNoAnimation, "toolbarNoAnimation");
                                ViewKt.visible(toolbarNoAnimation);
                                ComposeView composeViewActivityType = fragmentWorkoutDetailsBinding.composeViewActivityType;
                                Intrinsics.checkNotNullExpressionValue(composeViewActivityType, "composeViewActivityType");
                                CustomToolbar toolbarNoAnimation2 = fragmentWorkoutDetailsBinding.toolbarNoAnimation;
                                Intrinsics.checkNotNullExpressionValue(toolbarNoAnimation2, "toolbarNoAnimation");
                                ViewKt.below(composeViewActivityType, toolbarNoAnimation2);
                                LinearLayout layoutWorkout = fragmentWorkoutDetailsBinding.layoutWorkout;
                                Intrinsics.checkNotNullExpressionValue(layoutWorkout, "layoutWorkout");
                                ComposeView composeViewActivityType2 = fragmentWorkoutDetailsBinding.composeViewActivityType;
                                Intrinsics.checkNotNullExpressionValue(composeViewActivityType2, "composeViewActivityType");
                                ViewKt.below(layoutWorkout, composeViewActivityType2);
                            }
                            workoutDetailsViewModel = workoutDetailsFragment6.viewModel;
                            if (workoutDetailsViewModel != null) {
                                final ActivityState activityState = workoutDetailsViewModel.getActivityState();
                                fragmentWorkoutDetailsBinding.composeViewActivityType.setContent(ComposableLambdaKt.composableLambdaInstance(654841789, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Type inference failed for: r4v3, types: [com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$1$1, kotlin.jvm.internal.Lambda] */
                                    public final void invoke(Composer composer, int r4) {
                                        if ((r4 & 11) == 2 && composer.getSkipping()) {
                                            composer.skipToGroupEnd();
                                            return;
                                        }
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                                        final WorkoutDetailsFragment workoutDetailsFragment7 = WorkoutDetailsFragment.this;
                                        final ActivityState activityState2 = activityState;
                                        ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 2091044302, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$1.1
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
                                                if ((r8 & 11) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                } else {
                                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                                    WorkoutDetailsFragment.this.ActivityTypeSummary(activityState2, null, composer2, DfuConstants.UNKNOWN_DFU_15_ERROR, 2);
                                                }
                                            }
                                        }), composer, 6);
                                    }
                                }, true));
                                ComposeView composeViewActivityType3 = fragmentWorkoutDetailsBinding.composeViewActivityType;
                                Intrinsics.checkNotNullExpressionValue(composeViewActivityType3, "composeViewActivityType");
                                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                if (ViewCompat.Api19Impl.isLaidOut(composeViewActivityType3) && !composeViewActivityType3.isLayoutRequested()) {
                                    workoutDetailsFragment6.expandedMapHeight = ScreenLocationHelper.getScreenSize(workoutDetailsFragment6.requireContext()).getHeight() - composeViewActivityType3.getHeight();
                                } else {
                                    composeViewActivityType3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$invokeSuspend$lambda$3$lambda$2$$inlined$doOnLayout$1
                                        @Override // android.view.View.OnLayoutChangeListener
                                        public void onLayoutChange(View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                                            view.removeOnLayoutChangeListener(this);
                                            WorkoutDetailsFragment workoutDetailsFragment7 = WorkoutDetailsFragment.this;
                                            workoutDetailsFragment7.expandedMapHeight = ScreenLocationHelper.getScreenSize(workoutDetailsFragment7.requireContext()).getHeight() - view.getHeight();
                                        }
                                    });
                                }
                                fragmentWorkoutDetailsBinding.composeViewWorkout.setContent(ComposableLambdaKt.composableLambdaInstance(2047547110, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Type inference failed for: r4v3, types: [com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$3$1, kotlin.jvm.internal.Lambda] */
                                    public final void invoke(Composer composer, int r4) {
                                        if ((r4 & 11) == 2 && composer.getSkipping()) {
                                            composer.skipToGroupEnd();
                                            return;
                                        }
                                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                                        final WorkoutDetailsFragment workoutDetailsFragment7 = WorkoutDetailsFragment.this;
                                        final ActivityState activityState2 = activityState;
                                        ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -741307209, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.detail.WorkoutDetailsFragment$onCreateView$1$5$6$3.1
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
                                                if ((r8 & 11) == 2 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                } else {
                                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                                    WorkoutDetailsFragment.this.MetricSummary(activityState2.getMetrics(), null, composer2, DfuConstants.UNKNOWN_DFU_15_ERROR, 2);
                                                }
                                            }
                                        }), composer, 6);
                                    }
                                }, true));
                                workoutDetailsViewModel2 = workoutDetailsFragment6.viewModel;
                                if (workoutDetailsViewModel2 != null) {
                                    if (workoutDetailsViewModel2.getAreHeartEntriesValid()) {
                                        LayoutWorkoutDetailsLinechartBinding layoutHeartRate = fragmentWorkoutDetailsBinding.layoutHeartRate;
                                        Intrinsics.checkNotNullExpressionValue(layoutHeartRate, "layoutHeartRate");
                                        workoutDetailsFragment6.initHeartRate(layoutHeartRate);
                                    }
                                    workoutDetailsViewModel3 = workoutDetailsFragment6.viewModel;
                                    if (workoutDetailsViewModel3 != null) {
                                        if (workoutDetailsViewModel3.getAreElevationEntriesValid()) {
                                            LayoutWorkoutDetailsLinechartBinding layoutElevation = fragmentWorkoutDetailsBinding.layoutElevation;
                                            Intrinsics.checkNotNullExpressionValue(layoutElevation, "layoutElevation");
                                            workoutDetailsFragment6.initElevation(layoutElevation);
                                        }
                                        workoutDetailsViewModel4 = workoutDetailsFragment6.viewModel;
                                        if (workoutDetailsViewModel4 != null) {
                                            if (workoutDetailsViewModel4.getAreSplitEntriesValid()) {
                                                LayoutWorkoutDetailsSplitsBinding layoutSplits = fragmentWorkoutDetailsBinding.layoutSplits;
                                                Intrinsics.checkNotNullExpressionValue(layoutSplits, "layoutSplits");
                                                workoutDetailsFragment6.initSplits(layoutSplits);
                                            }
                                            Button btnDelete = fragmentWorkoutDetailsBinding.btnDelete;
                                            Intrinsics.checkNotNullExpressionValue(btnDelete, "btnDelete");
                                            workoutDetailsFragment6.onClick(btnDelete, new WorkoutDetailsFragment$onCreateView$1$5$7(workoutDetailsFragment6, null));
                                            if (DebugStorage.INSTANCE.getShowWipStuff()) {
                                                Button btnStravaUpload = fragmentWorkoutDetailsBinding.btnStravaUpload;
                                                Intrinsics.checkNotNullExpressionValue(btnStravaUpload, "btnStravaUpload");
                                                ViewKt.visible(btnStravaUpload);
                                                Button btnStravaUpload2 = fragmentWorkoutDetailsBinding.btnStravaUpload;
                                                Intrinsics.checkNotNullExpressionValue(btnStravaUpload2, "btnStravaUpload");
                                                workoutDetailsFragment6.onClick(btnStravaUpload2, new WorkoutDetailsFragment$onCreateView$1$5$8(workoutDetailsFragment6, null));
                                                Button btnExportTcx = fragmentWorkoutDetailsBinding.btnExportTcx;
                                                Intrinsics.checkNotNullExpressionValue(btnExportTcx, "btnExportTcx");
                                                ViewKt.visible(btnExportTcx);
                                                Button btnExportTcx2 = fragmentWorkoutDetailsBinding.btnExportTcx;
                                                Intrinsics.checkNotNullExpressionValue(btnExportTcx2, "btnExportTcx");
                                                workoutDetailsFragment6.onClick(btnExportTcx2, new WorkoutDetailsFragment$onCreateView$1$5$9(workoutDetailsFragment6, null));
                                            }
                                            workoutDetailsViewModel5 = this.this$0.viewModel;
                                            if (workoutDetailsViewModel5 != null) {
                                                FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AnonymousClass6(this.this$0, null), workoutDetailsViewModel5.getAnimationState()), Hashing.getLifecycleScope(this.this$0));
                                                z = this.this$0.shouldReveal;
                                                if (z) {
                                                    WorkoutDetailsFragment workoutDetailsFragment7 = this.this$0;
                                                    fragmentWorkoutDetailsBinding3 = workoutDetailsFragment7.binding;
                                                    if (fragmentWorkoutDetailsBinding3 != null) {
                                                        RelativeLayout root = fragmentWorkoutDetailsBinding3.getRoot();
                                                        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                                                        fragmentWorkoutDetailsBinding4 = this.this$0.binding;
                                                        if (fragmentWorkoutDetailsBinding4 != null) {
                                                            View viewAnimContainer = fragmentWorkoutDetailsBinding4.viewAnimContainer;
                                                            Intrinsics.checkNotNullExpressionValue(viewAnimContainer, "viewAnimContainer");
                                                            rect = this.this$0.cardBounds;
                                                            AnimationFactoryKotlinKt.enterCardRevealAnim(workoutDetailsFragment7, root, viewAnimContainer, rect);
                                                        } else {
                                                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                                                            throw null;
                                                        }
                                                    } else {
                                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                                        throw null;
                                                    }
                                                }
                                                this.this$0.shouldReveal = false;
                                                return Unit.INSTANCE;
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                            throw null;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("session");
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicy);
                        throw th;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("session");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WorkoutDetailsFragment$onCreateView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
