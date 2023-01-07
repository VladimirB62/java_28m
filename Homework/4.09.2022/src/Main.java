/*
Дан список  BankAccount {Peroson person, String IBAN, double balance).
Используя stream необходимо вывести на экран все аккаунты, баланс
которых составляет менее 100.
Дан список  BankAccount {Peroson person, String IBAN, double balance),
Person{String fName, String lName String email)   Используя stream,  сформировать отсортировнный по
lName лист строк вида “Lennon J.;IBAN: DE19************43;lennon@gmail.com”
(т.е. ФИО; замаскированный счет, в котором открыты только первые 2 и последние 2 символа; email)
для всех клиентов, чей баланс более 100000
*/

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List <BankAccount> bankAccounts = List.of(
                new BankAccount(new Person("Иван","Иванов","ivan@mail.ru"),"DE1234 1234 1234 0001",1563.15),
                new BankAccount(new Person("Сергей","Сергеев","sergey@mail.ru"),"DE1234 1234 1234 0001",97.99),
                new BankAccount(new Person("Пётр","Петров","peter@mail.ru"),"DE1234 1234 1234 0001",100000.03),
                new BankAccount(new Person("Олег","Олегов","oleg@mail.ru"),"DE1234 1234 1234 0001",5.13),
                new BankAccount(new Person("Александр","Александров","alex@mail.ru"),"DE1234 1234 1234 0001",158456.00)
        );

        bankAccounts.stream().filter(ba->ba.getBalance()<100).forEach(ba-> System.out.println(ba));

        List<String> list = bankAccounts.stream()
                .filter(ba -> ba.getBalance() > 100000)
                .sorted(Comparator.comparing(ba -> ba.getPerson().getlName()))
                //.sorted((ba1,ba2)->ba1.getPerson().getlName().compareTo(ba2.getPerson().getlName()))
                .map(ba -> String.format("%s IBAN:%s,%s", getFio(ba.getPerson()), maskIban(ba.getIban()), ba.getPerson().getEmail()))
                .collect(Collectors.toList());

        System.out.println("-".repeat(50));
        list.forEach(s -> System.out.println(s));

    }

    private static String maskIban(String iban) {
        int len = iban.length();
        return iban.substring(0,4)+"*".repeat(len-6)+iban.substring(len-2);
    }

    private static String getFio(Person person) {
        return person.getlName() + " " + person.getfName().charAt(0) + ".";
    }


}
