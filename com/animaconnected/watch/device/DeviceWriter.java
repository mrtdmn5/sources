package com.animaconnected.watch.device;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.msgpack.MsgPackCreator;
import com.animaconnected.watch.DispatchersKt;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DeviceWriter.kt */
/* loaded from: classes3.dex */
public final class DeviceWriter {
    private final CommandCenter commandCenter;
    private final WatchBackend device;
    private boolean isDebugEnabled;
    private boolean logBytes;
    private final MsgPackCreator msgPackCreator;
    private final String tag;

    public DeviceWriter(WatchBackend device, CommandCenter commandCenter, MsgPackCreator msgPackCreator, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(commandCenter, "commandCenter");
        Intrinsics.checkNotNullParameter(msgPackCreator, "msgPackCreator");
        this.device = device;
        this.commandCenter = commandCenter;
        this.msgPackCreator = msgPackCreator;
        this.isDebugEnabled = z;
        this.tag = "DeviceWriter";
    }

    private final Command createCommand(String str, int r3, MsgPack msgPack) {
        if (r3 >= 0) {
            return new Command(str, msgPack, msgPack.toMsgPackBytes());
        }
        throw new Exception(ConstraintSet$$ExternalSyntheticOutline0.m("No such command found: ", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Command createReadCommand(String str, Object[] objArr) {
        boolean z;
        MsgPack newArray;
        int commandNumber$watch_release = this.commandCenter.getCommandNumber$watch_release(str);
        if (objArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            newArray = this.msgPackCreator.newInt(commandNumber$watch_release);
        } else {
            newArray = this.msgPackCreator.newArray(new Serializable[]{Integer.valueOf(commandNumber$watch_release), objArr});
        }
        return createCommand(str, commandNumber$watch_release, newArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MsgPack unpackReceivedValue(byte[] bArr) {
        boolean z;
        if (bArr != null) {
            if (bArr.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.msgPackCreator.newEmpty();
            }
        }
        MsgPackCreator msgPackCreator = this.msgPackCreator;
        Intrinsics.checkNotNull(bArr);
        return msgPackCreator.fromBytes(bArr);
    }

    public final Command createWriteCommand(String name, MsgPack value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        int commandNumber$watch_release = this.commandCenter.getCommandNumber$watch_release(name);
        return createCommand(name, commandNumber$watch_release, this.msgPackCreator.newIntMap(MapsKt__MapsJVMKt.mapOf(new Pair(Integer.valueOf(commandNumber$watch_release), value))));
    }

    public final boolean isDebugEnabled() {
        return this.isDebugEnabled;
    }

    public final Object read(String str, Object[] objArr, Continuation<? super MsgPack> continuation) {
        return BuildersKt.withContext(DispatchersKt.ioDispatcher(), new DeviceWriter$read$2(this, str, objArr, null), continuation);
    }

    public final void setDebugEnabled(boolean z) {
        this.isDebugEnabled = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* renamed from: write-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1065write0E7RQCE(java.lang.String r6, com.animaconnected.msgpack.MsgPack r7, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.device.DeviceWriter$write$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.device.DeviceWriter$write$1 r0 = (com.animaconnected.watch.device.DeviceWriter$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.device.DeviceWriter$write$1 r0 = new com.animaconnected.watch.device.DeviceWriter$write$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = com.animaconnected.watch.DispatchersKt.ioDispatcher()
            com.animaconnected.watch.device.DeviceWriter$write$2 r2 = new com.animaconnected.watch.device.DeviceWriter$write$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.value
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.DeviceWriter.m1065write0E7RQCE(java.lang.String, com.animaconnected.msgpack.MsgPack, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ DeviceWriter(WatchBackend watchBackend, CommandCenter commandCenter, MsgPackCreator msgPackCreator, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(watchBackend, commandCenter, msgPackCreator, (r5 & 8) != 0 ? false : z);
    }
}
