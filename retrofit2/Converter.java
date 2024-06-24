package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public interface Converter<F, T> {

    /* loaded from: classes4.dex */
    public static abstract class Factory {
        public Converter requestBodyConverter(Type type, Annotation[] annotationArr) {
            return null;
        }

        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    T convert(F f) throws IOException;
}
