package aws.sdk.kotlin.runtime.config.profile;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AwsConfigLoader.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt", f = "AwsConfigLoader.kt", l = {31}, m = "loadActiveAwsProfile")
/* loaded from: classes.dex */
public final class AwsConfigLoaderKt$loadActiveAwsProfile$1 extends ContinuationImpl {
    public AwsConfigurationSource L$0;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwsConfigLoaderKt.loadActiveAwsProfile(null, this);
    }
}
