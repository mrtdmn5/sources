package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.animaconnected.secondo.R;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkHttpOperation.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt", f = "SdkHttpOperation.kt", l = {R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail, R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity}, m = "cleanup")
/* loaded from: classes.dex */
public final class SdkHttpOperationKt$cleanup$1 extends ContinuationImpl {
    public ExecutionContext L$0;
    public Iterator L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SdkHttpOperationKt.cleanup(null, this);
    }
}
