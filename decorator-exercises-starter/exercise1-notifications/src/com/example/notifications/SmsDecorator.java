package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
    private final String phone;

    public SmsDecorator(Notifier inner, String phone) {
        super(inner);
        this.phone = phone;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[SMS -> " + phone + "]: " + text);
    }
}

