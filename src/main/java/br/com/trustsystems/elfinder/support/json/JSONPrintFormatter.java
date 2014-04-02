package br.com.trustsystems.elfinder.support.json;

interface JSONPrintFormatter
{

    JSONPrintFormatter print(String value);

    JSONPrintFormatter printQuoted(String value);

    JSONPrintFormatter newline();

    JSONPrintFormatter printSymbol(char symbol);

    JSONPrintFormatter indent();

    JSONPrintFormatter outdent();
}
