package interface_adapter.verify;

import use_case.verify.VerifyOutputBoundary;
import use_case.verify.VerifyOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class VerifyPresenter implements VerifyOutputBoundary {

    private final VerifyViewModel verifyViewModel;

    public VerifyPresenter(VerifyViewModel loggedInViewModel) {
        this.verifyViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(VerifyOutputData outputData) {
        // currently there isn't anything to change based on the output data,
        // since the output data only contains the username, which remains the same.
        // We still fire the property changed event, but just to let the view know that
        // it can alert the user that their password was changed successfully..
        verifyViewModel.firePropertyChanged("password");

    }

    @Override
    public void prepareFailView(String error) {
        // note: this use case currently can't fail
    }
}
