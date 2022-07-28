package padroes.observer.observadores;

import padroes.state.estados.Estado;

// EventListener | Subscriber (interessados)
// EventListener ja existe na java.util 11!
public interface Observador {
	public void update(String evento, Estado estado); // comum encontrar: update(Object o)
}
