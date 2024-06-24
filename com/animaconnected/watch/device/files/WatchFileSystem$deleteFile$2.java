package com.animaconnected.watch.device.files;

import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.device.FileResult;
import com.animaconnected.watch.device.WatchIO;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2", f = "WatchFileSystem.kt", l = {R.styleable.AppTheme_stepsHistoryHintBackgroundColorActivity, R.styleable.AppTheme_stepsHistoryHintBackgroundColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$deleteFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileResult>, Object> {
    final /* synthetic */ FileEntry $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WatchFileSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$deleteFile$2(WatchFileSystem watchFileSystem, FileEntry fileEntry, Continuation<? super WatchFileSystem$deleteFile$2> continuation) {
        super(2, continuation);
        this.this$0 = watchFileSystem;
        this.$file = fileEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFileSystem$deleteFile$2 watchFileSystem$deleteFile$2 = new WatchFileSystem$deleteFile$2(this.this$0, this.$file, continuation);
        watchFileSystem$deleteFile$2.L$0 = obj;
        return watchFileSystem$deleteFile$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CompletableDeferred CompletableDeferred$default;
        Map map;
        CoroutineScope coroutineScope;
        Exception e;
        TimeoutCancellationException e2;
        Exception exc;
        CoroutineScope coroutineScope2;
        TimeoutCancellationException timeoutCancellationException;
        CoroutineScope coroutineScope3;
        CoroutineScope coroutineScope4;
        Map map2;
        Map map3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    coroutineScope4 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return (FileResult) obj;
                    } catch (TimeoutCancellationException e3) {
                        timeoutCancellationException = e3;
                        coroutineScope3 = coroutineScope4;
                        final FileEntry fileEntry = this.$file;
                        LogKt.warn$default((Object) coroutineScope3, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "TimeoutCancellationException in delete file: " + FileEntry.this.getFullPath();
                            }
                        }, 4, (Object) null);
                        map3 = this.this$0.currentTransfers;
                        map3.remove(this.$file);
                        return FileResult.OtherTimeout;
                    } catch (Exception e4) {
                        exc = e4;
                        coroutineScope2 = coroutineScope4;
                        final FileEntry fileEntry2 = this.$file;
                        LogKt.warn$default((Object) coroutineScope2, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Exception in delete file:  " + FileEntry.this.getFullPath();
                            }
                        }, 4, (Object) null);
                        map2 = this.this$0.currentTransfers;
                        map2.remove(this.$file);
                        return FileResult.OtherException;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CompletableDeferred$default = (CompletableDeferred) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException e5) {
                e2 = e5;
                timeoutCancellationException = e2;
                coroutineScope3 = coroutineScope;
                final FileEntry fileEntry3 = this.$file;
                LogKt.warn$default((Object) coroutineScope3, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "TimeoutCancellationException in delete file: " + FileEntry.this.getFullPath();
                    }
                }, 4, (Object) null);
                map3 = this.this$0.currentTransfers;
                map3.remove(this.$file);
                return FileResult.OtherTimeout;
            } catch (Exception e6) {
                e = e6;
                exc = e;
                coroutineScope2 = coroutineScope;
                final FileEntry fileEntry22 = this.$file;
                LogKt.warn$default((Object) coroutineScope2, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Exception in delete file:  " + FileEntry.this.getFullPath();
                    }
                }, 4, (Object) null);
                map2 = this.this$0.currentTransfers;
                map2.remove(this.$file);
                return FileResult.OtherException;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
            CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default();
            map = this.this$0.currentTransfers;
            map.put(this.$file, CompletableDeferred$default);
            try {
                WatchIO io2 = this.this$0.getIo();
                String fullPath = this.$file.getFullPath();
                this.L$0 = coroutineScope5;
                this.L$1 = CompletableDeferred$default;
                this.label = 1;
                if (io2.deleteFile(fullPath, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope5;
            } catch (TimeoutCancellationException e7) {
                coroutineScope = coroutineScope5;
                e2 = e7;
                timeoutCancellationException = e2;
                coroutineScope3 = coroutineScope;
                final FileEntry fileEntry32 = this.$file;
                LogKt.warn$default((Object) coroutineScope3, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "TimeoutCancellationException in delete file: " + FileEntry.this.getFullPath();
                    }
                }, 4, (Object) null);
                map3 = this.this$0.currentTransfers;
                map3.remove(this.$file);
                return FileResult.OtherTimeout;
            } catch (Exception e8) {
                coroutineScope = coroutineScope5;
                e = e8;
                exc = e;
                coroutineScope2 = coroutineScope;
                final FileEntry fileEntry222 = this.$file;
                LogKt.warn$default((Object) coroutineScope2, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$deleteFile$2$fileResult$3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Exception in delete file:  " + FileEntry.this.getFullPath();
                    }
                }, 4, (Object) null);
                map2 = this.this$0.currentTransfers;
                map2.remove(this.$file);
                return FileResult.OtherException;
            }
        }
        WatchFileSystem$deleteFile$2$fileResult$1 watchFileSystem$deleteFile$2$fileResult$1 = new WatchFileSystem$deleteFile$2$fileResult$1(CompletableDeferred$default, null);
        this.L$0 = coroutineScope;
        this.L$1 = null;
        this.label = 2;
        obj = TimeoutKt.withTimeout(10000L, watchFileSystem$deleteFile$2$fileResult$1, this);
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        coroutineScope4 = coroutineScope;
        return (FileResult) obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileResult> continuation) {
        return ((WatchFileSystem$deleteFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
