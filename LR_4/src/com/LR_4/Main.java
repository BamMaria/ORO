import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DBconnect dBconnect = new DBconnect();

        while (true) {
            System.out.println("1) Вывод полной информации из бд");
            System.out.println("2) Добавление книги");
            System.out.println("3) Удаление книги");
            System.out.println("4) Добавление автора");
            System.out.println("5) Удаление автора");
            System.out.println("0) Выход");
            System.out.println("=============================================================");
            System.out.println("Ваш выбор: ");
            int choice = in.nextInt();
            System.out.println("=============================================================");
            switch (choice) {
                case 1: {
                    List<String> info = dBconnect.getInfo();
                    for (int i = 0; i < info.size(); i++) {
                        System.out.println(info.get(i));
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Введите название книги: ");
                        in.nextLine();
                        String title = in.nextLine();
                        System.out.print("Введите цену книги: ");
                        int price = in.nextInt();
                        System.out.println("=================");
                        System.out.println("Список доступных авторов: ");
                        List<Authors> authors = DBconnect.getAuthors();
                        for (int i = 0; i < authors.size(); i++) {
                            System.out.println(i + ")" + authors.get(i));
                        }
                        System.out.println("=================");
                        System.out.print("Введите ID автора для книги: ");
                        int authorID = in.nextInt();
                        dBconnect.addBook(title, price, authorID);
                        System.out.println("Книга успешно добавлена");
                    } catch (Exception e) {
                        System.out.println("Ошибка " + e.toString());
                    }
                    System.out.println("=============================================================");
                    break;
                }
                case 3: {
                    System.out.println("Список доступных книг: ");
                    List<Books> books = DBconnect.getBooks();
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(i + 1 + ")" + books.get(i));
                    }
                    System.out.println("=================");
                    System.out.print("Введите ID книги для удаления: ");
                    int bookID = in.nextInt();
                    try {
                        DBconnect.deleteBook(bookID);
                        System.out.println("Книга удалена");
                    } catch (Exception e) {
                        System.out.println("Ошибка " + e.toString());
                    }
                    System.out.println("=============================================================");
                    break;
                }
                case 4: {
                    try {
                        System.out.print("Введите имя автора: ");
                        in.nextLine();
                        String name = in.nextLine();
                        System.out.print("Введите фамилию автора: ");
                        String surname = in.nextLine();
                        dBconnect.addAuthor(name, surname);
                        System.out.print("Автор успешно добавлен");
                    } catch (Exception e) {
                        System.out.println("Ошибка " + e.toString());
                    }
                    System.out.println("=============================================================");
                    break;
                }

                case 5: {
                    System.out.println("Список доступных авторов: ");
                    List<Authors> authors = DBconnect.getAuthors();
                    for (int i = 0; i < authors.size(); i++) {
                        System.out.println(i + 1 + ")" + authors.get(i));
                    }
                    System.out.println("=================");
                    System.out.print("Введите ID автора для удаления: ");
                    int authorID = in.nextInt();
                    System.out.println("=================");
                    List<Books> books = DBconnect.getAuthorBook(authorID);
                    if (books.size() != 0) {
                        System.out.println("Список книг этого автора: ");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println(i + 1 + ")" + books.get(i));
                        }
                    } else System.out.println("У автора нет книг");
                    System.out.println("=================");
                    System.out.println("Вы уверены, что хотите удалить этого автора? Все его книги будут удалены. \n1) да; 2) нет");
                    System.out.println("Ваш выбор: ");
                    int choice2 = in.nextInt();
                    switch (choice2) {
                        case 1: {
                            try {
                                DBconnect.deleteAuthor(authorID);
                                System.out.println("Автор и его книги удалены");
                            } catch (Exception e) {
                                System.out.println("Ошибка " + e.toString());
                            }
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    System.out.println("=============================================================");
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    break;
                }
            }
        }
    }
}