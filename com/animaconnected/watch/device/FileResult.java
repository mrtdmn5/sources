package com.animaconnected.watch.device;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchEventListener.kt */
/* loaded from: classes3.dex */
public final class FileResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FileResult[] $VALUES;
    public static final Companion Companion;
    private final String message;
    private final int status;
    public static final FileResult OK = new FileResult("OK", 0, 0, "Success");
    public static final FileResult ErrorNoSpace = new FileResult("ErrorNoSpace", 1, 1, "No space left on device");
    public static final FileResult ErrorNoEntry = new FileResult("ErrorNoEntry", 2, 2, "No directory entry");
    public static final FileResult ErrorNameTooLong = new FileResult("ErrorNameTooLong", 3, 3, "File name too long");
    public static final FileResult ErrorInvalidParameter = new FileResult("ErrorInvalidParameter", 4, 4, "Invalid parameter");
    public static final FileResult ErrorFileNumber = new FileResult("ErrorFileNumber", 5, 5, "Bad file number");
    public static final FileResult ErrorNotEmpty = new FileResult("ErrorNotEmpty", 6, 6, "Not empty");
    public static final FileResult ErrorFileSize = new FileResult("ErrorFileSize", 7, 7, "File too large");
    public static final FileResult ErrorIsDir = new FileResult("ErrorIsDir", 8, 8, "Entry is a dir");
    public static final FileResult ErrorNotADir = new FileResult("ErrorNotADir", 9, 9, "Entry is not a dir");
    public static final FileResult ErrorExists = new FileResult("ErrorExists", 10, 10, "Entry already exists");
    public static final FileResult ErrorCorrupt = new FileResult("ErrorCorrupt", 11, 11, "Corrupted");
    public static final FileResult ErrorIo = new FileResult("ErrorIo", 12, 12, "Error during device operation");
    public static final FileResult ErrorNoMemory = new FileResult("ErrorNoMemory", 13, 13, "No more memory available");
    public static final FileResult ErrorAccessDenied = new FileResult("ErrorAccessDenied", 14, 14, "Access denied");
    public static final FileResult Changed = new FileResult("Changed", 15, 207, "File changed");
    public static final FileResult OtherBadHash = new FileResult("OtherBadHash", 16, 65536, "Completed, hash error");
    public static final FileResult OtherTimeout = new FileResult("OtherTimeout", 17, 65537, "Timeout");
    public static final FileResult OtherException = new FileResult("OtherException", 18, 65538, "Other Exception");
    public static final FileResult OkAlreadyExists = new FileResult("OkAlreadyExists", 19, 65539, "Success, already exists");
    public static final FileResult Unknown = new FileResult("Unknown", 20, 69632, "Unknown result");

    /* compiled from: WatchEventListener.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FileResult fromStatus(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = FileResult.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((FileResult) obj).getStatus() == r4) {
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
            FileResult fileResult = (FileResult) obj;
            if (fileResult == null) {
                return FileResult.Unknown;
            }
            return fileResult;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FileResult[] $values() {
        return new FileResult[]{OK, ErrorNoSpace, ErrorNoEntry, ErrorNameTooLong, ErrorInvalidParameter, ErrorFileNumber, ErrorNotEmpty, ErrorFileSize, ErrorIsDir, ErrorNotADir, ErrorExists, ErrorCorrupt, ErrorIo, ErrorNoMemory, ErrorAccessDenied, Changed, OtherBadHash, OtherTimeout, OtherException, OkAlreadyExists, Unknown};
    }

    static {
        FileResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FileResult(String str, int r2, int r3, String str2) {
        this.status = r3;
        this.message = str2;
    }

    public static EnumEntries<FileResult> getEntries() {
        return $ENTRIES;
    }

    public static FileResult valueOf(String str) {
        return (FileResult) Enum.valueOf(FileResult.class, str);
    }

    public static FileResult[] values() {
        return (FileResult[]) $VALUES.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder("FileResult(status=");
        sb.append(this.status);
        sb.append(", message='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.message, "')");
    }
}
