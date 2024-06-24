package com.animaconnected.secondo.screens.complications;

import android.content.Context;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureUtils;
import com.animaconnected.future.MapCallback;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.behaviouritems.BehaviourItemDragAndDropProvider;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.device.WatchFacePosition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class ComplicationsPresenter extends BehaviourConfigurationBasePresenter {
    private final Behaviours behaviours;
    private final ComplicationsView mView;

    /* loaded from: classes3.dex */
    public interface ComplicationsView extends BehaviourConfigurationBasePresenter.BehaviourConfigurationView {
        int getDragAndDropProviderAdapterType();
    }

    public ComplicationsPresenter(Context context, ComplicationsView complicationsView, PermissionCompat.PermissionHelper permissionHelper, WatchProvider watchProvider, boolean z) {
        super(context, complicationsView, permissionHelper);
        this.behaviours = watchProvider.getWatchManager().getBehaviours();
        BehaviourItemDragAndDropProvider behaviourItemDragAndDropProvider = new BehaviourItemDragAndDropProvider(context, Slot.MainComplication, z);
        this.behaviourItemProvider = behaviourItemDragAndDropProvider;
        behaviourItemDragAndDropProvider.initData();
        this.mView = complicationsView;
    }

    private static WatchFacePosition getWatchFacePositionFromGroup(int r1) {
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 != 2) {
                    return null;
                }
                return WatchFacePosition.BottomRight;
            }
            if (ProviderFactory.getWatch().getCapabilities().hasOneSubComplication()) {
                return WatchFacePosition.BottomCenter;
            }
            return WatchFacePosition.BottomLeft;
        }
        return WatchFacePosition.Center;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Slot lambda$getSlotFromBehaviourType$0(String str, List list) throws IOException {
        if (str.equals(((Behaviour) list.get(0)).getType())) {
            return Slot.MainComplication;
        }
        if (str.equals(((Behaviour) list.get(1)).getType())) {
            return Slot.MainComplicationDouble;
        }
        return Slot.Unknown;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Slot lambda$getSlotFromBehaviourType$1(String str, List list) throws IOException {
        if (str.equals(((Behaviour) list.get(0)).getType())) {
            return Slot.SubComplication1;
        }
        if (str.equals(((Behaviour) list.get(1)).getType())) {
            return Slot.SubComplication2;
        }
        return Slot.Unknown;
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter
    public Future<Slot> getSlotFromBehaviourType(final String str) {
        ArrayList arrayList = new ArrayList();
        int dragAndDropProviderAdapterType = this.mView.getDragAndDropProviderAdapterType();
        if (dragAndDropProviderAdapterType != 0) {
            if (dragAndDropProviderAdapterType != 1) {
                if (dragAndDropProviderAdapterType != 2) {
                    return FutureUtils.just(Slot.Unknown);
                }
            } else {
                arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.SubComplication1));
                arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.SubComplication2));
                return FutureUtils.merge(arrayList).map(new MapCallback() { // from class: com.animaconnected.secondo.screens.complications.ComplicationsPresenter$$ExternalSyntheticLambda1
                    @Override // com.animaconnected.future.MapCallback
                    public final Object onResult(Object obj) {
                        Slot lambda$getSlotFromBehaviourType$1;
                        lambda$getSlotFromBehaviourType$1 = ComplicationsPresenter.lambda$getSlotFromBehaviourType$1(str, (List) obj);
                        return lambda$getSlotFromBehaviourType$1;
                    }
                });
            }
        }
        arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.MainComplication));
        arrayList.add(ProviderFactory.getWatch().getBehaviourAsFuture(Slot.MainComplicationDouble));
        return FutureUtils.merge(arrayList).map(new MapCallback() { // from class: com.animaconnected.secondo.screens.complications.ComplicationsPresenter$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.MapCallback
            public final Object onResult(Object obj) {
                Slot lambda$getSlotFromBehaviourType$0;
                lambda$getSlotFromBehaviourType$0 = ComplicationsPresenter.lambda$getSlotFromBehaviourType$0(str, (List) obj);
                return lambda$getSlotFromBehaviourType$0;
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourConfigurationBasePresenter
    public Slot getSlotFromGroup(int r2) {
        if (r2 == this.behaviourItemProvider.getGroupDoubleMainComplication()) {
            return Slot.MainComplicationDouble;
        }
        return this.behaviours.getSlotForWatchFace(ProviderFactory.getWatch().getCapabilities().getWatchFaceAtPosition(getWatchFacePositionFromGroup(r2)));
    }
}
