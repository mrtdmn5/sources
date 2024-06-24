package com.animaconnected.watch.storage;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import app.cash.sqldelight.TransactionWithoutReturn;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.DevicesKt;
import com.animaconnected.info.FirmwareVariant;
import com.animaconnected.info.UserCategory;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.GroupLayer;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchDatabase;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.storage.models.BehaviourSlot;
import com.animaconnected.watch.storage.models.DBCurrentWatch;
import com.animaconnected.watch.storage.models.DBCurrentWatchQueries;
import com.animaconnected.watch.storage.models.DBWatch;
import com.animaconnected.watch.storage.models.DBWatchQueries;
import com.animaconnected.watch.storage.models.GetCurrent;
import com.animaconnected.watch.storage.models.GetCurrentAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: WatchDb.kt */
/* loaded from: classes3.dex */
public final class WatchDb implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private final DBCurrentWatchQueries currentQueries;
    private final WatchDatabase db;
    private final String emptyType;
    private final CompletableJob job;
    private final DBWatchQueries watchQueries;

    /* compiled from: WatchDb.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void saveBehaviour(WatchDb watchDb, Behaviour behaviour, Slot slot, GroupLayer groupLayer, List<? extends GroupLayer> groupLayers) {
            Intrinsics.checkNotNullParameter(watchDb, "watchDb");
            Intrinsics.checkNotNullParameter(behaviour, "behaviour");
            Intrinsics.checkNotNullParameter(slot, "slot");
            Intrinsics.checkNotNullParameter(groupLayer, "groupLayer");
            Intrinsics.checkNotNullParameter(groupLayers, "groupLayers");
            watchDb.saveBehaviour(behaviour.getType(), slot, groupLayer, groupLayers);
        }

        private Companion() {
        }
    }

    public WatchDb(WatchDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        this.db = db;
        this.emptyType = "Empty";
        this.watchQueries = db.getDBWatchQueries();
        this.currentQueries = db.getDBCurrentWatchQueries();
        this.job = SupervisorKt.SupervisorJob$default();
    }

    public static /* synthetic */ void saveWatch$default(WatchDb watchDb, String str, DeviceType deviceType, FirmwareVariant firmwareVariant, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            firmwareVariant = new FirmwareVariant(null, 1, null);
        }
        watchDb.saveWatch(str, deviceType, firmwareVariant);
    }

    public final void setOrUpdateCurrent(final String str) {
        final DBCurrentWatchQueries dBCurrentWatchQueries = this.currentQueries;
        dBCurrentWatchQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.storage.WatchDb$setOrUpdateCurrent$1
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
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                if (DBCurrentWatchQueries.this.getCurrentAddress().executeAsOneOrNull() == null) {
                    DBCurrentWatchQueries.this.insertCurrent(new DBCurrentWatch(1L, str));
                } else {
                    DBCurrentWatchQueries.this.updateCurrent(str);
                }
            }
        });
    }

    public final long amountOfWatches() {
        return this.watchQueries.getCount().executeAsOne().longValue();
    }

    public final void changeAddressOnCurrent$watch_release(final String newAddress) {
        Intrinsics.checkNotNullParameter(newAddress, "newAddress");
        final DBCurrentWatchQueries dBCurrentWatchQueries = this.currentQueries;
        dBCurrentWatchQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.storage.WatchDb$changeAddressOnCurrent$1
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
                DBWatchQueries dBWatchQueries;
                DBWatchQueries dBWatchQueries2;
                DBWatchQueries dBWatchQueries3;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                final GetCurrent executeAsOneOrNull = DBCurrentWatchQueries.this.getCurrent().executeAsOneOrNull();
                if (executeAsOneOrNull != null) {
                    DBCurrentWatchQueries.this.deleteCurrent();
                    dBWatchQueries = this.watchQueries;
                    String device_address = executeAsOneOrNull.getDevice_address();
                    Intrinsics.checkNotNull(device_address);
                    dBWatchQueries.delete(device_address);
                    dBWatchQueries2 = this.watchQueries;
                    if (dBWatchQueries2.getWatchByAddress(newAddress).executeAsOneOrNull() == null) {
                        dBWatchQueries3 = this.watchQueries;
                        String str = newAddress;
                        Integer device_type = executeAsOneOrNull.getDevice_type();
                        Intrinsics.checkNotNull(device_type);
                        int intValue = device_type.intValue();
                        String sku = executeAsOneOrNull.getSku();
                        String last_dfu_result = executeAsOneOrNull.getLast_dfu_result();
                        Intrinsics.checkNotNull(last_dfu_result);
                        Boolean stronger_vibration = executeAsOneOrNull.getStronger_vibration();
                        Intrinsics.checkNotNull(stronger_vibration);
                        boolean booleanValue = stronger_vibration.booleanValue();
                        Long time_diagnostics_sent = executeAsOneOrNull.getTime_diagnostics_sent();
                        Intrinsics.checkNotNull(time_diagnostics_sent);
                        long longValue = time_diagnostics_sent.longValue();
                        Long time_since_daily = executeAsOneOrNull.getTime_since_daily();
                        Intrinsics.checkNotNull(time_since_daily);
                        dBWatchQueries3.insertAll(new DBWatch(str, intValue, sku, last_dfu_result, booleanValue, longValue, time_since_daily.longValue(), executeAsOneOrNull.getVariant(), executeAsOneOrNull.getCategory()));
                        this.setOrUpdateCurrent(newAddress);
                        return;
                    }
                    final String str2 = newAddress;
                    LogKt.debug$default((Object) transaction, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$changeAddressOnCurrent$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            StringBuilder sb = new StringBuilder("Can't change from old ");
                            sb.append(GetCurrent.this.getDevice_address());
                            sb.append(" to new ");
                            return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str2, ". New address already in use");
                        }
                    }, 7, (Object) null);
                    transaction.rollback();
                    throw new KotlinNothingValueException();
                }
                LogKt.debug$default((Object) transaction, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$changeAddressOnCurrent$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No current device, can't change address";
                    }
                }, 7, (Object) null);
                transaction.rollback();
                throw new KotlinNothingValueException();
            }
        });
    }

    public final List<DBWatch> getAllWatches() {
        return this.watchQueries.getAll().executeAsList();
    }

    public final Object getBehaviourOnSlot(Slot slot, GroupLayer groupLayer, Continuation<? super BehaviourSlot> continuation) {
        return BuildersKt.withContext(DispatchersKt.ioDispatcher(), new WatchDb$getBehaviourOnSlot$2(this, slot, groupLayer, null), continuation);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return DispatchersKt.mainDispatcher().plus(this.job);
    }

    public final DBWatch getCurrentWatch() {
        String current_address;
        GetCurrentAddress executeAsOneOrNull = this.currentQueries.getCurrentAddress().executeAsOneOrNull();
        if (executeAsOneOrNull != null && (current_address = executeAsOneOrNull.getCurrent_address()) != null) {
            final DBWatch executeAsOneOrNull2 = this.watchQueries.getWatchByAddress(current_address).executeAsOneOrNull();
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$getCurrentWatch$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder("Current device from other db: ");
                    DBWatch dBWatch = DBWatch.this;
                    sb.append(dBWatch != null ? dBWatch.getDevice_address() : null);
                    sb.append(" sku ");
                    DBWatch dBWatch2 = DBWatch.this;
                    sb.append(dBWatch2 != null ? dBWatch2.getSku() : null);
                    return sb.toString();
                }
            }, 7, (Object) null);
            return executeAsOneOrNull2;
        }
        return null;
    }

    public final WatchDatabase getDb() {
        return this.db;
    }

    public final DBWatch getWatch(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.watchQueries.getWatchByAddress(address).executeAsOneOrNull();
    }

    public final void removeCurrentDevice$watch_release() {
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$removeCurrentDevice$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "removeCurrentDevice";
            }
        }, 7, (Object) null);
        final DBCurrentWatchQueries dBCurrentWatchQueries = this.currentQueries;
        dBCurrentWatchQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.storage.WatchDb$removeCurrentDevice$2
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
                DBWatchQueries dBWatchQueries;
                Object obj;
                DBWatchQueries dBWatchQueries2;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                GetCurrentAddress executeAsOneOrNull = DBCurrentWatchQueries.this.getCurrentAddress().executeAsOneOrNull();
                String current_address = executeAsOneOrNull != null ? executeAsOneOrNull.getCurrent_address() : null;
                if (current_address != null) {
                    dBWatchQueries = this.watchQueries;
                    Iterator<T> it = dBWatchQueries.getAll().executeAsList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (!Intrinsics.areEqual(((DBWatch) obj).getDevice_address(), current_address)) {
                                break;
                            }
                        }
                    }
                    DBWatch dBWatch = (DBWatch) obj;
                    String device_address = dBWatch != null ? dBWatch.getDevice_address() : null;
                    if (device_address != null) {
                        this.setOrUpdateCurrent(device_address);
                    }
                    dBWatchQueries2 = this.watchQueries;
                    dBWatchQueries2.delete(current_address);
                    return;
                }
                LogKt.debug$default((Object) transaction, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$removeCurrentDevice$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No current device found";
                    }
                }, 7, (Object) null);
            }
        });
    }

    public final void removeDevice$watch_release(String address) {
        String str;
        Intrinsics.checkNotNullParameter(address, "address");
        if (getWatch(address) != null) {
            this.watchQueries.delete(address);
            GetCurrentAddress executeAsOneOrNull = this.currentQueries.getCurrentAddress().executeAsOneOrNull();
            if (executeAsOneOrNull != null) {
                str = executeAsOneOrNull.getCurrent_address();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, address)) {
                throw new RuntimeException("Removed device was also current device: ".concat(address));
            }
        }
    }

    public final void saveBehaviour(String type, Slot slot, GroupLayer groupLayer, List<? extends GroupLayer> groupLayers) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(groupLayer, "groupLayer");
        Intrinsics.checkNotNullParameter(groupLayers, "groupLayers");
        List<? extends GroupLayer> list = groupLayers;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((GroupLayer) it.next()).getId()));
        }
        if (!Intrinsics.areEqual(type, this.emptyType)) {
            this.db.getBehaviourSlotQueries().deleteBehavior(type, arrayList);
        }
        this.db.getBehaviourSlotQueries().deleteFromSlot(slot.getId(), arrayList);
        if (!Intrinsics.areEqual(type, this.emptyType)) {
            this.db.getBehaviourSlotQueries().insertOrUpdate(type, groupLayer.getId(), slot.getId());
        }
    }

    public final void saveWatch(final String address, final DeviceType deviceType, final FirmwareVariant firmwareVariant) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(firmwareVariant, "firmwareVariant");
        this.watchQueries.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.storage.WatchDb$saveWatch$1
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
                DBWatchQueries dBWatchQueries;
                DBWatchQueries dBWatchQueries2;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                dBWatchQueries = WatchDb.this.watchQueries;
                if (dBWatchQueries.getWatchByAddress(address).executeAsOneOrNull() == null) {
                    if (Intrinsics.areEqual(address, DevicesKt.fakeMacAddress)) {
                        LogKt.warn$default((Object) transaction, "WatchDb", (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.storage.WatchDb$saveWatch$1.1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Storing a watch with fake Mac address in db ".concat(ExceptionsKt.stackTraceToString(new Exception()));
                            }
                        }, 2, (Object) null);
                    }
                    dBWatchQueries2 = WatchDb.this.watchQueries;
                    dBWatchQueries2.insertAll(new DBWatch(address, deviceType.getAdvertisedNumber(), null, "None", false, 0L, 0L, firmwareVariant.getValue(), UserCategory.Live.getIdentifier()));
                }
                WatchDb.this.setOrUpdateCurrent(address);
            }
        });
    }

    public final void setCurrent(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        DBWatch executeAsOneOrNull = this.watchQueries.getWatchByAddress(address).executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            setOrUpdateCurrent(executeAsOneOrNull.getDevice_address());
        }
    }

    public final void updateCategory(UserCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        DBWatch currentWatch = getCurrentWatch();
        if (currentWatch == null) {
            return;
        }
        this.watchQueries.updateCategory(category.getIdentifier(), currentWatch.getDevice_address());
    }

    public final void updateLastDfuResult(String str) {
        DBWatch currentWatch;
        if (str == null || (currentWatch = getCurrentWatch()) == null) {
            return;
        }
        this.watchQueries.updateLastDfuResult(str, currentWatch.getDevice_address());
    }

    public final void updateSku(String str) {
        DBWatch currentWatch = getCurrentWatch();
        if (currentWatch == null) {
            return;
        }
        this.watchQueries.updateSku(str, currentWatch.getDevice_address());
    }

    public final void updateStrongerVibration(boolean z, String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.watchQueries.updateStrongerVibration(z, address);
    }

    public final void updateTimeDiagnosticsSent(Long l) {
        DBWatch currentWatch;
        if (l == null || (currentWatch = getCurrentWatch()) == null) {
            return;
        }
        this.watchQueries.updateTimeDiagnosticsSent(l.longValue(), currentWatch.getDevice_address());
    }

    public final void updateTimeSinceDaily(Long l) {
        DBWatch currentWatch;
        if (l == null || (currentWatch = getCurrentWatch()) == null) {
            return;
        }
        this.watchQueries.updateTimeSinceDaily(l.longValue(), currentWatch.getDevice_address());
    }
}
