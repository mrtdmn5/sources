package com.animaconnected.bluetooth.gatt.rxtwo;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: BondHelper.kt */
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public final class BondHelper {
    private final String TAG;
    private final BluetoothDevice bluetoothDevice;
    private final Context context;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BondHelper.kt */
    /* loaded from: classes.dex */
    public static final class Result {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Result[] $VALUES;
        public static final Result AlreadyInState = new Result("AlreadyInState", 0);
        public static final Result Success = new Result("Success", 1);
        public static final Result Failed = new Result("Failed", 2);

        private static final /* synthetic */ Result[] $values() {
            return new Result[]{AlreadyInState, Success, Failed};
        }

        static {
            Result[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Result(String str, int r2) {
        }

        public static EnumEntries<Result> getEntries() {
            return $ENTRIES;
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    public BondHelper(Context context, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
        this.context = context;
        this.bluetoothDevice = bluetoothDevice;
        this.TAG = "BondHelper";
    }

    private final Object bond$$forInline(Continuation<? super Result> continuation) {
        Object obj;
        NonCancellable nonCancellable;
        BondHelper$setState$3 bondHelper$setState$3;
        if (getBluetoothDevice().getBondState() == 12) {
            LogKt.debug$default((Object) this, "AlreadyInState: 12", getTAG(), (Throwable) null, true, 4, (Object) null);
            return Result.AlreadyInState;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        try {
            try {
                obj = TimeoutKt.withTimeout(30000L, new BondHelper$bond$$inlined$setState$1(this, ref$ObjectRef, 12, null, this), continuation);
                nonCancellable = NonCancellable.INSTANCE;
                bondHelper$setState$3 = new BondHelper$setState$3(ref$ObjectRef, this, null);
            } catch (TimeoutCancellationException unused) {
                LogKt.debug$default((Object) this, "Failed to reach state, timeout", getTAG(), (Throwable) null, true, 4, (Object) null);
                obj = Result.Failed;
                nonCancellable = NonCancellable.INSTANCE;
                bondHelper$setState$3 = new BondHelper$setState$3(ref$ObjectRef, this, null);
            }
            BuildersKt.withContext(nonCancellable, bondHelper$setState$3, continuation);
            return obj;
        } catch (Throwable th) {
            BuildersKt.withContext(NonCancellable.INSTANCE, new BondHelper$setState$3(ref$ObjectRef, this, null), continuation);
            throw th;
        }
    }

    private final Object removeBond$$forInline(Continuation<? super Result> continuation) {
        Object obj;
        NonCancellable nonCancellable;
        BondHelper$setState$3 bondHelper$setState$3;
        if (getBluetoothDevice().getBondState() == 10) {
            LogKt.debug$default((Object) this, "AlreadyInState: 10", getTAG(), (Throwable) null, true, 4, (Object) null);
            return Result.AlreadyInState;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        try {
            try {
                obj = TimeoutKt.withTimeout(30000L, new BondHelper$removeBond$$inlined$setState$1(this, ref$ObjectRef, 10, null, this), continuation);
                nonCancellable = NonCancellable.INSTANCE;
                bondHelper$setState$3 = new BondHelper$setState$3(ref$ObjectRef, this, null);
            } catch (TimeoutCancellationException unused) {
                LogKt.debug$default((Object) this, "Failed to reach state, timeout", getTAG(), (Throwable) null, true, 4, (Object) null);
                obj = Result.Failed;
                nonCancellable = NonCancellable.INSTANCE;
                bondHelper$setState$3 = new BondHelper$setState$3(ref$ObjectRef, this, null);
            }
            BuildersKt.withContext(nonCancellable, bondHelper$setState$3, continuation);
            return obj;
        } catch (Throwable th) {
            BuildersKt.withContext(NonCancellable.INSTANCE, new BondHelper$setState$3(ref$ObjectRef, this, null), continuation);
            throw th;
        }
    }

    private final Object setState$$forInline(int r11, Function0<Boolean> function0, Continuation<? super Result> continuation) {
        if (getBluetoothDevice().getBondState() == r11) {
            LogKt.debug$default((Object) this, SubMenuBuilder$$ExternalSyntheticOutline0.m("AlreadyInState: ", r11), getTAG(), (Throwable) null, true, 4, (Object) null);
            return Result.AlreadyInState;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        try {
            return TimeoutKt.withTimeout(30000L, new BondHelper$setState$2(function0, this, ref$ObjectRef, r11, null), continuation);
        } catch (TimeoutCancellationException unused) {
            LogKt.debug$default((Object) this, "Failed to reach state, timeout", getTAG(), (Throwable) null, true, 4, (Object) null);
            return Result.Failed;
        } finally {
            BuildersKt.withContext(NonCancellable.INSTANCE, new BondHelper$setState$3(ref$ObjectRef, this, null), continuation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object bond(kotlin.coroutines.Continuation<? super com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.Result> r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.bond(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final boolean isBonded() {
        try {
            if (this.bluetoothDevice.getBondState() != 12) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeBond(kotlin.coroutines.Continuation<? super com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.Result> r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.removeBond(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setState(int r23, kotlin.jvm.functions.Function0<java.lang.Boolean> r24, kotlin.coroutines.Continuation<? super com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.Result> r25) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.BondHelper.setState(int, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
