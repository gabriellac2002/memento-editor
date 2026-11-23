package padroescomportamentais.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditorTest {

    @Test
    void deveRestaurarEstadoSalvo() {
        Editor editor = new Editor();
        editor.escrever("Ola");
        EstadoEditor estado = editor.salvar();
        editor.escrever(" mundo");
        editor.restaurar(estado);
        assertEquals("Ola", editor.getTexto());
    }

    @Test
    void estadoSalvoNaoDeveMudarAposNovasEdicoes() {
        Editor editor = new Editor();
        editor.escrever("A");
        EstadoEditor estado = editor.salvar();
        editor.escrever("B");
        editor.escrever("C");
        assertEquals("A", estado.getTexto());
    }

    @Test
    void historicoDeveDesfazerEmOrdemInversa() {
        Editor editor = new Editor();
        Historico historico = new Historico();
        editor.escrever("1");
        historico.guardar(editor.salvar());
        editor.escrever("2");
        historico.guardar(editor.salvar());
        editor.escrever("3");

        editor.restaurar(historico.desfazer());
        assertEquals("12", editor.getTexto());
        editor.restaurar(historico.desfazer());
        assertEquals("1", editor.getTexto());
        assertTrue(historico.isVazio());
    }

    @Test
    void historicoVazioDeveRetornarNulo() {
        assertNull(new Historico().desfazer());
    }
}
