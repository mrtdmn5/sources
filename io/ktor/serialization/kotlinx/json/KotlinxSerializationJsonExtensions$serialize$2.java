package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.KSerializer;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$2", f = "KotlinxSerializationJsonExtensions.kt", l = {51}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class KotlinxSerializationJsonExtensions$serialize$2 extends SuspendLambda implements Function2<ByteWriteChannel, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Charset $charset;
    public final /* synthetic */ KSerializer<?> $serializer;
    public final /* synthetic */ Object $value;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationJsonExtensions$serialize$2(KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, Object obj, KSerializer<?> kSerializer, Charset charset, Continuation<? super KotlinxSerializationJsonExtensions$serialize$2> continuation) {
        super(2, continuation);
        this.this$0 = kotlinxSerializationJsonExtensions;
        this.$value = obj;
        this.$serializer = kSerializer;
        this.$charset = charset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinxSerializationJsonExtensions$serialize$2 kotlinxSerializationJsonExtensions$serialize$2 = new KotlinxSerializationJsonExtensions$serialize$2(this.this$0, this.$value, this.$serializer, this.$charset, continuation);
        kotlinxSerializationJsonExtensions$serialize$2.L$0 = obj;
        return kotlinxSerializationJsonExtensions$serialize$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        return ((KotlinxSerializationJsonExtensions$serialize$2) create(byteWriteChannel, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ByteWriteChannel byteWriteChannel = (ByteWriteChannel) this.L$0;
            KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions = this.this$0;
            Object obj2 = this.$value;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<*>");
            KSerializer<?> kSerializer = this.$serializer;
            Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            Charset charset = this.$charset;
            this.label = 1;
            if (KotlinxSerializationJsonExtensions.access$serialize(kotlinxSerializationJsonExtensions, (Flow) obj2, kSerializer, charset, byteWriteChannel, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
