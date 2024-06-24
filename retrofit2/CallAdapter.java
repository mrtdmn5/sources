package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public interface CallAdapter<R, T> {

    /* loaded from: classes4.dex */
    public static abstract class Factory {
        public abstract CallAdapter get(Type type, Annotation[] annotationArr);
    }

    Object adapt(OkHttpCall okHttpCall);

    Type responseType();
}
