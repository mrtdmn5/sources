package com.animaconnected.secondo.screens.pushers;

import android.content.Context;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.MapCallback;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class PushersPresenter extends BehaviourConfigurationBasePresenter {
    public PushersPresenter(Context context, BehaviourConfigurationBasePresenter.BehaviourConfigurationView behaviourConfigurationView, MainController mainController, PermissionCompat.PermissionHelper permissionHelper, WatchProvider watchProvider) {
        super(context, behaviourConfigurationView, permissionHelper);
        BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider = new BehaviourItemDragAndDropProvider(context, Slot.TopPusher, false);
        this.behaviourItemProvider = behaviourItemDragAndDropProvider;
        behaviourItemDragAndDropProvider.initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Slot lambda$getSlotFromBehaviourType$0(String str, List list) throws IOException {
        if (str.equals(((Behaviour) list.get(0)).getType())) {
            return Slot.TopPusher;
        }
        if (str.equals(((Behaviour) list.get(1)).getType())) {
            return Slot.BottomPusher;
        }
        return Slot.Unknown;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter
    public Future<Slot> getSlotFromBehaviourType(final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.TopPusher));
        arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.BottomPusher));
        return FutureUtils.merge(arrayList).map(new MapCallback() { // from class: com.animaconnected.secondo.screens.pushers.PushersPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.MapCallback
            public final Object onResult(Object obj) {
                Slot lambda$getSlotFromBehaviourType$0;
                lambda$getSlotFromBehaviourType$0 = PushersPresenter.lambda$getSlotFromBehaviourType$0(str, (List) obj);
                return lambda$getSlotFromBehaviourType$0;
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter
    public Slot getSlotFromGroup(int r3) {
        if (ProviderFactory.getWatch().getCapabilities().getNumOfButtons() == 3) {
            if (r3 != 0) {
                if (r3 != 1) {
                    return Slot.Unknown;
                }
                return Slot.BottomPusher;
            }
            return Slot.TopPusher;
        }
        return Slot.Unknown;
    }
}
