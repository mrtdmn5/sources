package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Converter;

@IgnoreJRERequirement
/* loaded from: classes4.dex */
public final class OptionalConverterFactory extends Converter.Factory {
    public static final OptionalConverterFactory INSTANCE = new OptionalConverterFactory();

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {
        public final Converter<ResponseBody, T> delegate;

        public OptionalConverter(Converter<ResponseBody, T> converter) {
            this.delegate = converter;
        }

        @Override // retrofit2.Converter
        public final Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.delegate.convert(responseBody));
        }
    }

    @Override // retrofit2.Converter.Factory
    public final Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Utils.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Utils.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
