package com.animaconnected.future;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MergePromise<T> {
    private boolean mFailed;
    private int mNumSucceeded;
    private final Promise<List<T>> mPromise;

    public MergePromise(List<Future<T>> list) {
        Promise<List<T>> promise = new Promise<>();
        this.mPromise = promise;
        this.mFailed = false;
        this.mNumSucceeded = 0;
        final int size = list.size();
        final ArrayList arrayList = new ArrayList(size);
        if (size > 0) {
            for (final int r1 = 0; r1 < size; r1++) {
                Future<T> future = list.get(r1);
                arrayList.add(null);
                future.fail(new FailCallback() { // from class: com.animaconnected.future.MergePromise$$ExternalSyntheticLambda0
                    @Override // com.animaconnected.future.FailCallback
                    public final void onFail(Throwable th) {
                        MergePromise.this.lambda$new$0(th);
                    }
                });
                future.success(new SuccessCallback() { // from class: com.animaconnected.future.MergePromise$$ExternalSyntheticLambda1
                    @Override // com.animaconnected.future.SuccessCallback
                    public final void onSuccess(Object obj) {
                        MergePromise.this.lambda$new$1(arrayList, r1, size, obj);
                    }
                });
            }
            return;
        }
        promise.resolve(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Throwable th) {
        if (!this.mFailed) {
            this.mFailed = true;
            this.mPromise.reject(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(List list, int r2, int r3, Object obj) {
        list.set(r2, obj);
        int r22 = this.mNumSucceeded + 1;
        this.mNumSucceeded = r22;
        if (r22 == r3) {
            this.mPromise.resolve(list);
        }
    }

    public Future<List<T>> getFuture() {
        return this.mPromise.getFuture();
    }
}
