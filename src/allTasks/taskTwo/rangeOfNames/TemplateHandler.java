package allTasks.taskTwo.rangeOfNames;

import allTasks.taskTwo.StringWriter;

import java.util.HashMap;
import java.util.Map;

public class TemplateHandler {
    Map<String, StringWriter> map = new HashMap<>();

    public TemplateHandler(){
        map.put("Vyacheslav", new Vyacheslav());
    }

    public StringWriter getMap(String name){
        return map.get(name);
    }

}
