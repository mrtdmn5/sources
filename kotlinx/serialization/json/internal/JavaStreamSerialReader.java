package kotlinx.serialization.json.internal;

import io.ktor.utils.io.jvm.javaio.InputAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: JvmJsonStreams.kt */
/* loaded from: classes4.dex */
public final class JavaStreamSerialReader implements SerialReader {
    public final CharsetReader reader;

    public JavaStreamSerialReader(InputAdapter inputAdapter) {
        this.reader = new CharsetReader(inputAdapter, Charsets.UTF_8);
    }

    @Override // kotlinx.serialization.json.internal.SerialReader
    public final int read(char[] buffer, int r3, int r4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return this.reader.read(buffer, r3, r4);
    }
}
