import java.io.*;
import java.util.ArrayList;

public class Arquivos {

    // salvar alunos (CSV)
    public void salvarAlunos(ArrayList<Aluno> alunos, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("Nome,Matrícula,Email"); // abrir com cabecalho
            writer.newLine();

            for (Aluno aluno : alunos) {
                writer.write(aluno.getNome() + "," + aluno.getMatricula() + "," + aluno.getEmail());
                writer.newLine();
            }
            System.out.println("Alunos salvos em arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    // carregar alunos (CSV)
    public ArrayList<Aluno> carregarAlunos(String caminhoArquivo) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean isFirstLine = true; //nao printar a primeira linha
            while ((linha = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // dividir as linhas
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    Aluno aluno = new Aluno(partes[0], partes[1], partes[2]);
                    alunos.add(aluno);
                }
            }
            System.out.println("Alunos carregados de arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar alunos: " + e.getMessage());
        }
        return alunos;
    }

    // salvar disciplinas (CSV)
    public void salvarDisciplinas(ArrayList<Disciplina> disciplinas, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("Nome,Código"); // cabecalho materia
            writer.newLine();

            for (Disciplina disciplina : disciplinas) {
                writer.write(disciplina.getNome() + "," + disciplina.getCodigo());
                writer.newLine();
            }
            System.out.println("Disciplinas salvas em arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }

    // carregar materias
    public ArrayList<Disciplina> carregarDisciplinas(String caminhoArquivo) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean isFirstLine = true; // nao printar a primeira linha
            while ((linha = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // divide
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    Disciplina disciplina = new Disciplina(partes[0], partes[1]);
                    disciplinas.add(disciplina);
                }
            }
            System.out.println("Disciplinas carregadas de arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
        return disciplinas;
    }
}
