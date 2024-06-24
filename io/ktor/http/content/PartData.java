package io.ktor.http.content;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.core.Input;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Multipart.kt */
/* loaded from: classes3.dex */
public abstract class PartData {
    public final Function0<Unit> dispose;
    public final Headers headers;

    /* compiled from: Multipart.kt */
    /* loaded from: classes3.dex */
    public static final class BinaryChannelItem extends PartData {
        public BinaryChannelItem(HeadersImpl headersImpl) {
            Intrinsics.checkNotNullParameter(null, "provider");
            throw null;
        }
    }

    /* compiled from: Multipart.kt */
    /* loaded from: classes3.dex */
    public static final class BinaryItem extends PartData {
        public final Function0<Input> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BinaryItem(Function0 provider, Function0 dispose, HeadersImpl headersImpl) {
            super(dispose, headersImpl);
            Intrinsics.checkNotNullParameter(provider, "provider");
            Intrinsics.checkNotNullParameter(dispose, "dispose");
            this.provider = provider;
        }
    }

    /* compiled from: Multipart.kt */
    /* loaded from: classes3.dex */
    public static final class FileItem extends PartData {
    }

    /* compiled from: Multipart.kt */
    /* loaded from: classes3.dex */
    public static final class FormItem extends PartData {
        public final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormItem(String value, Function0 dispose, HeadersImpl headersImpl) {
            super(dispose, headersImpl);
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(dispose, "dispose");
            this.value = value;
        }
    }

    public PartData() {
        throw null;
    }

    public PartData(Function0 function0, HeadersImpl headersImpl) {
        this.dispose = function0;
        this.headers = headersImpl;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<ContentDisposition>() { // from class: io.ktor.http.content.PartData$contentDisposition$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ContentDisposition invoke() {
                Headers headers = PartData.this.headers;
                List<String> list = HttpHeaders.UnsafeHeadersList;
                String str = headers.get("Content-Disposition");
                if (str != null) {
                    int r1 = ContentDisposition.$r8$clinit;
                    HeaderValue headerValue = (HeaderValue) CollectionsKt___CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(str));
                    return new ContentDisposition(headerValue.value, headerValue.params);
                }
                return null;
            }
        });
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0<ContentType>() { // from class: io.ktor.http.content.PartData$contentType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ContentType invoke() {
                Headers headers = PartData.this.headers;
                List<String> list = HttpHeaders.UnsafeHeadersList;
                String str = headers.get("Content-Type");
                if (str != null) {
                    ContentType contentType = ContentType.Any;
                    return ContentType.Companion.parse(str);
                }
                return null;
            }
        });
    }
}
