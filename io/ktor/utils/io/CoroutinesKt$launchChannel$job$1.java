package io.ktor.utils.io;

import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Unconfined;

/* compiled from: Coroutines.kt */
@DebugMetadata(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", l = {R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CoroutinesKt$launchChannel$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $attachJob;
    public final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $block;
    public final /* synthetic */ ByteChannel $channel;
    public final /* synthetic */ CoroutineDispatcher $dispatcher;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesKt$launchChannel$job$1(boolean z, ByteChannel byteChannel, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super CoroutinesKt$launchChannel$job$1> continuation) {
        super(2, continuation);
        this.$attachJob = z;
        this.$channel = byteChannel;
        this.$block = function2;
        this.$dispatcher = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutinesKt$launchChannel$job$1 coroutinesKt$launchChannel$job$1 = new CoroutinesKt$launchChannel$job$1(this.$attachJob, this.$channel, this.$block, this.$dispatcher, continuation);
        coroutinesKt$launchChannel$job$1.L$0 = obj;
        return coroutinesKt$launchChannel$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutinesKt$launchChannel$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        ByteChannel byteChannel = this.$channel;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (this.$attachJob) {
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
                    Intrinsics.checkNotNull(element);
                    byteChannel.attachJob((Job) element);
                }
                ChannelScope channelScope = new ChannelScope(coroutineScope, byteChannel);
                Function2<Object, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (function2.invoke(channelScope, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } catch (Throwable th) {
            Unconfined unconfined = Dispatchers.Unconfined;
            CoroutineDispatcher coroutineDispatcher = this.$dispatcher;
            if (!Intrinsics.areEqual(coroutineDispatcher, unconfined) && coroutineDispatcher != null) {
                throw th;
            }
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }
}
