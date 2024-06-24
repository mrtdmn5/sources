package com.animaconnected.secondo.utils.diagnostics;

import com.animaconnected.secondo.utils.debugging.Debugging;
import com.animaconnected.watch.device.diagnostics.DiagnosticsBinaryData;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: CrashBackendImpl.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.diagnostics.CrashBackendImpl$storeCrashFiles$2", f = "CrashBackendImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CrashBackendImpl$storeCrashFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WatchLibResult<? extends Unit, ? extends WatchLibException>>, Object> {
    final /* synthetic */ List<DiagnosticsBinaryData> $data;
    final /* synthetic */ String $filePath;
    int label;
    final /* synthetic */ CrashBackendImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrashBackendImpl$storeCrashFiles$2(String str, CrashBackendImpl crashBackendImpl, List<DiagnosticsBinaryData> list, Continuation<? super CrashBackendImpl$storeCrashFiles$2> continuation) {
        super(2, continuation);
        this.$filePath = str;
        this.this$0 = crashBackendImpl;
        this.$data = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CrashBackendImpl$storeCrashFiles$2(this.$filePath, this.this$0, this.$data, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<? extends Unit, ? extends WatchLibException>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super WatchLibResult<Unit, WatchLibException>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WatchLibResult.Failure failResult;
        Unit unit;
        WatchLibResult.Success successResult;
        Throwable th;
        Unit unit2;
        BufferedReader bufferedReader;
        Throwable th2;
        Long l;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.$filePath));
                List<DiagnosticsBinaryData> list = this.$data;
                CrashBackendImpl crashBackendImpl = this.this$0;
                Throwable th3 = null;
                try {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                    try {
                        for (DiagnosticsBinaryData diagnosticsBinaryData : list) {
                            zipOutputStream.putNextEntry(new ZipEntry(diagnosticsBinaryData.getName()));
                            zipOutputStream.write(diagnosticsBinaryData.getData());
                            zipOutputStream.closeEntry();
                        }
                        for (File file : Debugging.INSTANCE.getAppLogfiles(crashBackendImpl.getContext())) {
                            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                            Charset charset = Charsets.UTF_8;
                            Reader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
                            if (inputStreamReader instanceof BufferedReader) {
                                bufferedReader = (BufferedReader) inputStreamReader;
                            } else {
                                bufferedReader = new BufferedReader(inputStreamReader, DfuBaseService.ERROR_REMOTE_MASK);
                            }
                            try {
                                l = new Long(TextStreamsKt.copyTo(bufferedReader, new OutputStreamWriter(zipOutputStream, charset), 1024));
                                try {
                                    bufferedReader.close();
                                    th2 = null;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th6) {
                                    ExceptionsKt.addSuppressed(th2, th6);
                                }
                                l = null;
                            }
                            if (th2 == null) {
                                Intrinsics.checkNotNull(l);
                                zipOutputStream.closeEntry();
                            } else {
                                throw th2;
                            }
                        }
                        unit2 = Unit.INSTANCE;
                        try {
                            zipOutputStream.close();
                            th = null;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th9) {
                            ExceptionsKt.addSuppressed(th8, th9);
                        }
                        th = th8;
                        unit2 = null;
                    }
                } catch (Throwable th10) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th11) {
                        ExceptionsKt.addSuppressed(th10, th11);
                    }
                    th3 = th10;
                    unit = null;
                }
                if (th == null) {
                    Intrinsics.checkNotNull(unit2);
                    unit = Unit.INSTANCE;
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th12) {
                        th3 = th12;
                    }
                    if (th3 == null) {
                        Intrinsics.checkNotNull(unit);
                        successResult = this.this$0.successResult();
                        return successResult;
                    }
                    throw th3;
                }
                throw th;
            } catch (Exception e) {
                e.printStackTrace();
                failResult = this.this$0.failResult(e.getMessage());
                return failResult;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return ((CrashBackendImpl$storeCrashFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
