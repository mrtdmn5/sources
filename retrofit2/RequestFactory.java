package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;

/* loaded from: classes4.dex */
public final class RequestFactory {
    public final HttpUrl baseUrl;
    public final MediaType contentType;
    public final boolean hasBody;
    public final Headers headers;
    public final String httpMethod;
    public final boolean isFormEncoded;
    public final boolean isKotlinSuspendFunction;
    public final boolean isMultipart;
    public final Method method;
    public final ParameterHandler<?>[] parameterHandlers;
    public final String relativeUrl;

    /* loaded from: classes4.dex */
    public static final class Builder {
        public MediaType contentType;
        public boolean gotBody;
        public boolean gotField;
        public boolean gotPart;
        public boolean gotPath;
        public boolean gotQuery;
        public boolean gotQueryMap;
        public boolean gotQueryName;
        public boolean gotUrl;
        public boolean hasBody;
        public Headers headers;
        public String httpMethod;
        public boolean isFormEncoded;
        public boolean isKotlinSuspendFunction;
        public boolean isMultipart;
        public final Method method;
        public final Annotation[] methodAnnotations;
        public final Annotation[][] parameterAnnotationsArray;
        public ParameterHandler<?>[] parameterHandlers;
        public final Type[] parameterTypes;
        public String relativeUrl;
        public LinkedHashSet relativeUrlParamNames;
        public final Retrofit retrofit;
        public static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        public static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        public Builder(Retrofit retrofit, Method method) {
            this.retrofit = retrofit;
            this.method = method;
            this.methodAnnotations = method.getAnnotations();
            this.parameterTypes = method.getGenericParameterTypes();
            this.parameterAnnotationsArray = method.getParameterAnnotations();
        }

        public static Class<?> boxIfPrimitive(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            return cls;
        }

        public final void parseHttpMethodAndPath(String str, String str2, boolean z) {
            String str3 = this.httpMethod;
            Method method = this.method;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                Pattern pattern = PARAM_URL_REGEX;
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (pattern.matcher(substring).find()) {
                        throw Utils.methodError(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.relativeUrl = str2;
                Matcher matcher = pattern.matcher(str2);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                while (matcher.find()) {
                    linkedHashSet.add(matcher.group(1));
                }
                this.relativeUrlParamNames = linkedHashSet;
                return;
            }
            throw Utils.methodError(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        public final void validateResolvableType(int r3, Type type) {
            if (!Utils.hasUnresolvableType(type)) {
                return;
            }
            throw Utils.parameterError(this.method, r3, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }

    public RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }
}
