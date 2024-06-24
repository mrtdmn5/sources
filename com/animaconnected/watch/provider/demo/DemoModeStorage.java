package com.animaconnected.watch.provider.demo;

import androidx.compose.ui.semantics.SemanticsPropertiesKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.StorageFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.datetime.Instant;

/* compiled from: DemoModeStorage.kt */
/* loaded from: classes3.dex */
public final class DemoModeStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion;
    private static final String DEMO_MODE_STORAGE = "demoModeStorage";
    private static final String KEY_LAST_RESET_FULL = "last_reset_full";
    private static final String KEY_LAST_RESET_RECENT = "last_reset_recent";
    private static final String KEY_MODE = "mode";
    private final ReadWriteProperty lastResetFull$delegate;
    private final ReadWriteProperty lastResetRecent$delegate;
    private final BasicStorage prefs;

    /* compiled from: DemoModeStorage.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(DemoModeStorage.class, "lastResetFull", "getLastResetFull()Lkotlinx/datetime/Instant;", 0);
        ReflectionFactory reflectionFactory = Reflection.factory;
        reflectionFactory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(DemoModeStorage.class, "lastResetRecent", "getLastResetRecent()Lkotlinx/datetime/Instant;", 0, reflectionFactory)};
        Companion = new Companion(null);
    }

    public DemoModeStorage(StorageFactory storageFactory) {
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        BasicStorage createStorage = storageFactory.createStorage(DEMO_MODE_STORAGE);
        this.prefs = createStorage;
        this.lastResetFull$delegate = propertyInstant(createStorage, KEY_LAST_RESET_FULL);
        this.lastResetRecent$delegate = propertyInstant(createStorage, KEY_LAST_RESET_RECENT);
    }

    private final ReadWriteProperty<Object, Instant> propertyInstant(final BasicStorage basicStorage, final String str) {
        return new ReadWriteProperty<Object, Instant>() { // from class: com.animaconnected.watch.provider.demo.DemoModeStorage$propertyInstant$1
            @Override // kotlin.properties.ReadWriteProperty
            public /* bridge */ /* synthetic */ Instant getValue(Object obj, KProperty kProperty) {
                return getValue2(obj, (KProperty<?>) kProperty);
            }

            @Override // kotlin.properties.ReadWriteProperty
            public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Instant instant) {
                setValue2(obj, (KProperty<?>) kProperty, instant);
            }

            @Override // kotlin.properties.ReadWriteProperty
            /* renamed from: getValue, reason: avoid collision after fix types in other method */
            public Instant getValue2(Object obj, KProperty<?> property) {
                Intrinsics.checkNotNullParameter(property, "property");
                Long l = BasicStorage.this.getLong(str);
                if (l == null) {
                    return null;
                }
                long longValue = l.longValue();
                Instant.Companion.getClass();
                return Instant.Companion.fromEpochMilliseconds(longValue);
            }

            /* renamed from: setValue, reason: avoid collision after fix types in other method */
            public void setValue2(Object obj, KProperty<?> property, Instant instant) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (instant != null) {
                    BasicStorage.this.put(str, instant.toEpochMilliseconds());
                } else {
                    BasicStorage.this.remove(str);
                }
            }
        };
    }

    private final WatchDemoMode toWatchDemoMode(int r2) {
        if (r2 != 0) {
            if (r2 == 1) {
                return WatchDemoMode.Retail;
            }
            throw new IllegalArgumentException("Unknown demo mode value");
        }
        return WatchDemoMode.None;
    }

    public final Instant getLastResetFull() {
        return (Instant) this.lastResetFull$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final Instant getLastResetRecent() {
        return (Instant) this.lastResetRecent$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final WatchDemoMode getWatchDemoMode() {
        Integer num = this.prefs.getInt(KEY_MODE);
        if (num != null) {
            return toWatchDemoMode(num.intValue());
        }
        return null;
    }

    public final void setLastResetFull(Instant instant) {
        this.lastResetFull$delegate.setValue(this, $$delegatedProperties[0], instant);
    }

    public final void setLastResetRecent(Instant instant) {
        this.lastResetRecent$delegate.setValue(this, $$delegatedProperties[1], instant);
    }

    public final void setWatchDemoMode(WatchDemoMode watchDemoMode) {
        if (watchDemoMode != null) {
            this.prefs.put(KEY_MODE, watchDemoMode.getMode());
        } else {
            this.prefs.remove(KEY_MODE);
        }
    }
}
