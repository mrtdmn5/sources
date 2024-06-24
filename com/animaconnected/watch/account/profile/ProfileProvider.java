package com.animaconnected.watch.account.profile;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.behaviour.temperature.TemperatureStorage;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileProvider.kt */
/* loaded from: classes3.dex */
public final class ProfileProvider implements FitnessProvider.Profile {
    private final FitnessQueries db;
    private final ProfileHttpClient httpClient;
    private final Function0<Unit> onProfileChanged;

    public ProfileProvider(FitnessQueries db, Function0<Unit> onProfileChanged) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(onProfileChanged, "onProfileChanged");
        this.db = db;
        this.onProfileChanged = onProfileChanged;
        this.httpClient = new ProfileHttpClient(ServiceLocator.INSTANCE.getAccountBackend().isSandbox());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchToken(kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$1 r0 = (com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$1 r0 = new com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.account.profile.ProfileProvider r0 = (com.animaconnected.watch.account.profile.ProfileProvider) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r4 = r0
            goto L49
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L34:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.ServiceLocator r12 = com.animaconnected.watch.ServiceLocator.INSTANCE
            com.animaconnected.watch.device.AccountBackend r12 = r12.getAccountBackend()
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r12 = r12.token(r0)
            if (r12 != r1) goto L48
            return r1
        L48:
            r4 = r11
        L49:
            com.animaconnected.watch.utils.WatchLibResult r12 = (com.animaconnected.watch.utils.WatchLibResult) r12
            java.lang.Object r12 = r12.getOrNull()
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L5b
            int r0 = r12.length()
            if (r0 != 0) goto L5a
            goto L5b
        L5a:
            r3 = 0
        L5b:
            if (r3 == 0) goto L68
            java.lang.String r5 = "ProfileProvider"
            r6 = 0
            r7 = 0
            com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2
                static {
                    /*
                        com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2 r0 = new com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2) com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2.INSTANCE com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Token missing. Cloud sync not possible."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider$fetchToken$2.invoke():java.lang.Object");
                }
            }
            r9 = 6
            r10 = 0
            com.animaconnected.logger.LogKt.warn$default(r4, r5, r6, r7, r8, r9, r10)
        L68:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider.fetchToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncConfigToCloud(com.animaconnected.watch.fitness.FitnessConfig r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<kotlin.Unit, com.animaconnected.watch.utils.WatchLibException>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$1 r0 = (com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$1 r0 = new com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            com.animaconnected.watch.account.profile.ProfileProvider r8 = (com.animaconnected.watch.account.profile.ProfileProvider) r8
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L2b
            goto L46
        L2b:
            r9 = move-exception
            goto L49
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            com.animaconnected.watch.account.profile.ProfileHttpClient r10 = r7.httpClient     // Catch: java.lang.Exception -> L4b
            r0.L$0 = r7     // Catch: java.lang.Exception -> L4b
            r0.label = r3     // Catch: java.lang.Exception -> L4b
            java.lang.Object r10 = r10.putFitnessConfig(r8, r9, r0)     // Catch: java.lang.Exception -> L4b
            if (r10 != r1) goto L45
            return r1
        L45:
            r8 = r7
        L46:
            com.animaconnected.watch.utils.WatchLibResult r10 = (com.animaconnected.watch.utils.WatchLibResult) r10     // Catch: java.lang.Exception -> L2b
            goto L72
        L49:
            r0 = r8
            goto L4e
        L4b:
            r8 = move-exception
            r9 = r8
            r0 = r7
        L4e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Failed to sync fitness config to cloud. Exception: "
            r8.<init>(r10)
            java.lang.String r8 = com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0.m(r9, r8)
            java.lang.String r1 = "ProfileProvider"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$2 r4 = new com.animaconnected.watch.account.profile.ProfileProvider$syncConfigToCloud$2
            r4.<init>()
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.animaconnected.watch.utils.WatchLibResult$Failure r10 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            com.animaconnected.watch.utils.WatchLibException$Companion r9 = com.animaconnected.watch.utils.WatchLibException.Companion
            com.animaconnected.watch.utils.WatchLibException r8 = r9.getDefaultErrorException(r8)
            r10.<init>(r8)
        L72:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider.syncConfigToCloud(com.animaconnected.watch.fitness.FitnessConfig, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateLocalConfig(FitnessConfig fitnessConfig) {
        FitnessDatabaseExtensionsKt.insertProfile(this.db, fitnessConfig);
        this.onProfileChanged.invoke();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object clearPersonalData(Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, null, null, null, null, null, 224, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091 A[Catch: Exception -> 0x0115, TryCatch #2 {Exception -> 0x0115, blocks: (B:25:0x0049, B:26:0x0089, B:30:0x0091, B:32:0x0095, B:35:0x00ae, B:39:0x00ce, B:42:0x00d6, B:44:0x00e2, B:47:0x00ea, B:49:0x00f6, B:52:0x010f, B:53:0x0114), top: B:24:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchAndUpdateConfig(kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<com.animaconnected.watch.fitness.FitnessConfig, com.animaconnected.watch.utils.WatchLibException>> r20) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider.fetchAndUpdateConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Bedtime getBedtime() {
        Bedtime bedtime = getLocalFitnessConfig().getBedtime();
        if (bedtime == null) {
            return Bedtime.Companion.defaultBedtime();
        }
        return bedtime;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Long getDateOfBirth() {
        return getLocalFitnessConfig().getDateOfBirthTs();
    }

    public final FitnessQueries getDb() {
        return this.db;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Gender getGender() {
        return FitnessProvider.Profile.Gender.Companion.fromId$watch_release(getLocalFitnessConfig().getGender());
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Integer getHeight() {
        return getLocalFitnessConfig().getHeight();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessConfig getLocalFitnessConfig() {
        try {
            FitnessConfig executeAsOneOrNull = FitnessDatabaseExtensionsKt.getProfile(this.db, DateTimeUtilsKt.currentTimeMillis()).executeAsOneOrNull();
            if (executeAsOneOrNull == null) {
                return new FitnessConfig((Long) null, (Integer) null, (Integer) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, (Bedtime) null, 255, (DefaultConstructorMarker) null);
            }
            return executeAsOneOrNull;
        } catch (Exception e) {
            LogKt.warn$default((Object) this, "ProfileProvider", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.profile.ProfileProvider$getLocalFitnessConfig$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to retrieve local fitness config. Exception: "));
                }
            }, 6, (Object) null);
            return new FitnessConfig((Long) null, (Integer) null, (Integer) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, (Bedtime) null, 255, (DefaultConstructorMarker) null);
        }
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Measurement getMeasurement() {
        FitnessProvider.Profile.Measurement fromId$watch_release = FitnessProvider.Profile.Measurement.Companion.fromId$watch_release(getLocalFitnessConfig().getMeasurement());
        if (fromId$watch_release == null) {
            return FitnessProvider.Profile.Measurement.Metric;
        }
        return fromId$watch_release;
    }

    public final Function0<Unit> getOnProfileChanged() {
        return this.onProfileChanged;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public FitnessProvider.Profile.Temperature getTemperatureUnit() {
        FitnessProvider.Profile.Temperature fromId$watch_release = FitnessProvider.Profile.Temperature.Companion.fromId$watch_release(getLocalFitnessConfig().getTemperature());
        if (fromId$watch_release != null) {
            return fromId$watch_release;
        }
        if (new TemperatureStorage().isCelsius()) {
            return FitnessProvider.Profile.Temperature.Celsius;
        }
        return FitnessProvider.Profile.Temperature.Fahrenheit;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Integer getWeight() {
        return getLocalFitnessConfig().getWeight();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object saveAndSyncConfig(com.animaconnected.watch.fitness.FitnessConfig r20, kotlin.coroutines.Continuation<? super com.animaconnected.watch.utils.WatchLibResult<kotlin.Unit, com.animaconnected.watch.utils.WatchLibException>> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.animaconnected.watch.account.profile.ProfileProvider$saveAndSyncConfig$1
            if (r2 == 0) goto L17
            r2 = r1
            com.animaconnected.watch.account.profile.ProfileProvider$saveAndSyncConfig$1 r2 = (com.animaconnected.watch.account.profile.ProfileProvider$saveAndSyncConfig$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.animaconnected.watch.account.profile.ProfileProvider$saveAndSyncConfig$1 r2 = new com.animaconnected.watch.account.profile.ProfileProvider$saveAndSyncConfig$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L48
            if (r4 == r6) goto L37
            if (r4 != r5) goto L2f
            kotlin.ResultKt.throwOnFailure(r1)
            goto La4
        L2f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L37:
            java.lang.Object r4 = r2.L$1
            com.animaconnected.watch.fitness.FitnessConfig r4 = (com.animaconnected.watch.fitness.FitnessConfig) r4
            java.lang.Object r6 = r2.L$0
            com.animaconnected.watch.account.profile.ProfileProvider r6 = (com.animaconnected.watch.account.profile.ProfileProvider) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r18 = r4
            r4 = r1
            r1 = r18
            goto L86
        L48:
            kotlin.ResultKt.throwOnFailure(r1)
            com.animaconnected.watch.fitness.FitnessConfig r7 = r19.getLocalFitnessConfig()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 254(0xfe, float:3.56E-43)
            r17 = 0
            com.animaconnected.watch.fitness.FitnessConfig r1 = com.animaconnected.watch.fitness.FitnessConfig.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r7 = r20
            com.animaconnected.watch.fitness.FitnessConfig r4 = com.animaconnected.watch.fitness.FitnessConfig.copy$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L73
            com.animaconnected.watch.utils.WatchLibResult$Success r1 = new com.animaconnected.watch.utils.WatchLibResult$Success
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r1.<init>(r2)
            return r1
        L73:
            r19.updateLocalConfig(r20)
            r2.L$0 = r0
            r1 = r20
            r2.L$1 = r1
            r2.label = r6
            java.lang.Object r4 = r0.fetchToken(r2)
            if (r4 != r3) goto L85
            return r3
        L85:
            r6 = r0
        L86:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L96
            com.animaconnected.watch.utils.WatchLibResult$Failure r1 = new com.animaconnected.watch.utils.WatchLibResult$Failure
            com.animaconnected.watch.utils.WatchLibException$Companion r2 = com.animaconnected.watch.utils.WatchLibException.Companion
            com.animaconnected.watch.utils.WatchLibException r2 = r2.getNoTokenAvailableException()
            r1.<init>(r2)
            return r1
        L96:
            r7 = 0
            r2.L$0 = r7
            r2.L$1 = r7
            r2.label = r5
            java.lang.Object r1 = r6.syncConfigToCloud(r1, r4, r2)
            if (r1 != r3) goto La4
            return r3
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileProvider.saveAndSyncConfig(com.animaconnected.watch.fitness.FitnessConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setBedtime(Bedtime bedtime, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, null, null, null, null, bedtime, 126, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setDateOfBirth(Long l, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, l, null, null, null, null, 246, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setGender(FitnessProvider.Profile.Gender gender, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        Integer num;
        FitnessConfig localFitnessConfig = getLocalFitnessConfig();
        Long l = new Long(DateTimeUtilsKt.currentTimeMillis());
        if (gender != null) {
            num = new Integer(gender.getId$watch_release());
        } else {
            num = null;
        }
        return saveAndSyncConfig(FitnessConfig.copy$default(localFitnessConfig, l, null, null, null, num, null, null, null, 238, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setHeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), num, null, null, null, null, null, null, 252, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setMeasurement(FitnessProvider.Profile.Measurement measurement, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, null, null, new Integer(measurement.getId$watch_release()), null, null, 222, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setTemperatureUnit(FitnessProvider.Profile.Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, null, null, null, new Integer(temperature.getId$watch_release()), null, 190, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setUnits(FitnessProvider.Profile.Measurement measurement, FitnessProvider.Profile.Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, null, null, null, new Integer(measurement.getId$watch_release()), new Integer(temperature.getId$watch_release()), null, R.styleable.AppTheme_stepsHistoryNoDataBackgroundDetail, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider.Profile
    public Object setWeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        return saveAndSyncConfig(FitnessConfig.copy$default(getLocalFitnessConfig(), new Long(DateTimeUtilsKt.currentTimeMillis()), null, num, null, null, null, null, null, 250, null), continuation);
    }
}
