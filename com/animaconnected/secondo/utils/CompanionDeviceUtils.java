package com.animaconnected.secondo.utils;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.companion.CompanionDeviceManager$Callback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Handler;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline17;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline22;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline23;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline27;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.notification.receiver.NotificationReceiver;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: CompanionDeviceUtils.kt */
/* loaded from: classes3.dex */
public final class CompanionDeviceUtils {
    public static final int $stable = 0;
    public static final CompanionDeviceUtils INSTANCE = new CompanionDeviceUtils();

    private CompanionDeviceUtils() {
    }

    private final CompanionDeviceManager getDeviceManager(Context context) {
        CompanionDeviceManager m;
        if (Build.VERSION.SDK_INT < 33 || (m = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline27.m(context.getSystemService(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m()))) == null) {
            return null;
        }
        return m;
    }

    @SuppressLint({"NewApi"})
    public final Object associateDevice(Context context, String str, final Function2<? super IntentSender, ? super Function1<? super Intent, Unit>, Unit> function2, Continuation<? super Boolean> continuation) {
        BluetoothDeviceFilter.Builder address;
        BluetoothDeviceFilter build;
        AssociationRequest.Builder deviceProfile;
        AssociationRequest.Builder addDeviceFilter;
        AssociationRequest.Builder singleDevice;
        AssociationRequest build2;
        final CompanionDeviceManager deviceManager = getDeviceManager(context);
        if (deviceManager == null) {
            return Boolean.TRUE;
        }
        Boolean isDeviceAssociated = isDeviceAssociated(context, str);
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(isDeviceAssociated, bool)) {
            address = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline22.m().setAddress(str);
            build = address.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            deviceProfile = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline23.m().setDeviceProfile("android.app.role.COMPANION_DEVICE_WATCH");
            addDeviceFilter = deviceProfile.addDeviceFilter(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline17.m(build));
            singleDevice = addDeviceFilter.setSingleDevice(true);
            build2 = singleDevice.build();
            Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            cancellableContinuationImpl.initCancellability();
            deviceManager.associate(build2, new CompanionDeviceManager$Callback() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$associateDevice$2$1
                public void onDeviceFound(final IntentSender intentSender) {
                    Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                    LogKt.info$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$associateDevice$2$1$onDeviceFound$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "requestAssociation: Device found " + intentSender;
                        }
                    }, 7, (Object) null);
                    try {
                        Function2<IntentSender, Function1<? super Intent, Unit>, Unit> function22 = function2;
                        final CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl;
                        final CompanionDeviceManager companionDeviceManager = deviceManager;
                        function22.invoke(intentSender, new Function1<Intent, Unit>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$associateDevice$2$1$onDeviceFound$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                                invoke2(intent);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Intent intent) {
                                BluetoothDevice bluetoothDevice = intent != null ? (BluetoothDevice) intent.getParcelableExtra("android.companion.extra.DEVICE") : null;
                                if (bluetoothDevice == null) {
                                    cancellableContinuation.resumeWith(Boolean.FALSE);
                                    return;
                                }
                                final String address2 = bluetoothDevice.getAddress();
                                LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$associateDevice$2$1$onDeviceFound$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Associate success for address: " + address2;
                                    }
                                }, 7, (Object) null);
                                companionDeviceManager.startObservingDevicePresence(address2);
                                cancellableContinuation.resumeWith(Boolean.TRUE);
                            }
                        });
                    } catch (IntentSender.SendIntentException e) {
                        cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                        e.printStackTrace();
                    }
                }

                public void onFailure(final CharSequence charSequence) {
                    LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$associateDevice$2$1$onFailure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "onFailure " + ((Object) charSequence);
                        }
                    }, 7, (Object) null);
                    cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                }
            }, (Handler) null);
            Object result = cancellableContinuationImpl.getResult();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return result;
        }
        return bool;
    }

    @SuppressLint({"NewApi"})
    public final void disassociate(Context context, final String address) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        CompanionDeviceManager deviceManager = getDeviceManager(context);
        if (deviceManager != null) {
            deviceManager.disassociate(address);
        }
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$disassociate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "disassociate for address: " + address;
            }
        }, 7, (Object) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:            r0 = r0.getAssociations();     */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit disassociateAllDevices(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.companion.CompanionDeviceManager r0 = r3.getDeviceManager(r4)
            if (r0 == 0) goto L2f
            java.util.List r0 = com.animaconnected.secondo.utils.CompanionDeviceUtils$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r0 == 0) goto L2f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.animaconnected.secondo.utils.CompanionDeviceUtils r2 = com.animaconnected.secondo.utils.CompanionDeviceUtils.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2.disassociate(r4, r1)
            goto L17
        L2c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L30
        L2f:
            r4 = 0
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.CompanionDeviceUtils.disassociateAllDevices(android.content.Context):kotlin.Unit");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:            r2 = r2.getAssociations();     */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasAssociatedDevice(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            android.companion.CompanionDeviceManager r2 = r1.getDeviceManager(r2)
            if (r2 == 0) goto L1a
            java.util.List r2 = com.animaconnected.secondo.utils.CompanionDeviceUtils$$ExternalSyntheticApiModelOutline0.m(r2)
            if (r2 == 0) goto L1a
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            goto L1b
        L1a:
            r2 = 0
        L1b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.CompanionDeviceUtils.hasAssociatedDevice(android.content.Context):boolean");
    }

    @SuppressLint({"NewApi"})
    public final boolean hasNotificationAccess(Context context) {
        CompanionDeviceManager deviceManager;
        boolean hasNotificationAccess;
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasAssociatedDevice(context) && (deviceManager = getDeviceManager(context)) != null) {
            hasNotificationAccess = deviceManager.hasNotificationAccess(new ComponentName(context, (Class<?>) NotificationReceiver.class));
            return hasNotificationAccess;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:            r2 = r2.getAssociations();     */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean isDeviceAssociated(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.companion.CompanionDeviceManager r2 = r1.getDeviceManager(r2)
            if (r2 == 0) goto L1f
            java.util.List r2 = com.animaconnected.secondo.utils.CompanionDeviceUtils$$ExternalSyntheticApiModelOutline0.m(r2)
            if (r2 == 0) goto L1f
            boolean r2 = r2.contains(r3)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L20
        L1f:
            r2 = 0
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.CompanionDeviceUtils.isDeviceAssociated(android.content.Context, java.lang.String):java.lang.Boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:            r3 = r3.getAssociations();     */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isLastAssociatedDevice(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.companion.CompanionDeviceManager r3 = r2.getDeviceManager(r3)
            r0 = 0
            if (r3 == 0) goto L1a
            java.util.List r3 = com.animaconnected.secondo.utils.CompanionDeviceUtils$$ExternalSyntheticApiModelOutline0.m(r3)
            if (r3 == 0) goto L1a
            int r3 = r3.size()
            r1 = 1
            if (r3 != r1) goto L1a
            r0 = r1
        L1a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.CompanionDeviceUtils.isLastAssociatedDevice(android.content.Context):boolean");
    }

    @SuppressLint({"NewApi"})
    public final void requestNotificationAccess(Context context) {
        CompanionDeviceManager deviceManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasAssociatedDevice(context) && (deviceManager = getDeviceManager(context)) != null) {
            deviceManager.requestNotificationAccess(new ComponentName(context, (Class<?>) NotificationReceiver.class));
        }
    }

    @SuppressLint({"NewApi"})
    public final void startObservingDevicePresence(Context context, List<String> addresses) {
        List associations;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        CompanionDeviceManager deviceManager = getDeviceManager(context);
        if (deviceManager == null) {
            return;
        }
        for (final String str : addresses) {
            associations = deviceManager.getAssociations();
            if (associations.contains(str)) {
                LogKt.debug$default((Object) INSTANCE, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.CompanionDeviceUtils$startObservingDevicePresence$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Start observing " + str;
                    }
                }, 7, (Object) null);
                deviceManager.startObservingDevicePresence(str);
            }
        }
    }
}
