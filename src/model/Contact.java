package model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthday;

    public Contact(String phoneNumber, String group, String fullName, String gender, String address, String birthday) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", group='" + group + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
