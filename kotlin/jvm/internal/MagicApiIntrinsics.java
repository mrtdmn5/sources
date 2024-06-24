package kotlin.jvm.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import io.reactivex.Observer;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class MagicApiIntrinsics implements zzdq {
    public static ICameraUpdateFactoryDelegate zza;

    /* renamed from: zza, reason: collision with other field name */
    public static final /* synthetic */ MagicApiIntrinsics f130zza = new MagicApiIntrinsics();

    public static final void closeIfCloseable(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof Closeable) {
            ((Closeable) obj).close();
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng != null) {
            try {
                ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate = zza;
                Preconditions.checkNotNull(iCameraUpdateFactoryDelegate, "CameraUpdateFactory is not initialized");
                return new CameraUpdate(iCameraUpdateFactoryDelegate.newLatLngZoom(latLng, f));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        throw new NullPointerException("latLng must not be null");
    }

    public static void onComplete(Observer observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                observer.onError(terminate);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void onError(Observer observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                observer.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public static void onNext(Observer observer, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    observer.onError(terminate);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzpd.zza.zza().zze());
    }
}
