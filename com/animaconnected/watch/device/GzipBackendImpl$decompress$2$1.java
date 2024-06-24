package com.animaconnected.watch.device;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: GzipBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.GzipBackendImpl$decompress$2$1", f = "GzipBackendImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GzipBackendImpl$decompress$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ ByteArrayInputStream $bais;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GzipBackendImpl$decompress$2$1(ByteArrayInputStream byteArrayInputStream, Continuation<? super GzipBackendImpl$decompress$2$1> continuation) {
        super(2, continuation);
        this.$bais = byteArrayInputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GzipBackendImpl$decompress$2$1(this.$bais, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BufferedReader bufferedReader;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.$bais);
            try {
                Reader inputStreamReader = new InputStreamReader(gZIPInputStream, Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, DfuBaseService.ERROR_REMOTE_MASK);
                }
                try {
                    String readText = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(gZIPInputStream, null);
                    return readText;
                } finally {
                }
            } finally {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GzipBackendImpl$decompress$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
