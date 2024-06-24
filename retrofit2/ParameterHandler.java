package retrofit2;

import com.amplifyframework.core.model.ModelIdentifier;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal._RequestCommonKt;
import retrofit2.BuiltInConverters;

/* loaded from: classes4.dex */
public abstract class ParameterHandler<T> {

    /* loaded from: classes4.dex */
    public static final class Body<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final Method method;
        public final int p;

        public Body(Method method, int r2, Converter<T, RequestBody> converter) {
            this.method = method;
            this.p = r2;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) {
            int r1 = this.p;
            Method method = this.method;
            if (t != null) {
                try {
                    requestBuilder.body = this.converter.convert(t);
                    return;
                } catch (IOException e) {
                    throw Utils.parameterError(method, e, r1, "Unable to convert " + t + " to RequestBody", new Object[0]);
                }
            }
            throw Utils.parameterError(method, r1, "Body parameter value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Field<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Field(String str, boolean z) {
            BuiltInConverters.ToStringConverter toStringConverter = BuiltInConverters.ToStringConverter.INSTANCE;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = toStringConverter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes4.dex */
    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;

        public FieldMap(Method method, int r2, boolean z) {
            this.method = method;
            this.p = r2;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            int r1 = this.p;
            Method method = this.method;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String obj2 = value.toString();
                            if (obj2 != null) {
                                requestBuilder.addFormField(str, obj2, this.encoded);
                            } else {
                                throw Utils.parameterError(method, r1, "Field map value '" + value + "' converted to null by " + BuiltInConverters.ToStringConverter.class.getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(method, r1, zzav$$ExternalSyntheticOutline0.m("Field map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(method, r1, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(method, r1, "Field map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Header<T> extends ParameterHandler<T> {
        public final String name;
        public final Converter<T, String> valueConverter;

        public Header(String str) {
            BuiltInConverters.ToStringConverter toStringConverter = BuiltInConverters.ToStringConverter.INSTANCE;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = toStringConverter;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, convert);
        }
    }

    /* loaded from: classes4.dex */
    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;
        public final int p;

        public HeaderMap(Method method, int r2) {
            this.method = method;
            this.p = r2;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            int r1 = this.p;
            Method method = this.method;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(str, value.toString());
                        } else {
                            throw Utils.parameterError(method, r1, zzav$$ExternalSyntheticOutline0.m("Header map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(method, r1, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(method, r1, "Header map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Headers extends ParameterHandler<okhttp3.Headers> {
        public final Method method;
        public final int p;

        public Headers(int r1, Method method) {
            this.method = method;
            this.p = r1;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) throws IOException {
            okhttp3.Headers headers2 = headers;
            if (headers2 != null) {
                Headers.Builder builder = requestBuilder.headersBuilder;
                builder.getClass();
                int length = headers2.namesAndValues.length / 2;
                for (int r0 = 0; r0 < length; r0++) {
                    _HeadersCommonKt.commonAddLenient(builder, headers2.name(r0), headers2.value(r0));
                }
                return;
            }
            int r6 = this.p;
            throw Utils.parameterError(this.method, r6, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Part<T> extends ParameterHandler<T> {
        public final Converter<T, RequestBody> converter;
        public final okhttp3.Headers headers;
        public final Method method;
        public final int p;

        public Part(Method method, int r2, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.p = r2;
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.p, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        public final Method method;
        public final int p;
        public final String transferEncoding;
        public final Converter<T, RequestBody> valueConverter;

        public PartMap(Method method, int r2, Converter<T, RequestBody> converter, String str) {
            this.method = method;
            this.p = r2;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            int r1 = this.p;
            Method method = this.method;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addPart(Headers.Companion.of("Content-Disposition", zzav$$ExternalSyntheticOutline0.m("form-data; name=\"", str, ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR), "Content-Transfer-Encoding", this.transferEncoding), (RequestBody) this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(method, r1, zzav$$ExternalSyntheticOutline0.m("Part map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(method, r1, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(method, r1, "Part map was null.", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Path<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final Method method;
        public final String name;
        public final int p;
        public final Converter<T, String> valueConverter;

        public Path(Method method, int r3, String str, boolean z) {
            BuiltInConverters.ToStringConverter toStringConverter = BuiltInConverters.ToStringConverter.INSTANCE;
            this.method = method;
            this.p = r3;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = toStringConverter;
            this.encoded = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00e5  */
        @Override // retrofit2.ParameterHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void apply(retrofit2.RequestBuilder r18, T r19) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 266
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ParameterHandler.Path.apply(retrofit2.RequestBuilder, java.lang.Object):void");
        }
    }

    /* loaded from: classes4.dex */
    public static final class Query<T> extends ParameterHandler<T> {
        public final boolean encoded;
        public final String name;
        public final Converter<T, String> valueConverter;

        public Query(String str, boolean z) {
            BuiltInConverters.ToStringConverter toStringConverter = BuiltInConverters.ToStringConverter.INSTANCE;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = toStringConverter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes4.dex */
    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        public final boolean encoded;
        public final Method method;
        public final int p;

        public QueryMap(Method method, int r2, boolean z) {
            this.method = method;
            this.p = r2;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            int r1 = this.p;
            Method method = this.method;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str != null) {
                        Object value = entry.getValue();
                        if (value != null) {
                            String obj2 = value.toString();
                            if (obj2 != null) {
                                requestBuilder.addQueryParam(str, obj2, this.encoded);
                            } else {
                                throw Utils.parameterError(method, r1, "Query map value '" + value + "' converted to null by " + BuiltInConverters.ToStringConverter.class.getName() + " for key '" + str + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(method, r1, zzav$$ExternalSyntheticOutline0.m("Query map contained null value for key '", str, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(method, r1, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(method, r1, "Query map was null", new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public static final class QueryName<T> extends ParameterHandler<T> {
        public final boolean encoded;

        public QueryName(boolean z) {
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.addQueryParam(t.toString(), null, this.encoded);
        }
    }

    /* loaded from: classes4.dex */
    public static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        public static final RawPart INSTANCE = new RawPart();

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                MultipartBody.Builder builder = requestBuilder.multipartBuilder;
                builder.getClass();
                builder.parts.add(part2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class RelativeUrl extends ParameterHandler<Object> {
        public final Method method;
        public final int p;

        public RelativeUrl(int r1, Method method) {
            this.method = method;
            this.p = r1;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj != null) {
                requestBuilder.relativeUrl = obj.toString();
            } else {
                int r4 = this.p;
                throw Utils.parameterError(this.method, r4, "@Url parameter is null.", new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Tag<T> extends ParameterHandler<T> {
        public final Class<T> cls;

        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        public final void apply(RequestBuilder requestBuilder, T t) {
            Request.Builder builder = requestBuilder.requestBuilder;
            builder.getClass();
            Class<T> type = this.cls;
            Intrinsics.checkNotNullParameter(type, "type");
            _RequestCommonKt.commonTag(builder, Reflection.getOrCreateKotlinClass(type), t);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, T t) throws IOException;
}
