package com.amplifyframework.auth.cognito;

import aws.sdk.kotlin.services.cognitoidentity.CognitoIdentityClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import aws.sdk.kotlin.services.cognitoidentityprovider.endpoints.EndpointParameters;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.IdentityPoolConfiguration;
import com.amplifyframework.statemachine.codegen.data.UserPoolConfiguration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthService.kt */
/* loaded from: classes.dex */
public interface AWSCognitoAuthService {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: AWSCognitoAuthService.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AWSCognitoAuthService fromConfiguration$aws_auth_cognito_release(AuthConfiguration configuration) {
            final CognitoIdentityProviderClient cognitoIdentityProviderClient;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            final UserPoolConfiguration userPool = configuration.getUserPool();
            final CognitoIdentityClient cognitoIdentityClient = null;
            if (userPool != null) {
                int r2 = CognitoIdentityProviderClient.$r8$clinit;
                Function1<CognitoIdentityProviderClient.Config.Builder, Unit> function1 = new Function1<CognitoIdentityProviderClient.Config.Builder, Unit>() { // from class: com.amplifyframework.auth.cognito.AWSCognitoAuthService$Companion$fromConfiguration$cognitoIdentityProviderClient$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CognitoIdentityProviderClient.Config.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CognitoIdentityProviderClient.Config.Builder invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        invoke.region = UserPoolConfiguration.this.getRegion();
                        final String endpoint = UserPoolConfiguration.this.getEndpoint();
                        invoke.endpointProvider = endpoint != null ? new EndpointProvider() { // from class: com.amplifyframework.auth.cognito.AWSCognitoAuthService$Companion$fromConfiguration$cognitoIdentityProviderClient$1$1$1$1
                            public final Object resolveEndpoint(EndpointParameters endpointParameters, Continuation<? super Endpoint> continuation) {
                                return new Endpoint(endpoint);
                            }

                            @Override // aws.smithy.kotlin.runtime.client.endpoints.EndpointProvider
                            public /* bridge */ /* synthetic */ Object resolveEndpoint(Object obj, Continuation continuation) {
                                return resolveEndpoint((EndpointParameters) obj, (Continuation<? super Endpoint>) continuation);
                            }
                        } : null;
                    }
                };
                CognitoIdentityProviderClient.Builder builder = new CognitoIdentityProviderClient.Builder();
                function1.invoke(builder.getConfig());
                cognitoIdentityProviderClient = (CognitoIdentityProviderClient) ((SdkClient) builder.build());
            } else {
                cognitoIdentityProviderClient = null;
            }
            final IdentityPoolConfiguration identityPool = configuration.getIdentityPool();
            if (identityPool != null) {
                int r1 = CognitoIdentityClient.$r8$clinit;
                Function1<CognitoIdentityClient.Config.Builder, Unit> function12 = new Function1<CognitoIdentityClient.Config.Builder, Unit>() { // from class: com.amplifyframework.auth.cognito.AWSCognitoAuthService$Companion$fromConfiguration$cognitoIdentityClient$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(CognitoIdentityClient.Config.Builder builder2) {
                        invoke2(builder2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(CognitoIdentityClient.Config.Builder invoke) {
                        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                        invoke.region = IdentityPoolConfiguration.this.getRegion();
                    }
                };
                CognitoIdentityClient.Builder builder2 = new CognitoIdentityClient.Builder();
                function12.invoke(builder2.getConfig());
                cognitoIdentityClient = (CognitoIdentityClient) ((SdkClient) builder2.build());
            }
            return new AWSCognitoAuthService(cognitoIdentityProviderClient, cognitoIdentityClient) { // from class: com.amplifyframework.auth.cognito.AWSCognitoAuthService$Companion$fromConfiguration$1
                private CognitoIdentityClient cognitoIdentityClient;
                private CognitoIdentityProviderClient cognitoIdentityProviderClient;

                {
                    this.cognitoIdentityProviderClient = cognitoIdentityProviderClient;
                    this.cognitoIdentityClient = cognitoIdentityClient;
                }

                @Override // com.amplifyframework.auth.cognito.AWSCognitoAuthService
                public CognitoIdentityClient getCognitoIdentityClient() {
                    return this.cognitoIdentityClient;
                }

                @Override // com.amplifyframework.auth.cognito.AWSCognitoAuthService
                public CognitoIdentityProviderClient getCognitoIdentityProviderClient() {
                    return this.cognitoIdentityProviderClient;
                }

                @Override // com.amplifyframework.auth.cognito.AWSCognitoAuthService
                public void setCognitoIdentityClient(CognitoIdentityClient cognitoIdentityClient2) {
                    this.cognitoIdentityClient = cognitoIdentityClient2;
                }

                @Override // com.amplifyframework.auth.cognito.AWSCognitoAuthService
                public void setCognitoIdentityProviderClient(CognitoIdentityProviderClient cognitoIdentityProviderClient2) {
                    this.cognitoIdentityProviderClient = cognitoIdentityProviderClient2;
                }
            };
        }
    }

    CognitoIdentityClient getCognitoIdentityClient();

    CognitoIdentityProviderClient getCognitoIdentityProviderClient();

    void setCognitoIdentityClient(CognitoIdentityClient cognitoIdentityClient);

    void setCognitoIdentityProviderClient(CognitoIdentityProviderClient cognitoIdentityProviderClient);
}
