package com.animaconnected.watch.filter;

import com.amazonaws.http.HttpHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ancs.kt */
/* loaded from: classes3.dex */
public final class Ancs {
    public static final Companion Companion = new Companion(null);
    public static final int callsIndex = 0;
    public static final int maxNumberOfAncsFilter = 35;
    public static final int maxSearchStringLength = 32;
    public static final int textsIndex = 1;

    /* compiled from: Ancs.kt */
    /* loaded from: classes3.dex */
    public static final class Attribute extends Enum<Attribute> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Companion Companion;
        private final int rawValue;
        public static final Attribute ApplicationId = new Attribute("ApplicationId", 0, 0);
        public static final Attribute Title = new Attribute("Title", 1, 1);
        public static final Attribute Subtitle = new Attribute("Subtitle", 2, 2);
        public static final Attribute Message = new Attribute("Message", 3, 3);
        public static final Attribute All = new Attribute("All", 4, 255);

        /* compiled from: Ancs.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Attribute fromInt(int r4) {
                boolean z;
                for (Attribute attribute : Attribute.getEntries()) {
                    if (attribute.getRawValue() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return attribute;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{ApplicationId, Title, Subtitle, Message, All};
        }

        static {
            Attribute[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        private Attribute(String str, int r2, int r3) {
            super(str, r2);
            this.rawValue = r3;
        }

        public static EnumEntries<Attribute> getEntries() {
            return $ENTRIES;
        }

        public static Attribute valueOf(String str) {
            return (Attribute) Enum.valueOf(Attribute.class, str);
        }

        public static Attribute[] values() {
            return (Attribute[]) $VALUES.clone();
        }

        public final int bitmask() {
            return this.rawValue;
        }

        public final int getRawValue() {
            return this.rawValue;
        }
    }

    /* compiled from: Ancs.kt */
    /* loaded from: classes3.dex */
    public static final class Category extends Enum<Category> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Category[] $VALUES;
        public static final Companion Companion;
        private final int rawValue;
        public static final Category Other = new Category("Other", 0, 0);
        public static final Category IncomingCall = new Category("IncomingCall", 1, 1);
        public static final Category MissedCall = new Category("MissedCall", 2, 2);
        public static final Category Voicemail = new Category("Voicemail", 3, 3);
        public static final Category Social = new Category("Social", 4, 4);
        public static final Category Schedule = new Category("Schedule", 5, 5);
        public static final Category Email = new Category("Email", 6, 6);
        public static final Category News = new Category("News", 7, 7);
        public static final Category HealthAndFitness = new Category("HealthAndFitness", 8, 8);
        public static final Category BusinessAndFinance = new Category("BusinessAndFinance", 9, 9);
        public static final Category Location = new Category(HttpHeader.LOCATION, 10, 10);
        public static final Category Entertainment = new Category("Entertainment", 11, 11);

        /* compiled from: Ancs.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Set<Category> all() {
                return CollectionsKt___CollectionsKt.toSet(Category.getEntries());
            }

            public final int bitmask(Set<? extends Category> categories) {
                Intrinsics.checkNotNullParameter(categories, "categories");
                if (Intrinsics.areEqual(categories, all())) {
                    return 16777215;
                }
                Iterator it = CollectionsKt___CollectionsKt.toList(categories).iterator();
                int r0 = 0;
                while (it.hasNext()) {
                    r0 |= ((Category) it.next()).bitmask();
                }
                return r0;
            }

            public final Set<Category> fromBitmask(int r5) {
                boolean z;
                Set<Category> all = all();
                ArrayList arrayList = new ArrayList();
                for (Object obj : all) {
                    if ((((Category) obj).bitmask() & r5) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(obj);
                    }
                }
                return CollectionsKt___CollectionsKt.toSet(arrayList);
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Category[] $values() {
            return new Category[]{Other, IncomingCall, MissedCall, Voicemail, Social, Schedule, Email, News, HealthAndFitness, BusinessAndFinance, Location, Entertainment};
        }

        static {
            Category[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            Companion = new Companion(null);
        }

        private Category(String str, int r2, int r3) {
            super(str, r2);
            this.rawValue = r3;
        }

        public static EnumEntries<Category> getEntries() {
            return $ENTRIES;
        }

        public static Category valueOf(String str) {
            return (Category) Enum.valueOf(Category.class, str);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        public final int bitmask() {
            return 1 << (this.rawValue + 8);
        }
    }

    /* compiled from: Ancs.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Ancs.kt */
    /* loaded from: classes3.dex */
    public static final class VibrationPattern extends Enum<VibrationPattern> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VibrationPattern[] $VALUES;
        private final int rawValue;
        public static final VibrationPattern Single = new VibrationPattern("Single", 0, 1);
        public static final VibrationPattern Double = new VibrationPattern("Double", 1, 2);
        public static final VibrationPattern Triple = new VibrationPattern("Triple", 2, 3);

        private static final /* synthetic */ VibrationPattern[] $values() {
            return new VibrationPattern[]{Single, Double, Triple};
        }

        static {
            VibrationPattern[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private VibrationPattern(String str, int r2, int r3) {
            super(str, r2);
            this.rawValue = r3;
        }

        public static EnumEntries<VibrationPattern> getEntries() {
            return $ENTRIES;
        }

        public static VibrationPattern valueOf(String str) {
            return (VibrationPattern) Enum.valueOf(VibrationPattern.class, str);
        }

        public static VibrationPattern[] values() {
            return (VibrationPattern[]) $VALUES.clone();
        }

        public final int getRawValue() {
            return this.rawValue;
        }
    }
}
