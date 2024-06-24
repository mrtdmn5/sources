package com.animaconnected.watch.device;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GzipBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.GzipBackendImpl$compress$2$1", f = "GzipBackendImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GzipBackendImpl$compress$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteArrayOutputStream $baos;
    final /* synthetic */ String $content;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GzipBackendImpl$compress$2$1(ByteArrayOutputStream byteArrayOutputStream, String str, Continuation<? super GzipBackendImpl$compress$2$1> continuation) {
        super(2, continuation);
        this.$baos = byteArrayOutputStream;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GzipBackendImpl$compress$2$1(this.$baos, this.$content, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(this.$baos);
            try {
                byte[] bytes = this.$content.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                gZIPOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(gZIPOutputStream, null);
                return Unit.INSTANCE;
            } finally {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GzipBackendImpl$compress$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
