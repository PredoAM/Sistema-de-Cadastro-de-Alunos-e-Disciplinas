import java.util.ArrayList;

public class CadastroAluno {
    private ArrayList<Aluno> alunos;

    public CadastroAluno() {
        this.alunos = new ArrayList<>();
    }

    // adiciona um aluno
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // lista os alunos
    public void listarAlunos() {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ") " + " Email: " + aluno.getEmail());
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
