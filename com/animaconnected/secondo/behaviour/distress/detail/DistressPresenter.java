package com.animaconnected.secondo.behaviour.distress.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.animaconnected.secondo.behaviour.distress.DistressProvider;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.behaviour.distress.model.Subject;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.Slot;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.zaa;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.internal.location.zzbp;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: DistressPresenter.kt */
/* loaded from: classes3.dex */
public final class DistressPresenter implements DistressModel.OnChangeListener {

    @SuppressLint({"StaticFieldLeak"})
    private static DistressPresenter sInstance;
    private final Context context;
    private final DistressApi distressApi;
    private final DistressModel distressModel;
    private final DistressProvider distressProvider;
    private DistressView distressView;
    private boolean isLocationOn;
    private int nbrDistressApiInProgress;
    private PermissionCompat.PermissionHelper permissionHelper;
    private Slot slot;
    private boolean uiInProgress;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DistressPresenter";

    /* compiled from: DistressPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DistressPresenter getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DistressPresenter distressPresenter = DistressPresenter.sInstance;
            if (distressPresenter == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                DistressPresenter distressPresenter2 = new DistressPresenter(applicationContext, null);
                DistressPresenter.sInstance = distressPresenter2;
                return distressPresenter2;
            }
            return distressPresenter;
        }

        private Companion() {
        }
    }

    /* compiled from: DistressPresenter.kt */
    /* loaded from: classes3.dex */
    public interface DistressView {
        void error();

        void invitationAvailable(String str);

        void requestLocationPermission();

        void setState(State state);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DistressPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State NO_SAFETY_CONTACT = new State("NO_SAFETY_CONTACT", 0);
        public static final State BUSY = new State("BUSY", 1);
        public static final State WAITING_FOR_REPLY = new State("WAITING_FOR_REPLY", 2);
        public static final State HAS_SAFETY_CONTACT = new State("HAS_SAFETY_CONTACT", 3);

        private static final /* synthetic */ State[] $values() {
            return new State[]{NO_SAFETY_CONTACT, BUSY, WAITING_FOR_REPLY, HAS_SAFETY_CONTACT};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    public /* synthetic */ DistressPresenter(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final Subject fetchSubject() {
        Subject subject = this.distressModel.getSubject();
        if (subject == null) {
            Subject subject2 = new Subject(null, 1, null);
            this.distressModel.setSubject(subject2);
            this.distressModel.save();
            return subject2;
        }
        return subject;
    }

    public static final DistressPresenter getInstance(Context context) {
        return Companion.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void locationPermissionGranted$lambda$0(DistressPresenter this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.isLocationOn = false;
    }

    private final void networkRequestDone() {
        this.nbrDistressApiInProgress--;
        updateState();
    }

    private final String reduceWhiteSpaces(String str) {
        if (str.length() == 0) {
            return str;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.filterNotNull(StringsKt___StringsKt.windowed(StringsKt__StringsKt.trim(str).toString(), 2, 1, false, new Function1<CharSequence, Character>() { // from class: com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$reduceWhiteSpaces$1
            @Override // kotlin.jvm.functions.Function1
            public final Character invoke(CharSequence it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (CharsKt__CharKt.isWhitespace(it.charAt(0)) && CharsKt__CharKt.isWhitespace(it.charAt(1))) {
                    return null;
                }
                return Character.valueOf(it.charAt(0));
            }
        })), "", null, null, null, 62) + StringsKt___StringsKt.last(StringsKt__StringsKt.trim(str).toString());
    }

    private final void updateState() {
        State state;
        if (!this.uiInProgress && this.nbrDistressApiInProgress <= 0) {
            if (this.distressModel.isWaitingForInviteResponse()) {
                state = State.WAITING_FOR_REPLY;
            } else if (this.distressModel.getObserver() == null) {
                state = State.NO_SAFETY_CONTACT;
            } else {
                state = State.HAS_SAFETY_CONTACT;
            }
        } else {
            state = State.BUSY;
        }
        DistressView distressView = this.distressView;
        if (distressView != null) {
            distressView.setState(state);
        }
    }

    public final boolean canGetInvitation() {
        Subject subject = this.distressModel.getSubject();
        if (subject != null && !TextUtils.isEmpty(subject.getFirstName()) && !TextUtils.isEmpty(subject.getPhoneNumber()) && this.isLocationOn) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object cancelInvitation(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$cancelInvitation$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$cancelInvitation$1 r0 = (com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$cancelInvitation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$cancelInvitation$1 r0 = new com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$cancelInvitation$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter r0 = (com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.net.UnknownHostException -> L4e
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r5 = r4.distressApi     // Catch: java.net.UnknownHostException -> L4d
            r0.L$0 = r4     // Catch: java.net.UnknownHostException -> L4d
            r0.label = r3     // Catch: java.net.UnknownHostException -> L4d
            java.lang.Object r5 = r5.cancelInvitation(r0)     // Catch: java.net.UnknownHostException -> L4d
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            com.animaconnected.secondo.behaviour.distress.DistressProvider r5 = r0.distressProvider     // Catch: java.net.UnknownHostException -> L4e
            r5.setNotConfigured()     // Catch: java.net.UnknownHostException -> L4e
            r0.updateState()     // Catch: java.net.UnknownHostException -> L4e
            goto L55
        L4d:
            r0 = r4
        L4e:
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$DistressView r5 = r0.distressView
            if (r5 == 0) goto L55
            r5.error()
        L55:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.cancelInvitation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void cancelInviteSafetyContact() {
        this.uiInProgress = false;
        updateState();
    }

    public final String getObserverFirstLetter() {
        String firstName;
        boolean z;
        Character valueOf;
        String ch;
        Observer observer = this.distressModel.getObserver();
        if (observer != null && (firstName = observer.getFirstName()) != null) {
            if (firstName.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                valueOf = null;
            } else {
                valueOf = Character.valueOf(firstName.charAt(0));
            }
            if (valueOf != null && (ch = valueOf.toString()) != null) {
                return ch;
            }
        }
        return "";
    }

    public final String getObserverName() {
        Observer observer = this.distressModel.getObserver();
        if (observer != null) {
            return observer.getFirstName();
        }
        return null;
    }

    public final String getSubjectName() {
        return fetchSubject().getFirstName();
    }

    public final String getSubjectPhoneNumber() {
        return fetchSubject().getPhoneNumber();
    }

    public final void locationPermissionDenied() {
        this.isLocationOn = false;
    }

    public final void locationPermissionGranted() {
        GoogleApiManager googleApiManager;
        this.isLocationOn = true;
        Object obj = GoogleApiAvailability.zaa;
        Context context = this.context;
        int r2 = LocationServices.$r8$clinit;
        zzbp zzbpVar = new zzbp(context);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(zzbpVar);
        arrayList.addAll(Arrays.asList(new HasApiKey[0]));
        synchronized (GoogleApiManager.zac) {
            Preconditions.checkNotNull(GoogleApiManager.zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = GoogleApiManager.zad;
        }
        googleApiManager.getClass();
        zal zalVar = new zal(arrayList);
        zau zauVar = googleApiManager.zat;
        zauVar.sendMessage(zauVar.obtainMessage(2, zalVar));
        zalVar.zac.zza.onSuccessTask(zaa.zaa).addOnFailureListener(new OnFailureListener() { // from class: com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DistressPresenter.locationPermissionGranted$lambda$0(DistressPresenter.this, exc);
            }
        });
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onChanged() {
        updateState();
    }

    public final void pause() {
        this.distressModel.removeOnChangeListener(this);
        this.slot = Slot.Unknown;
        this.permissionHelper = null;
        this.distressView = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5 A[Catch: all -> 0x00c0, Exception -> 0x00c3, TRY_LEAVE, TryCatch #8 {Exception -> 0x00c3, all -> 0x00c0, blocks: (B:15:0x0094, B:17:0x00a5), top: B:14:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #7 {all -> 0x002f, blocks: (B:12:0x002a, B:25:0x00cb, B:27:0x00d6), top: B:11:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestInvitation(kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.requestInvitation(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void resume(DistressView distressView, PermissionCompat.PermissionHelper permissionHelper, Slot distressFragmentSlot) {
        Intrinsics.checkNotNullParameter(distressFragmentSlot, "distressFragmentSlot");
        this.distressView = distressView;
        this.permissionHelper = permissionHelper;
        this.slot = distressFragmentSlot;
        this.distressModel.addOnChangeListener(this);
        updateState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #1 {all -> 0x002b, blocks: (B:12:0x0027, B:13:0x004e, B:19:0x0065, B:21:0x0069), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendRemove(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1 r0 = (com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1 r0 = new com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$sendRemove$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter r0 = (com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            goto L4e
        L2b:
            r5 = move-exception
            goto L79
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            int r5 = r4.nbrDistressApiInProgress
            int r5 = r5 + r3
            r4.nbrDistressApiInProgress = r5
            r4.updateState()
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r5 = r4.distressApi     // Catch: java.lang.Throwable -> L61 java.net.UnknownHostException -> L64
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L61 java.net.UnknownHostException -> L64
            r0.label = r3     // Catch: java.lang.Throwable -> L61 java.net.UnknownHostException -> L64
            java.lang.Object r5 = r5.removeObserver(r0)     // Catch: java.lang.Throwable -> L61 java.net.UnknownHostException -> L64
            if (r5 != r1) goto L4d
            return r1
        L4d:
            r0 = r4
        L4e:
            com.animaconnected.secondo.behaviour.distress.DistressProvider r5 = r0.distressProvider     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            r5.setNotConfigured()     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r0.distressModel     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            r1 = 0
            r5.setObserver(r1)     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r0.distressModel     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r1 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Registered     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            r5.setState(r1)     // Catch: java.lang.Throwable -> L2b java.net.UnknownHostException -> L65
            goto L6c
        L61:
            r5 = move-exception
            r0 = r4
            goto L79
        L64:
            r0 = r4
        L65:
            com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter$DistressView r5 = r0.distressView     // Catch: java.lang.Throwable -> L2b
            if (r5 == 0) goto L6c
            r5.error()     // Catch: java.lang.Throwable -> L2b
        L6c:
            com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion r5 = com.animaconnected.secondo.behaviour.distress.service.DistressService.Companion
            android.content.Context r1 = r0.context
            r5.stop(r1)
            r0.networkRequestDone()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L79:
            com.animaconnected.secondo.behaviour.distress.service.DistressService$Companion r1 = com.animaconnected.secondo.behaviour.distress.service.DistressService.Companion
            android.content.Context r2 = r0.context
            r1.stop(r2)
            r0.networkRequestDone()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.detail.DistressPresenter.sendRemove(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setSubjectName(String str) {
        if (str != null) {
            fetchSubject().setFirstName(reduceWhiteSpaces(str));
        }
    }

    public final void setSubjectPhoneNumber(String str) {
        if (str != null) {
            fetchSubject().setPhoneNumber(str);
        }
    }

    public final void startInviteSafetyContact() {
        this.uiInProgress = true;
        updateState();
        if (PermissionCompat.isPermissionGranted(this.context, "android.permission.ACCESS_COARSE_LOCATION")) {
            locationPermissionGranted();
            return;
        }
        DistressView distressView = this.distressView;
        if (distressView != null) {
            distressView.requestLocationPermission();
        }
    }

    private DistressPresenter(Context context) {
        this.context = context;
        this.distressProvider = ProviderFactory.getDistressProvider();
        this.distressModel = DistressModel.Companion.getInstance(context);
        this.distressApi = DistressApi.Companion.getInstance(context);
        this.slot = Slot.Unknown;
    }

    @Override // com.animaconnected.secondo.behaviour.distress.model.DistressModel.OnChangeListener
    public void onMissingObserver() {
    }
}
