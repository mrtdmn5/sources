package com.animaconnected.secondo.provider.configuration.database;

import com.animaconnected.future.Future;
import com.animaconnected.future.runner.BackgroundRunner;
import com.animaconnected.future.runner.SequentialBackgroundRunner;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public class DatabaseHelper {
    private final Dao<ConfigurationItem, Integer> mDao;
    private final QueryBuilder<ConfigurationItem, Integer> mDefaultGetAllItemsQuery;
    private final BackgroundRunner mRunner = new SequentialBackgroundRunner();

    public DatabaseHelper(Dao<ConfigurationItem, Integer> dao) {
        this.mDao = dao;
        QueryBuilder<ConfigurationItem, Integer> queryBuilder = dao.queryBuilder();
        queryBuilder.orderBy(ConfigurationItem.COLUMN_NAME_CATEGORY, true);
        queryBuilder.orderBy(ConfigurationItem.COLUMN_NAME_ID, true);
        this.mDefaultGetAllItemsQuery = queryBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Void lambda$clearTables$0() throws Exception {
        DeleteBuilder<ConfigurationItem, Integer> deleteBuilder = this.mDao.deleteBuilder();
        deleteBuilder.dao.delete(deleteBuilder.prepareStatement(false));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$deleteConfigurationItemInDb$4(int r2) throws Exception {
        return Integer.valueOf(this.mDao.deleteById(Integer.valueOf(r2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getConfigurationItemId$6(String str) throws Exception {
        int r3;
        Where<ConfigurationItem, Integer> where = this.mDao.queryBuilder().where();
        where.eq(str, ConfigurationItem.COLUMN_NAME_EXTERNAL_ID);
        List<ConfigurationItem> query = where.query();
        if (query.size() > 0) {
            r3 = query.get(0).getId();
        } else {
            r3 = -1;
        }
        return Integer.valueOf(r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ConfigurationItem lambda$getConfigurationItemInDb$2(int r2) throws Exception {
        return this.mDao.queryForId(Integer.valueOf(r2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List lambda$getConfigurationItemsFromDb$5() throws Exception {
        boolean z;
        QueryBuilder<ConfigurationItem, Integer> queryBuilder = this.mDefaultGetAllItemsQuery;
        if (queryBuilder.selectList == null) {
            z = true;
        } else {
            z = false;
        }
        return queryBuilder.dao.query(queryBuilder.prepareStatement(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List lambda$getEnabledItems$7(int r6) throws Exception {
        Where<ConfigurationItem, Integer> where = this.mDao.queryBuilder().where();
        where.addClause(new SimpleComparison(ConfigurationItem.COLUMN_NAME_GROUP, where.tableInfo.getFieldTypeByColumnName(ConfigurationItem.COLUMN_NAME_GROUP), Integer.valueOf(r6), "<>"));
        return where.query();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Void lambda$removeItemOnGroupPriority$3(int r4) throws Exception {
        UpdateBuilder<ConfigurationItem, Integer> updateBuilder = this.mDao.updateBuilder();
        updateBuilder.where().eq(Integer.valueOf(r4), ConfigurationItem.COLUMN_NAME_GROUP_PRIORITY);
        updateBuilder.updateColumnValue(-1, ConfigurationItem.COLUMN_NAME_GROUP_PRIORITY);
        updateBuilder.updateColumnValue(-1, ConfigurationItem.COLUMN_NAME_GROUP);
        updateBuilder.dao.update(updateBuilder.prepareStatement(false));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ConfigurationItem lambda$updateConfigurationItemInDb$1(ConfigurationItem configurationItem) throws Exception {
        this.mDao.update((Dao<ConfigurationItem, Integer>) configurationItem);
        return configurationItem;
    }

    public Future<Void> clearTables() {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$clearTables$0;
                lambda$clearTables$0 = DatabaseHelper.this.lambda$clearTables$0();
                return lambda$clearTables$0;
            }
        });
    }

    public Future<Integer> deleteConfigurationItemInDb(final int r3) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer lambda$deleteConfigurationItemInDb$4;
                lambda$deleteConfigurationItemInDb$4 = DatabaseHelper.this.lambda$deleteConfigurationItemInDb$4(r3);
                return lambda$deleteConfigurationItemInDb$4;
            }
        });
    }

    public Future<Integer> getConfigurationItemId(final String str) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer lambda$getConfigurationItemId$6;
                lambda$getConfigurationItemId$6 = DatabaseHelper.this.lambda$getConfigurationItemId$6(str);
                return lambda$getConfigurationItemId$6;
            }
        });
    }

    public Future<ConfigurationItem> getConfigurationItemInDb(final int r3) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ConfigurationItem lambda$getConfigurationItemInDb$2;
                lambda$getConfigurationItemInDb$2 = DatabaseHelper.this.lambda$getConfigurationItemInDb$2(r3);
                return lambda$getConfigurationItemInDb$2;
            }
        });
    }

    public Future<List<ConfigurationItem>> getConfigurationItemsFromDb() {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$getConfigurationItemsFromDb$5;
                lambda$getConfigurationItemsFromDb$5 = DatabaseHelper.this.lambda$getConfigurationItemsFromDb$5();
                return lambda$getConfigurationItemsFromDb$5;
            }
        });
    }

    public Dao<ConfigurationItem, Integer> getDao() {
        return this.mDao;
    }

    public Future<List<ConfigurationItem>> getEnabledItems(final int r3) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List lambda$getEnabledItems$7;
                lambda$getEnabledItems$7 = DatabaseHelper.this.lambda$getEnabledItems$7(r3);
                return lambda$getEnabledItems$7;
            }
        });
    }

    public Future<Void> removeItemOnGroupPriority(final int r3) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$removeItemOnGroupPriority$3;
                lambda$removeItemOnGroupPriority$3 = DatabaseHelper.this.lambda$removeItemOnGroupPriority$3(r3);
                return lambda$removeItemOnGroupPriority$3;
            }
        });
    }

    public Future<ConfigurationItem> updateConfigurationItemInDb(final ConfigurationItem configurationItem) {
        return this.mRunner.submit(new Callable() { // from class: com.animaconnected.secondo.provider.configuration.database.DatabaseHelper$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ConfigurationItem lambda$updateConfigurationItemInDb$1;
                lambda$updateConfigurationItemInDb$1 = DatabaseHelper.this.lambda$updateConfigurationItemInDb$1(configurationItem);
                return lambda$updateConfigurationItemInDb$1;
            }
        });
    }
}
