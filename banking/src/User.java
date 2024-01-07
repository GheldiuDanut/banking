import java.util.ArrayList;
import java.util.List;

public class User implements ShowContent {

    private String userName;

    private String password;

    private boolean isAdmin;
    public static  List<Account> accountsList = new ArrayList<>();

    public User(String userName, String password, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    public static List<Account> getAccountsList() {
        return accountsList;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

        @Override
        public String  showContent () {
            return  "First name: " + this.userName + "\n" + "Last name: " + this.password + " \n" + "Pin: " + this.isAdmin +
                    "\n" + "-----------------------------------------------";
        }

    }


