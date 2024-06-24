package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Charsets;

/* compiled from: HttpPlainText.kt */
/* loaded from: classes3.dex */
public final class HttpPlainText {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<HttpPlainText> key = new AttributeKey<>("HttpPlainText");
    public final String acceptCharsetHeader;
    public final Charset requestCharset;
    public final Charset responseCharsetFallback;

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes3.dex */
    public static final class Config {
        public final LinkedHashSet charsets = new LinkedHashSet();
        public final LinkedHashMap charsetQuality = new LinkedHashMap();
        public final Charset responseCharsetFallback = Charsets.UTF_8;
    }

    /* compiled from: HttpPlainText.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpPlainText> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<HttpPlainText> getKey() {
            return HttpPlainText.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            HttpPlainText plugin = (HttpPlainText) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.Render, new HttpPlainText$Plugin$install$1(plugin, null));
            scope.responsePipeline.intercept(HttpResponsePipeline.Transform, new HttpPlainText$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final HttpPlainText prepare(Function1<? super Config, Unit> function1) {
            Config config = new Config();
            function1.invoke(config);
            return new HttpPlainText(config.charsets, config.charsetQuality, config.responseCharsetFallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpPlainText(LinkedHashSet charsets, LinkedHashMap charsetQuality, Charset responseCharsetFallback) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(charsets, "charsets");
        Intrinsics.checkNotNullParameter(charsetQuality, "charsetQuality");
        Intrinsics.checkNotNullParameter(responseCharsetFallback, "responseCharsetFallback");
        this.responseCharsetFallback = responseCharsetFallback;
        List<Pair> sortedWith = CollectionsKt___CollectionsKt.sortedWith(MapsKt___MapsKt.toList(charsetQuality), new HttpPlainText$special$$inlined$sortedByDescending$1());
        ArrayList arrayList = new ArrayList();
        Iterator it = charsets.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (true ^ charsetQuality.containsKey((Charset) next)) {
                arrayList.add(next);
            }
        }
        List sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList, new HttpPlainText$special$$inlined$sortedBy$1());
        StringBuilder sb = new StringBuilder();
        Iterator it2 = sortedWith2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Charset charset = (Charset) it2.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(CharsetJVMKt.getName(charset));
        }
        for (Pair pair : sortedWith) {
            Charset charset2 = (Charset) pair.first;
            float floatValue = ((Number) pair.second).floatValue();
            if (sb.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                sb.append(",");
            }
            double d = floatValue;
            if (0.0d <= d && d <= 1.0d) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                sb.append(CharsetJVMKt.getName(charset2) + ";q=" + (MathKt__MathJVMKt.roundToInt(100 * floatValue) / 100.0d));
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        if (sb.length() == 0) {
            sb.append(CharsetJVMKt.getName(this.responseCharsetFallback));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.acceptCharsetHeader = sb2;
        Charset charset3 = (Charset) CollectionsKt___CollectionsKt.firstOrNull(sortedWith2);
        if (charset3 == null) {
            Pair pair2 = (Pair) CollectionsKt___CollectionsKt.firstOrNull(sortedWith);
            if (pair2 != null) {
                charset3 = (Charset) pair2.first;
            } else {
                charset3 = null;
            }
            if (charset3 == null) {
                charset3 = Charsets.UTF_8;
            }
        }
        this.requestCharset = charset3;
    }
}
