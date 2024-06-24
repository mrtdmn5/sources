package com.animaconnected.watch.storage.models;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import com.animaconnected.watch.fitness.FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import com.animaconnected.watch.storage.models.BehaviourSlotQueries;
import io.ktor.http.UrlKt;
import java.util.Collection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviourSlotQueries.kt */
/* loaded from: classes3.dex */
public final class BehaviourSlotQueries extends TransacterImpl {
    private final BehaviourSlot.Adapter BehaviourSlotAdapter;

    /* compiled from: BehaviourSlotQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetBehaviourOnLayerGroupQuery<T> extends Query<T> {
        private final int groupLayer;
        final /* synthetic */ BehaviourSlotQueries this$0;
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBehaviourOnLayerGroupQuery(BehaviourSlotQueries behaviourSlotQueries, String type, int r4, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = behaviourSlotQueries;
            this.type = type;
            this.groupLayer = r4;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"BehaviourSlot"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final BehaviourSlotQueries behaviourSlotQueries = this.this$0;
            return driver.executeQuery(715838855, "SELECT * FROM BehaviourSlot WHERE behaviour_type = ? AND group_layer = ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>(this) { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$GetBehaviourOnLayerGroupQuery$execute$1
                final /* synthetic */ BehaviourSlotQueries.GetBehaviourOnLayerGroupQuery<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    BehaviourSlot.Adapter adapter;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    executeQuery.bindString(0, this.this$0.getType());
                    adapter = behaviourSlotQueries.BehaviourSlotAdapter;
                    executeQuery.bindLong(1, adapter.getGroup_layerAdapter().encode(Integer.valueOf(this.this$0.getGroupLayer())));
                }
            });
        }

        public final int getGroupLayer() {
            return this.groupLayer;
        }

        public final String getType() {
            return this.type;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"BehaviourSlot"}, listener);
        }

        public String toString() {
            return "BehaviourSlot.sq:getBehaviourOnLayerGroup";
        }
    }

    /* compiled from: BehaviourSlotQueries.kt */
    /* loaded from: classes3.dex */
    public final class GetBehaviourOnSlotQuery<T> extends Query<T> {
        private final int groupLayer;
        private final int slot;
        final /* synthetic */ BehaviourSlotQueries this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBehaviourOnSlotQuery(BehaviourSlotQueries behaviourSlotQueries, int r3, int r4, Function1<? super SqlCursor, ? extends T> mapper) {
            super(mapper);
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            this.this$0 = behaviourSlotQueries;
            this.slot = r3;
            this.groupLayer = r4;
        }

        @Override // app.cash.sqldelight.Query
        public void addListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().addListener(new String[]{"BehaviourSlot"}, listener);
        }

        @Override // app.cash.sqldelight.ExecutableQuery
        public <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, "mapper");
            SqlDriver driver = this.this$0.getDriver();
            final BehaviourSlotQueries behaviourSlotQueries = this.this$0;
            return driver.executeQuery(1927248535, "SELECT * FROM BehaviourSlot WHERE slot = ? AND group_layer = ?", mapper, 2, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$GetBehaviourOnSlotQuery$execute$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                    invoke2(sqlPreparedStatement);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SqlPreparedStatement executeQuery) {
                    BehaviourSlot.Adapter adapter;
                    BehaviourSlot.Adapter adapter2;
                    Intrinsics.checkNotNullParameter(executeQuery, "$this$executeQuery");
                    adapter = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                    executeQuery.bindLong(0, adapter.getSlotAdapter().encode(Integer.valueOf(this.getSlot())));
                    adapter2 = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                    executeQuery.bindLong(1, adapter2.getGroup_layerAdapter().encode(Integer.valueOf(this.getGroupLayer())));
                }
            });
        }

        public final int getGroupLayer() {
            return this.groupLayer;
        }

        public final int getSlot() {
            return this.slot;
        }

        @Override // app.cash.sqldelight.Query
        public void removeListener(Query.Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.this$0.getDriver().removeListener(new String[]{"BehaviourSlot"}, listener);
        }

        public String toString() {
            return "BehaviourSlot.sq:getBehaviourOnSlot";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BehaviourSlotQueries(SqlDriver driver, BehaviourSlot.Adapter BehaviourSlotAdapter) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(BehaviourSlotAdapter, "BehaviourSlotAdapter");
        this.BehaviourSlotAdapter = BehaviourSlotAdapter;
    }

    public final void delete(final int r5, final int r6) {
        getDriver().execute(-1545962658, "DELETE FROM BehaviourSlot WHERE slot = ? AND group_layer = ?", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$delete$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                execute.bindLong(0, adapter.getSlotAdapter().encode(Integer.valueOf(r5)));
                adapter2 = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                execute.bindLong(1, adapter2.getGroup_layerAdapter().encode(Integer.valueOf(r6)));
            }
        });
        notifyQueries(-1545962658, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$delete$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final void deleteBehavior(final String type, final Collection<Integer> layers) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(layers, "layers");
        String createArguments = createArguments(layers.size());
        layers.size();
        getDriver().execute(null, "DELETE FROM BehaviourSlot WHERE behaviour_type = ? AND group_layer IN " + createArguments, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$deleteBehavior$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                int r1 = 0;
                execute.bindString(0, type);
                Collection<Integer> collection = layers;
                BehaviourSlotQueries behaviourSlotQueries = this;
                for (Object obj : collection) {
                    int r4 = r1 + 1;
                    if (r1 >= 0) {
                        int intValue = ((Number) obj).intValue();
                        adapter = behaviourSlotQueries.BehaviourSlotAdapter;
                        execute.bindLong(r4, adapter.getGroup_layerAdapter().encode(Integer.valueOf(intValue)));
                        r1 = r4;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
            }
        });
        notifyQueries(-633777200, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$deleteBehavior$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final void deleteFromSlot(final int r5, final Collection<Integer> layers) {
        Intrinsics.checkNotNullParameter(layers, "layers");
        String createArguments = createArguments(layers.size());
        layers.size();
        getDriver().execute(null, "DELETE FROM BehaviourSlot WHERE slot = ? AND group_layer IN " + createArguments, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$deleteFromSlot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                int r1 = 0;
                execute.bindLong(0, adapter.getSlotAdapter().encode(Integer.valueOf(r5)));
                Collection<Integer> collection = layers;
                BehaviourSlotQueries behaviourSlotQueries = BehaviourSlotQueries.this;
                for (Object obj : collection) {
                    int r4 = r1 + 1;
                    if (r1 >= 0) {
                        int intValue = ((Number) obj).intValue();
                        adapter2 = behaviourSlotQueries.BehaviourSlotAdapter;
                        execute.bindLong(r4, adapter2.getGroup_layerAdapter().encode(Integer.valueOf(intValue)));
                        r1 = r4;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
            }
        });
        notifyQueries(905589318, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$deleteFromSlot$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final <T> Query<T> getAll(final Function3<? super String, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return UrlKt.Query(-1459871714, new String[]{"BehaviourSlot"}, getDriver(), "BehaviourSlot.sq", "getAll", "SELECT *\nFROM BehaviourSlot", new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Integer, Integer, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.BehaviourSlotAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getGroup_layerAdapter());
                adapter2 = this.BehaviourSlotAdapter;
                return (T) function3.invoke(string, m, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSlotAdapter()));
            }
        });
    }

    public final <T> Query<T> getBehaviourOnLayerGroup(String type, int r4, final Function3<? super String, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetBehaviourOnLayerGroupQuery(this, type, r4, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getBehaviourOnLayerGroup$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Integer, Integer, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.BehaviourSlotAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getGroup_layerAdapter());
                adapter2 = this.BehaviourSlotAdapter;
                return (T) function3.invoke(string, m, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSlotAdapter()));
            }
        });
    }

    public final <T> Query<T> getBehaviourOnSlot(int r3, int r4, final Function3<? super String, ? super Integer, ? super Integer, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new GetBehaviourOnSlotQuery(this, r3, r4, new Function1<SqlCursor, T>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getBehaviourOnSlot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(SqlCursor cursor) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                Function3<String, Integer, Integer, T> function3 = mapper;
                String string = cursor.getString(0);
                Intrinsics.checkNotNull(string);
                adapter = this.BehaviourSlotAdapter;
                Object m = FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 1, adapter.getGroup_layerAdapter());
                adapter2 = this.BehaviourSlotAdapter;
                return (T) function3.invoke(string, m, FitnessQueries$getCurrentSessionData$1$$ExternalSyntheticOutline0.m(cursor, 2, adapter2.getSlotAdapter()));
            }
        });
    }

    public final void insert(final String behaviour_type, final int r6, final int r7) {
        Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
        getDriver().execute(-1394296724, "INSERT INTO BehaviourSlot(behaviour_type, group_layer, slot)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$insert$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, behaviour_type);
                adapter = this.BehaviourSlotAdapter;
                execute.bindLong(1, adapter.getGroup_layerAdapter().encode(Integer.valueOf(r6)));
                adapter2 = this.BehaviourSlotAdapter;
                execute.bindLong(2, adapter2.getSlotAdapter().encode(Integer.valueOf(r7)));
            }
        });
        notifyQueries(-1394296724, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$insert$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final void insertOrUpdate(final String behaviour_type, final int r6, final int r7) {
        Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
        getDriver().execute(2046029080, "INSERT OR REPLACE INTO BehaviourSlot(behaviour_type, group_layer, slot)\nVALUES (?, ?, ?)", new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$insertOrUpdate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                execute.bindString(0, behaviour_type);
                adapter = this.BehaviourSlotAdapter;
                execute.bindLong(1, adapter.getGroup_layerAdapter().encode(Integer.valueOf(r6)));
                adapter2 = this.BehaviourSlotAdapter;
                execute.bindLong(2, adapter2.getSlotAdapter().encode(Integer.valueOf(r7)));
            }
        });
        notifyQueries(2046029080, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$insertOrUpdate$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final void updateSlotForType(final int r5, final String type, final Collection<Integer> layers) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(layers, "layers");
        String createArguments = createArguments(layers.size());
        layers.size();
        getDriver().execute(null, "UPDATE BehaviourSlot SET slot = ? WHERE behaviour_type = ? AND group_layer IN " + createArguments, new Function1<SqlPreparedStatement, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$updateSlotForType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SqlPreparedStatement sqlPreparedStatement) {
                invoke2(sqlPreparedStatement);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SqlPreparedStatement execute) {
                BehaviourSlot.Adapter adapter;
                BehaviourSlot.Adapter adapter2;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                adapter = BehaviourSlotQueries.this.BehaviourSlotAdapter;
                int r1 = 0;
                execute.bindLong(0, adapter.getSlotAdapter().encode(Integer.valueOf(r5)));
                execute.bindString(1, type);
                Collection<Integer> collection = layers;
                BehaviourSlotQueries behaviourSlotQueries = BehaviourSlotQueries.this;
                for (Object obj : collection) {
                    int r4 = r1 + 1;
                    if (r1 >= 0) {
                        int intValue = ((Number) obj).intValue();
                        adapter2 = behaviourSlotQueries.BehaviourSlotAdapter;
                        execute.bindLong(r1 + 2, adapter2.getGroup_layerAdapter().encode(Integer.valueOf(intValue)));
                        r1 = r4;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
            }
        });
        notifyQueries(527559593, new Function1<Function1<? super String, ? extends Unit>, Unit>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$updateSlotForType$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function1<? super String, ? extends Unit> function1) {
                invoke2((Function1<? super String, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function1<? super String, Unit> emit) {
                Intrinsics.checkNotNullParameter(emit, "emit");
                emit.invoke("BehaviourSlot");
            }
        });
    }

    public final Query<BehaviourSlot> getAll() {
        return getAll(new Function3<String, Integer, Integer, BehaviourSlot>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getAll$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ BehaviourSlot invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final BehaviourSlot invoke(String behaviour_type, int r3, int r4) {
                Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
                return new BehaviourSlot(behaviour_type, r3, r4);
            }
        });
    }

    public final Query<BehaviourSlot> getBehaviourOnLayerGroup(String type, int r3) {
        Intrinsics.checkNotNullParameter(type, "type");
        return getBehaviourOnLayerGroup(type, r3, new Function3<String, Integer, Integer, BehaviourSlot>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getBehaviourOnLayerGroup$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ BehaviourSlot invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final BehaviourSlot invoke(String behaviour_type, int r32, int r4) {
                Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
                return new BehaviourSlot(behaviour_type, r32, r4);
            }
        });
    }

    public final Query<BehaviourSlot> getBehaviourOnSlot(int r2, int r3) {
        return getBehaviourOnSlot(r2, r3, new Function3<String, Integer, Integer, BehaviourSlot>() { // from class: com.animaconnected.watch.storage.models.BehaviourSlotQueries$getBehaviourOnSlot$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ BehaviourSlot invoke(String str, Integer num, Integer num2) {
                return invoke(str, num.intValue(), num2.intValue());
            }

            public final BehaviourSlot invoke(String behaviour_type, int r32, int r4) {
                Intrinsics.checkNotNullParameter(behaviour_type, "behaviour_type");
                return new BehaviourSlot(behaviour_type, r32, r4);
            }
        });
    }
}
