package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* loaded from: classes4.dex */
public final class MoshiConverterFactory extends Converter.Factory {
    public final Moshi moshi;
    public final boolean lenient = false;
    public final boolean failOnUnknown = false;
    public final boolean serializeNulls = false;

    public MoshiConverterFactory(Moshi moshi) {
        this.moshi = moshi;
    }

    public static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    @Override // retrofit2.Converter.Factory
    public final Converter requestBodyConverter(Type type, Annotation[] annotationArr) {
        JsonAdapter adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr), null);
        if (this.lenient) {
            adapter = new JsonAdapter.AnonymousClass4();
        }
        if (this.failOnUnknown) {
            adapter = new JsonAdapter.AnonymousClass5();
        }
        if (this.serializeNulls) {
            adapter = new JsonAdapter.AnonymousClass1();
        }
        return new MoshiRequestBodyConverter(adapter);
    }

    @Override // retrofit2.Converter.Factory
    public final Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        JsonAdapter adapter = this.moshi.adapter(type, jsonAnnotations(annotationArr), null);
        if (this.lenient) {
            adapter = new JsonAdapter.AnonymousClass4();
        }
        if (this.failOnUnknown) {
            adapter = new JsonAdapter.AnonymousClass5();
        }
        if (this.serializeNulls) {
            adapter = new JsonAdapter.AnonymousClass1();
        }
        return new MoshiResponseBodyConverter(adapter);
    }
}
