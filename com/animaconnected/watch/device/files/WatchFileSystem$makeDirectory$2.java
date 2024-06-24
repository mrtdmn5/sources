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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: WatchFileSystem.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2", f = "WatchFileSystem.kt", l = {R.styleable.AppTheme_themeGradientColor, R.styleable.AppTheme_themeGradientOpacity}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFileSystem$makeDirectory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FileResult>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $path;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WatchFileSystem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFileSystem$makeDirectory$2(String str, String str2, WatchFileSystem watchFileSystem, Continuation<? super WatchFileSystem$makeDirectory$2> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$path = str2;
        this.this$0 = watchFileSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFileSystem$makeDirectory$2 watchFileSystem$makeDirectory$2 = new WatchFileSystem$makeDirectory$2(this.$name, this.$path, this.this$0, continuation);
        watchFileSystem$makeDirectory$2.L$0 = obj;
        return watchFileSystem$makeDirectory$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final DirectoryDescriptor directoryDescriptor;
        Map map;
        Exception exc;
        CoroutineScope coroutineScope;
        TimeoutCancellationException timeoutCancellationException;
        DirectoryDescriptor directoryDescriptor2;
        CoroutineScope coroutineScope2;
        CompletableDeferred completableDeferred;
        DirectoryDescriptor directoryDescriptor3;
        Object withTimeout;
        Map map2;
        Map map3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 == 2) {
                    directoryDescriptor3 = (DirectoryDescriptor) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        directoryDescriptor2 = directoryDescriptor3;
                        withTimeout = obj;
                        try {
                            return (FileResult) withTimeout;
                        } catch (TimeoutCancellationException e) {
                            e = e;
                            directoryDescriptor3 = directoryDescriptor2;
                            timeoutCancellationException = e;
                            directoryDescriptor = directoryDescriptor3;
                            LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$2
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "TimeoutCancellation Exception in make directory";
                                }
                            }, 4, (Object) null);
                            map3 = this.this$0.currentTransfers;
                            map3.remove(directoryDescriptor);
                            return FileResult.OtherTimeout;
                        } catch (Exception e2) {
                            e = e2;
                            directoryDescriptor3 = directoryDescriptor2;
                            exc = e;
                            directoryDescriptor = directoryDescriptor3;
                            LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$3
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Exception in make directory";
                                }
                            }, 4, (Object) null);
                            map2 = this.this$0.currentTransfers;
                            map2.remove(directoryDescriptor);
                            return FileResult.OtherException;
                        }
                    } catch (TimeoutCancellationException e3) {
                        e = e3;
                        timeoutCancellationException = e;
                        directoryDescriptor = directoryDescriptor3;
                        LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "TimeoutCancellation Exception in make directory";
                            }
                        }, 4, (Object) null);
                        map3 = this.this$0.currentTransfers;
                        map3.remove(directoryDescriptor);
                        return FileResult.OtherTimeout;
                    } catch (Exception e4) {
                        e = e4;
                        exc = e;
                        directoryDescriptor = directoryDescriptor3;
                        LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$3
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Exception in make directory";
                            }
                        }, 4, (Object) null);
                        map2 = this.this$0.currentTransfers;
                        map2.remove(directoryDescriptor);
                        return FileResult.OtherException;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableDeferred = (CompletableDeferred) this.L$2;
            directoryDescriptor2 = (DirectoryDescriptor) this.L$1;
            coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException e5) {
                e = e5;
                directoryDescriptor3 = directoryDescriptor2;
                coroutineScope = coroutineScope2;
                timeoutCancellationException = e;
                directoryDescriptor = directoryDescriptor3;
                LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "TimeoutCancellation Exception in make directory";
                    }
                }, 4, (Object) null);
                map3 = this.this$0.currentTransfers;
                map3.remove(directoryDescriptor);
                return FileResult.OtherTimeout;
            } catch (Exception e6) {
                e = e6;
                directoryDescriptor3 = directoryDescriptor2;
                coroutineScope = coroutineScope2;
                exc = e;
                directoryDescriptor = directoryDescriptor3;
                LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Exception in make directory";
                    }
                }, 4, (Object) null);
                map2 = this.this$0.currentTransfers;
                map2.remove(directoryDescriptor);
                return FileResult.OtherException;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            String str = this.$name;
            if (str == null) {
                String str2 = this.$path;
                Intrinsics.checkNotNullParameter(str2, "<this>");
                int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(str2, "/", 6);
                if (lastIndexOf$default != -1) {
                    str2 = str2.substring(lastIndexOf$default + 1, str2.length());
                    Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                }
                String str3 = str2;
                String str4 = this.$path;
                Intrinsics.checkNotNullParameter(str4, "<this>");
                int lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default(str4, "/", 6);
                if (lastIndexOf$default2 != -1) {
                    str4 = str4.substring(0, lastIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(str4, "substring(...)");
                }
                directoryDescriptor = new DirectoryDescriptor(str4, str3, null, 4, null);
            } else {
                directoryDescriptor = new DirectoryDescriptor(this.$path, str, null, 4, null);
            }
            LogKt.debug$default((Object) coroutineScope3, WatchFileSystem.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Making directory: " + DirectoryDescriptor.this.getFullPath();
                }
            }, 6, (Object) null);
            CompletableDeferredImpl CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default();
            map = this.this$0.currentTransfers;
            map.put(directoryDescriptor, CompletableDeferred$default);
            try {
                WatchIO io2 = this.this$0.getIo();
                String fullPath = directoryDescriptor.getFullPath();
                this.L$0 = coroutineScope3;
                this.L$1 = directoryDescriptor;
                this.L$2 = CompletableDeferred$default;
                this.label = 1;
                if (io2.writeDirectory(fullPath, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                directoryDescriptor2 = directoryDescriptor;
                coroutineScope2 = coroutineScope3;
                completableDeferred = CompletableDeferred$default;
            } catch (TimeoutCancellationException e7) {
                timeoutCancellationException = e7;
                coroutineScope = coroutineScope3;
                LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) timeoutCancellationException, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "TimeoutCancellation Exception in make directory";
                    }
                }, 4, (Object) null);
                map3 = this.this$0.currentTransfers;
                map3.remove(directoryDescriptor);
                return FileResult.OtherTimeout;
            } catch (Exception e8) {
                exc = e8;
                coroutineScope = coroutineScope3;
                LogKt.warn$default((Object) coroutineScope, WatchFileSystem.tag, (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.files.WatchFileSystem$makeDirectory$2$fileResult$3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Exception in make directory";
                    }
                }, 4, (Object) null);
                map2 = this.this$0.currentTransfers;
                map2.remove(directoryDescriptor);
                return FileResult.OtherException;
            }
        }
        WatchFileSystem$makeDirectory$2$fileResult$1 watchFileSystem$makeDirectory$2$fileResult$1 = new WatchFileSystem$makeDirectory$2$fileResult$1(completableDeferred, null);
        this.L$0 = coroutineScope2;
        this.L$1 = directoryDescriptor2;
        this.L$2 = null;
        this.label = 2;
        withTimeout = TimeoutKt.withTimeout(10000L, watchFileSystem$makeDirectory$2$fileResult$1, this);
        if (withTimeout == coroutineSingletons) {
            return coroutineSingletons;
        }
        coroutineScope = coroutineScope2;
        return (FileResult) withTimeout;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FileResult> continuation) {
        return ((WatchFileSystem$makeDirectory$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
