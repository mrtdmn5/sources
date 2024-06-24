package io.ktor.client.plugins.auth;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.Sender;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.auth.HttpAuthHeader;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Auth.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.Auth$Plugin$install$2", f = "Auth.kt", l = {67, 86, 87}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Auth$Plugin$install$2 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    public final /* synthetic */ Auth $plugin;
    public /* synthetic */ Sender L$0;
    public /* synthetic */ HttpRequestBuilder L$1;
    public Ref$ObjectRef L$2;
    public HashSet L$3;
    public Object L$4;
    public HttpAuthHeader L$5;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Auth$Plugin$install$2(Auth auth, Continuation<? super Auth$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = auth;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        Auth$Plugin$install$2 auth$Plugin$install$2 = new Auth$Plugin$install$2(this.$plugin, continuation);
        auth$Plugin$install$2.L$0 = sender;
        auth$Plugin$install$2.L$1 = httpRequestBuilder;
        return auth$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x039d, code lost:            r2 = androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0.m("Expected delimiter , at position ", r1, ", but found ");        r2.append(r11.charAt(r1));     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03b5, code lost:            throw new io.ktor.http.parsing.ParseException(r2.toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x029d, code lost:            throw new io.ktor.http.parsing.ParseException(aws.sdk.kotlin.runtime.config.imds.EndpointMode$Companion$$ExternalSyntheticOutline0.m("Expected closing quote'\"' in parameter: ", r11, ' '));     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0425, code lost:            throw new io.ktor.http.parsing.ParseException("Invalid authScheme value: it should be token, can't be blank");     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03c4 A[EDGE_INSN: B:125:0x03c4->B:126:0x03c4 BREAK  A[LOOP:5: B:75:0x020a->B:117:0x038d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ae A[LOOP:3: B:34:0x0169->B:58:0x01ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b5 A[EDGE_INSN: B:59:0x01b5->B:60:0x01b5 BREAK  A[LOOP:3: B:34:0x0169->B:58:0x01ae], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object, io.ktor.client.call.HttpClientCall] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:0x0589 -> B:7:0x058d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 1433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.Auth$Plugin$install$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
