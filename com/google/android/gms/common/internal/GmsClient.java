package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client {
    public final ClientSettings zab;
    public final Set zac;
    public final Account zad;

    @Deprecated
    public GmsClient(int r8, Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        this(context, looper, r8, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        if (requiresSignIn()) {
            return this.zac;
        }
        return Collections.emptySet();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GmsClient(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.ClientSettings r13, com.google.android.gms.common.api.internal.ConnectionCallbacks r14, com.google.android.gms.common.api.internal.OnConnectionFailedListener r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.zzr r3 = com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(r10)
            com.google.android.gms.common.GoogleApiAvailability r4 = com.google.android.gms.common.GoogleApiAvailability.zab
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            com.google.android.gms.common.internal.zah r6 = new com.google.android.gms.common.internal.zah
            r6.<init>(r14)
            com.google.android.gms.common.internal.zai r7 = new com.google.android.gms.common.internal.zai
            r7.<init>(r15)
            java.lang.String r8 = r13.zah
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.zab = r13
            android.accounts.Account r10 = r13.zaa
            r9.zad = r10
            java.util.Set r10 = r13.zac
            java.util.Iterator r11 = r10.iterator()
        L2b:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L46
            java.lang.Object r12 = r11.next()
            com.google.android.gms.common.api.Scope r12 = (com.google.android.gms.common.api.Scope) r12
            boolean r12 = r10.contains(r12)
            if (r12 == 0) goto L3e
            goto L2b
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Expanding scopes is not permitted, use implied scopes instead"
            r10.<init>(r11)
            throw r10
        L46:
            r9.zac = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClient.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void getBindServiceExecutor() {
    }
}
