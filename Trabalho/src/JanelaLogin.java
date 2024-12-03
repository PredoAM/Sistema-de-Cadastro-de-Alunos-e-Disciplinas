import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaLogin {
    public static void main(String[] args) {
        // janela de LOGIN
        JFrame janela = new JFrame("Login");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 150);
        janela.setLocationRelativeTo(null);

        // Jpanel
        JPanel painelLogin = new JPanel();

        // cria os componentes do painel
        JLabel labelLogin = new JLabel("Login: ");
        JTextField campoLogin = new JTextField(18);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(18);
        JLabel labelInfo = new JLabel("O Login deve ser seu nome");

        JButton botaoLogin = new JButton("Entrar");
        
        // enter funcionar
        janela.getRootPane().setDefaultButton(botaoLogin);

        // organizar
        painelLogin.add(labelLogin);
        painelLogin.add(campoLogin);
        painelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLogin.add(labelSenha);
        painelLogin.add(campoSenha);
        painelLogin.add(Box.createRigidArea(new Dimension(48, 10)));
        painelLogin.add(botaoLogin);
        painelLogin.add(Box.createRigidArea(new Dimension(48, 0)));
        painelLogin.add(labelInfo);

        janela.add(painelLogin, BorderLayout.CENTER);

        // botao
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());

                // verifica o login e senha
                if (login.equals("pedro") && senha.equals("12345")) {
                    JOptionPane.showMessageDialog(janela, "Login bem-sucedido!");
                    janela.dispose();  // fechar a janela se tiver certo

                    // return
                    new JanelaCadastro() {
                        @Override
                        public void salvar() {

                        }

                        @Override
                        public void carregar() {

                        }
                    };
                } else {
                    JOptionPane.showMessageDialog(janela, "Login ou senha inválidos!",
                            "Erro de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        janela.setVisible(true);
    }
}
