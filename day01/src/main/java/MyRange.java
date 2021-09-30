public class MyRange {
    private String input;

    public MyRange(String input) {
        this.input = input;
    }

    public boolean startWithInclude() {
        return this.input.startsWith("[");
    }


    public int getStart() {
        if(startWithInclude()){
            return this.input.charAt(1) - 48;
        }
        return this.input.charAt(1) - (48 -1);
    }

    public boolean endWithInclude() {
        return this.input.endsWith("]");
    }

    public boolean endWithExclude() {
        return this.input.endsWith(")");
    }


    public int getEnd(){
        int result = Integer.parseInt(this.input.substring(3,4));
        if(endWithExclude()){
            return result -1;
        }
        return result;
    }

    public String getRange() {
        String result = "";
        for(int i = getStart() ; i<=getEnd();i++){
            result += i + ",";
        }
        return result.substring(0,result.length()-1);
    }

    public void validate() {
        if (!input.startsWith("[") || !input.startsWith("(")) {
            throw new InputInvalidException("Input error");
        }
    }
}
