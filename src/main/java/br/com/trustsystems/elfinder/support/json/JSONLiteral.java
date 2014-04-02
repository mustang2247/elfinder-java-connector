package br.com.trustsystems.elfinder.support.json;

public class JSONLiteral implements JSONString
{
    private final String text;

    public JSONLiteral(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
    }

    public String toJSONString()
    {
        return text;
    }
}
