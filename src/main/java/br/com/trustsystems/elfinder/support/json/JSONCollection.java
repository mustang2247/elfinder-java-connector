package br.com.trustsystems.elfinder.support.json;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

public abstract class JSONCollection
{

    @Override
    public String toString()
    {
        CharArrayWriter caw = new CharArrayWriter();
        PrintWriter pw = new PrintWriter(caw);

        JSONPrintFormatter formatter = new DefaultFormatter(pw);

        print(formatter);

        pw.close();

        return caw.toString();
    }

    public String toString(boolean small)
    {
        return small ? toSmallString() : toString();
    }

    public String toSmallString()
    {
        CharArrayWriter caw = new CharArrayWriter();
        PrintWriter pw = new PrintWriter(caw);

        print(pw);

        pw.close();

        return caw.toString();
    }

    public void print(PrintWriter writer, boolean small)
    {
        JSONPrintFormatter formatter = small ? new SmallFormatter(writer) : new DefaultFormatter(writer);

        print(formatter);
    }

    public void print(PrintWriter writer)
    {
        print(writer, true);
    }

    abstract void print(JSONPrintFormatter formatter);
}
