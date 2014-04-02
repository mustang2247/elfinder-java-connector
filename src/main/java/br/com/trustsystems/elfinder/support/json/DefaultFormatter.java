package br.com.trustsystems.elfinder.support.json;

import java.io.PrintWriter;

class DefaultFormatter implements JSONPrintFormatter
{
    private final PrintWriter writer;

    private final String indentString;

    private int indentLevel;

    enum Position
    {
        MARGIN, INDENTED, CONTENT
    }

    private Position position = Position.MARGIN;

    public DefaultFormatter(PrintWriter writer)
    {
        this(writer, "  ");
    }

    public DefaultFormatter(PrintWriter writer, String indentString)
    {
        this.writer = writer;
        this.indentString = indentString;
    }

    public JSONPrintFormatter indent()
    {
        indentLevel++;

        return this;
    }

    public JSONPrintFormatter newline()
    {
        if (position != Position.MARGIN)
        {
            writer.write("\n");
            position = Position.MARGIN;
        }

        return this;
    }

    public JSONPrintFormatter outdent()
    {
        indentLevel--;

        return this;
    }

    private void addIndentation()
    {
        if (position == Position.MARGIN)
        {
            for (int i = 0; i < indentLevel; i++)
                writer.print(indentString);

            position = Position.INDENTED;
        }
    }

    private void addSep()
    {
        if (position == Position.CONTENT)
        {
            writer.print(" ");
        }
    }

    private void prepareToPrint()
    {
        addIndentation();

        addSep();
    }

    public JSONPrintFormatter print(String value)
    {
        prepareToPrint();

        writer.print(value);

        position = Position.CONTENT;

        return this;
    }

    public JSONPrintFormatter printQuoted(String value)
    {
        return print(JSONObject.quote(value));
    }

    public JSONPrintFormatter printSymbol(char symbol)
    {
        addIndentation();

        if (symbol != ',')
            addSep();

        writer.print(symbol);

        return this;
    }

}
