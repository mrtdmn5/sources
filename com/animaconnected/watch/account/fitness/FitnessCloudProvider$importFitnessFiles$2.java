package com.animaconnected.watch.account.fitness;

import app.cash.sqldelight.TransactionWithoutReturn;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.FitnessDatabaseParser;
import com.animaconnected.watch.fitness.FitnessQueries;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FitnessCloudProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.fitness.FitnessCloudProvider$importFitnessFiles$2", f = "FitnessCloudProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FitnessCloudProvider$importFitnessFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<FitnessFile> $files;
    final /* synthetic */ FitnessQueries $this_importFitnessFiles;
    int label;
    final /* synthetic */ FitnessCloudProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCloudProvider$importFitnessFiles$2(FitnessQueries fitnessQueries, List<FitnessFile> list, FitnessCloudProvider fitnessCloudProvider, Continuation<? super FitnessCloudProvider$importFitnessFiles$2> continuation) {
        super(2, continuation);
        this.$this_importFitnessFiles = fitnessQueries;
        this.$files = list;
        this.this$0 = fitnessCloudProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FitnessCloudProvider$importFitnessFiles$2(this.$this_importFitnessFiles, this.$files, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final FitnessQueries fitnessQueries = this.$this_importFitnessFiles;
            final List<FitnessFile> list = this.$files;
            final FitnessCloudProvider fitnessCloudProvider = this.this$0;
            fitnessQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.account.fitness.FitnessCloudProvider$importFitnessFiles$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                    invoke2(transactionWithoutReturn);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TransactionWithoutReturn transaction) {
                    String str;
                    Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                    List reversed = CollectionsKt___CollectionsKt.reversed(list);
                    FitnessQueries fitnessQueries2 = fitnessQueries;
                    FitnessCloudProvider fitnessCloudProvider2 = fitnessCloudProvider;
                    List<FitnessFile> list2 = list;
                    int r1 = 0;
                    for (Object obj2 : reversed) {
                        int r11 = r1 + 1;
                        if (r1 >= 0) {
                            FitnessFile fitnessFile = (FitnessFile) obj2;
                            FitnessDatabaseParser.INSTANCE.importFromJson(fitnessQueries2, fitnessFile.getContent());
                            str = fitnessCloudProvider2.tag;
                            LogKt.debug$default((Object) transaction, "Added to DB " + FitnessCloudSyncApiKt.toDateString(fitnessFile) + " [" + r11 + '/' + list2.size() + ']', str, (Throwable) null, false, 12, (Object) null);
                            r1 = r11;
                        } else {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                            throw null;
                        }
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FitnessCloudProvider$importFitnessFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
