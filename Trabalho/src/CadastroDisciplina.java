import java.util.ArrayList;

public class CadastroDisciplina {
    private ArrayList<Disciplina> disciplinas;

    public CadastroDisciplina() {
        this.disciplinas = new ArrayList<>();
    }

    // cria a disciplina
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    // lista a disciplina
    public void listarDisciplinas() {
        System.out.println("Lista de Disciplinas:");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome() + " (Código: " + disciplina.getCodigo() + ")");
        }
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
