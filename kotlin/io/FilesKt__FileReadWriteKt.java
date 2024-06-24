package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FileReadWrite.kt */
/* loaded from: classes.dex */
public class FilesKt__FileReadWriteKt {
    public static final byte[] readBytes(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                int r1 = (int) length;
                byte[] bArr = new byte[r1];
                int r5 = r1;
                int r6 = 0;
                while (r5 > 0) {
                    int read = fileInputStream.read(bArr, r6, r5);
                    if (read < 0) {
                        break;
                    }
                    r5 -= read;
                    r6 += read;
                }
                if (r5 > 0) {
                    bArr = Arrays.copyOf(bArr, r6);
                    Intrinsics.checkNotNullExpressionValue(bArr, "copyOf(...)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream();
                        exposingBufferByteArrayOutputStream.write(read2);
                        ByteStreamsKt.copyTo$default(fileInputStream, exposingBufferByteArrayOutputStream);
                        int size = exposingBufferByteArrayOutputStream.size() + r1;
                        if (size >= 0) {
                            byte[] buffer = exposingBufferByteArrayOutputStream.getBuffer();
                            bArr = Arrays.copyOf(bArr, size);
                            Intrinsics.checkNotNullExpressionValue(bArr, "copyOf(...)");
                            ArraysKt___ArraysJvmKt.copyInto(r1, buffer, 0, bArr, exposingBufferByteArrayOutputStream.size());
                        } else {
                            throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                        }
                    }
                }
                CloseableKt.closeFinally(fileInputStream, null);
                return bArr;
            }
            throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeBytes(File file, byte[] array) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static void writeText$default(File file, String text) {
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        writeBytes(file, bytes);
    }
}
