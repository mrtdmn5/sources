package com.animaconnected.watch.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: HistoryDeviceId.kt */
@Serializable
/* loaded from: classes3.dex */
public final class HistoryDeviceId {
    public static final Companion Companion = new Companion(null);
    public static final String VERSION = "A";
    private final String id;

    /* compiled from: HistoryDeviceId.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<HistoryDeviceId> serializer() {
            return HistoryDeviceId$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    private /* synthetic */ HistoryDeviceId(String str) {
        this.id = str;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HistoryDeviceId m1556boximpl(String str) {
        return new HistoryDeviceId(str);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static String m1557constructorimpl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return id;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1558equalsimpl(String str, Object obj) {
        if (!(obj instanceof HistoryDeviceId) || !Intrinsics.areEqual(str, ((HistoryDeviceId) obj).m1562unboximpl())) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1559equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1560hashCodeimpl(String str) {
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        return m1558equalsimpl(this.id, obj);
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return m1560hashCodeimpl(this.id);
    }

    public String toString() {
        return m1561toStringimpl(this.id);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m1562unboximpl() {
        return this.id;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1561toStringimpl(String str) {
        return str;
    }
}
