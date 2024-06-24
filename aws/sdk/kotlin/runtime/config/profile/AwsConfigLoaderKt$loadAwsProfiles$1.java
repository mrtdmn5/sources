package aws.sdk.kotlin.runtime.config.profile;

import java.io.Serializable;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AwsConfigLoader.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt", f = "AwsConfigLoader.kt", l = {48, 49}, m = "loadAwsProfiles")
/* loaded from: classes.dex */
public final class AwsConfigLoaderKt$loadAwsProfiles$1 extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Serializable L$2;
    public Object[] L$3;
    public FileType L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwsConfigLoaderKt.loadAwsProfiles(null, null, this);
    }
}
