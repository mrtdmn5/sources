package com.animaconnected.secondo.behaviour.distress;

import android.content.Context;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Subject;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.Internet;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.location.LocationResult;
import com.animaconnected.watch.location.Spot;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2", f = "DistressPlugin.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressPlugin$startWalkIfPossible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DistressPlugin this$0;

    /* compiled from: DistressPlugin.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2$5", f = "DistressPlugin.kt", l = {113, 117}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2$5, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DistressModel $instance;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DistressPlugin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DistressModel distressModel, DistressPlugin distressPlugin, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$instance = distressModel;
            this.this$0 = distressPlugin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$instance, this.this$0, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            String str;
            Context context;
            Context context2;
            DistressModel distressModel;
            String str2;
            Context context3;
            Object startWalk;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                LocationProvider locationProvider = ProviderFactory.getWatch().getWatchManager().getLocationProvider();
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = locationProvider.getLocationSuspending(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            CoroutineScope coroutineScope2 = coroutineScope;
            final LocationResult locationResult = (LocationResult) obj;
            if (!(locationResult instanceof Spot)) {
                str = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) coroutineScope2, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin.startWalkIfPossible.2.5.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to receive first location: " + LocationResult.this;
                    }
                }, 6, (Object) null);
                context = this.this$0.context;
                context2 = this.this$0.context;
                String string = context2.getString(R.string.distress_unavailable);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ViewKt.toast$default(context, string, false, 2, (Object) null);
                distressModel = this.this$0.distressModel;
                if (distressModel != null) {
                    distressModel.notifyChanged();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("distressModel");
                    throw null;
                }
            } else {
                Subject subject = this.$instance.getSubject();
                if (subject != null) {
                    Spot spot = (Spot) locationResult;
                    subject.setLocation(new FollowMeLocation(spot.latitude, spot.longitude, spot.accuracy));
                }
                str2 = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) coroutineScope2, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin.startWalkIfPossible.2.5.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "First location received, starting walk";
                    }
                }, 6, (Object) null);
                DistressPlugin distressPlugin = this.this$0;
                context3 = distressPlugin.context;
                this.L$0 = null;
                this.label = 2;
                startWalk = distressPlugin.startWalk(context3, this);
                if (startWalk == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$startWalkIfPossible$2(DistressPlugin distressPlugin, Continuation<? super DistressPlugin$startWalkIfPossible$2> continuation) {
        super(2, continuation);
        this.this$0 = distressPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DistressPlugin$startWalkIfPossible$2 distressPlugin$startWalkIfPossible$2 = new DistressPlugin$startWalkIfPossible$2(this.this$0, continuation);
        distressPlugin$startWalkIfPossible$2.L$0 = obj;
        return distressPlugin$startWalkIfPossible$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        String str;
        CoroutineScope coroutineScope;
        String str2;
        Context context2;
        Context context3;
        String str3;
        String str4;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            DistressModel.Companion companion = DistressModel.Companion;
            context = this.this$0.context;
            final DistressModel companion2 = companion.getInstance(context);
            if (companion2.getObserver() == null) {
                str4 = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) coroutineScope2, str4, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Tried start walk without observer";
                    }
                }, 6, (Object) null);
                companion2.notifyMissingObserver();
                return Unit.INSTANCE;
            }
            if (!companion2.canStartWalk()) {
                str3 = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) coroutineScope2, str3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Distress can't be started in state: " + DistressModel.this.getState();
                    }
                }, 6, (Object) null);
                companion2.notifyChanged();
                return Unit.INSTANCE;
            }
            if (!Internet.INSTANCE.isAvailable()) {
                str2 = DistressPlugin.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) coroutineScope2, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No Internet available";
                    }
                }, 6, (Object) null);
                context2 = this.this$0.context;
                context3 = this.this$0.context;
                String string = context3.getString(R.string.distress_unavailable);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ViewKt.toast$default(context2, string, false, 2, (Object) null);
                companion2.notifyChanged();
                return Unit.INSTANCE;
            }
            str = DistressPlugin.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            LogKt.debug$default((Object) coroutineScope2, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startWalkIfPossible$2.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Waiting for first location before starting";
                }
            }, 6, (Object) null);
            coroutineScope = this.this$0.scope;
            BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass5(companion2, this.this$0, null), 3);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressPlugin$startWalkIfPossible$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
