package padroes.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import padroes.observer.observadores.Observador;
import padroes.state.estados.Estado;

// EventManager | Base Publisher | Base Subject 
public class ServidorDelivery {
	
	private HashMap<String, List<Observador>> listeners = new HashMap<>();
	
	public ServidorDelivery(String[] eventos) {
        for (String evento : eventos) {
            this.listeners.put(evento, new ArrayList<>());
        }
    }
	
	public void subscribe(String evento, Observador novoListener) {
		List<Observador> interessados = listeners.get(evento);
		interessados.add(novoListener);
	}
	
	public void unsubscribe(String evento, Observador listener) {
		List<Observador> interessados = listeners.get(evento);
		interessados.remove(listener);
	}
	
	public void notify(String evento,Estado novoEstado) {
		List<Observador> interessados = listeners.get(evento);
        for (Observador listener : interessados) {
            listener.update(evento, novoEstado);
	    }
	}
	
}