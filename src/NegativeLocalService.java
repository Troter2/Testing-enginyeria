import data.Password;
import services.LocalService;

public class NegativeLocalService implements LocalService {
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        throw new InvalidAccountException();
    }
}
