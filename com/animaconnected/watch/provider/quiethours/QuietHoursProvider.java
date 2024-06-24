package com.animaconnected.watch.provider.quiethours;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.StorageFactory;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: QuietHoursProvider.kt */
/* loaded from: classes3.dex */
public final class QuietHoursProvider {
    private final List<WeakReference<QuietHoursChangedListener>> listeners;
    private final QuietHoursStorage storage;

    /* compiled from: QuietHoursProvider.kt */
    /* loaded from: classes3.dex */
    public interface QuietHoursChangedListener {
        void onQuietHoursChanged(boolean z, int r2, int r3, int r4, int r5);
    }

    public QuietHoursProvider(StorageFactory storageFactory) {
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        this.storage = new QuietHoursStorage(storageFactory);
        this.listeners = new ArrayList();
    }

    private final void notifyListeners() {
        boolean isEnabled = this.storage.isEnabled();
        int startHour = this.storage.getStartHour();
        int startMinutes = this.storage.getStartMinutes();
        int endHour = this.storage.getEndHour();
        int endMinutes = this.storage.getEndMinutes();
        List<WeakReference<QuietHoursChangedListener>> list = this.listeners;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            QuietHoursChangedListener quietHoursChangedListener = (QuietHoursChangedListener) ((WeakReference) it.next()).get();
            if (quietHoursChangedListener != null) {
                arrayList.add(quietHoursChangedListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.mainDispatcher(), null, new QuietHoursProvider$notifyListeners$2$1((QuietHoursChangedListener) it2.next(), isEnabled, startHour, startMinutes, endHour, endMinutes, null), 2);
            isEnabled = isEnabled;
        }
    }

    public final int getEndHour() {
        return this.storage.getEndHour();
    }

    public final int getEndMinutes() {
        return this.storage.getEndMinutes();
    }

    public final int getStartHour() {
        return this.storage.getStartHour();
    }

    public final int getStartMinutes() {
        return this.storage.getStartMinutes();
    }

    public final boolean isActive() {
        if (!this.storage.isEnabled()) {
            return false;
        }
        TimeZone.Companion.getClass();
        TimeZone currentSystemDefault = TimeZone.Companion.currentSystemDefault();
        Instant instant = TimeZoneKt.toInstant(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null), currentSystemDefault);
        Instant instant2 = TimeZoneKt.toInstant(LocalDateKt.atTime$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null).getDate(), getStartHour(), getStartMinutes()), currentSystemDefault);
        Instant instant3 = TimeZoneKt.toInstant(LocalDateKt.atTime$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null).getDate(), getEndHour(), getEndMinutes()), currentSystemDefault);
        if (instant3.compareTo(instant2) < 0) {
            if (instant.compareTo(instant3) < 0) {
                int r2 = Duration.$r8$clinit;
                instant2 = instant2.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
            } else {
                int r22 = Duration.$r8$clinit;
                instant3 = instant3.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
            }
        }
        if (instant.compareTo(instant2) < 0 || instant.compareTo(instant3) > 0) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return this.storage.isEnabled();
    }

    public final void registerListener(QuietHoursChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(new WeakReference<>(listener));
    }

    public final RefreshTimer runOnNextChange(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TimeZone.Companion.getClass();
        TimeZone currentSystemDefault = TimeZone.Companion.currentSystemDefault();
        return new RefreshTimer(ServiceLocator.INSTANCE.getScope(), CollectionsKt__CollectionsKt.listOf((Object[]) new Instant[]{TimeZoneKt.toInstant(LocalDateKt.atTime$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null).getDate(), getStartHour(), getStartMinutes()), currentSystemDefault), TimeZoneKt.toInstant(LocalDateKt.atTime$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null).getDate(), getEndHour(), getEndMinutes()), currentSystemDefault)}), callback);
    }

    public final void setEnabled(boolean z) {
        if (this.storage.isEnabled() != z) {
            this.storage.setEnabled(z);
            notifyListeners();
        }
    }

    public final void setEndTime(int r2, int r3) {
        this.storage.setEndHour(r2);
        this.storage.setEndMinutes(r3);
        notifyListeners();
    }

    public final void setStartTime(int r2, int r3) {
        this.storage.setStartHour(r2);
        this.storage.setStartMinutes(r3);
        notifyListeners();
    }

    public final void unregisterListener(final QuietHoursChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt__ReversedViewsKt.removeAll(this.listeners, new Function1<WeakReference<QuietHoursChangedListener>, Boolean>() { // from class: com.animaconnected.watch.provider.quiethours.QuietHoursProvider$unregisterListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<QuietHoursProvider.QuietHoursChangedListener> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.get(), QuietHoursProvider.QuietHoursChangedListener.this));
            }
        });
    }
}
