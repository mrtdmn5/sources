package com.animaconnected.watch.filter;

import java.util.NoSuchElementException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FilterSettingsExtension.kt */
/* loaded from: classes3.dex */
public final class ApplicationSetting {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApplicationSetting[] $VALUES;
    public static final Companion Companion;
    private final int rawValue;
    public static final ApplicationSetting NotImportant = new ApplicationSetting("NotImportant", 0, 0);
    public static final ApplicationSetting MessagingApplication = new ApplicationSetting("MessagingApplication", 1, 1);
    public static final ApplicationSetting Important = new ApplicationSetting("Important", 2, 2);
    public static final ApplicationSetting Ignored = new ApplicationSetting("Ignored", 3, 3);

    /* compiled from: FilterSettingsExtension.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ApplicationSetting fromInt(int r4) {
            boolean z;
            for (ApplicationSetting applicationSetting : ApplicationSetting.getEntries()) {
                if (applicationSetting.getRawValue() == r4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return applicationSetting;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ApplicationSetting[] $values() {
        return new ApplicationSetting[]{NotImportant, MessagingApplication, Important, Ignored};
    }

    static {
        ApplicationSetting[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private ApplicationSetting(String str, int r2, int r3) {
        this.rawValue = r3;
    }

    public static EnumEntries<ApplicationSetting> getEntries() {
        return $ENTRIES;
    }

    public static ApplicationSetting valueOf(String str) {
        return (ApplicationSetting) Enum.valueOf(ApplicationSetting.class, str);
    }

    public static ApplicationSetting[] values() {
        return (ApplicationSetting[]) $VALUES.clone();
    }

    public final int getRawValue() {
        return this.rawValue;
    }
}
