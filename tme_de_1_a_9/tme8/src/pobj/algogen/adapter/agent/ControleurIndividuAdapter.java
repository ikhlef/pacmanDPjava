package pobj.algogen.adapter.agent;

import agent.control.ControlFactory;
import agent.control.IControleur;
import pobj.algogen.AbstractIndividu;
import pobj.algogen.Individu;

public class ControleurIndividuAdapter extends AbstractIndividu implements Individu {
	private IControleur controleur;
	public ControleurIndividuAdapter(IControleur control){
		controleur=control;
	}
	public ControleurIndividuAdapter(int nbRules){
		controleur=ControlFactory.createControleur( nbRules);
	}
	public String toString(){
		String cont = ""+ getValeurPropre() + ", " + getFitness();
		return cont;
	}
	public IControleur getValeurPropre(){
		return controleur;
	}
	@Override
	public void muter() {
		getValeurPropre().muter(0.05);
	}
	@Override
	public Individu croiser(Individu autre) {
		return new ControleurIndividuAdapter(getValeurPropre().creeFils(((ControleurIndividuAdapter)autre).getValeurPropre(), 0.05));
	}
	@Override
	public ControleurIndividuAdapter clone() {	
		return new ControleurIndividuAdapter(controleur.clone());
	}
}
