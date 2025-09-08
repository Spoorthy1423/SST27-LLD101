package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
    protected final Notifier inner;

    protected NotifierDecorator(Notifier inner) {
        this.inner = inner;
    }

    @Override
    public void notify(String text) {
        inner.notify(text);
    }
}

