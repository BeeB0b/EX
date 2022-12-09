import java.util.Stack;


public class Solution {

    public String validate_xml(String xml) {

        if(xml == null || xml.isEmpty()) return "valid";

        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < xml.length()) {
            if(xml.charAt(i) == '<') {
                if(i < xml.length() && xml.charAt(i+1) == '/') {
                    //closing tag
                    i = i+2;
                    StringBuilder end = new StringBuilder("<");
                    while(xml.charAt(i) != '>') {
                        if(xml.charAt(i) == '<') return "parse error";
                        end.append(xml.charAt(i));
                        i++;
                    }
                    if(end.length() == 1) return "parse error";
                    end.append(">");
                    if(stack.peek().equals(end.toString())) {
                        stack.pop();
                    } else {
                        StringBuilder tag = new StringBuilder("</");
                        for(int j=1; j<end.length(); j++) {
                            tag.append(end.charAt(j));
                        }
                        return "encountered closing tag without matching open tag for " + tag.toString();
                    }
                } else {
                    //start tag
                    i++;
                    StringBuilder sb = new StringBuilder("<");
                    while(xml.charAt(i) != '>') {
                        if(xml.charAt(i) == '<') return "parse error";
                        sb.append(xml.charAt(i));
                        i++;
                    }
                    if(sb.length() == 1) return "parse error";
                    sb.append(">");
                    stack.push(sb.toString());
                }
            }
            i++;
        }

        if(!stack.isEmpty()) {
            return "missing closing tag for " + stack.pop();
        }

        return "valid";
    }

}
