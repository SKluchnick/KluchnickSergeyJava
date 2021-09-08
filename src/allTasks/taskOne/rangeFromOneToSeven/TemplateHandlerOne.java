package allTasks.taskOne.rangeFromOneToSeven;

import allTasks.taskOne.StringWriter;

import java.util.HashMap;
import java.util.Map;

public class TemplateHandlerOne {

    Map<Integer, StringWriter> map = new HashMap<>();


    public TemplateHandlerOne(){
        map.put(1,new One());
        map.put(2,new Two());
        map.put(3,new Three());
        map.put(4,new Four());
        map.put(5,new Five());
        map.put(6,new Six());
        map.put(7,new Seven());

}

    public StringWriter getMap(int id) {
        return map.get(id);
    }
    }
