package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: ContentNegotiation.kt */
/* loaded from: classes3.dex */
public final class ContentNegotiation {
    public static final Plugin Plugin = new Plugin();
    public static final AttributeKey<ContentNegotiation> key = new AttributeKey<>("ContentNegotiation");
    public final Set<KClass<?>> ignoredTypes;
    public final List<Config.ConverterRegistration> registrations;

    /* compiled from: ContentNegotiation.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Configuration {
        public final Set<KClass<?>> ignoredTypes = CollectionsKt___CollectionsKt.toMutableSet(SetsKt.plus(DefaultIgnoredTypesJvmKt.DefaultIgnoredTypes, ContentNegotiationKt.DefaultCommonIgnoredTypes));
        public final ArrayList registrations = new ArrayList();

        /* compiled from: ContentNegotiation.kt */
        /* loaded from: classes3.dex */
        public static final class ConverterRegistration {
            public final ContentTypeMatcher contentTypeMatcher;
            public final ContentType contentTypeToSend;
            public final ContentConverter converter;

            public ConverterRegistration(KotlinxSerializationConverter kotlinxSerializationConverter, ContentType contentTypeToSend, ContentTypeMatcher contentTypeMatcher) {
                Intrinsics.checkNotNullParameter(contentTypeToSend, "contentTypeToSend");
                this.converter = kotlinxSerializationConverter;
                this.contentTypeToSend = contentTypeToSend;
                this.contentTypeMatcher = contentTypeMatcher;
            }
        }

        @Override // io.ktor.serialization.Configuration
        public final void register(final ContentType contentType, KotlinxSerializationConverter kotlinxSerializationConverter, Function1 configuration) {
            ContentTypeMatcher contentTypeMatcher;
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            if (Intrinsics.areEqual(contentType, ContentType.Application.Json)) {
                contentTypeMatcher = JsonContentTypeMatcher.INSTANCE;
            } else {
                contentTypeMatcher = new ContentTypeMatcher() { // from class: io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Config$defaultMatcher$1
                    @Override // io.ktor.http.ContentTypeMatcher
                    public final boolean contains(ContentType contentType2) {
                        Intrinsics.checkNotNullParameter(contentType2, "contentType");
                        return contentType2.match(ContentType.this);
                    }
                };
            }
            configuration.invoke(kotlinxSerializationConverter);
            this.registrations.add(new ConverterRegistration(kotlinxSerializationConverter, contentType, contentTypeMatcher));
        }
    }

    /* compiled from: ContentNegotiation.kt */
    /* loaded from: classes3.dex */
    public static final class Plugin implements HttpClientPlugin<Config, ContentNegotiation> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey<ContentNegotiation> getKey() {
            return ContentNegotiation.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void install(HttpClient scope, Object obj) {
            ContentNegotiation plugin = (ContentNegotiation) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.requestPipeline.intercept(HttpRequestPipeline.Transform, new ContentNegotiation$Plugin$install$1(plugin, null));
            scope.responsePipeline.intercept(HttpResponsePipeline.Transform, new ContentNegotiation$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final ContentNegotiation prepare(Function1<? super Config, Unit> function1) {
            Config config = new Config();
            function1.invoke(config);
            return new ContentNegotiation(config.registrations, config.ignoredTypes);
        }
    }

    public ContentNegotiation(ArrayList registrations, Set ignoredTypes) {
        Intrinsics.checkNotNullParameter(registrations, "registrations");
        Intrinsics.checkNotNullParameter(ignoredTypes, "ignoredTypes");
        this.registrations = registrations;
        this.ignoredTypes = ignoredTypes;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0219 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01dd -> B:10:0x01e8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object convertRequest$ktor_client_content_negotiation(io.ktor.client.request.HttpRequestBuilder r19, java.lang.Object r20, kotlin.coroutines.Continuation<java.lang.Object> r21) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation.convertRequest$ktor_client_content_negotiation(io.ktor.client.request.HttpRequestBuilder, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object convertResponse$ktor_client_content_negotiation(io.ktor.http.Url r9, io.ktor.util.reflect.TypeInfo r10, java.lang.Object r11, io.ktor.http.ContentType r12, java.nio.charset.Charset r13, kotlin.coroutines.Continuation<java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.contentnegotiation.ContentNegotiation.convertResponse$ktor_client_content_negotiation(io.ktor.http.Url, io.ktor.util.reflect.TypeInfo, java.lang.Object, io.ktor.http.ContentType, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
