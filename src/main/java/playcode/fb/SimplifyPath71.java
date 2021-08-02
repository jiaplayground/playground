package playcode.fb;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;
public class SimplifyPath71 {
    public String simplifyPath(String path) {

        String[] dirs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(String dir : dirs  ){
            if(dir.isEmpty()) continue;
            if(".".equals(dir)){
                continue;
            }
            if("..".equals(dir)){
                if(!deque.isEmpty()){
                    deque.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.poll());
        }
        if(sb.length()==0){
             return "/";
        }
        return sb.toString();
    }

    @Test
    void t(){
        SimplifyPath71 s = new SimplifyPath71();
        s.simplifyPath("/a/./b/../../c/");


    }
}
