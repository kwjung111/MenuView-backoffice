package backoffice.backoffice.cmmn;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class CmmnController {

    protected static Map<String,Object> getRequestedParam(HttpServletRequest request){
        Map<String,Object> hMap = new HashMap<String,Object>();
        Enumeration<String> paramKeys = request.getParameterNames();
        while (paramKeys.hasMoreElements()) {
            String key = paramKeys.nextElement();
            String val = request.getParameter(key);
            hMap.put(key,val);
        }
        return hMap;
    }


}
