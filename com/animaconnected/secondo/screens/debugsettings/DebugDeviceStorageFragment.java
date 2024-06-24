package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.msgpack.MsgPackKotlin;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.Command;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.device.WatchIODebug;
import com.animaconnected.watch.device.files.Directory;
import com.animaconnected.watch.device.files.FileDescriptor;
import com.animaconnected.watch.device.files.FileEntry;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.widget.theme.ColorsKt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DebugDeviceStorageFragment.kt */
/* loaded from: classes3.dex */
public final class DebugDeviceStorageFragment extends BaseFragment {
    private TextView content;
    private final List<ListEntry> listEntries = new ArrayList();
    private final String name;
    private RecyclerView rv;
    private DebugDeviceStorageAdapter rvAdapter;
    private final DisplayWatch watch;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugDeviceStorageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugDeviceStorageFragment newInstance() {
            return new DebugDeviceStorageFragment();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugDeviceStorageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class DebugDeviceStorageAdapter extends RecyclerView.Adapter<DebugDeviceStorageViewHolder> {
        private List<? extends ListEntry> entries;
        private final Function1<Integer, Unit> onFileItemClick;
        private final Function1<Integer, Boolean> onFileItemRemoveClick;

        /* compiled from: DebugDeviceStorageFragment.kt */
        /* loaded from: classes3.dex */
        public final class DebugDeviceStorageViewHolder extends RecyclerView.ViewHolder {
            private final TextView content;
            private final TextView hash;
            private final ImageView image;
            private final TextView path;
            private final ImageView remove;
            final /* synthetic */ DebugDeviceStorageAdapter this$0;
            private final TextView ts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DebugDeviceStorageViewHolder(final DebugDeviceStorageAdapter debugDeviceStorageAdapter, View itemView, final Function1<? super Integer, Unit> onItemClicked, final Function1<? super Integer, Boolean> onItemRemoveClick) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
                Intrinsics.checkNotNullParameter(onItemRemoveClick, "onItemRemoveClick");
                this.this$0 = debugDeviceStorageAdapter;
                View findViewById = itemView.findViewById(R.id.tv_debug_device_storage_row_path);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.path = (TextView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.tv_debug_device_storage_hash);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.hash = (TextView) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.tv_debug_device_storage_ts);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.ts = (TextView) findViewById3;
                View findViewById4 = itemView.findViewById(R.id.tv_debug_device_storage_row_content);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
                this.content = (TextView) findViewById4;
                View findViewById5 = itemView.findViewById(R.id.tv_debug_device_storage_remove);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
                ImageView imageView = (ImageView) findViewById5;
                this.remove = imageView;
                View findViewById6 = itemView.findViewById(R.id.tv_debug_device_storage_remove);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
                this.image = (ImageView) findViewById6;
                itemView.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$DebugDeviceStorageAdapter$DebugDeviceStorageViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DebugDeviceStorageFragment.DebugDeviceStorageAdapter.DebugDeviceStorageViewHolder._init_$lambda$0(DebugDeviceStorageFragment.DebugDeviceStorageAdapter.this, this, onItemClicked, view);
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$DebugDeviceStorageAdapter$DebugDeviceStorageViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DebugDeviceStorageFragment.DebugDeviceStorageAdapter.DebugDeviceStorageViewHolder._init_$lambda$1(Function1.this, this, view);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void _init_$lambda$0(DebugDeviceStorageAdapter this$0, DebugDeviceStorageViewHolder this$1, Function1 onItemClicked, View view) {
                ListEntryFile listEntryFile;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
                ListEntry listEntry = this$0.getEntries().get(this$1.getBindingAdapterPosition());
                if (listEntry instanceof ListEntryFile) {
                    listEntryFile = (ListEntryFile) listEntry;
                } else {
                    listEntryFile = null;
                }
                if (listEntryFile == null) {
                    return;
                }
                listEntryFile.setExpanded(!listEntryFile.isExpanded());
                onItemClicked.invoke(Integer.valueOf(this$1.getBindingAdapterPosition()));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void _init_$lambda$1(Function1 onItemRemoveClick, DebugDeviceStorageViewHolder this$0, View view) {
                Intrinsics.checkNotNullParameter(onItemRemoveClick, "$onItemRemoveClick");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                onItemRemoveClick.invoke(Integer.valueOf(this$0.getBindingAdapterPosition()));
            }

            public final TextView getContent() {
                return this.content;
            }

            public final TextView getHash() {
                return this.hash;
            }

            public final ImageView getImage() {
                return this.image;
            }

            public final TextView getPath() {
                return this.path;
            }

            public final ImageView getRemove() {
                return this.remove;
            }

            public final TextView getTs() {
                return this.ts;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DebugDeviceStorageAdapter(Function1<? super Integer, Unit> onFileItemClick, Function1<? super Integer, Boolean> onFileItemRemoveClick) {
            Intrinsics.checkNotNullParameter(onFileItemClick, "onFileItemClick");
            Intrinsics.checkNotNullParameter(onFileItemRemoveClick, "onFileItemRemoveClick");
            this.onFileItemClick = onFileItemClick;
            this.onFileItemRemoveClick = onFileItemRemoveClick;
            this.entries = EmptyList.INSTANCE;
        }

        public final List<ListEntry> getEntries() {
            return this.entries;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.entries.size();
        }

        public final void setEntries(List<? extends ListEntry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.entries = list;
        }

        public final void setListEntries(List<? extends ListEntry> entries) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @SuppressLint({"SetTextI18n"})
        public void onBindViewHolder(DebugDeviceStorageViewHolder holder, int r9) {
            int r3;
            int r32;
            int r33;
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.getPath().setPaintFlags(0);
            int r2 = 8;
            holder.getRemove().setVisibility(8);
            ListEntry listEntry = this.entries.get(r9);
            if (listEntry instanceof ListEntryDirectory) {
                holder.itemView.setBackgroundColor(Integer.MIN_VALUE);
                holder.getPath().setText(((ListEntryDirectory) listEntry).getDirectory().getFullPath());
                return;
            }
            if (listEntry instanceof ListEntryFile) {
                TextView hash = holder.getHash();
                ListEntryFile listEntryFile = (ListEntryFile) listEntry;
                UInt m1106getDataHash0hXNFcg = listEntryFile.getFile().m1106getDataHash0hXNFcg();
                if (m1106getDataHash0hXNFcg != null) {
                    holder.getHash().setText("Hash: " + ByteUtils.toHex(ByteUtils.m737encodeUInt32LEWZ4Q5Ns(m1106getDataHash0hXNFcg.data)));
                    r3 = 0;
                } else {
                    r3 = 8;
                }
                hash.setVisibility(r3);
                TextView ts = holder.getTs();
                if (listEntryFile.getFile().getTimestamp() != null) {
                    holder.getTs().setText("Timestamp: " + listEntryFile.getFile().getTimestamp());
                    r32 = 0;
                } else {
                    r32 = 8;
                }
                ts.setVisibility(r32);
                TextView content = holder.getContent();
                if (listEntryFile.isExpanded()) {
                    holder.getContent().setText(listEntryFile.getContent());
                    r33 = 0;
                } else {
                    r33 = 8;
                }
                content.setVisibility(r33);
                ImageView image = holder.getImage();
                if (listEntryFile.isExpanded() && listEntryFile.getBitmap() != null) {
                    holder.getImage().setImageBitmap(listEntryFile.getBitmap());
                    r2 = 0;
                }
                image.setVisibility(r2);
                holder.getPath().setText("    " + listEntryFile.getFile().getName() + " - " + listEntryFile.getFile().getSize() + 'B');
                if (listEntryFile.getRemoved()) {
                    holder.itemView.setBackgroundColor(819663892);
                    holder.getPath().setPaintFlags(16);
                } else {
                    holder.getRemove().setVisibility(0);
                    holder.itemView.setBackgroundColor((int) (listEntryFile.getFile().m1106getDataHash0hXNFcg() != null ? ColorsKt.AMBER_GOLD : 4286690191L));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DebugDeviceStorageViewHolder onCreateViewHolder(ViewGroup parent, int r4) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_debug_device_storage, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new DebugDeviceStorageViewHolder(this, inflate, this.onFileItemClick, this.onFileItemRemoveClick);
        }
    }

    /* compiled from: DebugDeviceStorageFragment.kt */
    /* loaded from: classes3.dex */
    public interface ListEntry {
    }

    /* compiled from: DebugDeviceStorageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class ListEntryDirectory implements ListEntry {
        private final Directory directory;

        public ListEntryDirectory(Directory directory) {
            Intrinsics.checkNotNullParameter(directory, "directory");
            this.directory = directory;
        }

        public static /* synthetic */ ListEntryDirectory copy$default(ListEntryDirectory listEntryDirectory, Directory directory, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                directory = listEntryDirectory.directory;
            }
            return listEntryDirectory.copy(directory);
        }

        public final Directory component1() {
            return this.directory;
        }

        public final ListEntryDirectory copy(Directory directory) {
            Intrinsics.checkNotNullParameter(directory, "directory");
            return new ListEntryDirectory(directory);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ListEntryDirectory) && Intrinsics.areEqual(this.directory, ((ListEntryDirectory) obj).directory)) {
                return true;
            }
            return false;
        }

        public final Directory getDirectory() {
            return this.directory;
        }

        public int hashCode() {
            return this.directory.hashCode();
        }

        public String toString() {
            return "ListEntryDirectory(directory=" + this.directory + ')';
        }
    }

    public DebugDeviceStorageFragment() {
        Watch currentWatch = ProviderFactory.getWatch().getWatchManager().getCurrentWatch();
        Intrinsics.checkNotNull(currentWatch, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
        this.watch = (DisplayWatch) currentWatch;
        this.name = "DebugDeviceStorageFragment";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object deleteFile(FileDescriptor fileDescriptor, Continuation<? super Unit> continuation) {
        WatchIO io2 = this.watch.getIo();
        if (io2 instanceof WatchIODebug) {
            Object deleteFile = io2.deleteFile(fileDescriptor.getFullPath(), continuation);
            if (deleteFile == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return deleteFile;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deleteFileAt(int r5) {
        ListEntryFile listEntryFile;
        DebugDeviceStorageAdapter debugDeviceStorageAdapter = this.rvAdapter;
        if (debugDeviceStorageAdapter != null) {
            ListEntry listEntry = debugDeviceStorageAdapter.getEntries().get(r5);
            if (listEntry instanceof ListEntryFile) {
                listEntryFile = (ListEntryFile) listEntry;
            } else {
                listEntryFile = null;
            }
            if (listEntryFile == null) {
                return false;
            }
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugDeviceStorageFragment$deleteFileAt$1(listEntryFile, this, r5, null), 3);
            return true;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getContentString(WatchFile watchFile) {
        if (StringsKt__StringsJVMKt.equals(watchFile.getExtension(), "msg")) {
            return MsgPackKotlin.Companion.fromBytes(watchFile.getBytes()).toString();
        }
        if (StringsKt__StringsJVMKt.equals(watchFile.getExtension(), "bin")) {
            if (StringsKt__StringsKt.contains(watchFile.getDirectory(), Command.PICTURE, false)) {
                return "Image file";
            }
            return ByteUtils.toHex(watchFile.getBytes());
        }
        return new String(watchFile.getBytes(), Charsets.UTF_8);
    }

    private final void getItems(Directory directory, String str) {
        for (FileEntry fileEntry : directory.getEntries()) {
            if (fileEntry instanceof Directory) {
                Directory directory2 = (Directory) fileEntry;
                this.listEntries.add(new ListEntryDirectory(directory2));
                getItems(directory2, str + fileEntry.getName());
            } else if (fileEntry instanceof FileDescriptor) {
                this.listEntries.add(new ListEntryFile((FileDescriptor) fileEntry, false, null, null, false, 30, null));
            }
        }
    }

    public static /* synthetic */ void getItems$default(DebugDeviceStorageFragment debugDeviceStorageFragment, Directory directory, String str, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = "";
        }
        debugDeviceStorageFragment.getItems(directory, str);
    }

    @SuppressLint({"SetTextI18n"})
    private final void invalidateListEntries() {
        DebugDeviceStorageAdapter debugDeviceStorageAdapter = this.rvAdapter;
        if (debugDeviceStorageAdapter != null) {
            debugDeviceStorageAdapter.setListEntries(this.listEntries);
            if (this.listEntries.isEmpty()) {
                TextView textView = this.content;
                if (textView != null) {
                    textView.setVisibility(0);
                    RecyclerView recyclerView = this.rv;
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                        TextView textView2 = this.content;
                        if (textView2 != null) {
                            textView2.setText("No files found in flash or/and ram.\nReset watch to re-sync folders and data");
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("content");
                            throw null;
                        }
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("rv");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("content");
                throw null;
            }
            RecyclerView recyclerView2 = this.rv;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
                TextView textView3 = this.content;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("content");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateListRow(int r5) {
        ListEntryFile listEntryFile;
        boolean z;
        DebugDeviceStorageAdapter debugDeviceStorageAdapter = this.rvAdapter;
        if (debugDeviceStorageAdapter != null) {
            ListEntry listEntry = debugDeviceStorageAdapter.getEntries().get(r5);
            if (listEntry instanceof ListEntryFile) {
                listEntryFile = (ListEntryFile) listEntry;
            } else {
                listEntryFile = null;
            }
            if (listEntryFile == null) {
                return;
            }
            if (listEntryFile.getContent().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                DebugDeviceStorageAdapter debugDeviceStorageAdapter2 = this.rvAdapter;
                if (debugDeviceStorageAdapter2 != null) {
                    debugDeviceStorageAdapter2.notifyItemChanged(r5);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
                    throw null;
                }
            }
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugDeviceStorageFragment$invalidateListRow$1(this, r5, listEntryFile, null), 3);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateList(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$updateList$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$updateList$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$updateList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$updateList$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$updateList$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r1 = r0.L$1
            com.animaconnected.watch.device.files.Directory r1 = (com.animaconnected.watch.device.files.Directory) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment r0 = (com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L32
            goto L84
        L32:
            r8 = move-exception
            goto La2
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3d:
            java.lang.Object r2 = r0.L$1
            com.animaconnected.watch.device.files.WatchFileSystem r2 = (com.animaconnected.watch.device.files.WatchFileSystem) r2
            java.lang.Object r4 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment r4 = (com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L49
            goto L6e
        L49:
            r8 = move-exception
            r0 = r4
            goto La2
        L4c:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List<com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$ListEntry> r8 = r7.listEntries     // Catch: java.lang.Exception -> La0
            r8.clear()     // Catch: java.lang.Exception -> La0
            com.animaconnected.watch.DisplayWatch r8 = r7.watch     // Catch: java.lang.Exception -> La0
            com.animaconnected.watch.device.files.WatchFileSystem r2 = r8.getFs()     // Catch: java.lang.Exception -> La0
            if (r2 == 0) goto L98
            java.lang.String r8 = ""
            java.lang.String r5 = "ram"
            r0.L$0 = r7     // Catch: java.lang.Exception -> La0
            r0.L$1 = r2     // Catch: java.lang.Exception -> La0
            r0.label = r4     // Catch: java.lang.Exception -> La0
            java.lang.Object r8 = r2.getDirectoryRecursive(r8, r5, r0)     // Catch: java.lang.Exception -> La0
            if (r8 != r1) goto L6d
            return r1
        L6d:
            r4 = r7
        L6e:
            com.animaconnected.watch.device.files.Directory r8 = (com.animaconnected.watch.device.files.Directory) r8     // Catch: java.lang.Exception -> L49
            java.lang.String r5 = "flash"
            java.lang.String r6 = "ext"
            r0.L$0 = r4     // Catch: java.lang.Exception -> L49
            r0.L$1 = r8     // Catch: java.lang.Exception -> L49
            r0.label = r3     // Catch: java.lang.Exception -> L49
            java.lang.Object r0 = r2.getDirectoryRecursive(r5, r6, r0)     // Catch: java.lang.Exception -> L49
            if (r0 != r1) goto L81
            return r1
        L81:
            r1 = r8
            r8 = r0
            r0 = r4
        L84:
            com.animaconnected.watch.device.files.Directory r8 = (com.animaconnected.watch.device.files.Directory) r8     // Catch: java.lang.Exception -> L32
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Exception -> L32
            r0.getItems(r1, r2)     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = r8.getName()     // Catch: java.lang.Exception -> L32
            r0.getItems(r8, r1)     // Catch: java.lang.Exception -> L32
            r0.invalidateListEntries()     // Catch: java.lang.Exception -> L32
            goto Lad
        L98:
            java.lang.Exception r8 = new java.lang.Exception     // Catch: java.lang.Exception -> La0
            java.lang.String r0 = "No watch filesystem"
            r8.<init>(r0)     // Catch: java.lang.Exception -> La0
            throw r8     // Catch: java.lang.Exception -> La0
        La0:
            r8 = move-exception
            r0 = r7
        La2:
            android.widget.TextView r0 = r0.content
            if (r0 == 0) goto Lb0
            java.lang.String r8 = r8.toString()
            r0.setText(r8)
        Lad:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Lb0:
            java.lang.String r8 = "content"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = 0
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment.updateList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_debug_device_storage, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.format_flash);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        onClick(findViewById, new DebugDeviceStorageFragment$onCreateView$1$1(this, null));
        View findViewById2 = inflate.findViewById(R.id.run_gc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        onClick(findViewById2, new DebugDeviceStorageFragment$onCreateView$1$2(this, null));
        View findViewById3 = inflate.findViewById(R.id.device_storage_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.content = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.rv_debug_device_storage);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.rv = recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).mSupportsChangeAnimations = false;
        RecyclerView recyclerView2 = this.rv;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new DividerItemDecoration(requireContext()));
            DebugDeviceStorageAdapter debugDeviceStorageAdapter = new DebugDeviceStorageAdapter(new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$onCreateView$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int r2) {
                    DebugDeviceStorageFragment.this.invalidateListRow(r2);
                }
            }, new Function1<Integer, Boolean>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugDeviceStorageFragment$onCreateView$1$4
                {
                    super(1);
                }

                public final Boolean invoke(int r2) {
                    boolean deleteFileAt;
                    deleteFileAt = DebugDeviceStorageFragment.this.deleteFileAt(r2);
                    return Boolean.valueOf(deleteFileAt);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }
            });
            this.rvAdapter = debugDeviceStorageAdapter;
            RecyclerView recyclerView3 = this.rv;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(debugDeviceStorageAdapter);
                return inflate;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rv");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rv");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugDeviceStorageFragment$onViewCreated$1(this, null), 3);
    }

    /* compiled from: DebugDeviceStorageFragment.kt */
    /* loaded from: classes3.dex */
    public static final class ListEntryFile implements ListEntry {
        private Bitmap bitmap;
        private String content;
        private final FileDescriptor file;
        private boolean isExpanded;
        private boolean removed;

        public ListEntryFile(FileDescriptor file, boolean z, String content, Bitmap bitmap, boolean z2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(content, "content");
            this.file = file;
            this.isExpanded = z;
            this.content = content;
            this.bitmap = bitmap;
            this.removed = z2;
        }

        public static /* synthetic */ ListEntryFile copy$default(ListEntryFile listEntryFile, FileDescriptor fileDescriptor, boolean z, String str, Bitmap bitmap, boolean z2, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                fileDescriptor = listEntryFile.file;
            }
            if ((r9 & 2) != 0) {
                z = listEntryFile.isExpanded;
            }
            boolean z3 = z;
            if ((r9 & 4) != 0) {
                str = listEntryFile.content;
            }
            String str2 = str;
            if ((r9 & 8) != 0) {
                bitmap = listEntryFile.bitmap;
            }
            Bitmap bitmap2 = bitmap;
            if ((r9 & 16) != 0) {
                z2 = listEntryFile.removed;
            }
            return listEntryFile.copy(fileDescriptor, z3, str2, bitmap2, z2);
        }

        public final FileDescriptor component1() {
            return this.file;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final String component3() {
            return this.content;
        }

        public final Bitmap component4() {
            return this.bitmap;
        }

        public final boolean component5() {
            return this.removed;
        }

        public final ListEntryFile copy(FileDescriptor file, boolean z, String content, Bitmap bitmap, boolean z2) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(content, "content");
            return new ListEntryFile(file, z, content, bitmap, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListEntryFile)) {
                return false;
            }
            ListEntryFile listEntryFile = (ListEntryFile) obj;
            if (Intrinsics.areEqual(this.file, listEntryFile.file) && this.isExpanded == listEntryFile.isExpanded && Intrinsics.areEqual(this.content, listEntryFile.content) && Intrinsics.areEqual(this.bitmap, listEntryFile.bitmap) && this.removed == listEntryFile.removed) {
                return true;
            }
            return false;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final String getContent() {
            return this.content;
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final boolean getRemoved() {
            return this.removed;
        }

        public int hashCode() {
            int hashCode;
            int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.content, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isExpanded, this.file.hashCode() * 31, 31), 31);
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                hashCode = 0;
            } else {
                hashCode = bitmap.hashCode();
            }
            return Boolean.hashCode(this.removed) + ((m + hashCode) * 31);
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public final void setContent(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setExpanded(boolean z) {
            this.isExpanded = z;
        }

        public final void setRemoved(boolean z) {
            this.removed = z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ListEntryFile(file=");
            sb.append(this.file);
            sb.append(", isExpanded=");
            sb.append(this.isExpanded);
            sb.append(", content=");
            sb.append(this.content);
            sb.append(", bitmap=");
            sb.append(this.bitmap);
            sb.append(", removed=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.removed, ')');
        }

        public /* synthetic */ ListEntryFile(FileDescriptor fileDescriptor, boolean z, String str, Bitmap bitmap, boolean z2, int r13, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileDescriptor, (r13 & 2) != 0 ? false : z, (r13 & 4) != 0 ? "" : str, (r13 & 8) != 0 ? null : bitmap, (r13 & 16) != 0 ? false : z2);
        }
    }
}
