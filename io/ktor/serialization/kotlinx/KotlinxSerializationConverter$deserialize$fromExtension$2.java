package io.ktor.serialization.kotlinx;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: KotlinxSerializationConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$deserialize$fromExtension$2", f = "KotlinxSerializationConverter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class KotlinxSerializationConverter$deserialize$fromExtension$2 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    public final /* synthetic */ ByteReadChannel $content;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinxSerializationConverter$deserialize$fromExtension$2(ByteReadChannel byteReadChannel, Continuation<? super KotlinxSerializationConverter$deserialize$fromExtension$2> continuation) {
        super(2, continuation);
        this.$content = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinxSerializationConverter$deserialize$fromExtension$2 kotlinxSerializationConverter$deserialize$fromExtension$2 = new KotlinxSerializationConverter$deserialize$fromExtension$2(this.$content, continuation);
        kotlinxSerializationConverter$deserialize$fromExtension$2.L$0 = obj;
        return kotlinxSerializationConverter$deserialize$fromExtension$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return ((KotlinxSerializationConverter$deserialize$fromExtension$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        if (this.L$0 == null && !this.$content.isClosedForRead()) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
