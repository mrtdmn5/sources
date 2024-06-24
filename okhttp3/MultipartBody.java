package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.internal._MediaTypeCommonKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: MultipartBody.kt */
/* loaded from: classes4.dex */
public final class MultipartBody extends RequestBody {
    public static final byte[] COLONSPACE;
    public static final byte[] CRLF;
    public static final byte[] DASHDASH;
    public static final MediaType FORM;
    public static final MediaType MIXED = _MediaTypeCommonKt.commonToMediaType("multipart/mixed");
    public final ByteString boundaryByteString;
    public long contentLength;
    public final MediaType contentType;
    public final List<Part> parts;

    /* compiled from: MultipartBody.kt */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final ByteString boundary;
        public final ArrayList parts;
        public MediaType type;

        public Builder() {
            String str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            ByteString byteString = ByteString.EMPTY;
            this.boundary = ByteString.Companion.encodeUtf8(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }
    }

    /* compiled from: MultipartBody.kt */
    /* loaded from: classes4.dex */
    public static final class Part {
        public final RequestBody body;
        public final Headers headers;

        public Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }
    }

    static {
        _MediaTypeCommonKt.commonToMediaType("multipart/alternative");
        _MediaTypeCommonKt.commonToMediaType("multipart/digest");
        _MediaTypeCommonKt.commonToMediaType("multipart/parallel");
        FORM = _MediaTypeCommonKt.commonToMediaType("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b = (byte) 45;
        DASHDASH = new byte[]{b, b};
    }

    public MultipartBody(ByteString boundaryByteString, MediaType type, List<Part> list) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        this.boundaryByteString = boundaryByteString;
        this.parts = list;
        String str = type + "; boundary=" + boundaryByteString.utf8();
        Intrinsics.checkNotNullParameter(str, "<this>");
        this.contentType = _MediaTypeCommonKt.commonToMediaType(str);
        this.contentLength = -1L;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() throws IOException {
        long j = this.contentLength;
        if (j == -1) {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return j;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.contentType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long writeOrCountBytes(BufferedSink bufferedSink, boolean z) throws IOException {
        Buffer buffer;
        BufferedSink bufferedSink2;
        if (z) {
            bufferedSink2 = new Buffer();
            buffer = bufferedSink2;
        } else {
            buffer = 0;
            bufferedSink2 = bufferedSink;
        }
        List<Part> list = this.parts;
        int size = list.size();
        long j = 0;
        int r8 = 0;
        while (true) {
            ByteString byteString = this.boundaryByteString;
            byte[] bArr = DASHDASH;
            byte[] bArr2 = CRLF;
            if (r8 < size) {
                Part part = list.get(r8);
                Headers headers = part.headers;
                Intrinsics.checkNotNull(bufferedSink2);
                bufferedSink2.write(bArr);
                bufferedSink2.write(byteString);
                bufferedSink2.write(bArr2);
                if (headers != null) {
                    int length = headers.namesAndValues.length / 2;
                    for (int r10 = 0; r10 < length; r10++) {
                        bufferedSink2.writeUtf8(headers.name(r10)).write(COLONSPACE).writeUtf8(headers.value(r10)).write(bArr2);
                    }
                }
                RequestBody requestBody = part.body;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    BufferedSink writeUtf8 = bufferedSink2.writeUtf8("Content-Type: ");
                    Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
                    writeUtf8.writeUtf8(contentType.mediaType).write(bArr2);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength == -1 && z) {
                    Intrinsics.checkNotNull(buffer);
                    buffer.clear();
                    return -1L;
                }
                bufferedSink2.write(bArr2);
                if (z) {
                    j += contentLength;
                } else {
                    requestBody.writeTo(bufferedSink2);
                }
                bufferedSink2.write(bArr2);
                r8++;
            } else {
                Intrinsics.checkNotNull(bufferedSink2);
                bufferedSink2.write(bArr);
                bufferedSink2.write(byteString);
                bufferedSink2.write(bArr);
                bufferedSink2.write(bArr2);
                if (z) {
                    Intrinsics.checkNotNull(buffer);
                    long j2 = j + buffer.size;
                    buffer.clear();
                    return j2;
                }
                return j;
            }
        }
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
