package com.amplifyframework.kotlin.storage;

import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.async.Resumable;
import com.amplifyframework.storage.StorageException;
import com.amplifyframework.storage.operation.StorageTransferOperation;
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
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: Storage.kt */
/* loaded from: classes.dex */
public interface Storage {

    /* compiled from: Storage.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ InProgressStorageOperation downloadFile$default(Storage storage, String str, File file, StorageDownloadFileOptions storageDownloadFileOptions, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 4) != 0) {
                    storageDownloadFileOptions = StorageDownloadFileOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageDownloadFileOptions, "defaultInstance()");
                }
                return storage.downloadFile(str, file, storageDownloadFileOptions);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
        }

        public static /* synthetic */ Object getUrl$default(Storage storage, String str, StorageGetUrlOptions storageGetUrlOptions, Continuation continuation, int r4, Object obj) throws StorageException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    storageGetUrlOptions = StorageGetUrlOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageGetUrlOptions, "defaultInstance()");
                }
                return storage.getUrl(str, storageGetUrlOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUrl");
        }

        public static /* synthetic */ Object list$default(Storage storage, String str, StorageListOptions storageListOptions, Continuation continuation, int r4, Object obj) throws StorageException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    storageListOptions = StorageListOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageListOptions, "defaultInstance()");
                }
                return storage.list(str, storageListOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: list");
        }

        public static /* synthetic */ Object remove$default(Storage storage, String str, StorageRemoveOptions storageRemoveOptions, Continuation continuation, int r4, Object obj) throws StorageException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    storageRemoveOptions = StorageRemoveOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageRemoveOptions, "defaultInstance()");
                }
                return storage.remove(str, storageRemoveOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
        }

        public static /* synthetic */ InProgressStorageOperation uploadFile$default(Storage storage, String str, File file, StorageUploadFileOptions storageUploadFileOptions, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 4) != 0) {
                    storageUploadFileOptions = StorageUploadFileOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageUploadFileOptions, "defaultInstance()");
                }
                return storage.uploadFile(str, file, storageUploadFileOptions);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }

        public static /* synthetic */ InProgressStorageOperation uploadInputStream$default(Storage storage, String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 4) != 0) {
                    storageUploadInputStreamOptions = StorageUploadInputStreamOptions.defaultInstance();
                    Intrinsics.checkNotNullExpressionValue(storageUploadInputStreamOptions, "defaultInstance()");
                }
                return storage.uploadInputStream(str, inputStream, storageUploadInputStreamOptions);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadInputStream");
        }
    }

    /* compiled from: Storage.kt */
    /* loaded from: classes.dex */
    public static final class InProgressStorageOperation<T> implements Cancelable, Resumable {
        private final StorageTransferOperation<?, ?> delegate;
        private final Flow<StorageException> errors;
        private final Flow<StorageTransferProgress> progress;
        private final Flow<T> results;
        private final String transferId;

        /* JADX WARN: Multi-variable type inference failed */
        public InProgressStorageOperation(String transferId, Flow<? extends T> results, Flow<StorageTransferProgress> progress, Flow<StorageException> errors, StorageTransferOperation<?, ?> storageTransferOperation) {
            Intrinsics.checkNotNullParameter(transferId, "transferId");
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(errors, "errors");
            this.transferId = transferId;
            this.results = results;
            this.progress = progress;
            this.errors = errors;
            this.delegate = storageTransferOperation;
        }

        private final Flow<T> component2() {
            return this.results;
        }

        private final Flow<StorageTransferProgress> component3() {
            return this.progress;
        }

        private final Flow<StorageException> component4() {
            return this.errors;
        }

        private final StorageTransferOperation<?, ?> component5() {
            return this.delegate;
        }

        public static /* synthetic */ InProgressStorageOperation copy$default(InProgressStorageOperation inProgressStorageOperation, String str, Flow flow, Flow flow2, Flow flow3, StorageTransferOperation storageTransferOperation, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                str = inProgressStorageOperation.transferId;
            }
            if ((r9 & 2) != 0) {
                flow = inProgressStorageOperation.results;
            }
            Flow flow4 = flow;
            if ((r9 & 4) != 0) {
                flow2 = inProgressStorageOperation.progress;
            }
            Flow flow5 = flow2;
            if ((r9 & 8) != 0) {
                flow3 = inProgressStorageOperation.errors;
            }
            Flow flow6 = flow3;
            if ((r9 & 16) != 0) {
                storageTransferOperation = inProgressStorageOperation.delegate;
            }
            return inProgressStorageOperation.copy(str, flow4, flow5, flow6, storageTransferOperation);
        }

        @Override // com.amplifyframework.core.async.Cancelable
        public void cancel() {
            StorageTransferOperation<?, ?> storageTransferOperation = this.delegate;
            if (storageTransferOperation != null) {
                storageTransferOperation.cancel();
            }
        }

        public final String component1() {
            return this.transferId;
        }

        public final InProgressStorageOperation<T> copy(String transferId, Flow<? extends T> results, Flow<StorageTransferProgress> progress, Flow<StorageException> errors, StorageTransferOperation<?, ?> storageTransferOperation) {
            Intrinsics.checkNotNullParameter(transferId, "transferId");
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(errors, "errors");
            return new InProgressStorageOperation<>(transferId, results, progress, errors, storageTransferOperation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InProgressStorageOperation)) {
                return false;
            }
            InProgressStorageOperation inProgressStorageOperation = (InProgressStorageOperation) obj;
            if (Intrinsics.areEqual(this.transferId, inProgressStorageOperation.transferId) && Intrinsics.areEqual(this.results, inProgressStorageOperation.results) && Intrinsics.areEqual(this.progress, inProgressStorageOperation.progress) && Intrinsics.areEqual(this.errors, inProgressStorageOperation.errors) && Intrinsics.areEqual(this.delegate, inProgressStorageOperation.delegate)) {
                return true;
            }
            return false;
        }

        public final String getTransferId() {
            return this.transferId;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = (this.errors.hashCode() + ((this.progress.hashCode() + ((this.results.hashCode() + (this.transferId.hashCode() * 31)) * 31)) * 31)) * 31;
            StorageTransferOperation<?, ?> storageTransferOperation = this.delegate;
            if (storageTransferOperation == null) {
                hashCode = 0;
            } else {
                hashCode = storageTransferOperation.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @Override // com.amplifyframework.core.async.Resumable
        public void pause() {
            StorageTransferOperation<?, ?> storageTransferOperation = this.delegate;
            if (storageTransferOperation != null) {
                storageTransferOperation.pause();
            }
        }

        public final Flow<StorageTransferProgress> progress() {
            return this.progress;
        }

        public final Object result(Continuation<? super T> continuation) {
            final FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new Storage$InProgressStorageOperation$result$2(null), FlowKt.flattenMerge$default(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(new Flow[]{this.errors, this.results})));
            return FlowKt.first(new Flow<T>() { // from class: com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2", f = "Storage.kt", l = {224}, m = "emit")
                    /* renamed from: com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2$1 r0 = (com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2$1 r0 = new com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L3d
                        L27:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L3d
                            return r1
                        L3d:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.storage.Storage$InProgressStorageOperation$result$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                    if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }, continuation);
        }

        @Override // com.amplifyframework.core.async.Resumable
        public void resume() {
            StorageTransferOperation<?, ?> storageTransferOperation = this.delegate;
            if (storageTransferOperation != null) {
                storageTransferOperation.resume();
            }
        }

        public String toString() {
            return "InProgressStorageOperation(transferId=" + this.transferId + ", results=" + this.results + ", progress=" + this.progress + ", errors=" + this.errors + ", delegate=" + this.delegate + ')';
        }
    }

    InProgressStorageOperation<StorageDownloadFileResult> downloadFile(String str, File file, StorageDownloadFileOptions storageDownloadFileOptions);

    Object getTransfer(String str, Continuation<? super StorageTransferOperation<?, StorageTransferResult>> continuation) throws StorageException;

    Object getUrl(String str, StorageGetUrlOptions storageGetUrlOptions, Continuation<? super StorageGetUrlResult> continuation) throws StorageException;

    Object list(String str, StorageListOptions storageListOptions, Continuation<? super StorageListResult> continuation) throws StorageException;

    Object remove(String str, StorageRemoveOptions storageRemoveOptions, Continuation<? super StorageRemoveResult> continuation) throws StorageException;

    InProgressStorageOperation<StorageUploadFileResult> uploadFile(String str, File file, StorageUploadFileOptions storageUploadFileOptions);

    InProgressStorageOperation<StorageUploadInputStreamResult> uploadInputStream(String str, InputStream inputStream, StorageUploadInputStreamOptions storageUploadInputStreamOptions);
}
