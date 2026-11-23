package padroescomportamentais.memento;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        Historico historico = new Historico();

        editor.escrever("Ola");
        historico.guardar(editor.salvar());
        editor.escrever(", mundo");
        historico.guardar(editor.salvar());
        editor.escrever("!!!");

        System.out.println("Atual: " + editor.getTexto());
        editor.restaurar(historico.desfazer());
        System.out.println("Desfez 1: " + editor.getTexto());
        editor.restaurar(historico.desfazer());
        System.out.println("Desfez 2: " + editor.getTexto());
    }
}
