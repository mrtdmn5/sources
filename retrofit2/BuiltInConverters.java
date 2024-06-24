package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal._ResponseBodyCommonKt$commonAsResponseBody$1;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: classes4.dex */
public final class BuiltInConverters extends Converter.Factory {
    public boolean checkForKotlinUnit = true;

    /* loaded from: classes4.dex */
    public static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        public static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        @Override // retrofit2.Converter
        public final ResponseBody convert(ResponseBody responseBody) throws IOException {
            ResponseBody responseBody2 = responseBody;
            try {
                Buffer buffer = new Buffer();
                responseBody2.source().readAll(buffer);
                return new _ResponseBodyCommonKt$commonAsResponseBody$1(responseBody2.contentType(), responseBody2.contentLength(), buffer);
            } finally {
                responseBody2.close();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
        public static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        @Override // retrofit2.Converter
        public final RequestBody convert(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    /* loaded from: classes4.dex */
    public static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        public static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        @Override // retrofit2.Converter
        public final ResponseBody convert(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ToStringConverter implements Converter<Object, String> {
        public static final ToStringConverter INSTANCE = new ToStringConverter();

        @Override // retrofit2.Converter
        public final String convert(Object obj) throws IOException {
            return obj.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {
        public static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Unit convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes4.dex */
    public static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
        public static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        @Override // retrofit2.Converter
        public final Void convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public final Converter requestBodyConverter(Type type, Annotation[] annotationArr) {
        if (RequestBody.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public final Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (this.checkForKotlinUnit && type == Unit.class) {
            try {
                return UnitResponseBodyConverter.INSTANCE;
            } catch (NoClassDefFoundError unused) {
                this.checkForKotlinUnit = false;
                return null;
            }
        }
        return null;
    }
}
