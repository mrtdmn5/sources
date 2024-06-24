package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.databinding.FragmentDebugImagePreviewBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.image.pickers.CommonColorPalettePicker;
import com.animaconnected.watch.image.pickers.MedianCutPalettePicker;
import com.animaconnected.watch.image.pickers.PalettePicker;
import com.animaconnected.watch.image.pickers.SimpleGrayscalePalettePicker;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugImagePreview.kt */
/* loaded from: classes3.dex */
public final class DebugImagePreview extends BaseFragment {
    private FragmentDebugImagePreviewBinding _binding;
    private Mitmap mitmap;
    private final String name;
    private Pair<String, Bitmap> selected;
    private final DisplayWatch watch;
    private final WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DebugImagePreview.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DebugImagePreview newInstance() {
            return new DebugImagePreview();
        }

        private Companion() {
        }
    }

    /* compiled from: DebugImagePreview.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<FormatType> entries$0 = EnumEntriesKt.enumEntries(FormatType.values());
    }

    /* compiled from: DebugImagePreview.kt */
    /* loaded from: classes3.dex */
    public static final class Palette extends Enum<Palette> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Palette[] $VALUES;
        private final PalettePicker palettePicker;
        public static final Palette MedianCut = new Palette("MedianCut", 0, MedianCutPalettePicker.INSTANCE);
        public static final Palette SimpleGrayscale = new Palette("SimpleGrayscale", 1, SimpleGrayscalePalettePicker.INSTANCE);
        public static final Palette CommonColor = new Palette("CommonColor", 2, CommonColorPalettePicker.INSTANCE);

        private static final /* synthetic */ Palette[] $values() {
            return new Palette[]{MedianCut, SimpleGrayscale, CommonColor};
        }

        static {
            Palette[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Palette(String str, int r2, PalettePicker palettePicker) {
            super(str, r2);
            this.palettePicker = palettePicker;
        }

        public static EnumEntries<Palette> getEntries() {
            return $ENTRIES;
        }

        public static Palette valueOf(String str) {
            return (Palette) Enum.valueOf(Palette.class, str);
        }

        public static Palette[] values() {
            return (Palette[]) $VALUES.clone();
        }

        public final PalettePicker getPalettePicker() {
            return this.palettePicker;
        }
    }

    public DebugImagePreview() {
        Watch watch = ProviderFactory.getWatch().getWatch();
        Intrinsics.checkNotNull(watch, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
        this.watch = (DisplayWatch) watch;
        this.name = "Image preview";
    }

    public final FragmentDebugImagePreviewBinding getBinding() {
        FragmentDebugImagePreviewBinding fragmentDebugImagePreviewBinding = this._binding;
        Intrinsics.checkNotNull(fragmentDebugImagePreviewBinding);
        return fragmentDebugImagePreviewBinding;
    }

    public final void importImage(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugImagePreview$importImage$1$1(this, data, null), 3);
        }
    }

    public static final void onCreateView$lambda$7$lambda$0(DebugImagePreview this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectFile();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshList() {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        GridLayout debugImageList = getBinding().debugImageList;
        Intrinsics.checkNotNullExpressionValue(debugImageList, "debugImageList");
        debugImageList.removeAllViewsInLayout();
        this.selected = null;
        Iterator<T> it = Storage.INSTANCE.getBitmaps(context).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            final String str = (String) pair.first;
            final Bitmap bitmap = (Bitmap) pair.second;
            View inflate = getLayoutInflater().inflate(R.layout.fragment_debug_image_preview_item, (ViewGroup) debugImageList, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) inflate;
            debugImageList.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DebugImagePreview.refreshList$lambda$13$lambda$11(DebugImagePreview.this, str, bitmap, view);
                }
            });
            imageView.setImageBitmap(bitmap);
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean refreshList$lambda$13$lambda$12;
                    refreshList$lambda$13$lambda$12 = DebugImagePreview.refreshList$lambda$13$lambda$12(str, context, this, view);
                    return refreshList$lambda$13$lambda$12;
                }
            });
        }
    }

    public static final void refreshList$lambda$13$lambda$11(DebugImagePreview this$0, String name, Bitmap bitmap, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        this$0.setSelectedBitmap(name, bitmap);
    }

    public static final boolean refreshList$lambda$13$lambda$12(String name, Context context, DebugImagePreview this$0, View view) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean deleteFile = Storage.INSTANCE.deleteFile(name, context);
        Toast.makeText(context, "Deleted: " + deleteFile, 0).show();
        this$0.refreshList();
        return deleteFile;
    }

    private final void selectFile() {
        LogKt.warn$default((Object) this, "Select file ", (String) null, (Throwable) null, false, 14, (Object) null);
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        getActivityLauncher().launch(intent, new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$selectFile$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult activityResult) {
                Intrinsics.checkNotNullParameter(activityResult, "activityResult");
                Intent intent2 = activityResult.mData;
                if (intent2 != null) {
                    DebugImagePreview.this.importImage(intent2);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendImage(android.view.View r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$sendImage$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$sendImage$1 r0 = (com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$sendImage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$sendImage$1 r0 = new com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$sendImage$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r10 = r0.L$1
            android.view.View r10 = (android.view.View) r10
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.DebugImagePreview r0 = (com.animaconnected.secondo.screens.debugsettings.DebugImagePreview) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto Ld4
        L30:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef
            r11.<init>()
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            com.animaconnected.secondo.databinding.FragmentDebugImagePreviewBinding r4 = r9.getBinding()     // Catch: java.lang.NumberFormatException -> L6d
            android.widget.EditText r4 = r4.debugImageX     // Catch: java.lang.NumberFormatException -> L6d
            android.text.Editable r4 = r4.getText()     // Catch: java.lang.NumberFormatException -> L6d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.NumberFormatException -> L6d
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L6d
            r11.element = r4     // Catch: java.lang.NumberFormatException -> L6d
            com.animaconnected.secondo.databinding.FragmentDebugImagePreviewBinding r4 = r9.getBinding()     // Catch: java.lang.NumberFormatException -> L6d
            android.widget.EditText r4 = r4.debugImageY     // Catch: java.lang.NumberFormatException -> L6d
            android.text.Editable r4 = r4.getText()     // Catch: java.lang.NumberFormatException -> L6d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.NumberFormatException -> L6d
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L6d
            r2.element = r4     // Catch: java.lang.NumberFormatException -> L6d
        L6d:
            com.animaconnected.watch.image.Mitmap r4 = r9.mitmap
            if (r4 != 0) goto L74
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L74:
            android.content.Context r5 = r9.getContext()
            java.lang.String r6 = "Uploading"
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)
            r5.show()
            r5 = 0
            r10.setEnabled(r5)
            com.animaconnected.watch.WatchManager r5 = r9.watchManager
            com.animaconnected.watch.behaviour.Behaviours r5 = r5.getBehaviours()
            java.util.List r5 = r5.getAll()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L9a:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto Lac
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.animaconnected.watch.display.ImagePreviewWatchApp
            if (r8 == 0) goto L9a
            r6.add(r7)
            goto L9a
        Lac:
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r6)
            com.animaconnected.watch.display.ImagePreviewWatchApp r5 = (com.animaconnected.watch.display.ImagePreviewWatchApp) r5
            if (r5 != 0) goto Lb7
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        Lb7:
            r5.setMitmap(r4)
            int r11 = r11.element
            r5.setX(r11)
            int r11 = r2.element
            r5.setY(r11)
            com.animaconnected.watch.DisplayWatch r11 = r9.watch
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r11 = r11.updateApp(r5, r0)
            if (r11 != r1) goto Ld3
            return r1
        Ld3:
            r0 = r9
        Ld4:
            android.content.Context r11 = r0.getContext()
            java.lang.String r0 = "Done"
            android.widget.Toast r11 = android.widget.Toast.makeText(r11, r0, r3)
            r11.show()
            r10.setEnabled(r3)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview.sendImage(android.view.View, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void setSelectedBitmap(String str, Bitmap bitmap) {
        this.selected = new Pair<>(str, bitmap);
        updatePreview();
    }

    public final void updatePreview() {
        ImageView selectedImage = getBinding().selectedImage;
        Intrinsics.checkNotNullExpressionValue(selectedImage, "selectedImage");
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugImagePreview$updatePreview$1(this, selectedImage, this.selected, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentDebugImagePreviewBinding inflate = FragmentDebugImagePreviewBinding.inflate(inflater, viewGroup, false);
        this._binding = inflate;
        inflate.debugImageImportFile.setOnClickListener(new DebugImagePreview$$ExternalSyntheticLambda2(this, 0));
        refreshList();
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$onCreateView$1$onSelected$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int r3, long j) {
                DebugImagePreview.this.updatePreview();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                DebugImagePreview.this.updatePreview();
            }
        };
        Spinner spinner = inflate.formatType;
        Context context = spinner.getContext();
        EnumEntries<FormatType> enumEntries = EntriesMappings.entries$0;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(enumEntries, 10));
        Iterator<E> it = enumEntries.iterator();
        while (it.hasNext()) {
            arrayList.add(((FormatType) it.next()).toString());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.item_spinner_settings, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.item_spinner_drop_down_settings);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        Spinner spinner2 = inflate.palette;
        Context context2 = spinner2.getContext();
        EnumEntries<Palette> entries = Palette.getEntries();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
        Iterator<E> it2 = entries.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Palette) it2.next()).toString());
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(context2, R.layout.item_spinner_settings, arrayList2);
        arrayAdapter2.setDropDownViewResource(R.layout.item_spinner_drop_down_settings);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner2.setOnItemSelectedListener(onItemSelectedListener);
        Button upload = inflate.upload;
        Intrinsics.checkNotNullExpressionValue(upload, "upload");
        onClick(upload, new DebugImagePreview$onCreateView$1$4(this, null));
        updatePreview();
        ScrollView root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
