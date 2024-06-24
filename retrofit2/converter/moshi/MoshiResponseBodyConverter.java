package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonUtf8Reader;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

/* loaded from: classes4.dex */
public final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    public static final ByteString UTF8_BOM;
    public final JsonAdapter<T> adapter;

    static {
        ByteString byteString = ByteString.EMPTY;
        UTF8_BOM = ByteString.Companion.decodeHex("EFBBBF");
    }

    public MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.adapter = jsonAdapter;
    }

    @Override // retrofit2.Converter
    public final Object convert(ResponseBody responseBody) throws IOException {
        ResponseBody responseBody2 = responseBody;
        BufferedSource source = responseBody2.source();
        try {
            if (source.rangeEquals(UTF8_BOM)) {
                source.skip(r1.data.length);
            }
            JsonUtf8Reader jsonUtf8Reader = new JsonUtf8Reader(source);
            T fromJson = this.adapter.fromJson(jsonUtf8Reader);
            if (jsonUtf8Reader.peek() == JsonReader.Token.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            responseBody2.close();
        }
    }
}
