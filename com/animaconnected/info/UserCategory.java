package com.animaconnected.info;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UserCategory.kt */
/* loaded from: classes.dex */
public final class UserCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserCategory[] $VALUES;
    public static final Companion Companion;
    private final String identifier;
    public static final UserCategory Beta = new UserCategory("Beta", 0, "beta");
    public static final UserCategory Internal = new UserCategory("Internal", 1, "internal");
    public static final UserCategory Influenser = new UserCategory("Influenser", 2, "influencer");
    public static final UserCategory Live = new UserCategory("Live", 3, "live");
    public static final UserCategory Marketing = new UserCategory("Marketing", 4, "marketing");
    public static final UserCategory Develop = new UserCategory("Develop", 5, "develop");
    public static final UserCategory Pretest = new UserCategory("Pretest", 6, "pretest");
    public static final UserCategory Test = new UserCategory("Test", 7, "test");
    public static final UserCategory Sales = new UserCategory("Sales", 8, "sales");
    public static final UserCategory SystemTest = new UserCategory("SystemTest", 9, "systemtest");
    public static final UserCategory EarlyRelease = new UserCategory("EarlyRelease", 10, "earlyrelease");
    public static final UserCategory Dogfooding = new UserCategory("Dogfooding", 11, "dogfooding");
    public static final UserCategory DogfoodingLegacy = new UserCategory("DogfoodingLegacy", 12, "dogfooding_legacy");

    /* compiled from: UserCategory.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserCategory fromIdentifier(String str) {
            Object obj;
            Iterator<E> it = UserCategory.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((UserCategory) obj).getIdentifier(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (UserCategory) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ UserCategory[] $values() {
        return new UserCategory[]{Beta, Internal, Influenser, Live, Marketing, Develop, Pretest, Test, Sales, SystemTest, EarlyRelease, Dogfooding, DogfoodingLegacy};
    }

    static {
        UserCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private UserCategory(String str, int r2, String str2) {
        this.identifier = str2;
    }

    public static EnumEntries<UserCategory> getEntries() {
        return $ENTRIES;
    }

    public static UserCategory valueOf(String str) {
        return (UserCategory) Enum.valueOf(UserCategory.class, str);
    }

    public static UserCategory[] values() {
        return (UserCategory[]) $VALUES.clone();
    }

    public final String getIdentifier() {
        return this.identifier;
    }
}
