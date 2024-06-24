package retrofit2;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._MediaTypeCommonKt;
import okhttp3.internal._RequestBodyCommonKt$commonToRequestBody$1;
import okhttp3.internal._RequestCommonKt;
import okhttp3.internal._ResponseBodyCommonKt$commonAsResponseBody$1;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RealCall;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.RealBufferedSource;
import retrofit2.RequestBuilder;

/* loaded from: classes4.dex */
public final class OkHttpCall<T> implements Call<T> {
    public final Object[] args;
    public final Call.Factory callFactory;
    public volatile boolean canceled;
    public Throwable creationFailure;
    public boolean executed;
    public okhttp3.Call rawCall;
    public final RequestFactory requestFactory;
    public final Converter<ResponseBody, T> responseConverter;

    /* loaded from: classes4.dex */
    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        public final ResponseBody delegate;
        public final RealBufferedSource delegateSource;
        public IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer(new ForwardingSource(responseBody.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // okio.Source
                public final long read(Buffer sink, long j) throws IOException {
                    try {
                        Intrinsics.checkNotNullParameter(sink, "sink");
                        return this.delegate.read(sink, 8192L);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.delegate.close();
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.delegateSource;
        }
    }

    /* loaded from: classes4.dex */
    public static final class NoContentResponseBody extends ResponseBody {
        public final long contentLength;
        public final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter<ResponseBody, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    @Override // retrofit2.Call
    public final void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public final Object clone() throws CloneNotSupportedException {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    public final okhttp3.Call createRawCall() throws IOException {
        HttpUrl.Builder builder;
        HttpUrl httpUrl;
        RequestFactory requestFactory = this.requestFactory;
        requestFactory.getClass();
        Object[] objArr = this.args;
        int length = objArr.length;
        ParameterHandler<?>[] parameterHandlerArr = requestFactory.parameterHandlers;
        if (length == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(requestFactory.httpMethod, requestFactory.baseUrl, requestFactory.relativeUrl, requestFactory.headers, requestFactory.contentType, requestFactory.hasBody, requestFactory.isFormEncoded, requestFactory.isMultipart);
            if (requestFactory.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int r7 = 0; r7 < length; r7++) {
                arrayList.add(objArr[r7]);
                parameterHandlerArr[r7].apply(requestBuilder, objArr[r7]);
            }
            HttpUrl.Builder builder2 = requestBuilder.urlBuilder;
            if (builder2 != null) {
                httpUrl = builder2.build();
            } else {
                String link = requestBuilder.relativeUrl;
                HttpUrl httpUrl2 = requestBuilder.baseUrl;
                httpUrl2.getClass();
                Intrinsics.checkNotNullParameter(link, "link");
                try {
                    builder = new HttpUrl.Builder();
                    builder.parse$okhttp(httpUrl2, link);
                } catch (IllegalArgumentException unused) {
                    builder = null;
                }
                if (builder != null) {
                    httpUrl = builder.build();
                } else {
                    httpUrl = null;
                }
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl2 + ", Relative: " + requestBuilder.relativeUrl);
                }
            }
            RequestBody requestBody = requestBuilder.body;
            if (requestBody == null) {
                FormBody.Builder builder3 = requestBuilder.formBuilder;
                if (builder3 != null) {
                    requestBody = new FormBody(builder3.names, builder3.values);
                } else {
                    MultipartBody.Builder builder4 = requestBuilder.multipartBuilder;
                    if (builder4 != null) {
                        ArrayList arrayList2 = builder4.parts;
                        if (!arrayList2.isEmpty()) {
                            requestBody = new MultipartBody(builder4.boundary, builder4.type, _UtilJvmKt.toImmutableList(arrayList2));
                        } else {
                            throw new IllegalStateException("Multipart body must have at least one part.".toString());
                        }
                    } else if (requestBuilder.hasBody) {
                        long j = 0;
                        _UtilCommonKt.checkOffsetAndCount(j, j, j);
                        requestBody = new _RequestBodyCommonKt$commonToRequestBody$1(null, new byte[0], 0, 0);
                    }
                }
            }
            MediaType mediaType = requestBuilder.contentType;
            Headers.Builder builder5 = requestBuilder.headersBuilder;
            if (mediaType != null) {
                if (requestBody != null) {
                    requestBody = new RequestBuilder.ContentTypeOverridingRequestBody(requestBody, mediaType);
                } else {
                    Regex regex = _MediaTypeCommonKt.TYPE_SUBTYPE;
                    builder5.add("Content-Type", mediaType.mediaType);
                }
            }
            Request.Builder builder6 = requestBuilder.requestBuilder;
            builder6.getClass();
            builder6.url = httpUrl;
            builder6.headers = builder5.build().newBuilder();
            builder6.method(requestBuilder.method, requestBody);
            _RequestCommonKt.commonTag(builder6, Reflection.getOrCreateKotlinClass(Invocation.class), new Invocation(requestFactory.method, arrayList));
            RealCall newCall = this.callFactory.newCall(new Request(builder6));
            if (newCall != null) {
                return newCall;
            }
            throw new NullPointerException("Call.Factory returned null.");
        }
        throw new IllegalArgumentException(ConstraintWidget$$ExternalSyntheticOutline0.m(SuggestionsAdapter$$ExternalSyntheticOutline0.m("Argument count (", length, ") doesn't match expected count ("), parameterHandlerArr.length, ")"));
    }

    @Override // retrofit2.Call
    public final void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                call = this.rawCall;
                th = this.creationFailure;
                if (call == null && th == null) {
                    try {
                        okhttp3.Call createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        call = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            @Override // okhttp3.Callback
            public final void onFailure(RealCall realCall, IOException iOException) {
                try {
                    callback.onFailure(OkHttpCall.this, iOException);
                } catch (Throwable th3) {
                    Utils.throwIfFatal(th3);
                    th3.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public final void onResponse(RealCall realCall, okhttp3.Response response) {
                Callback callback2 = callback;
                OkHttpCall okHttpCall = OkHttpCall.this;
                try {
                    try {
                        callback2.onResponse(okHttpCall, okHttpCall.parseResponse(response));
                    } catch (Throwable th3) {
                        Utils.throwIfFatal(th3);
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    try {
                        callback2.onFailure(okHttpCall, th4);
                    } catch (Throwable th5) {
                        Utils.throwIfFatal(th5);
                        th5.printStackTrace();
                    }
                }
            }
        });
    }

    public final okhttp3.Call getRawCall() throws IOException {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (!(th instanceof IOException)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw ((Error) th);
            }
            throw ((IOException) th);
        }
        try {
            okhttp3.Call createRawCall = createRawCall();
            this.rawCall = createRawCall;
            return createRawCall;
        } catch (IOException | Error | RuntimeException e) {
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public final boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            okhttp3.Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    public final Response<T> parseResponse(okhttp3.Response response) throws IOException {
        Response.Builder builder = new Response.Builder(response);
        ResponseBody responseBody = response.body;
        builder.body = new NoContentResponseBody(responseBody.contentType(), responseBody.contentLength());
        okhttp3.Response build = builder.build();
        boolean z = build.isSuccessful;
        int r4 = build.code;
        if (r4 >= 200 && r4 < 300) {
            if (r4 != 204 && r4 != 205) {
                ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(responseBody);
                try {
                    T convert = this.responseConverter.convert(exceptionCatchingResponseBody);
                    if (z) {
                        return new Response<>(build, convert, null);
                    }
                    throw new IllegalArgumentException("rawResponse must be successful response");
                } catch (RuntimeException e) {
                    IOException iOException = exceptionCatchingResponseBody.thrownException;
                    if (iOException == null) {
                        throw e;
                    }
                    throw iOException;
                }
            }
            if (z) {
                return new Response<>(build, null, null);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        try {
            Buffer buffer = new Buffer();
            responseBody.source().readAll(buffer);
            _ResponseBodyCommonKt$commonAsResponseBody$1 _responsebodycommonkt_commonasresponsebody_1 = new _ResponseBodyCommonKt$commonAsResponseBody$1(responseBody.contentType(), responseBody.contentLength(), buffer);
            if (!z) {
                return new Response<>(build, null, _responsebodycommonkt_commonasresponsebody_1);
            }
            throw new IllegalArgumentException("rawResponse should not be successful response");
        } finally {
            responseBody.close();
        }
    }

    @Override // retrofit2.Call
    public final synchronized Request request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public final Call clone() {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
