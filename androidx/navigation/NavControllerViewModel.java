package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes.dex */
public final class NavControllerViewModel extends ViewModel {
    public static final AnonymousClass1 FACTORY = new AnonymousClass1();
    public final HashMap<UUID, ViewModelStore> mViewModelStores = new HashMap<>();

    /* renamed from: androidx.navigation.NavControllerViewModel$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ViewModelProvider.Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> cls) {
            return new NavControllerViewModel();
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        HashMap<UUID, ViewModelStore> hashMap = this.mViewModelStores;
        Iterator<ViewModelStore> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        hashMap.clear();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.mViewModelStores.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
