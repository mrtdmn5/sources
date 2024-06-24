package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amplifyframework.devmenu.DeveloperMenuActivity$$ExternalSyntheticLambda0;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {
    public static final Encoding PROTOBUF_ENCODING = new Encoding("proto");
    public final EventStoreConfig config;
    public final Clock monotonicClock;
    public final Provider<String> packageName;
    public final SchemaManager schemaManager;
    public final Clock wallClock;

    /* loaded from: classes3.dex */
    public interface Function<T, U> {
        U apply(T t);
    }

    /* loaded from: classes3.dex */
    public static class Metadata {
        public final String key;
        public final String value;

        public Metadata(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public SQLiteEventStore(Clock clock, Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, Provider<String> provider) {
        this.schemaManager = schemaManager;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
        this.packageName = provider;
    }

    public static Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))));
        if (transportContext.getExtras() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) tryWithCursor(sQLiteDatabase.query("transport_contexts", new String[]{TransferTable.COLUMN_ID}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new SQLiteEventStore$$ExternalSyntheticLambda11());
    }

    public static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getId());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T tryWithCursor(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final int cleanUp() {
        final long time = this.wallClock.getTime() - this.config.getEventCleanUpAge();
        return ((Integer) inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                sQLiteEventStore.getClass();
                String[] strArr = {String.valueOf(time)};
                SQLiteEventStore.tryWithCursor(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new DeveloperMenuActivity$$ExternalSyntheticLambda0(sQLiteEventStore));
                return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
            }
        })).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.schemaManager.close();
    }

    public final SQLiteDatabase getDb() {
        SchemaManager schemaManager = this.schemaManager;
        Objects.requireNonNull(schemaManager);
        Clock clock = this.monotonicClock;
        long time = clock.getTime();
        while (true) {
            try {
                return schemaManager.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() < this.config.getCriticalSectionEnterTimeoutMs() + time) {
                    SystemClock.sleep(50L);
                } else {
                    throw new SynchronizationException("Timed out while trying to open db.", e);
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final long getNextCallTime(TransportContext transportContext) {
        Long l;
        Cursor rawQuery = getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))});
        try {
            if (rawQuery.moveToNext()) {
                l = Long.valueOf(rawQuery.getLong(0));
            } else {
                l = 0L;
            }
            rawQuery.close();
            return l.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final boolean hasPendingEventsFor(final TransportContext transportContext) {
        return ((Boolean) inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda2
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                sQLiteEventStore.getClass();
                Long transportContextId = SQLiteEventStore.getTransportContextId((SQLiteDatabase) obj, transportContext);
                if (transportContextId == null) {
                    return Boolean.FALSE;
                }
                Cursor rawQuery = sQLiteEventStore.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                try {
                    return Boolean.valueOf(rawQuery.moveToNext());
                } finally {
                    rawQuery.close();
                }
            }
        })).booleanValue();
    }

    public final <T> T inTransaction(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            T apply = function.apply(db);
            db.setTransactionSuccessful();
            return apply;
        } finally {
            db.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable<TransportContext> loadActiveContexts() {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            List list = (List) tryWithCursor(db.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new SQLiteEventStore$$ExternalSyntheticLambda1());
            db.setTransactionSuccessful();
            db.endTransaction();
            return list;
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final Iterable<PersistedEvent> loadBatch(final TransportContext transportContext) {
        return (Iterable) inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda7
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                EventStoreConfig eventStoreConfig = sQLiteEventStore.config;
                int loadBatchSize = eventStoreConfig.getLoadBatchSize();
                TransportContext transportContext2 = transportContext;
                ArrayList loadEvents = sQLiteEventStore.loadEvents(sQLiteDatabase, transportContext2, loadBatchSize);
                for (Priority priority : Priority.values()) {
                    if (priority != transportContext2.getPriority()) {
                        int loadBatchSize2 = eventStoreConfig.getLoadBatchSize() - loadEvents.size();
                        if (loadBatchSize2 <= 0) {
                            break;
                        }
                        loadEvents.addAll(sQLiteEventStore.loadEvents(sQLiteDatabase, transportContext2.withPriority(priority), loadBatchSize2));
                    }
                }
                final HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder("event_id IN (");
                for (int r5 = 0; r5 < loadEvents.size(); r5++) {
                    sb.append(((PersistedEvent) loadEvents.get(r5)).getId());
                    if (r5 < loadEvents.size() - 1) {
                        sb.append(',');
                    }
                }
                sb.append(')');
                SQLiteEventStore.tryWithCursor(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new SQLiteEventStore.Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda8
                    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
                    public final Object apply(Object obj2) {
                        Cursor cursor = (Cursor) obj2;
                        while (cursor.moveToNext()) {
                            long j = cursor.getLong(0);
                            Long valueOf = Long.valueOf(j);
                            Map map = hashMap;
                            Set set = (Set) map.get(valueOf);
                            if (set == null) {
                                set = new HashSet();
                                map.put(Long.valueOf(j), set);
                            }
                            set.add(new SQLiteEventStore.Metadata(cursor.getString(1), cursor.getString(2)));
                        }
                        return null;
                    }
                });
                ListIterator listIterator = loadEvents.listIterator();
                while (listIterator.hasNext()) {
                    PersistedEvent persistedEvent = (PersistedEvent) listIterator.next();
                    if (hashMap.containsKey(Long.valueOf(persistedEvent.getId()))) {
                        AutoValue_EventInternal.Builder builder = persistedEvent.getEvent().toBuilder();
                        for (SQLiteEventStore.Metadata metadata : (Set) hashMap.get(Long.valueOf(persistedEvent.getId()))) {
                            builder.addMetadata(metadata.key, metadata.value);
                        }
                        listIterator.set(new AutoValue_PersistedEvent(persistedEvent.getId(), persistedEvent.getTransportContext(), builder.build()));
                    }
                }
                return loadEvents;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final ClientMetrics loadClientMetrics() {
        int r0 = ClientMetrics.$r8$clinit;
        final ClientMetrics.Builder builder = new ClientMetrics.Builder();
        final HashMap hashMap = new HashMap();
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            ClientMetrics clientMetrics = (ClientMetrics) tryWithCursor(db.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda12
                @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
                public final Object apply(Object obj) {
                    Map map;
                    Cursor cursor = (Cursor) obj;
                    SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                    sQLiteEventStore.getClass();
                    while (true) {
                        boolean moveToNext = cursor.moveToNext();
                        map = hashMap;
                        if (!moveToNext) {
                            break;
                        }
                        String string = cursor.getString(0);
                        int r2 = cursor.getInt(1);
                        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
                        if (r2 != reason.getNumber()) {
                            LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
                            if (r2 != reason2.getNumber()) {
                                reason2 = LogEventDropped.Reason.CACHE_FULL;
                                if (r2 != reason2.getNumber()) {
                                    reason2 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
                                    if (r2 != reason2.getNumber()) {
                                        reason2 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
                                        if (r2 != reason2.getNumber()) {
                                            reason2 = LogEventDropped.Reason.INVALID_PAYLOD;
                                            if (r2 != reason2.getNumber()) {
                                                reason2 = LogEventDropped.Reason.SERVER_ERROR;
                                                if (r2 != reason2.getNumber()) {
                                                    Logging.d(Integer.valueOf(r2), "SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            reason = reason2;
                        }
                        long j = cursor.getLong(2);
                        if (!map.containsKey(string)) {
                            map.put(string, new ArrayList());
                        }
                        ((List) map.get(string)).add(new LogEventDropped(j, reason));
                    }
                    Iterator it = map.entrySet().iterator();
                    while (true) {
                        boolean hasNext = it.hasNext();
                        ClientMetrics.Builder builder2 = builder;
                        if (hasNext) {
                            Map.Entry entry = (Map.Entry) it.next();
                            int r4 = LogSourceMetrics.$r8$clinit;
                            new ArrayList();
                            builder2.log_source_metrics_.add(new LogSourceMetrics((String) entry.getKey(), Collections.unmodifiableList((List) entry.getValue())));
                        } else {
                            final long time = sQLiteEventStore.wallClock.getTime();
                            SQLiteDatabase db2 = sQLiteEventStore.getDb();
                            db2.beginTransaction();
                            try {
                                TimeWindow timeWindow = (TimeWindow) SQLiteEventStore.tryWithCursor(db2.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new SQLiteEventStore.Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda13
                                    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
                                    public final Object apply(Object obj2) {
                                        Cursor cursor2 = (Cursor) obj2;
                                        cursor2.moveToNext();
                                        return new TimeWindow(cursor2.getLong(0), time);
                                    }
                                });
                                db2.setTransactionSuccessful();
                                db2.endTransaction();
                                builder2.window_ = timeWindow;
                                builder2.global_metrics_ = new GlobalMetrics(new StorageMetrics(sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong(), EventStoreConfig.DEFAULT.maxStorageSizeInBytes));
                                builder2.app_namespace_ = sQLiteEventStore.packageName.get();
                                return new ClientMetrics(builder2.window_, Collections.unmodifiableList(builder2.log_source_metrics_), builder2.global_metrics_, builder2.app_namespace_);
                            } catch (Throwable th) {
                                db2.endTransaction();
                                throw th;
                            }
                        }
                    }
                }
            });
            db.setTransactionSuccessful();
            return clientMetrics;
        } finally {
            db.endTransaction();
        }
    }

    public final ArrayList loadEvents(SQLiteDatabase sQLiteDatabase, final TransportContext transportContext, int r15) {
        final ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        tryWithCursor(sQLiteDatabase.query("events", new String[]{TransferTable.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", AnalyticsConstants.KEY_CODE, "inline"}, "context_id = ?", new String[]{transportContextId.toString()}, null, null, null, String.valueOf(r15)), new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda10
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                boolean z;
                Encoding encoding;
                Encoding encoding2;
                Cursor cursor = (Cursor) obj;
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                sQLiteEventStore.getClass();
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(0);
                    if (cursor.getInt(7) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    AutoValue_EventInternal.Builder builder = new AutoValue_EventInternal.Builder();
                    builder.autoMetadata = new HashMap();
                    builder.setTransportName(cursor.getString(1));
                    builder.eventMillis = Long.valueOf(cursor.getLong(2));
                    builder.uptimeMillis = Long.valueOf(cursor.getLong(3));
                    if (z) {
                        String string = cursor.getString(4);
                        if (string == null) {
                            encoding2 = SQLiteEventStore.PROTOBUF_ENCODING;
                        } else {
                            encoding2 = new Encoding(string);
                        }
                        builder.setEncodedPayload(new EncodedPayload(encoding2, cursor.getBlob(5)));
                    } else {
                        String string2 = cursor.getString(4);
                        if (string2 == null) {
                            encoding = SQLiteEventStore.PROTOBUF_ENCODING;
                        } else {
                            encoding = new Encoding(string2);
                        }
                        Cursor query = sQLiteEventStore.getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                        try {
                            Encoding encoding3 = SQLiteEventStore.PROTOBUF_ENCODING;
                            ArrayList arrayList2 = new ArrayList();
                            int r11 = 0;
                            while (query.moveToNext()) {
                                byte[] blob = query.getBlob(0);
                                arrayList2.add(blob);
                                r11 += blob.length;
                            }
                            byte[] bArr = new byte[r11];
                            int r13 = 0;
                            for (int r12 = 0; r12 < arrayList2.size(); r12++) {
                                byte[] bArr2 = (byte[]) arrayList2.get(r12);
                                System.arraycopy(bArr2, 0, bArr, r13, bArr2.length);
                                r13 += bArr2.length;
                            }
                            query.close();
                            builder.setEncodedPayload(new EncodedPayload(encoding, bArr));
                        } catch (Throwable th) {
                            query.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        builder.code = Integer.valueOf(cursor.getInt(6));
                    }
                    arrayList.add(new AutoValue_PersistedEvent(j, transportContext, builder.build()));
                }
                return null;
            }
        });
        return arrayList;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final AutoValue_PersistedEvent persist(final TransportContext transportContext, final EventInternal eventInternal) {
        Object[] objArr = {transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName()};
        String tag = Logging.getTag("SQLiteEventStore");
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format("Storing event with priority=%s, name=%s for destination %s", objArr));
        }
        long longValue = ((Long) inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                boolean z;
                long insert;
                boolean z2;
                byte[] bArr;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                long simpleQueryForLong = sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
                EventStoreConfig eventStoreConfig = sQLiteEventStore.config;
                if (simpleQueryForLong >= eventStoreConfig.getMaxStorageSizeInBytes()) {
                    z = true;
                } else {
                    z = false;
                }
                EventInternal eventInternal2 = eventInternal;
                if (z) {
                    sQLiteEventStore.recordLogEventDropped(1L, LogEventDropped.Reason.CACHE_FULL, eventInternal2.getTransportName());
                    return -1L;
                }
                TransportContext transportContext2 = transportContext;
                Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, transportContext2);
                if (transportContextId != null) {
                    insert = transportContextId.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", transportContext2.getBackendName());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext2.getPriority())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (transportContext2.getExtras() != null) {
                        contentValues.put("extras", Base64.encodeToString(transportContext2.getExtras(), 0));
                    }
                    insert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int maxBlobByteSizePerRow = eventStoreConfig.getMaxBlobByteSizePerRow();
                byte[] bArr2 = eventInternal2.getEncodedPayload().bytes;
                if (bArr2.length <= maxBlobByteSizePerRow) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(insert));
                contentValues2.put("transport_name", eventInternal2.getTransportName());
                contentValues2.put("timestamp_ms", Long.valueOf(eventInternal2.getEventMillis()));
                contentValues2.put("uptime_ms", Long.valueOf(eventInternal2.getUptimeMillis()));
                contentValues2.put("payload_encoding", eventInternal2.getEncodedPayload().encoding.name);
                contentValues2.put(AnalyticsConstants.KEY_CODE, eventInternal2.getCode());
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z2));
                if (z2) {
                    bArr = bArr2;
                } else {
                    bArr = new byte[0];
                }
                contentValues2.put("payload", bArr);
                long insert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z2) {
                    int ceil = (int) Math.ceil(bArr2.length / maxBlobByteSizePerRow);
                    for (int r3 = 1; r3 <= ceil; r3++) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr2, (r3 - 1) * maxBlobByteSizePerRow, Math.min(r3 * maxBlobByteSizePerRow, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert2));
                        contentValues3.put("sequence_num", Integer.valueOf(r3));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(eventInternal2.getAutoMetadata()).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert2);
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return new AutoValue_PersistedEvent(longValue, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordFailure(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + toIdList(iterable);
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            db.compileStatement(str).execute();
            Cursor rawQuery = db.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
            while (rawQuery.moveToNext()) {
                try {
                    recordLogEventDropped(rawQuery.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, rawQuery.getString(1));
                } catch (Throwable th) {
                    rawQuery.close();
                    throw th;
                }
            }
            rawQuery.close();
            db.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void recordLogEventDropped(final long j, final LogEventDropped.Reason reason, final String str) {
        inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda4
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                LogEventDropped.Reason reason2 = reason;
                String num = Integer.toString(reason2.getNumber());
                String str2 = str;
                boolean booleanValue = ((Boolean) SQLiteEventStore.tryWithCursor(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str2, num}), new PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0())).booleanValue();
                long j2 = j;
                if (!booleanValue) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("log_source", str2);
                    contentValues.put("reason", Integer.valueOf(reason2.getNumber()));
                    contentValues.put("events_dropped_count", Long.valueOf(j2));
                    sQLiteDatabase.insert("log_event_dropped", null, contentValues);
                } else {
                    sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str2, Integer.toString(reason2.getNumber())});
                }
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordNextCallTime(final long j, final TransportContext transportContext) {
        inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda5
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                ContentValues contentValues = new ContentValues();
                contentValues.put("next_request_ms", Long.valueOf(j));
                TransportContext transportContext2 = transportContext;
                if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext2.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext2.getPriority()))}) < 1) {
                    contentValues.put("backend_name", transportContext2.getBackendName());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext2.getPriority())));
                    sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public final void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (!iterable.iterator().hasNext()) {
            return;
        }
        getDb().compileStatement("DELETE FROM events WHERE _id in " + toIdList(iterable)).execute();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore
    public final void resetClientMetrics() {
        inTransaction(new Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda6
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
            public final Object apply(Object obj) {
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore = SQLiteEventStore.this;
                sQLiteEventStore.getClass();
                sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
                sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + sQLiteEventStore.wallClock.getTime()).execute();
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public final <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase db = getDb();
        Clock clock = this.monotonicClock;
        long time = clock.getTime();
        while (true) {
            try {
                db.beginTransaction();
                try {
                    T execute = criticalSection.execute();
                    db.setTransactionSuccessful();
                    return execute;
                } finally {
                    db.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() < this.config.getCriticalSectionEnterTimeoutMs() + time) {
                    SystemClock.sleep(50L);
                } else {
                    throw new SynchronizationException("Timed out while trying to acquire the lock.", e);
                }
            }
        }
    }
}
