package retrofit2;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal._MediaTypeCommonKt;
import okio.BufferedSink;

/* loaded from: classes4.dex */
public final class RequestBuilder {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    public final HttpUrl baseUrl;
    public RequestBody body;
    public MediaType contentType;
    public final FormBody.Builder formBuilder;
    public final boolean hasBody;
    public final Headers.Builder headersBuilder;
    public final String method;
    public final MultipartBody.Builder multipartBuilder;
    public String relativeUrl;
    public final Request.Builder requestBuilder = new Request.Builder();
    public HttpUrl.Builder urlBuilder;

    /* loaded from: classes4.dex */
    public static class ContentTypeOverridingRequestBody extends RequestBody {
        public final MediaType contentType;
        public final RequestBody delegate;

        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        @Override // okhttp3.RequestBody
        public final long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        if (z2) {
            this.formBuilder = new FormBody.Builder();
            return;
        }
        if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            MediaType type = MultipartBody.FORM;
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.areEqual(type.type, "multipart")) {
                builder.type = type;
            } else {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
        }
    }

    public final void addFormField(String name, String str, boolean z) {
        FormBody.Builder builder = this.formBuilder;
        if (z) {
            builder.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            builder.names.add(HttpUrl.Companion.canonicalize$okhttp$default(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, builder.charset, 83));
            builder.values.add(HttpUrl.Companion.canonicalize$okhttp$default(str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, builder.charset, 83));
            return;
        }
        builder.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        builder.names.add(HttpUrl.Companion.canonicalize$okhttp$default(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, builder.charset, 91));
        builder.values.add(HttpUrl.Companion.canonicalize$okhttp$default(str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, builder.charset, 91));
    }

    public final void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                Intrinsics.checkNotNullParameter(str2, "<this>");
                this.contentType = _MediaTypeCommonKt.commonToMediaType(str2);
                return;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("Malformed content type: ", str2), e);
            }
        }
        this.headersBuilder.add(str, str2);
    }

    public final void addPart(Headers headers, RequestBody body) {
        String str;
        boolean z;
        MultipartBody.Builder builder = this.multipartBuilder;
        builder.getClass();
        Intrinsics.checkNotNullParameter(body, "body");
        String str2 = null;
        if (headers != null) {
            str = headers.get("Content-Type");
        } else {
            str = null;
        }
        boolean z2 = true;
        if (str == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (headers != null) {
                str2 = headers.get("Content-Length");
            }
            if (str2 != null) {
                z2 = false;
            }
            if (z2) {
                builder.parts.add(new MultipartBody.Part(headers, body));
                return;
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
    }

    public final void addQueryParam(String name, String str, boolean z) {
        HttpUrl.Builder builder;
        String str2 = this.relativeUrl;
        String str3 = null;
        if (str2 != null) {
            HttpUrl httpUrl = this.baseUrl;
            httpUrl.getClass();
            try {
                builder = new HttpUrl.Builder();
                builder.parse$okhttp(httpUrl, str2);
            } catch (IllegalArgumentException unused) {
                builder = null;
            }
            this.urlBuilder = builder;
            if (builder != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl + ", Relative: " + this.relativeUrl);
            }
        }
        if (z) {
            HttpUrl.Builder builder2 = this.urlBuilder;
            builder2.getClass();
            Intrinsics.checkNotNullParameter(name, "encodedName");
            if (builder2.encodedQueryNamesAndValues == null) {
                builder2.encodedQueryNamesAndValues = new ArrayList();
            }
            ArrayList arrayList = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(arrayList);
            arrayList.add(HttpUrl.Companion.canonicalize$okhttp$default(name, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
            ArrayList arrayList2 = builder2.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(arrayList2);
            if (str != null) {
                str3 = HttpUrl.Companion.canonicalize$okhttp$default(str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211);
            }
            arrayList2.add(str3);
            return;
        }
        HttpUrl.Builder builder3 = this.urlBuilder;
        builder3.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        if (builder3.encodedQueryNamesAndValues == null) {
            builder3.encodedQueryNamesAndValues = new ArrayList();
        }
        ArrayList arrayList3 = builder3.encodedQueryNamesAndValues;
        Intrinsics.checkNotNull(arrayList3);
        arrayList3.add(HttpUrl.Companion.canonicalize$okhttp$default(name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
        ArrayList arrayList4 = builder3.encodedQueryNamesAndValues;
        Intrinsics.checkNotNull(arrayList4);
        if (str != null) {
            str3 = HttpUrl.Companion.canonicalize$okhttp$default(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219);
        }
        arrayList4.add(str3);
    }
}
