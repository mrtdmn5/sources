package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class Api<O extends ApiOptions> {
    public final AbstractClientBuilder zaa;
    public final String zac;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @Deprecated
        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, ApiOptions apiOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return buildClient(context, looper, clientSettings, apiOptions, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
        }

        public Client buildClient(Context context, Looper looper, ClientSettings clientSettings, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static class AnyClientKey<C> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface ApiOptions {
        public static final NoOptions NO_OPTIONS = new NoOptions(0);

        /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
        /* loaded from: classes3.dex */
        public interface HasAccountOptions extends ApiOptions {
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
        /* loaded from: classes3.dex */
        public interface HasGoogleSignInAccountOptions extends ApiOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
        /* loaded from: classes3.dex */
        public static final class NoOptions implements ApiOptions {
            public NoOptions() {
            }

            public /* synthetic */ NoOptions(int r1) {
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static abstract class BaseClientBuilder<T, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public interface Client {
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void disconnect(String str);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        Set<Scope> getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(zabp zabpVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        this.zac = str;
        this.zaa = abstractClientBuilder;
    }
}
