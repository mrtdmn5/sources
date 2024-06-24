package com.animaconnected.watch.device;

import com.animaconnected.msgpack.MsgPack;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceWriter.kt */
@DebugMetadata(c = "com.animaconnected.watch.device.DeviceWriter$read$2", f = "DeviceWriter.kt", l = {34}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DeviceWriter$read$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MsgPack>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ Object[] $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DeviceWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceWriter$read$2(DeviceWriter deviceWriter, String str, Object[] objArr, Continuation<? super DeviceWriter$read$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceWriter;
        this.$name = str;
        this.$params = objArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceWriter$read$2 deviceWriter$read$2 = new DeviceWriter$read$2(this.this$0, this.$name, this.$params, continuation);
        deviceWriter$read$2.L$0 = obj;
        return deviceWriter$read$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.DeviceWriter$read$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MsgPack> continuation) {
        return ((DeviceWriter$read$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
