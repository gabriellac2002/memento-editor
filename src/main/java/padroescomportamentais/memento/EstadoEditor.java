package padroescomportamentais.memento;

public final class EstadoEditor {

    private final String texto;

    EstadoEditor(String texto) {
        this.texto = texto;
    }

    String getTexto() {
        return texto;
    }
}
