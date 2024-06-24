package kotlin.io;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: ReadWrite.kt */
/* loaded from: classes.dex */
public final class TextStreamsKt {
    public static final long copyTo(Reader reader, Writer writer, int r7) {
        char[] cArr = new char[r7];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static final String readText(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        copyTo(reader, stringWriter, DfuBaseService.ERROR_REMOTE_MASK);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
