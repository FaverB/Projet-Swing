package ci.codeurs.service;

import java.util.List;

public interface IService<T, Pk> {

	public boolean ajouter(T t);
	public boolean suprimer(Pk pk);
	public boolean modifier(T t);
	public T lireUn(Pk pk);
	public List<T> lireTous();
	
}
