package com.google.common.io;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public final class Files {
    public static void copy(File file, File file2) throws IOException {
        if (!file.equals(file2)) {
            file2.getClass();
            int r0 = ImmutableSet.$r8$clinit;
            RegularImmutableSet<Object> regularImmutableSet = RegularImmutableSet.EMPTY;
            Closer closer = new Closer(Closer.SUPPRESSOR);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ArrayDeque arrayDeque = closer.stack;
                arrayDeque.addFirst(fileInputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(file2, regularImmutableSet.contains(FileWriteMode.APPEND));
                arrayDeque.addFirst(fileOutputStream);
                int r5 = ByteStreams.$r8$clinit;
                byte[] bArr = new byte[DfuBaseService.ERROR_REMOTE_MASK];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
            } finally {
            }
        } else {
            throw new IllegalArgumentException(Strings.lenientFormat("Source %s and destination %s must be different", file, file2));
        }
    }

    public static void move(File file, File file2) throws IOException {
        file.getClass();
        file2.getClass();
        if (!file.equals(file2)) {
            if (!file.renameTo(file2)) {
                copy(file, file2);
                if (!file.delete()) {
                    if (!file2.delete()) {
                        throw new IOException("Unable to delete " + file2);
                    }
                    throw new IOException("Unable to delete " + file);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException(Strings.lenientFormat("Source %s and destination %s must be different", file, file2));
    }
}
