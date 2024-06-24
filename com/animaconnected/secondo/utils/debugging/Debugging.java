package com.animaconnected.secondo.utils.debugging;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Debugging.kt */
/* loaded from: classes3.dex */
public final class Debugging {
    public static final int $stable = 0;
    public static final Debugging INSTANCE = new Debugging();
    public static final String debuggingFolder = "debugging";

    private Debugging() {
    }

    public final File createZip(Context context, String zipName, File... files) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zipName, "zipName");
        Intrinsics.checkNotNullParameter(files, "files");
        File file = getFile(context, zipName);
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                    try {
                        Iterator it = ArraysKt___ArraysKt.filterNotNull(files).iterator();
                        while (it.hasNext()) {
                            File file2 = (File) it.next();
                            zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                            zipOutputStream.write(ByteStreamsKt.readBytes(new FileInputStream(file2)));
                            zipOutputStream.closeEntry();
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipOutputStream, null);
                        CloseableKt.closeFinally(bufferedOutputStream, null);
                        return file;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final List<File> getAppLogfiles(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir(), debuggingFolder);
        boolean exists = file.exists();
        List<File> list = EmptyList.INSTANCE;
        if (!exists) {
            return list;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            list = new ArrayList<>();
            for (File file2 : listFiles) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt__StringsKt.contains(name, "appLog", false)) {
                    list.add(file2);
                }
            }
        }
        return list;
    }

    public final File getDatabaseFile(Context context, String databaseName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        File databasePath = context.getDatabasePath(databaseName);
        Intrinsics.checkNotNullExpressionValue(databasePath, "getDatabasePath(...)");
        return databasePath;
    }

    public final File getFile(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File file = new File(context.getFilesDir(), debuggingFolder);
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, fileName);
    }

    public final File saveFile(Context context, String fileName, String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        File file = getFile(context, fileName);
        FilesKt__FileReadWriteKt.writeText$default(file, content);
        return file;
    }
}
