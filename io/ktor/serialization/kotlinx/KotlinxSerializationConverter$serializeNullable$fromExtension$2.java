package io.ktor.serialization.kotlinx;

import io.ktor.http.content.OutgoingContent;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: KotlinxSerializationConverter.kt */
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializeNullable$fromExtension$2", f = "KotlinxSerializationConverter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class KotlinxSerializationConverter$serializeNullable$fromExtension$2 extends SuspendLambda implements Function2<OutgoingContent, Continuation<? super Boolean>, Object> {
    public /* synthetic */ Object L$0;

    public KotlinxSerializationConverter$serializeNullable$fromExtension$2(Continuation<? super KotlinxSerializationConverter$serializeNullable$fromExtension$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KotlinxSerializationConverter$serializeNullable$fromExtension$2 kotlinxSerializationConverter$serializeNullable$fromExtension$2 = new KotlinxSerializationConverter$serializeNullable$fromExtension$2(continuation);
        kotlinxSerializationConverter$serializeNullable$fromExtension$2.L$0 = obj;
        return kotlinxSerializationConverter$serializeNullable$fromExtension$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(OutgoingContent outgoingContent, Continuation<? super Boolean> continuation) {
        return ((KotlinxSerializationConverter$serializeNullable$fromExtension$2) create(outgoingContent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        if (((OutgoingContent) this.L$0) != null) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
