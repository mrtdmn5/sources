package com.animaconnected.secondo.screens.behaviourconfiguration;

import android.content.Context;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FeatureIssue.kt */
/* loaded from: classes3.dex */
public final class FeatureIssue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureIssue[] $VALUES;
    public static final Companion Companion;
    public static final FeatureIssue GeneralPermissions = new FeatureIssue("GeneralPermissions", 0);
    public static final FeatureIssue GeneralPermission = new FeatureIssue("GeneralPermission", 1);
    public static final FeatureIssue LocationPermission = new FeatureIssue("LocationPermission", 2);
    public static final FeatureIssue BackgroundLocationPermission = new FeatureIssue("BackgroundLocationPermission", 3);
    public static final FeatureIssue LocationDisabled = new FeatureIssue("LocationDisabled", 4);
    public static final FeatureIssue NotificationAccess = new FeatureIssue("NotificationAccess", 5);
    public static final FeatureIssue None = new FeatureIssue("None", 6);

    /* compiled from: FeatureIssue.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeatureIssue calculateIssue(String[] permissions, Context context) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(context, "context");
            List<String> filterMissingPermissions = PermissionProvider.Companion.filterMissingPermissions(permissions, context);
            if (filterMissingPermissions.contains("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                return FeatureIssue.NotificationAccess;
            }
            if (Intrinsics.areEqual(filterMissingPermissions, CollectionsKt__CollectionsKt.arrayListOf("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"))) {
                return FeatureIssue.LocationPermission;
            }
            if (Intrinsics.areEqual(filterMissingPermissions, CollectionsKt__CollectionsKt.arrayListOf("android.permission.ACCESS_BACKGROUND_LOCATION"))) {
                return FeatureIssue.BackgroundLocationPermission;
            }
            if (filterMissingPermissions.size() > 1) {
                return FeatureIssue.GeneralPermissions;
            }
            if (!filterMissingPermissions.isEmpty()) {
                return FeatureIssue.GeneralPermission;
            }
            if ((ArraysKt___ArraysKt.contains(permissions, "android.permission.ACCESS_FINE_LOCATION") || ArraysKt___ArraysKt.contains(permissions, "android.permission.ACCESS_COARSE_LOCATION") || ArraysKt___ArraysKt.contains(permissions, "android.permission.ACCESS_BACKGROUND_LOCATION")) && !AndroidLocationBackend.isLocationEnabled()) {
                return FeatureIssue.LocationDisabled;
            }
            return FeatureIssue.None;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FeatureIssue[] $values() {
        return new FeatureIssue[]{GeneralPermissions, GeneralPermission, LocationPermission, BackgroundLocationPermission, LocationDisabled, NotificationAccess, None};
    }

    static {
        FeatureIssue[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FeatureIssue(String str, int r2) {
    }

    public static final FeatureIssue calculateIssue(String[] strArr, Context context) {
        return Companion.calculateIssue(strArr, context);
    }

    public static EnumEntries<FeatureIssue> getEntries() {
        return $ENTRIES;
    }

    public static FeatureIssue valueOf(String str) {
        return (FeatureIssue) Enum.valueOf(FeatureIssue.class, str);
    }

    public static FeatureIssue[] values() {
        return (FeatureIssue[]) $VALUES.clone();
    }
}
