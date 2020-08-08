package thinkInJava.zyq14;

public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle,Person employee){
        title = jobTitle;
        person = employee;
        if (person == null){
            person = Person.NULL;
        }
    }
    public Position(String jobTitle){
        title = jobTitle;
        person = Person.NULL;
    }
    public String getTitle() {
        return title;
    }
    public Person getPerson(){
        return person;
    }
    public void setTitle(String newTitle){
        title = newTitle;
    }
    public void setPerson(Person newPerson) {
        person = newPerson;
        if(person == null){
            person = Person.NULL;
        }
    }
    public String toString(){
        return "Position: " + title + " " + person;
    }
}
//因为有Person.NULL所以也就隐式的构建了空的Positive