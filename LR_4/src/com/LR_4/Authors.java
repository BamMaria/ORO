public class Authors {
    private int authorID;
    private String name;
    private String surname;

    public Authors() {
    }

    public Authors(int authorID, String name, String surname) {
        this.authorID = authorID;
        this.name = name;
        this.surname = surname;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "ID автора: "+authorID+", имя: " + name + ", фамилия: " + surname + " ";
    }
}