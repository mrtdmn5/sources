package com.amazonaws.mobileconnectors.lambdainvoker;

import android.content.Context;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.util.ClientContext;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LambdaInvokerFactory {
    private final ClientContext clientContext;
    private final AWSLambda lambda;

    /* loaded from: classes.dex */
    public static class Builder {
        private AWSConfiguration awsConfig;
        private ClientConfiguration clientConfig;
        private ClientContext clientContext;
        private Context context;
        private AWSLambda lambda;
        private AWSCredentialsProvider provider;
        private Regions region;

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfig = aWSConfiguration;
            return this;
        }

        public LambdaInvokerFactory build() {
            if (this.clientConfig == null) {
                if (this.context != null) {
                    this.clientContext = new ClientContext(this.context);
                } else {
                    throw new IllegalArgumentException("Context or ClientContext are required please set using .context(context) or .clientContext(clientContext)");
                }
            }
            if (this.lambda == null) {
                if (this.provider != null) {
                    if (this.clientConfig == null) {
                        this.clientConfig = new ClientConfiguration();
                    }
                } else {
                    throw new IllegalArgumentException("AWSCredentialsProvider is required please set using .credentialsProvider(creds)");
                }
            }
            if (this.awsConfig != null) {
                try {
                    ClientConfiguration clientConfiguration = this.clientConfig;
                    if (clientConfiguration != null) {
                        String userAgent = clientConfiguration.getUserAgent();
                        if (userAgent != null && !userAgent.trim().isEmpty()) {
                            this.clientConfig.setUserAgent(userAgent + "/" + this.awsConfig.getUserAgent());
                        }
                        this.clientConfig.setUserAgent(this.awsConfig.getUserAgent());
                    }
                    JSONObject optJsonObject = this.awsConfig.optJsonObject("LambdaInvoker");
                    if (this.region != null) {
                        this.region = Regions.fromName(optJsonObject.getString("Region"));
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException("Failed to read LambdaInvoker please check your setup or awsconfiguration.json file", e);
                }
            }
            if (this.lambda == null) {
                this.lambda = new AWSLambdaClient(this.provider, this.clientConfig);
            }
            Regions regions = this.region;
            if (regions != null) {
                this.lambda.setRegion(Region.getRegion(regions));
            }
            return new LambdaInvokerFactory(this.lambda, this.clientContext);
        }

        public Builder clientConfiguration(ClientConfiguration clientConfiguration) {
            this.clientConfig = clientConfiguration;
            return this;
        }

        public Builder clientContext(ClientContext clientContext) {
            this.clientContext = clientContext;
            return this;
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder credentialsProvider(AWSCredentialsProvider aWSCredentialsProvider) {
            this.provider = aWSCredentialsProvider;
            return this;
        }

        public Builder lambdaClient(AWSLambda aWSLambda) {
            this.lambda = aWSLambda;
            return this;
        }

        public Builder region(Regions regions) {
            this.region = regions;
            return this;
        }
    }

    public LambdaInvokerFactory(Context context, Regions regions, AWSCredentialsProvider aWSCredentialsProvider) {
        this(context, regions, aWSCredentialsProvider, new ClientConfiguration());
    }

    public static Builder builder() {
        return new Builder();
    }

    public <T> T build(Class<T> cls) {
        return (T) build(cls, new LambdaJsonBinder());
    }

    public ClientContext getClientContext() {
        return this.clientContext;
    }

    public LambdaInvokerFactory(Context context, Regions regions, AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        if (aWSCredentialsProvider != null) {
            AWSLambdaClient aWSLambdaClient = new AWSLambdaClient(aWSCredentialsProvider, clientConfiguration);
            this.lambda = aWSLambdaClient;
            aWSLambdaClient.setRegion(Region.getRegion(regions));
            this.clientContext = new ClientContext(context);
            return;
        }
        throw new IllegalArgumentException("provider can't be null");
    }

    public <T> T build(Class<T> cls, LambdaDataBinder lambdaDataBinder) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new LambdaInvocationHandler(this.lambda, lambdaDataBinder, this.clientContext)));
    }

    public LambdaInvokerFactory(AWSLambda aWSLambda, ClientContext clientContext) {
        this.lambda = aWSLambda;
        this.clientContext = clientContext;
    }
}
