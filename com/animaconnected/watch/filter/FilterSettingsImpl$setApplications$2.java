package com.animaconnected.watch.filter;

import com.animaconnected.watch.display.ResourceSynchronizer;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: FilterSettingsImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.filter.FilterSettingsImpl$setApplications$2", f = "FilterSettingsImpl.kt", l = {124}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FilterSettingsImpl$setApplications$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Application> $apps;
    Object L$0;
    int label;
    final /* synthetic */ FilterSettingsImpl this$0;

    /* compiled from: FilterSettingsImpl.kt */
    @DebugMetadata(c = "com.animaconnected.watch.filter.FilterSettingsImpl$setApplications$2$1", f = "FilterSettingsImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.watch.filter.FilterSettingsImpl$setApplications$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$ObjectRef<List<Boolean>> $addOrUpdateResult;
        final /* synthetic */ List<Application> $apps;
        int label;
        final /* synthetic */ FilterSettingsImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FilterSettingsImpl filterSettingsImpl, Ref$ObjectRef<List<Boolean>> ref$ObjectRef, List<Application> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = filterSettingsImpl;
            this.$addOrUpdateResult = ref$ObjectRef;
            this.$apps = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$addOrUpdateResult, this.$apps, continuation);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.Collection, java.util.ArrayList] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ResourceSynchronizer resourceSynchronizer;
            boolean canAddOrUpdateApplication;
            boolean z;
            ResourceSynchronizer resourceSynchronizer2;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                resourceSynchronizer = this.this$0.resourceSynchronizer;
                resourceSynchronizer.removeImportantApps();
                Ref$ObjectRef<List<Boolean>> ref$ObjectRef = this.$addOrUpdateResult;
                List<Application> list = this.$apps;
                FilterSettingsImpl filterSettingsImpl = this.this$0;
                ?? arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
                for (Application application : list) {
                    canAddOrUpdateApplication = filterSettingsImpl.canAddOrUpdateApplication(application);
                    if (canAddOrUpdateApplication) {
                        resourceSynchronizer2 = filterSettingsImpl.resourceSynchronizer;
                        resourceSynchronizer2.addOrUpdateImportantApp(application);
                        z = true;
                    } else {
                        z = false;
                    }
                    arrayList.add(Boolean.valueOf(z));
                }
                ref$ObjectRef.element = arrayList;
                if (this.$addOrUpdateResult.element.contains(Boolean.TRUE)) {
                    this.this$0.emitFilterNotifications();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterSettingsImpl$setApplications$2(FilterSettingsImpl filterSettingsImpl, List<Application> list, Continuation<? super FilterSettingsImpl$setApplications$2> continuation) {
        super(2, continuation);
        this.this$0 = filterSettingsImpl;
        this.$apps = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilterSettingsImpl$setApplications$2(this.this$0, this.$apps, continuation);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlin.collections.EmptyList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef ref$ObjectRef;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ref$ObjectRef = (Ref$ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = EmptyList.INSTANCE;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, ref$ObjectRef2, this.$apps, null);
            this.L$0 = ref$ObjectRef2;
            this.label = 1;
            if (BuildersKt.withContext(defaultScheduler, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            ref$ObjectRef = ref$ObjectRef2;
        }
        return Boolean.valueOf(!((List) ref$ObjectRef.element).contains(Boolean.FALSE));
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FilterSettingsImpl$setApplications$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
