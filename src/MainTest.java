import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private List<BankAccount> accounts;

    @BeforeEach
    void setUp() {
        accounts = List.of(
                new BankAccount(new Person("Jack", "Vorobey", "vorobey@mail.com"), "DE10000001", 10500),
                new BankAccount(new Person("John", "Smith", "smith@mail.com"), "DE10000002", 500),
                new BankAccount(new Person("Nick", "White", "whote@mail.com"), "DE10000002", 92.10),
                new BankAccount(new Person("Sveta", "Ivanova", "ivanova@mail.com"), "DE10000003", 1000),
                new BankAccount(new Person("Sam", "Simpson", "simpson@mail.com"), "DE10000004", 81.90)
        );
    }

    @Test
    void getAccountsLessThen_regularCase() {
        List<BankAccount> expectedResult = List.of(
        new BankAccount(new Person("Nick", "White", "whote@mail.com"), "DE10000002", 92.10),
                new BankAccount(new Person("Sam", "Simpson", "simpson@mail.com"), "DE10000004", 81.90)
        );

        List<BankAccount> actualResult = Main.getAccountsLessThen(accounts, 100);

        Assertions.assertIterableEquals(new HashSet<>(expectedResult),new HashSet<>(actualResult));
    }

    @Test
    void getAccountsLessThen_NoAccountsLess_EmptyResult () {

        List<BankAccount> actualResult = Main.getAccountsLessThen(accounts, 50);
/*
        List<BankAccount> expectedResult =Collections.EMPTY_LIST;
        Assertions.assertIterableEquals(expectedResult,actualResult);
*/
        Assertions.assertTrue(actualResult.isEmpty());
    }


    @Test
    void getAccountsLessThen_NullList_EmptyResult () {

        List<BankAccount> actualResult = Main.getAccountsLessThen(null, 50);
        Assertions.assertTrue(actualResult.isEmpty());
    }


    @Test
    void getAllClients_regularCase() {
        List<Person> expectedResult = List.of(
                new Person("Jack", "Vorobey", "vorobey@mail.com"),
                new Person("John", "Smith", "smith@mail.com"),
                new Person("Nick", "White", "whote@mail.com"),
                new Person("Sveta", "Ivanova", "ivanova@mail.com"),
                new Person("Sam", "Simpson", "simpson@mail.com")
        );

        List<Person> actualResult = Main.getAllClients(accounts);
        Assertions.assertIterableEquals(expectedResult,actualResult, "#345: метод getAllClients не сработал");

    }

    @Test
    void getAllClients_NullList_EmptyResult () {

        List<Person> actualResult = Main.getAllClients(null);
        Assertions.assertTrue(actualResult.isEmpty());
    }

    @Test
    void getRichClientsReport() {
        // “Lennon J.;IBAN: DE199988643;lennon@gmail.com”
        List<String> expectedResult = List.of(
                "Vorobey J.;IBAN: DE10000001;vorobey@mail.com",
                "Ivanova S.;IBAN: DE10000003;ivanova@mail.com"
        );

        List<String> actualResult = Main.getRichClientsReport(accounts, 999);
        Assertions.assertIterableEquals(expectedResult,actualResult);

    }
}