package university.Entities;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;

    public Person(String _firstName, String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    public void setFirstName(String _firstName) {
        this.firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        this.lastName = _lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return " Person " + this.firstName + " " + this.lastName + " ";
    }

    @Override
    public boolean equals(Object _o) {
        if (this == _o) return true;
        if (_o == null) return false;
        if (_o instanceof Person) {
            Person test = (Person) _o;
            return this.firstName == test.firstName && this.lastName == test.lastName;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
