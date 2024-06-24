package com.animaconnected.watch.account.profile;

/* compiled from: ProfileHttpClient.kt */
/* loaded from: classes3.dex */
public final class ProfileHttpClientKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object toFitnessConfig(io.ktor.client.statement.HttpResponse r16, kotlin.coroutines.Continuation<? super com.animaconnected.watch.fitness.FitnessConfig> r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof com.animaconnected.watch.account.profile.ProfileHttpClientKt$toFitnessConfig$1
            if (r1 == 0) goto L15
            r1 = r0
            com.animaconnected.watch.account.profile.ProfileHttpClientKt$toFitnessConfig$1 r1 = (com.animaconnected.watch.account.profile.ProfileHttpClientKt$toFitnessConfig$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.animaconnected.watch.account.profile.ProfileHttpClientKt$toFitnessConfig$1 r1 = new com.animaconnected.watch.account.profile.ProfileHttpClientKt$toFitnessConfig$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L31
            if (r3 != r4) goto L29
            kotlin.ResultKt.throwOnFailure(r0)
            goto L54
        L29:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L31:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.client.call.HttpClientCall r0 = r16.getCall()
            java.lang.Class<com.animaconnected.watch.account.profile.UserProfileResponse> r3 = com.animaconnected.watch.account.profile.UserProfileResponse.class
            kotlin.jvm.internal.TypeReference r5 = kotlin.jvm.internal.Reflection.typeOf(r3)
            java.lang.reflect.Type r6 = kotlin.reflect.TypesJVMKt.getJavaType(r5)
            kotlin.jvm.internal.ClassReference r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            io.ktor.util.reflect.TypeInfo r7 = new io.ktor.util.reflect.TypeInfo
            r7.<init>(r6, r3, r5)
            r1.label = r4
            java.lang.Object r0 = r0.bodyNullable(r7, r1)
            if (r0 != r2) goto L54
            return r2
        L54:
            if (r0 == 0) goto L98
            com.animaconnected.watch.account.profile.UserProfileResponse r0 = (com.animaconnected.watch.account.profile.UserProfileResponse) r0
            com.animaconnected.watch.account.profile.UserProfileResponse$Profile r0 = r0.getData()
            if (r0 == 0) goto L63
            java.lang.String r0 = r0.getProfile()
            goto L64
        L63:
            r0 = 0
        L64:
            if (r0 == 0) goto L6e
            int r1 = r0.length()
            if (r1 != 0) goto L6d
            goto L6e
        L6d:
            r4 = 0
        L6e:
            if (r4 == 0) goto L82
            com.animaconnected.watch.fitness.FitnessConfig r0 = new com.animaconnected.watch.fitness.FitnessConfig
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 255(0xff, float:3.57E-43)
            r15 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L97
        L82:
            kotlinx.serialization.json.Json$Default r1 = kotlinx.serialization.json.Json.Default
            kotlinx.serialization.json.Json r1 = com.animaconnected.watch.utils.DefaultJsonConfigKt.DefaultConfig(r1)
            r1.getClass()
            com.animaconnected.watch.fitness.FitnessConfig$Companion r2 = com.animaconnected.watch.fitness.FitnessConfig.Companion
            kotlinx.serialization.KSerializer r2 = r2.serializer()
            java.lang.Object r0 = r1.decodeFromString(r2, r0)
            com.animaconnected.watch.fitness.FitnessConfig r0 = (com.animaconnected.watch.fitness.FitnessConfig) r0
        L97:
            return r0
        L98:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type com.animaconnected.watch.account.profile.UserProfileResponse"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.profile.ProfileHttpClientKt.toFitnessConfig(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
