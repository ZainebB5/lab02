package com.example.junit.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageService {

    private static final List<String> messages = new LinkedList<>();

    {
        for (int i = 0; i < 100; i++) {
            String formattedText = "Message: {" + "\n" +
                    "from" + "sender" + i + "@mail.be" + "\n" +
                    "To: " + "receiver" + i + "@mail.be" + "\n" +
                    "Header: " + "header " + i + "\n" +
                    "Body" + "body " + i + "\n" + "}";
            messages.add(formattedText);
        }
    }

    /*{
        List<String> expected = new ArrayList<>();
        String mock1 = "Message: {" + "\n" +
                "From: " + "F1" + "\n" +
                "To: " + "T1" + "\n" +
                "Header: " + "H1" + "\n" +
                "Body" + "B1" + "\n" + "}";
        expected.add(mock1);

    }*/

    public List<String> getAll(){
       return messages;
    }

    public List<String> getByFrom(String from){

        if (from == null || from.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (!from.contains("@") || !from.contains(".")){
        throw new IllegalArgumentException("must contain @ !");
        }
        List<String> filteredList = messages.stream()
                .filter(m -> m.contains(("From: " + from)))
                .collect(Collectors.toList());
        printAll(filteredList);
        return filteredList;

    }
    public List<String> getByTo(String to){
        if (to == null || to.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (!to.contains("@") || !to.contains(".")){
            throw new IllegalArgumentException("must contain @ !");
        }

        List<String> filteredList = messages.stream()
                .filter(m -> m.contains(("From: " + to)))
                .collect(Collectors.toList());
        printAll(filteredList);
        return filteredList;

    }

    private void printAll(List<String> messages){
        List<String> filteredList = messages.stream()
                        .collect(Collectors.toList());
        for (var m : filteredList) {
            System.out.println(m);
        }
    }
    public void send(String from, String to, String header, String body){
// TODO:
// if(....)
        if (from == null || from.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (!from.contains("@") || !from.contains(".")){
            throw new IllegalArgumentException("must contain @ !");
        }

        if (to == null || to.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (!to.contains("@") || !to.contains(".")){
            throw new IllegalArgumentException("must contain @ !");
        }
        if (header == null || header.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (body == null || body.isEmpty()){
            throw new IllegalArgumentException("sender can't be null !");
        }
        if (body.contains("bad") || header.contains("bad")) {
            throw new IllegalArgumentException(
                    "The message body or header cannot contain bad words");
        }

// throw exception..
        String formattedText = "Message: {" + "\n" +
                "From: " + from + "\n" +
                "To: " + to + "\n" +
                "Header: " + header + "\n" +
                "Body" + body + "\n" + "}";
        messages.add(formattedText);
    }



}
