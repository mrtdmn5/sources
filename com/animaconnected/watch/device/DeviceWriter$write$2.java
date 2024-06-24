package com.animaconnected.watch.device;

import com.animaconnected.logger.LogKt;
import com.animaconnected.msgpack.MsgPack;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceWriter.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceWriter$write$2", f = "DeviceWriter.kt", l = {94}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceWriter$write$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ MsgPack $value;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceWriter$write$2(DeviceWriter deviceWriter, String str, MsgPack msgPack, Continuation<? super DeviceWriter$write$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceWriter;
        this.$name = str;
        this.$value = msgPack;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceWriter$write$2 deviceWriter$write$2 = new DeviceWriter$write$2(this.this$0, this.$name, this.$value, continuation);
        deviceWriter$write$2.L$0 = obj;
        return deviceWriter$write$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Exception e;
        CoroutineScope coroutineScope;
        String str;
        CoroutineScope coroutineScope2;
        String str2;
        WatchBackend watchBackend;
        final Command command;
        String str3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ?? r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    command = (Command) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = (CoroutineScope) this.L$0;
                final Command createWriteCommand = this.this$0.createWriteCommand(this.$name, this.$value);
                if (createWriteCommand.getMsgpackAsBytes$watch_release().length <= 247) {
                    str2 = this.this$0.tag;
                    final DeviceWriter deviceWriter = this.this$0;
                    LogKt.verbose$default((Object) coroutineScope2, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceWriter$write$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            boolean z;
                            StringBuilder sb = new StringBuilder("Write -> ");
                            Command command2 = Command.this;
                            z = deviceWriter.logBytes;
                            sb.append(command2.toString(z));
                            return sb.toString();
                        }
                    }, 6, (Object) null);
                    watchBackend = this.this$0.device;
                    byte[] msgpackAsBytes$watch_release = createWriteCommand.getMsgpackAsBytes$watch_release();
                    this.L$0 = coroutineScope2;
                    this.L$1 = createWriteCommand;
                    this.label = 1;
                    if (watchBackend.write(msgpackAsBytes$watch_release, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    command = createWriteCommand;
                } else {
                    return new Result(ResultKt.createFailure(new CommandTooLargeException()));
                }
            }
            CoroutineScope coroutineScope3 = coroutineScope2;
            try {
                if (this.this$0.isDebugEnabled()) {
                    str3 = this.this$0.tag;
                    final DeviceWriter deviceWriter2 = this.this$0;
                    LogKt.debug$default((Object) coroutineScope3, str3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceWriter$write$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            boolean z;
                            StringBuilder sb = new StringBuilder("Wrote ");
                            Command command2 = Command.this;
                            z = deviceWriter2.logBytes;
                            sb.append(command2.toString(z));
                            return sb.toString();
                        }
                    }, 6, (Object) null);
                }
                return new Result(Unit.INSTANCE);
            } catch (Exception e2) {
                e = e2;
                coroutineScope = coroutineScope3;
                if (this.this$0.isDebugEnabled()) {
                    str = this.this$0.tag;
                    LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.device.DeviceWriter$write$2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return e.toString();
                        }
                    }, 6, (Object) null);
                    throw e;
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            coroutineScope = r1;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((DeviceWriter$write$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
