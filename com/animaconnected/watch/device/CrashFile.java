package com.animaconnected.watch.device;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import j$.time.format.DateTimeParseException;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalDateTime;

/* compiled from: CrashBackend.kt */
/* loaded from: classes3.dex */
public final class CrashFile {
    public static final Companion Companion = new Companion(null);
    private static final String ending = ".zip";
    private final String fileName;
    private final String isoTimestamp;
    private final LocalDateTime localDate;
    private final String s3UploadUrl;
    private final String serialNumber;

    /* compiled from: CrashBackend.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CrashFile fromFileName(String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            try {
                List split$default = StringsKt__StringsKt.split$default(StringsKt__StringsKt.removeSuffix(CrashFile.ending, fileName), new String[]{"-"}, 2, 2);
                return new CrashFile((String) split$default.get(0), (String) split$default.get(1));
            } catch (Exception e) {
                LogKt.err$default((Object) this, (String) null, (Throwable) e, true, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.CrashFile$Companion$fromFileName$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return String.valueOf(e.getMessage());
                    }
                }, 1, (Object) null);
                return null;
            }
        }

        private Companion() {
        }
    }

    public CrashFile(String serialNumber, String isoTimestamp) {
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(isoTimestamp, "isoTimestamp");
        this.serialNumber = serialNumber;
        this.isoTimestamp = isoTimestamp;
        String str = serialNumber + '-' + isoTimestamp + ending;
        this.fileName = str;
        LocalDateTime.Companion.getClass();
        try {
            LocalDateTime localDateTime = new LocalDateTime(j$.time.LocalDateTime.parse(isoTimestamp));
            this.localDate = localDateTime;
            this.s3UploadUrl = "stable/" + localDateTime.getYear() + '/' + StringsKt__StringsKt.padStart(String.valueOf(localDateTime.value.getMonthValue()), 2, '0') + '/' + StringsKt__StringsKt.padStart(String.valueOf(localDateTime.getDayOfMonth()), 2, '0') + '/' + str;
        } catch (DateTimeParseException e) {
            throw new DateTimeFormatException(e);
        }
    }

    public static /* synthetic */ CrashFile copy$default(CrashFile crashFile, String str, String str2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = crashFile.serialNumber;
        }
        if ((r3 & 2) != 0) {
            str2 = crashFile.isoTimestamp;
        }
        return crashFile.copy(str, str2);
    }

    public final String component1() {
        return this.serialNumber;
    }

    public final String component2() {
        return this.isoTimestamp;
    }

    public final CrashFile copy(String serialNumber, String isoTimestamp) {
        Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
        Intrinsics.checkNotNullParameter(isoTimestamp, "isoTimestamp");
        return new CrashFile(serialNumber, isoTimestamp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrashFile)) {
            return false;
        }
        CrashFile crashFile = (CrashFile) obj;
        if (Intrinsics.areEqual(this.serialNumber, crashFile.serialNumber) && Intrinsics.areEqual(this.isoTimestamp, crashFile.isoTimestamp)) {
            return true;
        }
        return false;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getIsoTimestamp() {
        return this.isoTimestamp;
    }

    public final LocalDateTime getLocalDate() {
        return this.localDate;
    }

    public final String getS3UploadUrl() {
        return this.s3UploadUrl;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public int hashCode() {
        return this.isoTimestamp.hashCode() + (this.serialNumber.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CrashFile(serialNumber=");
        sb.append(this.serialNumber);
        sb.append(", isoTimestamp=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.isoTimestamp, ')');
    }
}
