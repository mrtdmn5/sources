package com.animaconnected.secondo.screens.notification.magicword;

import android.content.SharedPreferences;
import android.util.Log;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemConstants;
import com.animaconnected.secondo.screens.minionboarding.MiniOnboardingStorage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class MagicWordProvider {
    private static final String KEYWORDSMODEL = "keywords";
    private static final String PREFERENCES_NAME = "com.kronaby.watch.magicwordprovider";
    private static final String TAG = "MagicWordProvider";
    private static MagicWordProvider sInstance;
    private static final Type sKeyWordType = new TypeToken<ArrayList<KeyWord>>() { // from class: com.animaconnected.secondo.screens.notification.magicword.MagicWordProvider.1
    }.getType();
    private ArrayList<KeyWord> mKeyWords = null;
    private final Set<MagicWordProviderListener> mListeners = new CopyOnWriteArraySet();

    /* loaded from: classes3.dex */
    public interface MagicWordProviderListener {
        void onKeyWordAdded(int r1);

        void onKeyWordRemoved(int r1);
    }

    private MagicWordProvider() {
    }

    public static MagicWordProvider getInstance() {
        if (sInstance == null) {
            MagicWordProvider magicWordProvider = new MagicWordProvider();
            sInstance = magicWordProvider;
            magicWordProvider.getAllKeyWords();
        }
        return sInstance;
    }

    private SharedPreferences getSharedPreferences() {
        return KronabyApplication.getContext().getSharedPreferences(PREFERENCES_NAME, 0);
    }

    private void loadKeyWords() {
        String string;
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(KEYWORDSMODEL) && (string = sharedPreferences.getString(KEYWORDSMODEL, null)) != null) {
            this.mKeyWords = (ArrayList) new Gson().fromJson(string, sKeyWordType);
        }
        if (this.mKeyWords == null) {
            this.mKeyWords = new ArrayList<>();
        }
        Log.v(TAG, "loadKeyWords: " + this.mKeyWords);
    }

    private void notifyKeyWordAdded() {
        if (this.mKeyWords.size() == 1) {
            MiniOnboardingStorage.setConfigured(KronabyApplication.getContext(), true, NotificationItemConstants.getNotificationName(11));
        }
        Iterator<MagicWordProviderListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onKeyWordAdded(0);
        }
    }

    private void notifyKeyWordRemoved(int r4) {
        if (this.mKeyWords.size() == 0) {
            MiniOnboardingStorage.setConfigured(KronabyApplication.getContext(), false, NotificationItemConstants.getNotificationName(11));
        }
        Iterator<MagicWordProviderListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onKeyWordRemoved(r4);
        }
    }

    private void saveKeyWords() {
        if (this.mKeyWords != null) {
            getSharedPreferences().edit().putString(KEYWORDSMODEL, new Gson().toJson(this.mKeyWords)).apply();
        }
        Log.d(TAG, "saveKeyWords: " + this.mKeyWords);
    }

    public void addKeyWord(KeyWord keyWord) {
        Log.d(TAG, "addKeyWord() called with: keyword = [" + keyWord + "]");
        this.mKeyWords.add(0, keyWord);
        notifyKeyWordAdded();
        saveKeyWords();
    }

    public List<KeyWord> getAllKeyWords() {
        Log.v(TAG, "getAllKeyWords: " + this.mKeyWords);
        if (this.mKeyWords == null) {
            loadKeyWords();
        }
        return this.mKeyWords;
    }

    public void registerMagicWordProviderListener(MagicWordProviderListener magicWordProviderListener) {
        this.mListeners.add(magicWordProviderListener);
    }

    public void removeKeyWord(int r4) {
        this.mKeyWords.remove(r4);
        Log.d(TAG, "removeKeyWord: " + this.mKeyWords);
        notifyKeyWordRemoved(r4);
        saveKeyWords();
    }

    public void unregisterMagicWordProviderListener(MagicWordProviderListener magicWordProviderListener) {
        this.mListeners.remove(magicWordProviderListener);
    }
}
