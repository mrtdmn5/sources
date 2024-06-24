package com.animaconnected.watch.filter;

import com.animaconnected.watch.CommonFlow;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FilterSettings.kt */
/* loaded from: classes3.dex */
public interface FilterSettings {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FilterSettings.kt */
    /* loaded from: classes3.dex */
    public static final class Allowed {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Allowed[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final Allowed All = new Allowed("All", 0, 0);
        public static final Allowed Known = new Allowed("Known", 1, 1);
        public static final Allowed Favourites = new Allowed("Favourites", 2, 2);
        public static final Allowed Important = new Allowed("Important", 3, 3);
        public static final Allowed None = new Allowed("None", 4, 4);

        /* compiled from: FilterSettings.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Allowed parseFromId(Integer num) {
                Object obj;
                boolean z;
                Iterator<E> it = Allowed.getEntries().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        int id = ((Allowed) obj).getId();
                        if (num != null && id == num.intValue()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                return (Allowed) obj;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Allowed[] $values() {
            return new Allowed[]{All, Known, Favourites, Important, None};
        }

        static {
            Allowed[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        private Allowed(String str, int r2, int r3) {
            this.id = r3;
        }

        public static EnumEntries<Allowed> getEntries() {
            return $ENTRIES;
        }

        public static Allowed valueOf(String str) {
            return (Allowed) Enum.valueOf(Allowed.class, str);
        }

        public static Allowed[] values() {
            return (Allowed[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    boolean addImportantContact(String str, String str2);

    boolean addOrUpdatesApplication(Application application);

    CommonFlow<FilterNotifications> filterNotificationsFlow();

    Application getApplication(String str);

    List<Application> getApplications();

    List<Application> getApplications(ApplicationSetting applicationSetting);

    CommonFlow<List<Application>> getApplicationsFlow(ApplicationSetting applicationSetting);

    Allowed getCallsFilter();

    List<ImportantContact> getImportantContacts();

    CommonFlow<List<ImportantContact>> getImportantContactsFlow();

    int getNbrOfApplications();

    int getNbrOfImportantContacts();

    Allowed getTextsFilter();

    boolean isAllAppsEnabled();

    void removeApplication(String str);

    void removeImportantContact(String str);

    void setAllAppsEnabled(boolean z);

    Object setApplications(List<Application> list, Continuation<? super Boolean> continuation);

    void setCallsFilter(Allowed allowed);

    void setIgnoredApplications(List<Application> list);

    void setTextApplications(List<Application> list);

    void setTextsFilter(Allowed allowed);

    void trackCurrentFilterSettingState();
}
