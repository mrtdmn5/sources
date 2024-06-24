package aws.smithy.kotlin.runtime.http.interceptors;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class InterceptorExecutor<I, O> {
    public HttpRequest _lastHttpRequest;
    public HttpResponse _lastHttpResponse;
    public I _lastInput;
    public final ExecutionContext execContext;
    public final List<Interceptor<Object, Object, HttpRequest, HttpResponse>> interceptors;
    public final OperationTypeInfo typeInfo;

    public InterceptorExecutor(ExecutionContext execContext, ArrayList interceptors, OperationTypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(execContext, "execContext");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        this.execContext = execContext;
        this.interceptors = interceptors;
        this.typeInfo = typeInfo;
    }

    public static void checkType(Object obj, String str, KClass kClass) {
        if (kClass.isInstance(obj)) {
            return;
        }
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, " invalid type conversion: found ");
        m.append(Reflection.getOrCreateKotlinClass(obj.getClass()));
        m.append("; expected ");
        m.append(kClass);
        throw new IllegalStateException(m.toString().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0081 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:11:0x002d, B:12:0x0078, B:14:0x0081, B:15:0x0087, B:16:0x005b, B:18:0x0061, B:22:0x008a), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:11:0x002d, B:12:0x0078, B:14:0x0081, B:15:0x0087, B:16:0x005b, B:18:0x0061, B:22:0x008a), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:11:0x002d, B:12:0x0078, B:14:0x0081, B:15:0x0087, B:16:0x005b, B:18:0x0061, B:22:0x008a), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0075 -> B:12:0x0078). Please report as a decompilation issue!!! */
    /* renamed from: modifyBeforeAttemptCompletion-3t6e044, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m617modifyBeforeAttemptCompletion3t6e044(java.lang.Object r12, aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView r13, aws.smithy.kotlin.runtime.http.response.HttpResponse r14, kotlin.coroutines.Continuation r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeAttemptCompletion$1
            if (r0 == 0) goto L13
            r0 = r15
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeAttemptCompletion$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeAttemptCompletion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeAttemptCompletion$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeAttemptCompletion$1
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "modifyBeforeAttemptCompletion"
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            aws.smithy.kotlin.runtime.http.interceptors.HttpAttemptInterceptorContext r12 = r0.L$3
            java.util.Iterator r13 = r0.L$2
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor r14 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L85
            kotlin.Result r15 = (kotlin.Result) r15     // Catch: java.lang.Throwable -> L85
            java.lang.Object r15 = r15.value     // Catch: java.lang.Throwable -> L85
            goto L78
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r15)
            I r6 = r11._lastInput
            if (r6 == 0) goto Lb4
            aws.smithy.kotlin.runtime.http.interceptors.HttpAttemptInterceptorContext r15 = new aws.smithy.kotlin.runtime.http.interceptors.HttpAttemptInterceptorContext
            aws.smithy.kotlin.runtime.operation.ExecutionContext r10 = r11.execContext
            r5 = r15
            r7 = r12
            r8 = r13
            r9 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r12 = r11.interceptors     // Catch: java.lang.Throwable -> L92
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Throwable -> L92
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L92
            r14 = r11
            r2 = r14
            r13 = r12
            r12 = r15
        L5b:
            boolean r15 = r13.hasNext()     // Catch: java.lang.Throwable -> L85
            if (r15 == 0) goto L8a
            java.lang.Object r15 = r13.next()     // Catch: java.lang.Throwable -> L85
            aws.smithy.kotlin.runtime.client.Interceptor r15 = (aws.smithy.kotlin.runtime.client.Interceptor) r15     // Catch: java.lang.Throwable -> L85
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L85
            r0.L$1 = r14     // Catch: java.lang.Throwable -> L85
            r0.L$2 = r13     // Catch: java.lang.Throwable -> L85
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L85
            r0.label = r3     // Catch: java.lang.Throwable -> L85
            java.lang.Object r15 = r15.mo615modifyBeforeAttemptCompletiongIAlus(r12)     // Catch: java.lang.Throwable -> L85
            if (r15 != r1) goto L78
            return r1
        L78:
            aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo r5 = r14.typeInfo     // Catch: java.lang.Throwable -> L85
            kotlin.reflect.KClass<?> r5 = r5.outputType     // Catch: java.lang.Throwable -> L85
            boolean r6 = r15 instanceof kotlin.Result.Failure     // Catch: java.lang.Throwable -> L85
            r6 = r6 ^ r3
            if (r6 == 0) goto L87
            checkType(r15, r4, r5)     // Catch: java.lang.Throwable -> L85
            goto L87
        L85:
            r12 = move-exception
            goto L94
        L87:
            r12.response = r15     // Catch: java.lang.Throwable -> L85
            goto L5b
        L8a:
            java.lang.Object r12 = r12.response     // Catch: java.lang.Throwable -> L85
            kotlin.Result r13 = new kotlin.Result     // Catch: java.lang.Throwable -> L85
            r13.<init>(r12)     // Catch: java.lang.Throwable -> L85
            goto L98
        L92:
            r12 = move-exception
            r2 = r11
        L94:
            kotlin.Result$Failure r13 = kotlin.ResultKt.createFailure(r12)
        L98:
            java.lang.Throwable r12 = kotlin.Result.m1661exceptionOrNullimpl(r13)
            if (r12 != 0) goto Laf
            kotlin.Result r13 = (kotlin.Result) r13
            aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo r12 = r2.typeInfo
            kotlin.reflect.KClass<?> r12 = r12.outputType
            java.lang.Object r13 = r13.value
            boolean r14 = r13 instanceof kotlin.Result.Failure
            r14 = r14 ^ r3
            if (r14 == 0) goto Lb3
            checkType(r13, r4, r12)
            goto Lb3
        Laf:
            kotlin.Result$Failure r13 = kotlin.ResultKt.createFailure(r12)
        Lb3:
            return r13
        Lb4:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Required value was null."
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.m617modifyBeforeAttemptCompletion3t6e044(java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:11:0x002d, B:12:0x007a, B:14:0x0083, B:15:0x0089, B:16:0x005d, B:18:0x0063, B:22:0x008c), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:11:0x002d, B:12:0x007a, B:14:0x0083, B:15:0x0089, B:16:0x005d, B:18:0x0063, B:22:0x008c), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:11:0x002d, B:12:0x007a, B:14:0x0083, B:15:0x0089, B:16:0x005d, B:18:0x0063, B:22:0x008c), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0077 -> B:12:0x007a). Please report as a decompilation issue!!! */
    /* renamed from: modifyBeforeCompletion-KWTtemM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m618modifyBeforeCompletionKWTtemM(java.lang.Object r12, kotlin.coroutines.Continuation<? super kotlin.Result<? extends O>> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeCompletion$1
            if (r0 == 0) goto L13
            r0 = r13
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeCompletion$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeCompletion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeCompletion$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeCompletion$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "modifyBeforeCompletion"
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            aws.smithy.kotlin.runtime.http.interceptors.HttpFinalInterceptorContext r12 = r0.L$3
            java.util.Iterator r2 = r0.L$2
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor r5 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L87
            kotlin.Result r13 = (kotlin.Result) r13     // Catch: java.lang.Throwable -> L87
            java.lang.Object r13 = r13.value     // Catch: java.lang.Throwable -> L87
            goto L7a
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            I r6 = r11._lastInput
            if (r6 == 0) goto Lb6
            aws.smithy.kotlin.runtime.http.interceptors.HttpFinalInterceptorContext r13 = new aws.smithy.kotlin.runtime.http.interceptors.HttpFinalInterceptorContext
            aws.smithy.kotlin.runtime.http.request.HttpRequest r8 = r11._lastHttpRequest
            aws.smithy.kotlin.runtime.http.response.HttpResponse r9 = r11._lastHttpResponse
            aws.smithy.kotlin.runtime.operation.ExecutionContext r10 = r11.execContext
            r5 = r13
            r7 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r12 = r11.interceptors     // Catch: java.lang.Throwable -> L94
            java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch: java.lang.Throwable -> L94
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L94
            r5 = r11
            r6 = r5
            r2 = r12
            r12 = r13
        L5d:
            boolean r13 = r2.hasNext()     // Catch: java.lang.Throwable -> L87
            if (r13 == 0) goto L8c
            java.lang.Object r13 = r2.next()     // Catch: java.lang.Throwable -> L87
            aws.smithy.kotlin.runtime.client.Interceptor r13 = (aws.smithy.kotlin.runtime.client.Interceptor) r13     // Catch: java.lang.Throwable -> L87
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L87
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L87
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L87
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L87
            r0.label = r3     // Catch: java.lang.Throwable -> L87
            java.lang.Object r13 = r13.mo616modifyBeforeCompletiongIAlus(r12)     // Catch: java.lang.Throwable -> L87
            if (r13 != r1) goto L7a
            return r1
        L7a:
            aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo r7 = r5.typeInfo     // Catch: java.lang.Throwable -> L87
            kotlin.reflect.KClass<?> r7 = r7.outputType     // Catch: java.lang.Throwable -> L87
            boolean r8 = r13 instanceof kotlin.Result.Failure     // Catch: java.lang.Throwable -> L87
            r8 = r8 ^ r3
            if (r8 == 0) goto L89
            checkType(r13, r4, r7)     // Catch: java.lang.Throwable -> L87
            goto L89
        L87:
            r12 = move-exception
            goto L96
        L89:
            r12.response = r13     // Catch: java.lang.Throwable -> L87
            goto L5d
        L8c:
            java.lang.Object r12 = r12.response     // Catch: java.lang.Throwable -> L87
            kotlin.Result r13 = new kotlin.Result     // Catch: java.lang.Throwable -> L87
            r13.<init>(r12)     // Catch: java.lang.Throwable -> L87
            goto L9a
        L94:
            r12 = move-exception
            r6 = r11
        L96:
            kotlin.Result$Failure r13 = kotlin.ResultKt.createFailure(r12)
        L9a:
            java.lang.Throwable r12 = kotlin.Result.m1661exceptionOrNullimpl(r13)
            if (r12 != 0) goto Lb1
            kotlin.Result r13 = (kotlin.Result) r13
            aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo r12 = r6.typeInfo
            kotlin.reflect.KClass<?> r12 = r12.outputType
            java.lang.Object r13 = r13.value
            boolean r0 = r13 instanceof kotlin.Result.Failure
            r0 = r0 ^ r3
            if (r0 == 0) goto Lb5
            checkType(r13, r4, r12)
            goto Lb5
        Lb1:
            kotlin.Result$Failure r13 = kotlin.ResultKt.createFailure(r12)
        Lb5:
            return r13
        Lb6:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "Required value was null."
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.m618modifyBeforeCompletionKWTtemM(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(8:10|11|12|13|14|(2:16|(1:18)(5:20|12|13|14|(0)))|21|22)(2:24|25))(2:26|(6:28|29|14|(0)|21|22)(2:30|31))))|34|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:            r8 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:            r2 = kotlin.ResultKt.createFailure(r8);     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:11:0x002b, B:12:0x0071, B:14:0x0053, B:16:0x0059, B:29:0x0049), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0070 -> B:12:0x0071). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeDeserialization(aws.smithy.kotlin.runtime.http.response.HttpCall r8, kotlin.coroutines.Continuation<? super aws.smithy.kotlin.runtime.http.response.HttpResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1
            if (r0 == 0) goto L13
            r0 = r9
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeDeserialization$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext r8 = r0.L$3
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext r2 = r0.L$2
            java.util.Iterator r4 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L7f
            goto L71
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            I r9 = r7._lastInput
            if (r9 == 0) goto L8c
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext r2 = new aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext
            aws.smithy.kotlin.runtime.http.request.HttpRequest r4 = r8.request
            aws.smithy.kotlin.runtime.operation.ExecutionContext r5 = r7.execContext
            aws.smithy.kotlin.runtime.http.response.HttpResponse r8 = r8.response
            r2.<init>(r9, r4, r8, r5)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r8 = r7.interceptors     // Catch: java.lang.Throwable -> L7f
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L7f
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L7f
            r4 = r8
            r8 = r2
        L53:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> L7f
            if (r9 == 0) goto L84
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L7f
            aws.smithy.kotlin.runtime.client.Interceptor r9 = (aws.smithy.kotlin.runtime.client.Interceptor) r9     // Catch: java.lang.Throwable -> L7f
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7f
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L7f
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7f
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L7f
            r0.label = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r9 = r9.modifyBeforeDeserialization(r8)     // Catch: java.lang.Throwable -> L7f
            if (r9 != r1) goto L70
            return r1
        L70:
            r5 = r8
        L71:
            aws.smithy.kotlin.runtime.http.response.HttpResponse r9 = (aws.smithy.kotlin.runtime.http.response.HttpResponse) r9     // Catch: java.lang.Throwable -> L7f
            r8.getClass()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)     // Catch: java.lang.Throwable -> L7f
            r8.protocolResponse = r9     // Catch: java.lang.Throwable -> L7f
            r8 = r5
            goto L53
        L7f:
            r8 = move-exception
            kotlin.Result$Failure r2 = kotlin.ResultKt.createFailure(r8)
        L84:
            kotlin.ResultKt.throwOnFailure(r2)
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext r2 = (aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolResponseInterceptorContext) r2
            aws.smithy.kotlin.runtime.http.response.HttpResponse r8 = r2.protocolResponse
            return r8
        L8c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Required value was null."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.modifyBeforeDeserialization(aws.smithy.kotlin.runtime.http.response.HttpCall, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(8:10|11|12|13|14|(2:16|(1:18)(5:20|12|13|14|(0)))|21|22)(2:24|25))(2:26|(6:28|29|14|(0)|21|22)(2:30|31))))|34|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:            r8 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:            r2 = kotlin.ResultKt.createFailure(r8);     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x002b, B:12:0x006d, B:14:0x004f, B:16:0x0055, B:29:0x0045), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:12:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeRetryLoop(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1
            if (r0 == 0) goto L13
            r0 = r9
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeRetryLoop$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r8 = r0.L$3
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = r0.L$2
            java.util.Iterator r4 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L7b
            goto L6d
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            I r9 = r7._lastInput
            if (r9 == 0) goto L88
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = new aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext
            aws.smithy.kotlin.runtime.operation.ExecutionContext r4 = r7.execContext
            r2.<init>(r9, r8, r4)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r8 = r7.interceptors     // Catch: java.lang.Throwable -> L7b
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L7b
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L7b
            r4 = r8
            r8 = r2
        L4f:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> L7b
            if (r9 == 0) goto L80
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L7b
            aws.smithy.kotlin.runtime.client.Interceptor r9 = (aws.smithy.kotlin.runtime.client.Interceptor) r9     // Catch: java.lang.Throwable -> L7b
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7b
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L7b
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7b
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L7b
            r0.label = r3     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r9 = r9.modifyBeforeRetryLoop(r8, r0)     // Catch: java.lang.Throwable -> L7b
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
        L6d:
            aws.smithy.kotlin.runtime.http.request.HttpRequest r9 = (aws.smithy.kotlin.runtime.http.request.HttpRequest) r9     // Catch: java.lang.Throwable -> L7b
            r8.getClass()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)     // Catch: java.lang.Throwable -> L7b
            r8.protocolRequest = r9     // Catch: java.lang.Throwable -> L7b
            r8 = r5
            goto L4f
        L7b:
            r8 = move-exception
            kotlin.Result$Failure r2 = kotlin.ResultKt.createFailure(r8)
        L80:
            kotlin.ResultKt.throwOnFailure(r2)
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = (aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext) r2
            aws.smithy.kotlin.runtime.http.request.HttpRequest r8 = r2.protocolRequest
            return r8
        L88:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Required value was null."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.modifyBeforeRetryLoop(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006c -> B:10:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeSerialization(I r9, kotlin.coroutines.Continuation<? super I> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1
            if (r0 == 0) goto L13
            r0 = r10
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSerialization$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext r9 = r0.L$3
            java.util.Iterator r2 = r0.L$2
            aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext r4 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6f
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.throwOnFailure(r10)
            aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext r10 = new aws.smithy.kotlin.runtime.http.interceptors.HttpInputInterceptorContext
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Any"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r2)
            aws.smithy.kotlin.runtime.operation.ExecutionContext r2 = r8.execContext
            r10.<init>(r2, r9)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r9 = r8.interceptors
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r5 = r8
            r2 = r9
            r9 = r10
            r4 = r9
        L52:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L7b
            java.lang.Object r10 = r2.next()
            aws.smithy.kotlin.runtime.client.Interceptor r10 = (aws.smithy.kotlin.runtime.client.Interceptor) r10
            r0.L$0 = r5
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r9
            r0.label = r3
            java.lang.Object r10 = r10.modifyBeforeSerialization(r9)
            if (r10 != r1) goto L6f
            return r1
        L6f:
            aws.smithy.kotlin.runtime.http.operation.OperationTypeInfo r6 = r5.typeInfo
            kotlin.reflect.KClass<?> r6 = r6.inputType
            java.lang.String r7 = "modifyBeforeSerialization"
            checkType(r10, r7, r6)
            r4.request = r10
            goto L52
        L7b:
            I r9 = r9.request
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.modifyBeforeSerialization(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(8:10|11|12|13|14|(2:16|(1:18)(5:20|12|13|14|(0)))|21|22)(2:24|25))(2:26|(6:28|29|14|(0)|21|22)(2:30|31))))|34|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:            r8 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:            r2 = kotlin.ResultKt.createFailure(r8);     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x002b, B:12:0x006d, B:14:0x004f, B:16:0x0055, B:29:0x0045), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:12:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeSigning(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1
            if (r0 == 0) goto L13
            r0 = r9
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeSigning$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r8 = r0.L$3
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = r0.L$2
            java.util.Iterator r4 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L7b
            goto L6d
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            I r9 = r7._lastInput
            if (r9 == 0) goto L88
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = new aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext
            aws.smithy.kotlin.runtime.operation.ExecutionContext r4 = r7.execContext
            r2.<init>(r9, r8, r4)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r8 = r7.interceptors     // Catch: java.lang.Throwable -> L7b
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L7b
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L7b
            r4 = r8
            r8 = r2
        L4f:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> L7b
            if (r9 == 0) goto L80
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L7b
            aws.smithy.kotlin.runtime.client.Interceptor r9 = (aws.smithy.kotlin.runtime.client.Interceptor) r9     // Catch: java.lang.Throwable -> L7b
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7b
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L7b
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7b
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L7b
            r0.label = r3     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r9 = r9.modifyBeforeSigning(r8)     // Catch: java.lang.Throwable -> L7b
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
        L6d:
            aws.smithy.kotlin.runtime.http.request.HttpRequest r9 = (aws.smithy.kotlin.runtime.http.request.HttpRequest) r9     // Catch: java.lang.Throwable -> L7b
            r8.getClass()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)     // Catch: java.lang.Throwable -> L7b
            r8.protocolRequest = r9     // Catch: java.lang.Throwable -> L7b
            r8 = r5
            goto L4f
        L7b:
            r8 = move-exception
            kotlin.Result$Failure r2 = kotlin.ResultKt.createFailure(r8)
        L80:
            kotlin.ResultKt.throwOnFailure(r2)
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = (aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext) r2
            aws.smithy.kotlin.runtime.http.request.HttpRequest r8 = r2.protocolRequest
            return r8
        L88:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Required value was null."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.modifyBeforeSigning(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(8:10|11|12|13|14|(2:16|(1:18)(5:20|12|13|14|(0)))|21|22)(2:24|25))(2:26|(6:28|29|14|(0)|21|22)(2:30|31))))|34|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:            r8 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:            r2 = kotlin.ResultKt.createFailure(r8);     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x002b, B:12:0x006d, B:14:0x004f, B:16:0x0055, B:29:0x0045), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006c -> B:12:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object modifyBeforeTransmit(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1
            if (r0 == 0) goto L13
            r0 = r9
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1 r0 = (aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1 r0 = new aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor$modifyBeforeTransmit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r8 = r0.L$3
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = r0.L$2
            java.util.Iterator r4 = r0.L$1
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L7b
            goto L6d
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            I r9 = r7._lastInput
            if (r9 == 0) goto L88
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = new aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext
            aws.smithy.kotlin.runtime.operation.ExecutionContext r4 = r7.execContext
            r2.<init>(r9, r8, r4)
            java.util.List<aws.smithy.kotlin.runtime.client.Interceptor<java.lang.Object, java.lang.Object, aws.smithy.kotlin.runtime.http.request.HttpRequest, aws.smithy.kotlin.runtime.http.response.HttpResponse>> r8 = r7.interceptors     // Catch: java.lang.Throwable -> L7b
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Throwable -> L7b
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L7b
            r4 = r8
            r8 = r2
        L4f:
            boolean r9 = r4.hasNext()     // Catch: java.lang.Throwable -> L7b
            if (r9 == 0) goto L80
            java.lang.Object r9 = r4.next()     // Catch: java.lang.Throwable -> L7b
            aws.smithy.kotlin.runtime.client.Interceptor r9 = (aws.smithy.kotlin.runtime.client.Interceptor) r9     // Catch: java.lang.Throwable -> L7b
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L7b
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L7b
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L7b
            r0.L$3 = r8     // Catch: java.lang.Throwable -> L7b
            r0.label = r3     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r9 = r9.modifyBeforeTransmit(r8)     // Catch: java.lang.Throwable -> L7b
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
        L6d:
            aws.smithy.kotlin.runtime.http.request.HttpRequest r9 = (aws.smithy.kotlin.runtime.http.request.HttpRequest) r9     // Catch: java.lang.Throwable -> L7b
            r8.getClass()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r6 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r6)     // Catch: java.lang.Throwable -> L7b
            r8.protocolRequest = r9     // Catch: java.lang.Throwable -> L7b
            r8 = r5
            goto L4f
        L7b:
            r8 = move-exception
            kotlin.Result$Failure r2 = kotlin.ResultKt.createFailure(r8)
        L80:
            kotlin.ResultKt.throwOnFailure(r2)
            aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext r2 = (aws.smithy.kotlin.runtime.http.interceptors.HttpProtocolRequestInterceptorContext) r2
            aws.smithy.kotlin.runtime.http.request.HttpRequest r8 = r2.protocolRequest
            return r8
        L88:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Required value was null."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor.modifyBeforeTransmit(aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
