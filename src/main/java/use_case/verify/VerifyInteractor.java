package use_case.verify;

import entity.User;
import entity.UserFactory;

/**
 * The Change Password Interactor.
 */
public class VerifyInteractor implements VerifyInputBoundary {
    private final VerifyUserDataAccessInterface userDataAccessObject;
    private final VerifyOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public VerifyInteractor(VerifyUserDataAccessInterface verifyDataAccessInterface,
                            VerifyOutputBoundary verifyOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = verifyDataAccessInterface;
        this.userPresenter = verifyOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(VerifyInputData verifyInputData) {
        final User user = userFactory.create(verifyInputData.getUsername(),
                                             verifyInputData.getPassword());
        userDataAccessObject.code(user);

        final VerifyOutputData verifyOutputData = new VerifyOutputData(user.getName(),
                                                                                  false);
        userPresenter.prepareSuccessView(verifyOutputData);
    }
}
