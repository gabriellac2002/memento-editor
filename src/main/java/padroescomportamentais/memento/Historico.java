package padroescomportamentais.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class Historico {

    private final Deque<EstadoEditor> estados = new ArrayDeque<>();

    public void guardar(EstadoEditor estado) {
        estados.push(estado);
    }

    public EstadoEditor desfazer() {
        return estados.isEmpty() ? null : estados.pop();
    }

    public boolean isVazio() {
        return estados.isEmpty();
    }
}
