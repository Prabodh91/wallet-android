package com.learningmachine.android.app.data.inject;

import android.content.Context;

import com.learningmachine.android.app.data.IssuerManager;
import com.learningmachine.android.app.data.bitcoin.BitcoinManager;
import com.learningmachine.android.app.data.store.ImageStore;
import com.learningmachine.android.app.data.store.IssuerStore;
import com.learningmachine.android.app.data.store.LMDatabaseHelper;
import com.learningmachine.android.app.data.webservice.IssuerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    BitcoinManager providesBitcoinManager(Context context, IssuerManager issuerManager) {
        return new BitcoinManager(context, issuerManager);
    }

    @Provides
    @Singleton
    LMDatabaseHelper provideLmDatabase(Context context) {
        return new LMDatabaseHelper(context);
    }

    @Provides
    @Singleton
    ImageStore providesImageStore(Context context) {
        return new ImageStore(context);
    }

    @Provides
    @Singleton
    IssuerStore providesIssuerStore(Context context, LMDatabaseHelper databaseHelper, ImageStore imageStore) {
        return new IssuerStore(context, databaseHelper, imageStore);
    }

    @Provides
    @Singleton
    IssuerManager providesIssuerManager(IssuerStore issuerStore, IssuerService issuerService) {
        return new IssuerManager(issuerStore, issuerService);
    }
}
