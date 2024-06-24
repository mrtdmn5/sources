package org.sqlite.jdbc3;

import aws.smithy.kotlin.runtime.http.engine.okhttp.HttpEngineEventListener;
import aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngineConfig;
import com.animaconnected.cloud.amazon.AWSLambda;
import com.animaconnected.cloud.amazon.lambda.LambdaFunctions;
import com.animaconnected.cloud.amazon.lambda.SendStatusDestinationParams;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class JDBC3Statement$$ExternalSyntheticLambda0 implements EventListener.Factory, FlatMapCallback {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ JDBC3Statement$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // okhttp3.EventListener.Factory
    public final EventListener create(Call call) {
        ConnectionPool pool = (ConnectionPool) this.f$0;
        OkHttpEngineConfig config = (OkHttpEngineConfig) this.f$1;
        Intrinsics.checkNotNullParameter(pool, "$pool");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(call, "call");
        return new HttpEngineEventListener(pool, config.hostResolver, call);
    }

    @Override // com.animaconnected.future.FlatMapCallback
    public final Future onResult(Object obj) {
        Future lambda$sendStatus$2;
        lambda$sendStatus$2 = ((AWSLambda) this.f$0).lambda$sendStatus$2((SendStatusDestinationParams) this.f$1, (LambdaFunctions) obj);
        return lambda$sendStatus$2;
    }
}
