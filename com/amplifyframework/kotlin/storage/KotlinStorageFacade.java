package com.amplifyframework.kotlin.storage;

import com.amplifyframework.core.Consumer;
import com.amplifyframework.kotlin.storage.Storage;
import com.amplifyframework.storage.StorageCategoryBehavior;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageDownloadFileOperation;
import com.amplifyframework.storage.operation.StorageTransferOperation;
import com.amplifyframework.storage.operation.StorageUploadFileOperation;
import com.amplifyframework.storage.operation.StorageUploadInputStreamOperation;
import com.amplifyframework.storage.options.StorageDownloadFileOptions;
import com.amplifyframework.storage.options.StorageGetUrlOptions;
import com.amplifyframework.storage.options.StorageListOptions;
import com.amplifyframework.storage.options.StorageRemoveOptions;
import com.amplifyframework.storage.options.StorageUploadFileOptions;
import com.amplifyframework.storage.options.StorageUploadInputStreamOptions;
import com.amplifyframework.storage.result.StorageDownloadFileResult;
import com.amplifyframework.storage.result.StorageGetUrlResult;
import com.amplifyframework.storage.result.StorageListResult;
import com.amplifyframework.storage.result.StorageRemoveResult;
import com.amplifyframework.storage.result.StorageTransferProgress;
import com.amplifyframework.storage.result.StorageTransferResult;
import com.amplifyframework.storage.result.StorageUploadFileResult;
import com.amplifyframework.storage.result.StorageUploadInputStreamResult;
import java.io.File;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: KotlinStorageFacade.kt */
/* loaded from: classes.dex */
public final class KotlinStorageFacade implements Storage {
    private final StorageCategoryBehavior delegate;

    public KotlinStorageFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadFile$lambda-1, reason: not valid java name */
    public static final void m680downloadFile$lambda1(MutableSharedFlow progress, StorageTransferProgress it) {
        Intrinsics.checkNotNullParameter(progress, "$progress");
        Intrinsics.checkNotNullParameter(it, "it");
        progress.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadFile$lambda-2, reason: not valid java name */
    public static final void m681downloadFile$lambda2(MutableSharedFlow results, StorageDownloadFileResult it) {
        Intrinsics.checkNotNullParameter(results, "$results");
        Intrinsics.checkNotNullParameter(it, "it");
        results.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadFile$lambda-3, reason: not valid java name */
    public static final void m682downloadFile$lambda3(MutableSharedFlow errors, StorageException it) {
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(it, "it");
        errors.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFile$lambda-4, reason: not valid java name */
    public static final void m683uploadFile$lambda4(MutableSharedFlow progress, StorageTransferProgress it) {
        Intrinsics.checkNotNullParameter(progress, "$progress");
        Intrinsics.checkNotNullParameter(it, "it");
        progress.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFile$lambda-5, reason: not valid java name */
    public static final void m684uploadFile$lambda5(MutableSharedFlow results, StorageUploadFileResult it) {
        Intrinsics.checkNotNullParameter(results, "$results");
        Intrinsics.checkNotNullParameter(it, "it");
        results.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadFile$lambda-6, reason: not valid java name */
    public static final void m685uploadFile$lambda6(MutableSharedFlow errors, StorageException it) {
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(it, "it");
        errors.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadInputStream$lambda-7, reason: not valid java name */
    public static final void m686uploadInputStream$lambda7(MutableSharedFlow progress, StorageTransferProgress it) {
        Intrinsics.checkNotNullParameter(progress, "$progress");
        Intrinsics.checkNotNullParameter(it, "it");
        progress.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadInputStream$lambda-8, reason: not valid java name */
    public static final void m687uploadInputStream$lambda8(MutableSharedFlow results, StorageUploadInputStreamResult it) {
        Intrinsics.checkNotNullParameter(results, "$results");
        Intrinsics.checkNotNullParameter(it, "it");
        results.tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: uploadInputStream$lambda-9, reason: not valid java name */
    public static final void m688uploadInputStream$lambda9(MutableSharedFlow errors, StorageException it) {
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(it, "it");
        errors.tryEmit(it);
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Storage.InProgressStorageOperation<StorageDownloadFileResult> downloadFile(String key, File local, StorageDownloadFileOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(options, "options");
        final SharedFlowImpl MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        StorageDownloadFileOperation<?> downloadFile = this.delegate.downloadFile(key, local, options, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda3
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m680downloadFile$lambda1(MutableSharedFlow$default, (StorageTransferProgress) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda4
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m681downloadFile$lambda2(MutableSharedFlow$default2, (StorageDownloadFileResult) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda5
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m682downloadFile$lambda3(MutableSharedFlow$default3, (StorageException) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(downloadFile, "delegate.downloadFile(\n …s.tryEmit(it) }\n        )");
        String transferId = downloadFile.getTransferId();
        Intrinsics.checkNotNullExpressionValue(transferId, "operation.transferId");
        return new Storage.InProgressStorageOperation<>(transferId, FlowKt.asSharedFlow(MutableSharedFlow$default2), FlowKt.asSharedFlow(MutableSharedFlow$default), FlowKt.asSharedFlow(MutableSharedFlow$default3), downloadFile);
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Object getTransfer(String str, Continuation<? super StorageTransferOperation<?, StorageTransferResult>> continuation) throws StorageException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.getTransfer(str, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$getTransfer$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageTransferOperation<?, ? extends StorageTransferResult> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$getTransfer$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Object getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Continuation<? super StorageGetUrlResult> continuation) throws StorageException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.getUrl(str, storageGetUrlOptions, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$getUrl$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageGetUrlResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$getUrl$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Object list(String str, StorageListOptions storageListOptions, Continuation<? super StorageListResult> continuation) throws StorageException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.list(str, storageListOptions, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$list$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageListResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$list$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Object remove(String str, StorageRemoveOptions storageRemoveOptions, Continuation<? super StorageRemoveResult> continuation) throws StorageException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.remove(str, storageRemoveOptions, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$remove$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageRemoveResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(it);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$remove$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(StorageException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return orThrow;
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Storage.InProgressStorageOperation<StorageUploadFileResult> uploadFile(String key, File local, StorageUploadFileOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(options, "options");
        final SharedFlowImpl MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        StorageUploadFileOperation<?> uploadFile = this.delegate.uploadFile(key, local, options, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda0
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m683uploadFile$lambda4(MutableSharedFlow$default, (StorageTransferProgress) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m684uploadFile$lambda5(MutableSharedFlow$default2, (StorageUploadFileResult) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m685uploadFile$lambda6(MutableSharedFlow$default3, (StorageException) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(uploadFile, "delegate.uploadFile(\n   …s.tryEmit(it) }\n        )");
        String transferId = uploadFile.getTransferId();
        Intrinsics.checkNotNullExpressionValue(transferId, "operation.transferId");
        return new Storage.InProgressStorageOperation<>(transferId, FlowKt.asSharedFlow(MutableSharedFlow$default2), FlowKt.asSharedFlow(MutableSharedFlow$default), FlowKt.asSharedFlow(MutableSharedFlow$default3), uploadFile);
    }

    @Override // com.amplifyframework.kotlin.storage.Storage
    public Storage.InProgressStorageOperation<StorageUploadInputStreamResult> uploadInputStream(String key, InputStream local, StorageUploadInputStreamOptions options) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(options, "options");
        final SharedFlowImpl MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        final SharedFlowImpl MutableSharedFlow$default3 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6);
        StorageUploadInputStreamOperation<?> uploadInputStream = this.delegate.uploadInputStream(key, local, options, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda6
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m686uploadInputStream$lambda7(MutableSharedFlow$default, (StorageTransferProgress) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda7
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m687uploadInputStream$lambda8(MutableSharedFlow$default2, (StorageUploadInputStreamResult) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.storage.KotlinStorageFacade$$ExternalSyntheticLambda8
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinStorageFacade.m688uploadInputStream$lambda9(MutableSharedFlow$default3, (StorageException) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(uploadInputStream, "delegate.uploadInputStre…s.tryEmit(it) }\n        )");
        String transferId = uploadInputStream.getTransferId();
        Intrinsics.checkNotNullExpressionValue(transferId, "cancelable.transferId");
        return new Storage.InProgressStorageOperation<>(transferId, FlowKt.asSharedFlow(MutableSharedFlow$default2), FlowKt.asSharedFlow(MutableSharedFlow$default), FlowKt.asSharedFlow(MutableSharedFlow$default3), uploadInputStream);
    }

    public KotlinStorageFacade(StorageCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinStorageFacade(com.amplifyframework.storage.StorageCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.storage.StorageCategory r1 = com.amplifyframework.core.Amplify.Storage
            java.lang.String r2 = "Storage"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.storage.KotlinStorageFacade.<init>(com.amplifyframework.storage.StorageCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
