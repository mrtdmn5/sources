package com.animaconnected.secondo.screens.debugsettings;

import android.companion.AssociationInfo;
import android.companion.AssociationRequest;
import android.companion.BluetoothDeviceFilter;
import android.companion.CompanionDeviceManager;
import android.companion.CompanionDeviceManager$Callback;
import android.content.IntentSender;
import android.net.MacAddress;
import android.os.Build;
import android.os.Handler;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline17;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline22;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline23;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26;
import androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline27;
import androidx.fragment.app.FragmentActivity;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DebugCompanionDevice.kt */
/* loaded from: classes3.dex */
public final class DebugCompanionDevice {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final DebugCompanionDevice$callback$1 callback;
    private final CompanionDeviceManager manager;
    private final String tag;

    /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$callback$1] */
    public DebugCompanionDevice(FragmentActivity activity) {
        CompanionDeviceManager companionDeviceManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        if (Build.VERSION.SDK_INT >= 26) {
            companionDeviceManager = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline27.m(activity.getSystemService(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline26.m()));
        } else {
            companionDeviceManager = null;
        }
        this.manager = companionDeviceManager;
        this.callback = new CompanionDeviceManager$Callback() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$callback$1
            public void onDeviceFound(final IntentSender intentSender) {
                String str;
                FragmentActivity fragmentActivity;
                Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                str = DebugCompanionDevice.this.tag;
                LogKt.info$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$callback$1$onDeviceFound$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onDeviceFound: " + intentSender;
                    }
                }, 6, (Object) null);
                try {
                    fragmentActivity = DebugCompanionDevice.this.activity;
                    fragmentActivity.startIntentSenderForResult(intentSender, 1337, null, 0, 0, 0);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(final CharSequence charSequence) {
                String str;
                str = DebugCompanionDevice.this.tag;
                LogKt.warn$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$callback$1$onFailure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onFailure: " + ((Object) charSequence);
                    }
                }, 6, (Object) null);
            }
        };
        this.tag = "DebugCompanionDevice";
    }

    private final AssociationRequest createAssociationRequest(String str) {
        BluetoothDeviceFilter.Builder address;
        BluetoothDeviceFilter build;
        AssociationRequest.Builder addDeviceFilter;
        AssociationRequest.Builder deviceProfile;
        AssociationRequest.Builder singleDevice;
        AssociationRequest.Builder displayName;
        AssociationRequest build2;
        address = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline22.m().setAddress(str);
        build = address.build();
        addDeviceFilter = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline23.m().addDeviceFilter(ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline17.m(build));
        deviceProfile = addDeviceFilter.setDeviceProfile("android.app.role.COMPANION_DEVICE_WATCH");
        singleDevice = deviceProfile.setSingleDevice(true);
        displayName = singleDevice.setDisplayName("Fancy " + str);
        build2 = displayName.build();
        Intrinsics.checkNotNullExpressionValue(build2, "let(...)");
        return build2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:            r0 = r0.getMyAssociations();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void logAssociationDetails() {
        /*
            r10 = this;
            android.companion.CompanionDeviceManager r0 = r10.manager
            if (r0 == 0) goto L2a
            java.util.List r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r0 != 0) goto Lb
            goto L2a
        Lb:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.lang.String r2 = "\n"
            r0 = 0
            r4 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1 r5 = new kotlin.jvm.functions.Function1<android.companion.AssociationInfo, java.lang.CharSequence>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1
                static {
                    /*
                        com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1) com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1.INSTANCE com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.CharSequence invoke(android.companion.AssociationInfo r1) {
                    /*
                        r0 = this;
                        android.companion.AssociationInfo r1 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline5.m(r1)
                        java.lang.CharSequence r1 = r0.invoke2(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1.invoke(java.lang.Object):java.lang.Object");
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:            r0 = r0.toString();     */
                /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:            r2 = r2.toOuiString();     */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.CharSequence invoke2(android.companion.AssociationInfo r5) {
                    /*
                        r4 = this;
                        android.net.MacAddress r0 = com.animaconnected.secondo.app.CompanionService$onDeviceAppeared$2$$ExternalSyntheticApiModelOutline0.m(r5)
                        java.lang.String r1 = "N/A"
                        if (r0 == 0) goto Le
                        java.lang.String r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1$$ExternalSyntheticApiModelOutline0.m(r0)
                        if (r0 != 0) goto Lf
                    Le:
                        r0 = r1
                    Lf:
                        android.net.MacAddress r2 = com.animaconnected.secondo.app.CompanionService$onDeviceAppeared$2$$ExternalSyntheticApiModelOutline0.m(r5)
                        if (r2 == 0) goto L1d
                        java.lang.String r2 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1$$ExternalSyntheticApiModelOutline1.m(r2)
                        if (r2 != 0) goto L1c
                        goto L1d
                    L1c:
                        r1 = r2
                    L1d:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "Device MAC Address: "
                        r2.<init>(r3)
                        r2.append(r0)
                        java.lang.String r0 = ", OUI String: "
                        r2.append(r0)
                        r2.append(r1)
                        java.lang.String r0 = ", Association: "
                        r2.append(r0)
                        r2.append(r5)
                        java.lang.String r5 = r2.toString()
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$info$1.invoke2(android.companion.AssociationInfo):java.lang.CharSequence");
                }
            }
            r6 = 30
            r3 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6)
            java.lang.String r4 = r10.tag
            r6 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$1 r7 = new com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$logAssociationDetails$1
            r7.<init>()
            r8 = 6
            r9 = 0
            r3 = r10
            r5 = r0
            com.animaconnected.logger.LogKt.info$default(r3, r4, r5, r6, r7, r8, r9)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice.logAssociationDetails():void");
    }

    private final boolean matchesWatchIdentifier(AssociationInfo associationInfo) {
        MacAddress deviceMacAddress;
        deviceMacAddress = associationInfo.getDeviceMacAddress();
        return StringsKt__StringsJVMKt.equals(String.valueOf(deviceMacAddress), ProviderFactory.getWatch().getWatch().getIdentifier());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:            r0 = r0.getMyAssociations();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAssociated() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 0
            if (r0 < r1) goto L40
            android.companion.CompanionDeviceManager r0 = r3.manager
            if (r0 == 0) goto L3d
            java.util.List r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r0 == 0) goto L3d
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L21
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L21
            goto L3d
        L21:
            java.util.Iterator r0 = r0.iterator()
        L25:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r0.next()
            android.companion.AssociationInfo r1 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline5.m(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r3.matchesWatchIdentifier(r1)
            if (r1 == 0) goto L25
            r2 = 1
        L3d:
            r3.logAssociationDetails()
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice.isAssociated():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:            r0 = r0.getMyAssociations();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeAssociation() {
        /*
            r8 = this;
            android.companion.CompanionDeviceManager r0 = r8.manager
            if (r0 == 0) goto L47
            java.util.List r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline0.m(r0)
            if (r0 == 0) goto L47
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L10:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L28
            java.lang.Object r1 = r0.next()
            android.companion.AssociationInfo r2 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline5.m(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r2 = r8.matchesWatchIdentifier(r2)
            if (r2 == 0) goto L10
            goto L29
        L28:
            r1 = 0
        L29:
            android.companion.AssociationInfo r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline5.m(r1)
            if (r0 == 0) goto L47
            int r0 = com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline6.m(r0)
            java.lang.String r2 = r8.tag
            r3 = 0
            r4 = 0
            com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$removeAssociation$1 r5 = new com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$removeAssociation$1
            r5.<init>()
            r6 = 6
            r7 = 0
            r1 = r8
            com.animaconnected.logger.LogKt.info$default(r1, r2, r3, r4, r5, r6, r7)
            android.companion.CompanionDeviceManager r1 = r8.manager
            com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice$$ExternalSyntheticApiModelOutline7.m(r1, r0)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugCompanionDevice.removeAssociation():void");
    }

    public final void requestAssociation() {
        String identifier = ProviderFactory.getWatch().getWatch().getIdentifier();
        AssociationRequest createAssociationRequest = createAssociationRequest(identifier);
        CompanionDeviceManager companionDeviceManager = this.manager;
        if (companionDeviceManager != null) {
            companionDeviceManager.associate(createAssociationRequest, this.callback, (Handler) null);
        }
        CompanionDeviceManager companionDeviceManager2 = this.manager;
        if (companionDeviceManager2 != null) {
            companionDeviceManager2.startObservingDevicePresence(identifier);
        }
    }

    private static /* synthetic */ void getCallback$annotations() {
    }
}
