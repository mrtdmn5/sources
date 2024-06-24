package io.ktor.serialization.kotlinx;

import io.ktor.serialization.ContentConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
/* loaded from: classes3.dex */
public final class KotlinxSerializationConverter implements ContentConverter {
    public final ArrayList extensions;
    public final SerialFormat format;

    public KotlinxSerializationConverter(SerialFormat format) {
        boolean z;
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        List<KotlinxSerializationExtensionProvider> list = ExtensionsJvmKt.providers;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            KotlinxSerializationExtension extension = ((KotlinxSerializationExtensionProvider) it.next()).extension(format);
            if (extension != null) {
                arrayList.add(extension);
            }
        }
        this.extensions = arrayList;
        SerialFormat serialFormat = this.format;
        if (!(serialFormat instanceof BinaryFormat) && !(serialFormat instanceof StringFormat)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Only binary and string formats are supported, " + this.format + " is not supported.").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a8 A[Catch: all -> 0x010a, TryCatch #0 {all -> 0x010a, blocks: (B:13:0x00a2, B:15:0x00a8, B:18:0x00b3, B:20:0x00b7, B:22:0x00c1, B:25:0x00cc, B:27:0x00d2, B:29:0x00ec, B:31:0x00ef, B:34:0x00f2, B:35:0x0109), top: B:12:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b3 A[Catch: all -> 0x010a, TryCatch #0 {all -> 0x010a, blocks: (B:13:0x00a2, B:15:0x00a8, B:18:0x00b3, B:20:0x00b7, B:22:0x00c1, B:25:0x00cc, B:27:0x00d2, B:29:0x00ec, B:31:0x00ef, B:34:0x00f2, B:35:0x0109), top: B:12:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deserialize(final java.nio.charset.Charset r11, final io.ktor.util.reflect.TypeInfo r12, final io.ktor.utils.io.ByteReadChannel r13, kotlin.coroutines.Continuation<java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.deserialize(java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object serializeNullable(final io.ktor.http.ContentType r11, final java.nio.charset.Charset r12, final io.ktor.util.reflect.TypeInfo r13, final java.lang.Object r14, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1
            if (r0 == 0) goto L13
            r0 = r15
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = (io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1 r0 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$1
            r0.<init>(r10, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r14 = r0.L$4
            io.ktor.util.reflect.TypeInfo r13 = r0.L$3
            java.nio.charset.Charset r12 = r0.L$2
            io.ktor.http.ContentType r11 = r0.L$1
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L67
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.ArrayList r15 = r10.extensions
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3 r5 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3
            r5.<init>(r15)
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1 r15 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$$inlined$map$1
            r4 = r15
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r4.<init>()
            io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2 r2 = new io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2
            r4 = 0
            r2.<init>(r4)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.L$4 = r14
            r0.label = r3
            java.lang.Object r15 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r15, r2, r0)
            if (r15 != r1) goto L66
            return r1
        L66:
            r0 = r10
        L67:
            io.ktor.http.content.OutgoingContent r15 = (io.ktor.http.content.OutgoingContent) r15
            if (r15 == 0) goto L6c
            return r15
        L6c:
            kotlinx.serialization.SerialFormat r15 = r0.format     // Catch: kotlinx.serialization.SerializationException -> L77
            com.google.common.hash.AbstractHasher r15 = r15.getSerializersModule()     // Catch: kotlinx.serialization.SerializationException -> L77
            kotlinx.serialization.KSerializer r13 = io.ktor.serialization.kotlinx.SerializerLookupKt.serializerForTypeInfo(r15, r13)     // Catch: kotlinx.serialization.SerializationException -> L77
            goto L81
        L77:
            kotlinx.serialization.SerialFormat r13 = r0.format
            com.google.common.hash.AbstractHasher r13 = r13.getSerializersModule()
            kotlinx.serialization.KSerializer r13 = io.ktor.serialization.kotlinx.SerializerLookupKt.guessSerializer(r14, r13)
        L81:
            kotlinx.serialization.SerialFormat r15 = r0.format
            boolean r0 = r15 instanceof kotlinx.serialization.StringFormat
            if (r0 == 0) goto L97
            kotlinx.serialization.StringFormat r15 = (kotlinx.serialization.StringFormat) r15
            java.lang.String r13 = r15.encodeToString(r13, r14)
            io.ktor.http.content.TextContent r14 = new io.ktor.http.content.TextContent
            io.ktor.http.ContentType r11 = io.ktor.http.ContentTypesKt.withCharsetIfNeeded(r11, r12)
            r14.<init>(r13, r11)
            goto La6
        L97:
            boolean r12 = r15 instanceof kotlinx.serialization.BinaryFormat
            if (r12 == 0) goto La7
            kotlinx.serialization.BinaryFormat r15 = (kotlinx.serialization.BinaryFormat) r15
            byte[] r12 = r15.encodeToByteArray()
            io.ktor.http.content.ByteArrayContent r14 = new io.ktor.http.content.ByteArrayContent
            r14.<init>(r12, r11)
        La6:
            return r14
        La7:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Unsupported format "
            r12.<init>(r13)
            r12.append(r15)
            java.lang.String r12 = r12.toString()
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.KotlinxSerializationConverter.serializeNullable(io.ktor.http.ContentType, java.nio.charset.Charset, io.ktor.util.reflect.TypeInfo, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
