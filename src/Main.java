/*

Дан список  BankAccount {Person owner, String IBAN, double balance).
Класс Person состоит из {String fName, String lName String email)

Используя stream необходимо получить List всех аккаунтов, баланс которых составляет менее 100.

Используя stream необходимо получить List всех владельцев счетов

Используя stream,  сформировать лист строк вида “Lennon J.;IBAN: DE199988643;lennon@gmail.com”    (т.е. ФИО; счет, email)  для всех клиентов, чей баланс более 100000


 */

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static List<BankAccount> getAccountsLessThen(List<BankAccount> bankAccounts, double limit) {
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }
        return bankAccounts.stream()
                .filter(ba-> ba.getBalance()<limit )
                .toList();
    }

    public static List<Person> getAllClients(List<BankAccount> bankAccounts){
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }
        return bankAccounts.stream()
                .map(BankAccount::getOwner)     // ba->ba.getOwner()
                .toList();
    }

    public static List<String> getRichClientsReport(List<BankAccount> bankAccounts, double limit){
        if (bankAccounts==null || bankAccounts.isEmpty()){
            return Collections.emptyList();
        }

        Function<BankAccount, String> getAccStrinFunction = ba -> {      // Lennon J.;IBAN: DE199988643;lennon@gmail.com
            StringBuilder sb = new StringBuilder();
            Person owner = ba.getOwner();
            sb.append(owner.getlName())
                    .append(' ')
                    .append(owner.getfName().charAt(0))
                    .append(".;IBAN: ")
                    .append(ba.getIBAN())
                    .append(';')
                    .append(owner.getEmail());
            return sb.toString();
        };
        return bankAccounts.stream()
                .filter(ba->ba!=null)
                .filter(ba->ba.getBalance()>limit)
                .map(getAccStrinFunction)
                .toList();
    }



}