package io.ktor.serialization.kotlinx.json;

import com.animaconnected.secondo.R;
import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;

/* compiled from: Collect.kt */
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 implements FlowCollector<Object> {
    public final /* synthetic */ ByteWriteChannel $channel$inlined;
    public final /* synthetic */ Charset $charset$inlined;
    public final /* synthetic */ JsonArraySymbols $jsonArraySymbols$inlined;
    public final /* synthetic */ KSerializer $serializer$inlined;
    public int index;
    public final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* compiled from: Collect.kt */
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", f = "KotlinxSerializationJsonExtensions.kt", l = {124, R.styleable.AppTheme_statusTextH5}, m = "emit")
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this.emit(null, this);
        }
    }

    public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(ByteWriteChannel byteWriteChannel, JsonArraySymbols jsonArraySymbols, KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, KSerializer kSerializer, Charset charset) {
        this.$channel$inlined = byteWriteChannel;
        this.$jsonArraySymbols$inlined = jsonArraySymbols;
        this.this$0 = kotlinxSerializationJsonExtensions;
        this.$serializer$inlined = kSerializer;
        this.$charset$inlined = charset;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L3d
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L9d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5e
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            int r7 = r5.index
            int r2 = r7 + 1
            r5.index = r2
            if (r7 < 0) goto La5
            if (r7 <= 0) goto L61
            io.ktor.serialization.kotlinx.json.JsonArraySymbols r7 = r5.$jsonArraySymbols$inlined
            byte[] r7 = r7.objectSeparator
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            io.ktor.utils.io.ByteWriteChannel r2 = r5.$channel$inlined
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r2, r7, r0)
            if (r7 != r1) goto L5d
            return r1
        L5d:
            r2 = r5
        L5e:
            r7 = r6
            r6 = r2
            goto L63
        L61:
            r7 = r6
            r6 = r5
        L63:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions r2 = r6.this$0
            kotlinx.serialization.json.Json r2 = r2.format
            kotlinx.serialization.KSerializer r3 = r6.$serializer$inlined
            java.lang.String r7 = r2.encodeToString(r3, r7)
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
            java.nio.charset.Charset r3 = r6.$charset$inlined
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r2 == 0) goto L7c
            byte[] r7 = kotlin.text.StringsKt__StringsJVMKt.encodeToByteArray(r7)
            goto L8d
        L7c:
            java.nio.charset.CharsetEncoder r2 = r3.newEncoder()
            java.lang.String r3 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r7.length()
            byte[] r7 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeToByteArray(r2, r7, r3)
        L8d:
            r0.L$0 = r6
            r2 = 0
            r0.L$1 = r2
            r0.label = r4
            io.ktor.utils.io.ByteWriteChannel r2 = r6.$channel$inlined
            java.lang.Object r7 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r2, r7, r0)
            if (r7 != r1) goto L9d
            return r1
        L9d:
            io.ktor.utils.io.ByteWriteChannel r6 = r6.$channel$inlined
            r6.flush()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        La5:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            java.lang.String r7 = "Index overflow has happened"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
