package pobj.obs;
import java.util.ArrayList;
import java.util.List;

public class SimpleObservable implements ISimpleObservable {
	private List<ISimpleObserver> obs = new ArrayList<ISimpleObserver>();
	@Override
	public void addOvserver(ISimpleObserver o) {
		obs.add(o);
	}

	@Override
	public void deleteObserver(ISimpleObserver o) {
		obs.remove(o);
	}

	@Override
	public void notifyObserver() {
	for(ISimpleObserver o : obs)
		o.update();
	}
}
