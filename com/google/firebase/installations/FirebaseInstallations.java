package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.util.Log;
import com.amazonaws.http.HttpHeader;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzcb;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.SequentialExecutor;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.RequestLimiter;
import com.google.firebase.installations.remote.TokenResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class FirebaseInstallations implements FirebaseInstallationsApi {
    public static final Object lockGenerateFid = new Object();
    public final ExecutorService backgroundExecutor;
    public String cachedFid;
    public final RandomFidGenerator fidGenerator;
    public final HashSet fidListeners;
    public final FirebaseApp firebaseApp;
    public final Lazy<IidStore> iidStore;
    public final ArrayList listeners;
    public final Object lock;
    public final Executor networkExecutor;
    public final PersistedInstallation persistedInstallation;
    public final FirebaseInstallationServiceClient serviceClient;
    public final Utils utils;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode;
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode;

        static {
            int[] r0 = new int[TokenResult.ResponseCode.values().length];
            $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode = r0;
            try {
                r0[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] r2 = new int[InstallationResponse.ResponseCode.values().length];
            $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode = r2;
            try {
                r2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        new AtomicInteger(1);
    }

    @SuppressLint({"ThreadPoolCreation"})
    public FirebaseInstallations() {
        throw null;
    }

    @SuppressLint({"ThreadPoolCreation"})
    public FirebaseInstallations(final FirebaseApp firebaseApp, Provider provider, ExecutorService executorService, SequentialExecutor sequentialExecutor) {
        firebaseApp.checkNotDeleted();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.applicationContext, provider);
        PersistedInstallation persistedInstallation = new PersistedInstallation(firebaseApp);
        if (zzcb.singleton == null) {
            zzcb.singleton = new zzcb();
        }
        zzcb zzcbVar = zzcb.singleton;
        if (Utils.singleton == null) {
            Utils.singleton = new Utils(zzcbVar);
        }
        Utils utils = Utils.singleton;
        Lazy<IidStore> lazy = new Lazy<>(new Provider() { // from class: com.google.firebase.installations.FirebaseInstallations$$ExternalSyntheticLambda1
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return new IidStore(FirebaseApp.this);
            }
        });
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.lock = new Object();
        this.fidListeners = new HashSet();
        this.listeners = new ArrayList();
        this.firebaseApp = firebaseApp;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = persistedInstallation;
        this.utils = utils;
        this.iidStore = lazy;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = executorService;
        this.networkExecutor = sequentialExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #1 {all -> 0x005f, blocks: (B:6:0x000e, B:8:0x001a, B:13:0x0024), top: B:5:0x000e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[Catch: all -> 0x0066, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:16:0x003f, B:17:0x0042, B:26:0x0062, B:27:0x0065, B:6:0x000e, B:8:0x001a, B:13:0x0024), top: B:3:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void doRegistrationOrRefresh(final boolean r7) {
        /*
            r6 = this;
            java.lang.Object r0 = com.google.firebase.installations.FirebaseInstallations.lockGenerateFid
            monitor-enter(r0)
            com.google.firebase.FirebaseApp r1 = r6.firebaseApp     // Catch: java.lang.Throwable -> L66
            r1.checkNotDeleted()     // Catch: java.lang.Throwable -> L66
            android.content.Context r1 = r1.applicationContext     // Catch: java.lang.Throwable -> L66
            com.google.firebase.installations.CrossProcessLock r1 = com.google.firebase.installations.CrossProcessLock.acquire(r1)     // Catch: java.lang.Throwable -> L66
            com.google.firebase.installations.local.PersistedInstallation r2 = r6.persistedInstallation     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = r2.readPersistedInstallationEntryValue()     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r3 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.NOT_GENERATED     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r4 = r2.registrationStatus     // Catch: java.lang.Throwable -> L5f
            if (r4 == r3) goto L21
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r3 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION     // Catch: java.lang.Throwable -> L5f
            if (r4 != r3) goto L1f
            goto L21
        L1f:
            r3 = 0
            goto L22
        L21:
            r3 = 1
        L22:
            if (r3 == 0) goto L3d
            java.lang.String r3 = r6.readExistingIidOrCreateFid(r2)     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.PersistedInstallation r4 = r6.persistedInstallation     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r5 = new com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder     // Catch: java.lang.Throwable -> L5f
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L5f
            r5.firebaseInstallationId = r3     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r2 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.UNREGISTERED     // Catch: java.lang.Throwable -> L5f
            r5.setRegistrationStatus(r2)     // Catch: java.lang.Throwable -> L5f
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = r5.build()     // Catch: java.lang.Throwable -> L5f
            r4.insertOrUpdatePersistedInstallationEntry(r2)     // Catch: java.lang.Throwable -> L5f
        L3d:
            if (r1 == 0) goto L42
            r1.releaseAndClose()     // Catch: java.lang.Throwable -> L66
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L66
            if (r7 == 0) goto L51
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder r0 = new com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry$Builder
            r0.<init>(r2)
            r1 = 0
            r0.authToken = r1
            com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r2 = r0.build()
        L51:
            r6.triggerOnStateReached(r2)
            java.util.concurrent.Executor r0 = r6.networkExecutor
            com.google.firebase.installations.FirebaseInstallations$$ExternalSyntheticLambda2 r1 = new com.google.firebase.installations.FirebaseInstallations$$ExternalSyntheticLambda2
            r1.<init>()
            r0.execute(r1)
            return
        L5f:
            r7 = move-exception
            if (r1 == 0) goto L65
            r1.releaseAndClose()     // Catch: java.lang.Throwable -> L66
        L65:
            throw r7     // Catch: java.lang.Throwable -> L66
        L66:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L66
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.doRegistrationOrRefresh(boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v5 */
    public final AutoValue_PersistedInstallationEntry fetchAuthTokenFromServer(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) throws FirebaseInstallationsException {
        ?? r10;
        boolean z;
        String str;
        String str2;
        boolean z2;
        int responseCode;
        boolean z3;
        AutoValue_TokenResult readGenerateAuthTokenResponse;
        String str3;
        String str4;
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String str5 = firebaseApp.options.apiKey;
        String str6 = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        String str7 = firebaseApp2.options.projectId;
        String str8 = autoValue_PersistedInstallationEntry.refreshToken;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        RequestLimiter requestLimiter = firebaseInstallationServiceClient.requestLimiter;
        synchronized (requestLimiter) {
            r10 = 1;
            if (requestLimiter.attemptCount != 0) {
                requestLimiter.utils.clock.getClass();
                if (System.currentTimeMillis() <= requestLimiter.nextRequestTime) {
                    z = false;
                }
            }
            z = true;
        }
        String str9 = "Firebase Installations Service is unavailable. Please try again later.";
        if (z) {
            URL fullyQualifiedRequestUri = FirebaseInstallationServiceClient.getFullyQualifiedRequestUri(String.format("projects/%s/installations/%s/authTokens:generate", str7, str6));
            int r8 = 0;
            while (r8 <= r10) {
                TrafficStats.setThreadStatsTag(32771);
                HttpURLConnection openHttpURLConnection = firebaseInstallationServiceClient.openHttpURLConnection(fullyQualifiedRequestUri, str5);
                try {
                    try {
                        openHttpURLConnection.setRequestMethod("POST");
                        openHttpURLConnection.addRequestProperty(HttpHeader.AUTHORIZATION, "FIS_v2 " + str8);
                        openHttpURLConnection.setDoOutput(r10);
                        FirebaseInstallationServiceClient.writeGenerateAuthTokenRequestBodyToOutputStream(openHttpURLConnection);
                        responseCode = openHttpURLConnection.getResponseCode();
                        requestLimiter.setNextRequestTime(responseCode);
                        if (responseCode >= 200 && responseCode < 300) {
                            z3 = r10;
                        } else {
                            z3 = false;
                        }
                    } catch (Throwable th) {
                        openHttpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        throw th;
                    }
                } catch (IOException | AssertionError unused) {
                }
                if (z3) {
                    readGenerateAuthTokenResponse = FirebaseInstallationServiceClient.readGenerateAuthTokenResponse(openHttpURLConnection);
                    str = str9;
                } else {
                    FirebaseInstallationServiceClient.logFisCommunicationError(openHttpURLConnection, null, str5, str7);
                    if (responseCode != 401 && responseCode != 404) {
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                try {
                                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                    Long l = 0L;
                                    TokenResult.ResponseCode responseCode2 = TokenResult.ResponseCode.BAD_CONFIG;
                                    if (l == null) {
                                        str4 = " tokenExpirationTimestamp";
                                    } else {
                                        str4 = "";
                                    }
                                    String str10 = str4;
                                    if (str10.isEmpty()) {
                                        str = str9;
                                        readGenerateAuthTokenResponse = new AutoValue_TokenResult(null, l.longValue(), responseCode2);
                                    } else {
                                        throw new IllegalStateException("Missing required properties:".concat(str10));
                                    }
                                } catch (IOException | AssertionError unused2) {
                                    str = str9;
                                    str2 = str;
                                    z2 = true;
                                    openHttpURLConnection.disconnect();
                                    TrafficStats.clearThreadStatsTag();
                                    r8++;
                                    str9 = str2;
                                    r10 = z2;
                                }
                            }
                            z2 = r10;
                            str2 = str9;
                            openHttpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            r8++;
                            str9 = str2;
                            r10 = z2;
                        } else {
                            FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.BAD_CONFIG;
                            throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                    } else {
                        try {
                            str = str9;
                            Long l2 = 0L;
                            TokenResult.ResponseCode responseCode3 = TokenResult.ResponseCode.AUTH_ERROR;
                            if (l2 == null) {
                                str3 = " tokenExpirationTimestamp";
                            } else {
                                str3 = "";
                            }
                            if (str3.isEmpty()) {
                                readGenerateAuthTokenResponse = new AutoValue_TokenResult(null, l2.longValue(), responseCode3);
                            } else {
                                str2 = str;
                                z2 = true;
                                try {
                                    throw new IllegalStateException("Missing required properties:".concat(str3));
                                    break;
                                } catch (IOException | AssertionError unused3) {
                                    continue;
                                }
                            }
                        } catch (IOException | AssertionError unused4) {
                            str2 = str;
                            z2 = true;
                            openHttpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            r8++;
                            str9 = str2;
                            r10 = z2;
                        }
                    }
                }
                openHttpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                int r3 = AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$TokenResult$ResponseCode[readGenerateAuthTokenResponse.responseCode.ordinal()];
                if (r3 != 1) {
                    if (r3 != 2) {
                        if (r3 == 3) {
                            synchronized (this) {
                                this.cachedFid = null;
                            }
                            AutoValue_PersistedInstallationEntry.Builder builder = new AutoValue_PersistedInstallationEntry.Builder(autoValue_PersistedInstallationEntry);
                            builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.NOT_GENERATED);
                            return builder.build();
                        }
                        FirebaseInstallationsException.Status status2 = FirebaseInstallationsException.Status.BAD_CONFIG;
                        throw new FirebaseInstallationsException(str);
                    }
                    AutoValue_PersistedInstallationEntry.Builder builder2 = autoValue_PersistedInstallationEntry.toBuilder();
                    builder2.fisError = "BAD CONFIG";
                    builder2.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
                    return builder2.build();
                }
                Utils utils = this.utils;
                utils.getClass();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                utils.clock.getClass();
                long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                AutoValue_PersistedInstallationEntry.Builder builder3 = new AutoValue_PersistedInstallationEntry.Builder(autoValue_PersistedInstallationEntry);
                builder3.authToken = readGenerateAuthTokenResponse.token;
                builder3.expiresInSecs = Long.valueOf(readGenerateAuthTokenResponse.tokenExpirationTimestamp);
                builder3.tokenCreationEpochInSecs = Long.valueOf(seconds);
                return builder3.build();
            }
            FirebaseInstallationsException.Status status3 = FirebaseInstallationsException.Status.BAD_CONFIG;
            throw new FirebaseInstallationsException(str9);
        }
        FirebaseInstallationsException.Status status4 = FirebaseInstallationsException.Status.BAD_CONFIG;
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public final zzw getId() {
        String str;
        preConditionChecks();
        synchronized (this) {
            str = this.cachedFid;
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getIdListener);
        }
        zzw zzwVar = taskCompletionSource.zza;
        this.backgroundExecutor.execute(new Runnable() { // from class: com.google.firebase.installations.FirebaseInstallations$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.doRegistrationOrRefresh(false);
            }
        });
        return zzwVar;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public final zzw getToken() {
        preConditionChecks();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getAuthTokenListener);
        }
        this.backgroundExecutor.execute(new Runnable() { // from class: com.google.firebase.installations.FirebaseInstallations$$ExternalSyntheticLambda3
            public final /* synthetic */ boolean f$1 = false;

            @Override // java.lang.Runnable
            public final void run() {
                FirebaseInstallations.this.doRegistrationOrRefresh(this.f$1);
            }
        });
        return taskCompletionSource.zza;
    }

    public final void preConditionChecks() {
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", firebaseApp.options.applicationId);
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty("Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", firebaseApp.options.projectId);
        firebaseApp.checkNotDeleted();
        Preconditions.checkNotEmpty("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", firebaseApp.options.apiKey);
        firebaseApp.checkNotDeleted();
        String str = firebaseApp.options.applicationId;
        Pattern pattern = Utils.API_KEY_FORMAT;
        Preconditions.checkArgument("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", str.contains(":"));
        firebaseApp.checkNotDeleted();
        Preconditions.checkArgument("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", Utils.API_KEY_FORMAT.matcher(firebaseApp.options.apiKey).matches());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:            if ("[DEFAULT]".equals(r0.name) != false) goto L6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String readExistingIidOrCreateFid(com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry r6) {
        /*
            r5 = this;
            com.google.firebase.FirebaseApp r0 = r5.firebaseApp
            r0.checkNotDeleted()
            java.lang.String r0 = r0.name
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            com.google.firebase.FirebaseApp r0 = r5.firebaseApp
            r0.checkNotDeleted()
            java.lang.String r1 = "[DEFAULT]"
            java.lang.String r0 = r0.name
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L29
        L1e:
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r6 = r6.registrationStatus
            com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus r0 = com.google.firebase.installations.local.PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION
            if (r6 != r0) goto L26
            r6 = 1
            goto L27
        L26:
            r6 = 0
        L27:
            if (r6 != 0) goto L33
        L29:
            com.google.firebase.installations.RandomFidGenerator r6 = r5.fidGenerator
            r6.getClass()
            java.lang.String r6 = com.google.firebase.installations.RandomFidGenerator.createRandomFid()
            return r6
        L33:
            com.google.firebase.components.Lazy<com.google.firebase.installations.local.IidStore> r6 = r5.iidStore
            java.lang.Object r6 = r6.get()
            com.google.firebase.installations.local.IidStore r6 = (com.google.firebase.installations.local.IidStore) r6
            android.content.SharedPreferences r0 = r6.iidPrefs
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r6.iidPrefs     // Catch: java.lang.Throwable -> L67
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L67
            android.content.SharedPreferences r2 = r6.iidPrefs     // Catch: java.lang.Throwable -> L64
            java.lang.String r3 = "|S|id"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L64
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L4f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            goto L54
        L4f:
            java.lang.String r2 = r6.readPublicKeyFromLocalStorageAndCalculateInstanceId()     // Catch: java.lang.Throwable -> L67
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
        L54:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 == 0) goto L63
            com.google.firebase.installations.RandomFidGenerator r6 = r5.fidGenerator
            r6.getClass()
            java.lang.String r2 = com.google.firebase.installations.RandomFidGenerator.createRandomFid()
        L63:
            return r2
        L64:
            r6 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L64
            throw r6     // Catch: java.lang.Throwable -> L67
        L67:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L67
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.readExistingIidOrCreateFid(com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry):java.lang.String");
    }

    public final AutoValue_PersistedInstallationEntry registerFidWithServer(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) throws FirebaseInstallationsException {
        boolean z;
        int responseCode;
        boolean z2;
        AutoValue_InstallationResponse readCreateResponse;
        String str = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        String str2 = null;
        if (str != null && str.length() == 11) {
            IidStore iidStore = this.iidStore.get();
            synchronized (iidStore.iidPrefs) {
                String[] strArr = IidStore.ALLOWABLE_SCOPES;
                int r7 = 0;
                while (true) {
                    if (r7 >= 4) {
                        break;
                    }
                    String str3 = strArr[r7];
                    String string = iidStore.iidPrefs.getString("|T|" + iidStore.defaultSenderId + "|" + str3, null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            try {
                                str2 = new JSONObject(string).getString(AWSCognitoLegacyCredentialStore.TOKEN_KEY);
                            } catch (JSONException unused) {
                            }
                        } else {
                            str2 = string;
                        }
                    } else {
                        r7++;
                    }
                }
            }
        }
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String str4 = firebaseApp.options.apiKey;
        String str5 = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        String str6 = firebaseApp2.options.projectId;
        FirebaseApp firebaseApp3 = this.firebaseApp;
        firebaseApp3.checkNotDeleted();
        String str7 = firebaseApp3.options.applicationId;
        RequestLimiter requestLimiter = firebaseInstallationServiceClient.requestLimiter;
        synchronized (requestLimiter) {
            if (requestLimiter.attemptCount != 0) {
                requestLimiter.utils.clock.getClass();
                if (System.currentTimeMillis() <= requestLimiter.nextRequestTime) {
                    z = false;
                }
            }
            z = true;
        }
        if (z) {
            URL fullyQualifiedRequestUri = FirebaseInstallationServiceClient.getFullyQualifiedRequestUri(String.format("projects/%s/installations", str6));
            for (int r13 = 0; r13 <= 1; r13++) {
                TrafficStats.setThreadStatsTag(32769);
                HttpURLConnection openHttpURLConnection = firebaseInstallationServiceClient.openHttpURLConnection(fullyQualifiedRequestUri, str4);
                try {
                    try {
                        openHttpURLConnection.setRequestMethod("POST");
                        openHttpURLConnection.setDoOutput(true);
                        if (str2 != null) {
                            openHttpURLConnection.addRequestProperty("x-goog-fis-android-iid-migration-auth", str2);
                        }
                        FirebaseInstallationServiceClient.writeFIDCreateRequestBodyToOutputStream(openHttpURLConnection, str5, str7);
                        responseCode = openHttpURLConnection.getResponseCode();
                        requestLimiter.setNextRequestTime(responseCode);
                        if (responseCode >= 200 && responseCode < 300) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (z2) {
                        readCreateResponse = FirebaseInstallationServiceClient.readCreateResponse(openHttpURLConnection);
                        openHttpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    } else {
                        FirebaseInstallationServiceClient.logFisCommunicationError(openHttpURLConnection, str7, str4, str6);
                        if (responseCode != 429) {
                            if (responseCode < 500 || responseCode >= 600) {
                                Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                AutoValue_InstallationResponse autoValue_InstallationResponse = new AutoValue_InstallationResponse(null, null, null, null, InstallationResponse.ResponseCode.BAD_CONFIG);
                                openHttpURLConnection.disconnect();
                                TrafficStats.clearThreadStatsTag();
                                readCreateResponse = autoValue_InstallationResponse;
                            } else {
                                openHttpURLConnection.disconnect();
                                TrafficStats.clearThreadStatsTag();
                            }
                        } else {
                            FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.BAD_CONFIG;
                            throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                    }
                    int r3 = AnonymousClass3.$SwitchMap$com$google$firebase$installations$remote$InstallationResponse$ResponseCode[readCreateResponse.responseCode.ordinal()];
                    if (r3 != 1) {
                        if (r3 == 2) {
                            AutoValue_PersistedInstallationEntry.Builder builder = autoValue_PersistedInstallationEntry.toBuilder();
                            builder.fisError = "BAD CONFIG";
                            builder.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
                            return builder.build();
                        }
                        FirebaseInstallationsException.Status status2 = FirebaseInstallationsException.Status.BAD_CONFIG;
                        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    String str8 = readCreateResponse.fid;
                    String str9 = readCreateResponse.refreshToken;
                    Utils utils = this.utils;
                    utils.getClass();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    utils.clock.getClass();
                    long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                    String token = readCreateResponse.authToken.getToken();
                    long tokenExpirationTimestamp = readCreateResponse.authToken.getTokenExpirationTimestamp();
                    AutoValue_PersistedInstallationEntry.Builder builder2 = new AutoValue_PersistedInstallationEntry.Builder(autoValue_PersistedInstallationEntry);
                    builder2.firebaseInstallationId = str8;
                    builder2.setRegistrationStatus(PersistedInstallation.RegistrationStatus.REGISTERED);
                    builder2.authToken = token;
                    builder2.refreshToken = str9;
                    builder2.expiresInSecs = Long.valueOf(tokenExpirationTimestamp);
                    builder2.tokenCreationEpochInSecs = Long.valueOf(seconds);
                    return builder2.build();
                } finally {
                    openHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            }
            FirebaseInstallationsException.Status status3 = FirebaseInstallationsException.Status.BAD_CONFIG;
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
        FirebaseInstallationsException.Status status4 = FirebaseInstallationsException.Status.BAD_CONFIG;
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void triggerOnException(Exception exc) {
        synchronized (this.lock) {
            Iterator it = this.listeners.iterator();
            while (it.hasNext()) {
                if (((StateListener) it.next()).onException(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void triggerOnStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        synchronized (this.lock) {
            Iterator it = this.listeners.iterator();
            while (it.hasNext()) {
                if (((StateListener) it.next()).onStateReached(autoValue_PersistedInstallationEntry)) {
                    it.remove();
                }
            }
        }
    }
}
