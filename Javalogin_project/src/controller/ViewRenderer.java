package controller;

import view.IView;

public class ViewRenderer {
	private IView view = null;

	public void changeView(IView viewState) {
		this.view = viewState;
	}

	public void renderView() {
		this.view.execute();
	}


}
