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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


//    public static void createUser() {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter user first name: ");
//        String firstName = scanner.next();
//
//        System.out.println("Enter user last name: ");
//        String lastName = scanner.next();
//
//
//        boolean exists = false;
//
//        for (User user : userList) {
//            if (user.getName().equals(firstName) && user.getPassword().equals(lastName) && user.getIsAdmin()) {
//                exists = true;
//                break;
//            }
//        }
//        if (exists) {
//            System.out.println("An user with this firstname, lastname and pin already exists");
//        } else {
//            User user = new User(firstName, lastName, false);
//            userList.add(user);
//        }
//
//        System.out.println("1- Enter an user");
//        System.out.println("2- Print user list");
//        System.out.println("3- Back to menu");
//        System.out.println("Enter a choice");
//        int choice = scanner.nextInt();
//        if (choice == 1) {
//            createUser();
//        } else if (choice == 2){
//            for (User user : userList) {
//                user.showContent();
//            }
//        }else {
//            Menu.principalMenu();
//        }
//    }



        @Override
        public void showContent () {
            System.out.println( "First name: " + this.userName + "\n" + "Last name: " + this.password + " \n" + "Pin: " + this.isAdmin +
                    "\n" + "-----------------------------------------------");
        }

//        public String showUserName () {
//            return "First name: " + this.name + "\n" + "Last name: " + this.password + " \n" + "Pin: " + this.isAdmin +
//                    "\n" + "-----------------------------------------------";
//        }
    }


