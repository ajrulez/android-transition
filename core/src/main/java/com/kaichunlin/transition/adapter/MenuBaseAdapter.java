package com.kaichunlin.transition.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;

/**
 * Adds support for {@link android.view.MenuItem} transition
 * <p>
 * Created by Kai-Chun Lin on 2015/5/11.
 */
public abstract class MenuBaseAdapter extends BaseAdapter implements IMenuOptionHandler {
    IMenuOptionHandler mMenuHandler;

    protected abstract IMenuOptionHandler createMenuHandler();

    @Override
    public void removeAllTransitions() {
        super.removeAllTransitions();
        createMenuHandlerIfNecessary();
        mMenuHandler.clearOptions();
    }

    protected IMenuOptionHandler getMenuOptionHandler() {
        return mMenuHandler;
    }

    private void createMenuHandlerIfNecessary() {
        if (mMenuHandler == null) {
            mMenuHandler = createMenuHandler();
        }
    }

    @Override
    public AdapterState getAdapterState() {
        return mMenuHandler.getAdapterState();
    }

    @Override
    public boolean isOpened(@NonNull Activity activity) {
        return mMenuHandler.isOpened(activity);
    }

    public void onCreateOptionsMenu(@NonNull Activity activity, @NonNull Menu menu) {
        createMenuHandlerIfNecessary();
        mMenuHandler.onCreateOptionsMenu(activity, menu);
    }

    public void onCreateOptionsMenu(@NonNull Activity activity, @NonNull Menu menu, AdapterState adapterState) {
        createMenuHandlerIfNecessary();
        mMenuHandler.onCreateOptionsMenu(activity, menu, adapterState);
    }

    @Override
    public void setupOption(@NonNull Activity activity, MenuOptionConfiguration openConfig) {
        createMenuHandlerIfNecessary();
        mMenuHandler.setupOption(activity, openConfig);
    }

    @Override
    public void setupOpenOption(@NonNull Activity activity, MenuOptionConfiguration openConfig) {
        createMenuHandlerIfNecessary();
        mMenuHandler.setupOpenOption(activity, openConfig);
    }

    @Override
    public void setupCloseOption(@NonNull Activity activity, MenuOptionConfiguration closeConfig) {
        createMenuHandlerIfNecessary();
        mMenuHandler.setupCloseOption(activity, closeConfig);
    }

    @Override
    public void setupOptions(@NonNull Activity activity, MenuOptionConfiguration openConfig, MenuOptionConfiguration closeConfig) {
        createMenuHandlerIfNecessary();
        mMenuHandler.setupOptions(activity, openConfig, closeConfig);
    }

    @Override
    public void clearOptions() {
        mMenuHandler.clearOptions();
    }

    @Override
    public MenuOptionConfiguration getOpenConfig() {
        return mMenuHandler.getOpenConfig();
    }

    @Override
    public MenuOptionConfiguration getCloseConfig() {
        return mMenuHandler.getCloseConfig();
    }
}
