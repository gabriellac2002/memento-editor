package padroescomportamentais.memento;

public class Editor {

    private String texto = "";

    public void escrever(String novoTexto) {
        texto += novoTexto;
    }

    public String getTexto() {
        return texto;
    }

    public EstadoEditor salvar() {
        return new EstadoEditor(texto);
    }

    public void restaurar(EstadoEditor estado) {
        this.texto = estado.getTexto();
    }
}
