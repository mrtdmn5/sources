package com.animaconnected.watch.filter;

import com.animaconnected.watch.filter.FilterSettings;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilterSettingsImpl.kt */
/* loaded from: classes3.dex */
public final class FilterSettingsImplKt {

    /* compiled from: FilterSettingsImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FilterSettings.Allowed.values().length];
            try {
                r0[FilterSettings.Allowed.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FilterSettings.Allowed.All.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FilterSettings.Allowed.Favourites.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FilterSettings.Allowed.Important.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FilterSettings.Allowed.Known.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final String trackingString(FilterSettings.Allowed allowed) {
        Intrinsics.checkNotNullParameter(allowed, "<this>");
        int r1 = WhenMappings.$EnumSwitchMapping$0[allowed.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    if (r1 != 4) {
                        if (r1 == 5) {
                            return "Known";
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return "Important";
                }
                return "Favourites";
            }
            return "All";
        }
        return "None";
    }
}
