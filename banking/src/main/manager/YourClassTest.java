//package main.manager;
//
//
//import org.junit.Rule;
//import org.junit.Test;
//import uk.org.webcompere.systemstubs.SystemStubs;
//
//import java.io.ByteArrayInputStream;
//import java.util.Scanner;
//
//import static org.junit.Assert.assertEquals;
//import static uk.org.webcompere.systemstubs.SystemStubs.withTextFromSystemIn;
//
//public class YourClassTest {
//    public BankManager bankManager;
//
//    public static final String NAME = "Name: ";
//
//    public static String readName() {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        return NAME.concat(input);
//    }
//
//    void provideInput(String data) {
//        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
//        System.setIn(testIn);
//    }
//
//
//    @Test
//    void givenName_whenReadFromInput_thenReturnCorrectResult() {
//        provideInput("Baeldung");
//        String input = Application.readName();
//        assertEquals(NAME.concat("Baeldung"), input);
//    }
//
//    @Rule
//    public final TextFromStandardInputStream systemIn = emptyStandardInputStream();
//
//    @Test
//    public void givenName_whenReadWithSystemRules_thenReturnCorrectResult() {
//        systemIn.provideLines("Baeldung");
//        assertEquals(NAME.concat("Baeldung"), Application.readName());
//    }
//
//    @Test
//    void givenName_whenReadWithSystemLambda_thenReturnCorrectResult() throws Exception {
//        withTextFromSystemIn("Baeldung")
//                .execute(() -> assertEquals(NAME.concat("Baeldung"), Application.readName()));
//    }
//    @Test
//    void givenName_whenReadWithSystemLambda_thenReturnCorrectResult() throws Exception {
//        withTextFromSystemIn("Baeldung")
//                .execute(() -> assertEquals(NAME.concat("Baeldung"), Application.readName()));
//    }
//    @Rule
//    public SystemInRule systemInRule = new SystemInRule("Baeldung");
//
//    @Test
//    public void givenName_whenReadWithSystemStubs_thenReturnCorrectResult() {
//        assertThat(Application.readName()).isEqualTo(NAME.concat("Baeldung"));
//    }
//    @Test
//    void givenName_whenReadWithSystemStubs_thenReturnCorrectResult() throws Exception {
//        SystemStubs.withTextFromSystemIn("Baeldung")
//                .execute(() -> {
//                    assertThat(Application.readName())
//                            .isEqualTo(NAME.concat("Baeldung"));
//                });
//    }
//
//}
