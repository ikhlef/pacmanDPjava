package pobj.obs;

public interface ISimpleObservable {
	public void addOvserver(ISimpleObserver o);
	public void deleteObserver(ISimpleObserver o);
	public void notifyObserver();
}
