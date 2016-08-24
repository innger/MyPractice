package com.ryl.learn.protobuf;

import com.ryl.learn.protobuf.AddressBookProtos.AddressBook;
import com.ryl.learn.protobuf.AddressBookProtos.Person;

import java.io.*;

/**
 * Created on 16/8/24 上午11:59.
 */
public class AddPerson {

    public static void main(String[] args) throws IOException {
        String file = "/Users/alibaba/protobuf_files/addressbook";
//        addPerson(file);
        System.out.println("Read person from file:"+ file);
        readPerson(file);
    }

    static void readPerson(String file) throws IOException {
        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(file));
        for (Person person : addressBook.getPersonList()) {
            System.out.println("##################"+person);
            System.out.println("Person ID:" + person.getId());
            System.out.println("Name:" + person.getName());
            if (person.hasEmail()) {
                System.out.println("E-mail address:" + person.getEmail());
            }
            for (Person.PhoneNumber phoneNumber : person.getPhoneList()) {
                switch (phoneNumber.getType()) {
                    case MOBILE:
                        System.out.print("Mobile phone #:");
                        break;
                    case HOME:
                        System.out.print("Home phone #:");
                        break;
                    case WORK:
                        System.out.print("Work phone #:");
                        break;
                }
                System.out.println(phoneNumber.getNumber());
            }
        }
    }

    static void addPerson(String file) throws IOException {
        AddressBook.Builder addressBook = AddressBook.newBuilder();
        addressBook.mergeFrom(new FileInputStream(file));

        FileOutputStream output = new FileOutputStream(file);
        addressBook.addPerson(promptForAddress(new BufferedReader(new InputStreamReader(System.in)), System.out));
        addressBook.build().writeTo(output);
        output.close();
    }

    static Person promptForAddress(BufferedReader stdin, PrintStream stdout) throws IOException {
        Person.Builder person = Person.newBuilder();
        stdout.print("Enter person ID:");
        person.setId(Integer.valueOf(stdin.readLine()));

        stdout.print("Enter name:");
        person.setName(stdin.readLine());

        stdout.print("Enter email address (blank for none):");
        String email = stdin.readLine();
        if (email.length() > 0) {
            person.setEmail(email);
        }
        while (true) {
            stdout.print("Enter a phone number (or leave blank to finish):");
            String number = stdin.readLine();
            if (number.length() == 0) {
                break;
            }
            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder().setNumber(number);
            stdout.print("Is this a mobile home or work phone?");
            String type = stdin.readLine();
            if (type.equals("mobile")) {
                phoneNumber.setType(Person.PhoneType.MOBILE);
            } else if (type.equals("home")) {
                phoneNumber.setType(Person.PhoneType.HOME);
            } else if (type.equals("work")) {
                phoneNumber.setType(Person.PhoneType.WORK);
            } else {
                stdout.print("Unknown phone type. Using default.");
            }
            person.addPhone(phoneNumber);
        }
        return person.build();
    }
}
