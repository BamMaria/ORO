import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBconnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/LR_4";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public DBconnect() {
    }

    public List<String> getInfo() {
        ArrayList db = new ArrayList();
        String info = "";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            try {
                Statement statement = connection.createStatement();
                try {
                    String request = "select * from books join authors on books.author = authors.\"authorID\"";
                    ResultSet resultSet = statement.executeQuery(request);
                    while (resultSet.next()) {
                        Books book = new Books();
                        Authors author = new Authors();
                        book.setBookID(resultSet.getInt(1));
                        book.setTitle(resultSet.getString(2));
                        book.setPrice(resultSet.getInt(3));
                        book.setAuthorID(resultSet.getInt(4));

                        author.setAuthorID(resultSet.getInt(5));
                        author.setName(resultSet.getString(6));
                        author.setSurname(resultSet.getString(7));

                        info = book.toString() + " | " + author.toString();
                        db.add(info);

                    }
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var9) {
                            var.addSuppressed(var9);
                        }
                    }
                    throw var;
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var1.addSuppressed(var8);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var12) {
            var12.printStackTrace();
        }
        return db;
    }

    public void addBook(String title, int price, int authorID) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                Statement statement = connection.createStatement();

                try {
                    String request = "INSERT INTO public.books( title, price, author) VALUES (\'" + title + "\'," + price + "," + authorID + ")";
                    statement.executeUpdate(request);
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var9) {
                            var.addSuppressed(var9);
                        }
                    }
                    throw var;
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var1.addSuppressed(var8);
                    }
                }
                throw var1;
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }
    }

    public static void deleteBook(int bookID) {
        String request = "delete from books where \"bookID\"=?";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                PreparedStatement statement = connection.prepareStatement(request);

                try {
                    statement.setInt(1, bookID);
                    statement.executeUpdate();
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var.addSuppressed(var8);
                        }
                    }

                    throw var;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var1.addSuppressed(var7);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static List<Books> getBooks() {
        ArrayList books = new ArrayList();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                Statement statement = connection.createStatement();
                try {
                    String request = "select * from books";
                    ResultSet resultSet = statement.executeQuery(request);

                    while (resultSet.next()) {
                        Books book = new Books();
                        book.setBookID(resultSet.getInt(1));
                        book.setTitle(resultSet.getString(2));
                        book.setPrice(resultSet.getInt(3));
                        book.setAuthorID(resultSet.getInt(4));
                        books.add(book);
                    }
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var.addSuppressed(var8);
                        }
                    }
                    throw var;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var1.addSuppressed(var7);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return books;
    }

    public void addAuthor(String name, String surname) {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            try {
                Statement statement = connection.createStatement();

                try {
                    String request = "INSERT INTO public.authors (name, surname) VALUES( \'" + name + "\',\'" + surname + "\') ";
                    statement.executeUpdate(request);
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var10) {
                            var.addSuppressed(var10);
                        }
                    }

                    throw var;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var1.addSuppressed(var9);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    public static void deleteAuthor(int authorID) {
        String request1 = "delete from authors where \"authorID\"=?";
        String request2 = "delete from books where author=?";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                PreparedStatement statement1 = connection.prepareStatement(request1);

                try {
                    PreparedStatement statement2 = connection.prepareStatement(request2);
                    try {
                        statement2.setInt(1, authorID);
                        statement2.executeUpdate();
                        statement1.setInt(1, authorID);
                        statement1.executeUpdate();
                    } catch (Throwable var) {
                        if (statement2 != null) {
                            try {
                                statement2.close();
                            } catch (Throwable var11) {
                                var.addSuppressed(var11);
                            }
                        }

                        throw var;
                    }

                    if (statement2 != null) {
                        statement2.close();
                    }
                } catch (Throwable var1) {
                    if (statement1 != null) {
                        try {
                            statement1.close();
                        } catch (Throwable var10) {
                            var1.addSuppressed(var10);
                        }
                    }

                    throw var1;
                }

                if (statement1 != null) {
                    statement1.close();
                }
            } catch (Throwable var2) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var2.addSuppressed(var9);
                    }
                }

                throw var2;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static List<Authors> getAuthors() {
        ArrayList authors = new ArrayList();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                Statement statement = connection.createStatement();

                try {
                    String request = "select * from authors";
                    ResultSet resultSet = statement.executeQuery(request);

                    while (resultSet.next()) {
                        Authors author = new Authors();
                        author.setAuthorID(resultSet.getInt(1));
                        author.setName(resultSet.getString(2));
                        author.setSurname(resultSet.getString(3));
                        authors.add(author);
                    }
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var.addSuppressed(var8);
                        }
                    }

                    throw var;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var1.addSuppressed(var7);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return authors;
    }

    public static List<Books> getAuthorBook(int authorID) {
        ArrayList books = new ArrayList();
        String request = "select * from books where author=?";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            try {
                PreparedStatement statement = connection.prepareStatement(request);
                Statement statementST = connection.createStatement();
                try {
                    statement.setInt(1, authorID);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Books book = new Books();
                        book.setBookID(resultSet.getInt(1));
                        book.setTitle(resultSet.getString(2));
                        book.setPrice(resultSet.getInt(3));
                        book.setAuthorID(resultSet.getInt(4));
                        books.add(book);
                    }
                } catch (Throwable var) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var.addSuppressed(var8);
                        }
                    }

                    throw var;
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var1) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var1.addSuppressed(var7);
                    }
                }

                throw var1;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return books;
    }
}