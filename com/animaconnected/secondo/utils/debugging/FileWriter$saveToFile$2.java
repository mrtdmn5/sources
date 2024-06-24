package com.animaconnected.secondo.utils.debugging;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* compiled from: FileWriter.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.debugging.FileWriter$saveToFile$2", f = "FileWriter.kt", l = {77}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FileWriter$saveToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ FileWriter this$0;

    /* compiled from: FileWriter.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.utils.debugging.FileWriter$saveToFile$2$1", f = "FileWriter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.utils.debugging.FileWriter$saveToFile$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $logs;
        int label;
        final /* synthetic */ FileWriter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FileWriter fileWriter, List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = fileWriter;
            this.$logs = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$logs, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            File file;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                file = this.this$0.currentLogFile;
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    Iterator<T> it = this.$logs.iterator();
                    while (it.hasNext()) {
                        byte[] bytes = ((String) it.next()).getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        fileOutputStream.write(bytes);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return Unit.INSTANCE;
                } finally {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileWriter$saveToFile$2(FileWriter fileWriter, Context context, Continuation<? super FileWriter$saveToFile$2> continuation) {
        super(2, continuation);
        this.this$0 = fileWriter;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileWriter$saveToFile$2(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        File file;
        File updateCurrentLogfile;
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
            list = this.this$0.logCache;
            List list3 = CollectionsKt___CollectionsKt.toList(list);
            list2 = this.this$0.logCache;
            list2.clear();
            FileWriter fileWriter = this.this$0;
            Context context = this.$context;
            file = fileWriter.currentLogFile;
            updateCurrentLogfile = fileWriter.updateCurrentLogfile(context, file);
            fileWriter.currentLogFile = updateCurrentLogfile;
            DefaultIoScheduler defaultIoScheduler = Dispatchers.IO;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, list3, null);
            this.label = 1;
            if (BuildersKt.withContext(defaultIoScheduler, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileWriter$saveToFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
