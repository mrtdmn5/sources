package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._MediaTypeCommonKt;
import okhttp3.internal._UtilJvmKt;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: FormBody.kt */
/* loaded from: classes4.dex */
public final class FormBody extends RequestBody {
    public static final MediaType CONTENT_TYPE = _MediaTypeCommonKt.commonToMediaType("application/x-www-form-urlencoded");
    public final List<String> encodedNames;
    public final List<String> encodedValues;

    /* compiled from: FormBody.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final Charset charset = null;
        public final ArrayList names = new ArrayList();
        public final ArrayList values = new ArrayList();
    }

    public FormBody(ArrayList encodedNames, ArrayList encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.encodedNames = _UtilJvmKt.toImmutableList(encodedNames);
        this.encodedValues = _UtilJvmKt.toImmutableList(encodedValues);
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            Intrinsics.checkNotNull(bufferedSink);
            buffer = bufferedSink.getBuffer();
        }
        List<String> list = this.encodedNames;
        int size = list.size();
        for (int r2 = 0; r2 < size; r2++) {
            if (r2 > 0) {
                buffer.m1734writeByte(38);
            }
            buffer.m1738writeUtf8(list.get(r2));
            buffer.m1734writeByte(61);
            buffer.m1738writeUtf8(this.encodedValues.get(r2));
        }
        if (z) {
            long j = buffer.size;
            buffer.clear();
            return j;
        }
        return 0L;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
