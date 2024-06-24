package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonUtf8Writer;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal._MediaTypeCommonKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import retrofit2.Converter;

/* loaded from: classes4.dex */
public final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final MediaType MEDIA_TYPE = _MediaTypeCommonKt.commonToMediaType("application/json; charset=UTF-8");
    public final JsonAdapter<T> adapter;

    public MoshiRequestBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    @Override // retrofit2.Converter
    public final RequestBody convert(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        this.adapter.toJson(new JsonUtf8Writer(buffer), obj);
        final ByteString content = buffer.readByteString();
        Intrinsics.checkNotNullParameter(content, "content");
        final MediaType mediaType = MEDIA_TYPE;
        return new RequestBody() { // from class: okhttp3.internal._RequestBodyCommonKt$commonToRequestBody$2
            @Override // okhttp3.RequestBody
            public final long contentLength() {
                return content.getSize$okio();
            }

            @Override // okhttp3.RequestBody
            public final MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public final void writeTo(BufferedSink bufferedSink) {
                bufferedSink.write(content);
            }
        };
    }
}
