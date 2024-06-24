package com.animaconnected.watch.account.fitness;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: FitnessCloudProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudProvider$getDeletedDays$2", f = "FitnessCloudProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FitnessCloudProvider$getDeletedDays$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<? extends TimePeriod>>, Object> {
    final /* synthetic */ FitnessQueries $this_getDeletedDays;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudProvider$getDeletedDays$2(FitnessQueries fitnessQueries, Continuation<? super FitnessCloudProvider$getDeletedDays$2> continuation) {
        super(2, continuation);
        this.$this_getDeletedDays = fitnessQueries;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FitnessCloudProvider$getDeletedDays$2 fitnessCloudProvider$getDeletedDays$2 = new FitnessCloudProvider$getDeletedDays$2(this.$this_getDeletedDays, continuation);
        fitnessCloudProvider$getDeletedDays$2.L$0 = obj;
        return fitnessCloudProvider$getDeletedDays$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<? extends TimePeriod>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Set<TimePeriod>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                List<Long> executeAsList = this.$this_getDeletedDays.getDeletedSessions().executeAsList();
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList, 10));
                Iterator<T> it = executeAsList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Number) it.next()).longValue();
                    TimePeriod.Companion companion = TimePeriod.Companion;
                    Instant.Companion.getClass();
                    Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(longValue);
                    TimeZone.Companion.getClass();
                    arrayList.add(companion.day(fromEpochMilliseconds, TimeZone.UTC));
                }
                return CollectionsKt___CollectionsKt.toSet(arrayList);
            } catch (Exception e) {
                LogKt.warn$default((Object) coroutineScope, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.fitness.FitnessCloudProvider$getDeletedDays$2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to get deleted session days: "));
                    }
                }, 7, (Object) null);
                return EmptySet.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Set<TimePeriod>> continuation) {
        return ((FitnessCloudProvider$getDeletedDays$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
