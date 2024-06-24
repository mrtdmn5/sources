package com.amplifyframework.datastore;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface DataStoreCategoryBehavior {
    void clear(Action action, Consumer<DataStoreException> consumer);

    <T extends Model> void delete(T t, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void delete(T t, QueryPredicate queryPredicate, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void delete(Class<T> cls, QueryPredicate queryPredicate, Action action, Consumer<DataStoreException> consumer);

    void observe(Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<? extends Model>> consumer2, Consumer<DataStoreException> consumer3, Action action);

    <T extends Model> void observe(Class<T> cls, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action);

    <T extends Model> void observe(Class<T> cls, QueryPredicate queryPredicate, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action);

    <T extends Model> void observe(Class<T> cls, Serializable serializable, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action);

    <T extends Model> void observeQuery(Class<T> cls, ObserveQueryOptions observeQueryOptions, Consumer<Cancelable> consumer, Consumer<DataStoreQuerySnapshot<T>> consumer2, Consumer<DataStoreException> consumer3, Action action);

    <T extends Model> void query(Class<T> cls, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void query(Class<T> cls, QueryOptions queryOptions, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void query(Class<T> cls, QueryPredicate queryPredicate, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void save(T t, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2);

    <T extends Model> void save(T t, QueryPredicate queryPredicate, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2);

    void start(Action action, Consumer<DataStoreException> consumer);

    void stop(Action action, Consumer<DataStoreException> consumer);
}
