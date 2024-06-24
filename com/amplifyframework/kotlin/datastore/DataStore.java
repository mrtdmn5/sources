package com.amplifyframework.kotlin.datastore;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.Where;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.core.model.query.predicate.QueryPredicates;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.DataStoreItemChange;
import com.amplifyframework.datastore.DataStoreQuerySnapshot;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DataStore.kt */
/* loaded from: classes.dex */
public interface DataStore {

    /* compiled from: DataStore.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object delete$default(DataStore dataStore, Model model, QueryPredicate queryPredicate, Continuation continuation, int r4, Object obj) throws DataStoreException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((r4 & 2) != 0) {
                queryPredicate = QueryPredicates.all();
                Intrinsics.checkNotNullExpressionValue(queryPredicate, "all()");
            }
            return dataStore.delete((DataStore) model, queryPredicate, (Continuation<? super Unit>) continuation);
        }

        public static /* synthetic */ Object observe$default(DataStore dataStore, KClass kClass, QueryPredicate queryPredicate, Continuation continuation, int r4, Object obj) throws DataStoreException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    queryPredicate = QueryPredicates.all();
                    Intrinsics.checkNotNullExpressionValue(queryPredicate, "all()");
                }
                return dataStore.observe(kClass, queryPredicate, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
        }

        public static /* synthetic */ Flow query$default(DataStore dataStore, KClass kClass, QueryOptions queryOptions, int r3, Object obj) throws DataStoreException {
            if (obj == null) {
                if ((r3 & 2) != 0) {
                    queryOptions = Where.matchesAll();
                    Intrinsics.checkNotNullExpressionValue(queryOptions, "matchesAll()");
                }
                return dataStore.query(kClass, queryOptions);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }

        public static /* synthetic */ Object save$default(DataStore dataStore, Model model, QueryPredicate queryPredicate, Continuation continuation, int r4, Object obj) throws DataStoreException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    queryPredicate = QueryPredicates.all();
                    Intrinsics.checkNotNullExpressionValue(queryPredicate, "all()");
                }
                return dataStore.save(model, queryPredicate, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }

        public static /* synthetic */ Object delete$default(DataStore dataStore, KClass kClass, QueryPredicate queryPredicate, Continuation continuation, int r4, Object obj) throws DataStoreException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((r4 & 2) != 0) {
                queryPredicate = QueryPredicates.all();
                Intrinsics.checkNotNullExpressionValue(queryPredicate, "all()");
            }
            return dataStore.delete(kClass, queryPredicate, (Continuation<? super Unit>) continuation);
        }
    }

    Object clear(Continuation<? super Unit> continuation) throws DataStoreException;

    <T extends Model> Object delete(T t, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException;

    <T extends Model> Object delete(KClass<T> kClass, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException;

    Object observe(Continuation<? super Flow<? extends DataStoreItemChange<? extends Model>>> continuation) throws DataStoreException;

    <T extends Model> Object observe(KClass<T> kClass, QueryPredicate queryPredicate, Continuation<? super Flow<DataStoreItemChange<T>>> continuation) throws DataStoreException;

    <T extends Model> Object observe(KClass<T> kClass, String str, Continuation<? super Flow<DataStoreItemChange<T>>> continuation) throws DataStoreException;

    <T extends Model> Object observeQuery(KClass<T> kClass, ObserveQueryOptions observeQueryOptions, Continuation<? super Flow<? extends DataStoreQuerySnapshot<T>>> continuation) throws DataStoreException;

    <T extends Model> Flow<T> query(KClass<T> kClass, QueryOptions queryOptions) throws DataStoreException;

    <T extends Model> Object save(T t, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException;

    Object start(Continuation<? super Unit> continuation) throws DataStoreException;

    Object stop(Continuation<? super Unit> continuation) throws DataStoreException;
}
