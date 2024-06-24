package io.ktor.serialization.kotlinx.json;

import com.google.android.gms.internal.fitness.zzaa;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.serialization.kotlinx.KotlinxSerializationExtension;
import io.ktor.serialization.kotlinx.SerializerLookupKt;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.Json;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions implements KotlinxSerializationExtension {
    public final Json format;
    public final LinkedHashMap jsonArraySymbolsMap;

    public KotlinxSerializationJsonExtensions(Json format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        this.jsonArraySymbolsMap = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$serialize(io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions r14, kotlinx.coroutines.flow.Flow r15, kotlinx.serialization.KSerializer r16, java.nio.charset.Charset r17, io.ktor.utils.io.ByteWriteChannel r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.access$serialize(io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions, kotlinx.coroutines.flow.Flow, kotlinx.serialization.KSerializer, java.nio.charset.Charset, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(java.nio.charset.Charset r5, io.ktor.util.reflect.TypeInfo r6, io.ktor.utils.io.ByteReadChannel r7, kotlin.coroutines.Continuation<java.lang.Object> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$deserialize$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L27
            goto L5e
        L27:
            r5 = move-exception
            goto L5f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
            r8 = 0
            if (r5 == 0) goto L65
            kotlin.reflect.KClass<?> r5 = r6.type
            java.lang.Class<kotlin.sequences.Sequence> r2 = kotlin.sequences.Sequence.class
            kotlin.jvm.internal.ClassReference r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r2)
            if (r5 != 0) goto L4c
            goto L65
        L4c:
            kotlinx.serialization.json.Json r5 = r4.format     // Catch: java.lang.Throwable -> L27
            r0.label = r3     // Catch: java.lang.Throwable -> L27
            kotlinx.coroutines.scheduling.DefaultIoScheduler r2 = kotlinx.coroutines.Dispatchers.IO     // Catch: java.lang.Throwable -> L27
            io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt$deserializeSequence$2 r3 = new io.ktor.serialization.kotlinx.json.JsonExtensionsJvmKt$deserializeSequence$2     // Catch: java.lang.Throwable -> L27
            r3.<init>(r6, r7, r8, r5)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r2, r3, r0)     // Catch: java.lang.Throwable -> L27
            if (r8 != r1) goto L5e
            return r1
        L5e:
            return r8
        L5f:
            io.ktor.serialization.JsonConvertException r6 = new io.ktor.serialization.JsonConvertException
            r6.<init>(r5)
            throw r6
        L65:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.deserialize(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.serialization.kotlinx.KotlinxSerializationExtension
    public final ChannelWriterContent serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj) {
        if (Intrinsics.areEqual(charset, Charsets.UTF_8) && Intrinsics.areEqual(typeInfo.type, Reflection.getOrCreateKotlinClass(Flow.class))) {
            return new ChannelWriterContent(new KotlinxSerializationJsonExtensions$serialize$2(this, obj, SerializerLookupKt.serializerForTypeInfo(this.format.serializersModule, zzaa.argumentTypeInfo(typeInfo)), charset, null), ContentTypesKt.withCharsetIfNeeded(contentType, charset));
        }
        return null;
    }
}
