package com.amplifyframework.datastore;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class DataStoreCategory extends Category<DataStorePlugin<?>> implements DataStoreCategoryBehavior {
    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public void clear(Action action, Consumer<DataStoreException> consumer) {
        getSelectedPlugin().clear(action, consumer);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void delete(T t, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().delete(t, consumer, consumer2);
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.DATASTORE;
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public void observe(Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<? extends Model>> consumer2, Consumer<DataStoreException> consumer3, Action action) {
        getSelectedPlugin().observe(consumer, consumer2, consumer3, action);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void observeQuery(Class<T> cls, ObserveQueryOptions observeQueryOptions, Consumer<Cancelable> consumer, Consumer<DataStoreQuerySnapshot<T>> consumer2, Consumer<DataStoreException> consumer3, Action action) {
        getSelectedPlugin().observeQuery(cls, observeQueryOptions, consumer, consumer2, consumer3, action);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void query(Class<T> cls, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().query(cls, consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void save(T t, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().save(t, consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public void start(Action action, Consumer<DataStoreException> consumer) {
        getSelectedPlugin().start(action, consumer);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public void stop(Action action, Consumer<DataStoreException> consumer) {
        getSelectedPlugin().stop(action, consumer);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void delete(T t, QueryPredicate queryPredicate, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().delete((DataStorePlugin<?>) t, queryPredicate, (Consumer<DataStoreItemChange<DataStorePlugin<?>>>) consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void observe(Class<T> cls, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action) {
        getSelectedPlugin().observe(cls, consumer, consumer2, consumer3, action);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void query(Class<T> cls, QueryPredicate queryPredicate, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().query(cls, queryPredicate, consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void save(T t, QueryPredicate queryPredicate, Consumer<DataStoreItemChange<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().save(t, queryPredicate, consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void delete(Class<T> cls, QueryPredicate queryPredicate, Action action, Consumer<DataStoreException> consumer) {
        getSelectedPlugin().delete(cls, queryPredicate, action, consumer);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void observe(Class<T> cls, Serializable serializable, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action) {
        getSelectedPlugin().observe(cls, serializable, consumer, consumer2, consumer3, action);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void query(Class<T> cls, QueryOptions queryOptions, Consumer<Iterator<T>> consumer, Consumer<DataStoreException> consumer2) {
        getSelectedPlugin().query(cls, queryOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.datastore.DataStoreCategoryBehavior
    public <T extends Model> void observe(Class<T> cls, QueryPredicate queryPredicate, Consumer<Cancelable> consumer, Consumer<DataStoreItemChange<T>> consumer2, Consumer<DataStoreException> consumer3, Action action) {
        getSelectedPlugin().observe(cls, queryPredicate, consumer, consumer2, consumer3, action);
    }
}
