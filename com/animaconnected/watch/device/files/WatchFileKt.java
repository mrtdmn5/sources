package com.animaconnected.watch.device.files;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.animaconnected.watch.device.FileResult;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: WatchFile.kt */
/* loaded from: classes3.dex */
public final class WatchFileKt {
    public static final int dekHash(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int length2 = str.length();
        for (int r2 = 0; r2 < length2; r2++) {
            length = ((length >>> 27) ^ (length << 5)) ^ str.charAt(r2);
        }
        return length;
    }

    /* renamed from: dekHash-GBYM_sE, reason: not valid java name */
    public static final int m1108dekHashGBYM_sE(byte[] dekHash) {
        Intrinsics.checkNotNullParameter(dekHash, "$this$dekHash");
        for (byte b : dekHash) {
            r0 = ((r0 >>> 27) ^ (r0 << 5)) ^ (b & 255);
        }
        return r0;
    }

    public static final String extension(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List split$default = StringsKt__StringsKt.split$default(name, new String[]{InstructionFileId.DOT}, 0, 6);
        if (split$default.size() < 2) {
            return null;
        }
        return (String) CollectionsKt___CollectionsKt.last(split$default);
    }

    public static final String fullPath(String path, String name) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        String trim = StringsKt__StringsKt.trim(path, '/');
        String trim2 = StringsKt__StringsKt.trim(name, '/');
        if (StringsKt__StringsJVMKt.isBlank(trim) && StringsKt__StringsJVMKt.isBlank(trim2)) {
            return "/";
        }
        if (StringsKt__StringsJVMKt.isBlank(trim) && (!StringsKt__StringsJVMKt.isBlank(trim2))) {
            return "/" + StringsKt__StringsKt.trim(trim2, '/');
        }
        if ((!StringsKt__StringsJVMKt.isBlank(trim)) && StringsKt__StringsJVMKt.isBlank(trim2)) {
            return "/" + StringsKt__StringsKt.trim(trim, '/');
        }
        return "/" + StringsKt__StringsKt.trim(trim, '/') + '/' + StringsKt__StringsKt.trim(trim2, '/');
    }

    public static final boolean getDeleteSuccess(FileDescriptor fileDescriptor) {
        Intrinsics.checkNotNullParameter(fileDescriptor, "<this>");
        if (fileDescriptor.getStatus() != FileResult.OtherBadHash && fileDescriptor.getStatus() != FileResult.OK && fileDescriptor.getStatus() != FileResult.ErrorNoEntry) {
            return false;
        }
        return true;
    }

    public static final String getRootDirectory(FileDescriptor fileDescriptor) {
        Intrinsics.checkNotNullParameter(fileDescriptor, "<this>");
        return rootDir(fileDescriptor.getDirectory());
    }

    public static final boolean getSuccess(FileDescriptor fileDescriptor) {
        Intrinsics.checkNotNullParameter(fileDescriptor, "<this>");
        if (fileDescriptor.getStatus() != FileResult.OkAlreadyExists && fileDescriptor.getStatus() != FileResult.OK) {
            return false;
        }
        return true;
    }

    public static final String rootDir(String directory) {
        Object obj;
        Intrinsics.checkNotNullParameter(directory, "directory");
        if (!StringsKt__StringsKt.startsWith$default((CharSequence) directory, '/')) {
            directory = "/".concat(directory);
        }
        StringBuilder sb = new StringBuilder("/");
        List split$default = StringsKt__StringsKt.split$default(0, 6, directory, new char[]{'/'});
        if (1 <= CollectionsKt__CollectionsKt.getLastIndex(split$default)) {
            obj = split$default.get(1);
        } else {
            obj = "";
        }
        sb.append((String) obj);
        return sb.toString();
    }
}
