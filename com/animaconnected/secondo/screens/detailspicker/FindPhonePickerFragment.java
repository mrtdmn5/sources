package com.animaconnected.secondo.screens.detailspicker;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.animaconnected.secondo.behaviour.findphone.FindPhonePluginKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.interfaces.FindPhoneListener;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.types.FindPhone;
import com.animaconnected.watch.device.ButtonAction;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FindPhonePickerFragment.kt */
/* loaded from: classes3.dex */
public final class FindPhonePickerFragment extends BaseDetailsPickerFragment implements DetailsPickerAdapter.DetailsPickerAdapterButtonListener {
    private static final String FEATURE_PATH = "featurePath";
    private FindPhone behaviour;
    private final FindPhonePickerFragment$findPhoneListener$1 findPhoneListener = new FindPhoneListener() { // from class: com.animaconnected.secondo.screens.detailspicker.FindPhonePickerFragment$findPhoneListener$1
        @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneListener
        public void onFindPhoneStarted() {
            FindPhonePickerFragment.this.updateButton();
        }

        @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneListener
        public void onFindPhoneStopped() {
            FindPhonePickerFragment.this.updateButton();
        }
    };
    private List<SoundOption> soundOptions;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FindPhonePickerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FindPhonePickerFragment newInstance(String str) {
            FindPhonePickerFragment findPhonePickerFragment = new FindPhonePickerFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FindPhonePickerFragment.FEATURE_PATH, str);
            findPhonePickerFragment.setArguments(bundle);
            return findPhonePickerFragment;
        }

        private Companion() {
        }
    }

    /* compiled from: FindPhonePickerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class SoundOption implements PickerOption {
        private final String mDisplayText;
        private final Music music;

        public SoundOption(Music music, String mDisplayText) {
            Intrinsics.checkNotNullParameter(music, "music");
            Intrinsics.checkNotNullParameter(mDisplayText, "mDisplayText");
            this.music = music;
            this.mDisplayText = mDisplayText;
        }

        @Override // com.animaconnected.secondo.screens.detailspicker.PickerOption
        public String getDisplayText() {
            return this.mDisplayText;
        }

        public final Music getMusic() {
            return this.music;
        }

        @Override // com.animaconnected.secondo.screens.detailspicker.PickerOption
        public String getSubText() {
            return "";
        }
    }

    private final int findSelectedIndex() {
        boolean z;
        FindPhone findPhone = this.behaviour;
        if (findPhone != null) {
            Music userPreferredMusic = findPhone.getUserPreferredMusic();
            List<SoundOption> list = this.soundOptions;
            if (list != null) {
                Iterator<SoundOption> it = list.iterator();
                int r3 = 0;
                while (it.hasNext()) {
                    if (it.next().getMusic() == userPreferredMusic) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        r3++;
                    } else {
                        return r3;
                    }
                }
                return -1;
            }
            Intrinsics.throwUninitializedPropertyAccessException("soundOptions");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String str = this.title;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DetailBottomDialog.keyTitle);
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter.DetailsPickerAdapterButtonListener
    public void onButtonClicked() {
        FindPhone findPhone = this.behaviour;
        if (findPhone != null) {
            findPhone.execute(ButtonAction.Press);
            updateButton();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("behaviour");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(FEATURE_PATH);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.title = str;
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.DetailsPickerAdapter.DetailsPickerAdapterListener
    public void onListItemClicked(PickerOption pickerOption) {
        Intrinsics.checkNotNullParameter(pickerOption, "pickerOption");
        if (pickerOption instanceof SoundOption) {
            SoundOption soundOption = (SoundOption) pickerOption;
            Music music = soundOption.getMusic();
            FindPhone findPhone = this.behaviour;
            if (findPhone != null) {
                if (music != findPhone.getUserPreferredMusic()) {
                    FindPhone findPhone2 = this.behaviour;
                    if (findPhone2 != null) {
                        findPhone2.setUserPreferredMusic(soundOption.getMusic());
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                        throw null;
                    }
                }
                this.mAdapter.setSelectedIndex(findSelectedIndex());
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("behaviour");
            throw null;
        }
        throw new RuntimeException("Picker option needs to be a Sound option");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FindPhone findPhone = this.behaviour;
        if (findPhone != null) {
            if (findPhone.isPlaying()) {
                FindPhone findPhone2 = this.behaviour;
                if (findPhone2 != null) {
                    findPhone2.stopMusic();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                    throw null;
                }
            }
            FindPhone findPhone3 = this.behaviour;
            if (findPhone3 != null) {
                findPhone3.unregisterFindPhoneListener(this.findPhoneListener);
                super.onPause();
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("behaviour");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateButton();
        FindPhone findPhone = this.behaviour;
        if (findPhone != null) {
            findPhone.registerFindPhoneListener(this.findPhoneListener);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("behaviour");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.detailspicker.BaseDetailsPickerFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Behaviour behaviour = ProviderFactory.getWatch().getBehaviours().getBehaviour(FindPhone.TYPE);
        Intrinsics.checkNotNull(behaviour, "null cannot be cast to non-null type com.animaconnected.watch.behaviour.types.FindPhone");
        this.behaviour = (FindPhone) behaviour;
        ListBuilder listBuilder = new ListBuilder();
        listBuilder.add(Music.Discrete);
        listBuilder.add(Music.Normal);
        listBuilder.add(Music.Loud);
        listBuilder.add(Music.Upbeat);
        FindPhone findPhone = this.behaviour;
        SimpleItemAnimator simpleItemAnimator = null;
        if (findPhone != null) {
            if (findPhone.isChristmasPeriod()) {
                listBuilder.add(Music.Christmas);
            }
            ListBuilder build = CollectionsKt__CollectionsKt.build(listBuilder);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(build, 10));
            ListIterator listIterator = build.listIterator(0);
            while (true) {
                ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                if (!itr.hasNext()) {
                    break;
                }
                Music music = (Music) itr.next();
                String string = getString(FindPhonePluginKt.getResource(music));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new SoundOption(music, string));
            }
            this.soundOptions = arrayList;
            DetailsPickerAdapter detailsPickerAdapter = this.mAdapter;
            detailsPickerAdapter.setData(arrayList);
            detailsPickerAdapter.setDetailsPickerAdapterListener(this);
            detailsPickerAdapter.setSelectedIndex(findSelectedIndex());
            detailsPickerAdapter.setHeadline(view.getContext().getString(R.string.find_phone_sound));
            detailsPickerAdapter.setShowButton(true);
            detailsPickerAdapter.setButtonText(view.getContext().getString(R.string.find_phone_play_sound_button));
            detailsPickerAdapter.setDetailsPickerAdapterButtonListener(this);
            RecyclerView.ItemAnimator itemAnimator = this.mPickerOptions.getItemAnimator();
            if (itemAnimator instanceof SimpleItemAnimator) {
                simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
            }
            if (simpleItemAnimator != null) {
                simpleItemAnimator.mSupportsChangeAnimations = false;
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }

    public final void updateButton() {
        int r0;
        FindPhone findPhone = this.behaviour;
        String str = null;
        if (findPhone != null) {
            if (findPhone.isPlaying()) {
                r0 = R.string.find_phone_stop_sound_button;
            } else {
                r0 = R.string.find_phone_play_sound_button;
            }
            DetailsPickerAdapter detailsPickerAdapter = this.mAdapter;
            Context context = getContext();
            if (context != null) {
                str = context.getString(r0);
            }
            detailsPickerAdapter.setButtonText(str);
            this.mAdapter.refreshButton();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("behaviour");
        throw null;
    }
}
