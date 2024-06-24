package com.amplifyframework.kotlin.datastore;

import androidx.compose.ui.draw.AlphaKt;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.datastore.DataStoreCategoryBehavior;
import com.amplifyframework.datastore.DataStoreException;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: KotlinDataStoreFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$query$1", f = "KotlinDataStoreFacade.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KotlinDataStoreFacade$query$1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ KClass<T> $itemClass;
    final /* synthetic */ QueryOptions $options;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KotlinDataStoreFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinDataStoreFacade$query$1(KotlinDataStoreFacade kotlinDataStoreFacade, KClass<T> kClass, QueryOptions queryOptions, Continuation<? super KotlinDataStoreFacade$query$1> continuation) {
        super(2, continuation);
        this.this$0 = kotlinDataStoreFacade;
        this.$itemClass = kClass;
        this.$options = queryOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    public static final void m674invokeSuspend$lambda0(ProducerScope producerScope, Iterator it) {
        while (it.hasNext()) {
            AlphaKt.trySendBlocking(producerScope, it.next());
        }
        producerScope.close(null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinDataStoreFacade$query$1 kotlinDataStoreFacade$query$1 = new KotlinDataStoreFacade$query$1(this.this$0, this.$itemClass, this.$options, continuation);
        kotlinDataStoreFacade$query$1.L$0 = obj;
        return kotlinDataStoreFacade$query$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataStoreCategoryBehavior dataStoreCategoryBehavior;
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            dataStoreCategoryBehavior = this.this$0.delegate;
            dataStoreCategoryBehavior.query(JvmClassMappingKt.getJavaClass(this.$itemClass), this.$options, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$query$1$$ExternalSyntheticLambda0
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj2) {
                    KotlinDataStoreFacade$query$1.m674invokeSuspend$lambda0(ProducerScope.this, (Iterator) obj2);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$query$1$$ExternalSyntheticLambda1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj2) {
                    ProducerScope.this.close((DataStoreException) obj2);
                }
            });
            AnonymousClass3 anonymousClass3 = new Function0<Unit>() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$query$1.3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, anonymousClass3, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((KotlinDataStoreFacade$query$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
