package com.polidea.rxandroidble2.internal.operations;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;

/* loaded from: classes3.dex */
public abstract class ScanOperation<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends QueueOperation<SCAN_RESULT_TYPE> {
    public final RxBleAdapterWrapper rxBleAdapterWrapper;

    /* renamed from: com.polidea.rxandroidble2.internal.operations.ScanOperation$1 */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 implements Cancellable {
        public final /* synthetic */ Object val$scanCallback;

        public AnonymousClass1(Object obj) {
            r2 = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            RxBleLog.i("Scan operation is requested to stop.", new Object[0]);
            ScanOperation scanOperation = ScanOperation.this;
            scanOperation.stopScan(scanOperation.rxBleAdapterWrapper, r2);
        }
    }

    public ScanOperation(RxBleAdapterWrapper rxBleAdapterWrapper) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
    }

    public abstract Object createScanCallback(ObservableCreate.CreateEmitter createEmitter);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) {
        Object createScanCallback = createScanCallback(createEmitter);
        try {
            DisposableHelper.set(createEmitter, new CancellableDisposable(new Cancellable() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperation.1
                public final /* synthetic */ Object val$scanCallback;

                public AnonymousClass1(Object createScanCallback2) {
                    r2 = createScanCallback2;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.functions.Cancellable
                public final void cancel() {
                    RxBleLog.i("Scan operation is requested to stop.", new Object[0]);
                    ScanOperation scanOperation = ScanOperation.this;
                    scanOperation.stopScan(scanOperation.rxBleAdapterWrapper, r2);
                }
            }));
            RxBleLog.i("Scan operation is requested to start.", new Object[0]);
            if (!startScan(this.rxBleAdapterWrapper, createScanCallback2)) {
                createEmitter.tryOnError(new BleScanException(0));
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final BleException provideException(DeadObjectException deadObjectException) {
        return new BleScanException(1, deadObjectException);
    }

    public abstract boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);

    public abstract void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);
}
