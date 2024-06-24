package androidx.compose.runtime;

import android.os.Trace;
import android.util.SparseArray;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.google.common.collect.Platform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class ComposerImpl implements Composer {
    public final Set<RememberObserver> abandonSet;
    public final Applier<?> applier;
    public List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    public int childrenComposing;
    public final ControlledComposition composition;
    public int compositionToken;
    public int compoundKeyHash;
    public ArrayList deferredChanges;
    public final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    public final Stack<Object> downNodes;
    public final IntStack entersStack;
    public boolean forceRecomposeScopes;
    public int groupNodeCount;
    public final IntStack groupNodeCountStack;
    public boolean implicitRootStart;
    public Anchor insertAnchor;
    public final ArrayList insertFixups;
    public SlotTable insertTable;
    public final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    public boolean inserting;
    public final Stack<RecomposeScopeImpl> invalidateStack;
    public final ArrayList invalidations;
    public boolean isComposing;
    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    public int[] nodeCountOverrides;
    public HashMap<Integer, Integer> nodeCountVirtualOverrides;
    public boolean nodeExpected;
    public int nodeIndex;
    public final IntStack nodeIndexStack;
    public final CompositionContext parentContext;
    public PersistentCompositionLocalMap parentProvider;
    public Pending pending;
    public final Stack<Pending> pendingStack;
    public int pendingUps;
    public int previousCount;
    public int previousMoveFrom;
    public int previousMoveTo;
    public int previousRemove;
    public PersistentCompositionLocalMap providerCache;
    public final IntMap providerUpdates;
    public boolean providersInvalid;
    public final IntStack providersInvalidStack;
    public SlotReader reader;
    public boolean reusing;
    public int reusingGroup;
    public final SlotTable slotTable;
    public boolean startedGroup;
    public final IntStack startedGroups;
    public SlotWriter writer;
    public boolean writerHasAProvider;
    public int writersReaderDelta;

    /* compiled from: Composer.kt */
    /* loaded from: classes.dex */
    public final class CompositionContextImpl extends CompositionContext {
        public final boolean collectingParameterInformation;
        public final LinkedHashSet composers = new LinkedHashSet();
        public final ParcelableSnapshotMutableState compositionLocalScope$delegate = Platform.mutableStateOf$default(PersistentCompositionLocalHashMap.Empty);
        public final int compoundHashKey;
        public HashSet inspectionTables;

        public CompositionContextImpl(int r2, boolean z) {
            this.compoundHashKey = r2;
            this.collectingParameterInformation = z;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void composeInitial$runtime_release(ControlledComposition composition, ComposableLambdaImpl composableLambdaImpl) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.composeInitial$runtime_release(composition, composableLambdaImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void deletedMovableContent$runtime_release(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.parentContext.deletedMovableContent$runtime_release(movableContentStateReference);
        }

        public final void dispose() {
            LinkedHashSet<ComposerImpl> linkedHashSet = this.composers;
            if (!linkedHashSet.isEmpty()) {
                HashSet hashSet = this.inspectionTables;
                if (hashSet != null) {
                    for (ComposerImpl composerImpl : linkedHashSet) {
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            ((Set) it.next()).remove(composerImpl.slotTable);
                        }
                    }
                }
                linkedHashSet.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void doneComposing$runtime_release() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void invalidate$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.parentContext.invalidate$runtime_release(composerImpl.composition);
            composerImpl.parentContext.invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void movableContentStateReleased$runtime_release(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState) {
            ComposerImpl.this.parentContext.movableContentStateReleased$runtime_release(movableContentStateReference, movableContentState);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
            Intrinsics.checkNotNullParameter(reference, "reference");
            return ComposerImpl.this.parentContext.movableContentStateResolve$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void recordInspectionTable$runtime_release(Set<Object> set) {
            HashSet hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void registerComposer$runtime_release(ComposerImpl composerImpl) {
            this.composers.add(composerImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void reportRemovedComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.reportRemovedComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void startComposing$runtime_release() {
            ComposerImpl.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void unregisterComposer$runtime_release(Composer composer) {
            Intrinsics.checkNotNullParameter(composer, "composer");
            HashSet hashSet = this.inspectionTables;
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(((ComposerImpl) composer).slotTable);
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void unregisterComposition$runtime_release(ControlledComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            ComposerImpl.this.parentContext.unregisterComposition$runtime_release(composition);
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(AbstractApplier abstractApplier, CompositionContext parentContext, SlotTable slotTable, HashSet hashSet, ArrayList arrayList, ArrayList arrayList2, ControlledComposition composition) {
        Intrinsics.checkNotNullParameter(parentContext, "parentContext");
        Intrinsics.checkNotNullParameter(composition, "composition");
        this.applier = abstractApplier;
        this.parentContext = parentContext;
        this.slotTable = slotTable;
        this.abandonSet = hashSet;
        this.changes = arrayList;
        this.lateChanges = arrayList2;
        this.composition = composition;
        this.pendingStack = new Stack<>();
        this.nodeIndexStack = new IntStack();
        this.groupNodeCountStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.parentProvider = PersistentCompositionLocalHashMap.Empty;
        this.providerUpdates = new IntMap(new SparseArray(10));
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public final void done(DerivedState<?> derivedState) {
                Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                ComposerImpl composerImpl = ComposerImpl.this;
                composerImpl.childrenComposing--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public final void start(DerivedState<?> derivedState) {
                Intrinsics.checkNotNullParameter(derivedState, "derivedState");
                ComposerImpl.this.childrenComposing++;
            }
        };
        this.invalidateStack = new Stack<>();
        SlotReader openReader = slotTable.openReader();
        openReader.close();
        this.reader = openReader;
        SlotTable slotTable2 = new SlotTable();
        this.insertTable = slotTable2;
        SlotWriter openWriter = slotTable2.openWriter();
        openWriter.close();
        this.writer = openWriter;
        SlotReader openReader2 = this.insertTable.openReader();
        try {
            Anchor anchor = openReader2.anchor(0);
            openReader2.close();
            this.insertAnchor = anchor;
            this.insertFixups = new ArrayList();
            this.downNodes = new Stack<>();
            this.implicitRootStart = true;
            this.startedGroups = new IntStack();
            this.insertUpFixups = new Stack<>();
            this.previousRemove = -1;
            this.previousMoveFrom = -1;
            this.previousMoveTo = -1;
        } catch (Throwable th) {
            openReader2.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:3:0x000c, B:5:0x0012, B:6:0x0017, B:11:0x002e, B:12:0x003b, B:17:0x001d), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.jvm.internal.Lambda, androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void access$invokeMovableContentLambda(androidx.compose.runtime.ComposerImpl r6, final androidx.compose.runtime.MovableContent r7, androidx.compose.runtime.PersistentCompositionLocalMap r8, final java.lang.Object r9) {
        /*
            r0 = 126665345(0x78cc281, float:2.1179178E-34)
            r6.startMovableGroup(r0, r7)
            r6.changed(r9)
            int r1 = r6.compoundKeyHash
            r2 = 0
            r6.compoundKeyHash = r0     // Catch: java.lang.Throwable -> L62
            boolean r0 = r6.inserting     // Catch: java.lang.Throwable -> L62
            if (r0 == 0) goto L17
            androidx.compose.runtime.SlotWriter r0 = r6.writer     // Catch: java.lang.Throwable -> L62
            androidx.compose.runtime.SlotWriter.markGroup$default(r0)     // Catch: java.lang.Throwable -> L62
        L17:
            boolean r0 = r6.inserting     // Catch: java.lang.Throwable -> L62
            r3 = 1
            if (r0 == 0) goto L1d
            goto L2b
        L1d:
            androidx.compose.runtime.SlotReader r0 = r6.reader     // Catch: java.lang.Throwable -> L62
            java.lang.Object r0 = r0.getGroupAux()     // Catch: java.lang.Throwable -> L62
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L2b
            r0 = r3
            goto L2c
        L2b:
            r0 = r2
        L2c:
            if (r0 == 0) goto L3b
            androidx.compose.runtime.collection.IntMap r4 = r6.providerUpdates     // Catch: java.lang.Throwable -> L62
            androidx.compose.runtime.SlotReader r5 = r6.reader     // Catch: java.lang.Throwable -> L62
            int r5 = r5.currentGroup     // Catch: java.lang.Throwable -> L62
            java.lang.Object r4 = r4.sparseArray     // Catch: java.lang.Throwable -> L62
            android.util.SparseArray r4 = (android.util.SparseArray) r4     // Catch: java.lang.Throwable -> L62
            r4.put(r5, r8)     // Catch: java.lang.Throwable -> L62
        L3b:
            androidx.compose.runtime.OpaqueKey r4 = androidx.compose.runtime.ComposerKt.compositionLocalMap     // Catch: java.lang.Throwable -> L62
            r5 = 202(0xca, float:2.83E-43)
            r6.m227startBaiHCIY(r5, r2, r4, r8)     // Catch: java.lang.Throwable -> L62
            boolean r8 = r6.inserting     // Catch: java.lang.Throwable -> L62
            boolean r8 = r6.providersInvalid     // Catch: java.lang.Throwable -> L62
            r6.providersInvalid = r0     // Catch: java.lang.Throwable -> L62
            androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1 r0 = new androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1     // Catch: java.lang.Throwable -> L62
            r0.<init>()     // Catch: java.lang.Throwable -> L62
            r7 = 316014703(0x12d6006f, float:1.3505406E-27)
            androidx.compose.runtime.internal.ComposableLambdaImpl r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r7, r0, r3)     // Catch: java.lang.Throwable -> L62
            kotlin.collections.SetsKt__SetsKt.invokeComposable(r6, r7)     // Catch: java.lang.Throwable -> L62
            r6.providersInvalid = r8     // Catch: java.lang.Throwable -> L62
            r6.end(r2)
            r6.compoundKeyHash = r1
            r6.end(r2)
            return
        L62:
            r7 = move-exception
            r6.end(r2)
            r6.compoundKeyHash = r1
            r6.end(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.access$invokeMovableContentLambda(androidx.compose.runtime.ComposerImpl, androidx.compose.runtime.MovableContent, androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object):void");
    }

    public static final void insertMovableContentGuarded$positionToParentOf(SlotWriter slotWriter, Applier<Object> applier, int r4) {
        boolean z;
        while (true) {
            int r0 = slotWriter.parent;
            if ((r4 > r0 && r4 < slotWriter.currentGroupEnd) || (r0 == 0 && r4 == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                slotWriter.skipToGroupEnd();
                if (slotWriter.isNode(slotWriter.parent)) {
                    applier.up();
                }
                slotWriter.endGroup();
            } else {
                return;
            }
        }
    }

    public static final int reportFreeMovableContent$reportGroup(final ComposerImpl composerImpl, int r18, boolean z, int r20) {
        boolean z2;
        boolean z3;
        int r9;
        CompositionContextHolder compositionContextHolder;
        boolean z4;
        SlotReader slotReader = composerImpl.reader;
        int[] r4 = slotReader.groups;
        int r5 = r18 * 5;
        int r8 = 1;
        if ((r4[r5 + 1] & 134217728) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            int r52 = r4[r5];
            Object objectKey = slotReader.objectKey(r4, r18);
            CompositionContext compositionContext = composerImpl.parentContext;
            if (r52 == 126665345 && (objectKey instanceof MovableContent)) {
                MovableContent movableContent = (MovableContent) objectKey;
                Object groupGet = composerImpl.reader.groupGet(r18, 0);
                Anchor anchor = composerImpl.reader.anchor(r18);
                int groupSize = composerImpl.reader.groupSize(r18) + r18;
                ArrayList arrayList = composerImpl.invalidations;
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ArrayList arrayList2 = new ArrayList();
                int findLocation = ComposerKt.findLocation(r18, arrayList);
                if (findLocation < 0) {
                    findLocation = -(findLocation + 1);
                }
                while (findLocation < arrayList.size()) {
                    Invalidation invalidation = (Invalidation) arrayList.get(findLocation);
                    if (invalidation.location >= groupSize) {
                        break;
                    }
                    arrayList2.add(invalidation);
                    findLocation++;
                }
                ArrayList arrayList3 = new ArrayList(arrayList2.size());
                int size = arrayList2.size();
                for (int r42 = 0; r42 < size; r42++) {
                    Invalidation invalidation2 = (Invalidation) arrayList2.get(r42);
                    arrayList3.add(new Pair(invalidation2.scope, invalidation2.instances));
                }
                final MovableContentStateReference movableContentStateReference = new MovableContentStateReference(movableContent, groupGet, composerImpl.composition, composerImpl.slotTable, anchor, arrayList3, composerImpl.currentCompositionLocalScope(r18));
                compositionContext.deletedMovableContent$runtime_release(movableContentStateReference);
                composerImpl.recordSlotEditing();
                composerImpl.record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$reportFreeMovableContent$reportGroup$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2 A[LOOP:0: B:9:0x0060->B:24:0x00a2, LOOP_END] */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0 A[SYNTHETIC] */
                    @Override // kotlin.jvm.functions.Function3
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final kotlin.Unit invoke(androidx.compose.runtime.Applier<?> r11, androidx.compose.runtime.SlotWriter r12, androidx.compose.runtime.RememberManager r13) {
                        /*
                            r10 = this;
                            r0 = r11
                            androidx.compose.runtime.Applier r0 = (androidx.compose.runtime.Applier) r0
                            androidx.compose.runtime.SlotWriter r12 = (androidx.compose.runtime.SlotWriter) r12
                            r4 = r13
                            androidx.compose.runtime.RememberManager r4 = (androidx.compose.runtime.RememberManager) r4
                            java.lang.String r1 = "<anonymous parameter 0>"
                            java.lang.String r3 = "slots"
                            java.lang.String r5 = "<anonymous parameter 2>"
                            r2 = r12
                            androidx.compose.runtime.ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(r0, r1, r2, r3, r4, r5)
                            androidx.compose.runtime.MovableContentStateReference r11 = r2
                            androidx.compose.runtime.ComposerImpl r13 = androidx.compose.runtime.ComposerImpl.this
                            r13.getClass()
                            androidx.compose.runtime.SlotTable r0 = new androidx.compose.runtime.SlotTable
                            r0.<init>()
                            androidx.compose.runtime.SlotWriter r1 = r0.openWriter()
                            r1.beginInsert()     // Catch: java.lang.Throwable -> Lcc
                            androidx.compose.runtime.MovableContent<java.lang.Object> r2 = r11.content     // Catch: java.lang.Throwable -> Lcc
                            androidx.compose.runtime.Composer$Companion$Empty$1 r3 = androidx.compose.runtime.Composer.Companion.Empty
                            r4 = 0
                            r5 = 126665345(0x78cc281, float:2.1179178E-34)
                            r1.startGroup(r5, r2, r3, r4)     // Catch: java.lang.Throwable -> Lcc
                            androidx.compose.runtime.SlotWriter.markGroup$default(r1)     // Catch: java.lang.Throwable -> Lcc
                            java.lang.Object r2 = r11.parameter     // Catch: java.lang.Throwable -> Lcc
                            r1.update(r2)     // Catch: java.lang.Throwable -> Lcc
                            androidx.compose.runtime.Anchor r2 = r11.anchor     // Catch: java.lang.Throwable -> Lcc
                            java.util.List r12 = r12.moveTo(r2, r1)     // Catch: java.lang.Throwable -> Lcc
                            r1.skipGroup()     // Catch: java.lang.Throwable -> Lcc
                            r1.endGroup()     // Catch: java.lang.Throwable -> Lcc
                            r1.endInsert()     // Catch: java.lang.Throwable -> Lcc
                            r1.close()
                            androidx.compose.runtime.MovableContentState r1 = new androidx.compose.runtime.MovableContentState
                            r1.<init>(r0)
                            r2 = r12
                            java.util.Collection r2 = (java.util.Collection) r2
                            boolean r2 = r2.isEmpty()
                            r5 = 1
                            r2 = r2 ^ r5
                            if (r2 == 0) goto La9
                            int r2 = r12.size()
                            r6 = r4
                        L60:
                            if (r6 >= r2) goto La5
                            java.lang.Object r7 = r12.get(r6)
                            androidx.compose.runtime.Anchor r7 = (androidx.compose.runtime.Anchor) r7
                            boolean r8 = r0.ownsAnchor(r7)
                            if (r8 == 0) goto L9d
                            int r7 = r0.anchorIndex(r7)
                            int[] r8 = r0.groups
                            int r8 = androidx.compose.runtime.SlotTableKt.access$slotAnchor(r8, r7)
                            int r7 = r7 + r5
                            int r9 = r0.groupsSize
                            if (r7 >= r9) goto L84
                            int[] r9 = r0.groups
                            int r7 = androidx.compose.runtime.SlotTableKt.access$dataAnchor(r9, r7)
                            goto L87
                        L84:
                            java.lang.Object[] r7 = r0.slots
                            int r7 = r7.length
                        L87:
                            int r7 = r7 - r8
                            if (r7 <= 0) goto L8c
                            r7 = r5
                            goto L8d
                        L8c:
                            r7 = r4
                        L8d:
                            if (r7 == 0) goto L96
                            java.lang.Object[] r7 = r0.slots
                            int r8 = r8 + 0
                            r7 = r7[r8]
                            goto L97
                        L96:
                            r7 = r3
                        L97:
                            boolean r7 = r7 instanceof androidx.compose.runtime.RecomposeScopeImpl
                            if (r7 == 0) goto L9d
                            r7 = r5
                            goto L9e
                        L9d:
                            r7 = r4
                        L9e:
                            if (r7 == 0) goto La2
                            r2 = r5
                            goto La6
                        La2:
                            int r6 = r6 + 1
                            goto L60
                        La5:
                            r2 = r4
                        La6:
                            if (r2 == 0) goto La9
                            r4 = r5
                        La9:
                            if (r4 == 0) goto Lc4
                            androidx.compose.runtime.ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1 r2 = new androidx.compose.runtime.ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1
                            androidx.compose.runtime.ControlledComposition r3 = r13.composition
                            r2.<init>()
                            androidx.compose.runtime.SlotWriter r0 = r0.openWriter()
                            androidx.compose.runtime.RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime_release(r0, r12, r2)     // Catch: java.lang.Throwable -> Lbf
                            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbf
                            r0.close()
                            goto Lc4
                        Lbf:
                            r11 = move-exception
                            r0.close()
                            throw r11
                        Lc4:
                            androidx.compose.runtime.CompositionContext r12 = r13.parentContext
                            r12.movableContentStateReleased$runtime_release(r11, r1)
                            kotlin.Unit r11 = kotlin.Unit.INSTANCE
                            return r11
                        Lcc:
                            r11 = move-exception
                            r1.close()
                            throw r11
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl$reportFreeMovableContent$reportGroup$1.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
                    }
                });
                if (z) {
                    composerImpl.realizeMovement();
                    composerImpl.realizeUps();
                    composerImpl.realizeDowns$1();
                    if (!composerImpl.reader.isNode(r18)) {
                        r8 = composerImpl.reader.nodeCount(r18);
                    }
                    if (r8 <= 0) {
                        return 0;
                    }
                    composerImpl.recordRemoveNode(r20, r8);
                    return 0;
                }
                return composerImpl.reader.nodeCount(r18);
            }
            if (r52 == 206 && Intrinsics.areEqual(objectKey, ComposerKt.reference)) {
                Object groupGet2 = composerImpl.reader.groupGet(r18, 0);
                if (groupGet2 instanceof CompositionContextHolder) {
                    compositionContextHolder = (CompositionContextHolder) groupGet2;
                } else {
                    compositionContextHolder = null;
                }
                if (compositionContextHolder != null) {
                    for (ComposerImpl composerImpl2 : compositionContextHolder.ref.composers) {
                        SlotTable slotTable = composerImpl2.slotTable;
                        if (slotTable.groupsSize > 0 && SlotTableKt.access$containsMark(slotTable.groups, 0)) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            ArrayList arrayList4 = new ArrayList();
                            composerImpl2.deferredChanges = arrayList4;
                            SlotReader openReader = slotTable.openReader();
                            try {
                                composerImpl2.reader = openReader;
                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = composerImpl2.changes;
                                try {
                                    composerImpl2.changes = arrayList4;
                                    composerImpl2.reportFreeMovableContent(0);
                                    composerImpl2.realizeUps();
                                    if (composerImpl2.startedGroup) {
                                        composerImpl2.record(ComposerKt.skipToGroupEndInstance);
                                        if (composerImpl2.startedGroup) {
                                            composerImpl2.recordSlotTableOperation(false, ComposerKt.endGroupInstance);
                                            composerImpl2.startedGroup = false;
                                        }
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    composerImpl2.changes = list;
                                } catch (Throwable th) {
                                    composerImpl2.changes = list;
                                    throw th;
                                }
                            } finally {
                                openReader.close();
                            }
                        }
                        compositionContext.reportRemovedComposition$runtime_release(composerImpl2.composition);
                    }
                }
                return composerImpl.reader.nodeCount(r18);
            }
            return composerImpl.reader.nodeCount(r18);
        }
        if (SlotTableKt.access$containsMark(r4, r18)) {
            int groupSize2 = composerImpl.reader.groupSize(r18) + r18;
            int r1 = r18 + 1;
            int r43 = 0;
            while (r1 < groupSize2) {
                boolean isNode = composerImpl.reader.isNode(r1);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl.downNodes.push(composerImpl.reader.node(r1));
                }
                if (!isNode && !z) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (isNode) {
                    r9 = 0;
                } else {
                    r9 = r20 + r43;
                }
                r43 += reportFreeMovableContent$reportGroup(composerImpl, r1, z3, r9);
                if (isNode) {
                    composerImpl.realizeMovement();
                    composerImpl.recordUp();
                }
                r1 += composerImpl.reader.groupSize(r1);
            }
            return r43;
        }
        return composerImpl.reader.nodeCount(r18);
    }

    public final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.backing.clear();
        this.nodeIndexStack.tos = 0;
        this.groupNodeCountStack.tos = 0;
        this.entersStack.tos = 0;
        this.providersInvalidStack.tos = 0;
        ((SparseArray) this.providerUpdates.sparseArray).clear();
        SlotReader slotReader = this.reader;
        if (!slotReader.closed) {
            slotReader.close();
        }
        SlotWriter slotWriter = this.writer;
        if (!slotWriter.closed) {
            slotWriter.close();
        }
        this.insertFixups.clear();
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.reusingGroup = -1;
    }

    @Override // androidx.compose.runtime.Composer
    public final <V, T> void apply(final V v, final Function2<? super T, ? super V, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Function3<Applier<?>, SlotWriter, RememberManager, Unit> function3 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$apply$operation$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                Applier<?> applier2 = applier;
                Intrinsics.checkNotNullParameter(applier2, "applier");
                Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                block.invoke(applier2.getCurrent(), v);
                return Unit.INSTANCE;
            }
        };
        if (this.inserting) {
            this.insertFixups.add(function3);
            return;
        }
        realizeUps();
        realizeDowns$1();
        record(function3);
    }

    @Override // androidx.compose.runtime.Composer
    public final CompositionContextImpl buildContext() {
        CompositionContextHolder compositionContextHolder;
        startGroup(206, ComposerKt.reference);
        if (this.inserting) {
            SlotWriter.markGroup$default(this.writer);
        }
        Object nextSlot = nextSlot();
        if (nextSlot instanceof CompositionContextHolder) {
            compositionContextHolder = (CompositionContextHolder) nextSlot;
        } else {
            compositionContextHolder = null;
        }
        if (compositionContextHolder == null) {
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(this.compoundKeyHash, this.forceRecomposeScopes));
            updateValue(compositionContextHolder);
        }
        PersistentCompositionLocalMap scope = currentCompositionLocalScope();
        CompositionContextImpl compositionContextImpl = compositionContextHolder.ref;
        compositionContextImpl.getClass();
        Intrinsics.checkNotNullParameter(scope, "scope");
        compositionContextImpl.compositionLocalScope$delegate.setValue(scope);
        end(false);
        return compositionContextHolder.ref;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changed(Object obj) {
        if (Intrinsics.areEqual(nextSlot(), obj)) {
            return false;
        }
        updateValue(obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changedInstance(Object obj) {
        if (nextSlot() != obj) {
            updateValue(obj);
            return true;
        }
        return false;
    }

    public final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.tos = 0;
        this.invalidateStack.backing.clear();
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    @Override // androidx.compose.runtime.Composer
    public final void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void composeContent$runtime_release(IdentityArrayMap invalidationsRequested, ComposableLambdaImpl composableLambdaImpl) {
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        if (this.changes.isEmpty()) {
            doCompose(invalidationsRequested, composableLambdaImpl);
        } else {
            ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
            throw null;
        }
    }

    public final int compoundKeyOf(int r7, int r8, int r9) {
        boolean z;
        Object aux;
        if (r7 != r8) {
            SlotReader slotReader = this.reader;
            int[] r1 = slotReader.groups;
            int r2 = r7 * 5;
            int r4 = 0;
            if ((r1[r2 + 1] & 536870912) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Object objectKey = slotReader.objectKey(r1, r7);
                if (objectKey != null) {
                    r4 = objectKey instanceof Enum ? ((Enum) objectKey).ordinal() : objectKey instanceof MovableContent ? 126665345 : objectKey.hashCode();
                }
            } else {
                r4 = r1[r2];
                if (r4 == 207 && (aux = slotReader.aux(r1, r7)) != null && !Intrinsics.areEqual(aux, Composer.Companion.Empty)) {
                    r4 = aux.hashCode();
                }
            }
            if (r4 == 126665345) {
                return r4;
            }
            return Integer.rotateLeft(compoundKeyOf(this.reader.parent(r7), r8, r9), 3) ^ r4;
        }
        return r9;
    }

    @Override // androidx.compose.runtime.Composer
    public final Object consume(ProvidableCompositionLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    public final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.closed);
        SlotTable slotTable = new SlotTable();
        this.insertTable = slotTable;
        SlotWriter openWriter = slotTable.openWriter();
        openWriter.close();
        this.writer = openWriter;
    }

    @Override // androidx.compose.runtime.Composer
    public final <T> void createNode(final Function0<? extends T> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this.nodeExpected) {
            this.nodeExpected = false;
            if (this.inserting) {
                final int r0 = this.nodeIndexStack.slots[r0.tos - 1];
                SlotWriter slotWriter = this.writer;
                final Anchor anchor = slotWriter.anchor(slotWriter.parent);
                this.groupNodeCount++;
                this.insertFixups.add(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$createNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter2, RememberManager rememberManager) {
                        Applier<?> applier2 = applier;
                        SlotWriter slotWriter3 = slotWriter2;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter3, "slots", rememberManager, "<anonymous parameter 2>");
                        Object invoke = factory.invoke();
                        Anchor anchor2 = anchor;
                        Intrinsics.checkNotNullParameter(anchor2, "anchor");
                        slotWriter3.updateNodeOfGroup(slotWriter3.anchorIndex(anchor2), invoke);
                        applier2.insertTopDown(r0, invoke);
                        applier2.down(invoke);
                        return Unit.INSTANCE;
                    }
                });
                this.insertUpFixups.push(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$createNode$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter2, RememberManager rememberManager) {
                        Applier<?> applier2 = applier;
                        SlotWriter slotWriter3 = slotWriter2;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter3, "slots", rememberManager, "<anonymous parameter 2>");
                        Anchor anchor2 = anchor;
                        Intrinsics.checkNotNullParameter(anchor2, "anchor");
                        Object node = slotWriter3.node(slotWriter3.anchorIndex(anchor2));
                        applier2.up();
                        applier2.insertBottomUp(r0, node);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            ComposerKt.composeRuntimeError("createNode() can only be called when inserting".toString());
            throw null;
        }
        ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
        throw null;
    }

    public final PersistentCompositionLocalMap currentCompositionLocalScope(int r9) {
        if (this.inserting && this.writerHasAProvider) {
            int r0 = this.writer.parent;
            while (r0 > 0) {
                SlotWriter slotWriter = this.writer;
                if (slotWriter.groups[slotWriter.groupIndexToAddress(r0) * 5] == 202) {
                    SlotWriter slotWriter2 = this.writer;
                    int groupIndexToAddress = slotWriter2.groupIndexToAddress(r0);
                    int[] r5 = slotWriter2.groups;
                    int r4 = groupIndexToAddress * 5;
                    int r6 = r5[r4 + 1];
                    if (Intrinsics.areEqual((536870912 & r6) != 0 ? slotWriter2.slots[SlotTableKt.countOneBits(r6 >> 30) + r5[r4 + 4]] : null, ComposerKt.compositionLocalMap)) {
                        SlotWriter slotWriter3 = this.writer;
                        int groupIndexToAddress2 = slotWriter3.groupIndexToAddress(r0);
                        Object obj = SlotTableKt.access$hasAux(slotWriter3.groups, groupIndexToAddress2) ? slotWriter3.slots[slotWriter3.auxIndex(slotWriter3.groups, groupIndexToAddress2)] : Composer.Companion.Empty;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) obj;
                        this.providerCache = persistentCompositionLocalMap;
                        return persistentCompositionLocalMap;
                    }
                }
                r0 = this.writer.parent(r0);
            }
        }
        if (this.reader.groupsSize > 0) {
            while (r9 > 0) {
                SlotReader slotReader = this.reader;
                int[] r42 = slotReader.groups;
                if (r42[r9 * 5] == 202 && Intrinsics.areEqual(slotReader.objectKey(r42, r9), ComposerKt.compositionLocalMap)) {
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) ((SparseArray) this.providerUpdates.sparseArray).get(r9);
                    if (persistentCompositionLocalMap2 == null) {
                        SlotReader slotReader2 = this.reader;
                        Object aux = slotReader2.aux(slotReader2.groups, r9);
                        Intrinsics.checkNotNull(aux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) aux;
                    }
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                r9 = this.reader.parent(r9);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.parentProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    @Override // androidx.compose.runtime.Composer
    public final void deactivateToEndGroup(boolean z) {
        boolean z2;
        int r5;
        if (this.groupNodeCount == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (!this.inserting) {
                if (!z) {
                    skipReaderToGroupEnd();
                    return;
                }
                SlotReader slotReader = this.reader;
                int r0 = slotReader.currentGroup;
                int r10 = slotReader.currentEnd;
                final int r1 = r0;
                while (r1 < r10) {
                    if (this.reader.isNode(r1)) {
                        final Object node = this.reader.node(r1);
                        if (node instanceof ComposeNodeLifecycleCallback) {
                            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                    RememberManager rememberManager2 = rememberManager;
                                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter, "<anonymous parameter 1>", rememberManager2, "rememberManager");
                                    rememberManager2.deactivating((ComposeNodeLifecycleCallback) node);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }
                    SlotReader slotReader2 = this.reader;
                    Function2<Integer, Object, Unit> function2 = new Function2<Integer, Object, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Integer num, final Object obj) {
                            final int intValue = num.intValue();
                            boolean z3 = obj instanceof RememberObserver;
                            int r2 = r1;
                            ComposerImpl composerImpl = ComposerImpl.this;
                            if (z3) {
                                composerImpl.reader.reposition(r2);
                                composerImpl.recordSlotTableOperation(false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                        SlotWriter slotWriter2 = slotWriter;
                                        RememberManager rememberManager2 = rememberManager;
                                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager2, "rememberManager");
                                        int r7 = slotWriter2.currentGroup;
                                        int r02 = intValue;
                                        Object slot = slotWriter2.slot(r7, r02);
                                        Object obj2 = obj;
                                        if (Intrinsics.areEqual(obj2, slot)) {
                                            rememberManager2.forgetting((RememberObserver) obj2);
                                            slotWriter2.set(r02, Composer.Companion.Empty);
                                            return Unit.INSTANCE;
                                        }
                                        ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                                        throw null;
                                    }
                                });
                            } else if (obj instanceof RecomposeScopeImpl) {
                                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                RecomposeScopeOwner recomposeScopeOwner = recomposeScopeImpl.owner;
                                if (recomposeScopeOwner != null) {
                                    recomposeScopeOwner.recomposeScopeReleased(recomposeScopeImpl);
                                }
                                recomposeScopeImpl.owner = null;
                                recomposeScopeImpl.trackedInstances = null;
                                recomposeScopeImpl.trackedDependencies = null;
                                composerImpl.reader.reposition(r2);
                                composerImpl.recordSlotTableOperation(false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$deactivateToEndGroup$3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                        SlotWriter slotWriter2 = slotWriter;
                                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                                        int r7 = slotWriter2.currentGroup;
                                        int r9 = intValue;
                                        if (Intrinsics.areEqual(obj, slotWriter2.slot(r7, r9))) {
                                            slotWriter2.set(r9, Composer.Companion.Empty);
                                            return Unit.INSTANCE;
                                        }
                                        ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                                        throw null;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    slotReader2.getClass();
                    int access$slotAnchor = SlotTableKt.access$slotAnchor(slotReader2.groups, r1);
                    r1++;
                    SlotTable slotTable = slotReader2.table;
                    if (r1 < slotTable.groupsSize) {
                        r5 = SlotTableKt.access$dataAnchor(slotTable.groups, r1);
                    } else {
                        r5 = slotTable.slotsSize;
                    }
                    for (int r6 = access$slotAnchor; r6 < r5; r6++) {
                        function2.invoke(Integer.valueOf(r6 - access$slotAnchor), slotReader2.slots[r6]);
                    }
                }
                ComposerKt.access$removeRange(r0, this.invalidations, r10);
                this.reader.reposition(r0);
                this.reader.skipToGroupEnd();
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("No nodes can be emitted before calling dactivateToEndGroup".toString());
        throw null;
    }

    public final void dispose$runtime_release() {
        Trace.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime_release(this);
            this.invalidateStack.backing.clear();
            this.invalidations.clear();
            this.changes.clear();
            ((SparseArray) this.providerUpdates.sparseArray).clear();
            this.applier.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:            if (r4.size() <= 1) goto L73;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:            kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(r4, new androidx.compose.runtime.ComposerImpl$doCompose$lambda$38$$inlined$sortBy$1());     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:            r9.nodeIndex = 0;        r9.isComposing = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:            startRoot();        r10 = nextSlot();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:            if (r10 == r11) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:            if (r11 == null) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:            updateValue(r11);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:            r0 = r9.derivedStateObserver;        r3 = com.google.common.collect.Platform.derivedStateObservers();     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:            r3.add(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:            if (r11 == null) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:            startGroup(200, androidx.compose.runtime.ComposerKt.invocation);        kotlin.collections.SetsKt__SetsKt.invokeComposable(r9, r11);        end(false);     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:            r3.removeAt(r3.size - 1);        endRoot();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:            r9.isComposing = false;        r4.clear();        r10 = kotlin.Unit.INSTANCE;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:            if (r9.providersInvalid == false) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:            if (r10 == null) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r10, androidx.compose.runtime.Composer.Companion.Empty) != false) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:            startGroup(200, androidx.compose.runtime.ComposerKt.invocation);        kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, r10);        kotlin.collections.SetsKt__SetsKt.invokeComposable(r9, (kotlin.jvm.functions.Function2) r10);        end(false);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:            skipCurrentGroup();     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:            r10 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00be, code lost:            r3.removeAt(r3.size - 1);     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:            throw r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:            r10 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c6, code lost:            r9.isComposing = false;        r4.clear();        abortRoot();     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ce, code lost:            throw r10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void doCompose(androidx.compose.runtime.collection.IdentityArrayMap r10, androidx.compose.runtime.internal.ComposableLambdaImpl r11) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.doCompose(androidx.compose.runtime.collection.IdentityArrayMap, androidx.compose.runtime.internal.ComposableLambdaImpl):void");
    }

    public final void doRecordDownsFor(int r2, int r3) {
        if (r2 > 0 && r2 != r3) {
            doRecordDownsFor(this.reader.parent(r2), r3);
            if (this.reader.isNode(r2)) {
                this.downNodes.push(this.reader.node(r2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v16 */
    public final void end(boolean z) {
        boolean z2;
        boolean z3;
        int r7;
        boolean z4;
        boolean z5;
        boolean z6;
        ?? r4;
        boolean z7;
        HashSet hashSet;
        Pending pending;
        ArrayList arrayList;
        LinkedHashSet linkedHashSet;
        int r21;
        int r22;
        int r2;
        int r5;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        Object obj;
        Object obj2;
        if (this.inserting) {
            SlotWriter slotWriter = this.writer;
            int r52 = slotWriter.parent;
            int r1 = slotWriter.groups[slotWriter.groupIndexToAddress(r52) * 5];
            SlotWriter slotWriter2 = this.writer;
            int groupIndexToAddress = slotWriter2.groupIndexToAddress(r52);
            int[] r8 = slotWriter2.groups;
            int r72 = groupIndexToAddress * 5;
            int r9 = r8[r72 + 1];
            if ((536870912 & r9) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                obj = slotWriter2.slots[SlotTableKt.countOneBits(r9 >> 30) + r8[r72 + 4]];
            } else {
                obj = null;
            }
            SlotWriter slotWriter3 = this.writer;
            int groupIndexToAddress2 = slotWriter3.groupIndexToAddress(r52);
            if (SlotTableKt.access$hasAux(slotWriter3.groups, groupIndexToAddress2)) {
                obj2 = slotWriter3.slots[slotWriter3.auxIndex(slotWriter3.groups, groupIndexToAddress2)];
            } else {
                obj2 = Composer.Companion.Empty;
            }
            updateCompoundKeyWhenWeExitGroup(obj, r1, obj2);
        } else {
            SlotReader slotReader = this.reader;
            int r53 = slotReader.parent;
            int[] r73 = slotReader.groups;
            int r6 = r73[r53 * 5];
            Object objectKey = slotReader.objectKey(r73, r53);
            SlotReader slotReader2 = this.reader;
            updateCompoundKeyWhenWeExitGroup(objectKey, r6, slotReader2.aux(slotReader2.groups, r53));
        }
        int r12 = this.groupNodeCount;
        Pending pending2 = this.pending;
        ArrayList arrayList2 = this.invalidations;
        if (pending2 != null) {
            List<KeyInfo> list = pending2.keyInfos;
            if (list.size() > 0) {
                ArrayList arrayList3 = pending2.usedKeys;
                Intrinsics.checkNotNullParameter(arrayList3, "<this>");
                HashSet hashSet2 = new HashSet(arrayList3.size());
                int size = arrayList3.size();
                for (int r11 = 0; r11 < size; r11++) {
                    hashSet2.add(arrayList3.get(r11));
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                int size2 = arrayList3.size();
                int size3 = list.size();
                int r13 = 0;
                int r14 = 0;
                int r15 = 0;
                while (r13 < size3) {
                    KeyInfo keyInfo = list.get(r13);
                    boolean contains = hashSet2.contains(keyInfo);
                    int r3 = pending2.startIndex;
                    if (!contains) {
                        recordRemoveNode(pending2.nodePositionOf(keyInfo) + r3, keyInfo.nodes);
                        int r23 = keyInfo.location;
                        pending2.updateNodeCount(r23, 0);
                        SlotReader slotReader3 = this.reader;
                        hashSet = hashSet2;
                        this.writersReaderDelta = r23 - (slotReader3.currentGroup - this.writersReaderDelta);
                        slotReader3.reposition(r23);
                        reportFreeMovableContent(this.reader.currentGroup);
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                        realizeOperationLocation(false);
                        recordSlotEditing();
                        record(composerKt$removeCurrentGroupInstance$1);
                        int r32 = this.writersReaderDelta;
                        SlotReader slotReader4 = this.reader;
                        this.writersReaderDelta = SlotTableKt.access$groupSize(slotReader4.groups, slotReader4.currentGroup) + r32;
                        this.reader.skipGroup();
                        ComposerKt.access$removeRange(r23, arrayList2, this.reader.groupSize(r23) + r23);
                    } else {
                        hashSet = hashSet2;
                        if (!linkedHashSet2.contains(keyInfo)) {
                            if (r14 < size2) {
                                KeyInfo keyInfo2 = (KeyInfo) arrayList3.get(r14);
                                HashMap<Integer, GroupInfo> hashMap = pending2.groupInfos;
                                if (keyInfo2 != keyInfo) {
                                    int nodePositionOf = pending2.nodePositionOf(keyInfo2);
                                    linkedHashSet2.add(keyInfo2);
                                    if (nodePositionOf != r15) {
                                        pending = pending2;
                                        GroupInfo groupInfo = hashMap.get(Integer.valueOf(keyInfo2.location));
                                        if (groupInfo != null) {
                                            r5 = groupInfo.nodeCount;
                                        } else {
                                            r5 = keyInfo2.nodes;
                                        }
                                        arrayList = arrayList3;
                                        int r82 = nodePositionOf + r3;
                                        int r33 = r3 + r15;
                                        if (r5 > 0) {
                                            linkedHashSet = linkedHashSet2;
                                            int r10 = this.previousCount;
                                            if (r10 > 0) {
                                                r21 = size2;
                                                r22 = size3;
                                                if (this.previousMoveFrom == r82 - r10 && this.previousMoveTo == r33 - r10) {
                                                    this.previousCount = r10 + r5;
                                                }
                                            } else {
                                                r21 = size2;
                                                r22 = size3;
                                            }
                                            realizeMovement();
                                            this.previousMoveFrom = r82;
                                            this.previousMoveTo = r33;
                                            this.previousCount = r5;
                                        } else {
                                            linkedHashSet = linkedHashSet2;
                                            r21 = size2;
                                            r22 = size3;
                                        }
                                        if (nodePositionOf > r15) {
                                            Collection<GroupInfo> values = hashMap.values();
                                            Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
                                            for (GroupInfo groupInfo2 : values) {
                                                int r102 = groupInfo2.nodeIndex;
                                                if (nodePositionOf <= r102 && r102 < nodePositionOf + r5) {
                                                    z10 = true;
                                                } else {
                                                    z10 = false;
                                                }
                                                if (z10) {
                                                    groupInfo2.nodeIndex = (r102 - nodePositionOf) + r15;
                                                } else {
                                                    if (r15 <= r102 && r102 < nodePositionOf) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    if (z11) {
                                                        groupInfo2.nodeIndex = r102 + r5;
                                                    }
                                                }
                                            }
                                        } else if (r15 > nodePositionOf) {
                                            Collection<GroupInfo> values2 = hashMap.values();
                                            Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
                                            for (GroupInfo groupInfo3 : values2) {
                                                int r103 = groupInfo3.nodeIndex;
                                                if (nodePositionOf <= r103 && r103 < nodePositionOf + r5) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    groupInfo3.nodeIndex = (r103 - nodePositionOf) + r15;
                                                } else {
                                                    if (nodePositionOf + 1 <= r103 && r103 < r15) {
                                                        z9 = true;
                                                    } else {
                                                        z9 = false;
                                                    }
                                                    if (z9) {
                                                        groupInfo3.nodeIndex = r103 - r5;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        pending = pending2;
                                        arrayList = arrayList3;
                                        linkedHashSet = linkedHashSet2;
                                        r21 = size2;
                                        r22 = size3;
                                    }
                                } else {
                                    pending = pending2;
                                    arrayList = arrayList3;
                                    linkedHashSet = linkedHashSet2;
                                    r21 = size2;
                                    r22 = size3;
                                    r13++;
                                }
                                r14++;
                                Intrinsics.checkNotNullParameter(keyInfo2, "keyInfo");
                                GroupInfo groupInfo4 = hashMap.get(Integer.valueOf(keyInfo2.location));
                                if (groupInfo4 != null) {
                                    r2 = groupInfo4.nodeCount;
                                } else {
                                    r2 = keyInfo2.nodes;
                                }
                                r15 += r2;
                                hashSet2 = hashSet;
                                pending2 = pending;
                                arrayList3 = arrayList;
                                linkedHashSet2 = linkedHashSet;
                                size2 = r21;
                                size3 = r22;
                            } else {
                                hashSet2 = hashSet;
                            }
                        }
                    }
                    r13++;
                    hashSet2 = hashSet;
                }
                realizeMovement();
                if (list.size() > 0) {
                    SlotReader slotReader5 = this.reader;
                    this.writersReaderDelta = slotReader5.currentEnd - (slotReader5.currentGroup - this.writersReaderDelta);
                    slotReader5.skipToGroupEnd();
                }
            }
        }
        int r24 = this.nodeIndex;
        while (true) {
            SlotReader slotReader6 = this.reader;
            if (slotReader6.emptyCount > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && slotReader6.currentGroup != slotReader6.currentEnd) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                break;
            }
            int r34 = slotReader6.currentGroup;
            reportFreeMovableContent(r34);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            realizeOperationLocation(false);
            recordSlotEditing();
            record(composerKt$removeCurrentGroupInstance$12);
            int r42 = this.writersReaderDelta;
            SlotReader slotReader7 = this.reader;
            this.writersReaderDelta = SlotTableKt.access$groupSize(slotReader7.groups, slotReader7.currentGroup) + r42;
            recordRemoveNode(r24, this.reader.skipGroup());
            ComposerKt.access$removeRange(r34, arrayList2, this.reader.currentGroup);
        }
        boolean z13 = this.inserting;
        int r35 = -1;
        if (z13) {
            ArrayList arrayList4 = this.insertFixups;
            if (z) {
                arrayList4.add(this.insertUpFixups.pop());
                r12 = 1;
            }
            SlotReader slotReader8 = this.reader;
            int r62 = slotReader8.emptyCount;
            if (r62 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                slotReader8.emptyCount = r62 - 1;
                SlotWriter slotWriter4 = this.writer;
                int r54 = slotWriter4.parent;
                slotWriter4.endGroup();
                if (this.reader.emptyCount > 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6) {
                    int r36 = (-2) - r54;
                    this.writer.endInsert();
                    this.writer.close();
                    final Anchor anchor = this.insertAnchor;
                    if (arrayList4.isEmpty()) {
                        final SlotTable slotTable = this.insertTable;
                        Function3<Applier<?>, SlotWriter, RememberManager, Unit> function3 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordInsert$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter5, RememberManager rememberManager) {
                                SlotWriter slots = slotWriter5;
                                Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                                Intrinsics.checkNotNullParameter(slots, "slots");
                                Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                                slots.beginInsert();
                                Anchor anchor2 = anchor;
                                anchor2.getClass();
                                SlotTable slots2 = SlotTable.this;
                                Intrinsics.checkNotNullParameter(slots2, "slots");
                                slots.moveFrom(slots2, slots2.anchorIndex(anchor2));
                                slots.endInsert();
                                return Unit.INSTANCE;
                            }
                        };
                        realizeOperationLocation(false);
                        recordSlotEditing();
                        record(function3);
                        r4 = 0;
                    } else {
                        final ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList4);
                        arrayList4.clear();
                        realizeUps();
                        realizeDowns$1();
                        final SlotTable slotTable2 = this.insertTable;
                        Function3<Applier<?>, SlotWriter, RememberManager, Unit> function32 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordInsert$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter5, RememberManager rememberManager) {
                                Applier<?> applier2 = applier;
                                SlotWriter slotWriter6 = slotWriter5;
                                RememberManager rememberManager2 = rememberManager;
                                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter6, "slots", rememberManager2, "rememberManager");
                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list2 = mutableList;
                                SlotTable slotTable3 = SlotTable.this;
                                SlotWriter openWriter = slotTable3.openWriter();
                                try {
                                    int size4 = list2.size();
                                    for (int r43 = 0; r43 < size4; r43++) {
                                        list2.get(r43).invoke(applier2, openWriter, rememberManager2);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    openWriter.close();
                                    slotWriter6.beginInsert();
                                    Anchor anchor2 = anchor;
                                    anchor2.getClass();
                                    slotWriter6.moveFrom(slotTable3, slotTable3.anchorIndex(anchor2));
                                    slotWriter6.endInsert();
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    openWriter.close();
                                    throw th;
                                }
                            }
                        };
                        r4 = 0;
                        realizeOperationLocation(false);
                        recordSlotEditing();
                        record(function32);
                    }
                    this.inserting = r4;
                    if (this.slotTable.groupsSize == 0) {
                        z7 = true;
                    } else {
                        z7 = r4;
                    }
                    if (!z7) {
                        updateNodeCount(r36, r4);
                        updateNodeCountOverrides(r36, r12);
                    }
                }
            } else {
                throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
            }
        } else {
            if (z) {
                recordUp();
            }
            int r43 = this.reader.parent;
            IntStack intStack = this.startedGroups;
            int r63 = intStack.tos;
            if (r63 > 0) {
                r7 = intStack.slots[r63 - 1];
            } else {
                r7 = -1;
            }
            if (r7 <= r43) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (r63 > 0) {
                    r35 = intStack.slots[r63 - 1];
                }
                if (r35 == r43) {
                    intStack.pop();
                    recordSlotTableOperation(false, ComposerKt.endGroupInstance);
                }
                int r37 = this.reader.parent;
                if (r12 != updatedNodeCount(r37)) {
                    updateNodeCountOverrides(r37, r12);
                }
                if (z) {
                    r12 = 1;
                }
                this.reader.endGroup();
                realizeMovement();
            } else {
                ComposerKt.composeRuntimeError("Missed recording an endGroup".toString());
                throw null;
            }
        }
        Pending pop = this.pendingStack.pop();
        if (pop != null && !z13) {
            pop.groupIndex++;
        }
        this.pending = pop;
        this.nodeIndex = this.nodeIndexStack.pop() + r12;
        this.groupNodeCount = this.groupNodeCountStack.pop() + r12;
    }

    public final void endDefaults() {
        boolean z = false;
        end(false);
        RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            int r2 = currentRecomposeScope$runtime_release.flags;
            if ((r2 & 1) != 0) {
                z = true;
            }
            if (z) {
                currentRecomposeScope$runtime_release.flags = r2 | 2;
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final void endMovableGroup() {
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    public final void endNode() {
        end(true);
    }

    public final void endProviders() {
        boolean z = false;
        end(false);
        end(false);
        int pop = this.providersInvalidStack.pop();
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (pop != 0) {
            z = true;
        }
        this.providersInvalid = z;
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public final void endReplaceableGroup() {
        end(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.runtime.RecomposeScopeImpl$end$1$2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.runtime.RecomposeScopeImpl endRestartGroup() {
        /*
            r12 = this;
            androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> r0 = r12.invalidateStack
            java.util.ArrayList<T> r1 = r0.backing
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r1 == 0) goto L14
            java.lang.Object r0 = r0.pop()
            androidx.compose.runtime.RecomposeScopeImpl r0 = (androidx.compose.runtime.RecomposeScopeImpl) r0
            goto L15
        L14:
            r0 = r3
        L15:
            if (r0 != 0) goto L18
            goto L1e
        L18:
            int r1 = r0.flags
            r1 = r1 & (-9)
            r0.flags = r1
        L1e:
            r1 = 0
            if (r0 == 0) goto L64
            int r4 = r12.compositionToken
            androidx.compose.runtime.collection.IdentityArrayIntMap r5 = r0.trackedInstances
            if (r5 == 0) goto L59
            int r6 = r0.flags
            r6 = r6 & 16
            if (r6 == 0) goto L2f
            r6 = r2
            goto L30
        L2f:
            r6 = r1
        L30:
            if (r6 != 0) goto L59
            java.lang.Object[] r6 = r5.keys
            int[] r7 = r5.values
            int r8 = r5.size
            r9 = r1
        L39:
            if (r9 >= r8) goto L50
            r10 = r6[r9]
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.Any"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            r10 = r7[r9]
            if (r10 == r4) goto L48
            r10 = r2
            goto L49
        L48:
            r10 = r1
        L49:
            if (r10 == 0) goto L4d
            r6 = r2
            goto L51
        L4d:
            int r9 = r9 + 1
            goto L39
        L50:
            r6 = r1
        L51:
            if (r6 == 0) goto L59
            androidx.compose.runtime.RecomposeScopeImpl$end$1$2 r6 = new androidx.compose.runtime.RecomposeScopeImpl$end$1$2
            r6.<init>()
            goto L5a
        L59:
            r6 = r3
        L5a:
            if (r6 == 0) goto L64
            androidx.compose.runtime.ComposerImpl$endRestartGroup$1$1 r4 = new androidx.compose.runtime.ComposerImpl$endRestartGroup$1$1
            r4.<init>()
            r12.record(r4)
        L64:
            if (r0 == 0) goto L9e
            int r4 = r0.flags
            r5 = r4 & 16
            if (r5 == 0) goto L6e
            r5 = r2
            goto L6f
        L6e:
            r5 = r1
        L6f:
            if (r5 != 0) goto L9e
            r4 = r4 & r2
            if (r4 == 0) goto L75
            goto L76
        L75:
            r2 = r1
        L76:
            if (r2 != 0) goto L7c
            boolean r2 = r12.forceRecomposeScopes
            if (r2 == 0) goto L9e
        L7c:
            androidx.compose.runtime.Anchor r2 = r0.anchor
            if (r2 != 0) goto L97
            boolean r2 = r12.inserting
            if (r2 == 0) goto L8d
            androidx.compose.runtime.SlotWriter r2 = r12.writer
            int r3 = r2.parent
            androidx.compose.runtime.Anchor r2 = r2.anchor(r3)
            goto L95
        L8d:
            androidx.compose.runtime.SlotReader r2 = r12.reader
            int r3 = r2.parent
            androidx.compose.runtime.Anchor r2 = r2.anchor(r3)
        L95:
            r0.anchor = r2
        L97:
            int r2 = r0.flags
            r2 = r2 & (-5)
            r0.flags = r2
            r3 = r0
        L9e:
            r12.end(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.endRestartGroup():androidx.compose.runtime.RecomposeScopeImpl");
    }

    @Override // androidx.compose.runtime.Composer
    public final void endReusableGroup() {
        if (this.reusing && this.reader.parent == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    public final void endRoot() {
        boolean z = false;
        end(false);
        this.parentContext.doneComposing$runtime_release();
        end(false);
        if (this.startedGroup) {
            recordSlotTableOperation(false, ComposerKt.endGroupInstance);
            this.startedGroup = false;
        }
        realizeUps();
        if (this.pendingStack.backing.isEmpty()) {
            if (this.startedGroups.tos == 0) {
                z = true;
            }
            if (z) {
                cleanUpCompose();
                this.reader.close();
                return;
            } else {
                ComposerKt.composeRuntimeError("Missed recording an endGroup()".toString());
                throw null;
            }
        }
        ComposerKt.composeRuntimeError("Start/end imbalance".toString());
        throw null;
    }

    public final void enterGroup(boolean z, Pending pending) {
        this.pendingStack.push(this.pending);
        this.pending = pending;
        this.nodeIndexStack.push(this.nodeIndex);
        if (z) {
            this.nodeIndex = 0;
        }
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    @Override // androidx.compose.runtime.Composer
    public final Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public final CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    @Override // androidx.compose.runtime.Composer
    public final SlotTable getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public final int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public final PersistentCompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        if (this.childrenComposing == 0) {
            Stack<RecomposeScopeImpl> stack = this.invalidateStack;
            if (!stack.backing.isEmpty()) {
                return stack.backing.get(r0.size() - 1);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getDefaultsInvalid() {
        /*
            r3 = this;
            boolean r0 = r3.providersInvalid
            r1 = 1
            if (r0 != 0) goto L1e
            androidx.compose.runtime.RecomposeScopeImpl r0 = r3.getCurrentRecomposeScope$runtime_release()
            r2 = 0
            if (r0 == 0) goto L19
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L14
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            if (r0 != r1) goto L19
            r0 = r1
            goto L1a
        L19:
            r0 = r2
        L1a:
            if (r0 == 0) goto L1d
            goto L1e
        L1d:
            r1 = r2
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.getDefaultsInvalid():boolean");
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public final RecomposeScopeImpl getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.runtime.Composer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getSkipping() {
        /*
            r3 = this;
            boolean r0 = r3.inserting
            r1 = 0
            if (r0 != 0) goto L25
            boolean r0 = r3.reusing
            if (r0 != 0) goto L25
            boolean r0 = r3.providersInvalid
            if (r0 != 0) goto L25
            androidx.compose.runtime.RecomposeScopeImpl r0 = r3.getCurrentRecomposeScope$runtime_release()
            r2 = 1
            if (r0 == 0) goto L21
            int r0 = r0.flags
            r0 = r0 & 8
            if (r0 == 0) goto L1c
            r0 = r2
            goto L1d
        L1c:
            r0 = r1
        L1d:
            if (r0 != 0) goto L21
            r0 = r2
            goto L22
        L21:
            r0 = r1
        L22:
            if (r0 == 0) goto L25
            r1 = r2
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.getSkipping():boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insertMovableContentGuarded(ArrayList arrayList) {
        SlotTable slotTable;
        Anchor anchor;
        final SlotReader openReader;
        int r16;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list;
        SlotTable slotTable2;
        SlotTable slotTable3;
        SlotTable slotTable4 = this.slotTable;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list2 = this.lateChanges;
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list3 = this.changes;
        try {
            this.changes = list2;
            record(ComposerKt.resetSlotsInstance);
            int size = arrayList.size();
            int r11 = 0;
            while (r11 < size) {
                Pair pair = (Pair) arrayList.get(r11);
                final MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.first;
                final MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.second;
                final Anchor anchor2 = movableContentStateReference.anchor;
                SlotTable slotTable5 = movableContentStateReference.slotTable;
                int anchorIndex = slotTable5.anchorIndex(anchor2);
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                realizeUps();
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        boolean z;
                        int r0;
                        boolean z2;
                        int access$nodeCount;
                        Applier<?> applier2 = applier;
                        SlotWriter slotWriter2 = slotWriter;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                        int anchorIndex2 = slotWriter2.anchorIndex(anchor2);
                        boolean z3 = true;
                        if (slotWriter2.currentGroup < anchorIndex2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ComposerKt.runtimeCheck(z);
                        ComposerImpl.insertMovableContentGuarded$positionToParentOf(slotWriter2, applier2, anchorIndex2);
                        int r02 = slotWriter2.currentGroup;
                        int r3 = slotWriter2.parent;
                        while (r3 >= 0 && !slotWriter2.isNode(r3)) {
                            r3 = slotWriter2.parent(r3);
                        }
                        int r32 = r3 + 1;
                        int r4 = 0;
                        while (r32 < r02) {
                            if (slotWriter2.indexInGroup(r02, r32)) {
                                if (slotWriter2.isNode(r32)) {
                                    r4 = 0;
                                }
                                r32++;
                            } else {
                                if (slotWriter2.isNode(r32)) {
                                    access$nodeCount = 1;
                                } else {
                                    access$nodeCount = SlotTableKt.access$nodeCount(slotWriter2.groups, slotWriter2.groupIndexToAddress(r32));
                                }
                                r4 += access$nodeCount;
                                r32 += slotWriter2.groupSize(r32);
                            }
                        }
                        while (true) {
                            r0 = slotWriter2.currentGroup;
                            if (r0 >= anchorIndex2) {
                                break;
                            }
                            if (slotWriter2.indexInGroup(anchorIndex2, r0)) {
                                int r03 = slotWriter2.currentGroup;
                                if (r03 < slotWriter2.currentGroupEnd && SlotTableKt.access$isNode(slotWriter2.groups, slotWriter2.groupIndexToAddress(r03))) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    applier2.down(slotWriter2.node(slotWriter2.currentGroup));
                                    r4 = 0;
                                }
                                slotWriter2.startGroup();
                            } else {
                                r4 += slotWriter2.skipGroup();
                            }
                        }
                        if (r0 != anchorIndex2) {
                            z3 = false;
                        }
                        ComposerKt.runtimeCheck(z3);
                        Ref$IntRef.this.element = r4;
                        return Unit.INSTANCE;
                    }
                });
                if (movableContentStateReference2 == null) {
                    if (Intrinsics.areEqual(slotTable5, this.insertTable)) {
                        createFreshInsertTable();
                    }
                    openReader = slotTable5.openReader();
                    try {
                        openReader.reposition(anchorIndex);
                        this.writersReaderDelta = anchorIndex;
                        final ArrayList arrayList2 = new ArrayList();
                        recomposeMovableContent(null, null, null, EmptyList.INSTANCE, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list4 = arrayList2;
                                SlotReader slotReader = openReader;
                                MovableContentStateReference movableContentStateReference3 = movableContentStateReference;
                                ComposerImpl composerImpl = ComposerImpl.this;
                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list5 = composerImpl.changes;
                                try {
                                    composerImpl.changes = list4;
                                    SlotReader slotReader2 = composerImpl.reader;
                                    int[] r5 = composerImpl.nodeCountOverrides;
                                    composerImpl.nodeCountOverrides = null;
                                    try {
                                        composerImpl.reader = slotReader;
                                        ComposerImpl.access$invokeMovableContentLambda(composerImpl, movableContentStateReference3.content, movableContentStateReference3.locals, movableContentStateReference3.parameter);
                                        Unit unit = Unit.INSTANCE;
                                        composerImpl.changes = list5;
                                        return Unit.INSTANCE;
                                    } finally {
                                        composerImpl.reader = slotReader2;
                                        composerImpl.nodeCountOverrides = r5;
                                    }
                                } catch (Throwable th) {
                                    composerImpl.changes = list5;
                                    throw th;
                                }
                            }
                        });
                        if (!arrayList2.isEmpty()) {
                            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                    Applier<?> applier2 = applier;
                                    SlotWriter slotWriter2 = slotWriter;
                                    RememberManager rememberManager2 = rememberManager;
                                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter2, "slots", rememberManager2, "rememberManager");
                                    int r0 = Ref$IntRef.this.element;
                                    if (r0 > 0) {
                                        applier2 = new OffsetApplier(applier2, r0);
                                    }
                                    List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list4 = arrayList2;
                                    int size2 = list4.size();
                                    for (int r2 = 0; r2 < size2; r2++) {
                                        list4.get(r2).invoke(applier2, slotWriter2, rememberManager2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        Unit unit = Unit.INSTANCE;
                        openReader.close();
                        slotTable2 = slotTable4;
                        r16 = size;
                        record(ComposerKt.skipToGroupEndInstance);
                        r11++;
                        size = r16;
                        slotTable4 = slotTable2;
                    } finally {
                    }
                } else {
                    final MovableContentState movableContentStateResolve$runtime_release = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference2);
                    if (movableContentStateResolve$runtime_release == null || (slotTable = movableContentStateResolve$runtime_release.slotTable) == null) {
                        slotTable = movableContentStateReference2.slotTable;
                    }
                    if (movableContentStateResolve$runtime_release != null && (slotTable3 = movableContentStateResolve$runtime_release.slotTable) != null) {
                        anchor = slotTable3.anchor();
                    } else {
                        anchor = movableContentStateReference2.anchor;
                    }
                    final ArrayList arrayList3 = new ArrayList();
                    openReader = slotTable.openReader();
                    r16 = size;
                    try {
                        ComposerKt.collectNodesFrom$lambda$9$collectFromGroup(openReader, arrayList3, slotTable.anchorIndex(anchor));
                        Unit unit2 = Unit.INSTANCE;
                        openReader.close();
                        if (!arrayList3.isEmpty()) {
                            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                    Applier<?> applier2 = applier;
                                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter, "<anonymous parameter 1>", rememberManager, "<anonymous parameter 2>");
                                    int r8 = Ref$IntRef.this.element;
                                    List<Object> list4 = arrayList3;
                                    int size2 = list4.size();
                                    for (int r1 = 0; r1 < size2; r1++) {
                                        Object obj = list4.get(r1);
                                        int r3 = r8 + r1;
                                        applier2.insertBottomUp(r3, obj);
                                        applier2.insertTopDown(r3, obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            if (Intrinsics.areEqual(slotTable5, slotTable4)) {
                                int anchorIndex2 = slotTable4.anchorIndex(anchor2);
                                updateNodeCount(anchorIndex2, updatedNodeCount(anchorIndex2) + arrayList3.size());
                            }
                        }
                        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                boolean z;
                                SlotWriter slotWriter2 = slotWriter;
                                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                                MovableContentState movableContentState = MovableContentState.this;
                                if (movableContentState == null && (movableContentState = this.parentContext.movableContentStateResolve$runtime_release(movableContentStateReference2)) == null) {
                                    ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                                    throw null;
                                }
                                SlotTable table = movableContentState.slotTable;
                                Intrinsics.checkNotNullParameter(table, "table");
                                if (slotWriter2.insertCount <= 0 && slotWriter2.groupSize(slotWriter2.currentGroup + 1) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                ComposerKt.runtimeCheck(z);
                                int r12 = slotWriter2.currentGroup;
                                int r7 = slotWriter2.currentSlot;
                                int r8 = slotWriter2.currentSlotEnd;
                                slotWriter2.advanceBy(1);
                                slotWriter2.startGroup();
                                slotWriter2.beginInsert();
                                SlotWriter openWriter = table.openWriter();
                                try {
                                    List moveGroup = SlotWriter.Companion.moveGroup(openWriter, 2, slotWriter2, false, true, true);
                                    openWriter.close();
                                    slotWriter2.endInsert();
                                    slotWriter2.endGroup();
                                    slotWriter2.currentGroup = r12;
                                    slotWriter2.currentSlot = r7;
                                    slotWriter2.currentSlotEnd = r8;
                                    ControlledComposition controlledComposition = movableContentStateReference.composition;
                                    Intrinsics.checkNotNull(controlledComposition, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
                                    RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime_release(slotWriter2, moveGroup, (RecomposeScopeOwner) controlledComposition);
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    openWriter.close();
                                    throw th;
                                }
                            }
                        });
                        openReader = slotTable.openReader();
                        try {
                            SlotReader slotReader = this.reader;
                            int[] r15 = this.nodeCountOverrides;
                            this.nodeCountOverrides = null;
                            try {
                                this.reader = openReader;
                                int anchorIndex3 = slotTable.anchorIndex(anchor);
                                openReader.reposition(anchorIndex3);
                                this.writersReaderDelta = anchorIndex3;
                                final ArrayList arrayList4 = new ArrayList();
                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list4 = this.changes;
                                try {
                                    this.changes = arrayList4;
                                    slotTable2 = slotTable4;
                                    list = list4;
                                } catch (Throwable th) {
                                    th = th;
                                    list = list4;
                                }
                                try {
                                    recomposeMovableContent(movableContentStateReference2.composition, movableContentStateReference.composition, Integer.valueOf(openReader.currentGroup), movableContentStateReference2.invalidations, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            MovableContentStateReference movableContentStateReference3 = movableContentStateReference;
                                            ComposerImpl.access$invokeMovableContentLambda(ComposerImpl.this, movableContentStateReference3.content, movableContentStateReference3.locals, movableContentStateReference3.parameter);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    this.changes = list;
                                    if (!arrayList4.isEmpty()) {
                                        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$5$1$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                                                Applier<?> applier2 = applier;
                                                SlotWriter slotWriter2 = slotWriter;
                                                RememberManager rememberManager2 = rememberManager;
                                                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter2, "slots", rememberManager2, "rememberManager");
                                                int r0 = Ref$IntRef.this.element;
                                                if (r0 > 0) {
                                                    applier2 = new OffsetApplier(applier2, r0);
                                                }
                                                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list5 = arrayList4;
                                                int size2 = list5.size();
                                                for (int r2 = 0; r2 < size2; r2++) {
                                                    list5.get(r2).invoke(applier2, slotWriter2, rememberManager2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    record(ComposerKt.skipToGroupEndInstance);
                                    r11++;
                                    size = r16;
                                    slotTable4 = slotTable2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    this.changes = list;
                                    throw th;
                                }
                            } finally {
                                this.reader = slotReader;
                                this.nodeCountOverrides = r15;
                            }
                        } finally {
                        }
                    } finally {
                    }
                }
            }
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$2
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Applier<?> applier2 = applier;
                    SlotWriter slots = slotWriter;
                    Intrinsics.checkNotNullParameter(applier2, "applier");
                    Intrinsics.checkNotNullParameter(slots, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    ComposerImpl.insertMovableContentGuarded$positionToParentOf(slots, applier2, 0);
                    slots.endGroup();
                    return Unit.INSTANCE;
                }
            });
            this.writersReaderDelta = 0;
            Unit unit3 = Unit.INSTANCE;
            this.changes = list3;
        } catch (Throwable th3) {
            this.changes = list3;
            throw th3;
        }
    }

    public final Object nextSlot() {
        Object obj;
        int r2;
        boolean z = this.inserting;
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (z) {
            if (!(!this.nodeExpected)) {
                ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
                throw null;
            }
            return composer$Companion$Empty$1;
        }
        SlotReader slotReader = this.reader;
        if (slotReader.emptyCount <= 0 && (r2 = slotReader.currentSlot) < slotReader.currentSlotEnd) {
            slotReader.currentSlot = r2 + 1;
            obj = slotReader.slots[r2];
        } else {
            obj = composer$Companion$Empty$1;
        }
        if (!this.reusing) {
            return obj;
        }
        return composer$Companion$Empty$1;
    }

    public final void realizeDowns$1() {
        Stack<Object> stack = this.downNodes;
        if (!stack.backing.isEmpty()) {
            ArrayList<Object> arrayList = stack.backing;
            int size = arrayList.size();
            final Object[] objArr = new Object[size];
            for (int r3 = 0; r3 < size; r3++) {
                objArr[r3] = arrayList.get(r3);
            }
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeDowns$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Applier<?> applier2 = applier;
                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter, "<anonymous parameter 1>", rememberManager, "<anonymous parameter 2>");
                    for (Object obj : objArr) {
                        applier2.down(obj);
                    }
                    return Unit.INSTANCE;
                }
            });
            arrayList.clear();
        }
    }

    public final void realizeMovement() {
        final int r0 = this.previousCount;
        this.previousCount = 0;
        if (r0 > 0) {
            final int r1 = this.previousRemove;
            if (r1 >= 0) {
                this.previousRemove = -1;
                Function3<Applier<?>, SlotWriter, RememberManager, Unit> function3 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeMovement$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        Applier<?> applier2 = applier;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter, "<anonymous parameter 1>", rememberManager, "<anonymous parameter 2>");
                        applier2.remove(r1, r0);
                        return Unit.INSTANCE;
                    }
                };
                realizeUps();
                realizeDowns$1();
                record(function3);
                return;
            }
            final int r12 = this.previousMoveFrom;
            this.previousMoveFrom = -1;
            final int r3 = this.previousMoveTo;
            this.previousMoveTo = -1;
            Function3<Applier<?>, SlotWriter, RememberManager, Unit> function32 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeMovement$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Applier<?> applier2 = applier;
                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter, "<anonymous parameter 1>", rememberManager, "<anonymous parameter 2>");
                    applier2.move(r12, r3, r0);
                    return Unit.INSTANCE;
                }
            };
            realizeUps();
            realizeDowns$1();
            record(function32);
        }
    }

    public final void realizeOperationLocation(boolean z) {
        int r3;
        boolean z2;
        if (z) {
            r3 = this.reader.parent;
        } else {
            r3 = this.reader.currentGroup;
        }
        final int r0 = r3 - this.writersReaderDelta;
        if (r0 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (r0 > 0) {
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeOperationLocation$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        SlotWriter slotWriter2 = slotWriter;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                        slotWriter2.advanceBy(r0);
                        return Unit.INSTANCE;
                    }
                });
                this.writersReaderDelta = r3;
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Tried to seek backward".toString());
        throw null;
    }

    public final void realizeUps() {
        final int r0 = this.pendingUps;
        if (r0 > 0) {
            this.pendingUps = 0;
            record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$realizeUps$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Applier<?> applier2 = applier;
                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier2, "applier", slotWriter, "<anonymous parameter 1>", rememberManager, "<anonymous parameter 2>");
                    for (int r8 = 0; r8 < r0; r8++) {
                        applier2.up();
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidationsRequested) {
        boolean z;
        Intrinsics.checkNotNullParameter(invalidationsRequested, "invalidationsRequested");
        if (this.changes.isEmpty()) {
            if (invalidationsRequested.size > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !(!this.invalidations.isEmpty())) {
                return false;
            }
            doCompose(invalidationsRequested, null);
            return !this.changes.isEmpty();
        }
        ComposerKt.composeRuntimeError("Expected applyChanges() to have been called".toString());
        throw null;
    }

    public final <R> R recomposeMovableContent(ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> list, Function0<? extends R> function0) {
        R r;
        int r5;
        boolean z = this.implicitRootStart;
        boolean z2 = this.isComposing;
        int r4 = this.nodeIndex;
        try {
            this.implicitRootStart = false;
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = list.size();
            for (int r7 = 0; r7 < size; r7++) {
                Pair<RecomposeScopeImpl, IdentityArraySet<Object>> pair = list.get(r7);
                RecomposeScopeImpl recomposeScopeImpl = pair.first;
                IdentityArraySet<Object> identityArraySet = pair.second;
                if (identityArraySet != null) {
                    Object[] objArr = identityArraySet.values;
                    int r9 = identityArraySet.size;
                    for (int r12 = 0; r12 < r9; r12++) {
                        Object obj = objArr[r12];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                        tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj);
                    }
                } else {
                    tryImminentInvalidation$runtime_release(recomposeScopeImpl, null);
                }
            }
            if (controlledComposition != null) {
                if (num != null) {
                    r5 = num.intValue();
                } else {
                    r5 = -1;
                }
                r = (R) controlledComposition.delegateInvalidations(controlledComposition2, r5, function0);
                if (r == null) {
                }
                return r;
            }
            r = function0.invoke();
            return r;
        } finally {
            this.implicitRootStart = z;
            this.isComposing = z2;
            this.nodeIndex = r4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0033, code lost:            if (r9.location < r3) goto L144;     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a3 A[LOOP:5: B:98:0x0066->B:111:0x00a3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void recomposeToGroupEnd() {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recomposeToGroupEnd():void");
    }

    public final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        this.changes.add(function3);
    }

    public final void recordRemoveNode(int r2, int r3) {
        boolean z;
        if (r3 > 0) {
            if (r2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.previousRemove == r2) {
                    this.previousCount += r3;
                    return;
                }
                realizeMovement();
                this.previousRemove = r2;
                this.previousCount = r3;
                return;
            }
            ComposerKt.composeRuntimeError(("Invalid remove index " + r2).toString());
            throw null;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final void recordSideEffect(final Function0<Unit> effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordSideEffect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                RememberManager rememberManager2 = rememberManager;
                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter, "<anonymous parameter 1>", rememberManager2, "rememberManager");
                rememberManager2.sideEffect(effect);
                return Unit.INSTANCE;
            }
        });
    }

    public final void recordSlotEditing() {
        int r3;
        SlotReader slotReader = this.reader;
        if (slotReader.groupsSize > 0) {
            int r1 = slotReader.parent;
            IntStack intStack = this.startedGroups;
            int r32 = intStack.tos;
            if (r32 > 0) {
                r3 = intStack.slots[r32 - 1];
            } else {
                r3 = -2;
            }
            if (r3 != r1) {
                if (!this.startedGroup && this.implicitRootStart) {
                    recordSlotTableOperation(false, ComposerKt.startRootGroup);
                    this.startedGroup = true;
                }
                if (r1 > 0) {
                    final Anchor anchor = slotReader.anchor(r1);
                    intStack.push(r1);
                    recordSlotTableOperation(false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$recordSlotEditing$1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                            SlotWriter slotWriter2 = slotWriter;
                            ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                            Anchor anchor2 = Anchor.this;
                            Intrinsics.checkNotNullParameter(anchor2, "anchor");
                            slotWriter2.ensureStarted(slotWriter2.anchorIndex(anchor2));
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
    }

    public final void recordSlotTableOperation(boolean z, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> function3) {
        realizeOperationLocation(z);
        record(function3);
    }

    public final void recordUp() {
        Stack<Object> stack = this.downNodes;
        if (!stack.backing.isEmpty()) {
            stack.pop();
        } else {
            this.pendingUps++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void recordUpsAndDowns(int r7, int r8, int r9) {
        /*
            r6 = this;
            androidx.compose.runtime.SlotReader r0 = r6.reader
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r1 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            if (r7 != r8) goto L7
            goto L1c
        L7:
            if (r7 == r9) goto L6c
            if (r8 != r9) goto Ld
            goto L6c
        Ld:
            int r1 = r0.parent(r7)
            if (r1 != r8) goto L16
            r9 = r8
            goto L6c
        L16:
            int r1 = r0.parent(r8)
            if (r1 != r7) goto L1e
        L1c:
            r9 = r7
            goto L6c
        L1e:
            int r1 = r0.parent(r7)
            int r2 = r0.parent(r8)
            if (r1 != r2) goto L2d
            int r9 = r0.parent(r7)
            goto L6c
        L2d:
            r1 = 0
            r2 = r7
            r3 = r1
        L30:
            if (r2 <= 0) goto L3b
            if (r2 == r9) goto L3b
            int r2 = r0.parent(r2)
            int r3 = r3 + 1
            goto L30
        L3b:
            r2 = r8
            r4 = r1
        L3d:
            if (r2 <= 0) goto L48
            if (r2 == r9) goto L48
            int r2 = r0.parent(r2)
            int r4 = r4 + 1
            goto L3d
        L48:
            int r9 = r3 - r4
            r5 = r7
            r2 = r1
        L4c:
            if (r2 >= r9) goto L55
            int r5 = r0.parent(r5)
            int r2 = r2 + 1
            goto L4c
        L55:
            int r4 = r4 - r3
            r9 = r8
        L57:
            if (r1 >= r4) goto L60
            int r9 = r0.parent(r9)
            int r1 = r1 + 1
            goto L57
        L60:
            if (r5 == r9) goto L6b
            int r5 = r0.parent(r5)
            int r9 = r0.parent(r9)
            goto L60
        L6b:
            r9 = r5
        L6c:
            if (r7 <= 0) goto L7e
            if (r7 == r9) goto L7e
            boolean r1 = r0.isNode(r7)
            if (r1 == 0) goto L79
            r6.recordUp()
        L79:
            int r7 = r0.parent(r7)
            goto L6c
        L7e:
            r6.doRecordDownsFor(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.recordUpsAndDowns(int, int, int):void");
    }

    @Override // androidx.compose.runtime.Composer
    public final void recordUsed(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl;
        if (recomposeScope instanceof RecomposeScopeImpl) {
            recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
        } else {
            recomposeScopeImpl = null;
        }
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.flags |= 1;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final Object rememberedValue() {
        return nextSlot();
    }

    public final void reportFreeMovableContent(int r2) {
        reportFreeMovableContent$reportGroup(this, r2, false, 0);
        realizeMovement();
    }

    public final void skipCurrentGroup() {
        Object obj;
        if (this.invalidations.isEmpty()) {
            this.groupNodeCount = this.reader.skipGroup() + this.groupNodeCount;
            return;
        }
        SlotReader slotReader = this.reader;
        int groupKey = slotReader.getGroupKey();
        int r2 = slotReader.currentGroup;
        int r3 = slotReader.currentEnd;
        int[] r5 = slotReader.groups;
        if (r2 < r3) {
            obj = slotReader.objectKey(r5, r2);
        } else {
            obj = null;
        }
        Object groupAux = slotReader.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(obj, groupKey, groupAux);
        startReaderGroup(null, SlotTableKt.access$isNode(r5, slotReader.currentGroup));
        recomposeToGroupEnd();
        slotReader.endGroup();
        updateCompoundKeyWhenWeExitGroup(obj, groupKey, groupAux);
    }

    public final void skipReaderToGroupEnd() {
        int r0;
        SlotReader slotReader = this.reader;
        int r1 = slotReader.parent;
        if (r1 >= 0) {
            r0 = SlotTableKt.access$nodeCount(slotReader.groups, r1);
        } else {
            r0 = 0;
        }
        this.groupNodeCount = r0;
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    public final void skipToGroupEnd() {
        boolean z;
        if (this.groupNodeCount == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
            if (currentRecomposeScope$runtime_release != null) {
                currentRecomposeScope$runtime_release.flags |= 16;
            }
            if (this.invalidations.isEmpty()) {
                skipReaderToGroupEnd();
                return;
            } else {
                recomposeToGroupEnd();
                return;
            }
        }
        ComposerKt.composeRuntimeError("No nodes can be emitted before calling skipAndEndGroup".toString());
        throw null;
    }

    /* renamed from: start-BaiHCIY */
    public final void m227startBaiHCIY(int r19, int r20, Object obj, Object obj2) {
        boolean z;
        boolean z2;
        boolean z3;
        Pending pending;
        Object valueOf;
        Object obj3;
        int r5;
        int r11;
        boolean z4;
        boolean z5;
        int access$nodeCount;
        Object obj4;
        Object obj5 = obj;
        if (!this.nodeExpected) {
            updateCompoundKeyWhenWeEnterGroup(obj5, r19, obj2);
            if (r20 != 0) {
                z = true;
            } else {
                z = false;
            }
            boolean z6 = this.inserting;
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (z6) {
                this.reader.emptyCount++;
                SlotWriter slotWriter = this.writer;
                int r9 = slotWriter.currentGroup;
                if (z) {
                    slotWriter.startGroup(r19, composer$Companion$Empty$1, composer$Companion$Empty$1, true);
                } else if (obj2 != null) {
                    if (obj5 == null) {
                        obj5 = composer$Companion$Empty$1;
                    }
                    slotWriter.startGroup(r19, obj5, obj2, false);
                } else {
                    if (obj5 == null) {
                        obj5 = composer$Companion$Empty$1;
                    }
                    slotWriter.startGroup(r19, obj5, composer$Companion$Empty$1, false);
                }
                Pending pending2 = this.pending;
                if (pending2 != null) {
                    int r6 = (-2) - r9;
                    KeyInfo keyInfo = new KeyInfo(r19, r6, -1, -1);
                    pending2.groupInfos.put(Integer.valueOf(r6), new GroupInfo(-1, this.nodeIndex - pending2.startIndex, 0));
                    pending2.usedKeys.add(keyInfo);
                }
                enterGroup(z, null);
                return;
            }
            if (r20 != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && this.reusing) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.pending == null) {
                int groupKey = this.reader.getGroupKey();
                if (!z3 && groupKey == r19) {
                    SlotReader slotReader = this.reader;
                    int r12 = slotReader.currentGroup;
                    if (r12 < slotReader.currentEnd) {
                        obj4 = slotReader.objectKey(slotReader.groups, r12);
                    } else {
                        obj4 = null;
                    }
                    if (Intrinsics.areEqual(obj5, obj4)) {
                        startReaderGroup(obj2, z);
                    }
                }
                SlotReader slotReader2 = this.reader;
                slotReader2.getClass();
                ArrayList arrayList = new ArrayList();
                if (slotReader2.emptyCount <= 0) {
                    int r14 = slotReader2.currentGroup;
                    while (r14 < slotReader2.currentEnd) {
                        int r16 = r14 * 5;
                        int[] r112 = slotReader2.groups;
                        int r7 = r112[r16];
                        Object objectKey = slotReader2.objectKey(r112, r14);
                        if (SlotTableKt.access$isNode(r112, r14)) {
                            access$nodeCount = 1;
                        } else {
                            access$nodeCount = SlotTableKt.access$nodeCount(r112, r14);
                        }
                        arrayList.add(new KeyInfo(r7, r14, access$nodeCount, objectKey));
                        r14 += r112[r16 + 3];
                    }
                }
                this.pending = new Pending(arrayList, this.nodeIndex);
            }
            Pending pending3 = this.pending;
            if (pending3 != null) {
                if (obj5 != null) {
                    valueOf = new JoinedKey(Integer.valueOf(r19), obj5);
                } else {
                    valueOf = Integer.valueOf(r19);
                }
                HashMap hashMap = (HashMap) pending3.keyMap$delegate.getValue();
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                LinkedHashSet linkedHashSet = (LinkedHashSet) hashMap.get(valueOf);
                if (linkedHashSet != null && (obj3 = CollectionsKt___CollectionsKt.firstOrNull(linkedHashSet)) != null) {
                    LinkedHashSet linkedHashSet2 = (LinkedHashSet) hashMap.get(valueOf);
                    if (linkedHashSet2 != null) {
                        linkedHashSet2.remove(obj3);
                        if (linkedHashSet2.isEmpty()) {
                            hashMap.remove(valueOf);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    obj3 = null;
                }
                KeyInfo keyInfo2 = (KeyInfo) obj3;
                HashMap<Integer, GroupInfo> hashMap2 = pending3.groupInfos;
                ArrayList arrayList2 = pending3.usedKeys;
                int r113 = pending3.startIndex;
                if (!z3 && keyInfo2 != null) {
                    arrayList2.add(keyInfo2);
                    this.nodeIndex = pending3.nodePositionOf(keyInfo2) + r113;
                    int r1 = keyInfo2.location;
                    GroupInfo groupInfo = hashMap2.get(Integer.valueOf(r1));
                    if (groupInfo != null) {
                        r11 = groupInfo.slotIndex;
                    } else {
                        r11 = -1;
                    }
                    int r2 = pending3.groupIndex;
                    final int r3 = r11 - r2;
                    if (r11 > r2) {
                        Collection<GroupInfo> values = hashMap2.values();
                        Intrinsics.checkNotNullExpressionValue(values, "groupInfos.values");
                        for (GroupInfo groupInfo2 : values) {
                            int r72 = groupInfo2.slotIndex;
                            if (r72 == r11) {
                                groupInfo2.slotIndex = r2;
                            } else {
                                if (r2 <= r72 && r72 < r11) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    groupInfo2.slotIndex = r72 + 1;
                                }
                            }
                        }
                    } else if (r2 > r11) {
                        Collection<GroupInfo> values2 = hashMap2.values();
                        Intrinsics.checkNotNullExpressionValue(values2, "groupInfos.values");
                        for (GroupInfo groupInfo3 : values2) {
                            int r73 = groupInfo3.slotIndex;
                            if (r73 == r11) {
                                groupInfo3.slotIndex = r2;
                            } else {
                                if (r11 + 1 <= r73 && r73 < r2) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    groupInfo3.slotIndex = r73 - 1;
                                }
                            }
                        }
                    }
                    SlotReader slotReader3 = this.reader;
                    this.writersReaderDelta = r1 - (slotReader3.currentGroup - this.writersReaderDelta);
                    slotReader3.reposition(r1);
                    if (r3 > 0) {
                        Function3<Applier<?>, SlotWriter, RememberManager, Unit> function3 = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$start$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter2, RememberManager rememberManager) {
                                boolean z7;
                                boolean z8;
                                int r192;
                                int r22;
                                boolean z9;
                                SlotWriter slotWriter3 = slotWriter2;
                                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter3, "slots", rememberManager, "<anonymous parameter 2>");
                                if (slotWriter3.insertCount == 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7) {
                                    int r4 = r3;
                                    if (r4 >= 0) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    if (z8) {
                                        if (r4 != 0) {
                                            int r52 = slotWriter3.currentGroup;
                                            int r8 = slotWriter3.parent;
                                            int r92 = slotWriter3.currentGroupEnd;
                                            int r10 = r52;
                                            while (r4 > 0) {
                                                r10 += SlotTableKt.access$groupSize(slotWriter3.groups, slotWriter3.groupIndexToAddress(r10));
                                                if (r10 <= r92) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                if (!z9) {
                                                    ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                                                    throw null;
                                                }
                                                r4--;
                                            }
                                            int access$groupSize = SlotTableKt.access$groupSize(slotWriter3.groups, slotWriter3.groupIndexToAddress(r10));
                                            int r42 = slotWriter3.currentSlot;
                                            int dataIndex = slotWriter3.dataIndex(slotWriter3.groups, slotWriter3.groupIndexToAddress(r10));
                                            int r102 = r10 + access$groupSize;
                                            int dataIndex2 = slotWriter3.dataIndex(slotWriter3.groups, slotWriter3.groupIndexToAddress(r102));
                                            int r114 = dataIndex2 - dataIndex;
                                            slotWriter3.insertSlots(r114, Math.max(slotWriter3.currentGroup - 1, 0));
                                            slotWriter3.insertGroups(access$groupSize);
                                            int[] r13 = slotWriter3.groups;
                                            int groupIndexToAddress = slotWriter3.groupIndexToAddress(r102) * 5;
                                            ArraysKt___ArraysJvmKt.copyInto(slotWriter3.groupIndexToAddress(r52) * 5, groupIndexToAddress, r13, r13, (access$groupSize * 5) + groupIndexToAddress);
                                            if (r114 > 0) {
                                                Object[] objArr = slotWriter3.slots;
                                                ArraysKt___ArraysJvmKt.copyInto(r42, slotWriter3.dataIndexToDataAddress(dataIndex + r114), slotWriter3.dataIndexToDataAddress(dataIndex2 + r114), objArr, objArr);
                                            }
                                            int r74 = dataIndex + r114;
                                            int r23 = r74 - r42;
                                            int r43 = slotWriter3.slotsGapStart;
                                            int r93 = slotWriter3.slotsGapLen;
                                            int length = slotWriter3.slots.length;
                                            int r132 = slotWriter3.slotsGapOwner;
                                            int r142 = r52 + access$groupSize;
                                            int r15 = r52;
                                            while (r15 < r142) {
                                                int groupIndexToAddress2 = slotWriter3.groupIndexToAddress(r15);
                                                int r18 = r43;
                                                int dataIndex3 = slotWriter3.dataIndex(r13, groupIndexToAddress2) - r23;
                                                if (r132 < groupIndexToAddress2) {
                                                    r192 = r23;
                                                    r22 = 0;
                                                } else {
                                                    r192 = r23;
                                                    r22 = r18;
                                                }
                                                if (dataIndex3 > r22) {
                                                    dataIndex3 = -(((length - r93) - dataIndex3) + 1);
                                                }
                                                int r24 = slotWriter3.slotsGapStart;
                                                int r162 = r93;
                                                int r94 = slotWriter3.slotsGapLen;
                                                int r202 = length;
                                                int length2 = slotWriter3.slots.length;
                                                if (dataIndex3 > r24) {
                                                    dataIndex3 = -(((length2 - r94) - dataIndex3) + 1);
                                                }
                                                r13[(groupIndexToAddress2 * 5) + 4] = dataIndex3;
                                                r15++;
                                                r43 = r18;
                                                r23 = r192;
                                                length = r202;
                                                r93 = r162;
                                            }
                                            int r0 = access$groupSize + r102;
                                            int size$runtime_release = slotWriter3.getSize$runtime_release();
                                            int access$locationOf = SlotTableKt.access$locationOf(slotWriter3.anchors, r102, size$runtime_release);
                                            ArrayList arrayList3 = new ArrayList();
                                            if (access$locationOf >= 0) {
                                                while (access$locationOf < slotWriter3.anchors.size()) {
                                                    Anchor anchor = slotWriter3.anchors.get(access$locationOf);
                                                    Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                                                    Anchor anchor2 = anchor;
                                                    int anchorIndex = slotWriter3.anchorIndex(anchor2);
                                                    if (anchorIndex < r102 || anchorIndex >= r0) {
                                                        break;
                                                    }
                                                    arrayList3.add(anchor2);
                                                    slotWriter3.anchors.remove(access$locationOf);
                                                }
                                            }
                                            int r02 = r52 - r102;
                                            int size = arrayList3.size();
                                            for (int r95 = 0; r95 < size; r95++) {
                                                Anchor anchor3 = (Anchor) arrayList3.get(r95);
                                                int anchorIndex2 = slotWriter3.anchorIndex(anchor3) + r02;
                                                if (anchorIndex2 >= slotWriter3.groupGapStart) {
                                                    anchor3.location = -(size$runtime_release - anchorIndex2);
                                                } else {
                                                    anchor3.location = anchorIndex2;
                                                }
                                                slotWriter3.anchors.add(SlotTableKt.access$locationOf(slotWriter3.anchors, anchorIndex2, size$runtime_release), anchor3);
                                            }
                                            if (!slotWriter3.removeGroups(r102, access$groupSize)) {
                                                slotWriter3.fixParentAnchorsFor(r8, slotWriter3.currentGroupEnd, r52);
                                                if (r114 > 0) {
                                                    slotWriter3.removeSlots(r74, r114, r102 - 1);
                                                }
                                            } else {
                                                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                                                throw null;
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    ComposerKt.composeRuntimeError("Parameter offset is out of bounds".toString());
                                    throw null;
                                }
                                ComposerKt.composeRuntimeError("Cannot move a group while inserting".toString());
                                throw null;
                            }
                        };
                        realizeOperationLocation(false);
                        recordSlotEditing();
                        record(function3);
                    }
                    startReaderGroup(obj2, z);
                } else {
                    this.reader.emptyCount++;
                    this.inserting = true;
                    this.providerCache = null;
                    if (this.writer.closed) {
                        SlotWriter openWriter = this.insertTable.openWriter();
                        this.writer = openWriter;
                        openWriter.skipToGroupEnd();
                        this.writerHasAProvider = false;
                        this.providerCache = null;
                    }
                    this.writer.beginInsert();
                    SlotWriter slotWriter2 = this.writer;
                    int r52 = slotWriter2.currentGroup;
                    if (z) {
                        slotWriter2.startGroup(r19, composer$Companion$Empty$1, composer$Companion$Empty$1, true);
                    } else if (obj2 != null) {
                        if (obj5 == null) {
                            obj5 = composer$Companion$Empty$1;
                        }
                        slotWriter2.startGroup(r19, obj5, obj2, false);
                    } else {
                        if (obj5 == null) {
                            obj5 = composer$Companion$Empty$1;
                        }
                        slotWriter2.startGroup(r19, obj5, composer$Companion$Empty$1, false);
                    }
                    this.insertAnchor = this.writer.anchor(r52);
                    int r53 = (-2) - r52;
                    KeyInfo keyInfo3 = new KeyInfo(r19, r53, -1, -1);
                    hashMap2.put(Integer.valueOf(r53), new GroupInfo(-1, this.nodeIndex - r113, 0));
                    arrayList2.add(keyInfo3);
                    ArrayList arrayList3 = new ArrayList();
                    if (z) {
                        r5 = 0;
                    } else {
                        r5 = this.nodeIndex;
                    }
                    pending = new Pending(arrayList3, r5);
                    enterGroup(z, pending);
                    return;
                }
            }
            pending = null;
            enterGroup(z, pending);
            return;
        }
        ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected".toString());
        throw null;
    }

    public final void startDefaults() {
        m227startBaiHCIY(-127, 0, null, null);
    }

    public final void startGroup(int r3, OpaqueKey opaqueKey) {
        m227startBaiHCIY(r3, 0, opaqueKey, null);
    }

    @Override // androidx.compose.runtime.Composer
    public final void startMovableGroup(int r3, Object obj) {
        m227startBaiHCIY(r3, 0, obj, null);
    }

    public final void startNode() {
        m227startBaiHCIY(125, 1, null, null);
        this.nodeExpected = true;
    }

    public final void startProviders(final ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap updateProviderMapGroup;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(values, "values");
        final PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.provider);
        startGroup(203, ComposerKt.providerValues);
        Function2<Composer, Integer, PersistentCompositionLocalMap> function2 = new Function2<Composer, Integer, PersistentCompositionLocalMap>() { // from class: androidx.compose.runtime.ComposerImpl$startProviders$currentProviders$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final PersistentCompositionLocalMap invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                num.intValue();
                composer2.startReplaceableGroup(-948105361);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ProvidedValue<?>[] values2 = values;
                Intrinsics.checkNotNullParameter(values2, "values");
                PersistentCompositionLocalMap parentScope = currentCompositionLocalScope;
                Intrinsics.checkNotNullParameter(parentScope, "parentScope");
                composer2.startReplaceableGroup(-300354947);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = PersistentCompositionLocalHashMap.Empty;
                persistentCompositionLocalHashMap.getClass();
                PersistentCompositionLocalHashMap.Builder builder = new PersistentCompositionLocalHashMap.Builder(persistentCompositionLocalHashMap);
                for (ProvidedValue<?> providedValue : values2) {
                    composer2.startReplaceableGroup(680845765);
                    boolean z = providedValue.canOverride;
                    CompositionLocal<?> key = providedValue.compositionLocal;
                    if (!z) {
                        Intrinsics.checkNotNullParameter(key, "key");
                        if (parentScope.containsKey(key)) {
                            composer2.endReplaceableGroup();
                        }
                    }
                    Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
                    builder.put(key, key.provided$runtime_release(providedValue.value, composer2));
                    composer2.endReplaceableGroup();
                }
                PersistentCompositionLocalHashMap build = builder.build();
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                return build;
            }
        };
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
        PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) function2.invoke(this, 1);
        end(false);
        if (this.inserting) {
            updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, persistentCompositionLocalMap);
            this.writerHasAProvider = true;
            areEqual = false;
        } else {
            SlotReader slotReader = this.reader;
            Object groupGet = slotReader.groupGet(slotReader.currentGroup, 0);
            Intrinsics.checkNotNull(groupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) groupGet;
            SlotReader slotReader2 = this.reader;
            Object groupGet2 = slotReader2.groupGet(slotReader2.currentGroup, 1);
            Intrinsics.checkNotNull(groupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap3 = (PersistentCompositionLocalMap) groupGet2;
            if (getSkipping() && Intrinsics.areEqual(persistentCompositionLocalMap3, persistentCompositionLocalMap)) {
                this.groupNodeCount = this.reader.skipGroup() + this.groupNodeCount;
                areEqual = false;
                updateProviderMapGroup = persistentCompositionLocalMap2;
            } else {
                updateProviderMapGroup = updateProviderMapGroup(currentCompositionLocalScope, persistentCompositionLocalMap);
                areEqual = true ^ Intrinsics.areEqual(updateProviderMapGroup, persistentCompositionLocalMap2);
            }
        }
        if (areEqual && !this.inserting) {
            ((SparseArray) this.providerUpdates.sparseArray).put(this.reader.currentGroup, updateProviderMapGroup);
        }
        this.providersInvalidStack.push(this.providersInvalid ? 1 : 0);
        this.providersInvalid = areEqual;
        this.providerCache = updateProviderMapGroup;
        m227startBaiHCIY(202, 0, ComposerKt.compositionLocalMap, updateProviderMapGroup);
    }

    public final void startReaderGroup(final Object obj, boolean z) {
        if (z) {
            SlotReader slotReader = this.reader;
            if (slotReader.emptyCount <= 0) {
                if (SlotTableKt.access$isNode(slotReader.groups, slotReader.currentGroup)) {
                    slotReader.startGroup();
                    return;
                }
                throw new IllegalArgumentException("Expected a node group".toString());
            }
            return;
        }
        if (obj != null && this.reader.getGroupAux() != obj) {
            recordSlotTableOperation(false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$startReaderGroup$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    SlotWriter slotWriter2 = slotWriter;
                    ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager, "<anonymous parameter 2>");
                    slotWriter2.updateAux(obj);
                    return Unit.INSTANCE;
                }
            });
        }
        this.reader.startGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public final void startReplaceableGroup(int r3) {
        m227startBaiHCIY(r3, 0, null, null);
    }

    @Override // androidx.compose.runtime.Composer
    public final ComposerImpl startRestartGroup(int r9) {
        Object obj;
        RecomposeScopeImpl recomposeScopeImpl;
        int r5;
        boolean z = false;
        Invalidation invalidation = null;
        m227startBaiHCIY(r9, 0, null, null);
        boolean z2 = this.inserting;
        Stack<RecomposeScopeImpl> stack = this.invalidateStack;
        ControlledComposition controlledComposition = this.composition;
        if (z2) {
            Intrinsics.checkNotNull(controlledComposition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            RecomposeScopeImpl recomposeScopeImpl2 = new RecomposeScopeImpl((CompositionImpl) controlledComposition);
            stack.push(recomposeScopeImpl2);
            updateValue(recomposeScopeImpl2);
            recomposeScopeImpl2.currentToken = this.compositionToken;
            recomposeScopeImpl2.flags &= -17;
        } else {
            ArrayList arrayList = this.invalidations;
            int findLocation = ComposerKt.findLocation(this.reader.parent, arrayList);
            if (findLocation >= 0) {
                invalidation = (Invalidation) arrayList.remove(findLocation);
            }
            SlotReader slotReader = this.reader;
            int r52 = slotReader.emptyCount;
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (r52 <= 0 && (r5 = slotReader.currentSlot) < slotReader.currentSlotEnd) {
                slotReader.currentSlot = r5 + 1;
                obj = slotReader.slots[r5];
            } else {
                obj = composer$Companion$Empty$1;
            }
            if (Intrinsics.areEqual(obj, composer$Companion$Empty$1)) {
                Intrinsics.checkNotNull(controlledComposition, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
                recomposeScopeImpl = new RecomposeScopeImpl((CompositionImpl) controlledComposition);
                updateValue(recomposeScopeImpl);
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                recomposeScopeImpl = (RecomposeScopeImpl) obj;
            }
            if (invalidation != null) {
                z = true;
            }
            if (z) {
                recomposeScopeImpl.flags |= 8;
            } else {
                recomposeScopeImpl.flags &= -9;
            }
            stack.push(recomposeScopeImpl);
            recomposeScopeImpl.currentToken = this.compositionToken;
            recomposeScopeImpl.flags &= -17;
        }
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public final void startReusableGroup(Object obj) {
        if (this.reader.getGroupKey() == 207 && !Intrinsics.areEqual(this.reader.getGroupAux(), obj) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.currentGroup;
            this.reusing = true;
        }
        m227startBaiHCIY(207, 0, null, obj);
    }

    @Override // androidx.compose.runtime.Composer
    public final void startReusableNode() {
        m227startBaiHCIY(125, 2, null, null);
        this.nodeExpected = true;
    }

    public final void startRoot() {
        SlotTable slotTable = this.slotTable;
        this.reader = slotTable.openReader();
        m227startBaiHCIY(100, 0, null, null);
        CompositionContext compositionContext = this.parentContext;
        compositionContext.startComposing$runtime_release();
        this.parentProvider = compositionContext.getCompositionLocalScope$runtime_release();
        boolean z = this.providersInvalid;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        this.providersInvalidStack.push(z ? 1 : 0);
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = compositionContext.getCollectingParameterInformation$runtime_release();
        }
        Set<Object> set = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.LocalInspectionTables);
        if (set != null) {
            set.add(slotTable);
            compositionContext.recordInspectionTable$runtime_release(set);
        }
        m227startBaiHCIY(compositionContext.getCompoundHashKey$runtime_release(), 0, null, null);
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl scope, Object obj) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Anchor anchor = scope.anchor;
        if (anchor == null) {
            return false;
        }
        SlotTable slots = this.reader.table;
        Intrinsics.checkNotNullParameter(slots, "slots");
        int anchorIndex = slots.anchorIndex(anchor);
        if (!this.isComposing || anchorIndex < this.reader.currentGroup) {
            return false;
        }
        ArrayList arrayList = this.invalidations;
        int findLocation = ComposerKt.findLocation(anchorIndex, arrayList);
        IdentityArraySet identityArraySet = null;
        if (findLocation < 0) {
            int r2 = -(findLocation + 1);
            if (obj != null) {
                identityArraySet = new IdentityArraySet();
                identityArraySet.add(obj);
            }
            arrayList.add(r2, new Invalidation(scope, anchorIndex, identityArraySet));
        } else if (obj == null) {
            ((Invalidation) arrayList.get(findLocation)).instances = null;
        } else {
            IdentityArraySet<Object> identityArraySet2 = ((Invalidation) arrayList.get(findLocation)).instances;
            if (identityArraySet2 != null) {
                identityArraySet2.add(obj);
            }
        }
        return true;
    }

    public final void updateCompoundKeyWhenWeEnterGroup(Object obj, int r3, Object obj2) {
        if (obj == null) {
            if (obj2 != null && r3 == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.Empty)) {
                this.compoundKeyHash = obj2.hashCode() ^ Integer.rotateLeft(this.compoundKeyHash, 3);
                return;
            } else {
                this.compoundKeyHash = Integer.rotateLeft(this.compoundKeyHash, 3) ^ r3;
                return;
            }
        }
        if (obj instanceof Enum) {
            this.compoundKeyHash = ((Enum) obj).ordinal() ^ Integer.rotateLeft(this.compoundKeyHash, 3);
        } else {
            this.compoundKeyHash = obj.hashCode() ^ Integer.rotateLeft(this.compoundKeyHash, 3);
        }
    }

    public final void updateCompoundKeyWhenWeExitGroup(Object obj, int r2, Object obj2) {
        if (obj == null) {
            if (obj2 != null && r2 == 207 && !Intrinsics.areEqual(obj2, Composer.Companion.Empty)) {
                updateCompoundKeyWhenWeExitGroupKeyHash(obj2.hashCode());
                return;
            } else {
                updateCompoundKeyWhenWeExitGroupKeyHash(r2);
                return;
            }
        }
        if (obj instanceof Enum) {
            updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) obj).ordinal());
        } else {
            updateCompoundKeyWhenWeExitGroupKeyHash(obj.hashCode());
        }
    }

    public final void updateCompoundKeyWhenWeExitGroupKeyHash(int r2) {
        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(r2) ^ this.compoundKeyHash, 3);
    }

    public final void updateNodeCount(int r5, int r6) {
        if (updatedNodeCount(r5) != r6) {
            if (r5 < 0) {
                HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    this.nodeCountVirtualOverrides = hashMap;
                }
                hashMap.put(Integer.valueOf(r5), Integer.valueOf(r6));
                return;
            }
            int[] r0 = this.nodeCountOverrides;
            if (r0 == null) {
                int r02 = this.reader.groupsSize;
                int[] r1 = new int[r02];
                Arrays.fill(r1, 0, r02, -1);
                this.nodeCountOverrides = r1;
                r0 = r1;
            }
            r0[r5] = r6;
        }
    }

    public final void updateNodeCountOverrides(int r7, int r8) {
        int updatedNodeCount = updatedNodeCount(r7);
        if (updatedNodeCount != r8) {
            int r82 = r8 - updatedNodeCount;
            Stack<Pending> stack = this.pendingStack;
            int size = stack.backing.size() - 1;
            while (r7 != -1) {
                int updatedNodeCount2 = updatedNodeCount(r7) + r82;
                updateNodeCount(r7, updatedNodeCount2);
                int r4 = size;
                while (true) {
                    if (-1 < r4) {
                        Pending pending = stack.backing.get(r4);
                        if (pending != null && pending.updateNodeCount(r7, updatedNodeCount2)) {
                            size = r4 - 1;
                            break;
                        }
                        r4--;
                    } else {
                        break;
                    }
                }
                if (r7 < 0) {
                    r7 = this.reader.parent;
                } else if (!this.reader.isNode(r7)) {
                    r7 = this.reader.parent(r7);
                } else {
                    return;
                }
            }
        }
    }

    public final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builder = persistentCompositionLocalMap.builder();
        builder.putAll(persistentCompositionLocalMap2);
        PersistentCompositionLocalHashMap build = builder.build();
        startGroup(204, ComposerKt.providerMaps);
        changed(build);
        changed(persistentCompositionLocalMap2);
        end(false);
        return build;
    }

    @Override // androidx.compose.runtime.Composer
    public final void updateRememberedValue(Object obj) {
        updateValue(obj);
    }

    public final void updateValue(final Object obj) {
        boolean z = this.inserting;
        Set<RememberObserver> set = this.abandonSet;
        if (z) {
            this.writer.update(obj);
            if (obj instanceof RememberObserver) {
                record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$updateValue$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                        RememberManager rememberManager2 = rememberManager;
                        ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter, "<anonymous parameter 1>", rememberManager2, "rememberManager");
                        rememberManager2.remembering((RememberObserver) obj);
                        return Unit.INSTANCE;
                    }
                });
                set.add(obj);
                return;
            }
            return;
        }
        SlotReader slotReader = this.reader;
        final int access$slotAnchor = (slotReader.currentSlot - SlotTableKt.access$slotAnchor(slotReader.groups, slotReader.parent)) - 1;
        if (obj instanceof RememberObserver) {
            set.add(obj);
        }
        recordSlotTableOperation(true, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$updateValue$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                SlotWriter slotWriter2 = slotWriter;
                RememberManager rememberManager2 = rememberManager;
                ComposerImpl$createNode$2$$ExternalSyntheticOutline0.m(applier, "<anonymous parameter 0>", slotWriter2, "slots", rememberManager2, "rememberManager");
                Object obj2 = obj;
                if (obj2 instanceof RememberObserver) {
                    rememberManager2.remembering((RememberObserver) obj2);
                }
                Object obj3 = slotWriter2.set(access$slotAnchor, obj2);
                if (obj3 instanceof RememberObserver) {
                    rememberManager2.forgetting((RememberObserver) obj3);
                } else if (obj3 instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj3;
                    RecomposeScopeOwner recomposeScopeOwner = recomposeScopeImpl.owner;
                    if (recomposeScopeOwner != null) {
                        recomposeScopeOwner.recomposeScopeReleased(recomposeScopeImpl);
                    }
                    recomposeScopeImpl.owner = null;
                    recomposeScopeImpl.trackedInstances = null;
                    recomposeScopeImpl.trackedDependencies = null;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final int updatedNodeCount(int r2) {
        int r0;
        Integer num;
        if (r2 < 0) {
            HashMap<Integer, Integer> hashMap = this.nodeCountVirtualOverrides;
            if (hashMap != null && (num = hashMap.get(Integer.valueOf(r2))) != null) {
                return num.intValue();
            }
            return 0;
        }
        int[] r02 = this.nodeCountOverrides;
        if (r02 != null && (r0 = r02[r2]) >= 0) {
            return r0;
        }
        return this.reader.nodeCount(r2);
    }

    @Override // androidx.compose.runtime.Composer
    public final void useNode() {
        if (this.nodeExpected) {
            this.nodeExpected = false;
            if (!this.inserting) {
                SlotReader slotReader = this.reader;
                Object node = slotReader.node(slotReader.parent);
                this.downNodes.push(node);
                if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
                    realizeUps();
                    realizeDowns$1();
                    record(new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$useNode$2
                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                            Applier<?> applier2 = applier;
                            Intrinsics.checkNotNullParameter(applier2, "applier");
                            Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
                            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                            Object current = applier2.getCurrent();
                            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
                            ((ComposeNodeLifecycleCallback) current).onReuse();
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                return;
            }
            ComposerKt.composeRuntimeError("useNode() called while inserting".toString());
            throw null;
        }
        ComposerKt.composeRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected".toString());
        throw null;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changed(boolean z) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Boolean) && z == ((Boolean) nextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(z));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changed(float f) {
        Object nextSlot = nextSlot();
        if (nextSlot instanceof Float) {
            if (f == ((Number) nextSlot).floatValue()) {
                return false;
            }
        }
        updateValue(Float.valueOf(f));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changed(long j) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Long) && j == ((Number) nextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(j));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean changed(int r3) {
        Object nextSlot = nextSlot();
        if ((nextSlot instanceof Integer) && r3 == ((Number) nextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(r3));
        return true;
    }

    /* compiled from: Composer.kt */
    /* loaded from: classes.dex */
    public static final class CompositionContextHolder implements RememberObserver {
        public final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public final void onRemembered() {
        }
    }

    public final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.parent);
    }
}
