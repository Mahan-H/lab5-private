package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.verify.VerifyController;
import interface_adapter.verify.VerifyState;
import interface_adapter.verify.VerifyViewModel;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class VerifyView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final VerifyViewModel verifyViewModel;
    private final JLabel verifyErrorField = new JLabel();
    private VerifyController verifyController;
    private LogoutController logoutController;

    private final JLabel username;

    private final JButton logOut;

    private final JTextField codeInputField = new JTextField(15);
    private final JButton verifyButton;

    public VerifyView(VerifyViewModel verifyViewModel) {
        this.verifyViewModel = verifyViewModel;
        this.verifyViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Verify Screen");
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Code"), codeInputField);

        final JLabel codeInfo = new JLabel("Sent Code to: ");
        username = new JLabel();

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        verifyButton = new JButton(" Verify Code");
        buttons.add(verifyButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        codeInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final VerifyState currentState = verifyViewModel.getState();
                currentState.setPassword(codeInputField.getText());
                verifyViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        verifyButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(verifyButton)) {
                        final VerifyState currentState = verifyViewModel.getState();

                        this.verifyController.execute(
                                currentState.getUsername(),
                                currentState.getPassword()
                        );
                    }
                }
        );

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        final VerifyState currentState = verifyViewModel.getState();
                        this.logoutController.execute(currentState.getUsername());
                    }
                }
        );

        this.add(title);
        this.add(codeInfo);
        this.add(username);

        this.add(passwordInfo);
        this.add(verifyErrorField);
        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final VerifyState state = (VerifyState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final VerifyState state = (VerifyState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setVerifyController(VerifyController verifyController) {
        this.verifyController = verifyController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
