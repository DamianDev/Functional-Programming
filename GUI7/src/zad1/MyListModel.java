package zad1;

import javax.swing.AbstractListModel;

public class MyListModel extends AbstractListModel {

	CelciusCalculator cc = new CelciusCalculator();
	
	@Override
	public Object getElementAt(int i) {
		return cc.getResult(i-70);
	}

	@Override
	public int getSize() {
		return 131;
	}

}
