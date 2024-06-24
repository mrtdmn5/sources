package androidx.loader.app;

import android.os.Bundle;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.android.gms.auth.api.signin.internal.zbw;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public final class LoaderManagerImpl extends LoaderManager {
    public final LifecycleOwner mLifecycleOwner;
    public final LoaderViewModel mLoaderViewModel;

    /* loaded from: classes.dex */
    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
        public LifecycleOwner mLifecycleOwner;
        public final Loader<D> mLoader;
        public LoaderObserver<D> mObserver;
        public final int mId = 0;
        public final Bundle mArgs = null;
        public Loader<D> mPriorLoader = null;

        public LoaderInfo(zbc zbcVar) {
            this.mLoader = zbcVar;
            if (zbcVar.mListener == null) {
                zbcVar.mListener = this;
                zbcVar.mId = 0;
                return;
            }
            throw new IllegalStateException("There is already a listener registered");
        }

        public final void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            LoaderObserver<D> loaderObserver = this.mObserver;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.removeObserver(loaderObserver);
                observe(lifecycleOwner, loaderObserver);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            Loader<D> loader = this.mLoader;
            loader.mStarted = true;
            loader.mReset = false;
            loader.mAbandoned = false;
            zbc zbcVar = (zbc) loader;
            zbcVar.zba.drainPermits();
            zbcVar.cancelLoad();
            zbcVar.mTask = new AsyncTaskLoader.LoadTask();
            zbcVar.executePendingTask();
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            this.mLoader.mStarted = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public final void removeObserver(Observer<? super D> observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public final void setValue(D d) {
            super.setValue(d);
            Loader<D> loader = this.mPriorLoader;
            if (loader != null) {
                loader.mReset = true;
                loader.mStarted = false;
                loader.mAbandoned = false;
                loader.mContentChanged = false;
                this.mPriorLoader = null;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.mId);
            sb.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderObserver<D> implements Observer<D> {
        public final LoaderManager.LoaderCallbacks<D> mCallback;
        public boolean mDeliveredData = false;

        public LoaderObserver(Loader loader, zbw zbwVar) {
            this.mCallback = zbwVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(D d) {
            zbw zbwVar = (zbw) this.mCallback;
            zbwVar.getClass();
            SignInHubActivity signInHubActivity = zbwVar.zba;
            signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
            signInHubActivity.finish();
            this.mDeliveredData = true;
        }

        public final String toString() {
            return this.mCallback.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class LoaderViewModel extends ViewModel {
        public static final AnonymousClass1 FACTORY = new AnonymousClass1();
        public final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat<>();
        public boolean mCreatingLoader = false;

        /* renamed from: androidx.loader.app.LoaderManagerImpl$LoaderViewModel$1 */
        /* loaded from: classes.dex */
        public static class AnonymousClass1 implements ViewModelProvider.Factory {
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public final <T extends ViewModel> T create(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            super.onCleared();
            SparseArrayCompat<LoaderInfo> sparseArrayCompat = this.mLoaders;
            int size = sparseArrayCompat.size();
            for (int r3 = 0; r3 < size; r3++) {
                LoaderInfo valueAt = sparseArrayCompat.valueAt(r3);
                Loader<D> loader = valueAt.mLoader;
                loader.cancelLoad();
                loader.mAbandoned = true;
                LoaderObserver<D> loaderObserver = valueAt.mObserver;
                if (loaderObserver != 0) {
                    valueAt.removeObserver(loaderObserver);
                    if (loaderObserver.mDeliveredData) {
                        loaderObserver.mCallback.getClass();
                    }
                }
                Object obj = loader.mListener;
                if (obj != null) {
                    if (obj == valueAt) {
                        loader.mListener = null;
                        loader.mReset = true;
                        loader.mStarted = false;
                        loader.mAbandoned = false;
                        loader.mContentChanged = false;
                    } else {
                        throw new IllegalArgumentException("Attempting to unregister the wrong listener");
                    }
                } else {
                    throw new IllegalStateException("No listener register");
                }
            }
            int r1 = sparseArrayCompat.mSize;
            Object[] objArr = sparseArrayCompat.mValues;
            for (int r5 = 0; r5 < r1; r5++) {
                objArr[r5] = null;
            }
            sparseArrayCompat.mSize = 0;
            sparseArrayCompat.mGarbage = false;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        this.mLoaderViewModel = (LoaderViewModel) new ViewModelProvider(viewModelStore, LoaderViewModel.FACTORY).get(LoaderViewModel.class);
    }

    @Deprecated
    public final void dump(String str, PrintWriter printWriter) {
        boolean z;
        LoaderViewModel loaderViewModel = this.mLoaderViewModel;
        if (loaderViewModel.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            for (int r3 = 0; r3 < loaderViewModel.mLoaders.size(); r3++) {
                LoaderInfo valueAt = loaderViewModel.mLoaders.valueAt(r3);
                printWriter.print(str);
                printWriter.print("  #");
                SparseArrayCompat<LoaderInfo> sparseArrayCompat = loaderViewModel.mLoaders;
                if (sparseArrayCompat.mGarbage) {
                    sparseArrayCompat.gc();
                }
                printWriter.print(sparseArrayCompat.mKeys[r3]);
                printWriter.print(": ");
                printWriter.println(valueAt.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(valueAt.mId);
                printWriter.print(" mArgs=");
                printWriter.println(valueAt.mArgs);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println(valueAt.mLoader);
                Object obj = valueAt.mLoader;
                String m = ComposableInvoker$$ExternalSyntheticOutline0.m(str2, "  ");
                AsyncTaskLoader asyncTaskLoader = (AsyncTaskLoader) obj;
                asyncTaskLoader.getClass();
                printWriter.print(m);
                printWriter.print("mId=");
                printWriter.print(asyncTaskLoader.mId);
                printWriter.print(" mListener=");
                printWriter.println(asyncTaskLoader.mListener);
                if (asyncTaskLoader.mStarted || asyncTaskLoader.mContentChanged) {
                    printWriter.print(m);
                    printWriter.print("mStarted=");
                    printWriter.print(asyncTaskLoader.mStarted);
                    printWriter.print(" mContentChanged=");
                    printWriter.print(asyncTaskLoader.mContentChanged);
                    printWriter.print(" mProcessingChange=");
                    printWriter.println(false);
                }
                if (asyncTaskLoader.mAbandoned || asyncTaskLoader.mReset) {
                    printWriter.print(m);
                    printWriter.print("mAbandoned=");
                    printWriter.print(asyncTaskLoader.mAbandoned);
                    printWriter.print(" mReset=");
                    printWriter.println(asyncTaskLoader.mReset);
                }
                if (asyncTaskLoader.mTask != null) {
                    printWriter.print(m);
                    printWriter.print("mTask=");
                    printWriter.print(asyncTaskLoader.mTask);
                    printWriter.print(" waiting=");
                    asyncTaskLoader.mTask.getClass();
                    printWriter.println(false);
                }
                if (asyncTaskLoader.mCancellingTask != null) {
                    printWriter.print(m);
                    printWriter.print("mCancellingTask=");
                    printWriter.print(asyncTaskLoader.mCancellingTask);
                    printWriter.print(" waiting=");
                    asyncTaskLoader.mCancellingTask.getClass();
                    printWriter.println(false);
                }
                if (valueAt.mObserver != null) {
                    printWriter.print(str2);
                    printWriter.print("mCallbacks=");
                    printWriter.println(valueAt.mObserver);
                    LoaderObserver<D> loaderObserver = valueAt.mObserver;
                    loaderObserver.getClass();
                    printWriter.print(str2 + "  ");
                    printWriter.print("mDeliveredData=");
                    printWriter.println(loaderObserver.mDeliveredData);
                }
                printWriter.print(str2);
                printWriter.print("mData=");
                Object obj2 = valueAt.mLoader;
                Object obj3 = valueAt.mData;
                if (obj3 == LiveData.NOT_SET) {
                    obj3 = null;
                }
                obj2.getClass();
                StringBuilder sb = new StringBuilder(64);
                DebugUtils.buildShortClassTag(obj3, sb);
                sb.append("}");
                printWriter.println(sb.toString());
                printWriter.print(str2);
                printWriter.print("mStarted=");
                if (valueAt.mActiveCount > 0) {
                    z = true;
                } else {
                    z = false;
                }
                printWriter.println(z);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
