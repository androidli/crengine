package org.coolreader.crengine;

import org.coolreader.CoolReader;

import com.onyx.android.sdk.ui.dialog.DialogSearchView.IHandler;

public class SearchMenuHandler implements IHandler {
	
	private CoolReader mCoolReader = null;
	private String mSearchText = null;
	public SearchMenuHandler(CoolReader coolReader , String searchText)
    {
		mCoolReader = coolReader;
		mSearchText = searchText;
    }
	
	@Override
	public void searchForward() {
		mCoolReader.getReaderView().findNext(mSearchText , false, true);
	}

	@Override
	public void searchBackward() {
		mCoolReader.getReaderView().findNext(mSearchText , true, true);
	}

	@Override
	public void dismissdialog() {
		mCoolReader.getReaderView().clearSelection();
		mCoolReader.mDialogSearchView.dismiss();
	}

	@Override
	public void showSearchAll() {
		
	}

}
