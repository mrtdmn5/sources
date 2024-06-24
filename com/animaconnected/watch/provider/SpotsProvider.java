package com.animaconnected.watch.provider;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.StorageFactory;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.provider.SpotsProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: SpotsProvider.kt */
/* loaded from: classes3.dex */
public final class SpotsProvider {
    public static final Companion Companion = new Companion(null);
    private static final String MODEL = "spots";
    private static final String PREFERENCES_NAME = "com.kronaby.watch.spotsprovider";
    private static final String TAG = "SpotsProvider";
    private final Set<WeakReference<SpotsProviderListener>> listeners;
    private final Lazy spots$delegate;
    private final BasicStorage storage;

    /* compiled from: SpotsProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpotsProvider getInstance() {
            return ServiceLocator.INSTANCE.getSpotsProvider();
        }

        private Companion() {
        }
    }

    /* compiled from: SpotsProvider.kt */
    /* loaded from: classes3.dex */
    public interface SpotsProviderListener {
        void onSpotAdded(int r1);

        void onSpotRemoved(int r1);

        void onSpotRenamed(int r1);
    }

    public SpotsProvider(StorageFactory storageFactory) {
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        this.storage = storageFactory.createStorage(PREFERENCES_NAME);
        this.spots$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<Spot>>() { // from class: com.animaconnected.watch.provider.SpotsProvider$spots$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Spot> invoke() {
                final ArrayList<Spot> arrayList;
                try {
                    Json.Default r1 = Json.Default;
                    String string = SpotsProvider.this.getStorage().getString("spots");
                    Intrinsics.checkNotNull(string);
                    r1.getClass();
                    arrayList = new ArrayList<>((Collection<? extends Spot>) r1.decodeFromString(new ArrayListSerializer(Spot.Companion.serializer()), string));
                } catch (Exception unused) {
                    arrayList = new ArrayList<>();
                }
                LogKt.verbose$default((Object) SpotsProvider.this, "SpotsProvider", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$spots$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "load: " + arrayList;
                    }
                }, 6, (Object) null);
                return arrayList;
            }
        });
        this.listeners = new LinkedHashSet();
    }

    public static final SpotsProvider getInstance() {
        return Companion.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Spot> getSpots() {
        return (ArrayList) this.spots$delegate.getValue();
    }

    private final void save() {
        BasicStorage basicStorage = this.storage;
        Json.Default r1 = Json.Default;
        ArrayList<Spot> spots = getSpots();
        r1.getClass();
        basicStorage.put(MODEL, r1.encodeToString(new ArrayListSerializer(Spot.Companion.serializer()), spots));
        LogKt.verbose$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$save$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                ArrayList spots2;
                StringBuilder sb = new StringBuilder("save: ");
                spots2 = SpotsProvider.this.getSpots();
                sb.append(spots2);
                return sb.toString();
            }
        }, 6, (Object) null);
    }

    public final void addSpot(final Spot spot) {
        Intrinsics.checkNotNullParameter(spot, "spot");
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$addSpot$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "addSpot() called with: spot = [" + Spot.this + ']';
            }
        }, 6, (Object) null);
        getSpots().add(0, spot);
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$addSpot$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                ArrayList spots;
                StringBuilder sb = new StringBuilder("addSpot: ");
                spots = SpotsProvider.this.getSpots();
                sb.append(spots);
                return sb.toString();
            }
        }, 6, (Object) null);
        Set<WeakReference<SpotsProviderListener>> set = this.listeners;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            SpotsProviderListener spotsProviderListener = (SpotsProviderListener) ((WeakReference) it.next()).get();
            if (spotsProviderListener != null) {
                arrayList.add(spotsProviderListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.mainDispatcher(), null, new SpotsProvider$addSpot$4$1((SpotsProviderListener) it2.next(), null), 2);
        }
        save();
    }

    public final List<Spot> getAllSpots() {
        LogKt.verbose$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$allSpots$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                ArrayList spots;
                StringBuilder sb = new StringBuilder("getAllSpots: ");
                spots = SpotsProvider.this.getSpots();
                sb.append(spots);
                return sb.toString();
            }
        }, 6, (Object) null);
        return CollectionsKt___CollectionsKt.toList(getSpots());
    }

    public final Spot getFirstSpot() {
        return (Spot) CollectionsKt___CollectionsKt.firstOrNull((List) getSpots());
    }

    public final Spot getSpot(final int r8) {
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$getSpot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                ArrayList spots;
                StringBuilder sb = new StringBuilder("getSpot() called with: index = [");
                sb.append(r8);
                sb.append("] spots: ");
                spots = this.getSpots();
                sb.append(spots);
                return sb.toString();
            }
        }, 6, (Object) null);
        return (Spot) CollectionsKt___CollectionsKt.getOrNull(r8, getSpots());
    }

    public final BasicStorage getStorage() {
        return this.storage;
    }

    public final void registerSpotsProviderListener(SpotsProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(new WeakReference<>(listener));
        Set<WeakReference<SpotsProviderListener>> set = this.listeners;
        SpotsProvider$registerSpotsProviderListener$1 predicate = new Function1<WeakReference<SpotsProviderListener>, Boolean>() { // from class: com.animaconnected.watch.provider.SpotsProvider$registerSpotsProviderListener$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<SpotsProvider.SpotsProviderListener> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        };
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        CollectionsKt__ReversedViewsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(set, predicate);
    }

    public final void removeSpot(Spot spot) {
        Intrinsics.checkNotNullParameter(spot, "spot");
        removeSpot(getSpots().indexOf(spot));
    }

    public final void unregisterSpotsProviderListener(final SpotsProviderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<WeakReference<SpotsProviderListener>> set = this.listeners;
        Function1<WeakReference<SpotsProviderListener>, Boolean> function1 = new Function1<WeakReference<SpotsProviderListener>, Boolean>() { // from class: com.animaconnected.watch.provider.SpotsProvider$unregisterSpotsProviderListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(WeakReference<SpotsProvider.SpotsProviderListener> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.get(), SpotsProvider.SpotsProviderListener.this));
            }
        };
        Intrinsics.checkNotNullParameter(set, "<this>");
        CollectionsKt__ReversedViewsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(set, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateSpotName(Spot spot, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(spot, "spot");
        Iterator it = CollectionsKt___CollectionsKt.withIndex(getSpots()).iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it;
            if (!indexingIterator.hasNext()) {
                obj = null;
                break;
            } else {
                obj = indexingIterator.next();
                if (((Spot) ((IndexedValue) obj).value).timeStamp == spot.timeStamp) {
                    break;
                }
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null) {
            updateSpotName(indexedValue.index, str);
        }
    }

    public final void removeSpot(final int r14) {
        if (r14 != -1) {
            getSpots().remove(r14);
            LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$removeSpot$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ArrayList spots;
                    StringBuilder sb = new StringBuilder("removeSpot: ");
                    spots = SpotsProvider.this.getSpots();
                    sb.append(spots);
                    return sb.toString();
                }
            }, 6, (Object) null);
            Set<WeakReference<SpotsProviderListener>> set = this.listeners;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                SpotsProviderListener spotsProviderListener = (SpotsProviderListener) ((WeakReference) it.next()).get();
                if (spotsProviderListener != null) {
                    arrayList.add(spotsProviderListener);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.mainDispatcher(), null, new SpotsProvider$removeSpot$3$1((SpotsProviderListener) it2.next(), r14, null), 2);
            }
            save();
            return;
        }
        LogKt.debug$default((Object) this, TAG, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.SpotsProvider$removeSpot$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "cant find spot at: " + r14;
            }
        }, 6, (Object) null);
    }

    public final void updateSpotName(int r20, String str) {
        ArrayList<Spot> spots = getSpots();
        Spot spot = getSpots().get(r20);
        Intrinsics.checkNotNullExpressionValue(spot, "get(...)");
        spots.set(r20, Spot.copy$default(spot, 0L, 0.0d, 0.0d, null, 0.0f, str, 0.0d, null, 223, null));
        Set<WeakReference<SpotsProviderListener>> set = this.listeners;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            SpotsProviderListener spotsProviderListener = (SpotsProviderListener) ((WeakReference) it.next()).get();
            if (spotsProviderListener != null) {
                arrayList.add(spotsProviderListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.mainDispatcher(), null, new SpotsProvider$updateSpotName$4$1((SpotsProviderListener) it2.next(), r20, null), 2);
        }
        save();
    }
}
