package com.animaconnected.watch.account.strava;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Upload.kt */
/* loaded from: classes3.dex */
public final class UploadStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UploadStatus[] $VALUES;
    public static final Companion Companion;
    private final String status;
    public static final UploadStatus READY = new UploadStatus("READY", 0, "Your activity is ready.");
    public static final UploadStatus ERROR = new UploadStatus("ERROR", 1, "There was an error processing your activity.");
    public static final UploadStatus DELETED = new UploadStatus("DELETED", 2, "The created activity has been deleted.");
    public static final UploadStatus PROCESSING = new UploadStatus("PROCESSING", 3, "Your activity is still being processed.");
    public static final UploadStatus UNKNOWN = new UploadStatus("UNKNOWN", 4, "Unknown status");

    /* compiled from: Upload.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UploadStatus fromString(String str) {
            Object obj;
            Iterator<E> it = UploadStatus.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((UploadStatus) obj).getStatus(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            UploadStatus uploadStatus = (UploadStatus) obj;
            if (uploadStatus == null) {
                return UploadStatus.UNKNOWN;
            }
            return uploadStatus;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ UploadStatus[] $values() {
        return new UploadStatus[]{READY, ERROR, DELETED, PROCESSING, UNKNOWN};
    }

    static {
        UploadStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private UploadStatus(String str, int r2, String str2) {
        this.status = str2;
    }

    public static EnumEntries<UploadStatus> getEntries() {
        return $ENTRIES;
    }

    public static UploadStatus valueOf(String str) {
        return (UploadStatus) Enum.valueOf(UploadStatus.class, str);
    }

    public static UploadStatus[] values() {
        return (UploadStatus[]) $VALUES.clone();
    }

    public final String getStatus() {
        return this.status;
    }
}
