import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class JanelaCadastro implements Persistente{
    private CadastroAluno cadastroAluno = new CadastroAluno();
    private CadastroDisciplina cadastroDisciplina = new CadastroDisciplina();
    private Arquivos arquivos = new Arquivos();

    public JanelaCadastro() {
        JFrame janela = new JFrame("Sistema de Cadastro");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 300);
        janela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        janela.add(painel);
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JButton botaoCadastrarAluno = new JButton("Cadastrar Aluno");
        JButton botaoCadastrarDisciplina = new JButton("Cadastrar Disciplina");
        JButton botaoListarAlunos = new JButton("Listar Alunos");
        JButton botaoListarDisciplinas = new JButton("Listar Disciplinas");
        JButton botaoSalvar = new JButton("Salvar Dados");
        JButton botaoCarregar = new JButton("Carregar Dados");

        botaoCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Aluno:");
                String matricula = JOptionPane.showInputDialog("Matrícula:");
                String email = JOptionPane.showInputDialog("Email:");

                if (!nome.matches("[a-z]+")){
                    JOptionPane.showMessageDialog(janela, "Erro: O nome deve conter apenas letras minúsculas.", "Erro de Nome", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!matricula.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(janela, "Erro: A matrícula deve conter apenas números.", "Erro de Matrícula", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!email.contains("@") || !email.contains(".com")) {
                    JOptionPane.showMessageDialog(janela, "Erro: Email inválido. Certifique-se de incluir '@' e '.com'.", "Erro de Email", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Aluno aluno = new Aluno(nome, matricula, email);
                cadastroAluno.adicionarAluno(aluno);
                JOptionPane.showMessageDialog(janela, "Aluno cadastrado com sucesso!");
            }
        });

        botaoCadastrarDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome da Disciplina:");
                String codigo = JOptionPane.showInputDialog("Código:");
                Disciplina disciplina = new Disciplina(nome, codigo);
                cadastroDisciplina.adicionarDisciplina(disciplina);
                JOptionPane.showMessageDialog(janela, "Disciplina cadastrada com sucesso!");
            }
        });

        botaoListarAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroAluno.listarAlunos();
            }
        });

        botaoListarDisciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroDisciplina.listarDisciplinas();
            }
        });

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arquivos.salvarAlunos(cadastroAluno.getAlunos(), "alunos.dat");
                JOptionPane.showMessageDialog(janela, "Dados salvos com sucesso!");
            }
        });

        botaoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroAluno.getAlunos().addAll(arquivos.carregarAlunos("alunos.dat"));
                JOptionPane.showMessageDialog(janela, "Dados carregados com sucesso!");
            }
        });

        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoCadastrarAluno);
        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoCadastrarDisciplina);
        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoListarAlunos);
        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoListarDisciplinas);
        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoSalvar);
        painel.add(Box.createRigidArea(new Dimension(170, 10)));
        painel.add(botaoCarregar);

        janela.setVisible(true);
    }
}