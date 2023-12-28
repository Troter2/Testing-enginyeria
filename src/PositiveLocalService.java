import data.Password;
import services.LocalService;

public class PositiveLocalService implements LocalService {
    @Override
    public void verifyAccount(String login, Password pssw) throws InvalidAccountException {
        return;
    }
}
