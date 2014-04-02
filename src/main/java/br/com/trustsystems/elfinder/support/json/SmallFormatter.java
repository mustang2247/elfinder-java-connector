package br.com.trustsystems.elfinder.support.json;

import java.io.PrintWriter;

class SmallFormatter implements JSONPrintFormatter
{
    private final PrintWriter writer;

    public SmallFormatter(PrintWriter writer)
    {
        this.writer = writer;
    }

    public JSONPrintFormatter indent()
    {
        return this;
    }

    public JSONPrintFormatter newline()
    {
        return this;
    }

    public JSONPrintFormatter outdent()
    {
        return this;
    }

    public JSONPrintFormatter print(String value)
    {
        writer.print(value);

        return this;
    }

    public JSONPrintFormatter printQuoted(String value)
    {
        return print(JSONObject.quote(value));
    }

    public JSONPrintFormatter printSymbol(char symbol)
    {
        writer.print(symbol);

        return this;
    }

}
