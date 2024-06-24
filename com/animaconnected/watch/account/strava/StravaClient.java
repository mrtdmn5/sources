package com.animaconnected.watch.account.strava;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: StravaClient.kt */
/* loaded from: classes3.dex */
public final class StravaClient {
    public static final Companion Companion = new Companion(null);
    public static final String tag = "StravaClient";
    private final MutableStateFlow<Boolean> _isConnected;
    private final StravaAuth auth;
    private final StravaHttpClient client;
    private final FitnessQueries db;
    private final Function0<HistoryDeviceId> getIdentifier;
    private boolean isHttpLoggingEnabled;
    private final Mutex refreshTokenMutex;
    private final StravaStorage storage;
    private final Mutex uploadSessionMutex;

    /* compiled from: StravaClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: StravaClient.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[UploadStatus.values().length];
            try {
                r0[UploadStatus.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[UploadStatus.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public StravaClient(StravaAuth auth, FitnessQueries db, Function0<HistoryDeviceId> getIdentifier) {
        boolean z;
        Intrinsics.checkNotNullParameter(auth, "auth");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(getIdentifier, "getIdentifier");
        this.auth = auth;
        this.db = db;
        this.getIdentifier = getIdentifier;
        this.refreshTokenMutex = MutexKt.Mutex$default();
        this.uploadSessionMutex = MutexKt.Mutex$default();
        StravaStorage stravaStorage = new StravaStorage();
        this.storage = stravaStorage;
        this.client = new StravaHttpClient(new StravaClient$client$1(this, null), new Function0<Boolean>() { // from class: com.animaconnected.watch.account.strava.StravaClient$client$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(StravaClient.this.isHttpLoggingEnabled());
            }
        });
        if (stravaStorage.getAccessToken() != null) {
            z = true;
        } else {
            z = false;
        }
        this._isConnected = StateFlowKt.MutableStateFlow(Boolean.valueOf(z));
    }

    private final boolean areScopesValid(String str) {
        List split$default = StringsKt__StringsKt.split$default(this.client.getScope(), new String[]{","}, 0, 6);
        List split$default2 = StringsKt__StringsKt.split$default(str, new String[]{","}, 0, 6);
        List list = split$default;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!split$default2.contains((String) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void deleteTokens() {
        Boolean value;
        this.storage.deleteToken();
        MutableStateFlow<Boolean> mutableStateFlow = this._isConnected;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.FALSE));
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.StravaClient$deleteTokens$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Access has been revoked. The stored tokens has been deleted.";
            }
        }, 6, (Object) null);
    }

    private final WatchLibResult<Boolean, WatchLibException> onUploadDelete(Session session, Upload upload) {
        this.db.m1290deleteStravaPendingUploadcu7zPM(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs());
        return StravaFailureResponse.INSTANCE.upload(upload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onUploadError(com.animaconnected.watch.fitness.Session r5, com.animaconnected.watch.account.strava.Upload r6, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.account.strava.StravaClient$onUploadError$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.account.strava.StravaClient$onUploadError$1 r0 = (com.animaconnected.watch.account.strava.StravaClient$onUploadError$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaClient$onUploadError$1 r0 = new com.animaconnected.watch.account.strava.StravaClient$onUploadError$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.animaconnected.watch.fitness.Session r5 = (com.animaconnected.watch.fitness.Session) r5
            java.lang.Object r6 = r0.L$0
            com.animaconnected.watch.account.strava.StravaClient r6 = (com.animaconnected.watch.account.strava.StravaClient) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L57
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = com.animaconnected.watch.account.strava.UploadKt.isDuplicate(r6)
            if (r7 == 0) goto L45
            com.animaconnected.watch.utils.WatchLibResult r5 = r4.onUploadDelete(r5, r6)
            return r5
        L45:
            com.animaconnected.watch.account.strava.StravaActivity r6 = com.animaconnected.watch.account.strava.StravaActivityKt.toStravaActivity(r5)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r4.uploadActivity(r6, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r6 = r4
        L57:
            com.animaconnected.watch.account.strava.StravaResult r7 = (com.animaconnected.watch.account.strava.StravaResult) r7
            boolean r0 = r7 instanceof com.animaconnected.watch.account.strava.StravaResult.Success
            if (r0 == 0) goto L62
            com.animaconnected.watch.utils.WatchLibResult r5 = r6.onUploadReady(r5)
            goto L72
        L62:
            boolean r5 = r7 instanceof com.animaconnected.watch.account.strava.StravaResult.Failure
            if (r5 == 0) goto L73
            com.animaconnected.watch.account.strava.StravaFailureResponse r5 = com.animaconnected.watch.account.strava.StravaFailureResponse.INSTANCE
            com.animaconnected.watch.account.strava.StravaResult$Failure r7 = (com.animaconnected.watch.account.strava.StravaResult.Failure) r7
            java.lang.Exception r6 = r7.getException()
            com.animaconnected.watch.utils.WatchLibResult$Failure r5 = r5.upload(r6)
        L72:
            return r5
        L73:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.onUploadError(com.animaconnected.watch.fitness.Session, com.animaconnected.watch.account.strava.Upload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final WatchLibResult<Boolean, WatchLibException> onUploadReady(Session session) {
        this.db.m1290deleteStravaPendingUploadcu7zPM(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs());
        return new WatchLibResult.Success(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01b7 -> B:13:0x01bc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object pollStatus(com.animaconnected.watch.account.strava.Upload r26, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.strava.StravaResult<com.animaconnected.watch.account.strava.Upload>> r27) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.pollStatus(com.animaconnected.watch.account.strava.Upload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processUpload(com.animaconnected.watch.account.strava.Upload r13, com.animaconnected.watch.fitness.Session r14, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.account.strava.StravaClient$processUpload$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.account.strava.StravaClient$processUpload$1 r0 = (com.animaconnected.watch.account.strava.StravaClient$processUpload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaClient$processUpload$1 r0 = new com.animaconnected.watch.account.strava.StravaClient$processUpload$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L8d
        L2a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L32:
            java.lang.Object r13 = r0.L$1
            r14 = r13
            com.animaconnected.watch.fitness.Session r14 = (com.animaconnected.watch.fitness.Session) r14
            java.lang.Object r13 = r0.L$0
            com.animaconnected.watch.account.strava.StravaClient r13 = (com.animaconnected.watch.account.strava.StravaClient) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L50
        L3f:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r12
            r0.L$1 = r14
            r0.label = r4
            java.lang.Object r15 = r12.pollStatus(r13, r0)
            if (r15 != r1) goto L4f
            return r1
        L4f:
            r13 = r12
        L50:
            com.animaconnected.watch.account.strava.StravaResult r15 = (com.animaconnected.watch.account.strava.StravaResult) r15
            boolean r2 = r15 instanceof com.animaconnected.watch.account.strava.StravaResult.Success
            if (r2 == 0) goto L9f
            com.animaconnected.watch.account.strava.StravaResult$Success r15 = (com.animaconnected.watch.account.strava.StravaResult.Success) r15
            java.lang.Object r2 = r15.getResult()
            com.animaconnected.watch.account.strava.Upload r2 = (com.animaconnected.watch.account.strava.Upload) r2
            com.animaconnected.watch.account.strava.UploadStatus r2 = com.animaconnected.watch.account.strava.UploadKt.statusAsEnum(r2)
            int[] r5 = com.animaconnected.watch.account.strava.StravaClient.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r4) goto L8e
            if (r2 == r3) goto L79
            java.lang.Object r15 = r15.getResult()
            com.animaconnected.watch.account.strava.Upload r15 = (com.animaconnected.watch.account.strava.Upload) r15
            com.animaconnected.watch.utils.WatchLibResult r13 = r13.onUploadDelete(r14, r15)
            goto Laf
        L79:
            java.lang.Object r15 = r15.getResult()
            com.animaconnected.watch.account.strava.Upload r15 = (com.animaconnected.watch.account.strava.Upload) r15
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r15 = r13.onUploadError(r14, r15, r0)
            if (r15 != r1) goto L8d
            return r1
        L8d:
            return r15
        L8e:
            java.lang.String r6 = "StravaClient"
            r7 = 0
            r8 = 0
            com.animaconnected.watch.account.strava.StravaClient$processUpload$2 r9 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.account.strava.StravaClient$processUpload$2
                static {
                    /*
                        com.animaconnected.watch.account.strava.StravaClient$processUpload$2 r0 = new com.animaconnected.watch.account.strava.StravaClient$processUpload$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.account.strava.StravaClient$processUpload$2) com.animaconnected.watch.account.strava.StravaClient$processUpload$2.INSTANCE com.animaconnected.watch.account.strava.StravaClient$processUpload$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$processUpload$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$processUpload$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Session uploaded successfully."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$processUpload$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$processUpload$2.invoke():java.lang.Object");
                }
            }
            r10 = 6
            r11 = 0
            r5 = r13
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)
            com.animaconnected.watch.utils.WatchLibResult r13 = r13.onUploadReady(r14)
            goto Laf
        L9f:
            boolean r13 = r15 instanceof com.animaconnected.watch.account.strava.StravaResult.Failure
            if (r13 == 0) goto Lb0
            com.animaconnected.watch.account.strava.StravaFailureResponse r13 = com.animaconnected.watch.account.strava.StravaFailureResponse.INSTANCE
            com.animaconnected.watch.account.strava.StravaResult$Failure r15 = (com.animaconnected.watch.account.strava.StravaResult.Failure) r15
            java.lang.Exception r14 = r15.getException()
            com.animaconnected.watch.utils.WatchLibResult$Failure r13 = r13.upload(r14)
        Laf:
            return r13
        Lb0:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.processUpload(com.animaconnected.watch.account.strava.Upload, com.animaconnected.watch.fitness.Session, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(2:3|(7:5|6|7|(1:(1:(8:(1:(9:13|14|15|16|17|18|19|20|21)(2:41|42))(4:43|44|45|(4:47|(3:49|(1:51)(1:64)|(3:53|(1:55)(1:63)|(5:57|(1:58)|61|20|21)))|65|(4:67|29|20|21)(2:68|(1:70)(6:71|17|18|19|20|21)))(2:72|73))|39|26|27|28|29|20|21)(5:76|77|78|79|(1:81)(2:82|(0)(0))))(1:86))(2:97|(1:99)(1:100))|87|88|(4:90|29|20|21)(2:91|(1:93)(3:94|79|(0)(0)))))|7|(0)(0)|87|88|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a1, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a2, code lost:            r12 = r5;     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f2 A[Catch: Exception -> 0x0065, all -> 0x019e, TRY_ENTER, TryCatch #4 {Exception -> 0x0065, blocks: (B:45:0x0060, B:47:0x00f2, B:49:0x00fe, B:53:0x010e, B:57:0x011c, B:58:0x0123, B:61:0x0135, B:65:0x0155, B:67:0x0161, B:68:0x016a, B:72:0x0193, B:73:0x019a), top: B:44:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0193 A[Catch: Exception -> 0x0065, all -> 0x019e, TRY_ENTER, TryCatch #4 {Exception -> 0x0065, blocks: (B:45:0x0060, B:47:0x00f2, B:49:0x00fe, B:53:0x010e, B:57:0x011c, B:58:0x0123, B:61:0x0135, B:65:0x0155, B:67:0x0161, B:68:0x016a, B:72:0x0193, B:73:0x019a), top: B:44:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a3 A[Catch: all -> 0x019e, Exception -> 0x01a1, TryCatch #5 {all -> 0x019e, blocks: (B:45:0x0060, B:47:0x00f2, B:49:0x00fe, B:53:0x010e, B:57:0x011c, B:58:0x0123, B:61:0x0135, B:65:0x0155, B:67:0x0161, B:68:0x016a, B:72:0x0193, B:73:0x019a, B:78:0x0072, B:79:0x00c4, B:88:0x009b, B:90:0x00a3, B:91:0x00a8), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a8 A[Catch: all -> 0x019e, Exception -> 0x01a1, TRY_LEAVE, TryCatch #5 {all -> 0x019e, blocks: (B:45:0x0060, B:47:0x00f2, B:49:0x00fe, B:53:0x010e, B:57:0x011c, B:58:0x0123, B:61:0x0135, B:65:0x0155, B:67:0x0161, B:68:0x016a, B:72:0x0193, B:73:0x019a, B:78:0x0072, B:79:0x00c4, B:88:0x009b, B:90:0x00a3, B:91:0x00a8), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshTokens(kotlin.coroutines.Continuation<? super io.ktor.client.plugins.auth.providers.BearerTokens> r20) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.refreshTokens(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void saveForLaterRetry(Session session, String str) {
        this.db.m1353insertStravaPendingUploadkRTOawE(session.getStartTs(), session.m1467getHistoryDeviceIdV9ZILtA(), str, DateTimeUtilsKt.now().toEpochMilliseconds());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object uploadActivity(com.animaconnected.watch.account.strava.StravaActivity r10, kotlin.coroutines.Continuation<? super com.animaconnected.watch.account.strava.StravaResult<kotlin.Unit>> r11) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.uploadActivity(com.animaconnected.watch.account.strava.StravaActivity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092 A[Catch: Exception -> 0x0047, TryCatch #2 {Exception -> 0x0047, blocks: (B:29:0x0043, B:30:0x0086, B:32:0x0092, B:33:0x00a3, B:38:0x00b6), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #2 {Exception -> 0x0047, blocks: (B:29:0x0043, B:30:0x0086, B:32:0x0092, B:33:0x00a3, B:38:0x00b6), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkConnection(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.checkConnection(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(1:(5:12|13|14|15|16)(2:18|19))(3:20|21|(7:23|(3:25|(1:27)(1:40)|(3:29|(1:31)(1:39)|(5:33|(1:34)|37|15|16)))|41|(1:43)|14|15|16)(2:44|45)))(3:46|47|48))(2:57|(2:59|60)(3:61|62|(1:64)(1:65)))|49|(1:51)(2:52|(0)(0))))|71|6|7|(0)(0)|49|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0053, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0146, code lost:            r1 = com.animaconnected.watch.account.strava.StravaToken.class;     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6 A[Catch: Exception -> 0x0053, TRY_ENTER, TryCatch #2 {Exception -> 0x0053, blocks: (B:13:0x0039, B:14:0x012c, B:21:0x004e, B:23:0x00c6, B:25:0x00d2, B:29:0x00e2, B:33:0x00f0, B:34:0x00f7, B:37:0x0109, B:41:0x011f, B:44:0x013e, B:45:0x0145), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013e A[Catch: Exception -> 0x0053, TryCatch #2 {Exception -> 0x0053, blocks: (B:13:0x0039, B:14:0x012c, B:21:0x004e, B:23:0x00c6, B:25:0x00d2, B:29:0x00e2, B:33:0x00f0, B:34:0x00f7, B:37:0x0109, B:41:0x011f, B:44:0x013e, B:45:0x0145), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object finishAuthentication(java.lang.String r19, final java.lang.String r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.finishAuthentication(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isConnected() {
        return this._isConnected.getValue().booleanValue();
    }

    public final CommonFlow<Boolean> isConnectedFlow() {
        return FlowExtensionsKt.asCommonFlow(this._isConnected);
    }

    public final boolean isHttpLoggingEnabled() {
        return this.isHttpLoggingEnabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[Catch: Exception -> 0x002a, TryCatch #0 {Exception -> 0x002a, blocks: (B:11:0x0026, B:12:0x0092, B:18:0x0038, B:19:0x0068, B:21:0x0074, B:23:0x0084, B:27:0x003f, B:29:0x0053, B:31:0x005a), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084 A[Catch: Exception -> 0x002a, TryCatch #0 {Exception -> 0x002a, blocks: (B:11:0x0026, B:12:0x0092, B:18:0x0038, B:19:0x0068, B:21:0x0074, B:23:0x0084, B:27:0x003f, B:29:0x0053, B:31:0x005a), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object revokeAccess(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.animaconnected.watch.account.strava.StravaClient$revokeAccess$1
            if (r0 == 0) goto L13
            r0 = r13
            com.animaconnected.watch.account.strava.StravaClient$revokeAccess$1 r0 = (com.animaconnected.watch.account.strava.StravaClient$revokeAccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaClient$revokeAccess$1 r0 = new com.animaconnected.watch.account.strava.StravaClient$revokeAccess$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L2a
            goto L92
        L2a:
            r13 = move-exception
            goto L95
        L2c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L34:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.account.strava.StravaClient r2 = (com.animaconnected.watch.account.strava.StravaClient) r2
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L2a
            goto L68
        L3c:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r6 = "StravaClient"
            r7 = 0
            r8 = 0
            com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2 r9 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2
                static {
                    /*
                        com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2 r0 = new com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2) com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2.INSTANCE com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Trying to revoke access..."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient$revokeAccess$2.invoke():java.lang.Object");
                }
            }     // Catch: java.lang.Exception -> L2a
            r10 = 6
            r11 = 0
            r5 = r12
            com.animaconnected.logger.LogKt.debug$default(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L2a
            com.animaconnected.watch.account.strava.StravaStorage r13 = r12.storage     // Catch: java.lang.Exception -> L2a
            java.lang.String r13 = r13.getAccessToken()     // Catch: java.lang.Exception -> L2a
            if (r13 != 0) goto L5a
            com.animaconnected.watch.account.strava.StravaFailureResponse r13 = com.animaconnected.watch.account.strava.StravaFailureResponse.INSTANCE     // Catch: java.lang.Exception -> L2a
            com.animaconnected.watch.utils.WatchLibResult$Failure r13 = r13.missingAccessToken()     // Catch: java.lang.Exception -> L2a
            return r13
        L5a:
            com.animaconnected.watch.account.strava.StravaHttpClient r2 = r12.client     // Catch: java.lang.Exception -> L2a
            r0.L$0 = r12     // Catch: java.lang.Exception -> L2a
            r0.label = r4     // Catch: java.lang.Exception -> L2a
            java.lang.Object r13 = r2.revokeAccess(r13, r0)     // Catch: java.lang.Exception -> L2a
            if (r13 != r1) goto L67
            return r1
        L67:
            r2 = r12
        L68:
            io.ktor.client.statement.HttpResponse r13 = (io.ktor.client.statement.HttpResponse) r13     // Catch: java.lang.Exception -> L2a
            io.ktor.http.HttpStatusCode r4 = r13.getStatus()     // Catch: java.lang.Exception -> L2a
            boolean r4 = io.ktor.http.HttpStatusCodeKt.isSuccess(r4)     // Catch: java.lang.Exception -> L2a
            if (r4 == 0) goto L84
            r2.deleteTokens()     // Catch: java.lang.Exception -> L2a
            com.animaconnected.watch.account.strava.StravaAnalytics r13 = com.animaconnected.watch.account.strava.StravaAnalytics.INSTANCE     // Catch: java.lang.Exception -> L2a
            r13.trackUserSignOut()     // Catch: java.lang.Exception -> L2a
            com.animaconnected.watch.utils.WatchLibResult$Success r13 = new com.animaconnected.watch.utils.WatchLibResult$Success     // Catch: java.lang.Exception -> L2a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L2a
            r13.<init>(r0)     // Catch: java.lang.Exception -> L2a
            goto L9b
        L84:
            com.animaconnected.watch.account.strava.StravaFailureResponse r2 = com.animaconnected.watch.account.strava.StravaFailureResponse.INSTANCE     // Catch: java.lang.Exception -> L2a
            r4 = 0
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2a
            r0.label = r3     // Catch: java.lang.Exception -> L2a
            java.lang.Object r13 = r2.revokeAccess(r13, r0)     // Catch: java.lang.Exception -> L2a
            if (r13 != r1) goto L92
            return r1
        L92:
            com.animaconnected.watch.utils.WatchLibResult r13 = (com.animaconnected.watch.utils.WatchLibResult) r13     // Catch: java.lang.Exception -> L2a
            goto L9b
        L95:
            com.animaconnected.watch.account.strava.StravaFailureResponse r0 = com.animaconnected.watch.account.strava.StravaFailureResponse.INSTANCE
            com.animaconnected.watch.utils.WatchLibResult$Failure r13 = r0.revokeAccess(r13)
        L9b:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.revokeAccess(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setHttpLoggingEnabled(boolean z) {
        this.isHttpLoggingEnabled = z;
    }

    public final void startAuthentication() {
        String clientId = this.auth.getClientId();
        this.auth.authenticate(this.client.getAppOAuthUrl(clientId), this.client.getWebOAuthUrl(clientId));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object uploadAllPendingSessions(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.account.strava.StravaClient$uploadAllPendingSessions$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.account.strava.StravaClient$uploadAllPendingSessions$1 r0 = (com.animaconnected.watch.account.strava.StravaClient$uploadAllPendingSessions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.strava.StravaClient$uploadAllPendingSessions$1 r0 = new com.animaconnected.watch.account.strava.StravaClient$uploadAllPendingSessions$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.watch.account.strava.StravaClient r4 = (com.animaconnected.watch.account.strava.StravaClient) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L54
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.fitness.FitnessQueries r6 = r5.db
            kotlin.jvm.functions.Function0<com.animaconnected.watch.model.HistoryDeviceId> r2 = r5.getIdentifier
            java.lang.Object r2 = r2.invoke()
            com.animaconnected.watch.model.HistoryDeviceId r2 = (com.animaconnected.watch.model.HistoryDeviceId) r2
            java.lang.String r2 = r2.m1562unboximpl()
            java.util.List r6 = com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt.m1233getPendingStravaSessionsnDauRJo(r6, r2)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r4 = r5
            r2 = r6
        L54:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L6d
            java.lang.Object r6 = r2.next()
            com.animaconnected.watch.fitness.Session r6 = (com.animaconnected.watch.fitness.Session) r6
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r4.uploadSession(r6, r0)
            if (r6 != r1) goto L54
            return r1
        L6d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.uploadAllPendingSessions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0023. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0110: MOVE (r9 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:273), block:B:168:0x010d */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x010e: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:271), block:B:168:0x010d */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x010f: MOVE (r4 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:272), block:B:168:0x010d */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0215 A[Catch: all -> 0x02eb, TRY_ENTER, TryCatch #4 {all -> 0x02eb, blocks: (B:94:0x01b0, B:97:0x01bf, B:101:0x0215, B:103:0x0221, B:107:0x0270, B:109:0x027c, B:112:0x0287, B:116:0x02a1), top: B:93:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0264 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ec A[Catch: all -> 0x020f, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x020f, blocks: (B:78:0x01ec, B:82:0x0207, B:83:0x020e), top: B:76:0x01ea }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0207 A[Catch: all -> 0x020f, TRY_ENTER, TryCatch #9 {all -> 0x020f, blocks: (B:78:0x01ec, B:82:0x0207, B:83:0x020e), top: B:76:0x01ea }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01bf A[Catch: all -> 0x02eb, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x02eb, blocks: (B:94:0x01b0, B:97:0x01bf, B:101:0x0215, B:103:0x0221, B:107:0x0270, B:109:0x027c, B:112:0x0287, B:116:0x02a1), top: B:93:0x01b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.animaconnected.watch.account.strava.StravaFailureResponse] */
    /* JADX WARN: Type inference failed for: r0v38, types: [io.ktor.client.call.HttpClientCall] */
    /* JADX WARN: Type inference failed for: r0v40, types: [io.ktor.client.call.HttpClientCall] */
    /* JADX WARN: Type inference failed for: r0v65, types: [com.animaconnected.watch.account.strava.StravaFailureResponse] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.animaconnected.watch.account.strava.StravaClient$uploadSession$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13, types: [com.animaconnected.watch.account.strava.StravaHttpClient] */
    /* JADX WARN: Type inference failed for: r4v29, types: [com.animaconnected.watch.account.strava.StravaClient] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v68 */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v70 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v25, types: [com.animaconnected.watch.account.strava.StravaClient] */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.animaconnected.watch.device.GzipBackend] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object uploadSession(com.animaconnected.watch.fitness.Session r18, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<java.lang.Boolean, com.animaconnected.watch.utils.WatchLibException>> r19) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.strava.StravaClient.uploadSession(com.animaconnected.watch.fitness.Session, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
