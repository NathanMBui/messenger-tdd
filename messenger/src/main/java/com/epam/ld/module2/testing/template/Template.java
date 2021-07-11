package com.epam.ld.module2.testing.template;

/**
 * The type Template.
 */
public class Template {

    private String prefix;
    private String postfix;
    private String template;

    public Template(String prefix, String postfix, String template) {
        this.prefix = prefix;
        this.postfix = postfix;
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }
}
