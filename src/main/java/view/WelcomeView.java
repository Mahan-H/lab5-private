package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.welcome.WelcomeController;
import interface_adapter.welcome.WelcomeState;
import interface_adapter.welcome.WelcomeViewModel;

/**
 * The View for the Signup Use Case.
 */
public class WelcomeView extends JPanel implements ActionListener {
    private final String viewName = "welcome";

    private final WelcomeViewModel welcomeupViewModel;
    private WelcomeController welcomeController;

    private final JButton toLogin;
    private final JButton createAccount;

    public WelcomeView(WelcomeViewModel welcomeupViewModel) {
        this.welcomeupViewModel = welcomeupViewModel;

        final JLabel title = new JLabel(WelcomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel slogan = new JLabel(WelcomeViewModel.SLOGAN_LABEL);
        slogan.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        toLogin = new JButton(welcomeupViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(toLogin);
        createAccount = new JButton(welcomeupViewModel.CREATE_ACCOUNT_BUTTON_LABEL);
        buttons.add(createAccount);

        toLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        welcomeController.switchToLoginView();
                    }
                }
        );

//        createAccount.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        welcomeController.switchToSignUpView();
//                    }
//                }
//        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(slogan);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }

    public void setWelcomeController(WelcomeController controller) {
        this.welcomeController = controller;
    }
}
